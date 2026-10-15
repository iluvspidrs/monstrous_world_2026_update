package net.mcreator.monstrousworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.OneTradeButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OneTradeScreen extends AbstractContainerScreen<OneTradeMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/one_trade.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/tradebackgroundonetrade.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/cooked_beef.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/darkened_iron_ingot.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_flymutant_blood.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/darkened_iron_ingot.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_serpent_blood.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/darkened_iron_ingot.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_blood.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/gold_ingot.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_goblin_blood.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/red_onyx_gem.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_troll_blood.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/darkened_iron_ingot.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_swampmonster_blood.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/aquastone.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_werewolf_blood.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/deathbloom.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/dectector3.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_deathbloom.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("monstrous_world:textures/screens/poisoned_skull.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("monstrous_world:textures/screens/deathbloominstructions.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_poisoned.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("monstrous_world:textures/screens/rotten_flesh.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("monstrous_world:textures/screens/digested_rotten_flesh.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("monstrous_world:textures/screens/tin_ingot.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_dreadful_tears.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("monstrous_world:textures/screens/tradetextgoblintohuntercomplete.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("monstrous_world:textures/screens/dropped_society_plans.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("monstrous_world:textures/screens/purified_silver.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("monstrous_world:textures/screens/modified_silver_dagger_unknown.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("monstrous_world:textures/screens/purified_silver.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("monstrous_world:textures/screens/tradetextgoblintohunteradvanced.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("monstrous_world:textures/screens/trolltradetextgoblin.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("monstrous_world:textures/screens/electrum_nugget.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("monstrous_world:textures/screens/gold_ingot.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("monstrous_world:textures/screens/trolltradetextblood.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("monstrous_world:textures/screens/tin_ingot.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_troll_blood.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("monstrous_world:textures/screens/trolltradetext.png");
	private static final ResourceLocation IMAGE_39 = ResourceLocation.parse("monstrous_world:textures/screens/troll_ores_trade.png");
	private static final ResourceLocation IMAGE_40 = ResourceLocation.parse("monstrous_world:textures/screens/troll_swords_trade.png");
	private static final ResourceLocation IMAGE_41 = ResourceLocation.parse("monstrous_world:textures/screens/troll_ores_trade.png");
	private static final ResourceLocation IMAGE_42 = ResourceLocation.parse("monstrous_world:textures/screens/troll_pickaxes_trade.png");
	private static final ResourceLocation IMAGE_43 = ResourceLocation.parse("monstrous_world:textures/screens/troll_ores_trade.png");
	private static final ResourceLocation IMAGE_44 = ResourceLocation.parse("monstrous_world:textures/screens/troll_axes_trade.png");
	private static final ResourceLocation IMAGE_45 = ResourceLocation.parse("monstrous_world:textures/screens/troll_ores_trade.png");
	private static final ResourceLocation IMAGE_46 = ResourceLocation.parse("monstrous_world:textures/screens/troll_shovels_trade.png");
	private static final ResourceLocation IMAGE_47 = ResourceLocation.parse("monstrous_world:textures/screens/troll_ores_trade.png");
	private static final ResourceLocation IMAGE_48 = ResourceLocation.parse("monstrous_world:textures/screens/troll_hoes_trade.png");
	private static final ResourceLocation IMAGE_49 = ResourceLocation.parse("monstrous_world:textures/screens/electrum_nugget.png");
	private static final ResourceLocation IMAGE_50 = ResourceLocation.parse("monstrous_world:textures/screens/armor_core.png");
	private static final ResourceLocation IMAGE_51 = ResourceLocation.parse("monstrous_world:textures/screens/goblintradetrolltext.png");
	private static final ResourceLocation IMAGE_52 = ResourceLocation.parse("monstrous_world:textures/screens/sorcerertradenormal.png");
	private static final ResourceLocation IMAGE_53 = ResourceLocation.parse("monstrous_world:textures/screens/tigers_eye_gem_2.png");
	private static final ResourceLocation IMAGE_54 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_witchery.png");
	private static final ResourceLocation IMAGE_55 = ResourceLocation.parse("monstrous_world:textures/screens/malachite_gem.png");
	private static final ResourceLocation IMAGE_56 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_goblin.png");
	private static final ResourceLocation IMAGE_57 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_troll.png");
	private static final ResourceLocation IMAGE_58 = ResourceLocation.parse("monstrous_world:textures/screens/black_onyx_gem.png");
	private static final ResourceLocation IMAGE_59 = ResourceLocation.parse("monstrous_world:textures/screens/green_agate.png");
	private static final ResourceLocation IMAGE_60 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_sorcery.png");
	private static final ResourceLocation IMAGE_61 = ResourceLocation.parse("monstrous_world:textures/screens/pale_agate.png");
	private static final ResourceLocation IMAGE_62 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_mad_science.png");
	private static final ResourceLocation IMAGE_63 = ResourceLocation.parse("monstrous_world:textures/screens/blue_agate.png");
	private static final ResourceLocation IMAGE_64 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_swamp.png");
	private static final ResourceLocation IMAGE_65 = ResourceLocation.parse("monstrous_world:textures/screens/moonstone.png");
	private static final ResourceLocation IMAGE_66 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_moon.png");
	private static final ResourceLocation IMAGE_67 = ResourceLocation.parse("monstrous_world:textures/screens/red_onyx_gem.png");
	private static final ResourceLocation IMAGE_68 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_bloodlust.png");
	private static final ResourceLocation IMAGE_69 = ResourceLocation.parse("monstrous_world:textures/screens/dark_essence_dust.png");
	private static final ResourceLocation IMAGE_70 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_corruption_wielder.png");
	private static final ResourceLocation IMAGE_71 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_dark_market.png");
	private static final ResourceLocation IMAGE_72 = ResourceLocation.parse("monstrous_world:textures/screens/nethergem.png");
	private static final ResourceLocation IMAGE_73 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_infernal_power.png");
	private static final ResourceLocation IMAGE_74 = ResourceLocation.parse("monstrous_world:textures/screens/diamond.png");
	private static final ResourceLocation IMAGE_75 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_fun_and_games.png");
	private static final ResourceLocation IMAGE_76 = ResourceLocation.parse("monstrous_world:textures/screens/red_onyx_gem.png");
	private static final ResourceLocation IMAGE_77 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_violence.png");
	private static final ResourceLocation IMAGE_78 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_79 = ResourceLocation.parse("monstrous_world:textures/screens/victim_heart.png");
	private static final ResourceLocation IMAGE_80 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_81 = ResourceLocation.parse("monstrous_world:textures/screens/jar_of_eyes.png");
	private static final ResourceLocation IMAGE_82 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_83 = ResourceLocation.parse("monstrous_world:textures/screens/pure_fear.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("monstrous_world:textures/screens/jar_of_eyes.png");
	private static final ResourceLocation SPRITE_1 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_butcher_knife_rotated.png");

	public OneTradeScreen(OneTradeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 225;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (VampireBloodTradeWerewolfProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_cooked_beef"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeEyeMutantProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_darkened_iron_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeEyeMutantProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_eye_mutant_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeFlyMutantProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_fly_mutant_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeWerewolfProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_werewolf_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeGoblinProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_goblin_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeTrollProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_troll_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeSwampmonsterProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_swampmonster_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeHumanProcedure.execute(entity))
			if (mouseX > leftPos + 58 && mouseX < leftPos + 82 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeSerpentMutantProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_serpent_mutant_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeFlyMutantProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 22 && mouseY < topPos + 46) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_darkened_iron_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeSerpentMutantProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_darkened_iron_ingot2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeHumanProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_gold_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeGoblinProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_sardonyx"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeTrollProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_darkened_iron_ingot3"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireBloodTradeSwampmonsterProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_swamp_crystal"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterDeathbloomTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_deathbloom"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterDeathbloomTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_monster_detector"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterSkullTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_poisoned_skull"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterSkullTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_deathbloom_instructions"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (FlyMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_rotten_flesh"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (FlyMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_digested_rotten_flesh"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (EyeMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tin_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (EyeMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_dreadful_tears"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_society_plans"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_purified_silver"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_modified_silver_dagger"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_purified_silver1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (TrollTradeTextGoblinProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_electrum_nugget"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (TrollTradeTextGoblinProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_gold_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (TrollTradeTextBloodProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tin_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (TrollTradeTextBloodProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_bottle_of_troll_blood1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_one_of_these_ores"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_alloy_sword"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_one_of_these_ores1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_alloy_pickaxe"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_alloy_axe"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_one_of_these_ores2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_alloy_shovel"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_one_of_these_ores3"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_any_one_of_these_ores4"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Troll5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 44 && mouseY < topPos + 68) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_alloy_hoe"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeTrollProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_electrum_nugget1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeTrollProcedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_armor_core"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade1Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tigers_eye"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade1Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_witchery"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade2Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_malachite"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade2Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_the_goblin"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade3Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_the_troll"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade3Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_black_onyx"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade4Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_green_agate"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade4Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_sorcery"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade5Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_pale_agate"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade5Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_mad_science"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade6Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_blue_agate"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade6Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_the_swamp"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade7Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_moonstone"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade7Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_the_moon"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade8Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_sardonyx1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade8Procedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_bloodlust"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade9Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_dark_essence_dust"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SorcererTrade9Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_tome_of_darkness"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade1Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_nether_gem"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade1Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_enchanted_tome_of_infernal_power"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade2Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_diamond"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade2Procedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_enchanted_tome_of_fun_and_games"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade3Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_sardonyx2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DMTrade3Procedure.execute(entity))
			if (mouseX > leftPos + 139 && mouseX < leftPos + 163 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_enchanted_tome_of_violence"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeManiacLevel1Procedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_jar_of_eyes"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeManiacLevel1Procedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_infernalbutcherknife"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_infernal_iron_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_victim_heart"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_jar_of_eyes1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_infernal_iron_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 20 && mouseY < topPos + 44) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_infernal_iron_ingot2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ManiacTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 138 && mouseX < leftPos + 162 && mouseY > topPos + 21 && mouseY < topPos + 45) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.one_trade.tooltip_pure_fear"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + -22, 0, 0, 224, 101, 224, 101);
		if (VampireBloodTradeWerewolfProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeEyeMutantProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeFlyMutantProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (VampireBloodTradeFlyMutantProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeSerpentMutantProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (VampireBloodTradeSerpentMutantProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeHumanProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 62, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeHumanProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeGoblinProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (VampireBloodTradeGoblinProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeTrollProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (VampireBloodTradeTrollProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeSwampmonsterProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (VampireBloodTradeSwampmonsterProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (VampireBloodTradeWerewolfProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 62, this.topPos + 27, 0, 0, 18, 18, 18, 18);
		}
		if (SwampmonsterDeathbloomTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterDeathbloomTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 62, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterDeathbloomTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 14, this.topPos + -4, 0, 0, 194, 18, 194, 18);
		}
		if (SwampmonsterSkullTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 62, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterSkullTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterSkullTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 14, this.topPos + -4, 0, 0, 194, 18, 194, 18);
		}
		if (FlyMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 62, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (FlyMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (EyeMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 62, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (EyeMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 143, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 23, this.topPos + -4, 0, 0, 177, 18, 177, 18);
		}
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 23, this.topPos + -4, 0, 0, 177, 18, 177, 18);
		}
		if (TrollTradeTextGoblinProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 19, this.topPos + -4, 0, 0, 184, 18, 184, 18);
		}
		if (TrollTradeTextGoblinProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (TrollTradeTextGoblinProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (TrollTradeTextBloodProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 19, this.topPos + -4, 0, 0, 184, 18, 184, 18);
		}
		if (TrollTradeTextBloodProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (TrollTradeTextBloodProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 142, this.topPos + 26, 0, 0, 18, 18, 18, 18);
		}
		if (TrollTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 19, this.topPos + -4, 0, 0, 184, 18, 184, 18);
		}
		if (TrollTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_39, this.leftPos + 35, this.topPos + 47, 0, 0, 52, 18, 52, 18);
		}
		if (Troll1TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_40, this.leftPos + 136, this.topPos + 48, 0, 0, 52, 18, 52, 18);
		}
		if (Troll2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_41, this.leftPos + 35, this.topPos + 47, 0, 0, 52, 18, 52, 18);
		}
		if (Troll2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_42, this.leftPos + 136, this.topPos + 48, 0, 0, 52, 18, 52, 18);
		}
		if (Troll3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_43, this.leftPos + 35, this.topPos + 47, 0, 0, 52, 18, 52, 18);
		}
		if (Troll3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_44, this.leftPos + 135, this.topPos + 48, 0, 0, 52, 18, 52, 18);
		}
		if (Troll4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_45, this.leftPos + 35, this.topPos + 47, 0, 0, 52, 18, 52, 18);
		}
		if (Troll4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_46, this.leftPos + 136, this.topPos + 48, 0, 0, 52, 18, 52, 18);
		}
		if (Troll5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_47, this.leftPos + 35, this.topPos + 47, 0, 0, 52, 18, 52, 18);
		}
		if (Troll5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_48, this.leftPos + 134, this.topPos + 49, 0, 0, 52, 18, 52, 18);
		}
		if (GoblinTradeTrollProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_49, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTrollProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_50, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTrollTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_51, this.leftPos + 20, this.topPos + -5, 0, 0, 184, 18, 184, 18);
		}
		if (SorcererTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_52, this.leftPos + 20, this.topPos + -5, 0, 0, 184, 18, 184, 18);
		}
		if (SorcererTrade1Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_53, this.leftPos + 61, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade1Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_54, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade2Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_55, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade2Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_56, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade3Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_57, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade3Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_58, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade4Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_59, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade4Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_60, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade5Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_61, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade5Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_62, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade6Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_63, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade6Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_64, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade7Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_65, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade7Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_66, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade8Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_67, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade8Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_68, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade9Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_69, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (SorcererTrade9Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_70, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_71, this.leftPos + 20, this.topPos + -5, 0, 0, 177, 18, 177, 18);
		}
		if (DMTrade1Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_72, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTrade1Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_73, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTrade2Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_74, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTrade2Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_75, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTrade3Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_76, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DMTrade3Procedure.execute(entity)) {
			guiGraphics.blit(IMAGE_77, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_78, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_79, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_80, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_81, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_82, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (ManiacTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_83, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeManiacLevel1Procedure.execute(entity)) {
			guiGraphics.blit(SPRITE_0, this.leftPos + 61, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeManiacLevel1Procedure.execute(entity)) {
			guiGraphics.blit(SPRITE_1, this.leftPos + 143, this.topPos + 28, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (VampireBloodTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_31"), 161, 36, -52, false);
		if (SwampmonsterDeathbloomTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_10"), 80, 36, -52, false);
		if (SwampmonsterSkullTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_101"), 80, 36, -52, false);
		if (FlyMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_32"), 80, 36, -52, false);
		if (FlyMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_3"), 161, 36, -52, false);
		if (EyeMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_4"), 80, 36, -52, false);
		if (HunterToGoblinCompleteTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_6"), 161, 36, -52, false);
		if (HunterToGoblinAdvancedTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_33"), 161, 36, -52, false);
		if (TrollTradeTextGoblinProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_321"), 80, 36, -52, false);
		if (TrollTradeTextGoblinProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_8"), 161, 36, -52, false);
		if (TrollTradeTextBloodProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_81"), 80, 36, -52, false);
		if (TrollTradeTextBloodProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_41"), 161, 36, -52, false);
		if (Troll1TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_322"), 42, 59, -52, false);
		if (Troll1TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_323"), 62, 59, -52, false);
		if (Troll1TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_42"), 83, 59, -52, false);
		if (Troll2TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_324"), 42, 59, -52, false);
		if (Troll2TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_325"), 62, 59, -52, false);
		if (Troll2TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_43"), 83, 59, -52, false);
		if (Troll3TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_326"), 42, 59, -52, false);
		if (Troll3TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_327"), 62, 59, -52, false);
		if (Troll3TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_44"), 83, 59, -52, false);
		if (Troll4TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_16"), 42, 59, -52, false);
		if (Troll4TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_161"), 62, 59, -52, false);
		if (Troll4TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_2"), 84, 59, -52, false);
		if (Troll5TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_162"), 42, 59, -52, false);
		if (Troll5TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_163"), 62, 59, -52, false);
		if (Troll5TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_21"), 84, 59, -52, false);
		if (GoblinTradeTrollProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_9"), 80, 36, -52, false);
		if (SorcererTradeHeadingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_328"), 80, 36, -52, false);
		if (DMTradeHeadingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_24"), 80, 36, -52, false);
		if (DemonTradeManiacLevel1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_trade_me_a_jar_of_eyes_to_get"), 30, -6, -52, false);
		if (DemonTradeManiacLevel1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_a_special_knife"), 65, 5, -52, false);
		if (ManiacTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_61"), 80, 36, -52, false);
		if (ManiacTrade2ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_34"), 80, 36, -52, false);
		if (ManiacTrade3ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_82"), 80, 36, -52, false);
		if (VampireBloodTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_use_a_bloodletter_and_a_bottle"), 21, -6, -52, false);
		if (VampireBloodTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.one_trade.label_your_off_hand_to_donate_blood"), 30, 5, -52, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_forward_button = new ImageButton(this.leftPos + 102, this.topPos + 30, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = OneTradeScreen.this.x;
					int y = OneTradeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OneTradeButtonMessage(0, x, y, z));
						OneTradeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
	}
}