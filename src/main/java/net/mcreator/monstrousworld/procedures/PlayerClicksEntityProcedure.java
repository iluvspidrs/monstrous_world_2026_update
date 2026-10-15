package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
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
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PlayerClicksEntityProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())) {
				if (entity instanceof EvilDarknessSpiritEntity || entity instanceof EvilLevitatingSpiritEntity) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
						if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.COOKIE_OF_CONFUSION.get()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.WILL_O_THE_WISP.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.COOKIE_OF_CONFUSION.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:spirit_treats"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
				if (entity instanceof WillOTheWispEntity) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_WISP_LANTERN.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.EMPTY_WISP_LANTERN.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.WISP_LANTERN.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
				if (entity instanceof HungryTreeEntity) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_DAGGER.get()) {
						if (!(entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(MobEffects.REGENERATION))) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.shear")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.shear")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.HUNGRY_TREE_BARK.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Hungry Tree Bark obtained"), true);
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:barking_up_a_tree"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 6000, 0));
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("This Hungry Tree is either healing or in water and cannot give bark"), true);
						}
					}
				}
				if (entity instanceof DeathbloomEntityEntity) {
					if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:blood_bottles"))))) {
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.DEATH_BLOOM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (y + entity.getY()), (entity.getZ()), 25, 1, 1, 1, 1);
						if (Math.random() >= 0.66) {
							world.setBlock(BlockPos.containing(entity.getX(), y, entity.getZ()), MonstrousWorldModBlocks.EMPTY_BAT_SNARE.get().defaultBlockState(), 3);
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
				if (entity instanceof EyeletEntity) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.EYELET_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
				if (entity instanceof PumpkinBroomEntityEntity) {
					if (sourceentity.isShiftKeyDown()) {
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.PUMPKIN_BROOM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Up: [SPACE]    Forward: [W]   Down: [D] "), true);
					}
				}
				if (entity instanceof GhostlyBroomEntityEntity) {
					if (sourceentity.isShiftKeyDown()) {
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.GHOSTLY_BROOM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Up: [SPACE]    Forward: [W]   Down: [D] "), true);
					}
				}
				if (entity instanceof EvilBroomEntityEntity) {
					if (sourceentity.isShiftKeyDown()) {
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.EVIL_BROOM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Up: [SPACE]    Forward: [W]   Down: [D] "), true);
					}
				}
				if (entity instanceof InfernalLightEntity) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_JAR.get()) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.INFERNAL_JAR.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CAPTIVE_INFERNAL_LIGHT.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!entity.level().isClientSide())
							entity.discard();
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pure_wickedness"));
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
				if (entity instanceof SwampLightEntity) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CRUDE_SWAMP_DAGGER.get()) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (sourceentity.getX()), (y + sourceentity.getY()), (sourceentity.getZ()), 25, 1, 1, 1, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.CRUDE_SWAMP_DAGGER.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof LivingEntity _entity) {
							ItemStack _setstack86 = new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_DAGGER.get()).copy();
							_setstack86.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack86);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FactionLevel = 2;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You advance a level!"), true);
								if (sourceentity instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor2"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (sourceentity instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterstrength2"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 1, 1, 1, 1);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.SWAMP_ESSENCE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 1, 1, 1, 1);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_LIGHT_JAR.get()) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SWAMP_LIGHT_JAR.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CAPTURED_SWAMP_LIGHT.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_up")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!entity.level().isClientSide())
							entity.discard();
					}
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 1, 1, 1, 1);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.SWAMP_ESSENCE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
				if (entity instanceof FeralWerewolfEntity) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
								if (hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.BRACELET_OF_CONTROL.get()))) {
									if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("A feral werewolf joins your pack!"), false);
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your reputation improves!"), true);
										if (sourceentity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:growing_your_pack"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.BRACELET_OF_CONTROL.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
											_vars.markSyncDirty();
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											Entity _ent = sourceentity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("pack_members");
											if (_so == null)
												_so = _sc.addObjective("pack_members", ObjectiveCriteria.DUMMY, Component.literal("pack_members"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("pack_members", sourceentity) + 1);
										}
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.FOLLOWER_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setYRot(entity.getYRot());
												entityToSpawn.setYBodyRot(entity.getYRot());
												entityToSpawn.setYHeadRot(entity.getYRot());
												entityToSpawn.setXRot(entity.getXRot());
											}
										}
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Reputation = 100;
													_vars.markSyncDirty();
												}
											}
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
												if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
											}
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
												if (sourceentity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
											}
										});
										MonstrousWorldMod.queueServerWork(1, () -> {
											{
												final Vec3 _center = new Vec3(x, y, z);
												for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
													if (entityiterator instanceof FollowerWerewolfEntity) {
														if (entityiterator instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
															_toTame.tame(_owner);
														entityiterator.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
														entityiterator.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
													}
												}
											}
										});
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
											MonstrousWorldMod.queueServerWork(1, () -> {
												if (getEntityScore("pack_members", sourceentity) >= 6) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), true);
													if (sourceentity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_full_alpha"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 4;
														_vars.markSyncDirty();
													}
													if (sourceentity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_4"), 1, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
													if (sourceentity instanceof LivingEntity _entity) {
														AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_4"), 0.01, AttributeModifier.Operation.ADD_VALUE);
														if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
															_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
														}
													}
												}
											});
										}
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Reputation = 100;
													_vars.markSyncDirty();
												}
											}
											if (!entity.level().isClientSide())
												entity.discard();
										});
									}
								}
							}
						}
					}
				}
				if (entity instanceof FollowerWerewolfEntity) {
					if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
							if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
								if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:werewolf_necklaces"))))) {
									if (!(entity.getPersistentData().getBoolean("Sitting") == true)) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Sitting", true);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member may wander"), true);
										});
									}
									if (entity.getPersistentData().getBoolean("Sitting") == true) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											entity.getPersistentData().putBoolean("Sitting", false);
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member will follow"), true);
										});
									}
								} else {
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_good_alpha_adv"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if ((entity.getPersistentData().getString("Necklace")).equals("Lunar")) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_LUNAR_STRENGTH.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getPersistentData().getString("Necklace")).equals("Regeneration")) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_REGENERATION.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getPersistentData().getString("Necklace")).equals("Attack")) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_ATTACK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getPersistentData().getString("Necklace")).equals("Cleansing")) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_CLEANSING.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getPersistentData().getString("Necklace")).equals("Shield")) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_SHIELD.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_LUNAR_STRENGTH.get()) {
											entity.getPersistentData().putString("Necklace", "Lunar");
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member now has Necklace of Lunar Strength"), true);
											entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.setCustomName(Component.literal(("\u00A7b" + entity.getDisplayName().getString())));
											});
										} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_REGENERATION.get()) {
											entity.getPersistentData().putString("Necklace", "Regeneration");
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member now has Necklace of Regeneration"), true);
											entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.setCustomName(Component.literal(("\u00A7d" + entity.getDisplayName().getString())));
											});
										} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_ATTACK.get()) {
											entity.getPersistentData().putString("Necklace", "Attack");
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member now has Necklace of Attack"), true);
											entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.setCustomName(Component.literal(("\u00A77" + entity.getDisplayName().getString())));
											});
										} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WEREWOLF_NECKLACE_OF_CLEANSING.get()) {
											entity.getPersistentData().putString("Necklace", "Cleansing");
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member now has Necklace of Cleansing"), true);
											entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.setCustomName(Component.literal(("\u00A72" + entity.getDisplayName().getString())));
											});
										} else {
											entity.getPersistentData().putString("Necklace", "Shield");
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Pack member now has Necklace of Shield"), true);
											entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.setCustomName(Component.literal(("\u00A76" + entity.getDisplayName().getString())));
											});
										}
									});
									MonstrousWorldMod.queueServerWork(2, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_leather")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_leather")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									});
								}
							}
						}
					} else {
						if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
							if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
						}
					}
				}
				if (entity instanceof CatFamiliarEntity) {
					if (sourceentity.isShiftKeyDown()) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
							if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
								if (!(entity.getPersistentData().getBoolean("Sitting") == true)) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putBoolean("Sitting", true);
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Familiar ordered to stay"), true);
									});
								}
								if (entity.getPersistentData().getBoolean("Sitting") == true) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putBoolean("Sitting", false);
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Familiar ordered to follow"), true);
									});
								}
							}
						}
					}
				}
			}
			if ((BuiltInRegistries.ITEM.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("dagger")) {
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("serpent") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("snake")
						|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("naga") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("cobra")
						|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("python") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("hognose")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SERPENT_SCALE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
				}
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TEST_TUBE.get()) {
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombie") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("zombified")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.UNDEAD_TISSUE_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("spider")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SPIDER_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("serpent") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("snake")
						|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("naga") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("cobra")
						|| (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("python") || (BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("hognose")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.SERPENT_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("fly")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.FLY_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof DreadfulWatcherEntity) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.DREADFUL_WATCHER_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (entity instanceof Pillager || entity instanceof SpellcasterIllager || entity instanceof Evoker || entity instanceof Vindicator) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.ILLAGER_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("creeper")) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(MonstrousWorldModItems.CREEPER_DNA_SAMPLE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (entity instanceof Salmon) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
							if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE_MEAL));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:gulp"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (!entity.level().isClientSide())
									entity.discard();
								if (!(sourceentity instanceof LivingEntity _livEnt316 && _livEnt316.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 6));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 6);
								} else {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 3));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 3);
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You prefer dragging victims underwater to drown them..."), false);
								}
							}
						}
					}
				}
			}
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (entity instanceof TropicalFish) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
							if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE_MEAL));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (!entity.level().isClientSide())
									entity.discard();
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:gulp"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (!(sourceentity instanceof LivingEntity _livEnt336 && _livEnt336.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 3));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 3);
								} else {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 1));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 1);
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You prefer dragging victims underwater to drown them..."), false);
								}
							}
						}
					}
				}
			}
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (entity instanceof Frog) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE_MEAL));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:gulp"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
							if (!(sourceentity instanceof LivingEntity _livEnt354 && _livEnt354.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 10));
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 10);
							} else {
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 4));
								if (sourceentity instanceof Player _player)
									_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 5);
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You prefer dragging victims underwater to drown them..."), false);
							}
						}
					}
				}
			}
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (entity instanceof Cod) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
							if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.witch.drink")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE_MEAL));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:gulp"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (!entity.level().isClientSide())
									entity.discard();
								if (!(sourceentity instanceof LivingEntity _livEnt374 && _livEnt374.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 4));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 4);
								} else {
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setSaturation((float) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + 2));
									if (sourceentity instanceof Player _player)
										_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 2);
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You prefer dragging victims underwater to drown them..."), false);
								}
							}
						}
					}
				}
			}
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
				if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get())) {
					if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())) {
						if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get())) {
							if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get())) {
								if (!(entity instanceof LivingEntity _livEnt392 && _livEnt392.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
									if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
										if (!(entity instanceof HunterNPCEntity) && !(entity instanceof HunterPatrolNPCEntity)) {
											if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
												if (sourceentity.isShiftKeyDown()) {
													if (!(entity instanceof LivingEntity _livEnt398 && _livEnt398.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
														if (sourceentity.getPersistentData().getDouble("HypnosisCooldown") == 0) {
															entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
															sourceentity.getPersistentData().putString("victim", (entity.getStringUUID()));
															if (sourceentity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:feeding_from_the_source"));
																if (_adv != null) {
																	AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																	if (!_ap.isDone()) {
																		for (String criteria : _ap.getRemainingCriteria())
																			_player.getAdvancements().award(_adv, criteria);
																	}
																}
															}
															if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Victim hypnotized. Press [V] to feed..."), true);
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
															sourceentity.getPersistentData().putDouble("HypnosisCooldown", 600);
														} else {
															if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You cannot hypnotize another victim for a short time..."), true);
														}
													}
												}
											}
										} else {
											if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
												if (sourceentity.isShiftKeyDown()) {
													if (!(entity instanceof LivingEntity _livEnt412 && _livEnt412.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
														if (sourceentity.getPersistentData().getDouble("HypnosisCooldown") == 0) {
															if (Math.random() < entity.getPersistentData().getDouble("Infectability")) {
																entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																sourceentity.getPersistentData().putString("victim", (entity.getStringUUID()));
																if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																	_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
																if (sourceentity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:feeding_from_the_source"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
																if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("Victim hypnotized. Press [V] to feed..."), true);
																if (world instanceof Level _level) {
																	if (!_level.isClientSide()) {
																		_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																	} else {
																		_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																	}
																}
																sourceentity.getPersistentData().putDouble("HypnosisCooldown", 600);
															} else {
																if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("The Hunter resists your hypnosis"), true);
															}
														} else {
															if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You cannot hypnotize another victim for a short time..."), true);
														}
													}
												}
											}
										}
									}
									if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:nonhuman_being")))) {
										if (sourceentity.isShiftKeyDown()) {
											if (!(entity instanceof LivingEntity _livEnt428 && _livEnt428.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
												if (sourceentity.getPersistentData().getDouble("HypnosisCooldown") == 0) {
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													sourceentity.getPersistentData().putString("victim", (entity.getStringUUID()));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
													if (sourceentity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:feeding_from_the_source"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Victim hypnotized. Press [V] to feed..."), true);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													sourceentity.getPersistentData().putDouble("HypnosisCooldown", 600);
													if (entity instanceof FeralGoblinEntity) {
														if (sourceentity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:me_first"));
															if (_adv != null) {
																AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																if (!_ap.isDone()) {
																	for (String criteria : _ap.getRemainingCriteria())
																		_player.getAdvancements().award(_adv, criteria);
																}
															}
														}
													}
												} else {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You cannot hypnotize another victim for a short time..."), true);
												}
											}
										}
									}
									if (entity instanceof Animal) {
										if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:robot")))) {
											if (sourceentity.isShiftKeyDown()) {
												if (!(entity instanceof LivingEntity _livEnt445 && _livEnt445.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													sourceentity.getPersistentData().putString("victim", (entity.getStringUUID()));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
													if (sourceentity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:feeding_from_the_source"));
														if (_adv != null) {
															AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
															if (!_ap.isDone()) {
																for (String criteria : _ap.getRemainingCriteria())
																	_player.getAdvancements().award(_adv, criteria);
															}
														}
													}
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Victim hypnotized. Press [V] to feed..."), true);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												}
											}
										}
									}
									if (entity instanceof Player || entity instanceof ServerPlayer) {
										if (sourceentity.isShiftKeyDown()) {
											if (!(entity instanceof LivingEntity _livEnt457 && _livEnt457.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
															if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 10) {
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 11) {
																	if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
																		if (sourceentity.getPersistentData().getDouble("HypnosisCooldown") == 0) {
																			if (Math.random() < entity.getPersistentData().getDouble("Infectability")) {
																				entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																				sourceentity.getPersistentData().putString("victim", (entity.getStringUUID()));
																				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
																				if (sourceentity instanceof ServerPlayer _player) {
																					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:feeding_from_the_source"));
																					if (_adv != null) {
																						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																						if (!_ap.isDone()) {
																							for (String criteria : _ap.getRemainingCriteria())
																								_player.getAdvancements().award(_adv, criteria);
																						}
																					}
																				}
																				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																					_player.displayClientMessage(Component.literal("Victim hypnotized. Press [V] to feed..."), true);
																				if (world instanceof Level _level) {
																					if (!_level.isClientSide()) {
																						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")),
																								SoundSource.NEUTRAL, 1, 1);
																					} else {
																						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																					}
																				}
																				sourceentity.getPersistentData().putDouble("HypnosisCooldown", 600);
																			}
																		} else {
																			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																				_player.displayClientMessage(Component.literal("You cannot hypnotize another victim for a short time..."), true);
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
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}