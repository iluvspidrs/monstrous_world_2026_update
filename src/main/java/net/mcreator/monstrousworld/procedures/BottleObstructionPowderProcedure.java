package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class BottleObstructionPowderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			int _value = 0;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
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
				_blockEntity.getPersistentData().putDouble("GhostlyApple", 0);
				_blockEntity.getPersistentData().putDouble("RatTail", 0);
				_blockEntity.getPersistentData().putDouble("DreadMoth", 0);
				_blockEntity.getPersistentData().putDouble("SwampWort", 0);
				_blockEntity.getPersistentData().putDouble("BatWing", 0);
				_blockEntity.getPersistentData().putDouble("PumpessPlant", 0);
				_blockEntity.getPersistentData().putDouble("PumpkinEssence", 0);
				_blockEntity.getPersistentData().putDouble("PumpkinSapling", 0);
				_blockEntity.getPersistentData().putDouble("PureDarkEssence", 0);
				_blockEntity.getPersistentData().putDouble("Book", 0);
				_blockEntity.getPersistentData().putDouble("Feather", 0);
				_blockEntity.getPersistentData().putDouble("Empty", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}