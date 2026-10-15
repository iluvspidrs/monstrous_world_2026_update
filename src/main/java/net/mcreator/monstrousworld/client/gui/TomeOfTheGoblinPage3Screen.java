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

import net.mcreator.monstrousworld.world.inventory.TomeOfTheGoblinPage3Menu;
import net.mcreator.monstrousworld.network.TomeOfTheGoblinPage3ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TomeOfTheGoblinPage3Screen extends AbstractContainerScreen<TomeOfTheGoblinPage3Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/goblintomepage3.png");

	public TomeOfTheGoblinPage3Screen(TomeOfTheGoblinPage3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 273;
		this.imageHeight = 171;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 1, this.topPos + -9, 0, 0, 278, 178, 278, 178);
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
		button_empty = new PlainTextButton(this.leftPos + 21, this.topPos + 79, 102, 20, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_3.button_empty"), e -> {
			int x = TomeOfTheGoblinPage3Screen.this.x;
			int y = TomeOfTheGoblinPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(0, x, y, z));
				TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 89, this.topPos + 124, 29, 20, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_3.button_empty1"), e -> {
			int x = TomeOfTheGoblinPage3Screen.this.x;
			int y = TomeOfTheGoblinPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(1, x, y, z));
				TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 48, this.topPos + 135, 48, 20, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_3.button_empty2"), e -> {
			int x = TomeOfTheGoblinPage3Screen.this.x;
			int y = TomeOfTheGoblinPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(2, x, y, z));
				TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 166, this.topPos + 33, 55, 20, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_3.button_empty3"), e -> {
			int x = TomeOfTheGoblinPage3Screen.this.x;
			int y = TomeOfTheGoblinPage3Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(3, x, y, z));
				TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		imagebutton_forward_button = new ImageButton(this.leftPos + 262, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TomeOfTheGoblinPage3Screen.this.x;
					int y = TomeOfTheGoblinPage3Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(4, x, y, z));
						TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_back_button = new ImageButton(this.leftPos + 1, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TomeOfTheGoblinPage3Screen.this.x;
					int y = TomeOfTheGoblinPage3Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage3ButtonMessage(5, x, y, z));
						TomeOfTheGoblinPage3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
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