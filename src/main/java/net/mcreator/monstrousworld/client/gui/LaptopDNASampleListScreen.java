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

import net.mcreator.monstrousworld.world.inventory.LaptopDNASampleListMenu;
import net.mcreator.monstrousworld.network.LaptopDNASampleListButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaptopDNASampleListScreen extends AbstractContainerScreen<LaptopDNASampleListMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private Button button_empty4;
	private ImageButton imagebutton_blue_back_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/laptop_dna_sample_list.png");

	public LaptopDNASampleListScreen(LaptopDNASampleListMenu container, Inventory inventory, Component text) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.label_fly_dna_sample"), 259, 38, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.label_serpent_dna_sample"), 247, 59, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.label_dreadful_watcher_dna_sample"), 227, 84, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.label_spider_dna_sample"), 251, 110, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.label_illager_dna_sample"), 249, 136, -16750951, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 259, this.topPos + 34, 75, 20, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.button_empty"), e -> {
			int x = LaptopDNASampleListScreen.this.x;
			int y = LaptopDNASampleListScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(0, x, y, z));
				LaptopDNASampleListButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 247, this.topPos + 55, 97, 20, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.button_empty1"), e -> {
			int x = LaptopDNASampleListScreen.this.x;
			int y = LaptopDNASampleListScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(1, x, y, z));
				LaptopDNASampleListButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 227, this.topPos + 79, 146, 20, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.button_empty2"), e -> {
			int x = LaptopDNASampleListScreen.this.x;
			int y = LaptopDNASampleListScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(2, x, y, z));
				LaptopDNASampleListButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 251, this.topPos + 106, 92, 20, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.button_empty3"), e -> {
			int x = LaptopDNASampleListScreen.this.x;
			int y = LaptopDNASampleListScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(3, x, y, z));
				LaptopDNASampleListButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 250, this.topPos + 131, 96, 20, Component.translatable("gui.monstrous_world.laptop_dna_sample_list.button_empty4"), e -> {
			int x = LaptopDNASampleListScreen.this.x;
			int y = LaptopDNASampleListScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(4, x, y, z));
				LaptopDNASampleListButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 284, this.topPos + 10, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = LaptopDNASampleListScreen.this.x;
					int y = LaptopDNASampleListScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LaptopDNASampleListButtonMessage(5, x, y, z));
						LaptopDNASampleListButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_blue_back_button);
	}
}