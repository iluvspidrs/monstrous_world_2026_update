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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;
import net.mcreator.monstrousworld.entity.FeralWerewolfEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class RitualLycanCureProcedure {
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
					if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get()
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
								&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get()
								&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
							if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
									&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get()
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get()
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
									if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip28
											? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getValue(_getip28)
											: -1) >= 15
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip30
													? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getValue(_getip30)
													: -1) <= 17) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip32
												? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getValue(_getip32)
												: -1) >= 15
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip34
														? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getValue(_getip34)
														: -1) <= 17) {
											if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip36
													? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getValue(_getip36)
													: -1) >= 15
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip38
															? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getValue(_getip38)
															: -1) <= 17) {
												if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip40
														? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getValue(_getip40)
														: -1) >= 15
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip42
																? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getValue(_getip42)
																: -1) <= 17) {
													if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip44
															? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getValue(_getip44)
															: -1) >= 15
															&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip46
																	? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getValue(_getip46)
																	: -1) <= 17) {
														if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip48
																? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getValue(_getip48)
																: -1) >= 15
																&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip50
																		? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getValue(_getip50)
																		: -1) <= 17) {
															if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip52
																	? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getValue(_getip52)
																	: -1) >= 15
																	&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip54
																			? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getValue(_getip54)
																			: -1) <= 17) {
																if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip56
																		? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getValue(_getip56)
																		: -1) >= 15
																		&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip58
																				? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getValue(_getip58)
																				: -1) <= 17) {
																	if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("ritual_wand")
																			&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get())) {
																		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
																			MonstrousWorldMod.queueServerWork(3, () -> {
																				if (world instanceof Level _level) {
																					if (!_level.isClientSide()) {
																						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1,
																								1);
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
																						_blockEntity.getPersistentData().putString("Glyph_Type", "Lycan Cure");
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
																							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL,
																									1, 1);
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
																							_blockEntity.getPersistentData().putString("Glyph_Type", "Lycan Cure");
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
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Lycan Cure")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MOON_DUST.get()) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() < 5) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() + 1);
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Added Moon Dust to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:silver_daggers")))) {
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
									_player.displayClientMessage(Component.literal("Added Silver Dagger to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_POWDER) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount() < 3) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount() + 1);
									_itemHandlerModifiable.setStackInSlot(2, _setstack);
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
						if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("ritual_wand")) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == MonstrousWorldModItems.MOON_DUST.get()
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:silver_daggers")))
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.BLAZE_POWDER) {
								if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() == 5 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount() == 3) {
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
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("All feral werewolves nearby are cured!"), true);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
													if (entityiterator instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("A nearby ritual cures you of lycanthropy!"), true);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("feral_werewolf_kills");
														if (_so == null)
															_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.MonsterType = 0;
														_vars.FeralLevel = 0;
														_vars.BeastForm = false;
														_vars.markSyncDirty();
													}
													entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", false);
													if (entityiterator instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
													}
													if (entityiterator instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
													}
													if (entityiterator instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
													}
													if (entityiterator instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_fall_damage"));
													}
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.LUNAR_PULL);
													if (entityiterator instanceof LivingEntity _entity)
														_entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1);
													entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is restored!"), false);
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.DarknessInfectable = true;
															_vars.MonsterInfectable = true;
															_vars.Reputation = 0;
															_vars.markSyncDirty();
														}
													}
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.MonsterInfectable = true;
															_vars.DarknessInfectable = true;
															_vars.Reputation = 0;
															_vars.markSyncDirty();
														}
													}
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
															|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
															|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.MonsterInfectable = true;
															_vars.markSyncDirty();
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 12) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 30;
																_vars.markSyncDirty();
															}
														}
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 20;
															_vars.markSyncDirty();
														}
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = 100;
																_vars.markSyncDirty();
															}
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = 100;
																_vars.markSyncDirty();
															}
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
															if (entity instanceof LivingEntity _entity)
																_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
															if (entityiterator instanceof LivingEntity _entity)
																_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
														}
													});
												}
												if (entityiterator instanceof FeralWerewolfEntity || entityiterator instanceof DireWerewolfEntity || entityiterator instanceof FollowerWerewolfEntity) {
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													entity.getPersistentData().putDouble("cure_type", (Mth.nextInt(RandomSource.create(), 1, 10)));
													if (entity.getPersistentData().getDouble("cure_type") == 1) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 2) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 3) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 4) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																	MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 5) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																	MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 6) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																	MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 7) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																	MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 8) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_PATROL_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																	MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 9) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (entity.getPersistentData().getDouble("cure_type") == 10) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
															}
														}
													}
													if (!entityiterator.level().isClientSide())
														entityiterator.discard();
												}
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
											if (getEntityScore("lycan_cure_ritual", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("lycan_cure_ritual");
													if (_so == null)
														_so = _sc.addObjective("lycan_cure_ritual", ObjectiveCriteria.DUMMY, Component.literal("lycan_cure_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("All feral werewolves nearby are cured!"), true);
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
												_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
												_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
												_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
											{
												final Vec3 _center = new Vec3(x, y, z);
												for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("A nearby ritual cures you of lycanthropy!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("feral_werewolf_kills");
															if (_so == null)
																_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.MonsterType = 0;
															_vars.FeralLevel = 0;
															_vars.BeastForm = false;
															_vars.markSyncDirty();
														}
														entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", false);
														if (entityiterator instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
														}
														if (entityiterator instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
														}
														if (entityiterator instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
														}
														if (entityiterator instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_fall_damage"));
														}
														if (entityiterator instanceof LivingEntity _entity)
															_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
														if (entityiterator instanceof LivingEntity _entity)
															_entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1);
														entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
															if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is restored!"), false);
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.DarknessInfectable = true;
																_vars.MonsterInfectable = true;
																_vars.Reputation = 0;
																_vars.markSyncDirty();
															}
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.MonsterInfectable = true;
																_vars.DarknessInfectable = true;
																_vars.Reputation = 0;
																_vars.markSyncDirty();
															}
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
																|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
																|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
																if (_adv != null) {
																	AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																	if (!_ap.isDone()) {
																		for (String criteria : _ap.getRemainingCriteria())
																			_player.getAdvancements().award(_adv, criteria);
																	}
																}
															}
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.MonsterInfectable = true;
																_vars.markSyncDirty();
															}
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 12) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 30;
																	_vars.markSyncDirty();
																}
															}
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.Reputation = 100;
																	_vars.markSyncDirty();
																}
															}
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.Reputation = 100;
																	_vars.markSyncDirty();
																}
															}
															if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																if (entity instanceof LivingEntity _entity)
																	_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
															}
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																if (entityiterator instanceof LivingEntity _entity)
																	_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
															}
														});
													}
													if (entityiterator instanceof FeralWerewolfEntity || entityiterator instanceof DireWerewolfEntity || entityiterator instanceof FollowerWerewolfEntity) {
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_daring_doctor"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
														entity.getPersistentData().putDouble("cure_type", (Mth.nextInt(RandomSource.create(), 1, 10)));
														if (entity.getPersistentData().getDouble("cure_type") == 1) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 2) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 3) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 4) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 5) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 6) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 7) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 8) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_PATROL_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 9) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (entity.getPersistentData().getDouble("cure_type") == 10) {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
																}
															}
														}
														if (!entityiterator.level().isClientSide())
															entityiterator.discard();
													}
												}
											}
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
												if (getEntityScore("lycan_cure_ritual", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("lycan_cure_ritual");
														if (_so == null)
															_so = _sc.addObjective("lycan_cure_ritual", ObjectiveCriteria.DUMMY, Component.literal("lycan_cure_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This baffles you"), true);
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