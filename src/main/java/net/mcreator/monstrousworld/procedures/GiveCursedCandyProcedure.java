package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiveCursedCandyProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CANDY.get()) {
				if (entity instanceof Villager || entity instanceof WanderingTrader) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
						if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION))) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:taking_candy_from_strangers"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 2400, 0));
								MonstrousWorldMod.queueServerWork(20, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								});
							});
						}
					}
				}
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:nonhuman_being")))) {
					if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:dark_faction")))) {
						if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MobEffects.CONFUSION)) {
							if (!(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION))) {
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:taking_candy_from_strangers"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 2400, 0));
									MonstrousWorldMod.queueServerWork(20, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									});
								});
							}
						}
					}
				}
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10
							&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 1
							&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 2 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 3) {
						if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						}
						if (sourceentity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:taking_candy_from_strangers"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 2400, 0));
					}
				}
			}
		}
	}
}