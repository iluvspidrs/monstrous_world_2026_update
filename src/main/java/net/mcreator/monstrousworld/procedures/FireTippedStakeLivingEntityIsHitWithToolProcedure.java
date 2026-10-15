package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class FireTippedStakeLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
					if (entity.getPersistentData().getBoolean("vampire") == true || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
						if (entity.getRemainingFireTicks() == 0) {
							if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MonstrousWorldModMobEffects.HOLY_DAMAGE)) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
									entity.igniteForSeconds(10);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.burn")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.burn")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 3, 3, 3, 1);
									MonstrousWorldMod.queueServerWork(20, () -> {
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 100);
										for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 3); _i1++) {
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.VAMPIRE_ASH.get()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
										}
									});
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You don't have the skill to use this yet"), true);
								}
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Only Hunters can use this"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Only Hunters can use this"), true);
			}
		}
	}
}