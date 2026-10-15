package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class VillagerConvertsToZombieProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Villager) {
			if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 10) {
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.ARMORER) {
						entity.getPersistentData().putString("VJob", "armorer");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FARMER) {
						entity.getPersistentData().putString("VJob", "farmer");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
						entity.getPersistentData().putString("VJob", "librarian");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
						entity.getPersistentData().putString("VJob", "cartographer");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
						entity.getPersistentData().putString("VJob", "fletcher");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
						entity.getPersistentData().putString("VJob", "butcher");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CLERIC) {
						entity.getPersistentData().putString("VJob", "cleric");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
						entity.getPersistentData().putString("VJob", "leatherworker");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
						entity.getPersistentData().putString("VJob", "fisherman");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.MASON) {
						entity.getPersistentData().putString("VJob", "mason");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
						entity.getPersistentData().putString("VJob", "weaponsmith");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
						entity.getPersistentData().putString("VJob", "shepherd");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
						entity.getPersistentData().putString("VJob", "toolsmith");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.NITWIT) {
						entity.getPersistentData().putString("VJob", "nitwit");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.NONE) {
						entity.getPersistentData().putString("VJob", "none");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.PLAINS) {
						entity.getPersistentData().putString("VBiome", "plains");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.TAIGA) {
						entity.getPersistentData().putString("VBiome", "taiga");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.DESERT) {
						entity.getPersistentData().putString("VBiome", "desert");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.JUNGLE) {
						entity.getPersistentData().putString("VBiome", "jungle");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.SAVANNA) {
						entity.getPersistentData().putString("VBiome", "savanna");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.SNOW) {
						entity.getPersistentData().putString("VBiome", "snow");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 1) {
						entity.getPersistentData().putString("VStage", "1");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 2) {
						entity.getPersistentData().putString("VStage", "2");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 3) {
						entity.getPersistentData().putString("VStage", "3");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 4) {
						entity.getPersistentData().putString("VStage", "4");
					}
					if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 5) {
						entity.getPersistentData().putString("VStage", "5");
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 9) {
					entity.getPersistentData().putString("xx", ("" + entity.getX()));
					entity.getPersistentData().putString("yy", ("" + entity.getY()));
					entity.getPersistentData().putString("zz", ("" + entity.getZ()));
					entity.getPersistentData().putString("spawnlocation", "xx yy zz");
					entity.getPersistentData().putString("villagerdata", "location {VillagerData:{type:biome,profession:job,level:number,age:-1,persistenceRequired:1b}}");
					MonstrousWorldMod.queueServerWork(1, () -> {
						entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
					});
					MonstrousWorldMod.queueServerWork(2, () -> {
						entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
					});
					MonstrousWorldMod.queueServerWork(3, () -> {
						entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
					});
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 5) {
					entity.getPersistentData().putString("villagerdata", ((entity.getPersistentData().getString("villagerdata")).replace("location", entity.getPersistentData().getString("spawnlocation"))));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 4) {
					entity.getPersistentData().putString("villagerdata", ((entity.getPersistentData().getString("villagerdata")).replace("biome", entity.getPersistentData().getString("VBiome"))));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 3) {
					entity.getPersistentData().putString("villagerdata", ((entity.getPersistentData().getString("villagerdata")).replace("job", entity.getPersistentData().getString("VJob"))));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 2) {
					entity.getPersistentData().putString("villagerdata", ((entity.getPersistentData().getString("villagerdata")).replace("number", entity.getPersistentData().getString("VStage"))));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0) == 1) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/summon zombie_villager details".replace("details", entity.getPersistentData().getString("villagerdata"))));
						}
					}
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.toList()) {
								if (entityiterator instanceof ZombieVillager) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands()
													.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
															_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															("data merge entity placeholder {CustomName:' \"  \" '}".replace("placeholder", "" + entityiterator.getStringUUID())));
										}
									}
								}
							}
						}
					});
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (!entity.level().isClientSide())
							entity.discard();
					});
				}
			}
		}
	}
}