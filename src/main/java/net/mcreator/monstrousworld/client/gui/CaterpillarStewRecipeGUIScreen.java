package net.mcreator.monstrousworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.monstrousworld.world.inventory.CaterpillarStewRecipeGUIMenu;
import net.mcreator.monstrousworld.network.CaterpillarStewRecipeGUIButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CaterpillarStewRecipeGUIScreen extends AbstractContainerScreen<CaterpillarStewRecipeGUIMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/caterpillarstewtext.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/swamp_wort.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/dreadmoth_caterpillar.png");

	public CaterpillarStewRecipeGUIScreen(CaterpillarStewRecipeGUIMenu container, Inventory inventory, Component text) {
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + -6, this.topPos + -11, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 80, this.topPos + 80, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 5, this.topPos + 100, 0, 0, 16, 16, 16, 16);
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
		button_empty = new PlainTextButton(this.leftPos + 170, this.topPos + 57, 36, 20, Component.translatable("gui.monstrous_world.caterpillar_stew_recipe_gui.button_empty"), e -> {
			int x = CaterpillarStewRecipeGUIScreen.this.x;
			int y = CaterpillarStewRecipeGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CaterpillarStewRecipeGUIButtonMessage(0, x, y, z));
				CaterpillarStewRecipeGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 29, this.topPos + 107, 86, 20, Component.translatable("gui.monstrous_world.caterpillar_stew_recipe_gui.button_empty1"), e -> {
			int x = CaterpillarStewRecipeGUIScreen.this.x;
			int y = CaterpillarStewRecipeGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CaterpillarStewRecipeGUIButtonMessage(1, x, y, z));
				CaterpillarStewRecipeGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 144, this.topPos + 107, 89, 20, Component.translatable("gui.monstrous_world.caterpillar_stew_recipe_gui.button_empty2"), e -> {
			int x = CaterpillarStewRecipeGUIScreen.this.x;
			int y = CaterpillarStewRecipeGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CaterpillarStewRecipeGUIButtonMessage(2, x, y, z));
				CaterpillarStewRecipeGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
	}
}