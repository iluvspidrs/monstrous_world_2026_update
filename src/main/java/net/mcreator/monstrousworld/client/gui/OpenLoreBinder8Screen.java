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

import net.mcreator.monstrousworld.world.inventory.OpenLoreBinder8Menu;
import net.mcreator.monstrousworld.network.OpenLoreBinder8ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OpenLoreBinder8Screen extends AbstractContainerScreen<OpenLoreBinder8Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private ImageButton imagebutton_add_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/open_lore_binder_8.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");

	public OpenLoreBinder8Screen(OpenLoreBinder8Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 387;
		this.imageHeight = 213;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 200, this.topPos + 64, 0, 0, 22, 22, 22, 22);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_8.label_lore_binder_page_8"), 31, 30, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_8.label_this_page_stores_info_related_to"), 17, 137, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_8.label_werewolves_including_its_factio"), 17, 147, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_8.label_guidebook_and_info_about"), 38, 157, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_8.label_infections_resulting_from_bites"), 21, 167, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 347, this.topPos + 49, 16, 20, Component.translatable("gui.monstrous_world.open_lore_binder_8.button_empty"), e -> {
			int x = OpenLoreBinder8Screen.this.x;
			int y = OpenLoreBinder8Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder8ButtonMessage(0, x, y, z));
				OpenLoreBinder8ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 266, this.topPos + 49, 16, 20, Component.translatable("gui.monstrous_world.open_lore_binder_8.button_empty1"), e -> {
			int x = OpenLoreBinder8Screen.this.x;
			int y = OpenLoreBinder8Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder8ButtonMessage(1, x, y, z));
				OpenLoreBinder8ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 292, this.topPos + 48, 17, 20, Component.translatable("gui.monstrous_world.open_lore_binder_8.button_empty2"), e -> {
			int x = OpenLoreBinder8Screen.this.x;
			int y = OpenLoreBinder8Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder8ButtonMessage(2, x, y, z));
				OpenLoreBinder8ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 319, this.topPos + 47, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_8.button_empty3"), e -> {
			int x = OpenLoreBinder8Screen.this.x;
			int y = OpenLoreBinder8Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder8ButtonMessage(3, x, y, z));
				OpenLoreBinder8ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		imagebutton_add_button = new ImageButton(this.leftPos + 202, this.topPos + 93, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
					int x = OpenLoreBinder8Screen.this.x;
					int y = OpenLoreBinder8Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OpenLoreBinder8ButtonMessage(4, x, y, z));
						OpenLoreBinder8ButtonMessage.handleButtonAction(entity, 4, x, y, z);
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