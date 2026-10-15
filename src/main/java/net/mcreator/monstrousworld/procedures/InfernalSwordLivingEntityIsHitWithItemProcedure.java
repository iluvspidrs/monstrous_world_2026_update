package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class InfernalSwordLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 6);
			if (!entity.fireImmune()) {
				entity.igniteForSeconds(3);
			}
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:takes_holy_damage")))) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8
						&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 7 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType < 4) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.UNHOLY_DAMAGE, 200, 0));
				}
			}
		}
	}
}