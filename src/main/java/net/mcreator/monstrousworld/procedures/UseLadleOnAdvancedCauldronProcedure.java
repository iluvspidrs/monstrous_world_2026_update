package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UseLadleOnAdvancedCauldronProcedure {
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
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ADVANCED_CAULDRON.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
					if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) == 1) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagickalCatalyst") == 1) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldenCarrot") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WitherRose") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Obstruction");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 8;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Frogspawn") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "LilyPad") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slimeball") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Frogify");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 2;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanosusPlant") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Spirit");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 7;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IronChain") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanosusPlant") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Sinking");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 6;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FingerGrass") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Paralysis");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 7;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MoonDust") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "LunarBloom") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "WerewolfCure");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 9;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BottleOfBlood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "VampireCure");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 5;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UndeathlyEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "UndeathCure");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 2;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Leather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 4) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FingerGrass") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.ANOINTMENT_OIL.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagicallyTreatedLeather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BAG_OF_SPIRITUAL_HOLDING.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UndeathlyEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.DEATHLY_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.SPIRITUAL_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.AUTUMNAL_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PureDarkEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.DARK_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.RICH_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										int _value = 0;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.UNSTABLE_INK.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RatTail") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WitherRose") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Vanishing");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 5;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IronChain") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Midas");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 3;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadMoth") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Chickenify");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 11;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RatTail") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpessPlant") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinSapling") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Pumpkin");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 4;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Firecane") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadMoth") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Explosion");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 9;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagicallyTreatedLeather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Bookish");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 11;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CaptiveSpirit") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CultivatedPumpkinEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PureDarkEssence") == 1
										&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BatWing") == 1) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Flight");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									{
										int _value = 7;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								} else {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putString("Powder", "Ruined");
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Brew failed"), true);
									{
										int _value = 10;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(4, ItemStack.EMPTY);
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
										_itemHandlerModifiable.setStackInSlot(5, ItemStack.EMPTY);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("MagicallyTreatedLeather", 0);
											_blockEntity.getPersistentData().putDouble("Spiritflower", 0);
											_blockEntity.getPersistentData().putDouble("VileLattice", 0);
											_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
											_blockEntity.getPersistentData().putDouble("Deathcatcher", 0);
											_blockEntity.getPersistentData().putDouble("FingerGrass", 0);
											_blockEntity.getPersistentData().putDouble("Frogspawn", 0);
											_blockEntity.getPersistentData().putDouble("Lilypad", 0);
											_blockEntity.getPersistentData().putDouble("Slimeball", 0);
											_blockEntity.getPersistentData().putDouble("InkSac", 0);
											_blockEntity.getPersistentData().putDouble("GoldenCarrot", 0);
											_blockEntity.getPersistentData().putDouble("InsanityEssence", 0);
											_blockEntity.getPersistentData().putDouble("UndeathlyEssence", 0);
											_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
											_blockEntity.getPersistentData().putDouble("MoonDust", 0);
											_blockEntity.getPersistentData().putDouble("BottleOfBlood", 0);
											_blockEntity.getPersistentData().putDouble("WitherRose", 0);
											_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
											_blockEntity.getPersistentData().putDouble("IronChain", 0);
											_blockEntity.getPersistentData().putDouble("LunarBloom", 0);
											_blockEntity.getPersistentData().putDouble("Leather", 0);
											_blockEntity.getPersistentData().putDouble("DigestedFood", 0);
											_blockEntity.getPersistentData().putDouble("VenomBottle", 0);
											_blockEntity.getPersistentData().putDouble("DreadfulTears", 0);
											_blockEntity.getPersistentData().putDouble("GoldDust", 0);
											_blockEntity.getPersistentData().putDouble("SilverDust", 0);
											_blockEntity.getPersistentData().putDouble("BatWing", 0);
											_blockEntity.getPersistentData().putDouble("SwampWort", 0);
											_blockEntity.getPersistentData().putDouble("GhostlyApple", 0);
											_blockEntity.getPersistentData().putDouble("PumpkinEssence", 0);
											_blockEntity.getPersistentData().putDouble("PumpkinSapling", 0);
											_blockEntity.getPersistentData().putDouble("RatTail", 0);
											_blockEntity.getPersistentData().putDouble("DreadMoth", 0);
											_blockEntity.getPersistentData().putDouble("CultivatedPumpkinEssence", 0);
											_blockEntity.getPersistentData().putDouble("CaptiveSpirit", 0);
											_blockEntity.getPersistentData().putDouble("PureDarkEssence", 0);
											_blockEntity.getPersistentData().putDouble("PumpessPlant", 0);
											_blockEntity.getPersistentData().putDouble("Book", 0);
											_blockEntity.getPersistentData().putDouble("Feather", 0);
											_blockEntity.getPersistentData().putDouble("Empty", 0);
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								});
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("There are no ingredients to mix"), true);
							}
						}
					}
				} else {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
						if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip266 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip266) : -1) == 1) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LADLE.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagickalCatalyst") == 1) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldenCarrot") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WitherRose") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Obstruction");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 8;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Frogspawn") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "LilyPad") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slimeball") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Frogify");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 2;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanosusPlant") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Spirit");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 7;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IronChain") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanosusPlant") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Sinking");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 6;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FingerGrass") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Paralysis");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 7;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MoonDust") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "LunarBloom") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "WerewolfCure");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 9;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BottleOfBlood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "VampireCure");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 5;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UndeathlyEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "UndeathCure");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 2;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Leather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 4) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FingerGrass") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.ANOINTMENT_OIL.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagicallyTreatedLeather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Spiritflower") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VileLattice") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.BAG_OF_SPIRITUAL_HOLDING.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UndeathlyEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.DEATHLY_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.SPIRITUAL_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.AUTUMNAL_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PureDarkEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.DARK_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.RICH_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SilverDust") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InkSac") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Empty") == 2) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(MonstrousWorldModItems.UNSTABLE_INK.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RatTail") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "WitherRose") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Vanishing");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 5;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IronChain") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Midas");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 3;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "InsanityEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DigestedFood") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadMoth") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Chickenify");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 11;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinEssence") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RatTail") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SwampWort") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpessPlant") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PumpkinSapling") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Pumpkin");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 4;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Firecane") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "VenomBottle") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadMoth") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DreadfulTears") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Deathcatcher") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Explosion");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 9;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MagicallyTreatedLeather") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldDust") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Bookish");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 11;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CaptiveSpirit") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CultivatedPumpkinEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GhostlyApple") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PureDarkEssence") == 1
											&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BatWing") == 1) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Flight");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										{
											int _value = 7;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putString("Powder", "Ruined");
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Brew failed"), true);
										{
											int _value = 10;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), Mth.nextInt(RandomSource.create(), 600, 2400));
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(3, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(4, ItemStack.EMPTY);
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
											_itemHandlerModifiable.setStackInSlot(5, ItemStack.EMPTY);
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("MagicallyTreatedLeather", 0);
												_blockEntity.getPersistentData().putDouble("Spiritflower", 0);
												_blockEntity.getPersistentData().putDouble("VileLattice", 0);
												_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 0);
												_blockEntity.getPersistentData().putDouble("Deathcatcher", 0);
												_blockEntity.getPersistentData().putDouble("FingerGrass", 0);
												_blockEntity.getPersistentData().putDouble("Frogspawn", 0);
												_blockEntity.getPersistentData().putDouble("Lilypad", 0);
												_blockEntity.getPersistentData().putDouble("Slimeball", 0);
												_blockEntity.getPersistentData().putDouble("InkSac", 0);
												_blockEntity.getPersistentData().putDouble("GoldenCarrot", 0);
												_blockEntity.getPersistentData().putDouble("InsanityEssence", 0);
												_blockEntity.getPersistentData().putDouble("UndeathlyEssence", 0);
												_blockEntity.getPersistentData().putDouble("SpiritEssence", 0);
												_blockEntity.getPersistentData().putDouble("MoonDust", 0);
												_blockEntity.getPersistentData().putDouble("BottleOfBlood", 0);
												_blockEntity.getPersistentData().putDouble("WitherRose", 0);
												_blockEntity.getPersistentData().putDouble("InsanosusPlant", 0);
												_blockEntity.getPersistentData().putDouble("IronChain", 0);
												_blockEntity.getPersistentData().putDouble("LunarBloom", 0);
												_blockEntity.getPersistentData().putDouble("Leather", 0);
												_blockEntity.getPersistentData().putDouble("DigestedFood", 0);
												_blockEntity.getPersistentData().putDouble("VenomBottle", 0);
												_blockEntity.getPersistentData().putDouble("DreadfulTears", 0);
												_blockEntity.getPersistentData().putDouble("GoldDust", 0);
												_blockEntity.getPersistentData().putDouble("SilverDust", 0);
												_blockEntity.getPersistentData().putDouble("BatWing", 0);
												_blockEntity.getPersistentData().putDouble("SwampWort", 0);
												_blockEntity.getPersistentData().putDouble("GhostlyApple", 0);
												_blockEntity.getPersistentData().putDouble("PumpkinEssence", 0);
												_blockEntity.getPersistentData().putDouble("PumpkinSapling", 0);
												_blockEntity.getPersistentData().putDouble("RatTail", 0);
												_blockEntity.getPersistentData().putDouble("DreadMoth", 0);
												_blockEntity.getPersistentData().putDouble("CultivatedPumpkinEssence", 0);
												_blockEntity.getPersistentData().putDouble("CaptiveSpirit", 0);
												_blockEntity.getPersistentData().putDouble("PureDarkEssence", 0);
												_blockEntity.getPersistentData().putDouble("PumpessPlant", 0);
												_blockEntity.getPersistentData().putDouble("Book", 0);
												_blockEntity.getPersistentData().putDouble("Feather", 0);
												_blockEntity.getPersistentData().putDouble("Empty", 0);
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									});
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("There are no ingredients to mix"), true);
								}
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), false);
					}
				}
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}