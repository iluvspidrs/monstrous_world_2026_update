package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DarkenBlocksWhenHitProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof ServerPlayer || entity instanceof Player) {
				if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4)) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
						if (Math.random() >= 0.8) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_stain_on_the_world"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))
										&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))
										&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
									if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sandstone/blocks")))) {
											world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_SANDSTONE.get().defaultBlockState(), 3);
										} else {
											world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_STONE.get().defaultBlockState(), 3);
										}
									}
								}
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									if (!("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("snow")) {
										if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
											if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
												world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState(), 3);
											}
											if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
												world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState(), 3);
											}
										}
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRAVEL) {
								world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_GRAVEL.get().defaultBlockState(), 3);
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
								world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_SAND.get().defaultBlockState(), 3);
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe")))) {
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
									world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_LOG.get().defaultBlockState(), 3);
								}
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:planks")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
										BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS.get().defaultBlockState();
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:fence_gates")))) {
									{
										BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
								world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.DARKENED_LEAVES.get().defaultBlockState(), 3);
							}
							if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:saplings")))
									|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:small_flowers")))
									|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:tall_flowers")))
									|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:warped_stems")))
									|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable_plants")))) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.DARKENED_BLOSSOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:saplings")))
									|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:small_flowers")))
									|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:tall_flowers")))
									|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:warped_stems")))
									|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable_plants")))) {
								world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.DARKENED_BLOSSOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock()).toString()).contains("pumpkin")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock()).toString()).contains("jack")) {
								world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_PUMPKIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:carrying_your_vengeance"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("pumpkin")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("jack")) {
								world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_PUMPKIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:carrying_your_vengeance"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("pumpkin")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("jack")) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_PUMPKIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:carrying_your_vengeance"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("skull")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("skeleton")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("bone")) {
								world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:raising_the_dead"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("skull")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("skeleton")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("bone")) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:raising_the_dead"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("body")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("remains")) {
								world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:raising_the_dead"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
							if (("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("body")
									|| ("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).contains("remains")) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SERVANT_SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Faction Points");
									if (_so == null)
										_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:raising_the_dead"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1 && getEntityScore("Faction Points", entity) >= 5) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Your connection to me grows\u2026throw my dark power by pressing [Y]\u2026"), false);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 2;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}