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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.MysteriousShadowEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class RitualExorcismProcedure {
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
					if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5)))
							.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_TIGERS_EYE.get()
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5)))
									.getBlock()) {
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5)))
								.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_TIGERS_EYE.get()
								&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1)))
										.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))).getBlock()) {
							if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5)))
									.getBlock() && (world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_TIGERS_EYE.get()
									&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2)))
											.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))).getBlock()) {
								if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2)))
										.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))).getBlock()
										&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.CONCENTRATED_TIGERS_EYE.get() && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2)))
												.getBlock() == (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))).getBlock()) {
									if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip44
											? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getValue(_getip44)
											: -1) >= 3
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip46
													? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getValue(_getip46)
													: -1) <= 5
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip48
													? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getValue(_getip48)
													: -1) >= 3
											&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip50
													? (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getValue(_getip50)
													: -1) <= 5) {
										if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip52
												? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getValue(_getip52)
												: -1) >= 3
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))), "blockstate") instanceof IntegerProperty _getip54
														? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getValue(_getip54)
														: -1) <= 5
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip56
														? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getValue(_getip56)
														: -1) >= 3
												&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))), "blockstate") instanceof IntegerProperty _getip58
														? (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getValue(_getip58)
														: -1) <= 5) {
											if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip60
													? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getValue(_getip60)
													: -1) >= 3
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip62
															? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getValue(_getip62)
															: -1) <= 5
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip64
															? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getValue(_getip64)
															: -1) >= 3
													&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))), "blockstate") instanceof IntegerProperty _getip66
															? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getValue(_getip66)
															: -1) <= 5) {
												if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip68
														? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getValue(_getip68)
														: -1) >= 3
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip70
																? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getValue(_getip70)
																: -1) <= 5
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip72
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getValue(_getip72)
																: -1) >= 3
														&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))), "blockstate") instanceof IntegerProperty _getip74
																? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getValue(_getip74)
																: -1) <= 5) {
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
																		_blockEntity.getPersistentData().putString("Glyph_Type", "Exorcism");
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
																			_blockEntity.getPersistentData().putString("Glyph_Type", "Exorcism");
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
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Exorcism")) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
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
									_player.displayClientMessage(Component.literal("Added Silver Dust to ritual"), true);
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
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIGERS_EYE.get()) {
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
									_player.displayClientMessage(Component.literal("Added Tiger's Eye to ritual"), true);
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
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))
									&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.TIGERS_EYE.get()) {
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
										_player.displayClientMessage(Component.literal("All dark entities and possessing spirits are banished from this area!"), false);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Possession = 0;
												_vars.markSyncDirty();
											}
											entityiterator.getPersistentData().putDouble("lev_possessed", 0);
											entityiterator.getPersistentData().putDouble("dark_possessed", 0);
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
														_vars.Dark_Message_Timer = 20000;
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 100;
														_vars.markSyncDirty();
													}
													if (entityiterator instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("The entity possessing you is banished by a nearby ritual!"), false);
													if (entity instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
													}
													if (entity instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"));
													}
													if (entity instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_attack"));
													}
													if (entity instanceof LivingEntity _entity) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
													}
													if (entity instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
													if (entity instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
													{
														Entity _entity = entityiterator;
														if (_entity instanceof Player _player) {
															_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
															_player.getInventory().setChanged();
														} else if (_entity instanceof LivingEntity _living) {
															_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
														}
													}
													{
														Entity _entity = entityiterator;
														if (_entity instanceof Player _player) {
															_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
															_player.getInventory().setChanged();
														} else if (_entity instanceof LivingEntity _living) {
															_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
														}
													}
													{
														Entity _entity = entityiterator;
														if (_entity instanceof Player _player) {
															_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
															_player.getInventory().setChanged();
														} else if (_entity instanceof LivingEntity _living) {
															_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
														}
													}
													{
														Entity _entity = entityiterator;
														if (_entity instanceof Player _player) {
															_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
															_player.getInventory().setChanged();
														} else if (_entity instanceof LivingEntity _living) {
															_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
														}
													}
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.MonsterInfectable = true;
															_vars.markSyncDirty();
														}
													}
													MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = false;
													MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation_Static = false;
														_vars.markSyncDirty();
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = 100;
																_vars.markSyncDirty();
															}
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
															if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
															if (entityiterator instanceof LivingEntity _entity)
																_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
														}
													});
												}
											}
											if (entityiterator instanceof MysteriousShadowEntity) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), true);
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:smart_sorcery"));
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
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													}
												}
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 4, 8); _i1++) {
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.PURE_DARK_ESSENCE.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
												}
											}
											if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:spirit_entity")))) {
												entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 500);
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
										if (getEntityScore("exorcism_ritual", entity) == 0) {
											{
												Entity _ent = entity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("exorcism_ritual");
												if (_so == null)
													_so = _sc.addObjective("exorcism_ritual", ObjectiveCriteria.DUMMY, Component.literal("exorcism_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
											_player.displayClientMessage(Component.literal("All dark entities and possessing spirits are banished from this area!"), false);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Possession = 0;
													_vars.markSyncDirty();
												}
												entityiterator.getPersistentData().putDouble("lev_possessed", 0);
												entityiterator.getPersistentData().putDouble("dark_possessed", 0);
												if (entityiterator instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
												if (entityiterator instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.Dark_Message_Timer = 20000;
															_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 100;
															_vars.markSyncDirty();
														}
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("The entity possessing you is banished by a nearby ritual!"), false);
														if (entity instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
														}
														if (entity instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"));
														}
														if (entity instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_attack"));
														}
														if (entity instanceof LivingEntity _entity) {
															_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
														}
														if (entity instanceof LivingEntity _entity)
															_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
														if (entity instanceof LivingEntity _entity)
															_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
														{
															Entity _entity = entityiterator;
															if (_entity instanceof Player _player) {
																_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
																_player.getInventory().setChanged();
															} else if (_entity instanceof LivingEntity _living) {
																_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
															}
														}
														{
															Entity _entity = entityiterator;
															if (_entity instanceof Player _player) {
																_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
																_player.getInventory().setChanged();
															} else if (_entity instanceof LivingEntity _living) {
																_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
															}
														}
														{
															Entity _entity = entityiterator;
															if (_entity instanceof Player _player) {
																_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
																_player.getInventory().setChanged();
															} else if (_entity instanceof LivingEntity _living) {
																_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
															}
														}
														{
															Entity _entity = entityiterator;
															if (_entity instanceof Player _player) {
																_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
																_player.getInventory().setChanged();
															} else if (_entity instanceof LivingEntity _living) {
																_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
															}
														}
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.MonsterInfectable = true;
																_vars.markSyncDirty();
															}
														}
														MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = false;
														MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation_Static = false;
															_vars.markSyncDirty();
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.Reputation = 100;
																	_vars.markSyncDirty();
																}
															}
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
																if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																	_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
															}
															if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																if (entityiterator instanceof LivingEntity _entity)
																	_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
															}
														});
													}
												}
												if (entityiterator instanceof MysteriousShadowEntity) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 5;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), true);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:smart_sorcery"));
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
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
														}
													}
												}
												if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:spirit_entity")))) {
													entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 500);
												}
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
											if (getEntityScore("exorcism_ritual", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("exorcism_ritual");
													if (_so == null)
														_so = _sc.addObjective("exorcism_ritual", ObjectiveCriteria.DUMMY, Component.literal("exorcism_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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