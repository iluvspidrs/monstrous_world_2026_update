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

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlaceLorePapersProcedure {
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
			if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP) {
				if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP)) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMAIL_ARCHIVE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_EMAIL_ARCHIVE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack11 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack11.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MUSEUM_CLOSED.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_MUSEUM_CLOSED.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack19 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack19.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack19);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FARMERS_LOG.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_FARMERS_LOG.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack27 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack27.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack27);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_TORN_JOURNAL.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_A_TORN_JOURNAL.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack35 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack35.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack35);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DROPPED_CURE_SERUM_NOTE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_CURE_SERUM_NOTE_BLOCK.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack43 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack43.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack43);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_NOTE_ON_SPIRITS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_NOTE_ON_SPIRITS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack51 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack51.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack51);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_NOTE_ON_LAB_ACCIDENTS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_NOTE_ON_LAB_ACCIDENTS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack59 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack59.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack59);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_NOTE_ON_STABILIZING_SERUM.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_STABILIZING_SERUM_NOTE_BLOCK.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack67 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack67.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack67);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SOCIETY_DIRECTIVE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_SOCIETY_DIRECTIVE_BLOCK.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack75 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack75.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack75);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FRESH_COOKIES.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_FRESH_COOKIES.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack83 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack83.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack83);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_RECOVERED_JOURNAL.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_RECOVERED_JOURNAL.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack91 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack91.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack91);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LETTER_FROM_AGATHA.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_LETTER_FROM_AGATHA.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack99 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack99.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack99);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LETTER_FROM_COUNTESS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_LETTER_FROM_COUNTESS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack107 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack107.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack107);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EXPLORER_LOG_PART_1.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_EXPLORERS_LOG_1.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack115 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack115.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack115);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EXPLORER_LOG_PART_2.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_EXPLORERS_LOG_2.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack123 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack123.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack123);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AN_UNUSUAL_INFECTION.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_UNUSUAL_INFECTION.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack131 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack131.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack131);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MYSTERY_CONTAINER.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_MYSTERY_CONTAINER.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack139 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack139.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack139);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SOCIETY_PAMPHLET.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_SOCIETY_PAMPHLET.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack147 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack147.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack147);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_GUILD_CURE_SERUM_NOTE_ITEM.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_HUNTERS_GUILD_CURE_SERUM_N_OTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack155 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack155.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack155);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.THE_VILE_RAIDERS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_VILE_RAIDERS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack163 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack163.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack163);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.THE_WARRIORS_ARENA.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_WARRIORS_ARENA.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack171 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack171.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack171);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.QUOTA.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_QUOTA.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack179 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack179.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack179);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SACRIFICE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_SACRIFICE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack187 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack187.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack187);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NOTE_ON_PIGLINS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_NOTE_ON_PIGLINS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack195 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack195.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack195);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NOTE_ON_MANIACS.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_NOTE_ON_MANIACS.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack203 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack203.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack203);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TOME_OF_LIGHT_NOTE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_TOME_OF_LIGHT.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack211 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack211.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack211);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_GOOD_ALPHA_ITEM.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_A_GOOD_ALPHA.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack219 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack219.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack219);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.THE_EYELET_NOTE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_EYELET_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack227 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack227.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack227);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INTERROGATION.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_INTERROGATION_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack235 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack235.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack235);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MURKANUS_MARTH_NOTE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_MURKANUS_MARTH_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack243 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack243.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack243);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SLUG_SOUP_RECIPE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_SLUG_SOUP_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack251 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack251.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack251);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CATERPILLAR_STEW_RECIPE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_CATERPILLAR_STEW_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack259 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack259.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack259);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MURKY_MEDLEY_RECIPE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_MURKY_MEDLEY_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack267 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack267.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack267);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GLOWING_PUMPKIN_TREES_NOTE_ITEM.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_GLOWING_PUMPKIN_SAPLING_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack275 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack275.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack275);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ARCHAEOLOGICAL_NOTE.get()) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DROPPED_ARCHAEOLOGICAL_NOTE.get().defaultBlockState(), 3);
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack283 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack283.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack283);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_WARNING_WEREWOLF.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WEREWOLF.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack295 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack295.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack295);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WEREWOLF.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack305 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack305.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack305);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WEREWOLF.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack315 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack315.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack315);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WEREWOLF.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack323 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack323.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack323);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_WARNING_VAMPIRE.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_VAMPIRE.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack335 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack335.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack335);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_VAMPIRE.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack345 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack345.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack345);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_VAMPIRE.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack355 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack355.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack355);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_VAMPIRE.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack363 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack363.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack363);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WISP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack375 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack375.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack375);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WISP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack385 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack385.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack385);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WISP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack395 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack395.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack395);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_WISP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack403 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack403.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack403);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_WARNING_SWAMP.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_SWAMP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack415 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack415.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack415);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_SWAMP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack425 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack425.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack425);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_SWAMP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack435 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack435.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack435);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_SWAMP.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack443 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack443.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack443);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_WARNING_FERAL_MOUNTAIN_TROLL.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_TROLL.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack455 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack455.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack455);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_TROLL.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack465 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack465.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack465);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_TROLL.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack475 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack475.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack475);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_TROLL.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack483 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack483.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack483);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING_CIRCUS_TENTS_ITEM.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_CIRCUS_TENTS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack495 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack495.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack495);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_CIRCUS_TENTS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack505 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack505.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack505);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_CIRCUS_TENTS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack515 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack515.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack515);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_CIRCUS_TENTS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack523 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack523.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack523);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_GUILD_FLYER_ITEM.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_GUILD_FLYER.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack535 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack535.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack535);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_GUILD_FLYER.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack545 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack545.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack545);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_GUILD_FLYER.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack555 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack555.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack555);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_GUILD_FLYER.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack563 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack563.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack563);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MUSEUM_AD.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_MUSEUM_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack575 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack575.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack575);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_MUSEUM_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack585 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack585.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack585);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_MUSEUM_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack595 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack595.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack595);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_MUSEUM_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack603 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack603.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack603);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_MARKET_AD.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_DARK_MARKET_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack615 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack615.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack615);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_DARK_MARKET_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack625 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack625.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack625);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_DARK_MARKET_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack635 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack635.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack635);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_DARK_MARKET_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack643 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack643.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack643);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TRICK_OR_TREAT_AD.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_TRICK_OR_TREAT_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack655 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack655.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack655);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_TRICK_OR_TREAT_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack665 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack665.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack665);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_TRICK_OR_TREAT_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack675 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack675.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack675);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_TRICK_OR_TREAT_AD.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack683 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack683.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack683);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING_DEMON_ITEM.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_DEMON.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack695 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack695.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack695);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_DEMON.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack705 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack705.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack705);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_DEMON.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack715 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack715.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack715);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_DEMON.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack723 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack723.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack723);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING_MANIAC_ITEM.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_MANIACS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack735 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack735.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack735);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_MANIACS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack745 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack745.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack745);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_MANIACS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack755 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack755.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack755);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_HUNTERS_WARNING_MANIACS.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack763 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack763.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack763);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPION_COTTAGE_WELCOME_ITEM.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
						world.setBlock(BlockPos.containing(x, y, z - 1), MonstrousWorldModBlocks.HANGING_PUMPION_COTTAGE_WELCOME.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack775 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack775.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack775);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
						world.setBlock(BlockPos.containing(x, y, z + 1), MonstrousWorldModBlocks.HANGING_PUMPION_COTTAGE_WELCOME.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack785 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack785.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack785);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.WEST) {
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
						world.setBlock(BlockPos.containing(x - 1, y, z), MonstrousWorldModBlocks.HANGING_PUMPION_COTTAGE_WELCOME.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack795 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack795.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack795);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
						world.setBlock(BlockPos.containing(x + 1, y, z), MonstrousWorldModBlocks.HANGING_PUMPION_COTTAGE_WELCOME.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
						if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack803 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack803.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack803);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
		}
	}
}