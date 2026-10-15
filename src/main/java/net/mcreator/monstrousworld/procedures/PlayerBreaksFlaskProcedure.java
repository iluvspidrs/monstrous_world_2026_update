package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PlayerBreaksFlaskProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.EMPTY_FLASK.get()) {
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) == 1) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof ServerPlayer) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
									if (!(entityiterator.getPersistentData().getBoolean("SplatterImmune") == true)) {
										entityiterator.getPersistentData().putDouble("MutationType", 1);
										entityiterator.getPersistentData().putDouble("StrangeSerum", 300);
										entityiterator.getPersistentData().putDouble("showStrangeSplatter", 300);
									}
								}
							}
						}
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip12 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12) : -1) == 8) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof ServerPlayer) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
									if (!(entityiterator.getPersistentData().getBoolean("SplatterImmune") == true)) {
										entityiterator.getPersistentData().putDouble("MutationType", 2);
										entityiterator.getPersistentData().putDouble("StrangeSerum", 300);
										entityiterator.getPersistentData().putDouble("showStrangeSplatter", 300);
									}
								}
							}
						}
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip20 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip20) : -1) == 9) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof ServerPlayer) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
									if (!(entityiterator.getPersistentData().getBoolean("SplatterImmune") == true)) {
										entityiterator.getPersistentData().putDouble("MutationType", 3);
										entityiterator.getPersistentData().putDouble("StrangeSerum", 300);
										entityiterator.getPersistentData().putDouble("showStrangeSplatter", 300);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}