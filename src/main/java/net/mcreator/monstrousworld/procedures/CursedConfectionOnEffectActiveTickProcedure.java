package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class CursedConfectionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getPersistentData().getBoolean("hit_by_acid_ball") == true) {
					if (entity.isInWaterOrBubble()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
						entity.getPersistentData().putBoolean("hit_by_acid_ball", false);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10
						|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1
						|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 2399) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Dazed, you take the candy offered to you..."), false);
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(MonstrousWorldModItems.CURSED_CANDY.get()));
				}
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:dark_faction")))) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 300) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sugary acid covers you and burns!"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 250) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 200) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 150) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 100) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 50) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) == 1) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
				for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 1, 3); _i1++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.CURSED_CONFECTIONERY.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
							if (entity instanceof Witch1Entity || entity instanceof SorcererNPCEntity || entity instanceof Witch || entity instanceof Evoker || entity instanceof Illusioner || entity instanceof DarkMarketVendorEntity) {
								if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Magic User";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
							}
							if (entity instanceof MadScientistNPCEntity || entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity || entity instanceof InfectedGoonEntity || entity instanceof HunterNPCEntity
									|| entity instanceof HunterPatrolNPCEntity) {
								if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Human";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
							}
							if (entity instanceof Villager || entity instanceof WanderingTrader) {
								if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Villager";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
							}
							if (entity instanceof Pillager || entity instanceof Vindicator) {
								if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Illager";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
							}
							if (entity instanceof FeralMountainTrollEntity || entity instanceof TrollNPCEntity) {
								{
									final String _tagName = "Type";
									final String _tagValue = "Troll";
									CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
								}
							}
							if (entity instanceof FeralGoblinEntity || entity instanceof GoblinVillagerEntity || entity instanceof GoblinFollowerEntity) {
								{
									final String _tagName = "Type";
									final String _tagValue = "Goblin";
									CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
								}
							}
							if (entity instanceof SwampmonsterVillagerEntity || entity instanceof SwampmonsterChieftanEntity || entity instanceof FeralSwampmonsterEntity) {
								{
									final String _tagName = "Type";
									final String _tagValue = "Swampmonster";
									CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
								}
							}
							if (entity instanceof FeralWerewolfEntity || entity instanceof FollowerWerewolfEntity || entity instanceof HumanWerewolfEntity) {
								{
									final String _tagName = "Type";
									final String _tagValue = "Werewolf";
									CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
								}
							}
							if (entity instanceof FeralVampireEntity || entity instanceof VampireNPCEntity || entity.getPersistentData().getBoolean("vampire") == true) {
								{
									final String _tagName = "Type";
									final String _tagValue = "Vampire";
									CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
								}
							}
							if (entity instanceof ServerPlayer) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
										|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Human";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Troll";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Goblin";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Swampmonster";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Werewolf";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
									{
										final String _tagName = "Type";
										final String _tagValue = "Vampire";
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
										{
											final String _tagName = "Type";
											final String _tagValue = "Human";
											CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
										{
											final String _tagName = "Type";
											final String _tagValue = "Werewolf";
											CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
										{
											final String _tagName = "Type";
											final String _tagValue = "Vampire";
											CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
										}
									}
								}
							}
						}
					}
				}
				if (entity instanceof HunterNPCEntity || entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity || entity instanceof HunterPatrolNPCEntity) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
									{
										Entity _ent = entityiterator;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Kills");
										if (_so == null)
											_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Kills", entityiterator) + 1);
									}
									MonstrousWorldMod.queueServerWork(20, () -> {
										if (getEntityScore("Kills", entityiterator) >= 30) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.FactionLevel = 4;
												_vars.markSyncDirty();
											}
											{
												Entity _ent = entityiterator;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Kills");
												if (_so == null)
													_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:monster_hunter_hunter"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You advance a level!"), false);
										}
									});
								}
							}
						}
					}
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}