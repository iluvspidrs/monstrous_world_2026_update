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

import net.mcreator.monstrousworld.world.inventory.OpenLoreBinderMenu;
import net.mcreator.monstrousworld.network.OpenLoreBinderButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OpenLoreBinderScreen extends AbstractContainerScreen<OpenLoreBinderMenu> implements MonstrousWorldModScreens.ScreenAccessor {
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
	private Button button_empty10;
	private Button button_empty11;
	private Button button_empty12;
	private Button button_empty13;
	private ImageButton imagebutton_add_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/open_lore_binder.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");

	public OpenLoreBinderScreen(OpenLoreBinderMenu container, Inventory inventory, Component text) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_lore_binder_page_1"), 39, 30, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_this_page_is_for_lore_labeled_mi"), 13, 137, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_intel_in_the_item_tooltip_add_i"), 12, 147, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_by_placing_in_the_slot_and_click"), 11, 158, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_and_a_copy_will_appear_to_the"), 23, 168, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_right_these_copies_can_be_read"), 18, 178, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder.label_by_clicking"), 68, 188, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 265, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(0, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 292, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty1"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(1, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 319, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty2"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(2, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 346, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty3"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(3, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 265, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty4"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(4, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new PlainTextButton(this.leftPos + 292, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty5"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(5, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty5);
		button_empty6 = new PlainTextButton(this.leftPos + 319, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty6"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(6, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty6);
		button_empty7 = new PlainTextButton(this.leftPos + 346, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty7"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(7, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty7);
		button_empty8 = new PlainTextButton(this.leftPos + 265, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty8"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(8, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty8);
		button_empty9 = new PlainTextButton(this.leftPos + 292, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty9"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(9, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty9);
		button_empty10 = new PlainTextButton(this.leftPos + 319, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty10"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(10, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty10);
		button_empty11 = new PlainTextButton(this.leftPos + 346, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty11"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(11, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty11);
		button_empty12 = new PlainTextButton(this.leftPos + 292, this.topPos + 128, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty12"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(12, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty12);
		button_empty13 = new PlainTextButton(this.leftPos + 265, this.topPos + 128, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder.button_empty13"), e -> {
			int x = OpenLoreBinderScreen.this.x;
			int y = OpenLoreBinderScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(13, x, y, z));
				OpenLoreBinderButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty13);
		imagebutton_add_button = new ImageButton(this.leftPos + 202, this.topPos + 93, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
					int x = OpenLoreBinderScreen.this.x;
					int y = OpenLoreBinderScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OpenLoreBinderButtonMessage(14, x, y, z));
						OpenLoreBinderButtonMessage.handleButtonAction(entity, 14, x, y, z);
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