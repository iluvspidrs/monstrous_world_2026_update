package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
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
import net.minecraft.tags.ItemTags;
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
public class RitualFactionBooksProcedure {
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
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SORCERER_CHESTPLATE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()
							&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()
							&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()
							&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()
							&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()) {
						if ((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
								&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()
								&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()) {
							if ((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
									&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()
									&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()
										&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 3))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()) {
									if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
											&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get()
											&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
											&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()
											&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 3))).getBlock() == MonstrousWorldModBlocks.DARKENED_CANDLE.get()) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip54
												? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getValue(_getip54)
												: -1) >= 6
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip56
														? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getValue(_getip56)
														: -1) <= 8
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip58
														? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getValue(_getip58)
														: -1) >= 6
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip60
														? (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getValue(_getip60)
														: -1) <= 8) {
											if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip62
													? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getValue(_getip62)
													: -1) >= 6
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip64
															? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z + 1))).getValue(_getip64)
															: -1) <= 8
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip66
															? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getValue(_getip66)
															: -1) >= 6
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip68
															? (world.getBlockState(BlockPos.containing(x - 3, y + 1, z - 1))).getValue(_getip68)
															: -1) <= 8) {
												if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip70
														? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getValue(_getip70)
														: -1) >= 6
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip72
																? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 3))).getValue(_getip72)
																: -1) <= 8
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip74
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getValue(_getip74)
																: -1) >= 6
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))), "blockstate") instanceof IntegerProperty _getip76
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 3))).getValue(_getip76)
																: -1) <= 8) {
													if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip78
															? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getValue(_getip78)
															: -1) >= 6
															&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip80
																	? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 3))).getValue(_getip80)
																	: -1) <= 8
															&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip82
																	? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getValue(_getip82)
																	: -1) >= 6
															&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))), "blockstate") instanceof IntegerProperty _getip84
																	? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 3))).getValue(_getip84)
																	: -1) <= 8) {
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
																			_blockEntity.getPersistentData().putString("Glyph_Type", "Faction Books");
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
																				_blockEntity.getPersistentData().putString("Glyph_Type", "Faction Books");
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
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Faction Books")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOOK) {
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
									_player.displayClientMessage(Component.literal("Added 1 Book to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
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
									_player.displayClientMessage(Component.literal("Added 1 Pure Dark Essence to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:ritual_ingredients")))) {
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
									_player.displayClientMessage(Component.literal("Added 1 Special Ingredient to ritual"), true);
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
							if (!(world instanceof Level _lvl144 && _lvl144.isDay())) {
								if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Cooldown == 0) {
										if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BOOK
												&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
												if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:powders")))) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of Witchery summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_WITCHERY.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_witchery_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_witchery_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_witchery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_witchery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:pumpkin_cookies")))) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of the Goblin summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_GOBLIN.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_goblin_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_goblin_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_goblin_tome", ObjectiveCriteria.DUMMY, Component.literal("created_goblin_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:bronze_axes")))) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of the Troll summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_TROLL.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_troll_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_troll_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_troll_tome", ObjectiveCriteria.DUMMY, Component.literal("created_troll_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.MAGICAL_FABRIC.get().asItem()) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of Sorcery summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_SORCERY.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_sorcery_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_sorcery_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_sorcery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_sorcery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString()).contains("test_tube")) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of Mad Science summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_MAD_SCIENCE.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_mad_scientist_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_mad_scientist_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_mad_scientist_tome", ObjectiveCriteria.DUMMY, Component.literal("created_mad_scientist_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of the Swamp summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_SWAMP.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_swamp_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_swamp_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_swamp_tome", ObjectiveCriteria.DUMMY, Component.literal("created_swamp_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BLOODLETTER.get()) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of Bloodlust summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_BLOODLUST.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_vampire_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_vampire_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_vampire_tome", ObjectiveCriteria.DUMMY, Component.literal("created_vampire_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BRACELET_OF_CONTROL.get()) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of the Moon summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_MOON.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_werewolf_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_werewolf_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_werewolf_tome", ObjectiveCriteria.DUMMY, Component.literal("created_werewolf_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														}
													}
												} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get().asItem()) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Tome of Darkness summoned!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_DARKNESS.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
													if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
														_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Cooldown = 12000;
															_vars.markSyncDirty();
														}
														if (getEntityScore("created_darkness_tome", entity) == 0) {
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("created_darkness_tome");
																if (_so == null)
																	_so = _sc.addObjective("created_darkness_tome", ObjectiveCriteria.DUMMY, Component.literal("created_darkness_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
															}
															if (getEntityScore("Faction Points", entity) == 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
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
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
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
											} else {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
													if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:powders")))) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Witchery summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_WITCHERY.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_witchery_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_witchery_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_witchery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_witchery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:pumpkin_cookies")))) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of the Goblin summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_GOBLIN.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_goblin_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_goblin_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_goblin_tome", ObjectiveCriteria.DUMMY, Component.literal("created_goblin_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BRONZE_AXE.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of the Troll summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_TROLL.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_troll_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_troll_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_troll_tome", ObjectiveCriteria.DUMMY, Component.literal("created_troll_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.MAGICAL_FABRIC.get().asItem()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Sorcery summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_SORCERY.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_sorcery_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_sorcery_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_sorcery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_sorcery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString()).contains("test_tube")) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Mad Science summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_MAD_SCIENCE.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_mad_scientist_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_mad_scientist_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_mad_scientist_tome", ObjectiveCriteria.DUMMY, Component.literal("created_mad_scientist_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of the Swamp summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_SWAMP.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_swamp_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_swamp_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_swamp_tome", ObjectiveCriteria.DUMMY, Component.literal("created_swamp_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BLOODLETTER.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Bloodlust summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_BLOODLUST.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_vampire_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_vampire_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_vampire_tome", ObjectiveCriteria.DUMMY, Component.literal("created_vampire_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BRACELET_OF_CONTROL.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of the Moon summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_MOON.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_werewolf_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_werewolf_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_werewolf_tome", ObjectiveCriteria.DUMMY, Component.literal("created_werewolf_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
															}
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get().asItem()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Darkness summoned!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_reality"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_DARKNESS.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Cooldown = 12000;
																_vars.markSyncDirty();
															}
															if (getEntityScore("created_darkness_tome", entity) == 0) {
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("created_darkness_tome");
																	if (_so == null)
																		_so = _sc.addObjective("created_darkness_tome", ObjectiveCriteria.DUMMY, Component.literal("created_darkness_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
																}
																if (getEntityScore("Faction Points", entity) == 5) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 6;
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
																	if (entity instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_librarian"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																}
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
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("This baffles you"), false);
												}
											}
										}
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("You are too tired to do this ritual again right now"), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This ritual must be under the open sky"), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This ritual can only be done at night"), true);
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}