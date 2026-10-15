package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
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
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClickOnAdvancedCauldronProcedure {
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
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ADVANCED_CAULDRON.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()) {
								if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
									if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip9 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip9) : -1) == 0) {
										if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
											if (event instanceof ICancellableEvent _cancellable) {
												_cancellable.setCanceled(true);
											}
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
												if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER) {
													{
														BlockPos _bp = BlockPos.containing(x, y + 1, z);
														BlockState _bs = Blocks.AIR.defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
											});
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip21
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip21)
											: -1) == 1) {
										if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(Items.BUCKET);
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
													int _value = 0;
													BlockPos _pos = BlockPos.containing(x, y, z);
													BlockState _bs = world.getBlockState(_pos);
													if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
														world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
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
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
														_level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, x, y, z, 40, 0, (y + 1), 0, 0);
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Add Magickal Catalyst to begin a brew"), true);
												}
											} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0) {
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
												}
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
														_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 1), z, 40, 1, 1, 1, 0.005);
												}
											} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) {
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
														_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 1), z, 40, 1, 1, 1, 0.005);
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
											} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0) {
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
														_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 1), z, 40, 1, 1, 1, 0.005);
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
											} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() == 0) {
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
														ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
														_setstack.setCount(1);
														_itemHandlerModifiable.setStackInSlot(4, _setstack);
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
														_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 1), z, 40, 1, 1, 1, 0.005);
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
											} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
												if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
														ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
														_setstack.setCount(1);
														_itemHandlerModifiable.setStackInSlot(5, _setstack);
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
														_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 1), z, 40, 1, 1, 1, 0.005);
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
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This cauldron is full..."), true);
											}
											MonstrousWorldMod.queueServerWork(1, () -> {
												AdvancedCauldronItemCountProcedure.execute(world, x, y, z);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This cauldron requires heat underneath"), true);
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip112
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip112)
											: -1) == 12) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Obstruction")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip119
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip119)
											: -1) == 17) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Spirit")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIRIT_TRAP_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Paralysis")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip131
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip131)
											: -1) == 16) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Frogify")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("UndeathCure")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip143
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip143)
											: -1) == 14) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Pumpkin")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PUMPKIN_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip150
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip150)
											: -1) == 19) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("WerewolfCure")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Explosion")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.EXPLOSION_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip162
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip162)
											: -1) == 13) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("VampireCure")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Vanishing")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VANISHING_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip174
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip174)
											: -1) == 15) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Midas")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip181
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip181)
											: -1) == 18) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Sinking")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip188
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip188)
											: -1) == 20) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Chickenify")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Bookish")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_book_lovers_gift"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOOKISH_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip201
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip201)
											: -1) == 21) {
										if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Flight")) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x, y, z);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null) {
														_blockEntity.getPersistentData().putString("FinishedPowder", "None");
													}
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FLIGHT_POWDER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												BottleObstructionPowderProcedure.execute(world, x, y, z);
											}
										}
									}
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You must wear a Witchery Robe for this magic to obey you"), true);
							}
						} else {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
								if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()) {
									if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip214
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip214)
												: -1) == 0) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
												if (event instanceof ICancellableEvent _cancellable) {
													_cancellable.setCanceled(true);
												}
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
													if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER) {
														{
															BlockPos _bp = BlockPos.containing(x, y + 1, z);
															BlockState _bs = Blocks.AIR.defaultBlockState();
															BlockState _bso = world.getBlockState(_bp);
															for (Property<?> _propertyOld : _bso.getProperties()) {
																Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
																if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																	try {
																		_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																	} catch (Exception e) {
																	}
															}
															world.setBlock(_bp, _bs, 3);
														}
													}
												});
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip226
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip226)
												: -1) == 1) {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BUCKET) {
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = new ItemStack(Items.BUCKET);
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
														int _value = 0;
														BlockPos _pos = BlockPos.containing(x, y, z);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
															world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
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
														if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
															_level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, x, y, z, 40, 1, (y + 1), 1, 0);
													} else {
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Add Magickal Catalyst to begin a brew"), true);
													}
												} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
														if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
													}
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
															_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 40, 1, (y + 1), 1, 0);
													}
												} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
															_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 40, 1, (y + 1), 1, 0);
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
												} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
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
															_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 40, 1, (y + 1), 1, 0);
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
												} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() == 0) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
															ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
															_setstack.setCount(1);
															_itemHandlerModifiable.setStackInSlot(4, _setstack);
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
															_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 40, 1, (y + 1), 1, 0);
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
												} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
													if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get())) {
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
															ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
															_setstack.setCount(1);
															_itemHandlerModifiable.setStackInSlot(5, _setstack);
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
															_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 40, 1, (y + 1), 1, 0);
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
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("This cauldron is full..."), true);
												}
												MonstrousWorldMod.queueServerWork(1, () -> {
													AdvancedCauldronItemCountProcedure.execute(world, x, y, z);
												});
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This cauldron requires heat underneath"), true);
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip317
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip317)
												: -1) == 12) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Obstruction")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip324
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip324)
												: -1) == 17) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Spirit")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIRIT_TRAP_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Paralysis")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip336
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip336)
												: -1) == 16) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Frogify")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("UndeathCure")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip348
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip348)
												: -1) == 14) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Pumpkin")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PUMPKIN_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip355
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip355)
												: -1) == 19) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("WerewolfCure")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Explosion")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.EXPLOSION_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip367
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip367)
												: -1) == 13) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("VampireCure")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Vanishing")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.VANISHING_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip379
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip379)
												: -1) == 15) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Midas")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip386
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip386)
												: -1) == 18) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Sinking")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip393
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip393)
												: -1) == 20) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Chickenify")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Bookish")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_book_lovers_gift"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOOKISH_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip406
												? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip406)
												: -1) == 21) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "FinishedPowder")).equals("Flight")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_POWDER_BOTTLE.get()) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null) {
															_blockEntity.getPersistentData().putString("FinishedPowder", "None");
														}
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (entity instanceof Player _player) {
														ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FLIGHT_POWDER.get()).copy();
														_setstack.setCount(1);
														ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
													}
													BottleObstructionPowderProcedure.execute(world, x, y, z);
												}
											}
										}
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You must wear a Witchery Robe for this magic to obey you"), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This baffles you"), false);
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You are not yet skilled enough to use this"), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You must be a Witch or Warlock to use this"), true);
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