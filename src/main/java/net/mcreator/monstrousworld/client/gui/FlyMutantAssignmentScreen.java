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

import net.mcreator.monstrousworld.world.inventory.FlyMutantAssignmentMenu;
import net.mcreator.monstrousworld.network.FlyMutantAssignmentButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class FlyMutantAssignmentScreen extends AbstractContainerScreen<FlyMutantAssignmentMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_forward_button1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/fly_mutant_assignment.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/tradebackground1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/payyourassistanttext.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/rotten_flesh.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/rotten_flesh.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/despawnpowder.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/frogify_image.png");

	public FlyMutantAssignmentScreen(FlyMutantAssignmentMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 225;
		this.imageHeight = 186;
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
		if (mouseX > leftPos + 41 && mouseX < leftPos + 65 && mouseY > topPos + 29 && mouseY < topPos + 53) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.tooltip_rotten_flesh"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 41 && mouseX < leftPos + 65 && mouseY > topPos + 54 && mouseY < topPos + 78) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.tooltip_rotten_flesh1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 30 && mouseY < topPos + 54) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.tooltip_vanishing_powder"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 54 && mouseY < topPos + 78) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.tooltip_frogify_powder"), mouseX, mouseY);
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
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + -12, 0, 0, 224, 101, 224, 101);
		guiGraphics.blit(IMAGE_1, this.leftPos + 29, this.topPos + -3, 0, 0, 167, 17, 167, 17);
		guiGraphics.blit(IMAGE_2, this.leftPos + 45, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 45, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 130, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 130, this.topPos + 61, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.label_31"), 63, 41, -52, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.fly_mutant_assignment.label_32"), 63, 69, -52, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_forward_button = new ImageButton(this.leftPos + 102, this.topPos + 37, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = FlyMutantAssignmentScreen.this.x;
					int y = FlyMutantAssignmentScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FlyMutantAssignmentButtonMessage(0, x, y, z));
						FlyMutantAssignmentButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_forward_button1 = new ImageButton(this.leftPos + 102, this.topPos + 63, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = FlyMutantAssignmentScreen.this.x;
					int y = FlyMutantAssignmentScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FlyMutantAssignmentButtonMessage(1, x, y, z));
						FlyMutantAssignmentButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button1);
	}
}