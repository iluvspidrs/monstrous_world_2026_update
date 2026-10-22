package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.client.model.*;

import java.util.Map;
import java.util.Collections;

@EventBusSubscriber(Dist.CLIENT)
public class MonstrousWorldModHumanoidModels {
	public static PlayerModel WRAPPED_VICTIM_LATE;
	public static PlayerModel PLAYER_FLY_FACE;
	public static PlayerModel FLY_WINGS_ON_GROUND;
	public static PlayerModel FLY_WINGS_OFF_GROUND;
	public static PlayerModel SERPENT_BODY;
	public static PlayerModel BAT_FORM;
	public static PlayerModel PLAYER_SWAMPMONSTER_PARTS;
	public static PlayerModel GOBLIN_EARS;
	public static PlayerModel WEREWOLF_FORM;
	public static PlayerModel WRAPPED_VICTIM_EARLY;
	public static PlayerModel TROLL_FACE;
	public static PlayerModel HUNGER_MODE;
	public static PlayerModel CLOWN_HAIR;
	public static PlayerModel PLAYER_DEMON_ON_GROUND;
	public static PlayerModel PLAYER_DEMON_OFF_GROUND;
	public static PlayerModel PLAYER_BALLOON_FORM;
	public static PlayerModel CLOWN_NOSE;
	public static PlayerModel PLAYER_DARKENED_ARMOR;
	public static PlayerModel PLAYER_DARKENED_CAPE;

	@SubscribeEvent
	public static void initModels(EntityRenderersEvent.AddLayers event) {
		ModelWrappedVictimLate wrapped_victim_late_temp = new ModelWrappedVictimLate(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWrappedVictimLate.LAYER_LOCATION));
		WRAPPED_VICTIM_LATE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelPlayerFlyFace player_fly_face_temp = new ModelPlayerFlyFace(Minecraft.getInstance().getEntityModels().bakeLayer(ModelPlayerFlyFace.LAYER_LOCATION));
		PLAYER_FLY_FACE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_fly_face_temp.Head), Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelPlayerFlyWings fly_wings_on_ground_temp = new ModelPlayerFlyWings(Minecraft.getInstance().getEntityModels().bakeLayer(ModelPlayerFlyWings.LAYER_LOCATION));
		FLY_WINGS_ON_GROUND = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("body", fly_wings_on_ground_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelPlayerFlyWingsOffGround fly_wings_off_ground_temp = new ModelPlayerFlyWingsOffGround(Minecraft.getInstance().getEntityModels().bakeLayer(ModelPlayerFlyWingsOffGround.LAYER_LOCATION));
		FLY_WINGS_OFF_GROUND = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("body", fly_wings_off_ground_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelSerpentBody serpent_body_temp = new ModelSerpentBody(Minecraft.getInstance().getEntityModels().bakeLayer(ModelSerpentBody.LAYER_LOCATION));
		SERPENT_BODY = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", serpent_body_temp.Head), Map.entry("body", serpent_body_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelBatForm bat_form_temp = new ModelBatForm(Minecraft.getInstance().getEntityModels().bakeLayer(ModelBatForm.LAYER_LOCATION));
		BAT_FORM = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelSwampmonsterPlayer player_swampmonster_parts_temp = new ModelSwampmonsterPlayer(Minecraft.getInstance().getEntityModels().bakeLayer(ModelSwampmonsterPlayer.LAYER_LOCATION));
		PLAYER_SWAMPMONSTER_PARTS = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_swampmonster_parts_temp.Head), Map.entry("body", player_swampmonster_parts_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelGoblinEars goblin_ears_temp = new ModelGoblinEars(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGoblinEars.LAYER_LOCATION));
		GOBLIN_EARS = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", goblin_ears_temp.Head), Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelWerewolf werewolf_form_temp = new ModelWerewolf(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWerewolf.LAYER_LOCATION));
		WEREWOLF_FORM = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", werewolf_form_temp.Head), Map.entry("body", werewolf_form_temp.Body), Map.entry("left_arm", werewolf_form_temp.LeftArm),
						Map.entry("right_arm", werewolf_form_temp.RightArm), Map.entry("left_leg", werewolf_form_temp.LeftLeg), Map.entry("right_leg", werewolf_form_temp.RightLeg),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelWrappedVictimEarly wrapped_victim_early_temp = new ModelWrappedVictimEarly(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWrappedVictimEarly.LAYER_LOCATION));
		WRAPPED_VICTIM_EARLY = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelTrollFace troll_face_temp = new ModelTrollFace(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTrollFace.LAYER_LOCATION));
		TROLL_FACE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", troll_face_temp.Head), Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelOvertaken hunger_mode_temp = new ModelOvertaken(Minecraft.getInstance().getEntityModels().bakeLayer(ModelOvertaken.LAYER_LOCATION));
		HUNGER_MODE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelClownHair clown_hair_temp = new ModelClownHair(Minecraft.getInstance().getEntityModels().bakeLayer(ModelClownHair.LAYER_LOCATION));
		CLOWN_HAIR = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", clown_hair_temp.Head), Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelDemonPlayerModel player_demon_on_ground_temp = new ModelDemonPlayerModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDemonPlayerModel.LAYER_LOCATION));
		PLAYER_DEMON_ON_GROUND = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_demon_on_ground_temp.Head), Map.entry("body", player_demon_on_ground_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelOpenWings player_demon_off_ground_temp = new ModelOpenWings(Minecraft.getInstance().getEntityModels().bakeLayer(ModelOpenWings.LAYER_LOCATION));
		PLAYER_DEMON_OFF_GROUND = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_demon_off_ground_temp.Head), Map.entry("body", player_demon_off_ground_temp.Body),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelDeadlyBalloon player_balloon_form_temp = new ModelDeadlyBalloon(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDeadlyBalloon.LAYER_LOCATION));
		PLAYER_BALLOON_FORM = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelClownNose clown_nose_temp = new ModelClownNose(Minecraft.getInstance().getEntityModels().bakeLayer(ModelClownNose.LAYER_LOCATION));
		CLOWN_NOSE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", clown_nose_temp.Head), Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelDarkenedArmorOverlay player_darkened_armor_temp = new ModelDarkenedArmorOverlay(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDarkenedArmorOverlay.LAYER_LOCATION));
		PLAYER_DARKENED_ARMOR = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_darkened_armor_temp.Head), Map.entry("body", player_darkened_armor_temp.Body),
						Map.entry("left_arm", player_darkened_armor_temp.LeftArm), Map.entry("right_arm", player_darkened_armor_temp.RightArm), Map.entry("left_leg", player_darkened_armor_temp.LeftLeg),
						Map.entry("right_leg", player_darkened_armor_temp.RightLeg), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
		ModelDarkenedCape player_darkened_cape_temp = new ModelDarkenedCape(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDarkenedCape.LAYER_LOCATION));
		PLAYER_DARKENED_CAPE = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", player_darkened_cape_temp.Head), Map.entry("body", player_darkened_cape_temp.Body),
						Map.entry("left_arm", player_darkened_cape_temp.LeftArm), Map.entry("right_arm", player_darkened_cape_temp.RightArm), Map.entry("left_leg", player_darkened_cape_temp.LeftLeg),
						Map.entry("right_leg", player_darkened_cape_temp.RightLeg), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
	}
}