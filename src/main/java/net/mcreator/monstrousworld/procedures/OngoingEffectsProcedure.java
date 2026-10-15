package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OngoingEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Zombify == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.LOOMING_UNDEATH, 220, 0));
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel >= 1 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel <= 11) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.BLOOD_RECOVERY))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_RECOVERY, 24000, 0));
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Slower_Movement == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SLOW_ESCAPE, 220, 0));
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
					if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("monstrous_world:spooky")))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.NO_DEFENSE, 220, 0));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).More_Nightmares == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MORE_NIGHTMARES, 220, 0));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
						if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("monstrous_world:nightmare"))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1));
						}
					}
				}
			}
			if (getEntityScore("Night Vision", entity) == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
			}
			if (entity.getPersistentData().getDouble("lev_possessed") >= 1) {
				entity.getPersistentData().putDouble("lev_possessed", (entity.getPersistentData().getDouble("lev_possessed") - 1));
				if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MonstrousWorldModMobEffects.POSSESSED))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.POSSESSED, getEntityScore("lev_possessed", entity), 0));
				}
			}
			if (entity.getPersistentData().getDouble("dark_possessed") >= 1) {
				entity.getPersistentData().putDouble("dark_possessed", (entity.getPersistentData().getDouble("dark_possessed") - 1));
				if (!(entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MonstrousWorldModMobEffects.POSSESSED_2))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.POSSESSED_2, getEntityScore("dark_possessed", entity), 0));
				}
			}
			if (entity.getPersistentData().getDouble("insanity_timer") >= 1) {
				entity.getPersistentData().putDouble("insanity_timer", (entity.getPersistentData().getDouble("insanity_timer") - 1));
				if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(MonstrousWorldModMobEffects.INSANITY))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.INSANITY, getEntityScore("insanity_timer", entity), 0));
				}
			}
			if (entity.getPersistentData().getDouble("just_transformed") >= 1) {
				entity.getPersistentData().putDouble("just_transformed", (entity.getPersistentData().getDouble("just_transformed") - 1));
			}
			if (entity.getPersistentData().getBoolean("InCoffin") == true) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.COFFIN_BOTTOM.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 7));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 1));
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.BLINDNESS);
					entity.getPersistentData().putBoolean("InCoffin", false);
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 0, true, false));
			}
			if (entity.getPersistentData().getBoolean("inNightmare") == true) {
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("NightmareX"));
						double _ty = (entity.getPersistentData().getDouble("NightmareY"));
						double _tz = (entity.getPersistentData().getDouble("NightmareZ"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
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