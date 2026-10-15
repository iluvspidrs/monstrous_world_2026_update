package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class RecipeHelperThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Basic Cauldron")) {
			RHBasicCauldronProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Incantation Book")) {
			RHIncantationBookProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Witchery Robe")) {
			RHWitcheryRobeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Magickal Catalyst")) {
			RHMagickalCatalystProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Ladle")) {
			RHLadleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Witchery Binder")) {
			RHBinderWitcheryProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Charm Altar")) {
			RHCharmAltarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Advanced Cauldron")) {
			RHAdvancedCauldronProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Pumpkin Broom")) {
			RHPumpkinBroomProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Ghostly Broom")) {
			RHGhostlyBroomProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Evil Broom")) {
			RHEvilBroomProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Flute")) {
			RHFluteProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Essence of Deception")) {
			RHEssenceOfDeceptionProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Goblin Oven")) {
			RHGoblinOvenProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkened Stone Bricks")) {
			RHDarkenedStoneBricksProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Goblin Worktable")) {
			RHGoblinWorkstationProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Essence of Transformation")) {
			RHEssenceOfTransformationProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Work Hammer")) {
			RHTrollWorkHammerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Mace")) {
			RHTrollMaceProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Forge")) {
			RHTrollForgeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Anvil")) {
			RHTrollAnvilProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll War Hammer")) {
			RHTrollWarHammerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Alloy Tool Example")) {
			RHTrollAlloyToolExampleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Troll Battle Axe")) {
			RHTrollBattleAxeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Magical Fabric")) {
			RHMagicalFabricProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Sorcery Robe")) {
			RHSorceryRobeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Basic Chalk")) {
			RHBasicChalkProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Ritual Wand")) {
			RHRitualWandProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkened Iron Ingot")) {
			RHDarkenedIronIngotProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkened Iron Trapdoor")) {
			RHDarkenedIronTrapdoorProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hot Plate")) {
			RHHotPlateProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Test Tube")) {
			RHTestTubeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Flask")) {
			RHFlaskProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Syringe")) {
			RHSyringeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Test Tube Mixer")) {
			RHTestTubeMixerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Coat")) {
			RHLabCoatProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Boots")) {
			RHLabBootsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Glasses")) {
			RHLabGlassesProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Laptop")) {
			RHLaptopProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Analyzer")) {
			RHAnalyzerProcedure.execute(world, entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Tin Rod")) {
			RHTinRodProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Tin Trapdoor")) {
			RHTinTrapdoorProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Remote")) {
			RHRobotControllerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Handheld Radio")) {
			RHHandheldRadioProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Scalpel")) {
			RHScalpelProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Laptop Screen")) {
			RHLaptopScreenProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Brain In Jar")) {
			RHBrainInJarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Computer Chip")) {
			RHComputerChipProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Stabilizing Dust")) {
			RHStabilizingDustProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Electricity Channeler")) {
			RHElectricityChannelerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Electricity Channeler Bottom")) {
			RHElectricityChannelerBottomProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Table Section")) {
			RHRobotTableSectionProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Tin Slab")) {
			RHTinSlabProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Redstone Eye")) {
			RHRedstoneEyeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Spider Head")) {
			RHRobotSpiderHeadProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Spider Body")) {
			RHRobotSpiderBodyProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Spider Legs")) {
			RHRobotSpiderLegsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Head")) {
			RHRobotGuardHeadProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Body and Arms")) {
			RHRobotGuardBodyAndArmsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Legs")) {
			RHRobotGuardLegsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Arm")) {
			RHRobotGuardArmProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Leg")) {
			RHRobotGuardLegProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Guard Body")) {
			RHRobotGuardBodyProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkness Sample")) {
			RHDarknessSampleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Glowstone Sample")) {
			RHGlowstoneSampleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Redstone Sample")) {
			RHRedstoneSampleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Shovel")) {
			RHSwampCrystalShovelProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Crude Swamp Crystal Dagger")) {
			RHCrudeSwampCrystalDaggerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Helmet")) {
			RHCrudeSwampCrystalHelmetProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Chestplate")) {
			RHCrudeSwampCrystalChestplateProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Leggings")) {
			RHCrudeSwampCrystalLeggingsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Boots")) {
			RHCrudeSwampCrystalBootsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Spear")) {
			RHSwampCrystalSpearProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Chieftan Headdress")) {
			RHChieftanHeaddressProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Tribal Brand")) {
			RHTribalBrandProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Cultivated Mysterious Seed")) {
			RHCultivatedMysteriousSeedProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Block")) {
			RHSwampCrystalBlockProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Light Jar")) {
			RHSwampLightJarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Moon Phase Clock")) {
			RHMoonPhaseClockProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Bracelet of Beastly Restraint")) {
			RHBraceletOfBeastlyRestraintProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Werewolf Necklace")) {
			RHWerewolfNecklaceProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Bloodletter")) {
			RHBloodletterProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Blood Focus")) {
			RHBloodFocusProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Block of Moonstone")) {
			RHBlockOfMoonstoneProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Block of Sardonyx")) {
			RHBlockOfSardonyxProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Clear Amulet")) {
			RHClearAmuletProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Blood Collector")) {
			RHBloodCollectorProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Block of Clear Quartz")) {
			RHBlockOfClearQuartzProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hunter Hat")) {
			RHHunterHatProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hunter Coat")) {
			RHHunterCoatProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hunter Leggings")) {
			RHHunterLeggingsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hunter Boots")) {
			RHHunterBootsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Soaking Basin")) {
			RHSoakingBasinProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Injection of Clarity")) {
			RHInjectionOfClarityProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Amulet of Clear Mind")) {
			RHAmuletOfClearMindProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Amulet of Strong Will")) {
			RHAmuletOfStrongWillProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Iron Bolt")) {
			RHIronBoltProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Silver Bolt")) {
			RHSilverBoltProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Iron Throwing Knife")) {
			RHIronThrowingKnifeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Silver Throwing Knife")) {
			RHSilverThrowingKnifeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Loaded Bolt")) {
			RHLoadedBoltProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Stake")) {
			RHStakeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Silver Dagger")) {
			RHSilverDaggerProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Fire Tipped Stake")) {
			RHFireTippedStakeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Silver Tipped Stake")) {
			RHSilverTippedStakeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Nether Altar")) {
			RHNetherAltarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Block of Nether Gems")) {
			RHBlockOfNetherGemsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Sword")) {
			RHInfernalSwordProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Axe")) {
			RHInfernalAxeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Pickaxe")) {
			RHInfernalPickaxeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Shovel")) {
			RHInfernalShovelProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Soul Crucible")) {
			RHSoulCrucibleProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Jar")) {
			RHInfernalJarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Obsidian")) {
			RHObsidianProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Fabric")) {
			RHInfernalFabricProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Unholy Scroll")) {
			RHUnholyScrollProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Acid Gun")) {
			RHAcidGunProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Block of Raw Infernal Iron")) {
			RHBlockOfRawInfernalIronProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Pliers")) {
			RHPliersProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Confectionery Table")) {
			RHConfectioneryTableProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Deadly Balloon")) {
			RHDeadlyBalloonProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Mallet")) {
			RHMalletProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Morbid Worktable")) {
			RHMorbidWorktableProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Mysterious Candy")) {
			RHMysteriousCandyProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Popcorn Upgrade")) {
			RHPopcornUpgradeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Sample Jar")) {
			RHSampleJarProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Popcorn Gun")) {
			RHPopcornGunProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Butcher Knife")) {
			RHButcherKnifeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Butcher Knife")) {
			RHInfernalButcherKnifeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Living Mud")) {
			RHLivingMudProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Mud Pot")) {
			RHMudPotProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Swamp Crystal Hoe")) {
			RHSwampCrystalHoeProcedure.execute(entity);
		}
	}
}