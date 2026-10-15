/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.block.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public class MonstrousWorldModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MonstrousWorldMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkSeedBlockEntity>> DARK_SEED = register("dark_seed", MonstrousWorldModBlocks.DARK_SEED, DarkSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedStoneBlockEntity>> ACTIVE_DARKENED_STONE = register("active_darkened_stone", MonstrousWorldModBlocks.ACTIVE_DARKENED_STONE, ActiveDarkenedStoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedDirtBlockEntity>> ACTIVE_DARKENED_DIRT = register("active_darkened_dirt", MonstrousWorldModBlocks.ACTIVE_DARKENED_DIRT, ActiveDarkenedDirtBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedSandBlockEntity>> ACTIVE_DARKENED_SAND = register("active_darkened_sand", MonstrousWorldModBlocks.ACTIVE_DARKENED_SAND, ActiveDarkenedSandBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedSandstoneBlockEntity>> ACTIVE_DARKENED_SANDSTONE = register("active_darkened_sandstone", MonstrousWorldModBlocks.ACTIVE_DARKENED_SANDSTONE,
			ActiveDarkenedSandstoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedGravelBlockEntity>> ACTIVE_DARKENED_GRAVEL = register("active_darkened_gravel", MonstrousWorldModBlocks.ACTIVE_DARKENED_GRAVEL,
			ActiveDarkenedGravelBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedLogBlockEntity>> ACTIVE_DARKENED_LOG = register("active_darkened_log", MonstrousWorldModBlocks.ACTIVE_DARKENED_LOG, ActiveDarkenedLogBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActiveDarkenedLeavesBlockEntity>> ACTIVE_DARKENED_LEAVES = register("active_darkened_leaves", MonstrousWorldModBlocks.ACTIVE_DARKENED_LEAVES,
			ActiveDarkenedLeavesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EmptyFlaskBlockEntity>> EMPTY_FLASK = register("empty_flask", MonstrousWorldModBlocks.EMPTY_FLASK, EmptyFlaskBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TestTubeMixerBlockEntity>> TEST_TUBE_MIXER = register("test_tube_mixer", MonstrousWorldModBlocks.TEST_TUBE_MIXER, TestTubeMixerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HotPlateBlockEntity>> HOT_PLATE = register("hot_plate", MonstrousWorldModBlocks.HOT_PLATE, HotPlateBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectricityChannelerTopBlockEntity>> ELECTRICITY_CHANNELER_TOP = register("electricity_channeler_top", MonstrousWorldModBlocks.ELECTRICITY_CHANNELER_TOP,
			ElectricityChannelerTopBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SimpleCauldronBlockEntity>> SIMPLE_CAULDRON = register("simple_cauldron", MonstrousWorldModBlocks.SIMPLE_CAULDRON, SimpleCauldronBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CharmAltarBlockEntity>> CHARM_ALTAR = register("charm_altar", MonstrousWorldModBlocks.CHARM_ALTAR, CharmAltarBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AdvancedCauldronBlockEntity>> ADVANCED_CAULDRON = register("advanced_cauldron", MonstrousWorldModBlocks.ADVANCED_CAULDRON, AdvancedCauldronBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BloodFocusBlockEntity>> BLOOD_FOCUS = register("blood_focus", MonstrousWorldModBlocks.BLOOD_FOCUS, BloodFocusBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BloodCollectorBlockEntity>> BLOOD_COLLECTOR = register("blood_collector", MonstrousWorldModBlocks.BLOOD_COLLECTOR, BloodCollectorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UpgradedBloodCollectorBlockEntity>> UPGRADED_BLOOD_COLLECTOR = register("upgraded_blood_collector", MonstrousWorldModBlocks.UPGRADED_BLOOD_COLLECTOR,
			UpgradedBloodCollectorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoblinWorkstationBlockEntity>> GOBLIN_WORKSTATION = register("goblin_workstation", MonstrousWorldModBlocks.GOBLIN_WORKSTATION, GoblinWorkstationBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoblinOvenBlockEntity>> GOBLIN_OVEN = register("goblin_oven", MonstrousWorldModBlocks.GOBLIN_OVEN, GoblinOvenBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SoakingBasinBlockEntity>> SOAKING_BASIN = register("soaking_basin", MonstrousWorldModBlocks.SOAKING_BASIN, SoakingBasinBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TerritoryMarkerBlockEntity>> TERRITORY_MARKER = register("territory_marker", MonstrousWorldModBlocks.TERRITORY_MARKER, TerritoryMarkerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrollForgeCopperBlockEntity>> TROLL_FORGE_COPPER = register("troll_forge_copper", MonstrousWorldModBlocks.TROLL_FORGE_COPPER, TrollForgeCopperBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrollForgeTungstenBlockEntity>> TROLL_FORGE_TUNGSTEN = register("troll_forge_tungsten", MonstrousWorldModBlocks.TROLL_FORGE_TUNGSTEN, TrollForgeTungstenBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrollAnvilBlockEntity>> TROLL_ANVIL = register("troll_anvil", MonstrousWorldModBlocks.TROLL_ANVIL, TrollAnvilBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrialBlockBlockEntity>> TRIAL_BLOCK = register("trial_block", MonstrousWorldModBlocks.TRIAL_BLOCK, TrialBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CenterGlyphBlockEntity>> CENTER_GLYPH = register("center_glyph", MonstrousWorldModBlocks.CENTER_GLYPH, CenterGlyphBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConcentratedMalachiteBlockEntity>> CONCENTRATED_MALACHITE = register("concentrated_malachite", MonstrousWorldModBlocks.CONCENTRATED_MALACHITE,
			ConcentratedMalachiteBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConcentratedMoonstoneBlockEntity>> CONCENTRATED_MOONSTONE = register("concentrated_moonstone", MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE,
			ConcentratedMoonstoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NetherAltarBlockEntity>> NETHER_ALTAR = register("nether_altar", MonstrousWorldModBlocks.NETHER_ALTAR, NetherAltarBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkMarketSeedBlockEntity>> DARK_MARKET_SEED = register("dark_market_seed", MonstrousWorldModBlocks.DARK_MARKET_SEED, DarkMarketSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CornCropTopBlockEntity>> CORN_CROP_TOP = register("corn_crop_top", MonstrousWorldModBlocks.CORN_CROP_TOP, CornCropTopBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CornCropTop1BlockEntity>> CORN_CROP_TOP_1 = register("corn_crop_top_1", MonstrousWorldModBlocks.CORN_CROP_TOP_1, CornCropTop1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CornCropTop2BlockEntity>> CORN_CROP_TOP_2 = register("corn_crop_top_2", MonstrousWorldModBlocks.CORN_CROP_TOP_2, CornCropTop2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConfectioneryTableBlockEntity>> CONFECTIONERY_TABLE = register("confectionery_table", MonstrousWorldModBlocks.CONFECTIONERY_TABLE, ConfectioneryTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkMarketAdSeedBlockEntity>> DARK_MARKET_AD_SEED = register("dark_market_ad_seed", MonstrousWorldModBlocks.DARK_MARKET_AD_SEED, DarkMarketAdSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HunterWarningCircusTentSeedBlockEntity>> HUNTER_WARNING_CIRCUS_TENT_SEED = register("hunter_warning_circus_tent_seed", MonstrousWorldModBlocks.HUNTER_WARNING_CIRCUS_TENT_SEED,
			HunterWarningCircusTentSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SoulCrucibleBlockEntity>> SOUL_CRUCIBLE = register("soul_crucible", MonstrousWorldModBlocks.SOUL_CRUCIBLE, SoulCrucibleBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ManiacHouseSeedBlockEntity>> MANIAC_HOUSE_SEED = register("maniac_house_seed", MonstrousWorldModBlocks.MANIAC_HOUSE_SEED, ManiacHouseSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MorbidWorkTableBlockEntity>> MORBID_WORK_TABLE = register("morbid_work_table", MonstrousWorldModBlocks.MORBID_WORK_TABLE, MorbidWorkTableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvilTreeNorthFacingSeedBlockEntity>> EVIL_TREE_NORTH_FACING_SEED = register("evil_tree_north_facing_seed", MonstrousWorldModBlocks.EVIL_TREE_NORTH_FACING_SEED,
			EvilTreeNorthFacingSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvilTreeSouthFacingSeedBlockEntity>> EVIL_TREE_SOUTH_FACING_SEED = register("evil_tree_south_facing_seed", MonstrousWorldModBlocks.EVIL_TREE_SOUTH_FACING_SEED,
			EvilTreeSouthFacingSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvilTreeEastFacingSeedBlockEntity>> EVIL_TREE_EAST_FACING_SEED = register("evil_tree_east_facing_seed", MonstrousWorldModBlocks.EVIL_TREE_EAST_FACING_SEED,
			EvilTreeEastFacingSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvilTreeWestFacingSeedBlockEntity>> EVIL_TREE_WEST_FACING_SEED = register("evil_tree_west_facing_seed", MonstrousWorldModBlocks.EVIL_TREE_WEST_FACING_SEED,
			EvilTreeWestFacingSeedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MudPotBlockEntity>> MUD_POT = register("mud_pot", MonstrousWorldModBlocks.MUD_POT, MudPotBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AncientShrineToArtemisBlockEntity>> ANCIENT_SHRINE_TO_ARTEMIS = register("ancient_shrine_to_artemis", MonstrousWorldModBlocks.ANCIENT_SHRINE_TO_ARTEMIS,
			AncientShrineToArtemisBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_STONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_DIRT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_SAND.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_SANDSTONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_GRAVEL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_LOG.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVE_DARKENED_LEAVES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EMPTY_FLASK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TEST_TUBE_MIXER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HOT_PLATE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ELECTRICITY_CHANNELER_TOP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SIMPLE_CAULDRON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHARM_ALTAR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ADVANCED_CAULDRON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLOOD_FOCUS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLOOD_COLLECTOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UPGRADED_BLOOD_COLLECTOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOBLIN_WORKSTATION.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOBLIN_OVEN.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOAKING_BASIN.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TERRITORY_MARKER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TROLL_FORGE_COPPER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TROLL_FORGE_TUNGSTEN.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TROLL_ANVIL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRIAL_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CENTER_GLYPH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONCENTRATED_MALACHITE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONCENTRATED_MOONSTONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NETHER_ALTAR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_MARKET_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CORN_CROP_TOP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CORN_CROP_TOP_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CORN_CROP_TOP_2.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONFECTIONERY_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_MARKET_AD_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HUNTER_WARNING_CIRCUS_TENT_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOUL_CRUCIBLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MANIAC_HOUSE_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MORBID_WORK_TABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EVIL_TREE_NORTH_FACING_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EVIL_TREE_SOUTH_FACING_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EVIL_TREE_EAST_FACING_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EVIL_TREE_WEST_FACING_SEED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MUD_POT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ANCIENT_SHRINE_TO_ARTEMIS.get(), SidedInvWrapper::new);
	}
}