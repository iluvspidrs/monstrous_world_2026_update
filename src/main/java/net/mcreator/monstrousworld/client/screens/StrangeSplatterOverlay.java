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

import net.mcreator.monstrousworld.procedures.StrangeSplatterConditionProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class StrangeSplatterOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/serum_splatter_lower_left.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/serum_splatter_lower_right.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/serum_splatter_upper_left.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/serum_splatter_upper_right.png");

	@SubscribeEvent(priority = EventPriority.LOWEST)
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
		if (StrangeSplatterConditionProcedure.execute(entity)) {
			if (StrangeSplatterConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, 0, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (StrangeSplatterConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w - 256, h - 256, 0, 0, 256, 256, 256, 256);
			}
			if (StrangeSplatterConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, 0, 0, 0, 0, 256, 256, 256, 256);
			}
			if (StrangeSplatterConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, w - 256, 0, 0, 0, 256, 256, 256, 256);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}