package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class OnEntitySpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof EyeletEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:ill_be_watching_you"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
				entity.getPersistentData().putDouble("BloodLevel", 12);
				if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
					if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:altered_human")))) {
						entity.getPersistentData().putBoolean("victim", true);
					} else {
						entity.getPersistentData().putBoolean("victim", true);
					}
				} else {
					entity.getPersistentData().putBoolean("victim", false);
				}
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:nonhuman_being"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
				if (!(entity instanceof VampireNPCEntity)) {
					entity.getPersistentData().putDouble("BloodLevel", 12);
					entity.getPersistentData().putBoolean("victim", false);
				}
			}
			if (entity.getType().is(EntityTypeTags.UNDEAD)) {
				entity.getPersistentData().putDouble("BloodLevel", (-1));
			}
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:robot")))) {
				entity.getPersistentData().putDouble("BloodLevel", 12);
			} else if (entity instanceof Animal) {
				if (!entity.getType().is(EntityTypeTags.UNDEAD)) {
					entity.getPersistentData().putDouble("BloodLevel", (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
				}
			}
			if (entity instanceof MadScientistNPCEntity) {
				entity.getPersistentData().putDouble("Reputation", (-5));
				entity.getPersistentData().putDouble("Vampire Type", 1);
			}
			if (entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity || entity instanceof InfectedGoonEntity) {
				entity.getPersistentData().putDouble("Reputation", 5);
				entity.getPersistentData().putDouble("Vampire Type", 2);
			}
			if (entity instanceof Witch1Entity) {
				entity.getPersistentData().putDouble("Reputation", (-10));
				entity.getPersistentData().putDouble("Vampire Type", 3);
			}
			if (entity instanceof SorcererNPCEntity) {
				entity.getPersistentData().putDouble("Reputation", (-10));
				entity.getPersistentData().putDouble("Vampire Type", 4);
			}
			if (entity instanceof WanderingTrader) {
				entity.getPersistentData().putDouble("Reputation", (-20));
				entity.getPersistentData().putDouble("Vampire Type", 8);
			}
			if (entity instanceof Villager) {
				entity.getPersistentData().putDouble("Reputation", (-20));
				entity.getPersistentData().putDouble("Vampire Type", 9);
			}
			if (entity instanceof FeralVampireEntity) {
				entity.getPersistentData().putDouble("Reputation", 10);
				entity.getPersistentData().putDouble("Vampire Type", 10);
			}
			if (entity instanceof Pillager) {
				entity.getPersistentData().putDouble("Reputation", 5);
				entity.getPersistentData().putDouble("Vampire Type", 11);
			}
			if (entity instanceof Vindicator) {
				entity.getPersistentData().putDouble("Reputation", 15);
				entity.getPersistentData().putDouble("Vampire Type", 12);
			}
			if (entity instanceof Evoker) {
				entity.getPersistentData().putDouble("Reputation", 15);
				entity.getPersistentData().putDouble("Vampire Type", 13);
			}
			if (entity instanceof Illusioner) {
				entity.getPersistentData().putDouble("Reputation", 15);
				entity.getPersistentData().putDouble("Vampire Type", 14);
			}
			if (entity instanceof Witch) {
				entity.getPersistentData().putDouble("Reputation", 10);
				entity.getPersistentData().putDouble("Vampire Type", 15);
			}
			if (entity instanceof HunterNPCEntity) {
				entity.getPersistentData().putDouble("Reputation", (-30));
			}
			if (entity instanceof SwampmonsterVillagerEntity) {
				entity.getPersistentData().putDouble("Reputation", (-10));
			}
			if (entity instanceof SwampmonsterChieftanEntity) {
				entity.getPersistentData().putDouble("Reputation", (-20));
			}
			if (entity instanceof InfectedGoonEntity) {
				entity.getPersistentData().putDouble("Reputation", 5);
			}
			if (entity instanceof FeralSwampmonsterEntity) {
				entity.getPersistentData().putDouble("Reputation", 10);
				if (Math.random() >= 0.95) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.MURKANUS_WORM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
			}
			if (entity instanceof FeralGoblinEntity) {
				entity.getPersistentData().putDouble("Reputation", 10);
			}
			if (entity instanceof FeralWerewolfEntity) {
				entity.getPersistentData().putDouble("Reputation", 10);
			}
			if (entity instanceof HumanWerewolfEntity) {
				entity.getPersistentData().putDouble("Reputation", (-15));
			}
			if (entity instanceof GoblinFollowerEntity) {
				entity.getPersistentData().putDouble("Reputation", (-15));
			}
			if (entity instanceof DemonNPCEntity) {
				entity.getPersistentData().putDouble("Reputation", 20);
			}
			if (entity instanceof EvilClown1Entity) {
				entity.getPersistentData().putDouble("Reputation", 10);
			}
			if (entity instanceof EvilClown2Entity) {
				entity.getPersistentData().putDouble("Reputation", 10);
			}
			if (entity instanceof EvilClown3Entity) {
				entity.getPersistentData().putDouble("Reputation", 10);
			}
			if (entity instanceof ManiacEntity) {
				entity.getPersistentData().putDouble("Reputation", 30);
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (Math.random() < 0.33) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(MonstrousWorldModItems.HOCKEY_MASK_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstrousWorldModItems.HOCKEY_MASK_HELMET.get()));
							}
						}
					} else if (Math.random() < 0.66) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(MonstrousWorldModItems.SKULL_MASK_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstrousWorldModItems.SKULL_MASK_HELMET.get()));
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(MonstrousWorldModItems.BUNNY_MASK_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstrousWorldModItems.BUNNY_MASK_HELMET.get()));
							}
						}
					}
					if (Math.random() < 0.33) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack100 = new ItemStack(MonstrousWorldModItems.BUTCHER_KNIFE.get()).copy();
							_setstack100.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack100);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (Math.random() < 0.66) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack101 = new ItemStack(Items.NETHERITE_AXE).copy();
							_setstack101.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack101);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack102 = new ItemStack(MonstrousWorldModItems.CHAINSAW_WEAPON.get()).copy();
							_setstack102.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack102);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((entity instanceof ManiacEntity _datEntI ? _datEntI.getEntityData().get(ManiacEntity.DATA_Trade) : 0) == 0) {
						if (entity instanceof ManiacEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ManiacEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 3));
					}
				}
				if (MonstrousWorldConfigConfiguration.DISPLAY_MANIAC_WARNING.get() == true) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof ServerPlayer) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A74A Maniac has entered the area!"), false);
							}
						}
					}
				}
			}
		}
	}
}