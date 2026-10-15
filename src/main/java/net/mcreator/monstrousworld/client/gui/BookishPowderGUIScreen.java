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

import net.mcreator.monstrousworld.world.inventory.BookishPowderGUIMenu;
import net.mcreator.monstrousworld.network.BookishPowderGUIButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class BookishPowderGUIScreen extends AbstractContainerScreen<BookishPowderGUIMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/bookishpowdertext.png");

	public BookishPowderGUIScreen(BookishPowderGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 258;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -9, this.topPos + -21, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 191, this.topPos + 37, 40, 20, Component.translatable("gui.monstrous_world.bookish_powder_gui.button_empty"), e -> {
			int x = BookishPowderGUIScreen.this.x;
			int y = BookishPowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BookishPowderGUIButtonMessage(0, x, y, z));
				BookishPowderGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 174, this.topPos + 82, 67, 20, Component.translatable("gui.monstrous_world.bookish_powder_gui.button_empty1"), e -> {
			int x = BookishPowderGUIScreen.this.x;
			int y = BookishPowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BookishPowderGUIButtonMessage(1, x, y, z));
				BookishPowderGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 110, this.topPos + 66, 45, 20, Component.translatable("gui.monstrous_world.bookish_powder_gui.button_empty2"), e -> {
			int x = BookishPowderGUIScreen.this.x;
			int y = BookishPowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BookishPowderGUIButtonMessage(2, x, y, z));
				BookishPowderGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 29, this.topPos + 48, 41, 20, Component.translatable("gui.monstrous_world.bookish_powder_gui.button_empty3"), e -> {
			int x = BookishPowderGUIScreen.this.x;
			int y = BookishPowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BookishPowderGUIButtonMessage(3, x, y, z));
				BookishPowderGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
	}
}