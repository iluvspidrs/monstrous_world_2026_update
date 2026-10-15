/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.world.features.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class MonstrousWorldModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, MonstrousWorldMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> DARK_SEED_FEATURE = REGISTRY.register("dark_seed_feature", DarkSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_GREEN_GRAVEL_FEATURE = REGISTRY.register("odd_green_gravel_feature", OddGreenGravelFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_BLUE_GRAVEL_FEATURE = REGISTRY.register("odd_blue_gravel_feature", OddBlueGravelFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_PALE_GRAVEL_FEATURE = REGISTRY.register("odd_pale_gravel_feature", OddPaleGravelFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_RED_GRAVEL_FEATURE = REGISTRY.register("odd_red_gravel_feature", OddRedGravelFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_1 = REGISTRY.register("awakened_patch_1", AwakenedPatch1Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_2 = REGISTRY.register("awakened_patch_2", AwakenedPatch2Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_3 = REGISTRY.register("awakened_patch_3", AwakenedPatch3Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SCATTERED_GOURDS = REGISTRY.register("scattered_gourds", ScatteredGourdsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_1 = REGISTRY.register("bookshelves_1", Bookshelves1Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_2 = REGISTRY.register("bookshelves_2", Bookshelves2Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_3 = REGISTRY.register("bookshelves_3", Bookshelves3Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GIANT_PUMPKIN_TALL = REGISTRY.register("giant_pumpkin_tall", GiantPumpkinTallFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GIANT_PUMPKIN_SHORT = REGISTRY.register("giant_pumpkin_short", GiantPumpkinShortFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SORCERESS_T_ENT = REGISTRY.register("sorceress_t_ent", SorceressTEntFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_WARNING_SWAMP = REGISTRY.register("hunter_warning_swamp", HunterWarningSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_WARNING_WISP = REGISTRY.register("hunter_warning_wisp", HunterWarningWispFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_WARNING_VAMPIRE = REGISTRY.register("hunter_warning_vampire", HunterWarningVampireFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_WARNING_WEREWOLF = REGISTRY.register("hunter_warning_werewolf", HunterWarningWerewolfFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> MOUNTAIN_TROLL_LAIR = REGISTRY.register("mountain_troll_lair", MountainTrollLairFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_WARNING_TROLL = REGISTRY.register("hunter_warning_troll", HunterWarningTrollFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> VILLAGER_WARNING = REGISTRY.register("villager_warning", VillagerWarningFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_BLUE_GRAVEL_FEATURE_DEATHLY_FOREST = REGISTRY.register("odd_blue_gravel_feature_deathly_forest", OddBlueGravelFeatureDeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_2_DEATHLY_FOREST = REGISTRY.register("bookshelves_2_deathly_forest", Bookshelves2DeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_3_DEATHLY_FOREST = REGISTRY.register("bookshelves_3_deathly_forest", Bookshelves3DeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_1_DEATHLY_FOREST = REGISTRY.register("awakened_patch_1_deathly_forest", AwakenedPatch1DeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_2_DEATHLY_FOREST = REGISTRY.register("awakened_patch_2_deathly_forest", AwakenedPatch2DeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AWAKENED_PATCH_3_DEATHLY_FOREST = REGISTRY.register("awakened_patch_3_deathly_forest", AwakenedPatch3DeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SMALL_GRAVEYARD_1 = REGISTRY.register("small_graveyard_1", SmallGraveyard1Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DEATHLY_FOREST_GRAVEL_PATCH_SHORE = REGISTRY.register("deathly_forest_gravel_patch_shore", DeathlyForestGravelPatchShoreFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DEATHLY_FOREST_SAND_PATCH_SHORE = REGISTRY.register("deathly_forest_sand_patch_shore", DeathlyForestSandPatchShoreFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SUGAR_CANE_SINGLE = REGISTRY.register("sugar_cane_single", SugarCaneSingleFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_RED_GRAVEL_FEATURE_CRIMSON_DREAD = REGISTRY.register("odd_red_gravel_feature_crimson_dread", OddRedGravelFeatureCrimsonDreadFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> WEBBED_VICTIM_CRIMSON_DREAD = REGISTRY.register("webbed_victim_crimson_dread", WebbedVictimCrimsonDreadFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> WEBBED_VICTIM_2_CRIMSON_DREAD = REGISTRY.register("webbed_victim_2_crimson_dread", WebbedVictim2CrimsonDreadFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SANGUINUS_1 = REGISTRY.register("sanguinus_1", Sanguinus1Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SANGUINUS_2 = REGISTRY.register("sanguinus_2", Sanguinus2Feature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_GREEN_GRAVEL_FEATURE_DEATHLY_FOREST = REGISTRY.register("odd_green_gravel_feature_deathly_forest", OddGreenGravelFeatureDeathlyForestFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HAY_BALE_1_FORSAKEN_LANDS = REGISTRY.register("hay_bale_1_forsaken_lands", HayBale1ForsakenLandsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HAY_BALE_2_FORSAKEN_LANDS = REGISTRY.register("hay_bale_2_forsaken_lands", HayBale2ForsakenLandsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DEATHLY_SHRUB_FORSAKEN_LANDS = REGISTRY.register("deathly_shrub_forsaken_lands", DeathlyShrubForsakenLandsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DARK_MARKET_SEED_FEATURE = REGISTRY.register("dark_market_seed_feature", DarkMarketSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CLOWN_TENT_SEED_FEATURE = REGISTRY.register("clown_tent_seed_feature", ClownTentSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CORN_FARM_1_FORSAKEN_LANDS = REGISTRY.register("corn_farm_1_forsaken_lands", CornFarm1ForsakenLandsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CORN_FARM_2_FORSAKEN_LANDS = REGISTRY.register("corn_farm_2_forsaken_lands", CornFarm2ForsakenLandsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PUMPKIN_TRAP_SCATTERED = REGISTRY.register("pumpkin_trap_scattered", PumpkinTrapScatteredFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTER_NOTICE_FLYER = REGISTRY.register("hunter_notice_flyer", HunterNoticeFlyerFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_PALE_GRAVEL_FEATURE_AUTUMN_DELIGHT = REGISTRY.register("odd_pale_gravel_feature_autumn_delight", OddPaleGravelFeatureAutumnDelightFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> MUSEUM_AD_FEATURE = REGISTRY.register("museum_ad_feature", MuseumAdFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> DARK_MARKET_AD_FEATURE = REGISTRY.register("dark_market_ad_feature", DarkMarketAdFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTERS_WARNING_CIRCUS_TENT_SEED_FEATURE = REGISTRY.register("hunters_warning_circus_tent_seed_feature", HuntersWarningCircusTentSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> NETHER_HALL_SEED_FEATURE = REGISTRY.register("nether_hall_seed_feature", NetherHallSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> MANIAC_HOUSE_SEED_FEATURE = REGISTRY.register("maniac_house_seed_feature", ManiacHouseSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_EAST_SEED_FEATURE = REGISTRY.register("evil_tree_east_seed_feature", EvilTreeEastSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_WEST_SEED_FEATURE = REGISTRY.register("evil_tree_west_seed_feature", EvilTreeWestSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_NORTH_SEED_FEATURE = REGISTRY.register("evil_tree_north_seed_feature", EvilTreeNorthSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_SOUTH_SEED_FEATURE = REGISTRY.register("evil_tree_south_seed_feature", EvilTreeSouthSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_EAST_SEED_FEATURE_SWAMP = REGISTRY.register("evil_tree_east_seed_feature_swamp", EvilTreeEastSeedFeatureSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_WEST_SEED_FEATURE_SWAMP = REGISTRY.register("evil_tree_west_seed_feature_swamp", EvilTreeWestSeedFeatureSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_NORTH_SEED_FEATURE_SWAMP = REGISTRY.register("evil_tree_north_seed_feature_swamp", EvilTreeNorthSeedFeatureSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_SOUTH_SEED_FEATURE_SWAMP = REGISTRY.register("evil_tree_south_seed_feature_swamp", EvilTreeSouthSeedFeatureSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_EAST_SEED_FEATURE_SPOOKY = REGISTRY.register("evil_tree_east_seed_feature_spooky", EvilTreeEastSeedFeatureSpookyFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_WEST_SEED_FEATURE_SPOOKY = REGISTRY.register("evil_tree_west_seed_feature_spooky", EvilTreeWestSeedFeatureSpookyFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_NORTH_SEED_FEATURE_SPOOKY = REGISTRY.register("evil_tree_north_seed_feature_spooky", EvilTreeNorthSeedFeatureSpookyFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> EVIL_TREE_SOUTH_SEED_FEATURE_SPOOKY = REGISTRY.register("evil_tree_south_seed_feature_spooky", EvilTreeSouthSeedFeatureSpookyFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> TRICK_OR_TREAT_AD_FEATURE = REGISTRY.register("trick_or_treat_ad_feature", TrickOrTreatAdFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTERS_WARNING_MANIAC_SEED_FEATURE = REGISTRY.register("hunters_warning_maniac_seed_feature", HuntersWarningManiacSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> HUNTERS_WARNING_DEMON_SEED_FEATURE = REGISTRY.register("hunters_warning_demon_seed_feature", HuntersWarningDemonSeedFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ABANDONED_CART_FEATURE = REGISTRY.register("abandoned_cart_feature", AbandonedCartFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ODD_GREEN_GRAVEL_FEATURE_D_SCUM_SWAMP = REGISTRY.register("odd_green_gravel_feature_d_scum_swamp", OddGreenGravelFeatureDScumSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BOOKSHELVES_3_SCUM_SWAMP = REGISTRY.register("bookshelves_3_scum_swamp", Bookshelves3ScumSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> WEBBED_VICTIM_SCUM_SWAMP = REGISTRY.register("webbed_victim_scum_swamp", WebbedVictimScumSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> WEBBED_VICTIM_2_SCUM_SWAMP = REGISTRY.register("webbed_victim_2_scum_swamp", WebbedVictim2ScumSwampFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PH_GIANT_PUMPKIN_TALL = REGISTRY.register("ph_giant_pumpkin_tall", PHGiantPumpkinTallFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PH_GIANT_PUMPKIN_SHORT = REGISTRY.register("ph_giant_pumpkin_short", PHGiantPumpkinShortFeature::new);
}