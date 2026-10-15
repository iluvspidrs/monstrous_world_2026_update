package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ConvertBlocksWithDustProcedure {
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
		boolean block_entity = false;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:soul_changeable")))) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_soil.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_soil.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, x, y, z, 5, 0, 1, 0, 1);
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:brrr"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LANTERN) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.SOUL_LANTERN.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAMPFIRE) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.SOUL_CAMPFIRE.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TORCH) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.SOUL_TORCH.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WALL_TORCH) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.SOUL_WALL_TORCH.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))
						&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks")))
						&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get())) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				} else {
					MonstrousWorldMod.queueServerWork(1, () -> {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))
									&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))
									&& !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:sandstone/blocks")))) {
									if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										if (entity instanceof LivingEntity _entity)
											_entity.swing(InteractionHand.MAIN_HAND, true);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
										}
										world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_SANDSTONE.get().defaultBlockState(), 3);
									}
								} else {
									if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										if (entity instanceof LivingEntity _entity)
											_entity.swing(InteractionHand.MAIN_HAND, true);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
										}
										world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_STONE.get().defaultBlockState(), 3);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:sandstone/stairs")))) {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_SANDSTONE_STAIRS.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									} else {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_STAIRS.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:sandstone/slabs")))) {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_SANDSTONE_SLAB.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									} else {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_SLAB.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("sandstone")) {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_SANDSTONE_WALL.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									} else {
										{
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_WALL.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:sand")))) {
								if (!("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("snow")) {
									if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
										if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
											}
											world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_DIRT.get().defaultBlockState(), 3);
										}
									}
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_GRAVEL.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_SAND.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe")))) {
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = MonstrousWorldModBlocks.ACTIVE_DARKENED_LOG.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Property<?> _propertyOld : _bso.getProperties()) {
											Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
											if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
												try {
													_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:planks")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_PLANKS.get().defaultBlockState(), 3);
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_SLAB.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Property<?> _propertyOld : _bso.getProperties()) {
											Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
											if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
												try {
													_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_STAIRS.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Property<?> _propertyOld : _bso.getProperties()) {
											Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
											if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
												try {
													_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Property<?> _propertyOld : _bso.getProperties()) {
											Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
											if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
												try {
													_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("fence_gate")) {
								if (event instanceof ICancellableEvent _cancellable) {
									_cancellable.setCanceled(true);
								}
								if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (entity instanceof LivingEntity _entity)
										_entity.swing(InteractionHand.MAIN_HAND, true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									}
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE_GATE.get().defaultBlockState();
										BlockState _bso = world.getBlockState(_bp);
										for (Property<?> _propertyOld : _bso.getProperties()) {
											Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
											if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
												try {
													_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
												} catch (Exception e) {
												}
										}
										world.setBlock(_bp, _bs, 3);
									}
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_LEAVES.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:pumpkin_traps")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								world.destroyBlock(BlockPos.containing(x, y, z), false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/moonstone")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/moonstone")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/malachite")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/malachite")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_MALACHITE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/tigers_eye")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/tigers_eye")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_TIGERS_EYE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/green_agate")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/green_agate")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_GREEN_AGATE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/blue_agate")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/blue_agate")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_BLUE_AGATE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/pale_agate")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/pale_agate")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_PALE_AGATE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/red_agate")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/red_agate")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_RED_AGATE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_CORRUPTED_CRYSTAL.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/black_onyx")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/black_onyx")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_ONYX.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/sardonyx")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/sardonyx")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_SARDONYX.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/nether_gem")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/nether_gem")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_NETHER_GEM.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/clear_quartz")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/clear_quartz")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_CLEAR_QUARTZ.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:raw_blocks/rose_quartz")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:storage_blocks/rose_quartz")))) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = MonstrousWorldModBlocks.CONCENTRATED_ROSE_QUARTZ.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 15, 1, 1, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					});
				}
			}
		}
	}
}