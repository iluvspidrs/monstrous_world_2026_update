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

import net.mcreator.monstrousworld.world.inventory.HuntersFieldGuidePage14Menu;
import net.mcreator.monstrousworld.network.HuntersFieldGuidePage14ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class HuntersFieldGuidePage14Screen extends AbstractContainerScreen<HuntersFieldGuidePage14Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/hunterfieldguidepageborder.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/guidebookpages.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/hunterguildfieldguide14.png");

	public HuntersFieldGuidePage14Screen(HuntersFieldGuidePage14Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 260;
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
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 21 && mouseX < leftPos + 45 && mouseY > topPos + 43 && mouseY < topPos + 67) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.hunters_field_guide_page_14.tooltip_obstruction_powder"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 45 && mouseX < leftPos + 68 && mouseY > topPos + 43 && mouseY < topPos + 67) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.hunters_field_guide_page_14.tooltip_sinking_powder"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 68 && mouseX < leftPos + 92 && mouseY > topPos + 43 && mouseY < topPos + 67) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.hunters_field_guide_page_14.tooltip_vanishing_powder"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 43 && mouseY < topPos + 67) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.hunters_field_guide_page_14.tooltip_paralysis_powder"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + -6, this.topPos + -11, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + -6, this.topPos + -11, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_2, this.leftPos + -6, this.topPos + -11, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 153, this.topPos + 43, 33, 20, Component.translatable("gui.monstrous_world.hunters_field_guide_page_14.button_empty"), e -> {
			int x = HuntersFieldGuidePage14Screen.this.x;
			int y = HuntersFieldGuidePage14Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new HuntersFieldGuidePage14ButtonMessage(0, x, y, z));
				HuntersFieldGuidePage14ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		imagebutton_forward_button = new ImageButton(this.leftPos + 255, this.topPos + 160, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = HuntersFieldGuidePage14Screen.this.x;
					int y = HuntersFieldGuidePage14Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new HuntersFieldGuidePage14ButtonMessage(1, x, y, z));
						HuntersFieldGuidePage14ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_back_button = new ImageButton(this.leftPos + -6, this.topPos + 160, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = HuntersFieldGuidePage14Screen.this.x;
					int y = HuntersFieldGuidePage14Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new HuntersFieldGuidePage14ButtonMessage(2, x, y, z));
						HuntersFieldGuidePage14ButtonMessage.handleButtonAction(entity, 2, x, y, z);
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