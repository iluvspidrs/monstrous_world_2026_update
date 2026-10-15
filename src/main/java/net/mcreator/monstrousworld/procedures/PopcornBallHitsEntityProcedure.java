package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class PopcornBallHitsEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:nonhuman_being")))) {
				if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:dark_faction")))) {
					if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MonstrousWorldModMobEffects.INFESTED))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.INFESTED, 1200, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.azalea_leaves.break")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}