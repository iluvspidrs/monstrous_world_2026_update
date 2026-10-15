package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RitualMagicallyInfusedPickaxeProcedure {
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
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SORCERER_CHESTPLATE.get()) {
					if ((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
							&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
						if ((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
							if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
									if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip44
											? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getValue(_getip44)
											: -1) >= 9
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip46
													? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getValue(_getip46)
													: -1) <= 11
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip48
													? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getValue(_getip48)
													: -1) >= 9
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip50
													? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getValue(_getip50)
													: -1) <= 11) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip52
												? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getValue(_getip52)
												: -1) >= 9
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip54
														? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getValue(_getip54)
														: -1) <= 11
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip56
														? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getValue(_getip56)
														: -1) >= 9
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip58
														? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getValue(_getip58)
														: -1) <= 11) {
											if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip60
													? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getValue(_getip60)
													: -1) >= 9
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip62
															? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getValue(_getip62)
															: -1) <= 11
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip64
															? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getValue(_getip64)
															: -1) >= 9
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip66
															? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getValue(_getip66)
															: -1) <= 11) {
												if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip68
														? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getValue(_getip68)
														: -1) >= 9
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip70
																? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getValue(_getip70)
																: -1) <= 11
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip72
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getValue(_getip72)
																: -1) >= 9
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip74
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getValue(_getip74)
																: -1) <= 11) {
													if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MASTER_RITUAL_WAND.get()
															&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get())) {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
															MonstrousWorldMod.queueServerWork(3, () -> {
																if (world instanceof Level _level) {
																	if (!_level.isClientSide()) {
																		_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
																	} else {
																		_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
																	}
																}
																if (entity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("Ritual Circle complete!"), true);
																world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.CENTER_GLYPH.get().defaultBlockState(), 3);
																if (!world.isClientSide()) {
																	BlockPos _bp = BlockPos.containing(x, y + 1, z);
																	BlockEntity _blockEntity = world.getBlockEntity(_bp);
																	BlockState _bs = world.getBlockState(_bp);
																	if (_blockEntity != null) {
																		_blockEntity.getPersistentData().putString("Glyph_Type", "Magically Infused Pickaxe");
																	}
																	if (world instanceof Level _level)
																		_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																}
															});
														} else {
															if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
																MonstrousWorldMod.queueServerWork(3, () -> {
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																	if (entity instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("Ritual Circle complete!"), true);
																	world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.CENTER_GLYPH.get().defaultBlockState(), 3);
																	if (!world.isClientSide()) {
																		BlockPos _bp = BlockPos.containing(x, y + 1, z);
																		BlockEntity _blockEntity = world.getBlockEntity(_bp);
																		BlockState _bs = world.getBlockState(_bp);
																		if (_blockEntity != null) {
																			_blockEntity.getPersistentData().putString("Glyph_Type", "Magically Infused Pickaxe");
																		}
																		if (world instanceof Level _level)
																			_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																	}
																});
															} else {
																if (entity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("This baffles you"), false);
															}
														}
													} else {
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("A Master Wand is needed for this ritual"), true);
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Magically Infused Pickaxe")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_PICKAXE) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added 1 Diamond Pickaxe to ritual"), true);
								if (world instanceof ServerLevel)
									((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(1, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added 1 Concentrated Clear Quartz to ritual"), true);
								if (world instanceof ServerLevel)
									((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(2, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added 1 Glowstone Dust to ritual"), true);
								if (world instanceof ServerLevel)
									((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MASTER_RITUAL_WAND.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.DIAMOND_PICKAXE
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel)
										((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MAGICALLY_INFUSED_PICKAXE.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Magically Infused Pickaxe summoned!"), true);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
								} else {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof ServerLevel)
											((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MAGICALLY_INFUSED_PICKAXE.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Magically Infused Pickaxe summoned!"), true);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This baffles you"), false);
									}
								}
							} else {
								world.destroyBlock(BlockPos.containing(x, y, z), false);
								if (world instanceof ServerLevel)
									((ServerLevel) world).sendParticles((ParticleTypes.ASH), x, (y + 1), z, 10, 1, 1, 1, 1);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Ritual failed"), true);
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

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}