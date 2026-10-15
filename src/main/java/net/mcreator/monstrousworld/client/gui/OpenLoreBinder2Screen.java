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

import net.mcreator.monstrousworld.world.inventory.OpenLoreBinder2Menu;
import net.mcreator.monstrousworld.network.OpenLoreBinder2ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OpenLoreBinder2Screen extends AbstractContainerScreen<OpenLoreBinder2Menu> implements MonstrousWorldModScreens.ScreenAccessor {
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
	private Button button_empty14;
	private Button button_empty15;
	private Button button_empty16;
	private Button button_empty17;
	private ImageButton imagebutton_add_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/open_lore_binder_2.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/border_slot.png");

	public OpenLoreBinder2Screen(OpenLoreBinder2Menu container, Inventory inventory, Component text) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_2.label_lore_binder_page_2"), 29, 31, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_2.label_this_page_stores_info_and_lore"), 30, 137, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_2.label_related_to_the_art_of_witchery"), 21, 147, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_2.label_including_its_guidebook_recipes"), 19, 157, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.open_lore_binder_2.label_and_info_about_magical_plants"), 24, 167, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 265, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(0, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 292, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty1"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(1, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 265, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty2"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(2, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 283, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty3"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(3, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 301, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty4"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(4, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new PlainTextButton(this.leftPos + 319, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty5"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(5, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty5);
		button_empty6 = new PlainTextButton(this.leftPos + 337, this.topPos + 75, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty6"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(6, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty6);
		button_empty7 = new PlainTextButton(this.leftPos + 265, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty7"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(7, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty7);
		button_empty8 = new PlainTextButton(this.leftPos + 283, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty8"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(8, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty8);
		button_empty9 = new PlainTextButton(this.leftPos + 301, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty9"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(9, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty9);
		button_empty10 = new PlainTextButton(this.leftPos + 319, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty10"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(10, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty10);
		button_empty11 = new PlainTextButton(this.leftPos + 337, this.topPos + 102, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty11"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(11, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty11);
		button_empty12 = new PlainTextButton(this.leftPos + 265, this.topPos + 129, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty12"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(12, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty12);
		button_empty13 = new PlainTextButton(this.leftPos + 283, this.topPos + 129, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty13"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(13, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty13);
		button_empty14 = new PlainTextButton(this.leftPos + 301, this.topPos + 129, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty14"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(14, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty14);
		button_empty15 = new PlainTextButton(this.leftPos + 319, this.topPos + 129, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty15"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(15, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty15);
		button_empty16 = new PlainTextButton(this.leftPos + 337, this.topPos + 129, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty16"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(16, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty16);
		button_empty17 = new PlainTextButton(this.leftPos + 319, this.topPos + 48, 18, 20, Component.translatable("gui.monstrous_world.open_lore_binder_2.button_empty17"), e -> {
			int x = OpenLoreBinder2Screen.this.x;
			int y = OpenLoreBinder2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(17, x, y, z));
				OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty17);
		imagebutton_add_button = new ImageButton(this.leftPos + 202, this.topPos + 93, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
					int x = OpenLoreBinder2Screen.this.x;
					int y = OpenLoreBinder2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OpenLoreBinder2ButtonMessage(18, x, y, z));
						OpenLoreBinder2ButtonMessage.handleButtonAction(entity, 18, x, y, z);
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