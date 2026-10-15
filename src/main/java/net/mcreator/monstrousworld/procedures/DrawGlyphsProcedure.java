package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DrawGlyphsProcedure {
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
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:chalk")))) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("This baffles you"), false);
						} else {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BASIC_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RED_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ORANGE_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 6, 8))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GOLDEN_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 9, 11))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GREEN_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 12, 14))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLUE_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 15, 17))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURPLE_CHALK.get()) {
								if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
											|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
										world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 18, 20))), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
												.setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
									}
								}
							}
						}
					} else {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BASIC_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 0, 2))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RED_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 3, 5))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ORANGE_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 6, 8))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GOLDEN_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 9, 11))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GREEN_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 12, 14))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLUE_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 15, 17))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURPLE_CHALK.get()) {
							if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
								if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
									world.setBlock(BlockPos.containing(x, y + 1, z), (blockStateWithInt(MonstrousWorldModBlocks.WHITE_GLYPH.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 18, 20))), 3);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() + 1);
								}
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You aren't sure what to draw with this"), false);
				}
			}
		}
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}
}