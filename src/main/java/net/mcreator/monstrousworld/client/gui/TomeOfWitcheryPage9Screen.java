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

import net.mcreator.monstrousworld.world.inventory.TomeOfWitcheryPage9Menu;
import net.mcreator.monstrousworld.network.TomeOfWitcheryPage9ButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TomeOfWitcheryPage9Screen extends AbstractContainerScreen<TomeOfWitcheryPage9Menu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_back_button;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_more_info_invisible;
	private ImageButton imagebutton_more_info_invisible1;
	private ImageButton imagebutton_more_info_invisible2;
	private ImageButton imagebutton_more_info_invisible3;
	private ImageButton imagebutton_more_info_invisible4;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/witcherytextpage9.png");

	public TomeOfWitcheryPage9Screen(TomeOfWitcheryPage9Menu container, Inventory inventory, Component text) {
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
		imagebutton_back_button = new ImageButton(this.leftPos + 0, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(0, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
		imagebutton_forward_button = new ImageButton(this.leftPos + 261, this.topPos + 162, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(1, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_more_info_invisible = new ImageButton(this.leftPos + 61, this.topPos + 21, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(2, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible);
		imagebutton_more_info_invisible1 = new ImageButton(this.leftPos + 61, this.topPos + 94, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(3, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible1);
		imagebutton_more_info_invisible2 = new ImageButton(this.leftPos + 61, this.topPos + 133, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(4, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible2);
		imagebutton_more_info_invisible3 = new ImageButton(this.leftPos + 199, this.topPos + 22, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(5, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible3);
		imagebutton_more_info_invisible4 = new ImageButton(this.leftPos + 200, this.topPos + 64, 16, 16,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/more_info_invisible.png"), ResourceLocation.parse("monstrous_world:textures/screens/more_info_hover.png")), e -> {
					int x = TomeOfWitcheryPage9Screen.this.x;
					int y = TomeOfWitcheryPage9Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new TomeOfWitcheryPage9ButtonMessage(6, x, y, z));
						TomeOfWitcheryPage9ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_more_info_invisible4);
	}
}