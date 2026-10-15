/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.monstrousworld.client.renderer.*;

@EventBusSubscriber(Dist.CLIENT)
public class MonstrousWorldModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get(), VengefulPumpkinRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_TREE_HOSTILE.get(), EvilTreeHostileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_TREE_PASSIVE.get(), EvilTreePassiveRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SAP_BALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_DARKNESS_SPIRIT.get(), EvilDarknessSpiritRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get(), EvilLevitatingSpiritRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.CHANNELER_SPARK.get(), ChannelerSparkRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SPIDER_ROBOT_ACTIVE.get(), SpiderRobotActiveRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get(), MadScientistNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FLY_MUTANT.get(), FlyMutantRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MUTANT_SERPENT.get(), MutantSerpentRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MUTANT_EYE.get(), MutantEyeRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GIANT_FLY.get(), GiantFlyRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DREADFUL_WATCHER.get(), DreadfulWatcherRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GIANT_SNAKE.get(), GiantSnakeRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SOCIETY_GOON.get(), SocietyGoonRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_OBSTRUCTION_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_FROGIFY_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SINKING_POWDER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_SPIRIT_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SPIRITOF_THE_DEPTHS.get(), SpiritofTheDepthsRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_WEREWOLF_CURE_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_EXPLOSION_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_CHICKENIFY_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_VANISHING_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_MIDAS_CURSE_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SPIRITOF_MIDAS.get(), SpiritofMidasRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_BOOKISH_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_PUMPKIN_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_PARALYSIS_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GUARD_ROBOT.get(), GuardRobotRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.INFECTED_GOON.get(), InfectedGoonRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_VAMPIRE_CURE_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.THROWN_UNDEATH_CURE_POWDER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.WITCH_1.get(), Witch1Renderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.CAT_FAMILIAR.get(), CatFamiliarRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.PUMPKIN_BROOM_ENTITY.get(), PumpkinBroomEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GHOSTLY_BROOM_ENTITY.get(), GhostlyBroomEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_BROOM_ENTITY.get(), EvilBroomEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_VAMPIRE.get(), FeralVampireRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.BLOOD_COLLECTOR_ENTITY.get(), BloodCollectorEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.VAMPIRE_NPC.get(), VampireNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SWAMP_LIGHT.get(), SwampLightRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HUNGRY_TREE.get(), HungryTreeRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SWAMPMONSTER_VILLAGER.get(), SwampmonsterVillagerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SWAMPMONSTER_CHIEFTAN.get(), SwampmonsterChieftanRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DEATHBLOOM_ENTITY.get(), DeathbloomEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.INFERNAL_LIGHT.get(), InfernalLightRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_SWAMPMONSTER.get(), FeralSwampmonsterRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.WILL_O_THE_WISP.get(), WillOTheWispRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_GOBLIN.get(), FeralGoblinRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GOBLIN_VILLAGER.get(), GoblinVillagerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HUNTER_NPC.get(), HunterNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SOCIETY_SPAWNER.get(), SocietySpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.CHANGELING.get(), ChangelingRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GOBLIN_FOLLOWER.get(), GoblinFollowerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.IRON_BOLT_PROJECTILE.get(), IronBoltProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_PROJECTILE.get(), SilverBoltProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HUNTER_VILLAGE_MARKER.get(), HunterVillageMarkerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_PARALYSIS_PROJECTILE.get(), SilverBoltParalysisProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_BLINDING_PROJECTILE.get(), SilverBoltBlindingProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_SINKING_PROJECTILE.get(), SilverBoltSinkingProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_VANISHING_PROJECTILE.get(), SilverBoltVanishingProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_WEREWOLF.get(), FeralWerewolfRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FOLLOWER_WEREWOLF.get(), FollowerWerewolfRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.WEREWOLF_TERRITORY_MARKER.get(), WerewolfTerritoryMarkerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DIRE_WEREWOLF.get(), DireWerewolfRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HUMAN_WEREWOLF.get(), HumanWerewolfRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.IRON_THROWING_KNIFE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_THROWING_KNIFE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_MOUNTAIN_TROLL.get(), FeralMountainTrollRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FERAL_MOUNTAIN_TROLL_SPAWNER.get(), FeralMountainTrollSpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ENHANCED_ZOMBIE.get(), EnhancedZombieRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ENHANCED_HUSK.get(), EnhancedHuskRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ENHANCED_DROWNED.get(), EnhancedDrownedRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MYSTERIOUS_CONTAINER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DARK_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.STRONG_DARK_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.LARGE_POSSESSING_ENTITY.get(), LargePossessingEntityRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SERVANT_PUMPKIN.get(), ServantPumpkinRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.PUMPKIN_GOLEM.get(), PumpkinGolemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DARKENED_BLOSSOM.get(), DarkenedBlossomRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SERVANT_SKELETON.get(), ServantSkeletonRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.AGGRESSIVE_GUARD.get(), AggressiveGuardRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.GUARD_SPAWNER.get(), GuardSpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.TROLL_NPC.get(), TrollNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.LEVITATION_CHARGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.FIRE_SPELL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.TELEPORT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SPIRIT_SPELL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HELPER_SPIRIT.get(), HelperSpiritRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SORCERER_NPC.get(), SorcererNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.BLAZING_BARRIER.get(), BlazingBarrierRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.AUTUMN_PLACEHOLDER.get(), AutumnPlaceholderRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ORE_PLACEHOLDER.get(), OrePlaceholderRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MYSTERIOUS_SHADOW.get(), MysteriousShadowRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ENEMY_PLACEHOLDER.get(), EnemyPlaceholderRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.IRON_BOLT_PROJECTILE_DESPAWNING.get(), IronBoltProjectileDespawningRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DARK_MARKET_VENDOR.get(), DarkMarketVendorRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.POPCORN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.ACID_BALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DEADLY_BALLOON.get(), DeadlyBalloonRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_CLOWN_1.get(), EvilClown1Renderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_CLOWN_2.get(), EvilClown2Renderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EVIL_CLOWN_3.get(), EvilClown3Renderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.CLOWN_SPAWNER.get(), ClownSpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DEMON_NPC.get(), DemonNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.DEMON_SPAWNER.get(), DemonSpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MANIAC.get(), ManiacRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MANIAC_SPAWNER.get(), ManiacSpawnerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.CURED_VAMPIRE.get(), CuredVampireRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.RAID.get(), RaidRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.HUNTER_PATROL_NPC.get(), HunterPatrolNPCRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.SILVER_BOLT_NPC_PROJECTILE.get(), SilverBoltNPCProjectileRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MONSTER_VILLAGE_MARKER.get(), MonsterVillageMarkerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.PURE_FEAR_MARKER.get(), PureFearMarkerRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.MURKANUS_WORM.get(), MurkanusWormRenderer::new);
		event.registerEntityRenderer(MonstrousWorldModEntities.EYELET.get(), EyeletRenderer::new);
	}
}