package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import java.util.Comparator;

public class ManiacOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity TargetedEntity = null;
		TargetedEntity = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		if (!world.isClientSide()) {
			if (Math.random() >= 0.95) {
				if (TargetedEntity != null) {
					if (TargetedEntity instanceof ServerPlayer) {
						if (TargetedEntity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10 || TargetedEntity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
							if (!(entity.getPersistentData().getString("AngryAt")).equals(TargetedEntity.getDisplayName().getString())) {
								if (entity instanceof Mob) {
									try {
										((Mob) entity).setTarget(null);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
				if (!(!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
					if (!(!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
						entity.getPersistentData().putString("AngryAt", "None");
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
									if (!(getEntityGameType(entityiterator) == GameType.CREATIVE) && !(getEntityGameType(entityiterator) == GameType.SPECTATOR)) {
										if (!(entityiterator instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.INVISIBILITY))) {
											if ((entity.getPersistentData().getString("AngryAt")).equals("None")) {
												entity.getPersistentData().putString("AngryAt", (entityiterator.getDisplayName().getString()));
												if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
													_entity.setTarget(_ent);
											}
										}
									}
								}
							}
						} else {
							entity.getPersistentData().putString("AngryAt", "None");
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHAINSAW_WEAPON.get()) {
				if (entity.getPersistentData().getDouble("ChainsawTimer") == 0) {
					entity.getPersistentData().putDouble("ChainsawTimer", 250);
				}
				if (entity.getPersistentData().getDouble("ChainsawTimer") >= 1) {
					entity.getPersistentData().putDouble("ChainsawTimer", (entity.getPersistentData().getDouble("ChainsawTimer") - 1));
				}
				if (entity.getPersistentData().getDouble("ChainsawTimer") == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:chainsaw_rev")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:chainsaw_rev")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}