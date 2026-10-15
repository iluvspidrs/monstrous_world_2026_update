package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.OrePlaceholderEntity;
import net.mcreator.monstrousworld.entity.AutumnPlaceholderEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlaceholderDespawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof AutumnPlaceholderEntity) {
				MonstrousWorldMod.queueServerWork(60, () -> {
					if (world.getBlockState(BlockPos.containing(x, entity.getY() - 1, z)).isFaceSturdy(world, BlockPos.containing(x, entity.getY() - 1, z), Direction.UP)) {
						if (!world.getBlockState(BlockPos.containing(x, entity.getY(), z)).isFaceSturdy(world, BlockPos.containing(x, entity.getY(), z), Direction.UP)) {
							if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
								world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("neoforge:autumn_magic")))
										.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value()).defaultBlockState(), 3);
								if (!entity.level().isClientSide())
									entity.discard();
							} else {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						} else {
							if (!entity.level().isClientSide())
								entity.discard();
						}
					} else {
						if (!entity.level().isClientSide())
							entity.discard();
					}
				});
			}
			if (entity instanceof OrePlaceholderEntity) {
				MonstrousWorldMod.queueServerWork(60, () -> {
					if (world.getBlockState(BlockPos.containing(x, entity.getY() - 1, z)).isFaceSturdy(world, BlockPos.containing(x, entity.getY() - 1, z), Direction.UP)) {
						if (!world.getBlockState(BlockPos.containing(x, entity.getY(), z)).isFaceSturdy(world, BlockPos.containing(x, entity.getY(), z), Direction.UP)) {
							if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
								world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
										(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("c:ores"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
												.defaultBlockState(),
										3);
								if (!entity.level().isClientSide())
									entity.discard();
							} else {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						} else {
							if (!entity.level().isClientSide())
								entity.discard();
						}
					} else {
						if (!entity.level().isClientSide())
							entity.discard();
					}
				});
			}
		}
	}
}