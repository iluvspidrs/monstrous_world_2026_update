package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class UnholyDamageOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 7) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
			}
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:takes_holy_damage")))) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
			}
		}
	}
}