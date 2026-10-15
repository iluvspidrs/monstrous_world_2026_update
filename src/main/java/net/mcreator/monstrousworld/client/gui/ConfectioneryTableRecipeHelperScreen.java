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

import net.mcreator.monstrousworld.world.inventory.ConfectioneryTableRecipeHelperMenu;
import net.mcreator.monstrousworld.network.ConfectioneryTableRecipeHelperButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ConfectioneryTableRecipeHelperScreen extends AbstractContainerScreen<ConfectioneryTableRecipeHelperMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private ImageButton imagebutton_add_button;
	private ImageButton imagebutton_blue_back_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/confectionery_table_recipe_helper.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");

	public ConfectioneryTableRecipeHelperScreen(ConfectioneryTableRecipeHelperMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
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
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 15, this.topPos + 32, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_1, this.leftPos + 49, this.topPos + 32, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_2, this.leftPos + 85, this.topPos + 32, 0, 0, 22, 22, 22, 22);
		guiGraphics.blit(IMAGE_3, this.leftPos + 139, this.topPos + 32, 0, 0, 22, 22, 22, 22);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.confectionery_table_recipe_helper.label_confectionery_table"), 38, 9, -10092442, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 18, this.topPos + 33, 16, 20, Component.translatable("gui.monstrous_world.confectionery_table_recipe_helper.button_empty"), e -> {
			int x = ConfectioneryTableRecipeHelperScreen.this.x;
			int y = ConfectioneryTableRecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ConfectioneryTableRecipeHelperButtonMessage(0, x, y, z));
				ConfectioneryTableRecipeHelperButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 51, this.topPos + 33, 18, 20, Component.translatable("gui.monstrous_world.confectionery_table_recipe_helper.button_empty1"), e -> {
			int x = ConfectioneryTableRecipeHelperScreen.this.x;
			int y = ConfectioneryTableRecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ConfectioneryTableRecipeHelperButtonMessage(1, x, y, z));
				ConfectioneryTableRecipeHelperButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 87, this.topPos + 33, 18, 20, Component.translatable("gui.monstrous_world.confectionery_table_recipe_helper.button_empty2"), e -> {
			int x = ConfectioneryTableRecipeHelperScreen.this.x;
			int y = ConfectioneryTableRecipeHelperScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ConfectioneryTableRecipeHelperButtonMessage(2, x, y, z));
				ConfectioneryTableRecipeHelperButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		imagebutton_add_button = new ImageButton(this.leftPos + 113, this.topPos + 39, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_add_button);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 79, this.topPos + 62, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = ConfectioneryTableRecipeHelperScreen.this.x;
					int y = ConfectioneryTableRecipeHelperScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ConfectioneryTableRecipeHelperButtonMessage(4, x, y, z));
						ConfectioneryTableRecipeHelperButtonMessage.handleButtonAction(entity, 4, x, y, z);
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