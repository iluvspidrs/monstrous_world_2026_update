package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FeralWerewolfEatsProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getItem());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.has(DataComponents.FOOD)) {
				if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/raw_meat")))) {
					if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/cooked_meat")))) {
						if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/cooked_fish")))) {
							if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/raw_fish")))) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
									if (world.dimensionType().moonPhase(world.dayTime()) != 0 || MonstrousWorldModVariables.TimeUntilNight > 0) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel >= 3) {
											if (entity instanceof Player _player)
												_player.getFoodData().setFoodLevel(7);
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You only eat meat! You transform and go on the hunt!"), false);
											if (entity instanceof LivingEntity _entity)
												_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
											entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
											entity.getPersistentData().putBoolean("can_kill_maniac", true);
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											{
												Entity _entity = entity;
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
												}
											}
											{
												Entity _entity = entity;
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
												}
											}
											{
												Entity _entity = entity;
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
												}
											}
											{
												Entity _entity = entity;
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
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
		}
	}
}