package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class SimpleCauldronOnBlockRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()) {
						if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) == 0) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(Items.WATER_BUCKET);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 1;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								});
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip13 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip13) : -1) == 1) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.BUCKET);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(Items.WATER_BUCKET).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								});
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:cauldron_heating")))) {
								if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() == 0) {
									if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Empty", (getBlockInventorySlotCount(world, BlockPos.containing(x, y, z)) - 1));
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(0, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 10, 0, (y + 1), 0, 0);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Add Magickal Catalyst to begin a brew"), true);
									}
								} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0) {
									if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot(1, _setstack);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 0.9), (z + 0.5), 10, 1, 1, 1, 0.005);
								} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot(2, _setstack);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 0.9), (z + 0.5), 10, 1, 1, 1, 0.005);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot(3, _setstack);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 0.9), (z + 0.5), 10, 1, 1, 1, 0.005);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This cauldron is too small to accept more ingredients"), true);
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									SimpleCauldronItemCountProcedure.execute(world, x, y, z);
								});
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This cauldron requires heat underneath"), true);
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip72 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip72) : -1) == 11) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Obstruction")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("InkSac", 0);
											_blockEntity.getPersistentData().putDouble("GoldenCarrot", 0);
											_blockEntity.getPersistentData().putDouble("WitherRose", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip90 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip90) : -1) == 13) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Spirit")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
											_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
											_blockEntity.getPersistentData().putDouble("Spiritflower", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIRIT_TRAP_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Paralysis")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("FingerGrass", 0);
											_blockEntity.getPersistentData().putDouble("VileLattice", 0);
											_blockEntity.getPersistentData().putDouble("InsanityEssence", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip124 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip124) : -1) == 12) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Frogify")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("LilyPad", 0);
											_blockEntity.getPersistentData().putDouble("Slimeball", 0);
											_blockEntity.getPersistentData().putDouble("Frogspawn", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("UndeathCure")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("UndeathlyEssence", 0);
											_blockEntity.getPersistentData().putDouble("Deathcatcher", 0);
											_blockEntity.getPersistentData().putDouble("SilverDust", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip158 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip158) : -1) == 14) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Sinking")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("IronChain", 0);
											_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
											_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip176 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip176) : -1) == 16) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("WerewolfCure")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("SilverDust", 0);
											_blockEntity.getPersistentData().putDouble("MoonDust", 0);
											_blockEntity.getPersistentData().putDouble("LunarBloom", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip194 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip194) : -1) == 15) {
							if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("VampireCure")) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("SilverDust", 0);
											_blockEntity.getPersistentData().putDouble("BottleOfBlood", 0);
											_blockEntity.getPersistentData().putDouble("VileLattice", 0);
											_blockEntity.getPersistentData().putString("FinishedPowder", "None");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								}
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You must wear a Witchery Robe for this magic to obey you..."), true);
					}
				} else {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()) {
							if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip215 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip215) : -1) == 0) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.WATER_BUCKET);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 1;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									});
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip224 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip224) : -1) == 1) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(Items.BUCKET);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(Items.WATER_BUCKET).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									});
								}
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:cauldron_heating")))) {
									if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() == 0) {
										if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
											if (!world.isClientSide()) {
												BlockPos _bp = BlockPos.containing(x, y, z);
												BlockEntity _blockEntity = world.getBlockEntity(_bp);
												BlockState _bs = world.getBlockState(_bp);
												if (_blockEntity != null) {
													_blockEntity.getPersistentData().putDouble("Empty", (getBlockInventorySlotCount(world, BlockPos.containing(x, y, z)) - 1));
												}
												if (world instanceof Level _level)
													_level.sendBlockUpdated(_bp, _bs, _bs, 3);
											}
										}
										if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()) {
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
												ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack.setCount(1);
												_itemHandlerModifiable.setStackInSlot(0, _setstack);
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 10, 1, (y + 1), 1, 0);
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Add Magickal Catalyst to begin a brew"), true);
										}
									} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0) {
										if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
											if (!world.isClientSide()) {
												BlockPos _bp = BlockPos.containing(x, y, z);
												BlockEntity _blockEntity = world.getBlockEntity(_bp);
												BlockState _bs = world.getBlockState(_bp);
												if (_blockEntity != null) {
													_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
												}
												if (world instanceof Level _level)
													_level.sendBlockUpdated(_bp, _bs, _bs, 3);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(1, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 10, 1, (y + 1), 1, 0);
									} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(2, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 10, 1, (y + 1), 1, 0);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(3, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 10, 1, (y + 1), 1, 0);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Empty", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") - 1));
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This cauldron is too small to accept more ingredients"), true);
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										SimpleCauldronItemCountProcedure.execute(world, x, y, z);
									});
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This cauldron requires heat underneath"), true);
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip283 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip283) : -1) == 11) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Obstruction")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("InkSac", 0);
												_blockEntity.getPersistentData().putDouble("GoldenCarrot", 0);
												_blockEntity.getPersistentData().putDouble("WitherRose", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip301 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip301) : -1) == 13) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Spirit")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
												_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
												_blockEntity.getPersistentData().putDouble("Spiritflower", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIRIT_TRAP_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Paralysis")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("FingerGrass", 0);
												_blockEntity.getPersistentData().putDouble("VileLattice", 0);
												_blockEntity.getPersistentData().putDouble("InsanityEssence", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip335 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip335) : -1) == 12) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Frogify")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("LilyPad", 0);
												_blockEntity.getPersistentData().putDouble("Slimeball", 0);
												_blockEntity.getPersistentData().putDouble("Frogspawn", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("UndeathCure")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("UndeathlyEssence", 0);
												_blockEntity.getPersistentData().putDouble("Deathcatcher", 0);
												_blockEntity.getPersistentData().putDouble("SilverDust", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip369 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip369) : -1) == 14) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Sinking")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("IronChain", 0);
												_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
												_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip387 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip387) : -1) == 16) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("WerewolfCure")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("SilverDust", 0);
												_blockEntity.getPersistentData().putDouble("MoonDust", 0);
												_blockEntity.getPersistentData().putDouble("LunarBloom", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip405 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip405) : -1) == 15) {
								if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("VampireCure")) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("SilverDust", 0);
												_blockEntity.getPersistentData().putDouble("BottleOfBlood", 0);
												_blockEntity.getPersistentData().putDouble("VileLattice", 0);
												_blockEntity.getPersistentData().putString("FinishedPowder", "None");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:bubbling_brew"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								}
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You must wear a Witchery Robe for this magic to obey you..."), true);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Only a Witch or Warlock can use this"), true);
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

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static int getBlockInventorySlotCount(LevelAccessor world, BlockPos pos) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getSlots();
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