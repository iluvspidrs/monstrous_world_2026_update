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

import net.mcreator.monstrousworld.world.inventory.TheArtOfRitualsContentsMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.TheArtOfRitualsContentsButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TheArtOfRitualsContentsScreen extends AbstractContainerScreen<TheArtOfRitualsContentsMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_back_button;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_blue_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/the_art_of_rituals_border.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/guidebookpages.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage1.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage3.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage4.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage5.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage6.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpage7.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfusion1.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfusion2.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/ritualblazing.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/ritualluckyday2.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/ritualmoondust.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/ritualhealing.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/ritualresistance.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/rituallycancure.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/ritualexorcism.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/ritualadvintro.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("monstrous_world:textures/screens/ritualteleport1.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("monstrous_world:textures/screens/ritualteleport2.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("monstrous_world:textures/screens/ritualteleport3.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpageblazingbarrier.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpageautumnmagic.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagetricktreat.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagecorruptedcrystals.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagecorruptedcandles.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagediamondwand.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagemasterwand.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpageeasymining.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpageultimatetome.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagetomelight.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagepuredark1.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagepuredark2.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagepuredark3a.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("monstrous_world:textures/screens/ritualpagedarksummons.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfused1.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfused2.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfused3.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("monstrous_world:textures/screens/ritualinfused4.png");

	public TheArtOfRitualsContentsScreen(TheArtOfRitualsContentsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
		this.imageHeight = 240;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		if (TheArtOfRitualsPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage4ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage5ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage6ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage7ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage8ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage9ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage10ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage11ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage12ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage13ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage14ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage15ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage16ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage17ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage18ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage19ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage20ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage21ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage22ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage23ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage24ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage25ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage26ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage27ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage28ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage29ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage30ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage31ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage32ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage33ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage34ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage35ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage36ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage37ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheArtOfRitualsPage38ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
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
		imagebutton_back_button = new ImageButton(this.leftPos + 39, this.topPos + 197, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TheArtOfRitualsContentsScreen.this.x;
					int y = TheArtOfRitualsContentsScreen.this.y;
					if (TheArtOfRitualsBackwardButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new TheArtOfRitualsContentsButtonMessage(0, x, y, z));
						TheArtOfRitualsContentsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
		imagebutton_forward_button = new ImageButton(this.leftPos + 300, this.topPos + 197, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TheArtOfRitualsContentsScreen.this.x;
					int y = TheArtOfRitualsContentsScreen.this.y;
					if (TheArtOfRitualsForwardButtonShowConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new TheArtOfRitualsContentsButtonMessage(1, x, y, z));
						TheArtOfRitualsContentsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_blue_back_button = new ImageButton(this.leftPos + 39, this.topPos + 26, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/blue_back_button_hover.png")), e -> {
					int x = TheArtOfRitualsContentsScreen.this.x;
					int y = TheArtOfRitualsContentsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TheArtOfRitualsContentsButtonMessage(2, x, y, z));
						TheArtOfRitualsContentsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_blue_back_button);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_back_button.visible = TheArtOfRitualsBackwardButtonShowConditionProcedure.execute(entity);
		this.imagebutton_forward_button.visible = TheArtOfRitualsForwardButtonShowConditionProcedure.execute(entity);
	}
}