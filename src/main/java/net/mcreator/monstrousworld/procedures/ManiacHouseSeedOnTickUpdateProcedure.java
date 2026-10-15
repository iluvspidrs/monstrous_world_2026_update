package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.MonsterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.HunterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.EvilTreePassiveEntity;
import net.mcreator.monstrousworld.entity.EvilTreeHostileEntity;

public class ManiacHouseSeedOnTickUpdateProcedure {

	public static void execute(LevelAccessor world, double x, double y, double z) {


		//server-side check
		
		if (world.isClientSide()) {
			return;
		}

		//only generate the Maniac House if Nightmare Mode has activated. Excludes this structure if not 1

		if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World != 1) {
			return;
		}

		//set the pos variable 

		BlockPos pos = BlockPos.containing(x, y, z);

		//exclude underwater locations 

		if (world.getBlockState(pos.above()).is(Blocks.WATER)) {
			return;
		}

		//set the largeArea variable

		AABB largeArea = new AABB(pos).inflate(50);

		boolean blockedByNearbyEntity = !world.getEntities(
			(Entity) null, largeArea, 
			entity ->
				entity instanceof ServerPlayer
				|| entity instanceof Villager
				|| entity instanceof MonsterVillageMarkerEntity
				|| entity instanceof HunterVillageMarkerEntity

				).isEmpty();
				

				if (blockedByNearbyEntity) {
					return;
				}

			// set the smallArea variable

			AABB smallArea = new AABB(pos).inflate(25);

			boolean blockedByTree = !world.getEntities(
				(Entity) null, smallArea,
				entity ->
					entity instanceof EvilTreeHostileEntity
					|| entity instanceof EvilTreePassiveEntity
			).isEmpty();
			

			if (blockedByTree) {
				return;
			}
				
			//places the Maniac House

			if (world instanceof ServerLevel serverLevel) {

				StructureTemplate template = 
					serverLevel.getStructureManager().getOrCreate(
						ResourceLocation.fromNamespaceAndPath("monstrous_world", "maniac_house"));

					if (template != null) {

						BlockPos structurePos = 
							pos.offset(-8, -4, -10);

						template.placeInWorld(
							serverLevel, structurePos, structurePos,
							new StructurePlaceSettings()
								.setRotation(Rotation.NONE)
								.setMirror(Mirror.NONE)
								.setIgnoreEntities(false),
							serverLevel.random,
							3
						);	
						
					}
			}

			// end places Maniac House

			//start replace block section

			world.setBlock(pos, Blocks.GRASS_BLOCK.defaultBlockState(), 3);

			
	}
}