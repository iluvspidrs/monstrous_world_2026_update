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

import net.mcreator.monstrousworld.world.inventory.TrollForgeCopperGUIMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.TrollForgeCopperGUIButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TrollForgeCopperGUIScreen extends AbstractContainerScreen<TrollForgeCopperGUIMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/troll_forge_copper_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/lava_empty.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/blaze_lava_200mb.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/blaze_lava_400mb.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/blaze_lava_600mb.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/blaze_lava_800mb.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/blaze_lava_full.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/lava_full.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/lava_800mb.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/lava_600mb.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/lava_400mb.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/lava_200mb.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");

	public TrollForgeCopperGUIScreen(TrollForgeCopperGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (EmptyFuelConditionProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (BlazeLavaFuelCondition200Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (BlazeLavaFuelCondition400Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (BlazeLavaFuelCondition600Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (BlazeLavaFuelCondition800Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (BlazeLavaFuelConditionFullProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (LavaFuelConditionFullProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (LavaFuelCondition800Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (LavaFuelCondition600Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (LavaFuelCondition400Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		if (LavaFuelCondition200Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 53, this.topPos + 55, 0, 0, 91, 11, 91, 11);
		}
		guiGraphics.blit(IMAGE_11, this.leftPos + 17, this.topPos + 48, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_12, this.leftPos + 35, this.topPos + 16, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_13, this.leftPos + 71, this.topPos + 16, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_14, this.leftPos + 107, this.topPos + 16, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_15, this.leftPos + 143, this.topPos + 16, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_16, this.leftPos + 161, this.topPos + 48, 0, 0, 22, 22, 22, 22);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_forward_button = new ImageButton(this.leftPos + 91, this.topPos + 39, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TrollForgeCopperGUIScreen.this.x;
					int y = TrollForgeCopperGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TrollForgeCopperGUIButtonMessage(0, x, y, z));
						TrollForgeCopperGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
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