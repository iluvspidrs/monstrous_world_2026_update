package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.world.inventory.SerpentMutantAssignmentMenu;
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.world.inventory.FlyMutantAssignmentMenu;
import net.mcreator.monstrousworld.world.inventory.EyeMutantAssignmentMenu;

import java.util.Comparator;

public class FeralVampireNoAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double XPos = 0;
		double YPos = 0;
		double ZPos = 0;
		Entity NearestPlayer = null;
		Entity TargetedEntity = null;
		Entity NearestShadeMarker = null;
		Entity NearestVillager = null;
		Entity NearestHunter = null;
		Entity NearestSocietyPatrol = null;
		Entity NearestHunterPatrol = null;
		Entity NearestWanderingTrader = null;
		Entity NearestSocietyGuard = null;
		Entity NearestIllager = null;
		Entity NearestWW = null;
		Entity NearestSorcerer = null;
		boolean ShadeFound = false;
		if (!world.isClientSide()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
						if ((entity.getPersistentData().getString("Interaction")).equals(entityiterator.getStringUUID())) {
							if (entityiterator instanceof Player _plr5 && _plr5.containerMenu instanceof TwoTradesMenu || entityiterator instanceof Player _plr6 && _plr6.containerMenu instanceof OneTradeMenu
									|| entityiterator instanceof Player _plr7 && _plr7.containerMenu instanceof EyeMutantAssignmentMenu || entityiterator instanceof Player _plr8 && _plr8.containerMenu instanceof SerpentMutantAssignmentMenu
									|| entityiterator instanceof Player _plr9 && _plr9.containerMenu instanceof FlyMutantAssignmentMenu) {
								entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ())));
								if (entity instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:trade_stop"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
									if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
									}
								}
							} else {
								if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:trade_stop"))) {
									if (entity instanceof LivingEntity _entity) {
										_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:trade_stop"));
									}
								}
							}
						} else {
							if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:trade_stop"))) {
								if (entity instanceof LivingEntity _entity) {
									_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:trade_stop"));
								}
							}
						}
					}
				}
			}
			if (world instanceof Level _lvl20 && _lvl20.isDay()) {
				if (!world.getLevelData().isRaining()) {
					if (world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
						if (!entity.isInWaterOrBubble()) {
							entity.igniteForSeconds(1);
						}
					}
				}
			}
			if (!(!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
				if (Math.random() < 0.001) {
					if (!(entity.getPersistentData().getString("Reserve")).equals("true")) {
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
			}
		}
	}
}