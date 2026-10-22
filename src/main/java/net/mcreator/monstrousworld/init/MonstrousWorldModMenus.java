/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.world.inventory.*;
import net.mcreator.monstrousworld.network.MenuStateUpdateMessage;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Map;

public class MonstrousWorldModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MonstrousWorldMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinderMenu>> OPEN_LORE_BINDER = REGISTRY.register("open_lore_binder", () -> IMenuTypeExtension.create(OpenLoreBinderMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder2Menu>> OPEN_LORE_BINDER_2 = REGISTRY.register("open_lore_binder_2", () -> IMenuTypeExtension.create(OpenLoreBinder2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TestTubeMixerGUIMenu>> TEST_TUBE_MIXER_GUI = REGISTRY.register("test_tube_mixer_gui", () -> IMenuTypeExtension.create(TestTubeMixerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder6Menu>> OPEN_LORE_BINDER_6 = REGISTRY.register("open_lore_binder_6", () -> IMenuTypeExtension.create(OpenLoreBinder6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FlyMutantAssignmentMenu>> FLY_MUTANT_ASSIGNMENT = REGISTRY.register("fly_mutant_assignment", () -> IMenuTypeExtension.create(FlyMutantAssignmentMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EyeMutantAssignmentMenu>> EYE_MUTANT_ASSIGNMENT = REGISTRY.register("eye_mutant_assignment", () -> IMenuTypeExtension.create(EyeMutantAssignmentMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SerpentMutantAssignmentMenu>> SERPENT_MUTANT_ASSIGNMENT = REGISTRY.register("serpent_mutant_assignment", () -> IMenuTypeExtension.create(SerpentMutantAssignmentMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder3Menu>> OPEN_LORE_BINDER_3 = REGISTRY.register("open_lore_binder_3", () -> IMenuTypeExtension.create(OpenLoreBinder3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder4Menu>> OPEN_LORE_BINDER_4 = REGISTRY.register("open_lore_binder_4", () -> IMenuTypeExtension.create(OpenLoreBinder4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder5Menu>> OPEN_LORE_BINDER_5 = REGISTRY.register("open_lore_binder_5", () -> IMenuTypeExtension.create(OpenLoreBinder5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CharmAltarGUIMenu>> CHARM_ALTAR_GUI = REGISTRY.register("charm_altar_gui", () -> IMenuTypeExtension.create(CharmAltarGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder7Menu>> OPEN_LORE_BINDER_7 = REGISTRY.register("open_lore_binder_7", () -> IMenuTypeExtension.create(OpenLoreBinder7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder8Menu>> OPEN_LORE_BINDER_8 = REGISTRY.register("open_lore_binder_8", () -> IMenuTypeExtension.create(OpenLoreBinder8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder9Menu>> OPEN_LORE_BINDER_9 = REGISTRY.register("open_lore_binder_9", () -> IMenuTypeExtension.create(OpenLoreBinder9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TwoTradesMenu>> TWO_TRADES = REGISTRY.register("two_trades", () -> IMenuTypeExtension.create(TwoTradesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OneTradeMenu>> ONE_TRADE = REGISTRY.register("one_trade", () -> IMenuTypeExtension.create(OneTradeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExplorerLog1Page1Menu>> EXPLORER_LOG_1_PAGE_1 = REGISTRY.register("explorer_log_1_page_1", () -> IMenuTypeExtension.create(ExplorerLog1Page1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExplorerLog1Page2Menu>> EXPLORER_LOG_1_PAGE_2 = REGISTRY.register("explorer_log_1_page_2", () -> IMenuTypeExtension.create(ExplorerLog1Page2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExplorerLog2Page1Menu>> EXPLORER_LOG_2_PAGE_1 = REGISTRY.register("explorer_log_2_page_1", () -> IMenuTypeExtension.create(ExplorerLog2Page1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExplorerLog2Page2Menu>> EXPLORER_LOG_2_PAGE_2 = REGISTRY.register("explorer_log_2_page_2", () -> IMenuTypeExtension.create(ExplorerLog2Page2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GoblinWorkstationLevel2Menu>> GOBLIN_WORKSTATION_LEVEL_2 = REGISTRY.register("goblin_workstation_level_2", () -> IMenuTypeExtension.create(GoblinWorkstationLevel2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GoblinOvenGUIMenu>> GOBLIN_OVEN_GUI = REGISTRY.register("goblin_oven_gui", () -> IMenuTypeExtension.create(GoblinOvenGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMissionForGoblinPage1Menu>> HUNTER_MISSION_FOR_GOBLIN_PAGE_1 = REGISTRY.register("hunter_mission_for_goblin_page_1",
			() -> IMenuTypeExtension.create(HunterMissionForGoblinPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMissionForGoblinPage2Menu>> HUNTER_MISSION_FOR_GOBLIN_PAGE_2 = REGISTRY.register("hunter_mission_for_goblin_page_2",
			() -> IMenuTypeExtension.create(HunterMissionForGoblinPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMissionForGoblinPage3Menu>> HUNTER_MISSION_FOR_GOBLIN_PAGE_3 = REGISTRY.register("hunter_mission_for_goblin_page_3",
			() -> IMenuTypeExtension.create(HunterMissionForGoblinPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMissionForGoblinPage4Menu>> HUNTER_MISSION_FOR_GOBLIN_PAGE_4 = REGISTRY.register("hunter_mission_for_goblin_page_4",
			() -> IMenuTypeExtension.create(HunterMissionForGoblinPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder10Menu>> OPEN_LORE_BINDER_10 = REGISTRY.register("open_lore_binder_10", () -> IMenuTypeExtension.create(OpenLoreBinder10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersGuildFlyerMenu>> HUNTERS_GUILD_FLYER = REGISTRY.register("hunters_guild_flyer", () -> IMenuTypeExtension.create(HuntersGuildFlyerMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersGuildApplicationMenu>> HUNTERS_GUILD_APPLICATION = REGISTRY.register("hunters_guild_application", () -> IMenuTypeExtension.create(HuntersGuildApplicationMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SocietyPamphletContentsMenu>> SOCIETY_PAMPHLET_CONTENTS = REGISTRY.register("society_pamphlet_contents", () -> IMenuTypeExtension.create(SocietyPamphletContentsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ATornJournalContentsMenu>> A_TORN_JOURNAL_CONTENTS = REGISTRY.register("a_torn_journal_contents", () -> IMenuTypeExtension.create(ATornJournalContentsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AGuideToMagickalPlantsContentMenu>> A_GUIDE_TO_MAGICKAL_PLANTS_CONTENT = REGISTRY.register("a_guide_to_magickal_plants_content",
			() -> IMenuTypeExtension.create(AGuideToMagickalPlantsContentMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ShortNotesContentsMenu>> SHORT_NOTES_CONTENTS = REGISTRY.register("short_notes_contents", () -> IMenuTypeExtension.create(ShortNotesContentsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HunterMissionContentsMenu>> HUNTER_MISSION_CONTENTS = REGISTRY.register("hunter_mission_contents", () -> IMenuTypeExtension.create(HunterMissionContentsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrollForgeCopperGUIMenu>> TROLL_FORGE_COPPER_GUI = REGISTRY.register("troll_forge_copper_gui", () -> IMenuTypeExtension.create(TrollForgeCopperGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrollForgeTungstenGUIMenu>> TROLL_FORGE_TUNGSTEN_GUI = REGISTRY.register("troll_forge_tungsten_gui", () -> IMenuTypeExtension.create(TrollForgeTungstenGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrollAnvilGUIMenu>> TROLL_ANVIL_GUI = REGISTRY.register("troll_anvil_gui", () -> IMenuTypeExtension.create(TrollAnvilGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfSorceryGUIMenu>> TOME_OF_SORCERY_GUI = REGISTRY.register("tome_of_sorcery_gui", () -> IMenuTypeExtension.create(TomeOfSorceryGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TheArtOfRitualsContentsMenu>> THE_ART_OF_RITUALS_CONTENTS = REGISTRY.register("the_art_of_rituals_contents", () -> IMenuTypeExtension.create(TheArtOfRitualsContentsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NetherAltarGUIMenu>> NETHER_ALTAR_GUI = REGISTRY.register("nether_altar_gui", () -> IMenuTypeExtension.create(NetherAltarGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ConfectioneryTableGUIMenu>> CONFECTIONERY_TABLE_GUI = REGISTRY.register("confectionery_table_gui", () -> IMenuTypeExtension.create(ConfectioneryTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder11Menu>> OPEN_LORE_BINDER_11 = REGISTRY.register("open_lore_binder_11", () -> IMenuTypeExtension.create(OpenLoreBinder11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder12Menu>> OPEN_LORE_BINDER_12 = REGISTRY.register("open_lore_binder_12", () -> IMenuTypeExtension.create(OpenLoreBinder12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder13Menu>> OPEN_LORE_BINDER_13 = REGISTRY.register("open_lore_binder_13", () -> IMenuTypeExtension.create(OpenLoreBinder13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MorbidWorkTableGUIMenu>> MORBID_WORK_TABLE_GUI = REGISTRY.register("morbid_work_table_gui", () -> IMenuTypeExtension.create(MorbidWorkTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AClawedJournalGUIMenu>> A_CLAWED_JOURNAL_GUI = REGISTRY.register("a_clawed_journal_gui", () -> IMenuTypeExtension.create(AClawedJournalGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AGoodAlphaMenu>> A_GOOD_ALPHA = REGISTRY.register("a_good_alpha", () -> IMenuTypeExtension.create(AGoodAlphaMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkEssenceDustGUIMenu>> DARK_ESSENCE_DUST_GUI = REGISTRY.register("dark_essence_dust_gui", () -> IMenuTypeExtension.create(DarkEssenceDustGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage1Menu>> TOME_OF_WITCHERY_PAGE_1 = REGISTRY.register("tome_of_witchery_page_1", () -> IMenuTypeExtension.create(TomeOfWitcheryPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage2Menu>> TOME_OF_WITCHERY_PAGE_2 = REGISTRY.register("tome_of_witchery_page_2", () -> IMenuTypeExtension.create(TomeOfWitcheryPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PumpkinEssenceGUIMenu>> PUMPKIN_ESSENCE_GUI = REGISTRY.register("pumpkin_essence_gui", () -> IMenuTypeExtension.create(PumpkinEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InsanityEssenceGUIMenu>> INSANITY_ESSENCE_GUI = REGISTRY.register("insanity_essence_gui", () -> IMenuTypeExtension.create(InsanityEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SpiritEssenceGUIMenu>> SPIRIT_ESSENCE_GUI = REGISTRY.register("spirit_essence_gui", () -> IMenuTypeExtension.create(SpiritEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UndeathlyEssenceGUIMenu>> UNDEATHLY_ESSENCE_GUI = REGISTRY.register("undeathly_essence_gui", () -> IMenuTypeExtension.create(UndeathlyEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoonDustGUIMenu>> MOON_DUST_GUI = REGISTRY.register("moon_dust_gui", () -> IMenuTypeExtension.create(MoonDustGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EvilTreeWoodGUIMenu>> EVIL_TREE_WOOD_GUI = REGISTRY.register("evil_tree_wood_gui", () -> IMenuTypeExtension.create(EvilTreeWoodGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage3Menu>> TOME_OF_WITCHERY_PAGE_3 = REGISTRY.register("tome_of_witchery_page_3", () -> IMenuTypeExtension.create(TomeOfWitcheryPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ClearQuartzGUIMenu>> CLEAR_QUARTZ_GUI = REGISTRY.register("clear_quartz_gui", () -> IMenuTypeExtension.create(ClearQuartzGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RoseQuartzGUIMenu>> ROSE_QUARTZ_GUI = REGISTRY.register("rose_quartz_gui", () -> IMenuTypeExtension.create(RoseQuartzGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BlackOnyxGUIMenu>> BLACK_ONYX_GUI = REGISTRY.register("black_onyx_gui", () -> IMenuTypeExtension.create(BlackOnyxGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RedOnyxGUIMenu>> RED_ONYX_GUI = REGISTRY.register("red_onyx_gui", () -> IMenuTypeExtension.create(RedOnyxGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LoreBinderWitcheryGUIMenu>> LORE_BINDER_WITCHERY_GUI = REGISTRY.register("lore_binder_witchery_gui", () -> IMenuTypeExtension.create(LoreBinderWitcheryGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage4Menu>> TOME_OF_WITCHERY_PAGE_4 = REGISTRY.register("tome_of_witchery_page_4", () -> IMenuTypeExtension.create(TomeOfWitcheryPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage5Menu>> TOME_OF_WITCHERY_PAGE_5 = REGISTRY.register("tome_of_witchery_page_5", () -> IMenuTypeExtension.create(TomeOfWitcheryPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage6Menu>> TOME_OF_WITCHERY_PAGE_6 = REGISTRY.register("tome_of_witchery_page_6", () -> IMenuTypeExtension.create(TomeOfWitcheryPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage7Menu>> TOME_OF_WITCHERY_PAGE_7 = REGISTRY.register("tome_of_witchery_page_7", () -> IMenuTypeExtension.create(TomeOfWitcheryPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage8Menu>> TOME_OF_WITCHERY_PAGE_8 = REGISTRY.register("tome_of_witchery_page_8", () -> IMenuTypeExtension.create(TomeOfWitcheryPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage9Menu>> TOME_OF_WITCHERY_PAGE_9 = REGISTRY.register("tome_of_witchery_page_9", () -> IMenuTypeExtension.create(TomeOfWitcheryPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage10Menu>> TOME_OF_WITCHERY_PAGE_10 = REGISTRY.register("tome_of_witchery_page_10", () -> IMenuTypeExtension.create(TomeOfWitcheryPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage11Menu>> TOME_OF_WITCHERY_PAGE_11 = REGISTRY.register("tome_of_witchery_page_11", () -> IMenuTypeExtension.create(TomeOfWitcheryPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage12Menu>> TOME_OF_WITCHERY_PAGE_12 = REGISTRY.register("tome_of_witchery_page_12", () -> IMenuTypeExtension.create(TomeOfWitcheryPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage13Menu>> TOME_OF_WITCHERY_PAGE_13 = REGISTRY.register("tome_of_witchery_page_13", () -> IMenuTypeExtension.create(TomeOfWitcheryPage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkenedLogGUIMenu>> DARKENED_LOG_GUI = REGISTRY.register("darkened_log_gui", () -> IMenuTypeExtension.create(DarkenedLogGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkenedCrystalGUIMenu>> DARKENED_CRYSTAL_GUI = REGISTRY.register("darkened_crystal_gui", () -> IMenuTypeExtension.create(DarkenedCrystalGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage14Menu>> TOME_OF_WITCHERY_PAGE_14 = REGISTRY.register("tome_of_witchery_page_14", () -> IMenuTypeExtension.create(TomeOfWitcheryPage14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfWitcheryPage15Menu>> TOME_OF_WITCHERY_PAGE_15 = REGISTRY.register("tome_of_witchery_page_15", () -> IMenuTypeExtension.create(TomeOfWitcheryPage15Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MonstrousPlantsGUIMenu>> MONSTROUS_PLANTS_GUI = REGISTRY.register("monstrous_plants_gui", () -> IMenuTypeExtension.create(MonstrousPlantsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CultivatedPumpkinEssenceGUIMenu>> CULTIVATED_PUMPKIN_ESSENCE_GUI = REGISTRY.register("cultivated_pumpkin_essence_gui",
			() -> IMenuTypeExtension.create(CultivatedPumpkinEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EssenceOfEnchantmentGUIMenu>> ESSENCE_OF_ENCHANTMENT_GUI = REGISTRY.register("essence_of_enchantment_gui", () -> IMenuTypeExtension.create(EssenceOfEnchantmentGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ElectrumGUIMenu>> ELECTRUM_GUI = REGISTRY.register("electrum_gui", () -> IMenuTypeExtension.create(ElectrumGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PurifiedSilverGUIMenu>> PURIFIED_SILVER_GUI = REGISTRY.register("purified_silver_gui", () -> IMenuTypeExtension.create(PurifiedSilverGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage1Menu>> TOME_OF_THE_GOBLIN_PAGE_1 = REGISTRY.register("tome_of_the_goblin_page_1", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage2Menu>> TOME_OF_THE_GOBLIN_PAGE_2 = REGISTRY.register("tome_of_the_goblin_page_2", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage3Menu>> TOME_OF_THE_GOBLIN_PAGE_3 = REGISTRY.register("tome_of_the_goblin_page_3", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage4Menu>> TOME_OF_THE_GOBLIN_PAGE_4 = REGISTRY.register("tome_of_the_goblin_page_4", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage5Menu>> TOME_OF_THE_GOBLIN_PAGE_5 = REGISTRY.register("tome_of_the_goblin_page_5", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage6Menu>> TOME_OF_THE_GOBLIN_PAGE_6 = REGISTRY.register("tome_of_the_goblin_page_6", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage7Menu>> TOME_OF_THE_GOBLIN_PAGE_7 = REGISTRY.register("tome_of_the_goblin_page_7", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage8Menu>> TOME_OF_THE_GOBLIN_PAGE_8 = REGISTRY.register("tome_of_the_goblin_page_8", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage9Menu>> TOME_OF_THE_GOBLIN_PAGE_9 = REGISTRY.register("tome_of_the_goblin_page_9", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage10Menu>> TOME_OF_THE_GOBLIN_PAGE_10 = REGISTRY.register("tome_of_the_goblin_page_10", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage11Menu>> TOME_OF_THE_GOBLIN_PAGE_11 = REGISTRY.register("tome_of_the_goblin_page_11", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheGoblinPage12Menu>> TOME_OF_THE_GOBLIN_PAGE_12 = REGISTRY.register("tome_of_the_goblin_page_12", () -> IMenuTypeExtension.create(TomeOfTheGoblinPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage1Menu>> PRECIOUS_STONES_AND_YOU_PAGE_1 = REGISTRY.register("precious_stones_and_you_page_1", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage2Menu>> PRECIOUS_STONES_AND_YOU_PAGE_2 = REGISTRY.register("precious_stones_and_you_page_2", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage3Menu>> PRECIOUS_STONES_AND_YOU_PAGE_3 = REGISTRY.register("precious_stones_and_you_page_3", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage4Menu>> PRECIOUS_STONES_AND_YOU_PAGE_4 = REGISTRY.register("precious_stones_and_you_page_4", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage5Menu>> PRECIOUS_STONES_AND_YOU_PAGE_5 = REGISTRY.register("precious_stones_and_you_page_5", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage6Menu>> PRECIOUS_STONES_AND_YOU_PAGE_6 = REGISTRY.register("precious_stones_and_you_page_6", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage7Menu>> PRECIOUS_STONES_AND_YOU_PAGE_7 = REGISTRY.register("precious_stones_and_you_page_7", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage8Menu>> PRECIOUS_STONES_AND_YOU_PAGE_8 = REGISTRY.register("precious_stones_and_you_page_8", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage9Menu>> PRECIOUS_STONES_AND_YOU_PAGE_9 = REGISTRY.register("precious_stones_and_you_page_9", () -> IMenuTypeExtension.create(PreciousStonesAndYouPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage10Menu>> PRECIOUS_STONES_AND_YOU_PAGE_10 = REGISTRY.register("precious_stones_and_you_page_10",
			() -> IMenuTypeExtension.create(PreciousStonesAndYouPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage11Menu>> PRECIOUS_STONES_AND_YOU_PAGE_11 = REGISTRY.register("precious_stones_and_you_page_11",
			() -> IMenuTypeExtension.create(PreciousStonesAndYouPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage12Menu>> PRECIOUS_STONES_AND_YOU_PAGE_12 = REGISTRY.register("precious_stones_and_you_page_12",
			() -> IMenuTypeExtension.create(PreciousStonesAndYouPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PreciousStonesAndYouPage13Menu>> PRECIOUS_STONES_AND_YOU_PAGE_13 = REGISTRY.register("precious_stones_and_you_page_13",
			() -> IMenuTypeExtension.create(PreciousStonesAndYouPage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage1Menu>> TOME_OF_THE_TROLL_PAGE_1 = REGISTRY.register("tome_of_the_troll_page_1", () -> IMenuTypeExtension.create(TomeOfTheTrollPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage2Menu>> TOME_OF_THE_TROLL_PAGE_2 = REGISTRY.register("tome_of_the_troll_page_2", () -> IMenuTypeExtension.create(TomeOfTheTrollPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage3Menu>> TOME_OF_THE_TROLL_PAGE_3 = REGISTRY.register("tome_of_the_troll_page_3", () -> IMenuTypeExtension.create(TomeOfTheTrollPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage4Menu>> TOME_OF_THE_TROLL_PAGE_4 = REGISTRY.register("tome_of_the_troll_page_4", () -> IMenuTypeExtension.create(TomeOfTheTrollPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage5Menu>> TOME_OF_THE_TROLL_PAGE_5 = REGISTRY.register("tome_of_the_troll_page_5", () -> IMenuTypeExtension.create(TomeOfTheTrollPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage6Menu>> TOME_OF_THE_TROLL_PAGE_6 = REGISTRY.register("tome_of_the_troll_page_6", () -> IMenuTypeExtension.create(TomeOfTheTrollPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage7Menu>> TOME_OF_THE_TROLL_PAGE_7 = REGISTRY.register("tome_of_the_troll_page_7", () -> IMenuTypeExtension.create(TomeOfTheTrollPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage8Menu>> TOME_OF_THE_TROLL_PAGE_8 = REGISTRY.register("tome_of_the_troll_page_8", () -> IMenuTypeExtension.create(TomeOfTheTrollPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage9Menu>> TOME_OF_THE_TROLL_PAGE_9 = REGISTRY.register("tome_of_the_troll_page_9", () -> IMenuTypeExtension.create(TomeOfTheTrollPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheTrollPage10Menu>> TOME_OF_THE_TROLL_PAGE_10 = REGISTRY.register("tome_of_the_troll_page_10", () -> IMenuTypeExtension.create(TomeOfTheTrollPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage1Menu>> HEAVY_METALS_PAGE_1 = REGISTRY.register("heavy_metals_page_1", () -> IMenuTypeExtension.create(HeavyMetalsPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage2Menu>> HEAVY_METALS_PAGE_2 = REGISTRY.register("heavy_metals_page_2", () -> IMenuTypeExtension.create(HeavyMetalsPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage3Menu>> HEAVY_METALS_PAGE_3 = REGISTRY.register("heavy_metals_page_3", () -> IMenuTypeExtension.create(HeavyMetalsPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage4Menu>> HEAVY_METALS_PAGE_4 = REGISTRY.register("heavy_metals_page_4", () -> IMenuTypeExtension.create(HeavyMetalsPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TinGUIMenu>> TIN_GUI = REGISTRY.register("tin_gui", () -> IMenuTypeExtension.create(TinGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage5Menu>> HEAVY_METALS_PAGE_5 = REGISTRY.register("heavy_metals_page_5", () -> IMenuTypeExtension.create(HeavyMetalsPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage6Menu>> HEAVY_METALS_PAGE_6 = REGISTRY.register("heavy_metals_page_6", () -> IMenuTypeExtension.create(HeavyMetalsPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage7Menu>> HEAVY_METALS_PAGE_7 = REGISTRY.register("heavy_metals_page_7", () -> IMenuTypeExtension.create(HeavyMetalsPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage8Menu>> HEAVY_METALS_PAGE_8 = REGISTRY.register("heavy_metals_page_8", () -> IMenuTypeExtension.create(HeavyMetalsPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage9Menu>> HEAVY_METALS_PAGE_9 = REGISTRY.register("heavy_metals_page_9", () -> IMenuTypeExtension.create(HeavyMetalsPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage10Menu>> HEAVY_METALS_PAGE_10 = REGISTRY.register("heavy_metals_page_10", () -> IMenuTypeExtension.create(HeavyMetalsPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage11Menu>> HEAVY_METALS_PAGE_11 = REGISTRY.register("heavy_metals_page_11", () -> IMenuTypeExtension.create(HeavyMetalsPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage12Menu>> HEAVY_METALS_PAGE_12 = REGISTRY.register("heavy_metals_page_12", () -> IMenuTypeExtension.create(HeavyMetalsPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage13Menu>> HEAVY_METALS_PAGE_13 = REGISTRY.register("heavy_metals_page_13", () -> IMenuTypeExtension.create(HeavyMetalsPage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeavyMetalsPage14Menu>> HEAVY_METALS_PAGE_14 = REGISTRY.register("heavy_metals_page_14", () -> IMenuTypeExtension.create(HeavyMetalsPage14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkenedWoodAshGUIMenu>> DARKENED_WOOD_ASH_GUI = REGISTRY.register("darkened_wood_ash_gui", () -> IMenuTypeExtension.create(DarkenedWoodAshGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuartzDustGUIMenu>> QUARTZ_DUST_GUI = REGISTRY.register("quartz_dust_gui", () -> IMenuTypeExtension.create(QuartzDustGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtOfRitualsTOCMenu>> ART_OF_RITUALS_TOC = REGISTRY.register("art_of_rituals_toc", () -> IMenuTypeExtension.create(ArtOfRitualsTOCMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtOfRitualsPage2Menu>> ART_OF_RITUALS_PAGE_2 = REGISTRY.register("art_of_rituals_page_2", () -> IMenuTypeExtension.create(ArtOfRitualsPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtOfRitualsPage4Menu>> ART_OF_RITUALS_PAGE_4 = REGISTRY.register("art_of_rituals_page_4", () -> IMenuTypeExtension.create(ArtOfRitualsPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtOfRitualsPage5Menu>> ART_OF_RITUALS_PAGE_5 = REGISTRY.register("art_of_rituals_page_5", () -> IMenuTypeExtension.create(ArtOfRitualsPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage1Menu>> TOME_OF_MAD_SCIENCE_PAGE_1 = REGISTRY.register("tome_of_mad_science_page_1", () -> IMenuTypeExtension.create(TomeOfMadSciencePage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage2Menu>> TOME_OF_MAD_SCIENCE_PAGE_2 = REGISTRY.register("tome_of_mad_science_page_2", () -> IMenuTypeExtension.create(TomeOfMadSciencePage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage3Menu>> TOME_OF_MAD_SCIENCE_PAGE_3 = REGISTRY.register("tome_of_mad_science_page_3", () -> IMenuTypeExtension.create(TomeOfMadSciencePage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SilverGUIMenu>> SILVER_GUI = REGISTRY.register("silver_gui", () -> IMenuTypeExtension.create(SilverGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage4Menu>> TOME_OF_MAD_SCIENCE_PAGE_4 = REGISTRY.register("tome_of_mad_science_page_4", () -> IMenuTypeExtension.create(TomeOfMadSciencePage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage5Menu>> TOME_OF_MAD_SCIENCE_PAGE_5 = REGISTRY.register("tome_of_mad_science_page_5", () -> IMenuTypeExtension.create(TomeOfMadSciencePage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RecipeHelperMenu>> RECIPE_HELPER = REGISTRY.register("recipe_helper", () -> IMenuTypeExtension.create(RecipeHelperMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AcidBottleGUIMenu>> ACID_BOTTLE_GUI = REGISTRY.register("acid_bottle_gui", () -> IMenuTypeExtension.create(AcidBottleGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ADoseOfSanityGUIMenu>> A_DOSE_OF_SANITY_GUI = REGISTRY.register("a_dose_of_sanity_gui", () -> IMenuTypeExtension.create(ADoseOfSanityGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoonstoneGUIMenu>> MOONSTONE_GUI = REGISTRY.register("moonstone_gui", () -> IMenuTypeExtension.create(MoonstoneGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DarkenedSandGUIMenu>> DARKENED_SAND_GUI = REGISTRY.register("darkened_sand_gui", () -> IMenuTypeExtension.create(DarkenedSandGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NetherGemGUIMenu>> NETHER_GEM_GUI = REGISTRY.register("nether_gem_gui", () -> IMenuTypeExtension.create(NetherGemGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GhostlyWoodGUIMenu>> GHOSTLY_WOOD_GUI = REGISTRY.register("ghostly_wood_gui", () -> IMenuTypeExtension.create(GhostlyWoodGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DigestedRottenFleshGUIMenu>> DIGESTED_ROTTEN_FLESH_GUI = REGISTRY.register("digested_rotten_flesh_gui", () -> IMenuTypeExtension.create(DigestedRottenFleshGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DreadfulTearsGUIMenu>> DREADFUL_TEARS_GUI = REGISTRY.register("dreadful_tears_gui", () -> IMenuTypeExtension.create(DreadfulTearsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VenomBottleGUIMenu>> VENOM_BOTTLE_GUI = REGISTRY.register("venom_bottle_gui", () -> IMenuTypeExtension.create(VenomBottleGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MurkwoodWoodGUIMenu>> MURKWOOD_WOOD_GUI = REGISTRY.register("murkwood_wood_gui", () -> IMenuTypeExtension.create(MurkwoodWoodGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OddRootGUIMenu>> ODD_ROOT_GUI = REGISTRY.register("odd_root_gui", () -> IMenuTypeExtension.create(OddRootGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SwampCrystalGUIMenu>> SWAMP_CRYSTAL_GUI = REGISTRY.register("swamp_crystal_gui", () -> IMenuTypeExtension.create(SwampCrystalGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SwampEssenceGUIMenu>> SWAMP_ESSENCE_GUI = REGISTRY.register("swamp_essence_gui", () -> IMenuTypeExtension.create(SwampEssenceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SwampEssenceDustGUIMenu>> SWAMP_ESSENCE_DUST_GUI = REGISTRY.register("swamp_essence_dust_gui", () -> IMenuTypeExtension.create(SwampEssenceDustGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VileSlimeGUIMenu>> VILE_SLIME_GUI = REGISTRY.register("vile_slime_gui", () -> IMenuTypeExtension.create(VileSlimeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PumpkinLogGUIMenu>> PUMPKIN_LOG_GUI = REGISTRY.register("pumpkin_log_gui", () -> IMenuTypeExtension.create(PumpkinLogGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SplatterProtectionGUIMenu>> SPLATTER_PROTECTION_GUI = REGISTRY.register("splatter_protection_gui", () -> IMenuTypeExtension.create(SplatterProtectionGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CureSerumPage2Menu>> CURE_SERUM_PAGE_2 = REGISTRY.register("cure_serum_page_2", () -> IMenuTypeExtension.create(CureSerumPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage6Menu>> TOME_OF_MAD_SCIENCE_PAGE_6 = REGISTRY.register("tome_of_mad_science_page_6", () -> IMenuTypeExtension.create(TomeOfMadSciencePage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage7Menu>> TOME_OF_MAD_SCIENCE_PAGE_7 = REGISTRY.register("tome_of_mad_science_page_7", () -> IMenuTypeExtension.create(TomeOfMadSciencePage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage8Menu>> TOME_OF_MAD_SCIENCE_PAGE_8 = REGISTRY.register("tome_of_mad_science_page_8", () -> IMenuTypeExtension.create(TomeOfMadSciencePage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfMadSciencePage9Menu>> TOME_OF_MAD_SCIENCE_PAGE_9 = REGISTRY.register("tome_of_mad_science_page_9", () -> IMenuTypeExtension.create(TomeOfMadSciencePage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopTOCMenu>> LAPTOP_TOC = REGISTRY.register("laptop_toc", () -> IMenuTypeExtension.create(LaptopTOCMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopAnalyzeFailMenu>> LAPTOP_ANALYZE_FAIL = REGISTRY.register("laptop_analyze_fail", () -> IMenuTypeExtension.create(LaptopAnalyzeFailMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopAnalyzeSuccessMenu>> LAPTOP_ANALYZE_SUCCESS = REGISTRY.register("laptop_analyze_success", () -> IMenuTypeExtension.create(LaptopAnalyzeSuccessMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopIntroPage1Menu>> LAPTOP_INTRO_PAGE_1 = REGISTRY.register("laptop_intro_page_1", () -> IMenuTypeExtension.create(LaptopIntroPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopIntroPage2Menu>> LAPTOP_INTRO_PAGE_2 = REGISTRY.register("laptop_intro_page_2", () -> IMenuTypeExtension.create(LaptopIntroPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopIntroPage3Menu>> LAPTOP_INTRO_PAGE_3 = REGISTRY.register("laptop_intro_page_3", () -> IMenuTypeExtension.create(LaptopIntroPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopDNASampleListMenu>> LAPTOP_DNA_SAMPLE_LIST = REGISTRY.register("laptop_dna_sample_list", () -> IMenuTypeExtension.create(LaptopDNASampleListMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleFailMenu>> LAPTOP_SAMPLE_FAIL = REGISTRY.register("laptop_sample_fail", () -> IMenuTypeExtension.create(LaptopSampleFailMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleFlyMenu>> LAPTOP_SAMPLE_FLY = REGISTRY.register("laptop_sample_fly", () -> IMenuTypeExtension.create(LaptopSampleFlyMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleSerpentMenu>> LAPTOP_SAMPLE_SERPENT = REGISTRY.register("laptop_sample_serpent", () -> IMenuTypeExtension.create(LaptopSampleSerpentMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleDreadfulWatcherMenu>> LAPTOP_SAMPLE_DREADFUL_WATCHER = REGISTRY.register("laptop_sample_dreadful_watcher",
			() -> IMenuTypeExtension.create(LaptopSampleDreadfulWatcherMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleSpiderPage1Menu>> LAPTOP_SAMPLE_SPIDER_PAGE_1 = REGISTRY.register("laptop_sample_spider_page_1", () -> IMenuTypeExtension.create(LaptopSampleSpiderPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleSpiderPage2Menu>> LAPTOP_SAMPLE_SPIDER_PAGE_2 = REGISTRY.register("laptop_sample_spider_page_2", () -> IMenuTypeExtension.create(LaptopSampleSpiderPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleGuardRobotPage1Menu>> LAPTOP_SAMPLE_GUARD_ROBOT_PAGE_1 = REGISTRY.register("laptop_sample_guard_robot_page_1",
			() -> IMenuTypeExtension.create(LaptopSampleGuardRobotPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopSampleGuardRobotPage2Menu>> LAPTOP_SAMPLE_GUARD_ROBOT_PAGE_2 = REGISTRY.register("laptop_sample_guard_robot_page_2",
			() -> IMenuTypeExtension.create(LaptopSampleGuardRobotPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopCreatingStrangeSerumPage1Menu>> LAPTOP_CREATING_STRANGE_SERUM_PAGE_1 = REGISTRY.register("laptop_creating_strange_serum_page_1",
			() -> IMenuTypeExtension.create(LaptopCreatingStrangeSerumPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopCreatingStrangeSerumPage2Menu>> LAPTOP_CREATING_STRANGE_SERUM_PAGE_2 = REGISTRY.register("laptop_creating_strange_serum_page_2",
			() -> IMenuTypeExtension.create(LaptopCreatingStrangeSerumPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopCreatingStrangeSerumPage3Menu>> LAPTOP_CREATING_STRANGE_SERUM_PAGE_3 = REGISTRY.register("laptop_creating_strange_serum_page_3",
			() -> IMenuTypeExtension.create(LaptopCreatingStrangeSerumPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopCreatingRobotsPage1Menu>> LAPTOP_CREATING_ROBOTS_PAGE_1 = REGISTRY.register("laptop_creating_robots_page_1", () -> IMenuTypeExtension.create(LaptopCreatingRobotsPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaptopCreatingRobotsPage2Menu>> LAPTOP_CREATING_ROBOTS_PAGE_2 = REGISTRY.register("laptop_creating_robots_page_2", () -> IMenuTypeExtension.create(LaptopCreatingRobotsPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage1Menu>> SM_TOME_PAGE_1 = REGISTRY.register("sm_tome_page_1", () -> IMenuTypeExtension.create(SMTomePage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage2Menu>> SM_TOME_PAGE_2 = REGISTRY.register("sm_tome_page_2", () -> IMenuTypeExtension.create(SMTomePage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StabilizingSerumGUIMenu>> STABILIZING_SERUM_GUI = REGISTRY.register("stabilizing_serum_gui", () -> IMenuTypeExtension.create(StabilizingSerumGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage3Menu>> SM_TOME_PAGE_3 = REGISTRY.register("sm_tome_page_3", () -> IMenuTypeExtension.create(SMTomePage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage4Menu>> SM_TOME_PAGE_4 = REGISTRY.register("sm_tome_page_4", () -> IMenuTypeExtension.create(SMTomePage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage5Menu>> SM_TOME_PAGE_5 = REGISTRY.register("sm_tome_page_5", () -> IMenuTypeExtension.create(SMTomePage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage6Menu>> SM_TOME_PAGE_6 = REGISTRY.register("sm_tome_page_6", () -> IMenuTypeExtension.create(SMTomePage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage7Menu>> SM_TOME_PAGE_7 = REGISTRY.register("sm_tome_page_7", () -> IMenuTypeExtension.create(SMTomePage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage8Menu>> SM_TOME_PAGE_8 = REGISTRY.register("sm_tome_page_8", () -> IMenuTypeExtension.create(SMTomePage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage9Menu>> SM_TOME_PAGE_9 = REGISTRY.register("sm_tome_page_9", () -> IMenuTypeExtension.create(SMTomePage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage10Menu>> SM_TOME_PAGE_10 = REGISTRY.register("sm_tome_page_10", () -> IMenuTypeExtension.create(SMTomePage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage11Menu>> SM_TOME_PAGE_11 = REGISTRY.register("sm_tome_page_11", () -> IMenuTypeExtension.create(SMTomePage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SMTomePage12Menu>> SM_TOME_PAGE_12 = REGISTRY.register("sm_tome_page_12", () -> IMenuTypeExtension.create(SMTomePage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage1Menu>> DEATHBLOOM_PAGE_1 = REGISTRY.register("deathbloom_page_1", () -> IMenuTypeExtension.create(DeathbloomPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage2Menu>> DEATHBLOOM_PAGE_2 = REGISTRY.register("deathbloom_page_2", () -> IMenuTypeExtension.create(DeathbloomPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage3Menu>> DEATHBLOOM_PAGE_3 = REGISTRY.register("deathbloom_page_3", () -> IMenuTypeExtension.create(DeathbloomPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage4Menu>> DEATHBLOOM_PAGE_4 = REGISTRY.register("deathbloom_page_4", () -> IMenuTypeExtension.create(DeathbloomPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage5Menu>> DEATHBLOOM_PAGE_5 = REGISTRY.register("deathbloom_page_5", () -> IMenuTypeExtension.create(DeathbloomPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage6Menu>> DEATHBLOOM_PAGE_6 = REGISTRY.register("deathbloom_page_6", () -> IMenuTypeExtension.create(DeathbloomPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage7Menu>> DEATHBLOOM_PAGE_7 = REGISTRY.register("deathbloom_page_7", () -> IMenuTypeExtension.create(DeathbloomPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathbloomPage8Menu>> DEATHBLOOM_PAGE_8 = REGISTRY.register("deathbloom_page_8", () -> IMenuTypeExtension.create(DeathbloomPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AGoodAlphaPage1Menu>> A_GOOD_ALPHA_PAGE_1 = REGISTRY.register("a_good_alpha_page_1", () -> IMenuTypeExtension.create(AGoodAlphaPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AGoodAlphaPage2Menu>> A_GOOD_ALPHA_PAGE_2 = REGISTRY.register("a_good_alpha_page_2", () -> IMenuTypeExtension.create(AGoodAlphaPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AGoodAlphaPage3Menu>> A_GOOD_ALPHA_PAGE_3 = REGISTRY.register("a_good_alpha_page_3", () -> IMenuTypeExtension.create(AGoodAlphaPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage1Menu>> TOME_OF_THE_MOON_PAGE_1 = REGISTRY.register("tome_of_the_moon_page_1", () -> IMenuTypeExtension.create(TomeOfTheMoonPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage2Menu>> TOME_OF_THE_MOON_PAGE_2 = REGISTRY.register("tome_of_the_moon_page_2", () -> IMenuTypeExtension.create(TomeOfTheMoonPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage3Menu>> TOME_OF_THE_MOON_PAGE_3 = REGISTRY.register("tome_of_the_moon_page_3", () -> IMenuTypeExtension.create(TomeOfTheMoonPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage4Menu>> TOME_OF_THE_MOON_PAGE_4 = REGISTRY.register("tome_of_the_moon_page_4", () -> IMenuTypeExtension.create(TomeOfTheMoonPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage5Menu>> TOME_OF_THE_MOON_PAGE_5 = REGISTRY.register("tome_of_the_moon_page_5", () -> IMenuTypeExtension.create(TomeOfTheMoonPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage6Menu>> TOME_OF_THE_MOON_PAGE_6 = REGISTRY.register("tome_of_the_moon_page_6", () -> IMenuTypeExtension.create(TomeOfTheMoonPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage7Menu>> TOME_OF_THE_MOON_PAGE_7 = REGISTRY.register("tome_of_the_moon_page_7", () -> IMenuTypeExtension.create(TomeOfTheMoonPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage8Menu>> TOME_OF_THE_MOON_PAGE_8 = REGISTRY.register("tome_of_the_moon_page_8", () -> IMenuTypeExtension.create(TomeOfTheMoonPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage9Menu>> TOME_OF_THE_MOON_PAGE_9 = REGISTRY.register("tome_of_the_moon_page_9", () -> IMenuTypeExtension.create(TomeOfTheMoonPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfTheMoonPage10Menu>> TOME_OF_THE_MOON_PAGE_10 = REGISTRY.register("tome_of_the_moon_page_10", () -> IMenuTypeExtension.create(TomeOfTheMoonPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage1Menu>> TOME_OF_BLOODLUST_PAGE_1 = REGISTRY.register("tome_of_bloodlust_page_1", () -> IMenuTypeExtension.create(TomeOfBloodlustPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage2Menu>> TOME_OF_BLOODLUST_PAGE_2 = REGISTRY.register("tome_of_bloodlust_page_2", () -> IMenuTypeExtension.create(TomeOfBloodlustPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage3Menu>> TOME_OF_BLOODLUST_PAGE_3 = REGISTRY.register("tome_of_bloodlust_page_3", () -> IMenuTypeExtension.create(TomeOfBloodlustPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage4Menu>> TOME_OF_BLOODLUST_PAGE_4 = REGISTRY.register("tome_of_bloodlust_page_4", () -> IMenuTypeExtension.create(TomeOfBloodlustPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage5Menu>> TOME_OF_BLOODLUST_PAGE_5 = REGISTRY.register("tome_of_bloodlust_page_5", () -> IMenuTypeExtension.create(TomeOfBloodlustPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage6Menu>> TOME_OF_BLOODLUST_PAGE_6 = REGISTRY.register("tome_of_bloodlust_page_6", () -> IMenuTypeExtension.create(TomeOfBloodlustPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage7Menu>> TOME_OF_BLOODLUST_PAGE_7 = REGISTRY.register("tome_of_bloodlust_page_7", () -> IMenuTypeExtension.create(TomeOfBloodlustPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage8Menu>> TOME_OF_BLOODLUST_PAGE_8 = REGISTRY.register("tome_of_bloodlust_page_8", () -> IMenuTypeExtension.create(TomeOfBloodlustPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage9Menu>> TOME_OF_BLOODLUST_PAGE_9 = REGISTRY.register("tome_of_bloodlust_page_9", () -> IMenuTypeExtension.create(TomeOfBloodlustPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage10Menu>> TOME_OF_BLOODLUST_PAGE_10 = REGISTRY.register("tome_of_bloodlust_page_10", () -> IMenuTypeExtension.create(TomeOfBloodlustPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage11Menu>> TOME_OF_BLOODLUST_PAGE_11 = REGISTRY.register("tome_of_bloodlust_page_11", () -> IMenuTypeExtension.create(TomeOfBloodlustPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage12Menu>> TOME_OF_BLOODLUST_PAGE_12 = REGISTRY.register("tome_of_bloodlust_page_12", () -> IMenuTypeExtension.create(TomeOfBloodlustPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage13Menu>> TOME_OF_BLOODLUST_PAGE_13 = REGISTRY.register("tome_of_bloodlust_page_13", () -> IMenuTypeExtension.create(TomeOfBloodlustPage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage14Menu>> TOME_OF_BLOODLUST_PAGE_14 = REGISTRY.register("tome_of_bloodlust_page_14", () -> IMenuTypeExtension.create(TomeOfBloodlustPage14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfBloodlustPage15Menu>> TOME_OF_BLOODLUST_PAGE_15 = REGISTRY.register("tome_of_bloodlust_page_15", () -> IMenuTypeExtension.create(TomeOfBloodlustPage15Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage1Menu>> HUNTERS_FIELD_GUIDE_PAGE_1 = REGISTRY.register("hunters_field_guide_page_1", () -> IMenuTypeExtension.create(HuntersFieldGuidePage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage2Menu>> HUNTERS_FIELD_GUIDE_PAGE_2 = REGISTRY.register("hunters_field_guide_page_2", () -> IMenuTypeExtension.create(HuntersFieldGuidePage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage3Menu>> HUNTERS_FIELD_GUIDE_PAGE_3 = REGISTRY.register("hunters_field_guide_page_3", () -> IMenuTypeExtension.create(HuntersFieldGuidePage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage4Menu>> HUNTERS_FIELD_GUIDE_PAGE_4 = REGISTRY.register("hunters_field_guide_page_4", () -> IMenuTypeExtension.create(HuntersFieldGuidePage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage5Menu>> HUNTERS_FIELD_GUIDE_PAGE_5 = REGISTRY.register("hunters_field_guide_page_5", () -> IMenuTypeExtension.create(HuntersFieldGuidePage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage6Menu>> HUNTERS_FIELD_GUIDE_PAGE_6 = REGISTRY.register("hunters_field_guide_page_6", () -> IMenuTypeExtension.create(HuntersFieldGuidePage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage7Menu>> HUNTERS_FIELD_GUIDE_PAGE_7 = REGISTRY.register("hunters_field_guide_page_7", () -> IMenuTypeExtension.create(HuntersFieldGuidePage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage8Menu>> HUNTERS_FIELD_GUIDE_PAGE_8 = REGISTRY.register("hunters_field_guide_page_8", () -> IMenuTypeExtension.create(HuntersFieldGuidePage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage9Menu>> HUNTERS_FIELD_GUIDE_PAGE_9 = REGISTRY.register("hunters_field_guide_page_9", () -> IMenuTypeExtension.create(HuntersFieldGuidePage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage10Menu>> HUNTERS_FIELD_GUIDE_PAGE_10 = REGISTRY.register("hunters_field_guide_page_10", () -> IMenuTypeExtension.create(HuntersFieldGuidePage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage11Menu>> HUNTERS_FIELD_GUIDE_PAGE_11 = REGISTRY.register("hunters_field_guide_page_11", () -> IMenuTypeExtension.create(HuntersFieldGuidePage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage12Menu>> HUNTERS_FIELD_GUIDE_PAGE_12 = REGISTRY.register("hunters_field_guide_page_12", () -> IMenuTypeExtension.create(HuntersFieldGuidePage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage13Menu>> HUNTERS_FIELD_GUIDE_PAGE_13 = REGISTRY.register("hunters_field_guide_page_13", () -> IMenuTypeExtension.create(HuntersFieldGuidePage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage14Menu>> HUNTERS_FIELD_GUIDE_PAGE_14 = REGISTRY.register("hunters_field_guide_page_14", () -> IMenuTypeExtension.create(HuntersFieldGuidePage14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HuntersFieldGuidePage15Menu>> HUNTERS_FIELD_GUIDE_PAGE_15 = REGISTRY.register("hunters_field_guide_page_15", () -> IMenuTypeExtension.create(HuntersFieldGuidePage15Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MalachiteGUIMenu>> MALACHITE_GUI = REGISTRY.register("malachite_gui", () -> IMenuTypeExtension.create(MalachiteGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage1Menu>> TOME_OF_INFERNAL_POWER_PAGE_1 = REGISTRY.register("tome_of_infernal_power_page_1", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage2Menu>> TOME_OF_INFERNAL_POWER_PAGE_2 = REGISTRY.register("tome_of_infernal_power_page_2", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage3Menu>> TOME_OF_INFERNAL_POWER_PAGE_3 = REGISTRY.register("tome_of_infernal_power_page_3", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage4Menu>> TOME_OF_INFERNAL_POWER_PAGE_4 = REGISTRY.register("tome_of_infernal_power_page_4", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage5Menu>> TOME_OF_INFERNAL_POWER_PAGE_5 = REGISTRY.register("tome_of_infernal_power_page_5", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage6Menu>> TOME_OF_INFERNAL_POWER_PAGE_6 = REGISTRY.register("tome_of_infernal_power_page_6", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MorbidWorkTableRecipeHelperMenu>> MORBID_WORK_TABLE_RECIPE_HELPER = REGISTRY.register("morbid_work_table_recipe_helper",
			() -> IMenuTypeExtension.create(MorbidWorkTableRecipeHelperMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeathlyWoodGUIMenu>> DEATHLY_WOOD_GUI = REGISTRY.register("deathly_wood_gui", () -> IMenuTypeExtension.create(DeathlyWoodGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage7Menu>> TOME_OF_INFERNAL_POWER_PAGE_7 = REGISTRY.register("tome_of_infernal_power_page_7", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage8Menu>> TOME_OF_INFERNAL_POWER_PAGE_8 = REGISTRY.register("tome_of_infernal_power_page_8", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NetherAltarRecipeHelperMenu>> NETHER_ALTAR_RECIPE_HELPER = REGISTRY.register("nether_altar_recipe_helper", () -> IMenuTypeExtension.create(NetherAltarRecipeHelperMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage9Menu>> TOME_OF_INFERNAL_POWER_PAGE_9 = REGISTRY.register("tome_of_infernal_power_page_9", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage10Menu>> TOME_OF_INFERNAL_POWER_PAGE_10 = REGISTRY.register("tome_of_infernal_power_page_10", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage11Menu>> TOME_OF_INFERNAL_POWER_PAGE_11 = REGISTRY.register("tome_of_infernal_power_page_11", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage11Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage12Menu>> TOME_OF_INFERNAL_POWER_PAGE_12 = REGISTRY.register("tome_of_infernal_power_page_12", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage12Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage13Menu>> TOME_OF_INFERNAL_POWER_PAGE_13 = REGISTRY.register("tome_of_infernal_power_page_13", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage13Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage14Menu>> TOME_OF_INFERNAL_POWER_PAGE_14 = REGISTRY.register("tome_of_infernal_power_page_14", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage15Menu>> TOME_OF_INFERNAL_POWER_PAGE_15 = REGISTRY.register("tome_of_infernal_power_page_15", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage15Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage16Menu>> TOME_OF_INFERNAL_POWER_PAGE_16 = REGISTRY.register("tome_of_infernal_power_page_16", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage16Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfInfernalPowerPage17Menu>> TOME_OF_INFERNAL_POWER_PAGE_17 = REGISTRY.register("tome_of_infernal_power_page_17", () -> IMenuTypeExtension.create(TomeOfInfernalPowerPage17Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage1Menu>> TOME_OF_FUN_AND_GAMES_PAGE_1 = REGISTRY.register("tome_of_fun_and_games_page_1", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage2Menu>> TOME_OF_FUN_AND_GAMES_PAGE_2 = REGISTRY.register("tome_of_fun_and_games_page_2", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage3Menu>> TOME_OF_FUN_AND_GAMES_PAGE_3 = REGISTRY.register("tome_of_fun_and_games_page_3", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ConfectioneryTableRecipeHelperMenu>> CONFECTIONERY_TABLE_RECIPE_HELPER = REGISTRY.register("confectionery_table_recipe_helper",
			() -> IMenuTypeExtension.create(ConfectioneryTableRecipeHelperMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage4Menu>> TOME_OF_FUN_AND_GAMES_PAGE_4 = REGISTRY.register("tome_of_fun_and_games_page_4", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage5Menu>> TOME_OF_FUN_AND_GAMES_PAGE_5 = REGISTRY.register("tome_of_fun_and_games_page_5", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage6Menu>> TOME_OF_FUN_AND_GAMES_PAGE_6 = REGISTRY.register("tome_of_fun_and_games_page_6", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage7Menu>> TOME_OF_FUN_AND_GAMES_PAGE_7 = REGISTRY.register("tome_of_fun_and_games_page_7", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage8Menu>> TOME_OF_FUN_AND_GAMES_PAGE_8 = REGISTRY.register("tome_of_fun_and_games_page_8", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfFunAndGamesPage9Menu>> TOME_OF_FUN_AND_GAMES_PAGE_9 = REGISTRY.register("tome_of_fun_and_games_page_9", () -> IMenuTypeExtension.create(TomeOfFunAndGamesPage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage1Menu>> TOME_OF_VIOLENCE_PAGE_1 = REGISTRY.register("tome_of_violence_page_1", () -> IMenuTypeExtension.create(TomeOfViolencePage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage2Menu>> TOME_OF_VIOLENCE_PAGE_2 = REGISTRY.register("tome_of_violence_page_2", () -> IMenuTypeExtension.create(TomeOfViolencePage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage3Menu>> TOME_OF_VIOLENCE_PAGE_3 = REGISTRY.register("tome_of_violence_page_3", () -> IMenuTypeExtension.create(TomeOfViolencePage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage4Menu>> TOME_OF_VIOLENCE_PAGE_4 = REGISTRY.register("tome_of_violence_page_4", () -> IMenuTypeExtension.create(TomeOfViolencePage4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage5Menu>> TOME_OF_VIOLENCE_PAGE_5 = REGISTRY.register("tome_of_violence_page_5", () -> IMenuTypeExtension.create(TomeOfViolencePage5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage6Menu>> TOME_OF_VIOLENCE_PAGE_6 = REGISTRY.register("tome_of_violence_page_6", () -> IMenuTypeExtension.create(TomeOfViolencePage6Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage7Menu>> TOME_OF_VIOLENCE_PAGE_7 = REGISTRY.register("tome_of_violence_page_7", () -> IMenuTypeExtension.create(TomeOfViolencePage7Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage8Menu>> TOME_OF_VIOLENCE_PAGE_8 = REGISTRY.register("tome_of_violence_page_8", () -> IMenuTypeExtension.create(TomeOfViolencePage8Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage9Menu>> TOME_OF_VIOLENCE_PAGE_9 = REGISTRY.register("tome_of_violence_page_9", () -> IMenuTypeExtension.create(TomeOfViolencePage9Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TomeOfViolencePage10Menu>> TOME_OF_VIOLENCE_PAGE_10 = REGISTRY.register("tome_of_violence_page_10", () -> IMenuTypeExtension.create(TomeOfViolencePage10Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OpenLoreBinder14Menu>> OPEN_LORE_BINDER_14 = REGISTRY.register("open_lore_binder_14", () -> IMenuTypeExtension.create(OpenLoreBinder14Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TestTubeMixerRecipesMenu>> TEST_TUBE_MIXER_RECIPES = REGISTRY.register("test_tube_mixer_recipes", () -> IMenuTypeExtension.create(TestTubeMixerRecipesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GhostlyAppleGUIMenu>> GHOSTLY_APPLE_GUI = REGISTRY.register("ghostly_apple_gui", () -> IMenuTypeExtension.create(GhostlyAppleGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ObstructionPowderGUIMenu>> OBSTRUCTION_POWDER_GUI = REGISTRY.register("obstruction_powder_gui", () -> IMenuTypeExtension.create(ObstructionPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FrogifyPowderGUIMenu>> FROGIFY_POWDER_GUI = REGISTRY.register("frogify_powder_gui", () -> IMenuTypeExtension.create(FrogifyPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ParalysisPowderGUIMenu>> PARALYSIS_POWDER_GUI = REGISTRY.register("paralysis_powder_gui", () -> IMenuTypeExtension.create(ParalysisPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SpiritPowderGUIMenu>> SPIRIT_POWDER_GUI = REGISTRY.register("spirit_powder_gui", () -> IMenuTypeExtension.create(SpiritPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SinkingPowderGUIMenu>> SINKING_POWDER_GUI = REGISTRY.register("sinking_powder_gui", () -> IMenuTypeExtension.create(SinkingPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BloodBottleGUIMenu>> BLOOD_BOTTLE_GUI = REGISTRY.register("blood_bottle_gui", () -> IMenuTypeExtension.create(BloodBottleGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VampireCurePowderGUIMenu>> VAMPIRE_CURE_POWDER_GUI = REGISTRY.register("vampire_cure_powder_gui", () -> IMenuTypeExtension.create(VampireCurePowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WerewolfCurePowderGUIMenu>> WEREWOLF_CURE_POWDER_GUI = REGISTRY.register("werewolf_cure_powder_gui", () -> IMenuTypeExtension.create(WerewolfCurePowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UndeathCurePowderGUIMenu>> UNDEATH_CURE_POWDER_GUI = REGISTRY.register("undeath_cure_powder_gui", () -> IMenuTypeExtension.create(UndeathCurePowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExplosionPowderGUIMenu>> EXPLOSION_POWDER_GUI = REGISTRY.register("explosion_powder_gui", () -> IMenuTypeExtension.create(ExplosionPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ChickenifyPowderGUIMenu>> CHICKENIFY_POWDER_GUI = REGISTRY.register("chickenify_powder_gui", () -> IMenuTypeExtension.create(ChickenifyPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VanishingPowderGUIMenu>> VANISHING_POWDER_GUI = REGISTRY.register("vanishing_powder_gui", () -> IMenuTypeExtension.create(VanishingPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GoldDustGUIMenu>> GOLD_DUST_GUI = REGISTRY.register("gold_dust_gui", () -> IMenuTypeExtension.create(GoldDustGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PumpkinPowderGUIMenu>> PUMPKIN_POWDER_GUI = REGISTRY.register("pumpkin_powder_gui", () -> IMenuTypeExtension.create(PumpkinPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MidasCursePowderGUIMenu>> MIDAS_CURSE_POWDER_GUI = REGISTRY.register("midas_curse_powder_gui", () -> IMenuTypeExtension.create(MidasCursePowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FlightPowderGUIMenu>> FLIGHT_POWDER_GUI = REGISTRY.register("flight_powder_gui", () -> IMenuTypeExtension.create(FlightPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BookishPowderGUIMenu>> BOOKISH_POWDER_GUI = REGISTRY.register("bookish_powder_gui", () -> IMenuTypeExtension.create(BookishPowderGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CharmAltarRecipeGUIMenu>> CHARM_ALTAR_RECIPE_GUI = REGISTRY.register("charm_altar_recipe_gui", () -> IMenuTypeExtension.create(CharmAltarRecipeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TheEyeletGUIMenu>> THE_EYELET_GUI = REGISTRY.register("the_eyelet_gui", () -> IMenuTypeExtension.create(TheEyeletGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InterrogationNoteGUIMenu>> INTERROGATION_NOTE_GUI = REGISTRY.register("interrogation_note_gui", () -> IMenuTypeExtension.create(InterrogationNoteGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MurkanusMarthPage1Menu>> MURKANUS_MARTH_PAGE_1 = REGISTRY.register("murkanus_marth_page_1", () -> IMenuTypeExtension.create(MurkanusMarthPage1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MurkanusMarthPage2Menu>> MURKANUS_MARTH_PAGE_2 = REGISTRY.register("murkanus_marth_page_2", () -> IMenuTypeExtension.create(MurkanusMarthPage2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MurkanusMarthPage3Menu>> MURKANUS_MARTH_PAGE_3 = REGISTRY.register("murkanus_marth_page_3", () -> IMenuTypeExtension.create(MurkanusMarthPage3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MudPotGUIMenu>> MUD_POT_GUI = REGISTRY.register("mud_pot_gui", () -> IMenuTypeExtension.create(MudPotGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PaleStalkWoodGUIMenu>> PALE_STALK_WOOD_GUI = REGISTRY.register("pale_stalk_wood_gui", () -> IMenuTypeExtension.create(PaleStalkWoodGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SlugSoupRecipeGUIMenu>> SLUG_SOUP_RECIPE_GUI = REGISTRY.register("slug_soup_recipe_gui", () -> IMenuTypeExtension.create(SlugSoupRecipeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CaterpillarStewRecipeGUIMenu>> CATERPILLAR_STEW_RECIPE_GUI = REGISTRY.register("caterpillar_stew_recipe_gui", () -> IMenuTypeExtension.create(CaterpillarStewRecipeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MurkyMedleyRecipeGUIMenu>> MURKY_MEDLEY_RECIPE_GUI = REGISTRY.register("murky_medley_recipe_gui", () -> IMenuTypeExtension.create(MurkyMedleyRecipeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PumpionCottageWelcomeGUIMenu>> PUMPION_COTTAGE_WELCOME_GUI = REGISTRY.register("pumpion_cottage_welcome_gui", () -> IMenuTypeExtension.create(PumpionCottageWelcomeGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GlowingPumpkinTreesGUIMenu>> GLOWING_PUMPKIN_TREES_GUI = REGISTRY.register("glowing_pumpkin_trees_gui", () -> IMenuTypeExtension.create(GlowingPumpkinTreesGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArchaeologicalNoteGUIMenu>> ARCHAEOLOGICAL_NOTE_GUI = REGISTRY.register("archaeological_note_gui", () -> IMenuTypeExtension.create(ArchaeologicalNoteGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TangledTwigGUIMenu>> TANGLED_TWIG_GUI = REGISTRY.register("tangled_twig_gui", () -> IMenuTypeExtension.create(TangledTwigGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ToDigFasterGUIMenu>> TO_DIG_FASTER_GUI = REGISTRY.register("to_dig_faster_gui", () -> IMenuTypeExtension.create(ToDigFasterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ToKeepArmorGUIMenu>> TO_KEEP_ARMOR_GUI = REGISTRY.register("to_keep_armor_gui", () -> IMenuTypeExtension.create(ToKeepArmorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForGreaterKnockbackGUIMenu>> FOR_GREATER_KNOCKBACK_GUI = REGISTRY.register("for_greater_knockback_gui", () -> IMenuTypeExtension.create(ForGreaterKnockbackGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ToStunPreyGUIMenu>> TO_STUN_PREY_GUI = REGISTRY.register("to_stun_prey_gui", () -> IMenuTypeExtension.create(ToStunPreyGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ToReduceFallDamageGUIMenu>> TO_REDUCE_FALL_DAMAGE_GUI = REGISTRY.register("to_reduce_fall_damage_gui", () -> IMenuTypeExtension.create(ToReduceFallDamageGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForHandlingItemsGUIMenu>> FOR_HANDLING_ITEMS_GUI = REGISTRY.register("for_handling_items_gui", () -> IMenuTypeExtension.create(ForHandlingItemsGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof MonstrousWorldModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}