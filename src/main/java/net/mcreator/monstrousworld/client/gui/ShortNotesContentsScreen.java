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

import net.mcreator.monstrousworld.world.inventory.ShortNotesContentsMenu;
import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.network.ShortNotesContentsButtonMessage;
import net.mcreator.monstrousworld.init.MonstrousWorldModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ShortNotesContentsScreen extends AbstractContainerScreen<ShortNotesContentsMenu> implements MonstrousWorldModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_forward_button;
	private ImageButton imagebutton_back_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("monstrous_world:textures/screens/anoteonspiritspage1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("monstrous_world:textures/screens/anoteonspiritspage2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("monstrous_world:textures/screens/societydirectivegui.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("monstrous_world:textures/screens/farmerslogpage1.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("monstrous_world:textures/screens/farmerslogpage2.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("monstrous_world:textures/screens/emailarchivepage1.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("monstrous_world:textures/screens/emailarchivepage2.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("monstrous_world:textures/screens/emailarchivepage3.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("monstrous_world:textures/screens/cureserumpaper1.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("monstrous_world:textures/screens/cureserumpaper2.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("monstrous_world:textures/screens/stabilzingseruminstructions.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("monstrous_world:textures/screens/huntersguildcureserumnote.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("monstrous_world:textures/screens/a_hunters_warning.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("monstrous_world:textures/screens/a_hunters_warning_swamp.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("monstrous_world:textures/screens/a_hunters_warning_vampire.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("monstrous_world:textures/screens/a_hunters_warning_werewolf.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("monstrous_world:textures/screens/recovered_journal_1.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("monstrous_world:textures/screens/recovered_journal_2.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("monstrous_world:textures/screens/recovered_journal_3.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("monstrous_world:textures/screens/note_from_witches.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("monstrous_world:textures/screens/note_from_countess_1.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("monstrous_world:textures/screens/note_from_countess_2.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("monstrous_world:textures/screens/hunterwarningferalmountaintroll.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("monstrous_world:textures/screens/unusualinfectionpage1.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("monstrous_world:textures/screens/unusualinfectionpage2.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("monstrous_world:textures/screens/unusualinfectionpage3.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("monstrous_world:textures/screens/museumlootpage1.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("monstrous_world:textures/screens/museumlootpage2.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("monstrous_world:textures/screens/curatoradams.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("monstrous_world:textures/screens/quotas_text.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("monstrous_world:textures/screens/sacrifice_1_text.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("monstrous_world:textures/screens/sacrifice_2_text.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("monstrous_world:textures/screens/sacrifice_3_text.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("monstrous_world:textures/screens/hunterwarningclowns.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("monstrous_world:textures/screens/museumad.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("monstrous_world:textures/screens/darkmarketad.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("monstrous_world:textures/screens/noteonpiglins.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("monstrous_world:textures/screens/noteonmaniacs.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("monstrous_world:textures/screens/a_warriors_arena.png");
	private static final ResourceLocation IMAGE_39 = ResourceLocation.parse("monstrous_world:textures/screens/the_vile_raiders.png");
	private static final ResourceLocation IMAGE_40 = ResourceLocation.parse("monstrous_world:textures/screens/fresh_cookies_goblin_made_gui.png");
	private static final ResourceLocation IMAGE_41 = ResourceLocation.parse("monstrous_world:textures/screens/trick_or_treat.png");
	private static final ResourceLocation IMAGE_42 = ResourceLocation.parse("monstrous_world:textures/screens/tome_of_light.png");
	private static final ResourceLocation IMAGE_43 = ResourceLocation.parse("monstrous_world:textures/screens/lock_your_door.png");
	private static final ResourceLocation IMAGE_44 = ResourceLocation.parse("monstrous_world:textures/screens/avoid_the_nether.png");

	public ShortNotesContentsScreen(ShortNotesContentsMenu container, Inventory inventory, Component text) {
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
		if (ANoteOnSpiritsPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_0, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (ANoteOnSpiritsPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (SocietyDirectivePageConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (FarmersLogPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (FarmersLogPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (EmailArchivePage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (EmailArchivePage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (EmailArchivePage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (CureSerumNotePage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (CureSerumNotePage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (StabilizingSerumNoteConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersNoteOnCureSerumConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningWispTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningSwampTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningVampireTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningWerewolfTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (ARecoveredJournalPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (ARecoveredJournalPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (ARecoveredJournalPage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (ALetterFromAgathaPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 39, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (LetterFromCountessPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (LetterFromCountessPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningTrollTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (UnusualInfectionPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (UnusualInfectionPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (UnusualInfectionPage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (MysteryContainerPage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (MysteryContainerPage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (MuseumClosedConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (QuotaConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (SacrificePage1ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (SacrificePage2ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (SacrificePage3ConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningCircusTentsConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (MuseumAdConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (DarkMarketAdConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (NoteOnPiglinsConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (NoteOnManiacsConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheWarriorsArenaConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TheVileRaidersConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_39, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (FreshCookiesConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_40, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TrickOrTreatAdConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_41, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (TomeOfLightNoteConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_42, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningManiacsTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_43, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
		}
		if (HuntersWarningDemonTextConditionProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_44, this.leftPos + 30, this.topPos + 26, 0, 0, 280, 180, 280, 180);
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
		imagebutton_forward_button = new ImageButton(this.leftPos + 300, this.topPos + 206, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/forward_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/forward_button_hover.png")), e -> {
					int x = ShortNotesContentsScreen.this.x;
					int y = ShortNotesContentsScreen.this.y;
					if (ShortNotesForwardButtonConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new ShortNotesContentsButtonMessage(0, x, y, z));
						ShortNotesContentsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_forward_button);
		imagebutton_back_button = new ImageButton(this.leftPos + 30, this.topPos + 206, 18, 10,
				new WidgetSprites(ResourceLocation.parse("monstrous_world:textures/screens/back_button.png"), ResourceLocation.parse("monstrous_world:textures/screens/back_button_hover.png")), e -> {
					int x = ShortNotesContentsScreen.this.x;
					int y = ShortNotesContentsScreen.this.y;
					if (ShortNotesBackwardButtonConditionProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new ShortNotesContentsButtonMessage(1, x, y, z));
						ShortNotesContentsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_back_button);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_forward_button.visible = ShortNotesForwardButtonConditionProcedure.execute(entity);
		this.imagebutton_back_button.visible = ShortNotesBackwardButtonConditionProcedure.execute(entity);
	}
}