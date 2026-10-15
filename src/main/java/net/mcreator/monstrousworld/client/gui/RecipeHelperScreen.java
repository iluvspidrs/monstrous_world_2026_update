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

import net.mcreator.monstrousworld.world.inventory.RecipeHelperMenu;
import net.mcreator.monstrousworld.network.RecipeHelperButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RecipeHelperScreen extends AbstractContainerScreen<RecipeHelperMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private Button button_empty4;
	private Button button_empty5;
	private Button button_empty6;
	private Button button_empty7;
	private Button button_empty8;
	private Button button_empty9;
	private ImageButton imagebutton_blue_back_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/recipe_helper.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/add_button.png");

	public RecipeHelperScreen(RecipeHelperMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 181;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 105, this.topPos + 45, 0, 0, 18, 10, 18, 10);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.recipe_helper.label_monstrous_world_recipe"), 26, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 41, this.topPos + 20, 19, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(0, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 61, this.topPos + 20, 16, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty1"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(1, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 60, this.topPos + 20, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty2"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(2, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 79, this.topPos + 20, 16, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty3"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(3, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 42, this.topPos + 40, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty4"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(4, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new PlainTextButton(this.leftPos + 61, this.topPos + 40, 16, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty5"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(5, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty5);
		button_empty6 = new PlainTextButton(this.leftPos + 78, this.topPos + 40, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty6"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(6, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty6);
		button_empty7 = new PlainTextButton(this.leftPos + 42, this.topPos + 59, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty7"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(7, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty7);
		button_empty8 = new PlainTextButton(this.leftPos + 60, this.topPos + 59, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty8"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(8, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty8);
		button_empty9 = new PlainTextButton(this.leftPos + 78, this.topPos + 59, 17, 20, Component.translatable("gui.monstrous_world.recipe_helper.button_empty9"), e -> {
			int x = RecipeHelperScreen.this.x;
			int y = RecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RecipeHelperButtonMessage(9, x, y, z));
				RecipeHelperButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty9);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 13, this.topPos + 45, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = RecipeHelperScreen.this.x;
					int y = RecipeHelperScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new RecipeHelperButtonMessage(10, x, y, z));
						RecipeHelperButtonMessage.handleButtonAction(entity, 10, x, y, z);
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