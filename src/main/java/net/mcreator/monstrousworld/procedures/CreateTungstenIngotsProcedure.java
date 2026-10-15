package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CreateTungstenIngotsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double tungsten_required = 0;
		tungsten_required = 4;
		if (getAmountInGUISlot(entity, 4) <= 60) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.TUNGSTEN_INGOT.get()).copy();
				_setstack2.setCount(getAmountInGUISlot(entity, 4) + 4);
				_menu.getSlots().get(4).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
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
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tungsten")))) {
				if (getAmountInGUISlot(entity, 0) == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 3;
				}
				if (getAmountInGUISlot(entity, 0) == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(2);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 2;
				}
				if (getAmountInGUISlot(entity, 0) == 3) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(3);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 1;
				}
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(4);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tungsten")))) {
				if (tungsten_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 0;
				}
				if (tungsten_required == 2) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 1) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 3) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 1) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 1) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 4) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 3;
					}
					if (getAmountInGUISlot(entity, 1) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 1) == 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 1) >= 4) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(4);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tungsten")))) {
				if (tungsten_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 0;
				}
				if (tungsten_required == 2) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 2) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 3) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 2) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 2) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 4) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 3;
					}
					if (getAmountInGUISlot(entity, 2) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 2) == 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 2) >= 4) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(4);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(3).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tungsten")))) {
				if (tungsten_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(3).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					tungsten_required = 0;
				}
				if (tungsten_required == 2) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 3) >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 3) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 3) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 3) >= 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
				if (tungsten_required == 4) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 3;
					}
					if (getAmountInGUISlot(entity, 3) == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 2;
					}
					if (getAmountInGUISlot(entity, 3) == 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(3);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 1;
					}
					if (getAmountInGUISlot(entity, 3) >= 4) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(4);
							_player.containerMenu.broadcastChanges();
						}
						tungsten_required = 0;
					}
				}
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