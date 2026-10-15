package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PlaceTeleportGlyphProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 3) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1)) && world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1))) {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z)) || world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z + 1)) || world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z - 1))) {
							if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z)) || world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z + 1)) || world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z - 1))) {
								if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
										&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
									if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
											&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
											&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
										if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
											if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
													&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()
													&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get()) {
												if ((entity.level().dimension()) == Level.OVERWORLD) {
													if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("ritual_wand")) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.CENTER_GLYPH.get().defaultBlockState(), 3);
														if (!world.isClientSide()) {
															BlockPos _bp = BlockPos.containing(x, y + 1, z);
															BlockEntity _blockEntity = world.getBlockEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_blockEntity != null) {
																_blockEntity.getPersistentData().putString("Glyph_Type", "Teleportation");
															}
															if (world instanceof Level _level)
																_level.sendBlockUpdated(_bp, _bs, _bs, 3);
														}
													} else {
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You must use a Ritual Wand to complete this"), false);
													}
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Teleportation Circles only work in the overworld!"), false);
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Teleportation")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(MonstrousWorldModItems.PEBBLE.get()));
					entityToSpawn.setPickUpDelay(15);
					_level.addFreshEntity(entityToSpawn);
				}
				MonstrousWorldMod.queueServerWork(1, () -> {
					entity.getPersistentData().putString("location", "x y z");
				});
				MonstrousWorldMod.queueServerWork(2, () -> {
					entity.getPersistentData().putString("x", (new java.text.DecimalFormat("##.##").format(entity.getX())));
				});
				MonstrousWorldMod.queueServerWork(3, () -> {
					entity.getPersistentData().putString("y", (new java.text.DecimalFormat("##.##").format(entity.getY())));
				});
				MonstrousWorldMod.queueServerWork(4, () -> {
					entity.getPersistentData().putString("z", (new java.text.DecimalFormat("##.##").format(entity.getZ())));
				});
				MonstrousWorldMod.queueServerWork(5, () -> {
					entity.getPersistentData().putString("location", ((entity.getPersistentData().getString("location")).replace("x", entity.getPersistentData().getString("x"))));
				});
				MonstrousWorldMod.queueServerWork(6, () -> {
					entity.getPersistentData().putString("location", ((entity.getPersistentData().getString("location")).replace("y", entity.getPersistentData().getString("y"))));
				});
				MonstrousWorldMod.queueServerWork(7, () -> {
					entity.getPersistentData().putString("location", ((entity.getPersistentData().getString("location")).replace("z", entity.getPersistentData().getString("z"))));
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof ItemEntity) {
								if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PEBBLE.get()) {
									{
										final String _tagName = "location";
										final String _tagValue = (entity.getPersistentData().getString("location"));
										CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
									}
								}
							}
						}
					}
				});
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}