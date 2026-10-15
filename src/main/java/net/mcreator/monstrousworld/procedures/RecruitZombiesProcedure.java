package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RecruitZombiesProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4 && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BRAIN.get()) {
				if (entity instanceof Zombie || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombie") || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombified")) {
					if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
						entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 40, 3, 3, 3, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("/data merge entity @e[type=placeholder,limit=1,sort=nearest] {PersistenceRequired:1b}".replace("placeholder", BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You make a friend! Click this zombie to make them stay or follow"), false);
						if (sourceentity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:everybody_needs_friends"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.BRAIN.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
					}
				}
			}
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BRAIN.get())) {
					if (entity instanceof Zombie || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombie") || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombified")) {
						if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
							if (!(entity.getPersistentData().getBoolean("Follow") == true)) {
								MonstrousWorldMod.queueServerWork(1, () -> {
									entity.getPersistentData().putBoolean("Follow", true);
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This zombie will now follow"), true);
									if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:zombie_stay"))) {
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:zombie_stay"));
										}
									}
								});
							}
							if (entity.getPersistentData().getBoolean("Follow") == true) {
								MonstrousWorldMod.queueServerWork(1, () -> {
									entity.getPersistentData().putBoolean("Follow", false);
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This zombie will now wander"), true);
									if (entity instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:zombie_stay"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
										if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
										}
									}
								});
							}
						}
					}
				}
			}
		}
	}
}