/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.monstrousworld.client.model.*;

@EventBusSubscriber(Dist.CLIENT)
public class MonstrousWorldModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldemontunic.LAYER_LOCATION, Modeldemontunic::createBodyLayer);
		event.registerLayerDefinition(ModelEvilTreeEntityHostile.LAYER_LOCATION, ModelEvilTreeEntityHostile::createBodyLayer);
		event.registerLayerDefinition(ModelSkinTunic1.LAYER_LOCATION, ModelSkinTunic1::createBodyLayer);
		event.registerLayerDefinition(ModelWrappedVictimEarly.LAYER_LOCATION, ModelWrappedVictimEarly::createBodyLayer);
		event.registerLayerDefinition(ModelCatFamiliar.LAYER_LOCATION, ModelCatFamiliar::createBodyLayer);
		event.registerLayerDefinition(ModelWitcheryBroom2.LAYER_LOCATION, ModelWitcheryBroom2::createBodyLayer);
		event.registerLayerDefinition(ModelPlayerFlyWingsOffGround.LAYER_LOCATION, ModelPlayerFlyWingsOffGround::createBodyLayer);
		event.registerLayerDefinition(ModelNPCGoblin.LAYER_LOCATION, ModelNPCGoblin::createBodyLayer);
		event.registerLayerDefinition(ModelChannelerSpark.LAYER_LOCATION, ModelChannelerSpark::createBodyLayer);
		event.registerLayerDefinition(ModelVampireCloakHood.LAYER_LOCATION, ModelVampireCloakHood::createBodyLayer);
		event.registerLayerDefinition(ModelLabCoat.LAYER_LOCATION, ModelLabCoat::createBodyLayer);
		event.registerLayerDefinition(ModelBunnyMask.LAYER_LOCATION, ModelBunnyMask::createBodyLayer);
		event.registerLayerDefinition(ModelWWRobe.LAYER_LOCATION, ModelWWRobe::createBodyLayer);
		event.registerLayerDefinition(ModelClown_2.LAYER_LOCATION, ModelClown_2::createBodyLayer);
		event.registerLayerDefinition(ModelSwampmonsterHelmet2.LAYER_LOCATION, ModelSwampmonsterHelmet2::createBodyLayer);
		event.registerLayerDefinition(ModelWerewolf.LAYER_LOCATION, ModelWerewolf::createBodyLayer);
		event.registerLayerDefinition(ModelSwampLight.LAYER_LOCATION, ModelSwampLight::createBodyLayer);
		event.registerLayerDefinition(ModelGlowingBlockEntity.LAYER_LOCATION, ModelGlowingBlockEntity::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(ModelNeutralSkeleton.LAYER_LOCATION, ModelNeutralSkeleton::createBodyLayer);
		event.registerLayerDefinition(Modelmutationfour.LAYER_LOCATION, Modelmutationfour::createBodyLayer);
		event.registerLayerDefinition(ModelMurkanusWorm.LAYER_LOCATION, ModelMurkanusWorm::createBodyLayer);
		event.registerLayerDefinition(ModelFeralTroll.LAYER_LOCATION, ModelFeralTroll::createBodyLayer);
		event.registerLayerDefinition(ModelClown1.LAYER_LOCATION, ModelClown1::createBodyLayer);
		event.registerLayerDefinition(ModelNeutralStray.LAYER_LOCATION, ModelNeutralStray::createBodyLayer);
		event.registerLayerDefinition(ModelOvertaken.LAYER_LOCATION, ModelOvertaken::createBodyLayer);
		event.registerLayerDefinition(ModelCorruptedSkeleton2.LAYER_LOCATION, ModelCorruptedSkeleton2::createBodyLayer);
		event.registerLayerDefinition(Modelevilscientist.LAYER_LOCATION, Modelevilscientist::createBodyLayer);
		event.registerLayerDefinition(ModelClownNose.LAYER_LOCATION, ModelClownNose::createBodyLayer);
		event.registerLayerDefinition(Modelaquaticboots.LAYER_LOCATION, Modelaquaticboots::createBodyLayer);
		event.registerLayerDefinition(ModelHungryTree.LAYER_LOCATION, ModelHungryTree::createBodyLayer);
		event.registerLayerDefinition(Modelmutantserpent.LAYER_LOCATION, Modelmutantserpent::createBodyLayer);
		event.registerLayerDefinition(ModelPlayerFlyWingsFlap.LAYER_LOCATION, ModelPlayerFlyWingsFlap::createBodyLayer);
		event.registerLayerDefinition(ModelSwampmonsterVillager.LAYER_LOCATION, ModelSwampmonsterVillager::createBodyLayer);
		event.registerLayerDefinition(ModelSerpentBody.LAYER_LOCATION, ModelSerpentBody::createBodyLayer);
		event.registerLayerDefinition(ModelAlphaWerewolf.LAYER_LOCATION, ModelAlphaWerewolf::createBodyLayer);
		event.registerLayerDefinition(ModelDeathBloom.LAYER_LOCATION, ModelDeathBloom::createBodyLayer);
		event.registerLayerDefinition(Modelaquaticleggings.LAYER_LOCATION, Modelaquaticleggings::createBodyLayer);
		event.registerLayerDefinition(ModelWrappedVictimLate.LAYER_LOCATION, ModelWrappedVictimLate::createBodyLayer);
		event.registerLayerDefinition(Modelcorruptedhelmet.LAYER_LOCATION, Modelcorruptedhelmet::createBodyLayer);
		event.registerLayerDefinition(ModelChieftanHeaddress.LAYER_LOCATION, ModelChieftanHeaddress::createBodyLayer);
		event.registerLayerDefinition(ModelPlaceholderEntity.LAYER_LOCATION, ModelPlaceholderEntity::createBodyLayer);
		event.registerLayerDefinition(Modelaquaticchestplate.LAYER_LOCATION, Modelaquaticchestplate::createBodyLayer);
		event.registerLayerDefinition(ModelHockeyMask.LAYER_LOCATION, ModelHockeyMask::createBodyLayer);
		event.registerLayerDefinition(ModelMSBoots.LAYER_LOCATION, ModelMSBoots::createBodyLayer);
		event.registerLayerDefinition(ModelFlyMutant.LAYER_LOCATION, ModelFlyMutant::createBodyLayer);
		event.registerLayerDefinition(ModelLabGlasses.LAYER_LOCATION, ModelLabGlasses::createBodyLayer);
		event.registerLayerDefinition(ModelTrollNPC.LAYER_LOCATION, ModelTrollNPC::createBodyLayer);
		event.registerLayerDefinition(ModelPlayerFlyWings.LAYER_LOCATION, ModelPlayerFlyWings::createBodyLayer);
		event.registerLayerDefinition(ModelCorruptedEyeChestplate4.LAYER_LOCATION, ModelCorruptedEyeChestplate4::createBodyLayer);
		event.registerLayerDefinition(ModelDreadfulWatcher.LAYER_LOCATION, ModelDreadfulWatcher::createBodyLayer);
		event.registerLayerDefinition(ModelCorruptedEyeLeggings5.LAYER_LOCATION, ModelCorruptedEyeLeggings5::createBodyLayer);
		event.registerLayerDefinition(ModelFaceOnly.LAYER_LOCATION, ModelFaceOnly::createBodyLayer);
		event.registerLayerDefinition(ModelGiantSnake.LAYER_LOCATION, ModelGiantSnake::createBodyLayer);
		event.registerLayerDefinition(ModelHunterBoots.LAYER_LOCATION, ModelHunterBoots::createBodyLayer);
		event.registerLayerDefinition(ModelFullFlyMutation3.LAYER_LOCATION, ModelFullFlyMutation3::createBodyLayer);
		event.registerLayerDefinition(Modeldemonleggings.LAYER_LOCATION, Modeldemonleggings::createBodyLayer);
		event.registerLayerDefinition(ModelNeutralBogged.LAYER_LOCATION, ModelNeutralBogged::createBodyLayer);
		event.registerLayerDefinition(ModelSwampmonsterPlayer.LAYER_LOCATION, ModelSwampmonsterPlayer::createBodyLayer);
		event.registerLayerDefinition(ModelBolt.LAYER_LOCATION, ModelBolt::createBodyLayer);
		event.registerLayerDefinition(ModelHunterCoat.LAYER_LOCATION, ModelHunterCoat::createBodyLayer);
		event.registerLayerDefinition(ModelCorruptedPlant.LAYER_LOCATION, ModelCorruptedPlant::createBodyLayer);
		event.registerLayerDefinition(ModelVengefulPumpkin.LAYER_LOCATION, ModelVengefulPumpkin::createBodyLayer);
		event.registerLayerDefinition(ModelHunterHat.LAYER_LOCATION, ModelHunterHat::createBodyLayer);
		event.registerLayerDefinition(ModelDeadlyBalloon.LAYER_LOCATION, ModelDeadlyBalloon::createBodyLayer);
		event.registerLayerDefinition(ModelRobotSpider.LAYER_LOCATION, ModelRobotSpider::createBodyLayer);
		event.registerLayerDefinition(ModelCorruptedEyeBoots2.LAYER_LOCATION, ModelCorruptedEyeBoots2::createBodyLayer);
		event.registerLayerDefinition(Modelserpentparts.LAYER_LOCATION, Modelserpentparts::createBodyLayer);
		event.registerLayerDefinition(ModelOpenWings.LAYER_LOCATION, ModelOpenWings::createBodyLayer);
		event.registerLayerDefinition(ModelBatForm.LAYER_LOCATION, ModelBatForm::createBodyLayer);
		event.registerLayerDefinition(ModelTroll.LAYER_LOCATION, ModelTroll::createBodyLayer);
		event.registerLayerDefinition(ModelTrollChestplateUpdated.LAYER_LOCATION, ModelTrollChestplateUpdated::createBodyLayer);
		event.registerLayerDefinition(ModelLargePossessingEntity.LAYER_LOCATION, ModelLargePossessingEntity::createBodyLayer);
		event.registerLayerDefinition(ModelHunterLeggings.LAYER_LOCATION, ModelHunterLeggings::createBodyLayer);
		event.registerLayerDefinition(Modelvampire_cloak.LAYER_LOCATION, Modelvampire_cloak::createBodyLayer);
		event.registerLayerDefinition(ModelClownHair.LAYER_LOCATION, ModelClownHair::createBodyLayer);
		event.registerLayerDefinition(ModelTrollHelmetUpdated.LAYER_LOCATION, ModelTrollHelmetUpdated::createBodyLayer);
		event.registerLayerDefinition(ModelTrollFace.LAYER_LOCATION, ModelTrollFace::createBodyLayer);
		event.registerLayerDefinition(ModelEyelet.LAYER_LOCATION, ModelEyelet::createBodyLayer);
		event.registerLayerDefinition(ModelBoltFired.LAYER_LOCATION, ModelBoltFired::createBodyLayer);
		event.registerLayerDefinition(ModelPlayerFlyFace.LAYER_LOCATION, ModelPlayerFlyFace::createBodyLayer);
		event.registerLayerDefinition(ModelSlasherSkullMask.LAYER_LOCATION, ModelSlasherSkullMask::createBodyLayer);
		event.registerLayerDefinition(ModelSkinLeggings1.LAYER_LOCATION, ModelSkinLeggings1::createBodyLayer);
		event.registerLayerDefinition(Modelplayerskinoverlaylarge3.LAYER_LOCATION, Modelplayerskinoverlaylarge3::createBodyLayer);
		event.registerLayerDefinition(ModelSwampmonsterChieftan.LAYER_LOCATION, ModelSwampmonsterChieftan::createBodyLayer);
		event.registerLayerDefinition(ModelDemonPlayerOffGround.LAYER_LOCATION, ModelDemonPlayerOffGround::createBodyLayer);
		event.registerLayerDefinition(ModelDemonPlayerModel.LAYER_LOCATION, ModelDemonPlayerModel::createBodyLayer);
		event.registerLayerDefinition(ModelSorcereryRobe.LAYER_LOCATION, ModelSorcereryRobe::createBodyLayer);
		event.registerLayerDefinition(ModelGoblinEars.LAYER_LOCATION, ModelGoblinEars::createBodyLayer);
		event.registerLayerDefinition(Modeldemon.LAYER_LOCATION, Modeldemon::createBodyLayer);
		event.registerLayerDefinition(ModelRobotGuard.LAYER_LOCATION, ModelRobotGuard::createBodyLayer);
		event.registerLayerDefinition(ModelFighterSpirit.LAYER_LOCATION, ModelFighterSpirit::createBodyLayer);
	}
}