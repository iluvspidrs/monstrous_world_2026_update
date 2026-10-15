package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CreateBronzeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double copper_required = 0;
		double cassiterite_required = 0;
		double iron_required = 0;
		double coal_required = 0;
		copper_required = 3;
		cassiterite_required = 1;
		if (getAmountInGUISlot(entity, 4) <= 60) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.BRONZE_INGOT.get()).copy();
				_setstack2.setCount(getAmountInGUISlot(entity, 4) + 4);
				_menu.getSlots().get(4).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("lava", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") - 200));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("blaze_lava", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") - 200));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.COPPER_INGOT) {
				if (getAmountInGUISlot(entity, 0) < copper_required) {
					copper_required = copper_required - getAmountInGUISlot(entity, 0);
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(getAmountInGUISlot(entity, 0));
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(3);
						_player.containerMenu.broadcastChanges();
					}
					copper_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/tin")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				cassiterite_required = 0;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.COPPER_INGOT) {
				if (copper_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					copper_required = 0;
				}
				if (copper_required == 2) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 1) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
				if (copper_required == 3) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 2;
					}
					if (getAmountInGUISlot(entity, 1) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 1) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/tin")))) {
				if (cassiterite_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					cassiterite_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.COPPER_INGOT) {
				if (copper_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					copper_required = 0;
				}
				if (copper_required == 2) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 2) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
				if (copper_required == 3) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 2;
					}
					if (getAmountInGUISlot(entity, 2) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 2) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/tin")))) {
				if (cassiterite_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					cassiterite_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_COPPER
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.COPPER_INGOT) {
				if (copper_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(3).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					copper_required = 0;
				}
				if (copper_required == 2) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 3) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
				if (copper_required == 3) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 2;
					}
					if (getAmountInGUISlot(entity, 3) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 1;
					}
					if (getAmountInGUISlot(entity, 3) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						copper_required = 0;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(3).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/tin")))) {
				if (cassiterite_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(3).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					cassiterite_required = 0;
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.FactionLevel = 2;
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
}