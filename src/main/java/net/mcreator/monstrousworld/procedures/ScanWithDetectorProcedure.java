package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.VengefulPumpkinEntity;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;
import net.mcreator.monstrousworld.entity.InfectedGoonEntity;
import net.mcreator.monstrousworld.entity.GiantFlyEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ScanWithDetectorProcedure {
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
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get() && !sourceentity.isShiftKeyDown()) {
				if (!(entity instanceof ServerPlayer)) {
					if (entity.getType().is(EntityTypeTags.UNDEAD)) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Undead creature detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("witch") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("warlock")
							|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("mage") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("wizard")
							|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("sorcerer") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("sorceress")) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Magic user detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Vampire and magic user detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					} else if (entity instanceof Evoker || entity instanceof Illusioner) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Magic user detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Vampire and magic user detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					} else if (entity instanceof Animal || entity instanceof Villager || entity instanceof WanderingTrader || entity instanceof Pillager) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("werewolf")) {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7aOrdinary creature. No action advised."), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							} else {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A74Werewolf detected!"), true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Vampire detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("troll")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Troll detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity instanceof SocietyGoonEntity || entity instanceof InfectedGoonEntity) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aOrdinary creature. No action advised."), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74Vampire detected!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					} else if (entity instanceof MadScientistNPCEntity) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Mad scientist detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("goblin") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("redcap")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Goblin detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("swampmonster")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Swamp monster detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("demon")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Demonic entity detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("maniac")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Slasher detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("vampire") || entity.getPersistentData().getBoolean("vampire") == true) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Vampire detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("werewolf")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Lycanthropy detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("evil_clown")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Evil clown detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity instanceof VengefulPumpkinEntity) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Vengeful Pumpkin detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("golem")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7eGolem creature detected. Discouraged but no action advised."), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getType().is(EntityTypeTags.ARTHROPOD) || entity instanceof GiantFlyEntity) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7eGiant anthropod detected. Take no action and avoid."), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:robots")))) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Unauthorized Robot detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:mutants")))) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Mutant detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				} else if (entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Undead creature detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Vampire detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Lycanthropy detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 1 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType <= 3) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Mutation detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Goblin detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Mad scientist detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Troll detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Swamp monster detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Demonic entity detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Slasher detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Magic user detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Unusual concentration of dark force detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Evil clown detected!"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7aOrdinary human. No action advised."), true);
					}
				}
			}
		}
	}
}