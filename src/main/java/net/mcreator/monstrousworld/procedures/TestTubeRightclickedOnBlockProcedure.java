package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import java.util.Comparator;

public class TestTubeRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GLOWSTONE) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(MonstrousWorldModItems.GLOWSTONE_SAMPLE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack10 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
						_setstack10.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack10);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_BLOCK) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(MonstrousWorldModItems.REDSTONE_SAMPLE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack20 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
						_setstack20.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack20);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, (y + 1), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof ItemEntity) {
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
								for (int _i1 = 0; _i1 < (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getCount(); _i1++) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof LivingEntity _entity) {
											ItemStack _setstack31 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack31.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
											_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack31);
											if (_entity instanceof Player _player)
												_player.getInventory().setChanged();
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.DARKNESS_SAMPLE.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (!entityiterator.level().isClientSide())
										entityiterator.discard();
								}
							}
						}
					}
				}
			}
		}
	}
}