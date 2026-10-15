package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class SimpleCauldronItemCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("MagicallyTreatedLeather", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("InsanityEssence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("UndeathlyEssence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("PumpkinEssence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("SpiritEssence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()).toString()).contains("moon_dust")
					|| (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString()).contains("moon_dust")
					|| (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem()).toString()).contains("moon_dust")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("MoonDust", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("MagickalCatalyst", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()).toString()).contains("blood_bottle")
					|| (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString()).contains("blood_bottle")
					|| (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem()).toString()).contains("blood_bottle")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("BottleOfBlood", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:blood_bottles")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:blood_bottles")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:blood_bottles")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("BottleOfBlood", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.SLIME_BALL || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.SLIME_BALL
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.SLIME_BALL) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Slimeball", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.INK_SAC || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.INK_SAC
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.INK_SAC) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("InkSac", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.WITHER_ROSE.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Blocks.WITHER_ROSE.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Blocks.WITHER_ROSE.asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("WitherRose", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.GOLDEN_CARROT || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.GOLDEN_CARROT
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.GOLDEN_CARROT) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GoldenCarrot", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.TADPOLE_BUCKET || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.TADPOLE_BUCKET
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.TADPOLE_BUCKET) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Frogspawn", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.LILY_PAD.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Blocks.LILY_PAD.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Blocks.LILY_PAD.asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("LilyPad", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.INSANOSUS.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.INSANOSUS.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.INSANOSUS.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("InsanosusPlant", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.SOULFLOWER.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.SOULFLOWER.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.SOULFLOWER.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Spiritflower", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.CHAIN.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Blocks.CHAIN.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Blocks.CHAIN.asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("IronChain", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.VILE_LATTICE.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.VILE_LATTICE.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.VILE_LATTICE.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("VileLattice", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("SilverDust", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("PureDarkEssence", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/gold")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/gold")))
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).is(ItemTags.create(ResourceLocation.parse("c:dusts/gold")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GoldDust", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.DEATHCATCHER.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.DEATHCATCHER.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.DEATHCATCHER.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Deathcatcher", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("DigestedFood", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.LUNAR_BLOOM.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.LUNAR_BLOOM.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.LUNAR_BLOOM.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("LunarBloom", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.DREADFUL_TEARS.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.DREADFUL_TEARS.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.DREADFUL_TEARS.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("DreadfulTears", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.LEATHER || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.LEATHER
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.LEATHER) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Leather", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModBlocks.FINGER_GRASS.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModBlocks.FINGER_GRASS.get().asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModBlocks.FINGER_GRASS.get().asItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("FingerGrass", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.VENOM_BOTTLE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.VENOM_BOTTLE.get()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == MonstrousWorldModItems.VENOM_BOTTLE.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("VenomBottle", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}