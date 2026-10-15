package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CountBloodBottlesInCollectorProcedure {
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
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.BLOOD_COLLECTOR.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
						if (!entity.isShiftKeyDown()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") < 9) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_WEAK_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("WeakBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WeakBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Weak Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("RegularBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Human Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("GoblinBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Goblin Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("TrollBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Troll Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_DEMON_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("DemonBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Demon Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("SwampmonsterBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Swampmonster Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("WerewolfBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Werewolf Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("EyeBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Eye Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("FlyBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Fly Blood to collector"), false);
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("SerpentBlood", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") + 1));
											_blockEntity.getPersistentData().putDouble("BloodLevel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") + 1));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Added Serpent Blood to collector"), false);
								}
							} else {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.BLOCK_OF_CLEAR_QUARTZ.get().asItem()) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") == 1) {
										if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") == 1) {
											if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") == 1) {
												if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") == 1) {
													if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") == 1) {
														if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") == 1) {
															if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") == 1) {
																if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") == 1) {
																	if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WeakBlood") == 1) {
																		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
																			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
																				if (entity instanceof Player _player) {
																					ItemStack _stktoremove = new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_CLEAR_QUARTZ.get());
																					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
																				}
																				if (entity instanceof ServerPlayer _player) {
																					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:overpowered"));
																					if (_adv != null) {
																						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																						if (!_ap.isDone()) {
																							for (String criteria : _ap.getRemainingCriteria())
																								_player.getAdvancements().award(_adv, criteria);
																						}
																					}
																				}
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
																				{
																					BlockPos _bp = BlockPos.containing(x, y, z);
																					BlockState _bs = MonstrousWorldModBlocks.UPGRADED_BLOOD_COLLECTOR.get().defaultBlockState();
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
																				if (world instanceof Level _level) {
																					if (!_level.isClientSide()) {
																						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL,
																								1, 1);
																					} else {
																						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																					}
																				}
																				if (world instanceof ServerLevel _level) {
																					Entity entityToSpawn = MonstrousWorldModEntities.BLOOD_COLLECTOR_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 0.9, z), MobSpawnType.MOB_SUMMONED);
																					if (entityToSpawn != null) {
																					}
																				}
																				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
																					{
																						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																						_vars.FactionLevel = 6;
																						_vars.markSyncDirty();
																					}
																				}
																			} else {
																				if (entity instanceof Player _player && !_player.level().isClientSide())
																					_player.displayClientMessage(Component.literal("You are not yet skilled enough to upgrade this Collector"), true);
																			}
																		} else {
																			if (entity instanceof Player _player && !_player.level().isClientSide())
																				_player.displayClientMessage(Component.literal("Only a first-generation vampire can alter this Collector..."), true);
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
						} else {
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_DEMON_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int _i1 = 0; _i1 < (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WeakBlood"); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEAK_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("BloodLevel", 0);
										_blockEntity.getPersistentData().putDouble("RegularBlood", 0);
										_blockEntity.getPersistentData().putDouble("GoblinBlood", 0);
										_blockEntity.getPersistentData().putDouble("TrollBlood", 0);
										_blockEntity.getPersistentData().putDouble("SwampmonsterBlood", 0);
										_blockEntity.getPersistentData().putDouble("DemonBlood", 0);
										_blockEntity.getPersistentData().putDouble("FlyBlood", 0);
										_blockEntity.getPersistentData().putDouble("SerpentBlood", 0);
										_blockEntity.getPersistentData().putDouble("EyeBlood", 0);
										_blockEntity.getPersistentData().putDouble("WerewolfBlood", 0);
										_blockEntity.getPersistentData().putDouble("WeakBlood", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							});
						}
						MonstrousWorldMod.queueServerWork(2, () -> {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") < 3) {
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") < 6) {
									{
										int _value = 1;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BloodLevel") < 9) {
									{
										int _value = 2;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 3;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								}
							}
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Regeneration", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Speed", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Strength", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Fire Resistance", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Dolphins Grace", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Jump Boost", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Haste", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Slow Falling", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") < 3) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Hypnosis", 0);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Regeneration", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetRegen", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetRegen");
													if (_so == null)
														_so = _sc.addObjective("SetRegen", ObjectiveCriteria.DUMMY, Component.literal("SetRegen"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RegularBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Regeneration", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetRegen", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetRegen");
														if (_so == null)
															_so = _sc.addObjective("SetRegen", ObjectiveCriteria.DUMMY, Component.literal("SetRegen"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Regeneration", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetRegen", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetRegen");
														if (_so == null)
															_so = _sc.addObjective("SetRegen", ObjectiveCriteria.DUMMY, Component.literal("SetRegen"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Speed", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetSpeed", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetSpeed");
													if (_so == null)
														_so = _sc.addObjective("SetSpeed", ObjectiveCriteria.DUMMY, Component.literal("SetSpeed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoblinBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Speed", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetSpeed", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetSpeed");
														if (_so == null)
															_so = _sc.addObjective("SetSpeed", ObjectiveCriteria.DUMMY, Component.literal("SetSpeed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Speed", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetSpeed", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetSpeed");
														if (_so == null)
															_so = _sc.addObjective("SetSpeed", ObjectiveCriteria.DUMMY, Component.literal("SetSpeed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Strength", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetStrength", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetStrength");
													if (_so == null)
														_so = _sc.addObjective("SetStrength", ObjectiveCriteria.DUMMY, Component.literal("SetStrength"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TrollBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Strength", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetStrength", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetStrength");
														if (_so == null)
															_so = _sc.addObjective("SetStrength", ObjectiveCriteria.DUMMY, Component.literal("SetStrength"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Strength", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetStrength", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetStrength");
														if (_so == null)
															_so = _sc.addObjective("SetStrength", ObjectiveCriteria.DUMMY, Component.literal("SetStrength"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Fire Resistance", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetFireResistance", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetFireResistance");
													if (_so == null)
														_so = _sc.addObjective("SetFireResistance", ObjectiveCriteria.DUMMY, Component.literal("SetFireResistance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DemonBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Fire Resistance", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetFireResistance", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetFireResistance");
														if (_so == null)
															_so = _sc.addObjective("SetFireResistance", ObjectiveCriteria.DUMMY, Component.literal("SetFireResistance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Fire Resistance", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetFireResistance", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetFireResistance");
														if (_so == null)
															_so = _sc.addObjective("SetFireResistance", ObjectiveCriteria.DUMMY, Component.literal("SetFireResistance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Dolphins Grace", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetDolphinsGrace", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetDolphinsGrace");
													if (_so == null)
														_so = _sc.addObjective("SetDolphinsGrace", ObjectiveCriteria.DUMMY, Component.literal("SetDolphinsGrace"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampmonsterBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Dolphins Grace", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetDolphinsGrace", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetDolphinsGrace");
														if (_so == null)
															_so = _sc.addObjective("SetDolphinsGrace", ObjectiveCriteria.DUMMY, Component.literal("SetDolphinsGrace"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Dolphins Grace", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetDolphinsGrace", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetDolphinsGrace");
														if (_so == null)
															_so = _sc.addObjective("SetDolphinsGrace", ObjectiveCriteria.DUMMY, Component.literal("SetDolphinsGrace"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Jump Boost", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetJumpBoost", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetJumpBoost");
													if (_so == null)
														_so = _sc.addObjective("SetJumpBoost", ObjectiveCriteria.DUMMY, Component.literal("SetJumpBoost"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WerewolfBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Jump Boost", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetJumpBoost", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetJumpBoost");
														if (_so == null)
															_so = _sc.addObjective("SetJumpBoost", ObjectiveCriteria.DUMMY, Component.literal("SetJumpBoost"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Jump Boost", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetJumpBoost", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetJumpBoost");
														if (_so == null)
															_so = _sc.addObjective("SetJumpBoost", ObjectiveCriteria.DUMMY, Component.literal("SetJumpBoost"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Slow Falling", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetSlowFalling", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetSlowFalling");
													if (_so == null)
														_so = _sc.addObjective("SetSlowFalling", ObjectiveCriteria.DUMMY, Component.literal("SetSlowFalling"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlyBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Slow Falling", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetSlowFalling", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetSlowFalling");
														if (_so == null)
															_so = _sc.addObjective("SetSlowFalling", ObjectiveCriteria.DUMMY, Component.literal("SetSlowFalling"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Slow Falling", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetSlowFalling", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetSlowFalling");
														if (_so == null)
															_so = _sc.addObjective("SetSlowFalling", ObjectiveCriteria.DUMMY, Component.literal("SetSlowFalling"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Haste", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetHaste", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetHaste");
													if (_so == null)
														_so = _sc.addObjective("SetHaste", ObjectiveCriteria.DUMMY, Component.literal("SetHaste"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SerpentBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Haste", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetHaste", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetHaste");
														if (_so == null)
															_so = _sc.addObjective("SetHaste", ObjectiveCriteria.DUMMY, Component.literal("SetHaste"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Haste", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetHaste", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetHaste");
														if (_so == null)
															_so = _sc.addObjective("SetHaste", ObjectiveCriteria.DUMMY, Component.literal("SetHaste"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") >= 3) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") < 6) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("Hypnosis", 1);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											if (getEntityScore("SetHypnosis", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("SetHypnosis");
													if (_so == null)
														_so = _sc.addObjective("SetHypnosis", ObjectiveCriteria.DUMMY, Component.literal("SetHypnosis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
												if (getEntityScore("Faction Points", entity) >= 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.markSyncDirty();
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), false);
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
														}
													}
													if (entity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											}
										}
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") >= 6) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "EyeBlood") < 9) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Hypnosis", 2);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetHypnosis", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetHypnosis");
														if (_so == null)
															_so = _sc.addObjective("SetHypnosis", ObjectiveCriteria.DUMMY, Component.literal("SetHypnosis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("Hypnosis", 3);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
												if (getEntityScore("SetHypnosis", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("SetHypnosis");
														if (_so == null)
															_so = _sc.addObjective("SetHypnosis", ObjectiveCriteria.DUMMY, Component.literal("SetHypnosis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
													if (getEntityScore("Faction Points", entity) >= 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 5, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
															}
														}
														if (entity instanceof LivingEntity _entity) {
															AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
															if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
																_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						});
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You are not yet skilled enough to use this"), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Only first-generation vampires can use this"), false);
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}