package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class BloodFocusOnBlockRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.BLOOD_FOCUS.get()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip3 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip3) : -1) == 0) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 1;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack13 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack13.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 2;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack25 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack25.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack25);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 3;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack37 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack37.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack37);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack49 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack49.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack49);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 5;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack61 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack61.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack61);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 6;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack73 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack73.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack73);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 7;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack85 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack85.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack85);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 8;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack97 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack97.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack97);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip101 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip101) : -1) == 1) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack111 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack111.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack111);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl117 && _lvl117.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 9;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack128 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack128.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack128);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
											if (getEntityScore("Amulet Placed", entity) == 0) {
												{
													Entity _ent = entity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Amulet Placed");
													if (_so == null)
														_so = _sc.addObjective("Amulet Placed", ObjectiveCriteria.DUMMY, Component.literal("Amulet Placed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
												}
											}
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip136 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip136) : -1) == 2) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack146 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack146.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack146);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl152 && _lvl152.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 10;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack163 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack163.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack163);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip169 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip169) : -1) == 3) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack179 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack179.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack179);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl185 && _lvl185.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 11;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack196 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack196.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack196);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip202 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip202) : -1) == 4) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack212 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack212.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack212);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl218 && _lvl218.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 12;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack229 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack229.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack229);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip235 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip235) : -1) == 5) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack245 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack245.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack245);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl251 && _lvl251.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 13;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack262 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack262.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack262);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip268 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip268) : -1) == 6) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack278 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack278.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack278);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl284 && _lvl284.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 14;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack293 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack293.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack293);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip301 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip301) : -1) == 7) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack311 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack311.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack311);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl317 && _lvl317.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 15;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											if (entity instanceof LivingEntity _entity)
												_entity.swing(InteractionHand.MAIN_HAND, true);
											if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
												if (entity instanceof LivingEntity _entity) {
													ItemStack _setstack326 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
													_setstack326.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
													_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack326);
													if (_entity instanceof Player _player)
														_player.getInventory().setChanged();
												}
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip334 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip334) : -1) == 8) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									int _value = 0;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack344 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack344.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack344);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (entity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							});
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_AMULET.get()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (!(world instanceof Level _lvl350 && _lvl350.isDay())) {
									if (!world.getLevelData().isRaining()) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.place")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												int _value = 16;
												BlockPos _pos = BlockPos.containing(x, y, z);
												BlockState _bs = world.getBlockState(_pos);
												if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
													world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.CLEAR_AMULET.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 1200));
										});
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Moonlight is needed for the infusion..."), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("An open sky is needed for the infusion..."), true);
							}
						}
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Only a first generation Vampire can use this"), true);
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}