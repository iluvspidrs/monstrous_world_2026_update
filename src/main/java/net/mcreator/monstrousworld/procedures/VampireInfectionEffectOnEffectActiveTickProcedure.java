package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.Witch1Entity;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class VampireInfectionEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 67000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("The bite on your neck stops hurting so much..."), false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 60000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You feel off somehow..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 54000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74A cold dread grows within..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 48000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You feel chilled as your dread increases..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 42000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Something's wrong and you can't sleep at night..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 36000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Food begins to taste like ash..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 30000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You gag on food and fear where this is going..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 24000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You start feeling unwell in the sun..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 18000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You are desperate for help..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) < 24000) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) >= 12000) {
					if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (!world.getLevelData().isRaining()) {
							if (world instanceof Level _lvl32 && _lvl32.isDay()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0));
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) >= 1) {
					if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (!world.getLevelData().isRaining()) {
							if (world instanceof Level _lvl37 && _lvl37.isDay()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 12000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Your teeth feel like they are shifting..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 6000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74A strange thirst begins to build..."), false);
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 1) {
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.ZombieInfection = 0;
					_vars.Possession = 0;
					_vars.Zombify = 0;
					_vars.MonsterType = 6;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putDouble("fear_countdown", 0);
				entity.getPersistentData().putDouble("lev_possessed", 0);
				entity.getPersistentData().putDouble("dark_possessed", 0);
				entity.getPersistentData().putDouble("insanity_timer", 0);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterInfectable = false;
					_vars.DarknessInfectable = false;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putBoolean("Monstrous World Vampire", true);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"), 0.5, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"), 3, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"), 15, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74The thirst has overtaken you..."), false);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure yourself..."), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:every_hunters_worst_nightmare"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				MonstrousWorldMod.queueServerWork(1, () -> {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.BloodBar = 20;
						_vars.Bloodlevel = -1;
						_vars.markSyncDirty();
					}
				});
			}
		} else {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0) == 1) {
					if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
						if (!(entity instanceof HunterNPCEntity) && !(entity instanceof HunterPatrolNPCEntity)) {
							entity.getPersistentData().putBoolean("vampire", true);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 20000, 0, true, false));
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirehealth"), 10, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirespeed"), 0.1, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
							if (entity instanceof Witch1Entity) {
								if (entity instanceof Witch1Entity _datEntSetL)
									_datEntSetL.getEntityData().set(Witch1Entity.DATA_Vampire, true);
							}
							if (entity instanceof SorcererNPCEntity) {
								if (entity instanceof SorcererNPCEntity _datEntSetL)
									_datEntSetL.getEntityData().set(SorcererNPCEntity.DATA_Vampire, true);
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setXRot(entity.getXRot());
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof FeralVampireEntity) {
										if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 1
												|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 1) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 4);
										}
										if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 2
												|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 2) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 5);
										}
										if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 3
												|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 3) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 6);
										}
										if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 4
												|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 4) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 7);
										}
										if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 5
												|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 5) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 8);
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
								}
							}
						}
					}
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
		}
		if (entity.getPersistentData().getBoolean("vampire") == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
		}
	}
}