package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class ModifiedIronPickaxeBlueAgateToolInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1));
		}
	}
}