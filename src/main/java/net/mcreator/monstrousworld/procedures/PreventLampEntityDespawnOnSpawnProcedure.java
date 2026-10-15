package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.entity.EvilTreePassiveEntity;
import net.mcreator.monstrousworld.entity.EvilTreeHostileEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PreventLampEntityDespawnOnSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:lamp_entity"))) || entity instanceof EvilTreeHostileEntity || entity instanceof EvilTreePassiveEntity) {
				entity.setCustomName(Component.literal("."));
				if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(NeoForgeMod.NAMETAG_DISTANCE))
					_livingEntity5.getAttribute(NeoForgeMod.NAMETAG_DISTANCE).setBaseValue(0);
			}
		}
	}
}