package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class UndeadCureActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.UNDEAD_CURE) ? _livEnt.getEffect(MonstrousWorldModMobEffects.UNDEAD_CURE).getDuration() : 0) == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("team_undead");
						if (_pt != null)
							_level.getScoreboard().removePlayerTeam(_pt);
					}
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterType = 0;
						_vars.Reputation = 0;
						_vars.markSyncDirty();
					}
					MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = 5;
					MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"));
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are no longer a zombie!"), false);
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74Your place in the Hunter's Guild is restored!"), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = true;
							_vars.DarknessInfectable = true;
							_vars.markSyncDirty();
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = true;
							_vars.DarknessInfectable = true;
							_vars.markSyncDirty();
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
							|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
							|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = true;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
	}
}