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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.SocietySpawnerEntity;
import net.mcreator.monstrousworld.entity.MonsterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.HunterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.EvilTreePassiveEntity;
import net.mcreator.monstrousworld.entity.EvilTreeHostileEntity;

public class ForbiddenArenaSeedOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER)) {
				if (!(!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
					if (!(!world.getEntitiesOfClass(MonsterVillageMarkerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
						if (!(!world.getEntitiesOfClass(HunterVillageMarkerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
							if (!(!world.getEntitiesOfClass(Villager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
								if (!(!world.getEntitiesOfClass(EvilTreePassiveEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(40 / 2d), e -> true).isEmpty())) {
									if (!(!world.getEntitiesOfClass(EvilTreeHostileEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(40 / 2d), e -> true).isEmpty())) {
										if (!(!world.getEntitiesOfClass(SocietySpawnerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											if (world instanceof ServerLevel _serverworld) {
												StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("monstrous_world", "directors_office"));
												if (template != null) {
													template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y - 8, z - 15), BlockPos.containing(x - 8, y - 8, z - 15),
															new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
												}
											}
											{
												BlockPos _bp = BlockPos.containing(x, y, z);
												BlockState _bs = Blocks.COARSE_DIRT.defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}