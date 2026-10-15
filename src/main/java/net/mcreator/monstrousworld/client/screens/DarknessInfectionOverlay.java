package net.mcreator.monstrousworld.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.procedures.TopRight100DisplayConditionProcedure;
import net.mcreator.monstrousworld.procedures.Corner75DisplayConditionProcedure;
import net.mcreator.monstrousworld.procedures.Corner50DisplayConditionProcedure;
import net.mcreator.monstrousworld.procedures.Corner25DisplayConditionProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class DarknessInfectionOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_left.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_right.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_right.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_left.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_left_25.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_left_50.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_left_75.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_right_25.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_right_50.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_top_right_75.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_left_25.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_left_50.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_left_75.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_right_25.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_right_50.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/darkness_infection_bottom_right_75.png");

	@SubscribeEvent(priority = EventPriority.HIGH)
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
			if (TopRight100DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, 0, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (TopRight100DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w - 256, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (TopRight100DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, w - 256, 0, 0, 0, 256, 256, 256, 256);
			}
			if (TopRight100DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, 0, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner25DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, 0, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner50DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_5, 0, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner75DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_6, 0, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner25DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_7, w - 256, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner50DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_8, w - 256, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner75DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_9, w - 256, 0, 0, 0, 256, 256, 256, 256);
			}
			if (Corner25DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_10, 0, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (Corner50DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_11, 0, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (Corner75DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_12, 0, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (Corner25DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_13, w - 256, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (Corner50DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_14, w - 256, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (Corner75DisplayConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_15, w - 256, h - 256, 0, 0, 256, 256, 256, 256);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}