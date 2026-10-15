package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FilledContainerHitsBlockProcedure {


    private static final TagKey<Block> PICKAXE =
            BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"));

    private static final TagKey<Block> SHOVEL =
            BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel"));

    private static final TagKey<Block> AXE =
            BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe"));

    private static final TagKey<Block> SLABS =
            BlockTags.create(ResourceLocation.parse("minecraft:slabs"));

    private static final TagKey<Block> STAIRS =
            BlockTags.create(ResourceLocation.parse("minecraft:stairs"));

    private static final TagKey<Block> WALLS =
            BlockTags.create(ResourceLocation.parse("minecraft:walls"));

    private static final TagKey<Block> LOGS =
            BlockTags.create(ResourceLocation.parse("minecraft:logs"));

    private static final TagKey<Block> LEAVES =
            BlockTags.create(ResourceLocation.parse("minecraft:leaves"));

    private static final TagKey<Block> FENCES =
            BlockTags.create(ResourceLocation.parse("minecraft:fences"));

    private static final TagKey<Block> FENCE_GATES =
            BlockTags.create(ResourceLocation.parse("minecraft:fence_gates"));

    private static final TagKey<Block> SANDS =
            BlockTags.create(ResourceLocation.parse("c:sands"));

    private static final TagKey<Block> GRAVELS =
            BlockTags.create(ResourceLocation.parse("c:gravels"));

    private static final TagKey<Block> SANDSTONE_BLOCKS =
            BlockTags.create(ResourceLocation.parse("c:sandstone/blocks"));

    private static final TagKey<Block> SANDSTONE_STAIRS =
            BlockTags.create(ResourceLocation.parse("c:sandstone/stairs"));

    private static final TagKey<Block> SANDSTONE_SLABS =
            BlockTags.create(ResourceLocation.parse("c:sandstone/slabs"));

    private static final TagKey<Block> IMMUNE =
    		BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune"));


    public static void execute(LevelAccessor world, double x, double y, double z, BlockPos blockpos) {

        if (world.isClientSide()) {
            return;
        }

        BlockPos center = blockpos;

        // Play impact sound once.
        if (world instanceof Level level) {
            level.playSound(
                    null,
                    center,
                    BuiltInRegistries.SOUND_EVENT.get(
                            ResourceLocation.parse("block.glass.break")
                    ),
                    SoundSource.NEUTRAL,
                    1.0F,
                    1.0F
            );
        }


        final int radius = 4;
        final int radiusSq = radius * radius;

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int dy = -radius; dy <= radius; dy++) {

            int dySq = dy * dy;

            for (int dx = -radius; dx <= radius; dx++) {

                int partialSq = dx * dx + dySq;

                // Entire Z column lies outside the sphere.
                if (partialSq > radiusSq) {
                    continue;
                }

                for (int dz = -radius; dz <= radius; dz++) {

                    if (partialSq + dz * dz > radiusSq) {
                        continue;
                    }

                    pos.set(
                            center.getX() + dx,
                            center.getY() + dy,
                            center.getZ() + dz
                    );

                    BlockState oldState = world.getBlockState(pos);

                    Block replacement = getDarkenedReplacement(oldState);

                    if (replacement == null) {
                        continue;
                    }

                    BlockState newState =
                            copyCompatibleProperties(
                                    oldState,
                                    replacement.defaultBlockState()
                            );


                    world.setBlock(pos, newState, 3);
                }
            }
        }
    }



    private static Block getDarkenedReplacement(BlockState state) {

    	if (state.is(IMMUNE)) {
        	return null;
   		}

        Block block = state.getBlock();

        if (block == Blocks.GRASS_BLOCK
                || block == Blocks.DIRT_PATH
                || block == Blocks.MYCELIUM
                || block == Blocks.MOSS_BLOCK
                || block == Blocks.PODZOL) {

            return MonstrousWorldModBlocks.DARKENED_DIRT.get();
        }




        if (state.is(LEAVES)) {
            return MonstrousWorldModBlocks.DARKENED_LEAVES.get();
        }



        if (state.is(SANDSTONE_STAIRS)) {
            return MonstrousWorldModBlocks.DARKENED_SANDSTONE_STAIRS.get();
        }

        if (state.is(SANDSTONE_SLABS)) {
            return MonstrousWorldModBlocks.DARKENED_SANDSTONE_SLAB.get();
        }

        if (block == Blocks.SANDSTONE_WALL
                || block == Blocks.RED_SANDSTONE_WALL) {

            return MonstrousWorldModBlocks.DARKENED_SANDSTONE_WALL.get();
        }

        if (state.is(SANDSTONE_BLOCKS)) {
            return MonstrousWorldModBlocks.DARKENED_SANDSTONE.get();
        }


        if (state.is(AXE)) {

            if (state.is(LOGS)) {
                return MonstrousWorldModBlocks.DARKENED_LOG.get();
            }

            if (state.is(FENCE_GATES)) {
                return MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE_GATE.get();
            }

            if (state.is(STAIRS)) {
                return MonstrousWorldModBlocks.DARKENED_PLANKS_STAIRS.get();
            }

            if (state.is(SLABS)) {
                return MonstrousWorldModBlocks.DARKENED_PLANKS_SLAB.get();
            }

            if (state.is(FENCES)) {
                return MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE.get();
            }

            if (state.canOcclude()) {
                return MonstrousWorldModBlocks.DARKENED_PLANKS.get();
            }

            return null;
        }


        if (state.is(SHOVEL)) {

            if (state.is(SANDS)) {
                return state.canOcclude()
                        ? MonstrousWorldModBlocks.DARKENED_SAND.get()
                        : null;
            }

            if (state.is(GRAVELS)) {
                return state.canOcclude()
                        ? MonstrousWorldModBlocks.DARKENED_GRAVEL.get()
                        : null;
            }


            ResourceLocation key =
                    BuiltInRegistries.BLOCK.getKey(block);

            if (key != null
                    && !key.getPath().contains("snow")
                    && state.canOcclude()) {

                return MonstrousWorldModBlocks.DARKENED_DIRT.get();
            }

            return null;
        }


        if (state.is(PICKAXE)) {

            if (state.is(SLABS)) {
                return MonstrousWorldModBlocks.DARKENED_COBBLESTONE_SLAB.get();
            }

            if (state.is(STAIRS)) {
                return MonstrousWorldModBlocks.DARKENED_COBBLESTONE_STAIRS.get();
            }

            if (state.is(WALLS)) {
                return MonstrousWorldModBlocks.DARKENED_COBBLESTONE_WALL.get();
            }

            if (state.canOcclude()) {
                return MonstrousWorldModBlocks.DARKENED_STONE.get();
            }
        }

        return null;
    }



    private static BlockState copyCompatibleProperties(
            BlockState oldState,
            BlockState newState) {

        for (Property<?> oldProperty : oldState.getProperties()) {

            Property<?> newProperty =
                    newState.getBlock()
                            .getStateDefinition()
                            .getProperty(oldProperty.getName());

            if (newProperty == null) {
                continue;
            }

            newState = copyProperty(
                    oldState,
                    newState,
                    oldProperty,
                    newProperty
            );
        }

        return newState;
    }


    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    private static BlockState copyProperty(
            BlockState oldState,
            BlockState newState,
            Property oldProperty,
            Property newProperty) {

        Comparable value = oldState.getValue(oldProperty);


        if (newProperty.getPossibleValues().contains(value)) {
            return newState.setValue(newProperty, value);
        }

        return newState;
    }
}