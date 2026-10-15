package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.ChangelingEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class BabyVillagerFollowsProcedure {
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
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WISP_LANTERN.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WISP_LANTERN.get()) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Villager) {
								if (entityiterator instanceof LivingEntity _livEnt8 && _livEnt8.isBaby()) {
									if (!(entity.getDisplayName().getString()).equals(entityiterator.getPersistentData().getString("Owner"))) {
										if (!world.getEntitiesOfClass(ChangelingEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty()) {
											if (getEntityScore("kidnap_number", entity) >= 1) {
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("kidnap_number");
													if (_so == null)
														_so = _sc.addObjective("kidnap_number", ObjectiveCriteria.DUMMY, Component.literal("kidnap_number"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("kidnap_number", entity) - 1);
												}
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Baby villager enchanted! Lead it back to a goblin village..."), false);
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 5;
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
												}
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("You must leave a changeling nearby before capturing a baby villager"), true);
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("There must be a changeling nearby to kidnap a baby villager"), true);
										}
									}
									if ((entity.getDisplayName().getString()).equals(entityiterator.getPersistentData().getString("Owner"))) {
										if (entityiterator instanceof Mob _entity)
											_entity.getNavigation().moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 1);
										if (entityiterator instanceof AgeableMob _ageable)
											_ageable.setAge(-200000);
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}