package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class ButtonPressedGoblinWorkstation2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("OrangeDye", 0);
				_blockEntity.getPersistentData().putDouble("GreenDye", 0);
				_blockEntity.getPersistentData().putDouble("Sugar", 0);
				_blockEntity.getPersistentData().putDouble("Wheat", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Planks", 0);
				_blockEntity.getPersistentData().putDouble("Glass", 0);
				_blockEntity.getPersistentData().putDouble("Spirit Essence", 0);
				_blockEntity.getPersistentData().putDouble("Clear Quartz", 0);
				_blockEntity.getPersistentData().putDouble("Ghostly Log", 0);
				_blockEntity.getPersistentData().putDouble("Purified Moonstone", 0);
				_blockEntity.getPersistentData().putDouble("Dark Essence Dust", 0);
				_blockEntity.getPersistentData().putDouble("Essence of Deception", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		MonstrousWorldMod.queueServerWork(1, () -> {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dyes/orange")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/orange")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/orange")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/orange")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("OrangeDye", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dyes/green")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/green")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/green")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:dyes/green")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GreenDye", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Sugar", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.WHEAT) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Wheat", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.DARKENED_PLANKS
					.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.DARKENED_PLANKS.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.DARKENED_PLANKS.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.DARKENED_PLANKS.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Darkened Planks", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:glass_blocks")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:glass_blocks")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:glass_blocks")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:glass_blocks")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Glass", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Spirit Essence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Clear Quartz", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.GHOSTLY_LOG
					.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.GHOSTLY_LOG.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.GHOSTLY_LOG.get().asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModBlocks.GHOSTLY_LOG.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Ghostly Log", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.PURIFIED_MOONSTONE.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.PURIFIED_MOONSTONE.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.PURIFIED_MOONSTONE.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.PURIFIED_MOONSTONE.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Purified Moonstone", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Essence of Deception", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu113 ? _menu113.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Dark Essence Dust", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getAmountInGUISlot(entity, 8) < 64) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "OrangeDye") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GreenDye") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1
						&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Wheat") >= 1) {
					if (getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 7) == 0) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack135 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE.get()).copy();
								_setstack135.setCount(getAmountInGUISlot(entity, 8) + 1);
								_menu.getSlots().get(8).set(_setstack135);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if (getAmountInGUISlot(entity, 8) < 64) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Glass") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spirit Essence") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Clear Quartz") >= 1
						&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Darkened Planks") >= 1) {
					if (getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 7) == 0) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu149 ? _menu149.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.EMPTY_WISP_LANTERN.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu151 ? _menu151.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack155 = new ItemStack(MonstrousWorldModItems.EMPTY_WISP_LANTERN.get()).copy();
								_setstack155.setCount(getAmountInGUISlot(entity, 8) + 1);
								_menu.getSlots().get(8).set(_setstack155);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if (getAmountInGUISlot(entity, 8) == 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Purified Moonstone") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dark Essence Dust") >= 1
						&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Essence of Deception") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Ghostly Log") >= 1) {
					if (getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 7) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack169 = new ItemStack(MonstrousWorldModItems.DAGGER_OF_TRICKERY.get()).copy();
							_setstack169.setCount(1);
							_menu.getSlots().get(8).set(_setstack169);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_menu.getSlots().get(2).remove(1);
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if (getAmountInGUISlot(entity, 8) == 0) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ESSENCE_OF_ENCHANTMENT.get() && getAmountInGUISlot(entity, 7) >= 1) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu178 ? _menu178.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones")))) {
						if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get())) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:goblin_enchantable")))) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("neoforge:goblin_enchantable_simple")))) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof SwordItem
												|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(6).getItem() : ItemStack.EMPTY)
														.getItem() instanceof AxeItem) {
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_simple_modification"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Weapon Modified");
													if (_so == null)
														_so = _sc.addObjective("Weapon Modified", ObjectiveCriteria.DUMMY, Component.literal("Weapon Modified"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Weapon Modified", entity) + 1);
												}
												if (getEntityScore("Weapon Modified", entity) >= 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 3;
														_vars.markSyncDirty();
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), true);
												}
											}
										}
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu196 ? _menu196.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof ShovelItem) {
											if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(5).getItem() : ItemStack.EMPTY)
													.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones_shovel")))) {
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_simple_modification"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Weapon Modified");
														if (_so == null)
															_so = _sc.addObjective("Weapon Modified", ObjectiveCriteria.DUMMY, Component.literal("Weapon Modified"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Weapon Modified", entity) + 1);
													}
													if (getEntityScore("Weapon Modified", entity) >= 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 3;
															_vars.markSyncDirty();
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), true);
													}
												}
											}
										}
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu206 ? _menu206.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof PickaxeItem) {
											if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu208 ? _menu208.getSlots().get(5).getItem() : ItemStack.EMPTY)
													.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones_pickaxe")))) {
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_simple_modification"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Weapon Modified");
														if (_so == null)
															_so = _sc.addObjective("Weapon Modified", ObjectiveCriteria.DUMMY, Component.literal("Weapon Modified"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Weapon Modified", entity) + 1);
													}
													if (getEntityScore("Weapon Modified", entity) >= 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 3;
															_vars.markSyncDirty();
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), true);
													}
												}
											}
										}
									}
								}
								ModifySwordsProcedure.execute(entity);
								ModifyPickaxesProcedure.execute(entity);
								ModifyAxesProcedure.execute(entity);
								ModifyShovelsProcedure.execute(entity);
								ModifyArmorProcedure.execute(entity);
							}
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu216 ? _menu216.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu219 ? _menu219.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu225 ? _menu225.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu228 ? _menu228.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu231 ? _menu231.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							PurifyPreciousStonesProcedure.execute(entity);
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu237 ? _menu237.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu243 ? _menu243.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu246 ? _menu246.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu249 ? _menu249.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							EnchantToolsProcedure.execute(world, x, y, z, entity);
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu252 ? _menu252.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu255 ? _menu255.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu258 ? _menu258.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu261 ? _menu261.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu264 ? _menu264.getSlots().get(7).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.CULTIVATED_PUMPKIN_ESSENCE.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							CopyEnchantedBooksProcedure.execute(entity);
						}
					}
				}
			}
		});
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}