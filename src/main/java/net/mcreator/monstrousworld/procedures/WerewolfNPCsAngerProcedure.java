package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.HumanWerewolfEntity;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class WerewolfNPCsAngerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof HumanWerewolfEntity) {
			if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MALLET.get())) {
				entity.getPersistentData().putString("AngryAt", (sourceentity.getStringUUID()));
				if ((entity instanceof HumanWerewolfEntity _datEntI ? _datEntI.getEntityData().get(HumanWerewolfEntity.DATA_Skin) : 0) == 1) {
					entity.getPersistentData().putDouble("HumanWerewolf", 1);
				}
				if ((entity instanceof HumanWerewolfEntity _datEntI ? _datEntI.getEntityData().get(HumanWerewolfEntity.DATA_Skin) : 0) == 2) {
					entity.getPersistentData().putDouble("HumanWerewolf", 2);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MonstrousWorldModEntities.FOLLOWER_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof FollowerWerewolfEntity) {
							entityiterator.getPersistentData().putBoolean("Angry", true);
							entityiterator.getPersistentData().putString("AngryAt", (entity.getPersistentData().getString("AngryAt")));
							entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
							entityiterator.getPersistentData().putString("NoSoul", (entity.getPersistentData().getString("NoSoul")));
							entityiterator.getPersistentData().putString("UUID", (entity.getStringUUID()));
							if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							Entity _ent28 = entityiterator;
							if (!(_ent28 instanceof Player) && !_ent28.level().isClientSide())
								_ent28.setUUID(entity.getUUID());
							entityiterator.getPersistentData().putDouble("HumanWerewolf", (entity.getPersistentData().getDouble("HumanWerewolf")));
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}