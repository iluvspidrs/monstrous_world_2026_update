package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RecruitHuntersProcedure {
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
		double diamonds = 0;
		diamonds = 0;
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
						if (entity instanceof HunterNPCEntity || entity instanceof HunterPatrolNPCEntity) {
							if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
								for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
									ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
									if (Items.DIAMOND == itemstackiterator.getItem()) {
										diamonds = diamonds + itemstackiterator.getCount();
									}
								}
							}
							if (diamonds >= 3) {
								if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
									entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 40, 1, 1, 1, 1);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Hunter recruited! Click this Hunter to get them to follow or wander"), false);
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.DIAMOND);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
									}
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:hired_help"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putBoolean("Follow", true);
									});
								} else {
									if (!(entity.getPersistentData().getBoolean("Follow") == true)) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Follow", true);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Hunter will now follow"), true);
										});
									}
									if (entity.getPersistentData().getBoolean("Follow") == true) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Follow", false);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Hunter will now patrol"), true);
										});
									}
								}
							} else {
								if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Pay this Hunter 3 Diamonds to recruit..."), true);
								} else {
									if (!(entity.getPersistentData().getBoolean("Follow") == true)) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Follow", true);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Hunter will now follow"), true);
										});
									}
									if (entity.getPersistentData().getBoolean("Follow") == true) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Follow", false);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Hunter will now patrol"), true);
										});
									}
								}
							}
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You are not in the Guild right now"), true);
					}
				}
			}
		}
	}
}