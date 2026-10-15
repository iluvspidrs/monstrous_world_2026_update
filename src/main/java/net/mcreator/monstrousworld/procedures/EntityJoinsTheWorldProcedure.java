package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityJoinsTheWorldProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof InfectedGoonEntity) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS, 24000, 0));
				}
			}
			if (entity instanceof IronGolem || entity instanceof FeralMountainTrollEntity || entity instanceof TrollNPCEntity || entity instanceof VampireNPCEntity || entity instanceof GuardRobotEntity
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 200 || entity instanceof DemonNPCEntity || entity instanceof SpiderRobotActiveEntity || entity instanceof FollowerWerewolfEntity
					|| entity instanceof DireWerewolfEntity || entity instanceof FeralWerewolfEntity) {
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
			}
			if (entity instanceof DireWerewolfEntity || entity instanceof FeralWerewolfEntity || entity instanceof FollowerWerewolfEntity) {
				if (!(entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(ResourceLocation.parse("monstrous_world:werewolf_fall_distance")))) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_fall_distance"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity instanceof FollowerWerewolfEntity) {
				if (entity.getPersistentData().getBoolean("Sitting") == true) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:tamed_stay"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
						if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					entity.getPersistentData().putBoolean("Monstrous World Witch", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Witch", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
					entity.getPersistentData().putBoolean("Monstrous World Goblin", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Goblin", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
					entity.getPersistentData().putBoolean("Monstrous World Troll", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Troll", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
					entity.getPersistentData().putBoolean("Monstrous World Sorcerer", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Sorcerer", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
					entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
					entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
					entity.getPersistentData().putBoolean("Monstrous World Werewolf", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Werewolf", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
					entity.getPersistentData().putBoolean("Monstrous World Vampire", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Vampire", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
					entity.getPersistentData().putBoolean("Monstrous World Demon", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Demon", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
					entity.getPersistentData().putBoolean("Monstrous World Evil Clown", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Evil Clown", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
					entity.getPersistentData().putBoolean("Monstrous World Maniac", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Maniac", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
					entity.getPersistentData().putBoolean("Monstrous World Zombie", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Zombie", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
					entity.getPersistentData().putBoolean("Monstrous World Fly", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Fly", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
					entity.getPersistentData().putBoolean("Monstrous World Eye", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Eye", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
					entity.getPersistentData().putBoolean("Monstrous World Serpent", true);
				} else {
					entity.getPersistentData().putBoolean("Monstrous World Serpent", false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Zombify == 1) {
					if (MonstrousWorldConfigConfiguration.ALLOW_LOOMING_UNDEATH_CURSE.get() == false) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.LOOMING_UNDEATH);
					}
				}
				if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0) {
					if (MonstrousWorldConfigConfiguration.START_ON_NIGHTMARE_MODE.get() == true) {
						MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World = 1;
						MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:lamp_entity"))) || entity instanceof EvilTreeHostileEntity || entity instanceof EvilTreePassiveEntity) {
				entity.setCustomName(Component.literal("."));
				if (entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(NeoForgeMod.NAMETAG_DISTANCE))
					_livingEntity63.getAttribute(NeoForgeMod.NAMETAG_DISTANCE).setBaseValue(0);
			}
		}
	}
}