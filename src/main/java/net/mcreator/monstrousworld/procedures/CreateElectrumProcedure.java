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

public class CreateElectrumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double gold_required = 0;
		double silver_required = 0;
		double iron_required = 0;
		double coal_required = 0;
		gold_required = 2;
		silver_required = 2;
		if (getAmountInGUISlot(entity, 4) <= 60) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.ELECTRUM_INGOT.get()).copy();
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
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 0) < gold_required) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					gold_required = gold_required - 1;
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(2);
						_player.containerMenu.broadcastChanges();
					}
					gold_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (getAmountInGUISlot(entity, 0) < silver_required) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					silver_required = silver_required - 1;
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(2);
						_player.containerMenu.broadcastChanges();
					}
					silver_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 1) == 1) {
					if (getAmountInGUISlot(entity, 1) <= gold_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
				} else {
					if (gold_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
					if (gold_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (getAmountInGUISlot(entity, 1) == 1) {
					if (getAmountInGUISlot(entity, 1) <= silver_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
				} else {
					if (silver_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
					if (silver_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 2;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 2) <= gold_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
				} else {
					if (gold_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
					if (gold_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 2) <= silver_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
				} else {
					if (silver_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
					if (silver_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 2;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 3) == 1) {
					if (getAmountInGUISlot(entity, 3) <= gold_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
				} else {
					if (gold_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 1;
					}
					if (gold_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						gold_required = gold_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(3).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (getAmountInGUISlot(entity, 3) == 1) {
					if (getAmountInGUISlot(entity, 3) <= silver_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
				} else {
					if (silver_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 1;
					}
					if (silver_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						silver_required = silver_required - 2;
					}
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