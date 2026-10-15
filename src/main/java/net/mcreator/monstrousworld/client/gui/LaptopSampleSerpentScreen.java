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

import net.mcreator.monstrousworld.world.inventory.LaptopSampleSerpentMenu;
import net.mcreator.monstrousworld.network.LaptopSampleSerpentButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaptopSampleSerpentScreen extends AbstractContainerScreen<LaptopSampleSerpentMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private ImageButton imagebutton_blue_back_button;
	private ImageButton imagebutton_add_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/laptop_sample_serpent.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/computerchip.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/laptoptextserpentdna.png");

	public LaptopSampleSerpentScreen(LaptopSampleSerpentMenu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 27, this.topPos + 110, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_1, this.leftPos + 155, this.topPos + 19, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 222, this.topPos + 126, 68, 20, Component.translatable("gui.monstrous_world.laptop_sample_serpent.button_empty"), e -> {
			int x = LaptopSampleSerpentScreen.this.x;
			int y = LaptopSampleSerpentScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopSampleSerpentButtonMessage(0, x, y, z));
				LaptopSampleSerpentButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 305, this.topPos + 37, 72, 20, Component.translatable("gui.monstrous_world.laptop_sample_serpent.button_empty1"), e -> {
			int x = LaptopSampleSerpentScreen.this.x;
			int y = LaptopSampleSerpentScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopSampleSerpentButtonMessage(1, x, y, z));
				LaptopSampleSerpentButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 284, this.topPos + 10, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = LaptopSampleSerpentScreen.this.x;
					int y = LaptopSampleSerpentScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopSampleSerpentButtonMessage(2, x, y, z));
						LaptopSampleSerpentButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_blue_back_button);
		imagebutton_add_button = new ImageButton(this.leftPos + 78, this.topPos + 113, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
					int x = LaptopSampleSerpentScreen.this.x;
					int y = LaptopSampleSerpentScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopSampleSerpentButtonMessage(3, x, y, z));
						LaptopSampleSerpentButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_add_button);
	}
}