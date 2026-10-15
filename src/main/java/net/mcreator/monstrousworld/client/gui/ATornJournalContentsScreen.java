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

import net.mcreator.monstrousworld.world.inventory.ATornJournalContentsMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.ATornJournalContentsButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ATornJournalContentsScreen extends AbstractContainerScreen<ATornJournalContentsMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_back_button;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/atornjournalpage1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/atornjournalpage2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/atornjournalpage3.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/atornjournalpage4.png");

	public ATornJournalContentsScreen(ATornJournalContentsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
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
		if (ATornJournalPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 30, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (ATornJournalPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 30, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (ATornJournalPage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 30, this.topPos + 17, 0, 0, 280, 180, 280, 180);
		}
		if (ATornJournalPage4ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 30, this.topPos + 17, 0, 0, 280, 180, 280, 180);
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
		imagebutton_back_button = new ImageButton(this.leftPos + 30, this.topPos + 179, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = ATornJournalContentsScreen.this.x;
					int y = ATornJournalContentsScreen.this.y;
					if (ATornJournalBackwardButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new ATornJournalContentsButtonMessage(0, x, y, z));
						ATornJournalContentsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
		imagebutton_forward_button = new ImageButton(this.leftPos + 291, this.topPos + 179, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = ATornJournalContentsScreen.this.x;
					int y = ATornJournalContentsScreen.this.y;
					if (ATornJournalButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new ATornJournalContentsButtonMessage(1, x, y, z));
						ATornJournalContentsButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
		this.imagebutton_back_button.visible = ATornJournalBackwardButtonShowConditionProcedure.execute(entity);
		this.imagebutton_forward_button.visible = ATornJournalButtonShowConditionProcedure.execute(entity);
	}
}