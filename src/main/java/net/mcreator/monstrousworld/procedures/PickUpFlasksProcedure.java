package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PickUpFlasksProcedure {
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
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_SYRINGE.get())) {
				MonstrousWorldMod.queueServerWork(1, () -> {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.EMPTY_FLASK.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip8 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip8) : -1) == 1) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_SERUM_FLASK.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip11 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip11) : -1) == 2) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CURE_SERUM_FLASK.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip14 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip14) : -1) == 3) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STABILIZER_FLASK.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip17 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip17) : -1) == 0) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.EMPTY_FLASK_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip20 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip20) : -1) == 5) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip23 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip23) : -1) == 6) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STABLIZER_FLASK_UNCOOKED.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip26 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip26) : -1) == 7) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CURE_FLASK_UNCOOKED.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip29 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip29) : -1) == 8) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_SERUM_FLASK_2.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip32 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip32) : -1) == 9) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_SERUM_FLASK_3.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip35 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip35) : -1) == 10) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_2.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_3.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					}
				});
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
}