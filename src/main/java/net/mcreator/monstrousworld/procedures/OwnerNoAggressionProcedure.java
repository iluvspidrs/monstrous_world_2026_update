package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OwnerNoAggressionProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity TargetedEntity = null;
		TargetedEntity = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity) {
				if (TargetedEntity != null) {
					if (TargetedEntity instanceof ServerPlayer) {
						if ((entity.getPersistentData().getString("Owner")).equals(TargetedEntity.getDisplayName().getString())) {
							if (entity instanceof Mob) {
								try {
									((Mob) entity).setTarget(null);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							if (!(entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttribute(Attributes.FOLLOW_RANGE).hasModifier(ResourceLocation.parse("monstrous_world:ignore")))) {
								if (entity instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:ignore"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
									if (!_entity.getAttribute(Attributes.FOLLOW_RANGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(modifier);
									}
								}
							}
						} else {
							if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttribute(Attributes.FOLLOW_RANGE).hasModifier(ResourceLocation.parse("monstrous_world:ignore"))) {
								if (entity instanceof LivingEntity _entity) {
									_entity.getAttribute(Attributes.FOLLOW_RANGE).removeModifier(ResourceLocation.parse("monstrous_world:ignore"));
								}
							}
						}
					}
				}
			}
		}
	}
}