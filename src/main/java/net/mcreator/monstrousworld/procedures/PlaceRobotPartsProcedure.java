package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlaceRobotPartsProcedure {
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
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ROBOT_TABLE_SECTION.get()) {
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) == 1) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_SPIDER_HEAD.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack13 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack13.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						MonstrousWorldMod.queueServerWork(1, () -> {
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GUARD_ROBOT_HEAD.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack39 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack39.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack39);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						MonstrousWorldMod.queueServerWork(1, () -> {
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 7;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 7;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 7;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 7;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip58 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip58) : -1) == 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_SPIDER_BODY.get()) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack67 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack67.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack67);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 5;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 5;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 5;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								{
									Direction _dir = Direction.DOWN;
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 5;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_GUARD_BODY_AND_ARMS.get()) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack93 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack93.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack93);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 8;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 8;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 8;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								{
									Direction _dir = Direction.DOWN;
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 8;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip112 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip112) : -1) == 3) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_SPIDER_LEGS.get()) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack121 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack121.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack121);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 6;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 6;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 6;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 6;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_GUARD_LEGS.get()) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack147 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack147.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack147);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
								{
									int _value = 9;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
								{
									int _value = 9;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
								{
									int _value = 9;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
							if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
								{
									int _value = 9;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
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
							}
						});
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip166 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip166) : -1) == 4) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ROBOT_SPIDER_HEAD.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip186 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip186) : -1) == 5) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ROBOT_SPIDER_BODY.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip206 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip206) : -1) == 6) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ROBOT_SPIDER_LEGS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip226 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip226) : -1) == 7) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.GUARD_ROBOT_HEAD.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip246 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip246) : -1) == 8) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ROBOT_GUARD_BODY_AND_ARMS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
				}
				if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip266 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip266) : -1) == 9) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ROBOT_GUARD_LEGS.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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
					}
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
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

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}