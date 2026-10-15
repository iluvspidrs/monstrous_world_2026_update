package net.mcreator.monstrousworld.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.procedures.*;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class WerewolfLevelsOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/wf1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/wf2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/wf3.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/wf4.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/wf5.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/wf6.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/bracelet_of_control.png");

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (WerewolfLevel1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (WerewolfLevel2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (WerewolfLevel3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (WerewolfLevel4ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (WerewolfLevel5ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (WerewolfLevel6ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_5, 6, h - 43, 0, 0, 32, 32, 32, 32);
			}
			if (BraceletControlConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_6, w - 21, h - 19, 0, 0, 16, 16, 16, 16);
			}
			if (WerewolfTerritoryMaxConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_5"), 19, h - 54, -1, false);
			if (TerrMarker1ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_1"), 13, h - 54, -1, false);
			if (TerrMarker2ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_2"), 13, h - 54, -1, false);
			if (TerrMarker3ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_3"), 13, h - 54, -1, false);
			if (TerrMarker4ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_4"), 13, h - 54, -1, false);
			if (TerrMarker5ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_51"), 13, h - 54, -1, false);
			if (TerrMarker0ConditionProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.monstrous_world.werewolf_levels.label_0"), 13, h - 54, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}