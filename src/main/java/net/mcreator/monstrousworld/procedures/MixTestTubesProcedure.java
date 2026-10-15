package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class MixTestTubesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			TestTubeMixerItemCountProcedure.execute(world, x, y, z, entity);
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_FLASK_ITEM
					.get()) {
				if (getAmountInGUISlot(entity, 3) < 64) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.CURE_FLASK_UNCOOKED.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GlowstoneSample") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UndeadTissueSample") >= 1) {
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack14 = new ItemStack(MonstrousWorldModItems.CURE_FLASK_UNCOOKED.get()).copy();
								_setstack14.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack14);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STABLIZER_FLASK_UNCOOKED.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RedstoneSample") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GlowstoneSample") >= 1) {
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack28 = new ItemStack(MonstrousWorldModItems.STABLIZER_FLASK_UNCOOKED.get()).copy();
								_setstack28.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack28);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyDNASample") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DarknessSample") >= 1) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Fly")) {
								{
									int _value = 3;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack43 = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED.get()).copy();
									_setstack43.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack43);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
							if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Fly")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_2.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulWatcherDNASample") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DarknessSample") >= 1) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Dreadful Watcher")) {
								{
									int _value = 3;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack60 = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_2.get()).copy();
									_setstack60.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack60);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
							if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Dreadful Watcher")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_3.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentDNASample") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DarknessSample") >= 1) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Serpent")) {
								{
									int _value = 3;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack77 = new ItemStack(MonstrousWorldModItems.STRANGE_FLASK_UNCOOKED_3.get()).copy();
									_setstack77.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack77);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
							if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "DNA Type")).equals("Serpent")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_SYRINGE
					.get()) {
				if (getAmountInGUISlot(entity, 3) < 64) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_VANISHING.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VanishingPowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack96 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_VANISHING.get()).copy();
								_setstack96.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack96);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_MIDAS_CURSE.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MidasCursePowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack110 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_MIDAS_CURSE.get()).copy();
								_setstack110.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack110);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_PARALYSIS.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ParalyzePowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack124 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_PARALYSIS.get()).copy();
								_setstack124.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack124);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_SINKING.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SinkingPowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack138 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_SINKING.get()).copy();
								_setstack138.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack138);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu142 ? _menu142.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_FROGIFY.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu144 ? _menu144.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FrogifyPowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack152 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_FROGIFY.get()).copy();
								_setstack152.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack152);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SYRINGE_OF_CHICKENIFY.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ChickenifyPowder") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack166 = new ItemStack(MonstrousWorldModItems.SYRINGE_OF_CHICKENIFY.get()).copy();
								_setstack166.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack166);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_FLY.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StrangeSerumFly") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack180 = new ItemStack(MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_FLY.get()).copy();
									_setstack180.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack180);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_EYE.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StrangeSerumEye") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack194 = new ItemStack(MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_EYE.get()).copy();
									_setstack194.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack194);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_SERPENT.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StrangeSerumSerpent") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StabilizingPowder") >= 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack208 = new ItemStack(MonstrousWorldModItems.STABILIZED_STRANGE_SERUM_SERPENT.get()).copy();
									_setstack208.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack208);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(1).remove(1);
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
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

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}