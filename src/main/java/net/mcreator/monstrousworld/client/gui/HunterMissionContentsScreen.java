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

import net.mcreator.monstrousworld.world.inventory.HunterMissionContentsMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.HunterMissionContentsButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class HunterMissionContentsScreen extends AbstractContainerScreen<HunterMissionContentsMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_back_button;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalgoblinpage1.png.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalgoblinpage2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalswamppage1.png.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalswamppage2.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionwerewolfpage1.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionwerewolfpage2.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalvampirepage1.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferalvampirepage2.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionmaniacpage1.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionmaniacpage2.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissiondirewerewolfpage1.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissiondirewerewolfpage2.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferaltrollpage1.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionferaltrollpage2.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissiondemonpage1.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissiondemonpage2.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionclownpage1.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/huntermissionclownpage2.png");

	public HunterMissionContentsScreen(HunterMissionContentsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 240;
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
		if (HunterMissionFeralGoblinsPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionFeralGoblinsPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionSwampPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionSwampPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionWerewolfPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionWerewolfPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionFeralVampiresPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionFeralVampiresPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionManiacPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionManiacPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionDireWerewolfPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionDireWerewolfPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionFeralMountainTrollPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionFeralMountainTrollPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionDemonPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionDemonPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionClownsPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (HunterMissionClownsPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + -48, this.topPos + 17, 0, 0, 280, 180, 280, 180);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_back_button = new ImageButton(this.leftPos + 24, this.topPos + 188, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = HunterMissionContentsScreen.this.x;
					int y = HunterMissionContentsScreen.this.y;
					if (MissionBackwardButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new HunterMissionContentsButtonMessage(0, x, y, z));
						HunterMissionContentsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
		imagebutton_forward_button = new ImageButton(this.leftPos + 141, this.topPos + 188, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = HunterMissionContentsScreen.this.x;
					int y = HunterMissionContentsScreen.this.y;
					if (MissionForwardButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new HunterMissionContentsButtonMessage(1, x, y, z));
						HunterMissionContentsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_back_button.visible = MissionBackwardButtonShowConditionProcedure.execute(entity);
		this.imagebutton_forward_button.visible = MissionForwardButtonShowConditionProcedure.execute(entity);
	}
}