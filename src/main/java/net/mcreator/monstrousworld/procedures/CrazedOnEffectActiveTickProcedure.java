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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CrazedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
			{
				Entity _ent = entity;
				_ent.setYRot(Mth.nextInt(RandomSource.create(), 0, 359));
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity.onGround()) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) > 900) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y + 0.5);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) > 600) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y + 1);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) > 300) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z))) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y + 2);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				} else {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z))) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y + 3);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) == 900) {
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1, false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You gasp for breath but cannot stop..."), false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) == 600) {
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1, false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("The bones in your feet break..."), false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) == 300) {
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1, false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your heart races faster and faster..."), false);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CRAZED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CRAZED).getDuration() : 0) == 1) {
				if (world instanceof Level)
					((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1, false);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 200);
				for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 4); _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ESSENCE_OF_ENCHANTMENT.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}