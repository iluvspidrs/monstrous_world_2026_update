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
public class BloodBarOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_empty.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_1.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_2.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_3.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_4.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_5.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_6.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_7.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_8.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_9.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_10.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_11.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_12.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_13.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_14.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_15.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_16.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_17.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_18.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_19.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("monstrous_world:textures/screens/blood_bar_full.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("monstrous_world:textures/screens/bloodlevel12.png");

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
			if (BloodBarEmptyConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_0, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar1ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_1, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar2ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_2, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar3ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_3, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar4ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_4, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar5ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_5, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar6ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_6, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar7ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_7, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar8ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_8, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar9ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_9, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar10ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_10, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar11ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_11, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar12ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_12, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar13ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_13, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar14ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_14, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar15ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_15, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar16ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_16, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar17ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_17, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar18ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_18, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBar19ConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_19, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodBarFullConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_20, w / 2 + 107, h - 17, 0, 0, 93, 13, 93, 13);
			}
			if (BloodIconConditionProcedure.execute(entity)) {
				event.getGuiGraphics().blit(IMAGE_21, w / 2 + 98, h - 16, 0, 0, 9, 9, 9, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}