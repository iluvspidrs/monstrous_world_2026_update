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

import net.mcreator.monstrousworld.world.inventory.VampireCurePowderGUIMenu;
import net.mcreator.monstrousworld.network.VampireCurePowderGUIButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class VampireCurePowderGUIScreen extends AbstractContainerScreen<VampireCurePowderGUIMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/vampirecuretext.png");

	public VampireCurePowderGUIScreen(VampireCurePowderGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 247;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -14, this.topPos + -20, 0, 0, 280, 180, 280, 180);
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
		button_empty = new PlainTextButton(this.leftPos + 119, this.topPos + 38, 83, 20, Component.translatable("gui.monstrous_world.vampire_cure_powder_gui.button_empty"), e -> {
			int x = VampireCurePowderGUIScreen.this.x;
			int y = VampireCurePowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VampireCurePowderGUIButtonMessage(0, x, y, z));
				VampireCurePowderGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 103, this.topPos + 60, 52, 20, Component.translatable("gui.monstrous_world.vampire_cure_powder_gui.button_empty1"), e -> {
			int x = VampireCurePowderGUIScreen.this.x;
			int y = VampireCurePowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VampireCurePowderGUIButtonMessage(1, x, y, z));
				VampireCurePowderGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 93, this.topPos + 78, 71, 20, Component.translatable("gui.monstrous_world.vampire_cure_powder_gui.button_empty2"), e -> {
			int x = VampireCurePowderGUIScreen.this.x;
			int y = VampireCurePowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VampireCurePowderGUIButtonMessage(2, x, y, z));
				VampireCurePowderGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 102, this.topPos + 97, 52, 20, Component.translatable("gui.monstrous_world.vampire_cure_powder_gui.button_empty3"), e -> {
			int x = VampireCurePowderGUIScreen.this.x;
			int y = VampireCurePowderGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VampireCurePowderGUIButtonMessage(3, x, y, z));
				VampireCurePowderGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
	}
}