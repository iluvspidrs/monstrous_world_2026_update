package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SilverBoltVanishingProjectileEntity;
import net.mcreator.monstrousworld.entity.SilverBoltSinkingProjectileEntity;
import net.mcreator.monstrousworld.entity.SilverBoltProjectileEntity;
import net.mcreator.monstrousworld.entity.SilverBoltParalysisProjectileEntity;
import net.mcreator.monstrousworld.entity.SilverBoltBlindingProjectileEntity;

public class FeralMountainTrollEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(sourceentity instanceof SilverBoltParalysisProjectileEntity)) {
				if (!(sourceentity instanceof SilverBoltBlindingProjectileEntity)) {
					if (!(sourceentity instanceof SilverBoltSinkingProjectileEntity)) {
						if (!(sourceentity instanceof SilverBoltVanishingProjectileEntity)) {
							if (!(sourceentity instanceof SilverBoltProjectileEntity)) {
								if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHAINSAW_WEAPON.get())) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 5, false, false));
								}
							}
						}
					}
				}
			}
		}
	}
}