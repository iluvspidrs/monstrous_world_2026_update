package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CharmOfCleansingItemInInventoryTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_CLEANSING.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
					if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.POISON)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.POISON);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.WITHER)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WITHER);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.HUNGER)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.HUNGER);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MobEffects.BLINDNESS)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.BLINDNESS);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MonstrousWorldModMobEffects.INFESTED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INFESTED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MonstrousWorldModMobEffects.ENCHANTED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(MonstrousWorldModMobEffects.CRAZED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CRAZED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
						entity.getPersistentData().putString("hypnosis", "none");
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MurkanusMarth = 1;
							_vars.markSyncDirty();
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STRANGE_SERUM).getDuration() : 0) >= 1) {
						entity.getPersistentData().putDouble("StrangeSerum", 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Strange Serum is cleared!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.STRANGE_SERUM);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(MonstrousWorldModMobEffects.INSANITY)) {
						entity.getPersistentData().putDouble("insanity_timer", 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your mind clears and stabilizes!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.WerewolfInfectionTimer = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.VampireInfection = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.ZombieInfection = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_CLEANSING.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
					if (entity instanceof LivingEntity _livEnt90 && _livEnt90.hasEffect(MobEffects.POISON)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.POISON);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt94 && _livEnt94.hasEffect(MobEffects.WITHER)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WITHER);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt98 && _livEnt98.hasEffect(MobEffects.HUNGER)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.HUNGER);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt102 && _livEnt102.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt106 && _livEnt106.hasEffect(MobEffects.BLINDNESS)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.BLINDNESS);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt110 && _livEnt110.hasEffect(MonstrousWorldModMobEffects.INFESTED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INFESTED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt114 && _livEnt114.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt118 && _livEnt118.hasEffect(MonstrousWorldModMobEffects.ENCHANTED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt122 && _livEnt122.hasEffect(MonstrousWorldModMobEffects.CRAZED)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CRAZED);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt126 && _livEnt126.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
						entity.getPersistentData().putString("hypnosis", "none");
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt131 && _livEnt131.hasEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt135 && _livEnt135.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt139 && _livEnt139.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MurkanusMarth = 1;
							_vars.markSyncDirty();
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STRANGE_SERUM).getDuration() : 0) >= 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Strange Serum is cleared!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.STRANGE_SERUM);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if (entity instanceof LivingEntity _livEnt149 && _livEnt149.hasEffect(MonstrousWorldModMobEffects.INSANITY)) {
						entity.getPersistentData().putDouble("insanity_timer", 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your mind clears and stabilizes!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.WerewolfInfectionTimer = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.VampireInfection = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.ZombieInfection = 0;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your supernatural infection is cleared!"), true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					}
				}
			}
		}
	}
}