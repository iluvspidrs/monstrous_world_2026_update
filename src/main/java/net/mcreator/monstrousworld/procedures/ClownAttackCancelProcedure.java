package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.EvilClown3Entity;
import net.mcreator.monstrousworld.entity.EvilClown2Entity;
import net.mcreator.monstrousworld.entity.EvilClown1Entity;
import net.mcreator.monstrousworld.entity.DeadlyBalloonEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClownAttackCancelProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof EvilClown1Entity || sourceentity instanceof EvilClown2Entity || sourceentity instanceof EvilClown3Entity || sourceentity instanceof DeadlyBalloonEntity) {
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION)) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}