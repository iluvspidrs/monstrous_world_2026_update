package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.item.ItemExpireEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BonesPlaceThemselvesProcedure {
	@SubscribeEvent
	public static void onItemExpire(ItemExpireEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		execute(null, world, x, y, z, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (!world.isClientSide()) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP)) {
				if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))
						&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))
						&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
					if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.AWAKENED_SOUL_SAND_BLOCK.get())) {
						if (itemstack.getItem() == Items.BONE) {
							if (Math.random() > 0.5) {
								world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.PLACED_BONE.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.PLACED_BONE_FLIPPED.get().defaultBlockState(), 3);
							}
						}
						if (itemstack.getItem() == Blocks.SKELETON_SKULL.asItem()) {
							if (Math.random() < 0.25) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.NORTH;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else if (Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.SOUTH;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else if (Math.random() < 0.75) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.WEST;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.EAST;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							}
						}
						if (itemstack.getItem() == Blocks.WITHER_SKELETON_SKULL.asItem()) {
							if (Math.random() < 0.25) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.WITHER_SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.NORTH;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else if (Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.WITHER_SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.SOUTH;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else if (Math.random() < 0.75) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.WITHER_SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.WEST;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
									}
								}
							} else {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.WITHER_SKELETON_SKULL.defaultBlockState(), 3);
								{
									Direction _dir = Direction.EAST;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
										world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
									} else {
										_property = _bs.getBlock().getStateDefinition().getProperty("axis");
										if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
											world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
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