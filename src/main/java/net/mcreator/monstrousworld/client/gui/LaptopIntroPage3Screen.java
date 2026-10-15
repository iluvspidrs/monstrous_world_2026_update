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

import net.mcreator.monstrousworld.world.inventory.LaptopIntroPage3Menu;
import net.mcreator.monstrousworld.network.LaptopIntroPage3ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaptopIntroPage3Screen extends AbstractContainerScreen<LaptopIntroPage3Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private ImageButton imagebutton_blue_back_button;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/laptop_intro_page_3.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/laptoptextintro3.png");

	public LaptopIntroPage3Screen(LaptopIntroPage3Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 155, this.topPos + 10, 0, 0, 280, 180, 280, 180);
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
		button_empty1 = new PlainTextButton(this.leftPos + 219, this.topPos + 38, 68, 20, Component.translatable("gui.monstrous_world.laptop_intro_page_3.button_empty1"), e -> {
			int x = LaptopIntroPage3Screen.this.x;
			int y = LaptopIntroPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopIntroPage3ButtonMessage(0, x, y, z));
				LaptopIntroPage3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 179, this.topPos + 98, 32, 20, Component.translatable("gui.monstrous_world.laptop_intro_page_3.button_empty2"), e -> {
			int x = LaptopIntroPage3Screen.this.x;
			int y = LaptopIntroPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopIntroPage3ButtonMessage(1, x, y, z));
				LaptopIntroPage3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 251, this.topPos + 97, 104, 20, Component.translatable("gui.monstrous_world.laptop_intro_page_3.button_empty3"), e -> {
			int x = LaptopIntroPage3Screen.this.x;
			int y = LaptopIntroPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopIntroPage3ButtonMessage(2, x, y, z));
				LaptopIntroPage3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 284, this.topPos + 10, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = LaptopIntroPage3Screen.this.x;
					int y = LaptopIntroPage3Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopIntroPage3ButtonMessage(3, x, y, z));
						LaptopIntroPage3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_blue_back_button);
		imagebutton_back_button = new ImageButton(this.leftPos + 182, this.topPos + 172, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = LaptopIntroPage3Screen.this.x;
					int y = LaptopIntroPage3Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopIntroPage3ButtonMessage(4, x, y, z));
						LaptopIntroPage3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
	}
}