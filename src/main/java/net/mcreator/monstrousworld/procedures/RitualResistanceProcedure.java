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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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

import java.util.Comparator;

@EventBusSubscriber
public class RitualResistanceProcedure {
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
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SORCERER_CHESTPLATE.get()) {
					if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2)))
							.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_PALE_AGATE.get()
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2)))
									.getBlock()) {
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2)))
								.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_PALE_AGATE.get()
								&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1)))
										.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))).getBlock()) {
							if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2)))
									.getBlock() && (world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_PALE_AGATE.get()
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2)))
											.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))).getBlock()) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2)))
										.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))).getBlock()
										&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_PALE_AGATE.get() && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2)))
												.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))).getBlock()) {
									if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip44
											? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getValue(_getip44)
											: -1) <= 2
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip46
													? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getValue(_getip46)
													: -1) <= 2) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip48
												? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getValue(_getip48)
												: -1) <= 2
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip50
														? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getValue(_getip50)
														: -1) <= 2) {
											if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip52
													? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getValue(_getip52)
													: -1) <= 2
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip54
															? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getValue(_getip54)
															: -1) <= 2) {
												if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip56
														? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getValue(_getip56)
														: -1) <= 2
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip58
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getValue(_getip58)
																: -1) <= 2) {
													if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("ritual_wand")
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
																		_blockEntity.getPersistentData().putString("Glyph_Type", "Resistance");
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
																			_blockEntity.getPersistentData().putString("Glyph_Type", "Resistance");
																		}
																		if (world instanceof Level _level)
																			_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																	}
																});
															} else {
																if (entity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("This baffles you"), true);
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
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Resistance")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_POWDER) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.BLAZE_POWDER).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added Blaze Powder to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get()).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(1, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added Darkened Iron Ingot to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == ItemStack.EMPTY.getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIRIT_DUST.get()).copy();
									_setstack.setCount(1);
									_itemHandlerModifiable.setStackInSlot(2, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added Spirit Dust to ritual"), true);
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
						if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("ritual_wand")) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
								if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BLAZE_POWDER
										&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()
										&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
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
										_player.displayClientMessage(Component.literal("Resistance III granted!"), true);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 14400, 2, false, false));
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 24000, 2, false, false));
											}
										}
									}
								} else {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
										if (getEntityScore("resistance_ritual", entity) == 0) {
											{
												Entity _ent = entity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("resistance_ritual");
												if (_so == null)
													_so = _sc.addObjective("resistance_ritual", ObjectiveCriteria.DUMMY, Component.literal("resistance_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
											if (getEntityScore("Faction Points", entity) >= 3) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.FactionLevel = 3;
													_vars.markSyncDirty();
												}
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("You advance a level!"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Faction Points");
													if (_so == null)
														_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
												}
											}
										}
									}
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
									if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BLAZE_POWDER
											&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()
											&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
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
											_player.displayClientMessage(Component.literal("Resistance III granted!"), true);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
											{
												final Vec3 _center = new Vec3(x, y, z);
												for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 14400, 2, false, false));
												}
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
											{
												final Vec3 _center = new Vec3(x, y, z);
												for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 24000, 2, false, false));
												}
											}
										}
									} else {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
											if (getEntityScore("resistance_ritual", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("resistance_ritual");
													if (_so == null)
														_so = _sc.addObjective("resistance_ritual", ObjectiveCriteria.DUMMY, Component.literal("resistance_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 3;
														_vars.markSyncDirty();
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), true);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
												}
											}
										}
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
										_player.displayClientMessage(Component.literal("This baffles you"), true);
								}
							}
						}
					}
				}
			}
		}
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
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