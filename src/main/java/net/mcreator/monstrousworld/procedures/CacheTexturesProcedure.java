package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class CacheTexturesProcedure {
	@SubscribeEvent
	public static void afterModelRegistration(EntityRenderersEvent.AddLayers event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		MonstrousWorldModVariables.PlayerDarkPossessedFace = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerdarkpossessedface.png");
		MonstrousWorldModVariables.PlayerDarkPossessedEyes = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerdarkpossessedeyes.png");
		MonstrousWorldModVariables.PlayerLevPossessedFace = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerlevpossessedface.png");
		MonstrousWorldModVariables.PlayerLevPossessedEyes = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerlevpossessedeyes.png");
		MonstrousWorldModVariables.PlayerFlyOverlayWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerflylayerwide.png");
		MonstrousWorldModVariables.PlayerFlyOverlaySlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerflylayerslim.png");
		MonstrousWorldModVariables.PlayerFlyFace = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerflyface.png");
		MonstrousWorldModVariables.PlayerFlyWings = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerflywings.png");
		MonstrousWorldModVariables.PlayerFlyWingsOffGround = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerflywings.png");
		MonstrousWorldModVariables.PlayerEyeOverlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playereyelayer.png");
		MonstrousWorldModVariables.PlayerSerpentOverlayWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerserpentlayerwide.png");
		MonstrousWorldModVariables.PlayerSerpentOverlaySlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/playerserpentlayerslim.png");
		MonstrousWorldModVariables.PlayerSerpentBody = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/serpentparts.png");
		MonstrousWorldModVariables.SpiderParalysisEyes = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/spider_paralysis_eyes.png");
		MonstrousWorldModVariables.VampireEyesHuman = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/vampire_face_human.png");
		MonstrousWorldModVariables.VampireEyesGoon = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/vampire_face_goon.png");
		MonstrousWorldModVariables.VampireEyesVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/villager_vampire_eyes.png");
		MonstrousWorldModVariables.SnowVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/snow.png");
		MonstrousWorldModVariables.SavannaVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/savanna.png");
		MonstrousWorldModVariables.PlainsVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/plains.png");
		MonstrousWorldModVariables.TaigaVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/taiga.png");
		MonstrousWorldModVariables.SwampVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/swamp.png");
		MonstrousWorldModVariables.DesertVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/desert.png");
		MonstrousWorldModVariables.JungleVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/jungle.png");
		MonstrousWorldModVariables.ShepherdVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/shepherd.png");
		MonstrousWorldModVariables.LibrarianVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/librarian.png");
		MonstrousWorldModVariables.ButcherVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/butcher.png");
		MonstrousWorldModVariables.FletcherVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/fletcher.png");
		MonstrousWorldModVariables.WeaponsmithVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/weaponsmith.png");
		MonstrousWorldModVariables.CartographerVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/cartographer.png");
		MonstrousWorldModVariables.ToolsmithVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/toolsmith.png");
		MonstrousWorldModVariables.ClericVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/cleric.png");
		MonstrousWorldModVariables.LeatherworkerVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/leatherworker.png");
		MonstrousWorldModVariables.FishermanVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/fisherman.png");
		MonstrousWorldModVariables.FarmerVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/farmer.png");
		MonstrousWorldModVariables.ArmorerVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/armorer.png");
		MonstrousWorldModVariables.NitwitVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/nitwit.png");
		MonstrousWorldModVariables.MasonVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/mason.png");
		MonstrousWorldModVariables.StoneLevelVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/stone.png");
		MonstrousWorldModVariables.IronLevelVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/iron.png");
		MonstrousWorldModVariables.GoldLevelVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/gold.png");
		MonstrousWorldModVariables.EmeraldLevelVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/emerald.png");
		MonstrousWorldModVariables.DiamondLevelVillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/diamond.png");
		MonstrousWorldModVariables.VampirePillager = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/pillager_vampire.png");
		MonstrousWorldModVariables.VampireEvoker = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/evoker_vampire.png");
		MonstrousWorldModVariables.VampireVindicator = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/vindicator_vampire.png");
		MonstrousWorldModVariables.VampireWitch = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/witch_vampire.png");
		MonstrousWorldModVariables.VampireIllusioner = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/illusioner_vampire.png");
		MonstrousWorldModVariables.VampireWanderingTrader = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/_vampire.png");
		MonstrousWorldModVariables.VampireRobe = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/vampire_robe.png");
		MonstrousWorldModVariables.BatTexture = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/bat.png");
		MonstrousWorldModVariables.SwampmonsterPlayerSkinSlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_swampmonster_layer_slim.png");
		MonstrousWorldModVariables.SwampmonsterPartsTexture = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/baseskinswampmonster.png");
		MonstrousWorldModVariables.SwampmonsterPlayerSkinWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_swampmonster_layer_wide.png");
		MonstrousWorldModVariables.feral_swampmonster_player_wide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_feral_swampmonster_layer_wide.png");
		MonstrousWorldModVariables.feral_swampmonster_player_slim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_feral_swampmonster_layer_slim.png");
		MonstrousWorldModVariables.player_moss_overlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_moss_overlay.png");
		MonstrousWorldModVariables.GoblinPlayerSkinWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_goblin_layer_wide.png");
		MonstrousWorldModVariables.GoblinPlayerSkinSlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_goblin_layer_slim.png");
		MonstrousWorldModVariables.GoblinEarsPlayer = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/goblin2.png");
		MonstrousWorldModVariables.WerewolfTexture = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/werewolf.png");
		MonstrousWorldModVariables.WrappedVictim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/wrapped.png");
		MonstrousWorldModVariables.PlayerZombieOverlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_zombie_layer_wide.png");
		MonstrousWorldModVariables.PlayerZombieOverlaySlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_zombie_layer_slim.png");
		MonstrousWorldModVariables.UndeadGlowEyes = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/undeadglowgreeneyes.png");
		MonstrousWorldModVariables.PlayerTrollLayerWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_troll_layer_wide.png");
		MonstrousWorldModVariables.PlayerTrollLayerSlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_troll_layer_slim.png");
		MonstrousWorldModVariables.hunger_mode = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/violet_eyes.png");
		MonstrousWorldModVariables.acid_overlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/acid_overlay.png");
		MonstrousWorldModVariables.popcorn_overlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/popcorn_overlay.png");
		MonstrousWorldModVariables.PlayerClownSkin = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_clown_layer.png");
		MonstrousWorldModVariables.PlayerBalloonForm = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/deadlyballoonred.png");
		MonstrousWorldModVariables.PlayerClownHair = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/clown_1.png");
		MonstrousWorldModVariables.PlayerDemonSkinWide = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_demon_layer_wide.png");
		MonstrousWorldModVariables.PlayerDemonSkinSlim = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_demon_layer_slim.png");
		MonstrousWorldModVariables.PlayerDemonParts = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/demonskin.png");
		MonstrousWorldModVariables.DummyBowTexture = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/skeleton_with_bow.png");
		MonstrousWorldModVariables.ClownNoseTexture = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/clown_nose.png");
		MonstrousWorldModVariables.player_dark_armor_overlay = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/darkened_armor.png");
		MonstrousWorldModVariables.player_dark_armor_arm = ResourceLocation.fromNamespaceAndPath("monstrous_world", "textures/entities/player_darkened_armor_arm.png");
	}
}