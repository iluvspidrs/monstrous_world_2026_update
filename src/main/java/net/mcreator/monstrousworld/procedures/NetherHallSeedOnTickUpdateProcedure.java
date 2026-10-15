package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.DemonSpawnerEntity;

public class NetherHallSeedOnTickUpdateProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z) {

		//do this on server only

        if (world.isClientSide()) {
            return;
        }

		//checking for Nightmare Mode, or nothing happens

        if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World != 1) {
            return;
        }

		//set the seedPos varible to the Seed's location

        BlockPos seedPos = BlockPos.containing(x, y, z);


        AABB searchArea = new AABB(seedPos).inflate(100);

        boolean locationBlocked = !world.getEntities(
                (Entity) null,
                searchArea,
                nearby -> {

                    double distanceSq =
                            nearby.distanceToSqr(seedPos.getX() + 0.5, seedPos.getY() + 0.5, seedPos.getZ() + 0.5);


                    if (nearby instanceof ServerPlayer) {
                        return distanceSq <= 45 * 45;
                    }


                    if (nearby instanceof DemonSpawnerEntity) {
                        return distanceSq <= 60 * 60;
                    }


                    if (nearby instanceof Blaze || nearby instanceof PiglinBrute || nearby instanceof WitherSkeleton) {
                        	return distanceSq <= 100 * 100;
                    }

                    return false;
                }  ).isEmpty();


        if (locationBlocked) {
            return;
        }


        if (!(world instanceof ServerLevel serverLevel)) {
            return;
        }


		//placing the feature on the block update

		StructureTemplate template = serverLevel.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("monstrous_world", "demonv_hall"));

        if (template == null) {
            return;
        }


        BlockPos structurePos = seedPos.offset(-17, 0, -12);


        template.placeInWorld(
                serverLevel,
                structurePos,
                structurePos,
                new StructurePlaceSettings()
                        .setRotation(Rotation.NONE)
                        .setMirror(Mirror.NONE)
                        .setIgnoreEntities(false),
                serverLevel.random,
                3
        );


		//put Netherrack where the seed was

        world.setBlock(seedPos, Blocks.NETHERRACK.defaultBlockState(), 3);

		//foundation
		
        createBlackstoneFoundation(world, seedPos);
    	}

    private static void createBlackstoneFoundation(LevelAccessor world, BlockPos center) {

        final int horizontalRadius = 20;
        final int verticalRadius = 8;

        final double horizontalRadiusSq =
                horizontalRadius * horizontalRadius;

        final double verticalRadiusSq =
                verticalRadius * verticalRadius;


        // below structure 
        
        for (int dy = -verticalRadius + 1; dy <= 0; dy++) {

            double verticalPart = (dy * dy) / verticalRadiusSq;


            for (int dx = -horizontalRadius; 
            		dx <= horizontalRadius;
                    dx++) {

                double xPart = (dx * dx) / horizontalRadiusSq;

                
                if (xPart + verticalPart > 1.0) {
                    continue;
                }


                for (int dz = -horizontalRadius;
                        dz <= horizontalRadius;
                        dz++) {

                    double distance =
                            xPart
                            + verticalPart
                            + (dz * dz) / horizontalRadiusSq;


                    if (distance > 1.0) {
                        continue;
                    }


                    BlockPos targetPos =
                            center.offset(
                                    dx,
                                    dy - 1,
                                    dz
                            );


                    world.setBlock(
                            targetPos,
                            Blocks.BLACKSTONE.defaultBlockState(),
                            2
                    );
                }
            }
        }
    }
}
