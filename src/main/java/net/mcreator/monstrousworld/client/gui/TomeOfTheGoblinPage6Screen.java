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

import net.mcreator.monstrousworld.world.inventory.TomeOfTheGoblinPage6Menu;
import net.mcreator.monstrousworld.network.TomeOfTheGoblinPage6ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TomeOfTheGoblinPage6Screen extends AbstractContainerScreen<TomeOfTheGoblinPage6Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_more_info_invisible;
	private ImageButton imagebutton_more_info_invisible1;
	private ImageButton imagebutton_more_info_invisible2;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/goblintomepage6.png");

	public TomeOfTheGoblinPage6Screen(TomeOfTheGoblinPage6Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 273;
		this.imageHeight = 171;
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
		if (mouseX > leftPos + 217 && mouseX < leftPos + 241 && mouseY > topPos + 25 && mouseY < topPos + 49) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_6.tooltip_clear_quartz"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 174 && mouseX < leftPos + 198 && mouseY > topPos + 25 && mouseY < topPos + 49) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_6.tooltip_glass"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 174 && mouseX < leftPos + 198 && mouseY > topPos + 68 && mouseY < topPos + 92) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_6.tooltip_spirit_dust"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 216 && mouseX < leftPos + 240 && mouseY > topPos + 67 && mouseY < topPos + 91) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_6.tooltip_darkened_wood_planks"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 1, this.topPos + -9, 0, 0, 278, 178, 278, 178);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.monstrous_world.tome_of_the_goblin_page_6.label_click_on_items_for_info"), 156, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_forward_button = new ImageButton(this.leftPos + 262, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TomeOfTheGoblinPage6Screen.this.x;
					int y = TomeOfTheGoblinPage6Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage6ButtonMessage(0, x, y, z));
						TomeOfTheGoblinPage6ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_more_info_invisible = new ImageButton(this.leftPos + 220, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfTheGoblinPage6Screen.this.x;
					int y = TomeOfTheGoblinPage6Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage6ButtonMessage(1, x, y, z));
						TomeOfTheGoblinPage6ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible);
		imagebutton_more_info_invisible1 = new ImageButton(this.leftPos + 178, this.topPos + 71, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfTheGoblinPage6Screen.this.x;
					int y = TomeOfTheGoblinPage6Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage6ButtonMessage(2, x, y, z));
						TomeOfTheGoblinPage6ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible1);
		imagebutton_more_info_invisible2 = new ImageButton(this.leftPos + 221, this.topPos + 72, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfTheGoblinPage6Screen.this.x;
					int y = TomeOfTheGoblinPage6Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage6ButtonMessage(3, x, y, z));
						TomeOfTheGoblinPage6ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible2);
		imagebutton_back_button = new ImageButton(this.leftPos + 1, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TomeOfTheGoblinPage6Screen.this.x;
					int y = TomeOfTheGoblinPage6Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfTheGoblinPage6ButtonMessage(4, x, y, z));
						TomeOfTheGoblinPage6ButtonMessage.handleButtonAction(entity, 4, x, y, z);
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