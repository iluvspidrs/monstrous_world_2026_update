package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;

public class SpiderRobotActiveOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			entity.getPersistentData().putDouble("Health", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) != null) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Mob) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:robot")))) {
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:mutants")))) {
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else if (entity instanceof MadScientistNPCEntity) {
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}