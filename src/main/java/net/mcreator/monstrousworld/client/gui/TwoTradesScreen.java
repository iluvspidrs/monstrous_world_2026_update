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

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.TwoTradesButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TwoTradesScreen extends AbstractContainerScreen<TwoTradesMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/two_trades.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/tradebackground1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/slime_blossom.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/image_paralysis_powder.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/hint_of_insanity.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_dreadful_tears.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/finger_grass.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/image_paralysis_powder.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/charm_of_cleansing.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/lunar_bloom.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/digested_rotten_flesh.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/despawnpowder.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/spiritdust.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/venom_bottle.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/charm_of_possession_protection.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/midas_powder.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/venom_bottle.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/pumpkin_essence.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("monstrous_world:textures/screens/sinking_powder.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_dreadful_tears.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("monstrous_world:textures/screens/insanosus.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("monstrous_world:textures/screens/chickenify_powder.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("monstrous_world:textures/screens/charm_of_healing.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("monstrous_world:textures/screens/digested_rotten_flesh.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("monstrous_world:textures/screens/pumpess_flower.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("monstrous_world:textures/screens/frogify_image.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("monstrous_world:textures/screens/reanimation_essence.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("monstrous_world:textures/screens/soulflower_immature.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("monstrous_world:textures/screens/explosion_powder.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("monstrous_world:textures/screens/vile_lattice.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("monstrous_world:textures/screens/insanosus.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("monstrous_world:textures/screens/obstruction_powder.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("monstrous_world:textures/screens/finger_grass.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("monstrous_world:textures/screens/slime_blossom.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_39 = ResourceLocation.parse("monstrous_world:textures/screens/pumpkin_powder.png");
	private static final ResourceLocation IMAGE_40 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bulb.png");
	private static final ResourceLocation IMAGE_41 = ResourceLocation.parse("monstrous_world:textures/screens/vile_lattice.png");
	private static final ResourceLocation IMAGE_42 = ResourceLocation.parse("monstrous_world:textures/screens/vampire_cure_powder.png");
	private static final ResourceLocation IMAGE_43 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_44 = ResourceLocation.parse("monstrous_world:textures/screens/lunar_bloom.png");
	private static final ResourceLocation IMAGE_45 = ResourceLocation.parse("monstrous_world:textures/screens/pumpess_flower.png");
	private static final ResourceLocation IMAGE_46 = ResourceLocation.parse("monstrous_world:textures/screens/werewolfcurepowder.png");
	private static final ResourceLocation IMAGE_47 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_48 = ResourceLocation.parse("monstrous_world:textures/screens/deathcatcher.png");
	private static final ResourceLocation IMAGE_49 = ResourceLocation.parse("monstrous_world:textures/screens/finger_grass.png");
	private static final ResourceLocation IMAGE_50 = ResourceLocation.parse("monstrous_world:textures/screens/undeath_cure_powder.png");
	private static final ResourceLocation IMAGE_51 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_52 = ResourceLocation.parse("monstrous_world:textures/screens/vampiretovampiretradetext.png");
	private static final ResourceLocation IMAGE_53 = ResourceLocation.parse("monstrous_world:textures/screens/red_onyx_gem.png");
	private static final ResourceLocation IMAGE_54 = ResourceLocation.parse("monstrous_world:textures/screens/bottle_of_blood.png");
	private static final ResourceLocation IMAGE_55 = ResourceLocation.parse("monstrous_world:textures/screens/gold_ingot.png");
	private static final ResourceLocation IMAGE_56 = ResourceLocation.parse("monstrous_world:textures/screens/amulet_of_reserve.png");
	private static final ResourceLocation IMAGE_57 = ResourceLocation.parse("monstrous_world:textures/screens/madscientisttradetext.png");
	private static final ResourceLocation IMAGE_58 = ResourceLocation.parse("monstrous_world:textures/screens/glowstone_dust.png");
	private static final ResourceLocation IMAGE_59 = ResourceLocation.parse("monstrous_world:textures/screens/tin_ingot.png");
	private static final ResourceLocation IMAGE_60 = ResourceLocation.parse("monstrous_world:textures/screens/syringe_cure_serum.png");
	private static final ResourceLocation IMAGE_61 = ResourceLocation.parse("monstrous_world:textures/screens/syringe_cure_serum.png");
	private static final ResourceLocation IMAGE_62 = ResourceLocation.parse("monstrous_world:textures/screens/madscientisttrademutationcure.png");
	private static final ResourceLocation IMAGE_63 = ResourceLocation.parse("monstrous_world:textures/screens/darkened_iron_ingot.png");
	private static final ResourceLocation IMAGE_64 = ResourceLocation.parse("monstrous_world:textures/screens/tin_ingot.png");
	private static final ResourceLocation IMAGE_65 = ResourceLocation.parse("monstrous_world:textures/screens/syringe_stabilize.png");
	private static final ResourceLocation IMAGE_66 = ResourceLocation.parse("monstrous_world:textures/screens/syringe_cure_serum.png");
	private static final ResourceLocation IMAGE_67 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_swamp_1.png");
	private static final ResourceLocation IMAGE_68 = ResourceLocation.parse("monstrous_world:textures/screens/icon_frogspawn.png");
	private static final ResourceLocation IMAGE_69 = ResourceLocation.parse("monstrous_world:textures/screens/salmon.png");
	private static final ResourceLocation IMAGE_70 = ResourceLocation.parse("monstrous_world:textures/screens/odd_root.png");
	private static final ResourceLocation IMAGE_71 = ResourceLocation.parse("monstrous_world:textures/screens/aquastone.png");
	private static final ResourceLocation IMAGE_72 = ResourceLocation.parse("monstrous_world:textures/screens/aquastone.png");
	private static final ResourceLocation IMAGE_73 = ResourceLocation.parse("monstrous_world:textures/screens/hungry_tree_bark.png");
	private static final ResourceLocation IMAGE_74 = ResourceLocation.parse("monstrous_world:textures/screens/mysterious_seed_item.png");
	private static final ResourceLocation IMAGE_75 = ResourceLocation.parse("monstrous_world:textures/screens/capture_jar_full.png");
	private static final ResourceLocation IMAGE_76 = ResourceLocation.parse("monstrous_world:textures/screens/swamp_essence.png");
	private static final ResourceLocation IMAGE_77 = ResourceLocation.parse("monstrous_world:textures/screens/salmon.png");
	private static final ResourceLocation IMAGE_78 = ResourceLocation.parse("monstrous_world:textures/screens/swamp_essence_dust.png");
	private static final ResourceLocation IMAGE_79 = ResourceLocation.parse("monstrous_world:textures/screens/hungry_tree_bark.png");
	private static final ResourceLocation IMAGE_80 = ResourceLocation.parse("monstrous_world:textures/screens/brand_of_strength.png");
	private static final ResourceLocation IMAGE_81 = ResourceLocation.parse("monstrous_world:textures/screens/nethergem.png");
	private static final ResourceLocation IMAGE_82 = ResourceLocation.parse("monstrous_world:textures/screens/hungry_tree_heart.png");
	private static final ResourceLocation IMAGE_83 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_hungry_tree.png");
	private static final ResourceLocation IMAGE_84 = ResourceLocation.parse("monstrous_world:textures/screens/hungry_tree_heart.png");
	private static final ResourceLocation IMAGE_85 = ResourceLocation.parse("monstrous_world:textures/screens/brand_of_conquest.png");
	private static final ResourceLocation IMAGE_86 = ResourceLocation.parse("monstrous_world:textures/screens/elder_guardian_core.png");
	private static final ResourceLocation IMAGE_87 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_elder.png");
	private static final ResourceLocation IMAGE_88 = ResourceLocation.parse("monstrous_world:textures/screens/trickortreatbag.png");
	private static final ResourceLocation IMAGE_89 = ResourceLocation.parse("monstrous_world:textures/screens/tin_ingot.png");
	private static final ResourceLocation IMAGE_90 = ResourceLocation.parse("monstrous_world:textures/screens/nethergem.png");
	private static final ResourceLocation IMAGE_91 = ResourceLocation.parse("monstrous_world:textures/screens/venom_bottle.png");
	private static final ResourceLocation IMAGE_92 = ResourceLocation.parse("monstrous_world:textures/screens/serpent_scale.png");
	private static final ResourceLocation IMAGE_93 = ResourceLocation.parse("monstrous_world:textures/screens/tradetextgoblintohunter.png");
	private static final ResourceLocation IMAGE_94 = ResourceLocation.parse("monstrous_world:textures/screens/leather.png");
	private static final ResourceLocation IMAGE_95 = ResourceLocation.parse("monstrous_world:textures/screens/standard_hunter_boots.png");
	private static final ResourceLocation IMAGE_96 = ResourceLocation.parse("monstrous_world:textures/screens/malachite_hunter_boots.png");
	private static final ResourceLocation IMAGE_97 = ResourceLocation.parse("monstrous_world:textures/screens/hunter_mission.png");
	private static final ResourceLocation IMAGE_98 = ResourceLocation.parse("monstrous_world:textures/screens/goblintradetext.png");
	private static final ResourceLocation IMAGE_99 = ResourceLocation.parse("monstrous_world:textures/screens/modified_netherite_sword_unknown.png");
	private static final ResourceLocation IMAGE_100 = ResourceLocation.parse("monstrous_world:textures/screens/modified_iron_pickaxe_unknown.png");
	private static final ResourceLocation IMAGE_101 = ResourceLocation.parse("monstrous_world:textures/screens/modified_bronze_axe_unknown.png");
	private static final ResourceLocation IMAGE_102 = ResourceLocation.parse("monstrous_world:textures/screens/diamond_sword.png");
	private static final ResourceLocation IMAGE_103 = ResourceLocation.parse("monstrous_world:textures/screens/netherite_shovel.png");
	private static final ResourceLocation IMAGE_104 = ResourceLocation.parse("monstrous_world:textures/screens/iron_pickaxe.png");
	private static final ResourceLocation IMAGE_105 = ResourceLocation.parse("monstrous_world:textures/screens/red_onyx_gem.png");
	private static final ResourceLocation IMAGE_106 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_hunter_normal.png");
	private static final ResourceLocation IMAGE_107 = ResourceLocation.parse("monstrous_world:textures/screens/leather.png");
	private static final ResourceLocation IMAGE_108 = ResourceLocation.parse("monstrous_world:textures/screens/amulet_of_clear_mind.png");
	private static final ResourceLocation IMAGE_109 = ResourceLocation.parse("monstrous_world:textures/screens/silver_nugget.png");
	private static final ResourceLocation IMAGE_110 = ResourceLocation.parse("monstrous_world:textures/screens/distilled_silver_injection.png");
	private static final ResourceLocation IMAGE_111 = ResourceLocation.parse("monstrous_world:textures/screens/string.png");
	private static final ResourceLocation IMAGE_112 = ResourceLocation.parse("monstrous_world:textures/screens/injection_of_clarity.png");
	private static final ResourceLocation IMAGE_113 = ResourceLocation.parse("monstrous_world:textures/screens/silver_dust.png");
	private static final ResourceLocation IMAGE_114 = ResourceLocation.parse("monstrous_world:textures/screens/amulet_of_strong_will.png");
	private static final ResourceLocation IMAGE_115 = ResourceLocation.parse("monstrous_world:textures/screens/iron_ingot.png");
	private static final ResourceLocation IMAGE_116 = ResourceLocation.parse("monstrous_world:textures/screens/leather.png");
	private static final ResourceLocation IMAGE_117 = ResourceLocation.parse("monstrous_world:textures/screens/amulet_of_strong_will.png");
	private static final ResourceLocation IMAGE_118 = ResourceLocation.parse("monstrous_world:textures/screens/injection_of_clarity.png");
	private static final ResourceLocation IMAGE_119 = ResourceLocation.parse("monstrous_world:textures/screens/malachite_hunter_boots.png");
	private static final ResourceLocation IMAGE_120 = ResourceLocation.parse("monstrous_world:textures/screens/malachite_gem.png");
	private static final ResourceLocation IMAGE_121 = ResourceLocation.parse("monstrous_world:textures/screens/standard_hunter_boots.png");
	private static final ResourceLocation IMAGE_122 = ResourceLocation.parse("monstrous_world:textures/screens/trade_text_boots.png");
	private static final ResourceLocation IMAGE_123 = ResourceLocation.parse("monstrous_world:textures/screens/mutton.png");
	private static final ResourceLocation IMAGE_124 = ResourceLocation.parse("monstrous_world:textures/screens/beef.png");
	private static final ResourceLocation IMAGE_125 = ResourceLocation.parse("monstrous_world:textures/screens/bracelet_of_control.png");
	private static final ResourceLocation IMAGE_126 = ResourceLocation.parse("monstrous_world:textures/screens/moon_clock_0.png");
	private static final ResourceLocation IMAGE_127 = ResourceLocation.parse("monstrous_world:textures/screens/victim_heart.png");
	private static final ResourceLocation IMAGE_128 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_129 = ResourceLocation.parse("monstrous_world:textures/screens/jar_of_eyes.png");
	private static final ResourceLocation IMAGE_130 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_131 = ResourceLocation.parse("monstrous_world:textures/screens/pure_fear.png");
	private static final ResourceLocation IMAGE_132 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");
	private static final ResourceLocation IMAGE_133 = ResourceLocation.parse("monstrous_world:textures/screens/jar_of_eyes.png");
	private static final ResourceLocation IMAGE_134 = ResourceLocation.parse("monstrous_world:textures/screens/infernal_iron_ingot.png");

	public TwoTradesScreen(TwoTradesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 224;
		this.imageHeight = 184;
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
		if (Witch1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_slime_blossom"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_paralysis_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_a_hint_of_insanity"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch1TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_bottle_of_dreadful_tears"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_finger_grass"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_paralysis_powder1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch2TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_charm_of_cleansing"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_lunar_bloom"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_digested_rotten_flesh"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch3TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_vanishing_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_spirit_essence"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_venom_bottle"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_charm_of_possession_immunity"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch4TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_midas_curse_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_venom_bottle1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_pumpkin_essence"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_sinking_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch5TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch6TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 31 && mouseY < topPos + 55) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_bottle_of_dreadful_tears1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch6TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_insanosus"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch6TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_chickenify_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch6TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_charm_of_healing"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch7TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_digested_rotten_flesh1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch7TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_pumpess_flower"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch7TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_frogify_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch7TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag3"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch8TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_reanimation_essence"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch8TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_soulflower"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch8TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag4"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch8TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_explosion_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch9TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_vile_lattice"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch9TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_insanosus1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch9TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag5"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch9TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_obstruction_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch10TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_finger_grass1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch10TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_slime_blossom1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch10TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag6"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Witch10TradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_pumpkin_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_blood_bulb"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_vile_lattice1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_vampire_cure_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag7"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_lunar_bloom1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_werewolf_cure_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_pumpess_flower1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag8"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchZombieCureTradeProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 31 && mouseY < topPos + 55) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_deathcatcher"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchZombieCureTradeProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_finger_grass2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchZombieCureTradeProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_undeath_cure_powder"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WitchZombieCureTradeProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_trick_or_treat_bag9"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireToVampireTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_sardonyx"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireToVampireTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_bottle_of_blood"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireToVampireTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 58 && mouseY < topPos + 82) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_gold_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (VampireToVampireTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_amulet_of_reserve"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_glowstone_dust"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_tin_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_cure_serum"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_cure_serum1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_darkened_iron_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_tin_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_stabilizing_serum"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_cure_serum2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_tadpole_bucket"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_salmon"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_odd_root"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_swamp_crystal"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_swamp_crystal1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hungry_tree_bark"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_mysterious_seed"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_captured_swamp_light"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_swamp_essence"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_salmon1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_swamp_essence_dust"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hungry_tree_bark1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_brand_of_strength"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_nether_gem"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hungry_tree_heart"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hungry_tree_heart1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_brand_of_conquest"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 57 && mouseY < topPos + 81) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_elder_guardian_core"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SerpentMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_nether_gem1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SerpentMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_tin_ingot2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SerpentMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_serpent_scale"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (SerpentMutantTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_venom_bottle2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_leather"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_standard_hunter_boots"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_malachite_hunter_boots"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterToGoblinTradeConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hunter_mission"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeTextProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_any_precious_stone"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeTextProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_weapon_or_tool"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_leather1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_amulet_of_clear_mind"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_silver_nugget"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_distilled_silver_injection"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_string"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_injection_of_clarity"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_silver_dust"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_amulet_of_strong_will"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_iron_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_leather2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_amulet_of_strong_will1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (HunterTrade3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_injection_of_clarity1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeBootsProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_modified_hunter_boots"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeBootsProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_malachite"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GoblinTradeBootsProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_hunter_boots"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 29 && mouseY < topPos + 53) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_raw_mutton"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_raw_beef"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_bracelet_of_beastly_restraint"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_moon_clock"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradePureFearProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_pure_fear"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeVictimHeartProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_victim_heart"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeVictimHeartProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_jar_of_eyes"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeVictimHeartProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 30 && mouseY < topPos + 54) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_infernal_iron_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradeVictimHeartProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_infernal_iron_ingot1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradePureFearProcedure.execute(entity))
			if (mouseX > leftPos + 44 && mouseX < leftPos + 68 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_jar_of_eyes1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (DemonTradePureFearProcedure.execute(entity))
			if (mouseX > leftPos + 152 && mouseX < leftPos + 176 && mouseY > topPos + 56 && mouseY < topPos + 80) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.two_trades.tooltip_infernal_iron_ingot2"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + -11, 0, 0, 224, 101, 224, 101);
		if (Witch1TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch1TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch1TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch2TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch3TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch4TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch5TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch6TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch6TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch6TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch6TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch7TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch7TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch7TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch7TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch8TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch8TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch8TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch8TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch9TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch9TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch9TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch9TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch10TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch10TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (Witch10TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Witch10TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_39, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchVampireCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_40, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchVampireCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_41, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchVampireCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_42, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchVampireCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_43, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_44, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_45, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_46, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_47, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchZombieCureTradeProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_48, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchZombieCureTradeProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_49, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (WitchZombieCureTradeProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_50, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (WitchZombieCureTradeProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_51, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (VampireToVampireTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_52, this.leftPos + 2, this.topPos + 0, 0, 0, 219, 23, 219, 23);
		}
		if (VampireToVampireTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_53, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (VampireToVampireTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_54, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (VampireToVampireTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_55, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (VampireToVampireTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_56, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistNormalTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_57, this.leftPos + 22, this.topPos + 1, 0, 0, 178, 17, 178, 17);
		}
		if (MadScientistNormalTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_58, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistNormalTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_59, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistNormalTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_60, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistNormalTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_61, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistMutantTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_62, this.leftPos + 11, this.topPos + 1, 0, 0, 195, 18, 195, 18);
		}
		if (MadScientistMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_63, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_64, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_65, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (MadScientistMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_66, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_67, this.leftPos + 14, this.topPos + 1, 0, 0, 194, 18, 194, 18);
		}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_68, this.leftPos + 156, this.topPos + 34, 0, 0, 14, 15, 14, 15);
		}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_69, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_70, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_71, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_72, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_73, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_74, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_75, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_76, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_77, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_78, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_79, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_80, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_81, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_82, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterHungryTreeHeartTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_83, this.leftPos + 13, this.topPos + 1, 0, 0, 194, 18, 194, 18);
		}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_84, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_85, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_86, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SwampmonsterElderGuardianTradeHeadingProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_87, this.leftPos + 13, this.topPos + 1, 0, 0, 194, 18, 194, 18);
		}
		if (Witch1TradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_88, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SerpentMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_89, this.leftPos + 48, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (SerpentMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_90, this.leftPos + 48, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SerpentMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_91, this.leftPos + 156, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (SerpentMutantTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_92, this.leftPos + 156, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_93, this.leftPos + 27, this.topPos + 1, 0, 0, 167, 18, 167, 18);
		}
		if (HunterToGoblinTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_94, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_95, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_96, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterToGoblinTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_97, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_98, this.leftPos + 25, this.topPos + 1, 0, 0, 172, 18, 172, 18);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_99, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_100, this.leftPos + 176, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_101, this.leftPos + 195, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_102, this.leftPos + 49, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_103, this.leftPos + 28, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_104, this.leftPos + 9, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeTextProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_105, this.leftPos + 49, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTradeConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_106, this.leftPos + 14, this.topPos + 1, 0, 0, 194, 18, 194, 18);
		}
		if (HunterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_107, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_108, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_109, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_110, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_111, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_112, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_113, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_114, this.leftPos + 155, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_115, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_116, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_117, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (HunterTrade3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_118, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeBootsProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_119, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeBootsProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_120, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeBootsProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_121, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (GoblinTradeBootsProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_122, this.leftPos + 13, this.topPos + 1, 0, 0, 194, 18, 194, 18);
		}
		if (WerewolfToWerewolfConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_123, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (WerewolfToWerewolfConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_124, this.leftPos + 49, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (WerewolfToWerewolfConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_125, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (WerewolfToWerewolfConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_126, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeVictimHeartProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_127, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeVictimHeartProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_128, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeVictimHeartProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_129, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradeVictimHeartProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_130, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradePureFearProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_131, this.leftPos + 48, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradePureFearProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_132, this.leftPos + 156, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradePureFearProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_133, this.leftPos + 48, this.topPos + 62, 0, 0, 16, 16, 16, 16);
		}
		if (DemonTradePureFearProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_134, this.leftPos + 156, this.topPos + 62, 0, 0, 16, 16, 16, 16);
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
		if (Witch1TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_31"), 39, 43, -52, false);
		if (Witch1TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_4"), 39, 70, -52, false);
		if (Witch2TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_32"), 39, 43, -52, false);
		if (Witch2TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_8"), 39, 70, -52, false);
		if (Witch3TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_2"), 39, 43, -52, false);
		if (Witch3TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_33"), 39, 70, -52, false);
		if (Witch4TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_7"), 39, 43, -52, false);
		if (Witch4TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_21"), 39, 70, -52, false);
		if (Witch5TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_34"), 39, 70, -52, false);
		if (Witch6TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_22"), 39, 43, -52, false);
		if (Witch6TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_3"), 39, 70, -52, false);
		if (Witch7TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_23"), 39, 43, -52, false);
		if (Witch7TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_24"), 39, 70, -52, false);
		if (Witch8TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_25"), 39, 43, -52, false);
		if (Witch8TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_26"), 39, 70, -52, false);
		if (Witch9TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_27"), 39, 43, -52, false);
		if (Witch9TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_28"), 39, 70, -52, false);
		if (Witch10TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_29"), 39, 43, -52, false);
		if (Witch10TradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_210"), 39, 70, -52, false);
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_35"), 39, 43, -52, false);
		if (WitchVampireCureTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_211"), 39, 70, -52, false);
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_36"), 39, 43, -52, false);
		if (WitchWerewolfCureTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_212"), 39, 70, -52, false);
		if (WitchZombieCureTradeProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_37"), 39, 43, -52, false);
		if (WitchZombieCureTradeProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_213"), 39, 70, -52, false);
		if (VampireToVampireTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_81"), 39, 70, -52, false);
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_38"), 39, 43, -52, false);
		if (MadScientistNormalTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_41"), 39, 70, -52, false);
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_12"), 39, 43, -52, false);
		if (MadScientistMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_42"), 39, 70, -52, false);
		if (SwampmonsterTrade1ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_6"), 39, 43, -52, false);
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_39"), 39, 70, -52, false);
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_16"), 174, 43, -52, false);
		if (SwampmonsterTrade3ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_310"), 39, 70, -52, false);
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_5"), 39, 70, -52, false);
		if (SwampmonsterHungryTreeHeartTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_51"), 39, 43, -52, false);
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_52"), 39, 43, -52, false);
		if (SwampmonsterElderGuardianTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_311"), 39, 70, -52, false);
		if (SerpentMutantTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_43"), 39, 70, -52, false);
		if (HunterToGoblinTradeConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_122"), 36, 43, -52, false);
		if (GoblinTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_empty"), 29, 70, -52, false);
		if (GoblinTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_161"), 33, 61, -52, false);
		if (HunterTrade1ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_123"), 36, 43, -52, false);
		if (HunterTrade1ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_61"), 39, 70, -52, false);
		if (HunterTrade2ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_82"), 39, 43, -52, false);
		if (HunterTrade2ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_62"), 39, 70, -52, false);
		if (HunterTrade3ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_124"), 36, 43, -52, false);
		if (HunterTrade3ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_63"), 39, 70, -52, false);
		if (GoblinTradeBootsProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_125"), 34, 70, -52, false);
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_126"), 36, 43, -52, false);
		if (WerewolfToWerewolfConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_127"), 34, 70, -52, false);
		if (DemonManiacButtonConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_trade_me_your_ghastly_prizes_a"), 21, 1, -52, false);
		if (DemonManiacButtonConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_you_can_have_these_items"), 41, 11, -52, false);
		if (WerewolfToWerewolfHeadingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_these_artifacts_will_help_you"), 29, 0, -52, false);
		if (WerewolfToWerewolfHeadingProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_manage_your_lycanthropy"), 42, 10, -52, false);
		if (WitchTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_trade_me_for_magical_wares_but"), 36, -1, -52, false);
		if (WitchTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_but_beware"), 77, 11, -52, false);
		if (WitchCureTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_you_look_like_you_need_a_cure"), 31, 0, -52, false);
		if (WitchCureTradeTextProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_for_your_condition"), 56, 11, -52, false);
		if (SwampmonsterTrade2ConditionProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_121"), 36, 43, -52, false);
		if (DemonTradeVictimHeartProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_83"), 174, 43, -52, false);
		if (DemonTradeVictimHeartProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_64"), 174, 70, -52, false);
		if (DemonTradeVictimHeartProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_84"), 39, 43, -52, false);
		if (DemonTradePureFearProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_44"), 39, 43, -52, false);
		if (DemonTradePureFearProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_85"), 174, 43, -52, false);
		if (DemonTradePureFearProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.two_trades.label_65"), 174, 70, -52, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_forward_button = new ImageButton(this.leftPos + 102, this.topPos + 52, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TwoTradesScreen.this.x;
					int y = TwoTradesScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TwoTradesButtonMessage(0, x, y, z));
						TwoTradesButtonMessage.handleButtonAction(entity, 0, x, y, z);
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