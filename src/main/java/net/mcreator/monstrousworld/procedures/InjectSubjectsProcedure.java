package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InjectSubjectsProcedure {
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
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
				if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()) {
						if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MonstrousWorldModMobEffects.CURE_SERUM))) {
							if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURE_SERUM, 220, 0));
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack14 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack14.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack14);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
										_vars.markSyncDirty();
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You've cleared the undead virus from the victim. Your reputation improves..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (sourceentity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STABILIZER_SYRINGE.get()) {
						if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:mutants"))) || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1
								|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
							if (!(entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STABILIZING_SERUM, 220, 0));
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack29 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack29.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack29);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:ah_better"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
										_vars.markSyncDirty();
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (sourceentity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_FLY.get()) {
						if (!(entity instanceof MadScientistNPCEntity)) {
							if (!(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack45 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack45.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack45);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								entity.getPersistentData().putDouble("MutationType", 1);
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
										_vars.markSyncDirty();
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
									});
								}
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_EYE.get()) {
						if (!(entity instanceof MadScientistNPCEntity)) {
							if (!(entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack64 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack64.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack64);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								entity.getPersistentData().putDouble("MutationType", 2);
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
										_vars.markSyncDirty();
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
									});
								}
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_SERPENT.get()) {
						if (!(entity instanceof MadScientistNPCEntity)) {
							if (!(entity instanceof LivingEntity _livEnt76 && _livEnt76.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack83 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack83.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack83);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								entity.getPersistentData().putDouble("MutationType", 3);
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
										_vars.markSyncDirty();
									}
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
									});
								}
							}
						}
					}
				}
			}
			if (entity instanceof ServerPlayer || entity instanceof Player) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()) {
					if (!(entity instanceof LivingEntity _livEnt96 && _livEnt96.hasEffect(MonstrousWorldModMobEffects.CURE_SERUM))) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).ZombieInfection >= 1) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.ZombieInfection = 0;
								_vars.markSyncDirty();
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURE_SERUM, 220, 0));
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack103 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack103.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack103);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You've cleared the undead virus from the victim. Your reputation improves..."), true);
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
								});
							}
						}
					}
				}
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STABILIZER_SYRINGE.get()) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2
							|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
						if (!(entity instanceof LivingEntity _livEnt110 && _livEnt110.hasEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STABILIZING_SERUM, 220, 0));
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack117 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack117.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack117);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:ah_better"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (sourceentity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_FLY.get()) {
						if (!(entity instanceof LivingEntity _livEnt125 && _livEnt125.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack132 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack132.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack132);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							entity.getPersistentData().putDouble("MutationType", 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
								});
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_EYE.get()) {
						if (!(entity instanceof LivingEntity _livEnt141 && _livEnt141.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack148 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack148.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack148);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							entity.getPersistentData().putDouble("MutationType", 2);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
								});
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_SERPENT.get()) {
						if (!(entity instanceof LivingEntity _livEnt157 && _livEnt157.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack164 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack164.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack164);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							entity.getPersistentData().putDouble("MutationType", 3);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_will_only_hurt_a_little"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
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