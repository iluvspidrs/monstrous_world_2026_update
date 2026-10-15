package net.mcreator.monstrousworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.monstrousworld.world.inventory.LaptopCreatingRobotsPage1Menu;
import net.mcreator.monstrousworld.network.LaptopCreatingRobotsPage1ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaptopCreatingRobotsPage1Screen extends AbstractContainerScreen<LaptopCreatingRobotsPage1Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private ImageButton imagebutton_blue_back_button;
	private ImageButton imagebutton_forward_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/laptop_creating_robots_page_1.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/laptoptextcreatingrobots.png");

	public LaptopCreatingRobotsPage1Screen(LaptopCreatingRobotsPage1Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 155, this.topPos + 19, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 312, this.topPos + 61, 71, 20, Component.translatable("gui.monstrous_world.laptop_creating_robots_page_1.button_empty"), e -> {
			int x = LaptopCreatingRobotsPage1Screen.this.x;
			int y = LaptopCreatingRobotsPage1Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopCreatingRobotsPage1ButtonMessage(0, x, y, z));
				LaptopCreatingRobotsPage1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 262, this.topPos + 73, 48, 20, Component.translatable("gui.monstrous_world.laptop_creating_robots_page_1.button_empty1"), e -> {
			int x = LaptopCreatingRobotsPage1Screen.this.x;
			int y = LaptopCreatingRobotsPage1Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopCreatingRobotsPage1ButtonMessage(1, x, y, z));
				LaptopCreatingRobotsPage1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 185, this.topPos + 103, 101, 20, Component.translatable("gui.monstrous_world.laptop_creating_robots_page_1.button_empty2"), e -> {
			int x = LaptopCreatingRobotsPage1Screen.this.x;
			int y = LaptopCreatingRobotsPage1Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopCreatingRobotsPage1ButtonMessage(2, x, y, z));
				LaptopCreatingRobotsPage1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 284, this.topPos + 10, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = LaptopCreatingRobotsPage1Screen.this.x;
					int y = LaptopCreatingRobotsPage1Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopCreatingRobotsPage1ButtonMessage(3, x, y, z));
						LaptopCreatingRobotsPage1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_blue_back_button);
		imagebutton_forward_button = new ImageButton(this.leftPos + 389, this.topPos + 172, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = LaptopCreatingRobotsPage1Screen.this.x;
					int y = LaptopCreatingRobotsPage1Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopCreatingRobotsPage1ButtonMessage(4, x, y, z));
						LaptopCreatingRobotsPage1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
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