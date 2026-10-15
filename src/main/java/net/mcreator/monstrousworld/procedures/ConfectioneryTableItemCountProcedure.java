package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ConfectioneryTableItemCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Sugar", 0);
				_blockEntity.getPersistentData().putDouble("Hint of Insanity", 0);
				_blockEntity.getPersistentData().putDouble("Acid Bottle", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Sugar 0",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Sugar 1",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Sugar 2",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Sugar",
						(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar 0") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar 2")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Hint of Insanity 0",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Hint of Insanity 1",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Hint of Insanity 2",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Hint of Insanity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity 0") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity 1")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity 2")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_ACID
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Acid Bottle 0",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_ACID
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Acid Bottle 1",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_ACID
				.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Acid Bottle 2",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Acid Bottle",
						(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Acid Bottle 0") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Acid Bottle 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Acid Bottle 2")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY
				.get()) {
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Human")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Villager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Illager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Vampire")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu91 ? _menu91.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Werewolf")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Goblin")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Swampmonster")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Troll")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Magic User")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu113 ? _menu113.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Human")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Villager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Illager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Vampire")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu138 ? _menu138.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Werewolf")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu140 ? _menu140.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Goblin")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Swampmonster")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu153 ? _menu153.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Troll")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Magic User")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu163 ? _menu163.getSlots().get(2).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu165 ? _menu165.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Human")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Villager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Illager")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Vampire")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Werewolf")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu187 ? _menu187.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu190 ? _menu190.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Goblin")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Swampmonster")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu197 ? _menu197.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Troll")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu205 ? _menu205.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")).equals("Magic User")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 0",
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu207 ? _menu207.getSlots().get(2).getItem() : ItemStack.EMPTY).getCount()));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Human 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Human 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Human 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Villager 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Villager 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Villager 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Illager 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Illager 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Illager 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Goblin 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Goblin 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Goblin 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Troll 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Troll 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Troll 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Swampmonster 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Swampmonster 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Swampmonster 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Magical 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Magical 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Magical 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Werewolf 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Werewolf 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Werewolf 2")));
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Vampire 0")
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Vampire 1") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Vampire 2")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}