package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.GoblinVillagerEntity;
import net.mcreator.monstrousworld.entity.GoblinFollowerEntity;
import net.mcreator.monstrousworld.entity.FeralGoblinEntity;

public class IronBoltProjectileProjectileHitsLivingEntityProcedure {

	public static void execute(LevelAccessor world, Entity entity) {

		if (entity == null)
			return;

		//set entities vulnerable to iron

		boolean hurtByIron = 
			entity instanceof GoblinVillagerEntity 
			|| entity instanceof FeralGoblinEntity 
			|| entity instanceof GoblinFollowerEntity;

		//ensures the goblinPlayer variable will exist when the iron bolt hits a player

		boolean goblinPlayer = false;

			if (entity instanceof Player player) {

				var PlayerVariables = 
					player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

				goblinPlayer = 
					PlayerVariables.MonsterClass == 2;
			
			}

		//server side check
		
		if (!world.isClientSide()) {

			//records that the hit entity is impaled by an iron bolt, which controls drops later
			
			entity.getPersistentData().putDouble("IronBolts", (entity.getPersistentData().getDouble("IronBolts") + 1));

			//adds iron poisoning if either condition is true
			
			if (entity instanceof LivingEntity livingEntity && (hurtByIron || goblinPlayer)) {
					livingEntity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
				}


		}
	}
}