package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.EnhancedZombieEntity;
import net.mcreator.monstrousworld.entity.EnhancedHuskEntity;
import net.mcreator.monstrousworld.entity.EnhancedDrownedEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class EnhancedZombieEquipsProcedure {
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
		if (entity instanceof EnhancedZombieEntity || entity instanceof EnhancedDrownedEntity || entity instanceof EnhancedHuskEntity) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.UNDEAD_GLOW, 12000, 1));
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Zombie || entityiterator instanceof Drowned || entityiterator instanceof Husk) {
						entity.getPersistentData().putString("Owner", (entityiterator.getPersistentData().getString("Owner")));
						if (!(entityiterator.getDisplayName().getString()).equals("Zombie")) {
							if (!(entityiterator.getDisplayName().getString()).equals("Enhanced Zombie")) {
								if (!(entityiterator.getDisplayName().getString()).equals("Enhanced Husk")) {
									if (!(entityiterator.getDisplayName().getString()).equals("Enhanced Drowned")) {
										if (!(entityiterator.getDisplayName().getString()).equals("Husk")) {
											if (!(entityiterator.getDisplayName().getString()).equals("Drowned")) {
												entity.setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
											}
										}
									}
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ItemEntity) {
						for (int _i1 = 0; _i1 < ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getCount(); _i1++) {
							if ((entityiterator.getDisplayName().getString()).contains("Boots")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_BOOTS.get())) {
									if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get())) {
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(0, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.FEET, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											}
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Leggings")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_LEGGINGS.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Pants")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Chestplate")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Tunic")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Coat")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_CHESTPLATE.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Robe")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Helmet")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_HELMET.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Hat") && ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() instanceof ArmorItem) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_HELMET.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Cap") && ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() instanceof ArmorItem) {
								if (!(((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() == MonstrousWorldModItems.BRAIN.get())) {
									if (!(((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() == MonstrousWorldModItems.FLESH_OF_THE_LIVING.get())) {
										if (entity instanceof LivingEntity _entity) {
											ItemStack _setstack85 = ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).copy();
											_setstack85.setCount(1);
											_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack85);
											if (_entity instanceof Player _player)
												_player.getInventory().setChanged();
										}
									}
								}
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
		if (entity instanceof Zombie || entity instanceof Drowned || entity instanceof Husk) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof EnhancedZombieEntity || entityiterator instanceof EnhancedDrownedEntity || entityiterator instanceof EnhancedHuskEntity) {
						entity.getPersistentData().putString("Owner", (entityiterator.getPersistentData().getString("Owner")));
						entityiterator.getPersistentData().putBoolean("PersistenceRequired", true);
						entity.setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
						entity.getPersistentData().putDouble("PersistenceRequired", 1);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ItemEntity) {
						for (int _i1 = 0; _i1 < ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getCount(); _i1++) {
							if ((entityiterator.getDisplayName().getString()).contains("Boots")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_BOOTS.get())) {
									if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get())) {
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(0, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.FEET, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											}
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Leggings")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_LEGGINGS.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Pants")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Chestplate")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Coat")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_CHESTPLATE.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Tunic")) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Hat")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_HELMET.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Helmet")) {
								if (!((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_HELMET.get())) {
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										}
									}
								}
							}
							if ((entityiterator.getDisplayName().getString()).contains("Cap") && ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() instanceof ArmorItem) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
									}
								}
							}
							if (!(((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() instanceof ArmorItem)) {
								if (!(((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() == MonstrousWorldModItems.BRAIN.get())) {
									if (!(((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).getItem() == MonstrousWorldModItems.FLESH_OF_THE_LIVING.get())) {
										if (entity instanceof LivingEntity _entity) {
											ItemStack _setstack167 = ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()).copy();
											_setstack167.setCount(1);
											_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack167);
											if (_entity instanceof Player _player)
												_player.getInventory().setChanged();
										}
									}
								}
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
	}
}