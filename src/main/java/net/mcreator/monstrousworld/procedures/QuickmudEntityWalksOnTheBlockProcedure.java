package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class QuickmudEntityWalksOnTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6)) {
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:swamp_creature")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, true, false));
				{
					Entity _ent = entity;
					double _tx = (entity.getX());
					double _ty = (entity.getY() - 0.005);
					double _tz = (entity.getZ());
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}