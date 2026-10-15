package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class ModifiedIronSwordBlueAgateToolInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.SINKING);
			entity.getPersistentData().putDouble("sinking", 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0));
		}
	}
}