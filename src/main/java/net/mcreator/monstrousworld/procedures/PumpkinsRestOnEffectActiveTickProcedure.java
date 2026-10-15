package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.VengefulPumpkinEntity;

import java.util.Comparator;

public class PumpkinsRestOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.isClientSide()) {
			sx = Mth.nextInt(RandomSource.create(), -6, 6);
			for (int _i1 = 0; _i1 < 6; _i1++) {
				sy = Mth.nextInt(RandomSource.create(), -6, 6);
				for (int _i2 = 0; _i2 < 6; _i2++) {
					sz = Mth.nextInt(RandomSource.create(), -6, 6);
					for (int _i3 = 0; _i3 < 6; _i3++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == MonstrousWorldModBlocks.PUMPKIN_TRAP.get()) {
							{
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = Blocks.PUMPKIN.defaultBlockState();
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
						sz = sz + 1;
					}
					sy = sz + 1;
				}
				sx = sx + 1;
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof VengefulPumpkinEntity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
						world.setBlock(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Blocks.CARVED_PUMPKIN.defaultBlockState(), 3);
					}
				}
			}
		}
	}
}