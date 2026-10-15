package net.mcreator.monstrousworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.monstrousworld.world.inventory.LaptopTOCMenu;
import net.mcreator.monstrousworld.network.LaptopTOCButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaptopTOCScreen extends AbstractContainerScreen<LaptopTOCMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private Button button_empty4;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/laptop_toc.png");

	public LaptopTOCScreen(LaptopTOCMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 420;
		this.imageHeight = 190;
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_toc.label_analyze_a_sample"), 259, 119, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_toc.label_introduction"), 267, 33, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_toc.label_dna_samples_list"), 255, 54, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_toc.label_creating_strange_serum"), 241, 76, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_toc.label_creating_robots"), 260, 98, -16750951, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 255, this.topPos + 50, 86, 20, Component.translatable("gui.monstrous_world.laptop_toc.button_empty"), e -> {
			int x = LaptopTOCScreen.this.x;
			int y = LaptopTOCScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopTOCButtonMessage(0, x, y, z));
				LaptopTOCButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 267, this.topPos + 27, 65, 20, Component.translatable("gui.monstrous_world.laptop_toc.button_empty1"), e -> {
			int x = LaptopTOCScreen.this.x;
			int y = LaptopTOCScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopTOCButtonMessage(1, x, y, z));
				LaptopTOCButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 242, this.topPos + 73, 119, 20, Component.translatable("gui.monstrous_world.laptop_toc.button_empty2"), e -> {
			int x = LaptopTOCScreen.this.x;
			int y = LaptopTOCScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopTOCButtonMessage(2, x, y, z));
				LaptopTOCButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 260, this.topPos + 93, 81, 20, Component.translatable("gui.monstrous_world.laptop_toc.button_empty3"), e -> {
			int x = LaptopTOCScreen.this.x;
			int y = LaptopTOCScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopTOCButtonMessage(3, x, y, z));
				LaptopTOCButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 259, this.topPos + 115, 86, 20, Component.translatable("gui.monstrous_world.laptop_toc.button_empty4"), e -> {
			int x = LaptopTOCScreen.this.x;
			int y = LaptopTOCScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopTOCButtonMessage(4, x, y, z));
				LaptopTOCButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
	}
}