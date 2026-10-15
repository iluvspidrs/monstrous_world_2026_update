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

import net.mcreator.monstrousworld.world.inventory.TomeOfTheTrollPage10Menu;
import net.mcreator.monstrousworld.network.TomeOfTheTrollPage10ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TomeOfTheTrollPage10Screen extends AbstractContainerScreen<TomeOfTheTrollPage10Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/troll_border.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/guidebookpages.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_the_troll_10.png");

	public TomeOfTheTrollPage10Screen(TomeOfTheTrollPage10Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 275;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -7, this.topPos + -11, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + -7, this.topPos + -11, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_2, this.leftPos + -7, this.topPos + -11, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 30, this.topPos + 95, 82, 20, Component.translatable("gui.monstrous_world.tome_of_the_troll_page_10.button_empty"), e -> {
			int x = TomeOfTheTrollPage10Screen.this.x;
			int y = TomeOfTheTrollPage10Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheTrollPage10ButtonMessage(0, x, y, z));
				TomeOfTheTrollPage10ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 86, this.topPos + 136, 29, 20, Component.translatable("gui.monstrous_world.tome_of_the_troll_page_10.button_empty1"), e -> {
			int x = TomeOfTheTrollPage10Screen.this.x;
			int y = TomeOfTheTrollPage10Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheTrollPage10ButtonMessage(1, x, y, z));
				TomeOfTheTrollPage10ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 141, this.topPos + -1, 18, 20, Component.translatable("gui.monstrous_world.tome_of_the_troll_page_10.button_empty2"), e -> {
			int x = TomeOfTheTrollPage10Screen.this.x;
			int y = TomeOfTheTrollPage10Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TomeOfTheTrollPage10ButtonMessage(2, x, y, z));
				TomeOfTheTrollPage10ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		imagebutton_back_button = new ImageButton(this.leftPos + -7, this.topPos + 160, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TomeOfTheTrollPage10Screen.this.x;
					int y = TomeOfTheTrollPage10Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheTrollPage10ButtonMessage(3, x, y, z));
						TomeOfTheTrollPage10ButtonMessage.handleButtonAction(entity, 3, x, y, z);
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