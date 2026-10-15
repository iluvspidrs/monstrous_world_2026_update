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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GeneralZombieEffectsProcedure {
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
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel(2);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.REGENERATION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (entity.isInWaterOrBubble()) {
					entity.setAirSupply(300);
				}
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW))) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !entity.isInWater() && world instanceof Level _lvl12 && _lvl12.isDay() && !world.getLevelData().isRaining()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !entity.isInWater() && world instanceof Level _lvl16 && _lvl16.isDay() && !world.getLevelData().isRaining()) {
									entity.igniteForSeconds(1);
								}
							});
						}
					} else {
						if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !entity.isInWater() && world instanceof Level _lvl22 && _lvl22.isDay() && !world.getLevelData().isRaining()) {
							if (entity.getPersistentData().getDouble("helmetTimer") > 1) {
								entity.getPersistentData().putDouble("helmetTimer", (entity.getPersistentData().getDouble("helmetTimer") - 1));
							}
							if (entity.getPersistentData().getDouble("helmetTimer") == 1) {
								entity.getPersistentData().putDouble("helmetTimer", 500);
								if (world instanceof ServerLevel _level) {
									(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
									});
								}
							}
						}
					}
				}
			}
		}
	}
}