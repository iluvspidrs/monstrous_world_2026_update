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

import net.mcreator.monstrousworld.procedures.Webbed3ConditionProcedure;
import net.mcreator.monstrousworld.procedures.Webbed2ConditionProcedure;
import net.mcreator.monstrousworld.procedures.Webbed1ConditionProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class WebbedOverlayOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_center_50.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_center.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_center_poison.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_left.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_left_50.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_left_poison.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_right.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_right_50.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_bottom_right_poison.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_left.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_left_50.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_left_poison.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_right.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_right_50.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/webbed_top_right_poison.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
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
			if (Webbed1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, w / 2 + -212, h / 2 + -133, 0, 0, 425, 266, 425, 266);
			}
			if (Webbed2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w / 2 + -212, h / 2 + -133, 0, 0, 425, 266, 425, 266);
			}
			if (Webbed3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, w / 2 + -212, h / 2 + -133, 0, 0, 425, 266, 425, 266);
			}
			if (Webbed2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, 0, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, 0, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_5, 0, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_6, w - 128, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_7, w - 128, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_8, w - 128, h - 128, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_9, 0, 0, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_10, 0, 0, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_11, 0, 0, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_12, w - 128, 0, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_13, w - 128, 0, 0, 0, 128, 128, 128, 128);
			}
			if (Webbed3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_14, w - 128, 0, 0, 0, 128, 128, 128, 128);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}