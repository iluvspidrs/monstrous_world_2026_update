package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class PossessedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() >= 0.9996) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, Mth.nextInt(RandomSource.create(), 100, 300), 0));
				MonstrousWorldMod.queueServerWork(1, () -> {
					if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.LEVITATION)) {
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
					}
				});
			}
			if ((double) MonstrousWorldConfigConfiguration.POSSESSION_CHANCE.get() == 0) {
				entity.getPersistentData().putDouble("lev_possessed", 0);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
			}
		}
	}
}