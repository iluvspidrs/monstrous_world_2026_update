package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class ChainsawLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), 10);
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:chainsaw_rev")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:chainsaw_rev")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel >= 1) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_LOSS, Mth.nextInt(RandomSource.create(), 600, 1200), 0));
				}
			} else {
				if (entity.getPersistentData().getDouble("BloodLevel") >= 3) {
					entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") - 3));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_LOSS, Mth.nextInt(RandomSource.create(), 600, 1200), 0));
				}
			}
		}
	}
}