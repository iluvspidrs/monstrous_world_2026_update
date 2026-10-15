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

import net.mcreator.monstrousworld.world.inventory.TomeOfWitcheryPage15Menu;
import net.mcreator.monstrousworld.network.TomeOfWitcheryPage15ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TomeOfWitcheryPage15Screen extends AbstractContainerScreen<TomeOfWitcheryPage15Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty8;
	private Button button_empty9;
	private Button button_empty10;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/witcherytextpage15.png");

	public TomeOfWitcheryPage15Screen(TomeOfWitcheryPage15Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 272;
		this.imageHeight = 170;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + -9, 0, 0, 280, 180, 280, 180);
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
		button_empty8 = new PlainTextButton(this.leftPos + 43, this.topPos + 42, 69, 20, Component.translatable("gui.monstrous_world.tome_of_witchery_page_15.button_empty8"), e -> {
			int x = TomeOfWitcheryPage15Screen.this.x;
			int y = TomeOfWitcheryPage15Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfWitcheryPage15ButtonMessage(0, x, y, z));
				TomeOfWitcheryPage15ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty8);
		button_empty9 = new PlainTextButton(this.leftPos + 34, this.topPos + 120, 69, 20, Component.translatable("gui.monstrous_world.tome_of_witchery_page_15.button_empty9"), e -> {
			int x = TomeOfWitcheryPage15Screen.this.x;
			int y = TomeOfWitcheryPage15Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfWitcheryPage15ButtonMessage(1, x, y, z));
				TomeOfWitcheryPage15ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty9);
		button_empty10 = new PlainTextButton(this.leftPos + 174, this.topPos + 31, 50, 20, Component.translatable("gui.monstrous_world.tome_of_witchery_page_15.button_empty10"), e -> {
			int x = TomeOfWitcheryPage15Screen.this.x;
			int y = TomeOfWitcheryPage15Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfWitcheryPage15ButtonMessage(2, x, y, z));
				TomeOfWitcheryPage15ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty10);
		imagebutton_back_button = new ImageButton(this.leftPos + 0, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TomeOfWitcheryPage15Screen.this.x;
					int y = TomeOfWitcheryPage15Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage15ButtonMessage(3, x, y, z));
						TomeOfWitcheryPage15ButtonMessage.handleButtonAction(entity, 3, x, y, z);
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