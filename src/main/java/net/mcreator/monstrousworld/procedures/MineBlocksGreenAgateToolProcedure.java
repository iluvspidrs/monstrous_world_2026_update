package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class MineBlocksGreenAgateToolProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:green_agate_tool")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z))))) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:precious_stone_ores")))) {
						if (Math.random() > 0.25) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ItemEntity) {
											if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones")))) {
												if (!(entityiterator.getPersistentData().getBoolean("doubled") == true)) {
													entityiterator.getPersistentData().putBoolean("doubled", true);
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
													});
												}
											}
										}
									}
								}
							});
						}
					} else {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MODIFIED_SWAMP_CRYSTAL_SHOVEL_GREEN_AGATE.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ItemEntity) {
											if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_items")))) {
												if (!(entityiterator.getPersistentData().getBoolean("doubled") == true)) {
													entityiterator.getPersistentData().putBoolean("doubled", true);
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
													});
												}
											}
										}
									}
								}
							});
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z))))) {
					if (Math.random() > 0.5) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof ItemEntity) {
										if (!(entityiterator.getPersistentData().getBoolean("doubled") == true)) {
											entityiterator.getPersistentData().putBoolean("doubled", true);
											MonstrousWorldMod.queueServerWork(1, () -> {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
											});
										}
									}
								}
							}
						});
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:nether_tool")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x, y, z))))) {
				if (!entity.isShiftKeyDown()) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof ItemEntity) {
									if (world instanceof Level _level57
											&& _level57.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY)), _level57).isPresent()) {
										if (!(entityiterator.getPersistentData().getBoolean("doubled") == true)) {
											entityiterator.getPersistentData().putBoolean("doubled", true);
											MonstrousWorldMod.queueServerWork(1, () -> {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5),
															(world instanceof Level _lvlSmeltResult
																	? _lvlSmeltResult.getRecipeManager()
																			.getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY)), _lvlSmeltResult)
																			.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
																	: ItemStack.EMPTY));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											});
										}
									}
								}
							}
						}
					});
				}
			}
		}
	}
}