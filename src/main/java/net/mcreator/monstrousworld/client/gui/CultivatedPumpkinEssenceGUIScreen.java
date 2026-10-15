package net.mcreator.monstrousworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.monstrousworld.world.inventory.CultivatedPumpkinEssenceGUIMenu;
import net.mcreator.monstrousworld.network.CultivatedPumpkinEssenceGUIButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CultivatedPumpkinEssenceGUIScreen extends AbstractContainerScreen<CultivatedPumpkinEssenceGUIMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_blue_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/recipedisplaycultivatedpumpkinessence.png");

	public CultivatedPumpkinEssenceGUIScreen(CultivatedPumpkinEssenceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 245;
		this.imageHeight = 150;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -4, this.topPos + -1, 0, 0, 257, 150, 257, 150);
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
		imagebutton_blue_back_button = new ImageButton(this.leftPos + -31, this.topPos + -1, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = CultivatedPumpkinEssenceGUIScreen.this.x;
					int y = CultivatedPumpkinEssenceGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CultivatedPumpkinEssenceGUIButtonMessage(0, x, y, z));
						CultivatedPumpkinEssenceGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
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