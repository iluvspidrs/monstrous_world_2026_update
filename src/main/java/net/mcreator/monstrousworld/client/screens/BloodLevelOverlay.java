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

import net.mcreator.monstrousworld.procedures.*;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class BloodLevelOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel3.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel4.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel5.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel6.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel7.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel8.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel9.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel10.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel11.png");

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
		if (Bloodlevel12ConditionProcedure.execute(entity)) {
			if (Bloodlevel1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel4ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel5ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel6ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_5, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel7ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_6, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel8ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_7, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel9ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_8, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel10ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_9, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
			if (Bloodlevel11ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_10, w / 2 + -9, h - 69, 0, 0, 18, 18, 18, 18);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}