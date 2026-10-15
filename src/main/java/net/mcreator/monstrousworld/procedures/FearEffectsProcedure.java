package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FearEffectsProcedure {
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
		if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.NIGHT_VISION))) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
					if (entity.getPersistentData().getDouble("fear_countdown") == 600) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your fear of the dark makes your neck prickle..."), true);
					}
					if (entity.getPersistentData().getDouble("fear_countdown") == 2400) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your breath quickens as you break into a cold sweat..."), true);
					}
					if (entity.getPersistentData().getDouble("fear_countdown") == 3600) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your heart begins to race faster..."), true);
					}
					if (entity.getPersistentData().getDouble("fear_countdown") == 4800) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Panic grips you as the dark closes in..."), true);
					}
				}
			}
		}
	}
}