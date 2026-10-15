package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.VengefulPumpkinEntity;
import net.mcreator.monstrousworld.entity.EnemyPlaceholderEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VengefulPumpkinLeavesStructureProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.isClientSide()) {
			if (entity instanceof VengefulPumpkinEntity) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
					if (!(!world.getEntitiesOfClass(EnemyPlaceholderEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(4 / 2d), e -> true).isEmpty())) {
						if (Math.random() >= 0.95) {
							world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MonstrousWorldModBlocks.PUMPKIN_TRAP.get().defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}