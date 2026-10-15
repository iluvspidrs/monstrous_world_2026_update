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

import net.mcreator.monstrousworld.world.inventory.GoblinWorkstationLevel2Menu;
import net.mcreator.monstrousworld.procedures.PurifiedSilverShowConditionProcedure;
import net.mcreator.monstrousworld.procedures.ElectrumNuggetShowConditionProcedure;
import net.mcreator.monstrousworld.procedures.BooksShowConditionProcedure;
import net.mcreator.monstrousworld.network.GoblinWorkstationLevel2ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GoblinWorkstationLevel2Screen extends AbstractContainerScreen<GoblinWorkstationLevel2Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_add_button;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("monstrous_world:textures/screens/goblin_workstation_level_2.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/goblin_workstation.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/electrum_nugget_transparent.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/purified_silver_transparent.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/book_transparent.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/enchanted_book_transparent.png");

	public GoblinWorkstationLevel2Screen(GoblinWorkstationLevel2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 325;
		this.imageHeight = 137;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 188, this.topPos + 0, 0, 0, 134, 134, 134, 134);
		if (ElectrumNuggetShowConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 272, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		}
		if (PurifiedSilverShowConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 275, this.topPos + 59, 0, 0, 11, 16, 11, 16);
		}
		if (BooksShowConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 222, this.topPos + 60, 0, 0, 16, 16, 16, 16);
		}
		if (BooksShowConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 248, this.topPos + 85, 0, 0, 16, 16, 16, 16);
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
		imagebutton_add_button = new ImageButton(this.leftPos + 246, this.topPos + 117, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/add_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/add_button_hover.png")), e -> {
					int x = GoblinWorkstationLevel2Screen.this.x;
					int y = GoblinWorkstationLevel2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GoblinWorkstationLevel2ButtonMessage(0, x, y, z));
						GoblinWorkstationLevel2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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