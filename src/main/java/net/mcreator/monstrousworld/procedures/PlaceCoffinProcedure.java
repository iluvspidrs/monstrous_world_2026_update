package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlaceCoffinProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.COFFIN.get()) {
			if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP) {
				if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP)) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
						if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack12 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack12.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack12);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
								world.setBlock(BlockPos.containing(x, y + 2, z), MonstrousWorldModBlocks.COFFIN_TOP.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.COFFIN_BOTTOM.get().defaultBlockState(), 3);
								{
									Direction _dir = Direction.SOUTH;
									BlockPos _pos = BlockPos.containing(x, y + 1, z);
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
								{
									Direction _dir = Direction.SOUTH;
									BlockPos _pos = BlockPos.containing(x, y + 2, z);
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
							} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
								world.setBlock(BlockPos.containing(x, y + 2, z), MonstrousWorldModBlocks.COFFIN_TOP.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.COFFIN_BOTTOM.get().defaultBlockState(), 3);
								{
									Direction _dir = Direction.EAST;
									BlockPos _pos = BlockPos.containing(x, y + 1, z);
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
								{
									Direction _dir = Direction.EAST;
									BlockPos _pos = BlockPos.containing(x, y + 2, z);
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
							} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.COFFIN_BOTTOM.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x, y + 2, z), MonstrousWorldModBlocks.COFFIN_TOP.get().defaultBlockState(), 3);
								{
									Direction _dir = Direction.NORTH;
									BlockPos _pos = BlockPos.containing(x, y + 1, z);
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
								{
									Direction _dir = Direction.NORTH;
									BlockPos _pos = BlockPos.containing(x, y + 2, z);
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
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.COFFIN_BOTTOM.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x, y + 2, z), MonstrousWorldModBlocks.COFFIN_TOP.get().defaultBlockState(), 3);
								{
									Direction _dir = Direction.WEST;
									BlockPos _pos = BlockPos.containing(x, y + 1, z);
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
								{
									Direction _dir = Direction.WEST;
									BlockPos _pos = BlockPos.containing(x, y + 2, z);
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