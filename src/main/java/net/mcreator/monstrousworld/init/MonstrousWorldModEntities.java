/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public class MonstrousWorldModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MonstrousWorldMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<VengefulPumpkinEntity>> VENGEFUL_PUMPKIN = register("vengeful_pumpkin",
			EntityType.Builder.<VengefulPumpkinEntity>of(VengefulPumpkinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilTreeHostileEntity>> EVIL_TREE_HOSTILE = register("evil_tree_hostile",
			EntityType.Builder.<EvilTreeHostileEntity>of(EvilTreeHostileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilTreePassiveEntity>> EVIL_TREE_PASSIVE = register("evil_tree_passive",
			EntityType.Builder.<EvilTreePassiveEntity>of(EvilTreePassiveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SapBallProjectileEntity>> SAP_BALL_PROJECTILE = register("sap_ball_projectile",
			EntityType.Builder.<SapBallProjectileEntity>of(SapBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilDarknessSpiritEntity>> EVIL_DARKNESS_SPIRIT = register("evil_darkness_spirit",
			EntityType.Builder.<EvilDarknessSpiritEntity>of(EvilDarknessSpiritEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilLevitatingSpiritEntity>> EVIL_LEVITATING_SPIRIT = register("evil_levitating_spirit",
			EntityType.Builder.<EvilLevitatingSpiritEntity>of(EvilLevitatingSpiritEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ChannelerSparkEntity>> CHANNELER_SPARK = register("channeler_spark",
			EntityType.Builder.<ChannelerSparkEntity>of(ChannelerSparkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpiderRobotActiveEntity>> SPIDER_ROBOT_ACTIVE = register("spider_robot_active",
			EntityType.Builder.<SpiderRobotActiveEntity>of(SpiderRobotActiveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<MadScientistNPCEntity>> MAD_SCIENTIST_NPC = register("mad_scientist_npc",
			EntityType.Builder.<MadScientistNPCEntity>of(MadScientistNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlyMutantEntity>> FLY_MUTANT = register("fly_mutant",
			EntityType.Builder.<FlyMutantEntity>of(FlyMutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MutantSerpentEntity>> MUTANT_SERPENT = register("mutant_serpent",
			EntityType.Builder.<MutantSerpentEntity>of(MutantSerpentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MutantEyeEntity>> MUTANT_EYE = register("mutant_eye",
			EntityType.Builder.<MutantEyeEntity>of(MutantEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantFlyEntity>> GIANT_FLY = register("giant_fly",
			EntityType.Builder.<GiantFlyEntity>of(GiantFlyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DreadfulWatcherEntity>> DREADFUL_WATCHER = register("dreadful_watcher",
			EntityType.Builder.<DreadfulWatcherEntity>of(DreadfulWatcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantSnakeEntity>> GIANT_SNAKE = register("giant_snake",
			EntityType.Builder.<GiantSnakeEntity>of(GiantSnakeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<SocietyGoonEntity>> SOCIETY_GOON = register("society_goon",
			EntityType.Builder.<SocietyGoonEntity>of(SocietyGoonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownObstructionPowderEntity>> THROWN_OBSTRUCTION_POWDER = register("thrown_obstruction_powder",
			EntityType.Builder.<ThrownObstructionPowderEntity>of(ThrownObstructionPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownFrogifyPowderEntity>> THROWN_FROGIFY_POWDER = register("thrown_frogify_powder",
			EntityType.Builder.<ThrownFrogifyPowderEntity>of(ThrownFrogifyPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SinkingPowderProjectileEntity>> SINKING_POWDER_PROJECTILE = register("sinking_powder_projectile",
			EntityType.Builder.<SinkingPowderProjectileEntity>of(SinkingPowderProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownSpiritPowderEntity>> THROWN_SPIRIT_POWDER = register("thrown_spirit_powder",
			EntityType.Builder.<ThrownSpiritPowderEntity>of(ThrownSpiritPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpiritofTheDepthsEntity>> SPIRITOF_THE_DEPTHS = register("spiritof_the_depths",
			EntityType.Builder.<SpiritofTheDepthsEntity>of(SpiritofTheDepthsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownWerewolfCurePowderEntity>> THROWN_WEREWOLF_CURE_POWDER = register("thrown_werewolf_cure_powder",
			EntityType.Builder.<ThrownWerewolfCurePowderEntity>of(ThrownWerewolfCurePowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownExplosionPowderEntity>> THROWN_EXPLOSION_POWDER = register("thrown_explosion_powder",
			EntityType.Builder.<ThrownExplosionPowderEntity>of(ThrownExplosionPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownChickenifyPowderEntity>> THROWN_CHICKENIFY_POWDER = register("thrown_chickenify_powder",
			EntityType.Builder.<ThrownChickenifyPowderEntity>of(ThrownChickenifyPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownVanishingPowderEntity>> THROWN_VANISHING_POWDER = register("thrown_vanishing_powder",
			EntityType.Builder.<ThrownVanishingPowderEntity>of(ThrownVanishingPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownMidasCursePowderEntity>> THROWN_MIDAS_CURSE_POWDER = register("thrown_midas_curse_powder",
			EntityType.Builder.<ThrownMidasCursePowderEntity>of(ThrownMidasCursePowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpiritofMidasEntity>> SPIRITOF_MIDAS = register("spiritof_midas",
			EntityType.Builder.<SpiritofMidasEntity>of(SpiritofMidasEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownBookishPowderEntity>> THROWN_BOOKISH_POWDER = register("thrown_bookish_powder",
			EntityType.Builder.<ThrownBookishPowderEntity>of(ThrownBookishPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownPumpkinPowderEntity>> THROWN_PUMPKIN_POWDER = register("thrown_pumpkin_powder",
			EntityType.Builder.<ThrownPumpkinPowderEntity>of(ThrownPumpkinPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownParalysisPowderEntity>> THROWN_PARALYSIS_POWDER = register("thrown_paralysis_powder",
			EntityType.Builder.<ThrownParalysisPowderEntity>of(ThrownParalysisPowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GuardRobotEntity>> GUARD_ROBOT = register("guard_robot",
			EntityType.Builder.<GuardRobotEntity>of(GuardRobotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(1f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<InfectedGoonEntity>> INFECTED_GOON = register("infected_goon",
			EntityType.Builder.<InfectedGoonEntity>of(InfectedGoonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownVampireCurePowderEntity>> THROWN_VAMPIRE_CURE_POWDER = register("thrown_vampire_cure_powder",
			EntityType.Builder.<ThrownVampireCurePowderEntity>of(ThrownVampireCurePowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownUndeathCurePowderEntity>> THROWN_UNDEATH_CURE_POWDER = register("thrown_undeath_cure_powder",
			EntityType.Builder.<ThrownUndeathCurePowderEntity>of(ThrownUndeathCurePowderEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<Witch1Entity>> WITCH_1 = register("witch_1",
			EntityType.Builder.<Witch1Entity>of(Witch1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CatFamiliarEntity>> CAT_FAMILIAR = register("cat_familiar",
			EntityType.Builder.<CatFamiliarEntity>of(CatFamiliarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PumpkinBroomEntityEntity>> PUMPKIN_BROOM_ENTITY = register("pumpkin_broom_entity",
			EntityType.Builder.<PumpkinBroomEntityEntity>of(PumpkinBroomEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostlyBroomEntityEntity>> GHOSTLY_BROOM_ENTITY = register("ghostly_broom_entity",
			EntityType.Builder.<GhostlyBroomEntityEntity>of(GhostlyBroomEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilBroomEntityEntity>> EVIL_BROOM_ENTITY = register("evil_broom_entity",
			EntityType.Builder.<EvilBroomEntityEntity>of(EvilBroomEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralVampireEntity>> FERAL_VAMPIRE = register("feral_vampire",
			EntityType.Builder.<FeralVampireEntity>of(FeralVampireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BloodCollectorEntityEntity>> BLOOD_COLLECTOR_ENTITY = register("blood_collector_entity",
			EntityType.Builder.<BloodCollectorEntityEntity>of(BloodCollectorEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<VampireNPCEntity>> VAMPIRE_NPC = register("vampire_npc",
			EntityType.Builder.<VampireNPCEntity>of(VampireNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwampLightEntity>> SWAMP_LIGHT = register("swamp_light",
			EntityType.Builder.<SwampLightEntity>of(SwampLightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.3f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<HungryTreeEntity>> HUNGRY_TREE = register("hungry_tree",
			EntityType.Builder.<HungryTreeEntity>of(HungryTreeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(3f, 4f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwampmonsterVillagerEntity>> SWAMPMONSTER_VILLAGER = register("swampmonster_villager",
			EntityType.Builder.<SwampmonsterVillagerEntity>of(SwampmonsterVillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwampmonsterChieftanEntity>> SWAMPMONSTER_CHIEFTAN = register("swampmonster_chieftan",
			EntityType.Builder.<SwampmonsterChieftanEntity>of(SwampmonsterChieftanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeathbloomEntityEntity>> DEATHBLOOM_ENTITY = register("deathbloom_entity",
			EntityType.Builder.<DeathbloomEntityEntity>of(DeathbloomEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<InfernalLightEntity>> INFERNAL_LIGHT = register("infernal_light",
			EntityType.Builder.<InfernalLightEntity>of(InfernalLightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.3f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralSwampmonsterEntity>> FERAL_SWAMPMONSTER = register("feral_swampmonster",
			EntityType.Builder.<FeralSwampmonsterEntity>of(FeralSwampmonsterEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<WillOTheWispEntity>> WILL_O_THE_WISP = register("will_o_the_wisp",
			EntityType.Builder.<WillOTheWispEntity>of(WillOTheWispEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.3f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralGoblinEntity>> FERAL_GOBLIN = register("feral_goblin",
			EntityType.Builder.<FeralGoblinEntity>of(FeralGoblinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoblinVillagerEntity>> GOBLIN_VILLAGER = register("goblin_villager",
			EntityType.Builder.<GoblinVillagerEntity>of(GoblinVillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HunterNPCEntity>> HUNTER_NPC = register("hunter_npc",
			EntityType.Builder.<HunterNPCEntity>of(HunterNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SocietySpawnerEntity>> SOCIETY_SPAWNER = register("society_spawner",
			EntityType.Builder.<SocietySpawnerEntity>of(SocietySpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<ChangelingEntity>> CHANGELING = register("changeling",
			EntityType.Builder.<ChangelingEntity>of(ChangelingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoblinFollowerEntity>> GOBLIN_FOLLOWER = register("goblin_follower",
			EntityType.Builder.<GoblinFollowerEntity>of(GoblinFollowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.3f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronBoltProjectileEntity>> IRON_BOLT_PROJECTILE = register("iron_bolt_projectile",
			EntityType.Builder.<IronBoltProjectileEntity>of(IronBoltProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltProjectileEntity>> SILVER_BOLT_PROJECTILE = register("silver_bolt_projectile",
			EntityType.Builder.<SilverBoltProjectileEntity>of(SilverBoltProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HunterVillageMarkerEntity>> HUNTER_VILLAGE_MARKER = register("hunter_village_marker",
			EntityType.Builder.<HunterVillageMarkerEntity>of(HunterVillageMarkerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltParalysisProjectileEntity>> SILVER_BOLT_PARALYSIS_PROJECTILE = register("silver_bolt_paralysis_projectile",
			EntityType.Builder.<SilverBoltParalysisProjectileEntity>of(SilverBoltParalysisProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltBlindingProjectileEntity>> SILVER_BOLT_BLINDING_PROJECTILE = register("silver_bolt_blinding_projectile",
			EntityType.Builder.<SilverBoltBlindingProjectileEntity>of(SilverBoltBlindingProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltSinkingProjectileEntity>> SILVER_BOLT_SINKING_PROJECTILE = register("silver_bolt_sinking_projectile",
			EntityType.Builder.<SilverBoltSinkingProjectileEntity>of(SilverBoltSinkingProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltVanishingProjectileEntity>> SILVER_BOLT_VANISHING_PROJECTILE = register("silver_bolt_vanishing_projectile",
			EntityType.Builder.<SilverBoltVanishingProjectileEntity>of(SilverBoltVanishingProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralWerewolfEntity>> FERAL_WEREWOLF = register("feral_werewolf",
			EntityType.Builder.<FeralWerewolfEntity>of(FeralWerewolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FollowerWerewolfEntity>> FOLLOWER_WEREWOLF = register("follower_werewolf",
			EntityType.Builder.<FollowerWerewolfEntity>of(FollowerWerewolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WerewolfTerritoryMarkerEntity>> WEREWOLF_TERRITORY_MARKER = register("werewolf_territory_marker",
			EntityType.Builder.<WerewolfTerritoryMarkerEntity>of(WerewolfTerritoryMarkerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DireWerewolfEntity>> DIRE_WEREWOLF = register("dire_werewolf",
			EntityType.Builder.<DireWerewolfEntity>of(DireWerewolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HumanWerewolfEntity>> HUMAN_WEREWOLF = register("human_werewolf",
			EntityType.Builder.<HumanWerewolfEntity>of(HumanWerewolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronThrowingKnifeProjectileEntity>> IRON_THROWING_KNIFE_PROJECTILE = register("iron_throwing_knife_projectile",
			EntityType.Builder.<IronThrowingKnifeProjectileEntity>of(IronThrowingKnifeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverThrowingKnifeProjectileEntity>> SILVER_THROWING_KNIFE_PROJECTILE = register("silver_throwing_knife_projectile",
			EntityType.Builder.<SilverThrowingKnifeProjectileEntity>of(SilverThrowingKnifeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralMountainTrollEntity>> FERAL_MOUNTAIN_TROLL = register("feral_mountain_troll",
			EntityType.Builder.<FeralMountainTrollEntity>of(FeralMountainTrollEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<FeralMountainTrollSpawnerEntity>> FERAL_MOUNTAIN_TROLL_SPAWNER = register("feral_mountain_troll_spawner",
			EntityType.Builder.<FeralMountainTrollSpawnerEntity>of(FeralMountainTrollSpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnhancedZombieEntity>> ENHANCED_ZOMBIE = register("enhanced_zombie",
			EntityType.Builder.<EnhancedZombieEntity>of(EnhancedZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnhancedHuskEntity>> ENHANCED_HUSK = register("enhanced_husk",
			EntityType.Builder.<EnhancedHuskEntity>of(EnhancedHuskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnhancedDrownedEntity>> ENHANCED_DROWNED = register("enhanced_drowned",
			EntityType.Builder.<EnhancedDrownedEntity>of(EnhancedDrownedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MysteriousContainerProjectileEntity>> MYSTERIOUS_CONTAINER_PROJECTILE = register("mysterious_container_projectile",
			EntityType.Builder.<MysteriousContainerProjectileEntity>of(MysteriousContainerProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DarkChargeProjectileEntity>> DARK_CHARGE_PROJECTILE = register("dark_charge_projectile",
			EntityType.Builder.<DarkChargeProjectileEntity>of(DarkChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StrongDarkChargeProjectileEntity>> STRONG_DARK_CHARGE_PROJECTILE = register("strong_dark_charge_projectile",
			EntityType.Builder.<StrongDarkChargeProjectileEntity>of(StrongDarkChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LargePossessingEntityEntity>> LARGE_POSSESSING_ENTITY = register("large_possessing_entity",
			EntityType.Builder.<LargePossessingEntityEntity>of(LargePossessingEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<ServantPumpkinEntity>> SERVANT_PUMPKIN = register("servant_pumpkin",
			EntityType.Builder.<ServantPumpkinEntity>of(ServantPumpkinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PumpkinGolemEntity>> PUMPKIN_GOLEM = register("pumpkin_golem",
			EntityType.Builder.<PumpkinGolemEntity>of(PumpkinGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(2.5f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DarkenedBlossomEntity>> DARKENED_BLOSSOM = register("darkened_blossom",
			EntityType.Builder.<DarkenedBlossomEntity>of(DarkenedBlossomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<ServantSkeletonEntity>> SERVANT_SKELETON = register("servant_skeleton",
			EntityType.Builder.<ServantSkeletonEntity>of(ServantSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<AggressiveGuardEntity>> AGGRESSIVE_GUARD = register("aggressive_guard",
			EntityType.Builder.<AggressiveGuardEntity>of(AggressiveGuardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(85).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GuardSpawnerEntity>> GUARD_SPAWNER = register("guard_spawner",
			EntityType.Builder.<GuardSpawnerEntity>of(GuardSpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrollNPCEntity>> TROLL_NPC = register("troll_npc",
			EntityType.Builder.<TrollNPCEntity>of(TrollNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LevitationChargeProjectileEntity>> LEVITATION_CHARGE_PROJECTILE = register("levitation_charge_projectile",
			EntityType.Builder.<LevitationChargeProjectileEntity>of(LevitationChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireSpellProjectileEntity>> FIRE_SPELL_PROJECTILE = register("fire_spell_projectile",
			EntityType.Builder.<FireSpellProjectileEntity>of(FireSpellProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TeleportProjectileEntity>> TELEPORT_PROJECTILE = register("teleport_projectile",
			EntityType.Builder.<TeleportProjectileEntity>of(TeleportProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpiritSpellProjectileEntity>> SPIRIT_SPELL_PROJECTILE = register("spirit_spell_projectile",
			EntityType.Builder.<SpiritSpellProjectileEntity>of(SpiritSpellProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HelperSpiritEntity>> HELPER_SPIRIT = register("helper_spirit",
			EntityType.Builder.<HelperSpiritEntity>of(HelperSpiritEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<SorcererNPCEntity>> SORCERER_NPC = register("sorcerer_npc",
			EntityType.Builder.<SorcererNPCEntity>of(SorcererNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlazingBarrierEntity>> BLAZING_BARRIER = register("blazing_barrier",
			EntityType.Builder.<BlazingBarrierEntity>of(BlazingBarrierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<AutumnPlaceholderEntity>> AUTUMN_PLACEHOLDER = register("autumn_placeholder",
			EntityType.Builder.<AutumnPlaceholderEntity>of(AutumnPlaceholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<OrePlaceholderEntity>> ORE_PLACEHOLDER = register("ore_placeholder",
			EntityType.Builder.<OrePlaceholderEntity>of(OrePlaceholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<MysteriousShadowEntity>> MYSTERIOUS_SHADOW = register("mysterious_shadow",
			EntityType.Builder.<MysteriousShadowEntity>of(MysteriousShadowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyPlaceholderEntity>> ENEMY_PLACEHOLDER = register("enemy_placeholder",
			EntityType.Builder.<EnemyPlaceholderEntity>of(EnemyPlaceholderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronBoltProjectileDespawningEntity>> IRON_BOLT_PROJECTILE_DESPAWNING = register("iron_bolt_projectile_despawning",
			EntityType.Builder.<IronBoltProjectileDespawningEntity>of(IronBoltProjectileDespawningEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DarkMarketVendorEntity>> DARK_MARKET_VENDOR = register("dark_market_vendor",
			EntityType.Builder.<DarkMarketVendorEntity>of(DarkMarketVendorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PopcornProjectileEntity>> POPCORN_PROJECTILE = register("popcorn_projectile",
			EntityType.Builder.<PopcornProjectileEntity>of(PopcornProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AcidBallProjectileEntity>> ACID_BALL_PROJECTILE = register("acid_ball_projectile",
			EntityType.Builder.<AcidBallProjectileEntity>of(AcidBallProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DeadlyBalloonEntity>> DEADLY_BALLOON = register("deadly_balloon",
			EntityType.Builder.<DeadlyBalloonEntity>of(DeadlyBalloonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilClown1Entity>> EVIL_CLOWN_1 = register("evil_clown_1",
			EntityType.Builder.<EvilClown1Entity>of(EvilClown1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilClown2Entity>> EVIL_CLOWN_2 = register("evil_clown_2",
			EntityType.Builder.<EvilClown2Entity>of(EvilClown2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilClown3Entity>> EVIL_CLOWN_3 = register("evil_clown_3",
			EntityType.Builder.<EvilClown3Entity>of(EvilClown3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ClownSpawnerEntity>> CLOWN_SPAWNER = register("clown_spawner",
			EntityType.Builder.<ClownSpawnerEntity>of(ClownSpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DemonNPCEntity>> DEMON_NPC = register("demon_npc",
			EntityType.Builder.<DemonNPCEntity>of(DemonNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<DemonSpawnerEntity>> DEMON_SPAWNER = register("demon_spawner",
			EntityType.Builder.<DemonSpawnerEntity>of(DemonSpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<ManiacEntity>> MANIAC = register("maniac",
			EntityType.Builder.<ManiacEntity>of(ManiacEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(120).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ManiacSpawnerEntity>> MANIAC_SPAWNER = register("maniac_spawner",
			EntityType.Builder.<ManiacSpawnerEntity>of(ManiacSpawnerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<CuredVampireEntity>> CURED_VAMPIRE = register("cured_vampire",
			EntityType.Builder.<CuredVampireEntity>of(CuredVampireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<RaidEntity>> RAID = register("raid",
			EntityType.Builder.<RaidEntity>of(RaidEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<HunterPatrolNPCEntity>> HUNTER_PATROL_NPC = register("hunter_patrol_npc",
			EntityType.Builder.<HunterPatrolNPCEntity>of(HunterPatrolNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SilverBoltNPCProjectileEntity>> SILVER_BOLT_NPC_PROJECTILE = register("silver_bolt_npc_projectile",
			EntityType.Builder.<SilverBoltNPCProjectileEntity>of(SilverBoltNPCProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MonsterVillageMarkerEntity>> MONSTER_VILLAGE_MARKER = register("monster_village_marker",
			EntityType.Builder.<MonsterVillageMarkerEntity>of(MonsterVillageMarkerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PureFearMarkerEntity>> PURE_FEAR_MARKER = register("pure_fear_marker",
			EntityType.Builder.<PureFearMarkerEntity>of(PureFearMarkerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<MurkanusWormEntity>> MURKANUS_WORM = register("murkanus_worm",
			EntityType.Builder.<MurkanusWormEntity>of(MurkanusWormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.2f, 0.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<EyeletEntity>> EYELET = register("eyelet",
			EntityType.Builder.<EyeletEntity>of(EyeletEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		VengefulPumpkinEntity.init(event);
		EvilTreeHostileEntity.init(event);
		EvilTreePassiveEntity.init(event);
		EvilDarknessSpiritEntity.init(event);
		EvilLevitatingSpiritEntity.init(event);
		ChannelerSparkEntity.init(event);
		SpiderRobotActiveEntity.init(event);
		MadScientistNPCEntity.init(event);
		FlyMutantEntity.init(event);
		MutantSerpentEntity.init(event);
		MutantEyeEntity.init(event);
		GiantFlyEntity.init(event);
		DreadfulWatcherEntity.init(event);
		GiantSnakeEntity.init(event);
		SocietyGoonEntity.init(event);
		SpiritofTheDepthsEntity.init(event);
		SpiritofMidasEntity.init(event);
		GuardRobotEntity.init(event);
		InfectedGoonEntity.init(event);
		Witch1Entity.init(event);
		CatFamiliarEntity.init(event);
		PumpkinBroomEntityEntity.init(event);
		GhostlyBroomEntityEntity.init(event);
		EvilBroomEntityEntity.init(event);
		FeralVampireEntity.init(event);
		BloodCollectorEntityEntity.init(event);
		VampireNPCEntity.init(event);
		SwampLightEntity.init(event);
		HungryTreeEntity.init(event);
		SwampmonsterVillagerEntity.init(event);
		SwampmonsterChieftanEntity.init(event);
		DeathbloomEntityEntity.init(event);
		InfernalLightEntity.init(event);
		FeralSwampmonsterEntity.init(event);
		WillOTheWispEntity.init(event);
		FeralGoblinEntity.init(event);
		GoblinVillagerEntity.init(event);
		HunterNPCEntity.init(event);
		SocietySpawnerEntity.init(event);
		ChangelingEntity.init(event);
		GoblinFollowerEntity.init(event);
		HunterVillageMarkerEntity.init(event);
		FeralWerewolfEntity.init(event);
		FollowerWerewolfEntity.init(event);
		WerewolfTerritoryMarkerEntity.init(event);
		DireWerewolfEntity.init(event);
		HumanWerewolfEntity.init(event);
		FeralMountainTrollEntity.init(event);
		FeralMountainTrollSpawnerEntity.init(event);
		EnhancedZombieEntity.init(event);
		EnhancedHuskEntity.init(event);
		EnhancedDrownedEntity.init(event);
		LargePossessingEntityEntity.init(event);
		ServantPumpkinEntity.init(event);
		PumpkinGolemEntity.init(event);
		DarkenedBlossomEntity.init(event);
		ServantSkeletonEntity.init(event);
		AggressiveGuardEntity.init(event);
		GuardSpawnerEntity.init(event);
		TrollNPCEntity.init(event);
		HelperSpiritEntity.init(event);
		SorcererNPCEntity.init(event);
		BlazingBarrierEntity.init(event);
		AutumnPlaceholderEntity.init(event);
		OrePlaceholderEntity.init(event);
		MysteriousShadowEntity.init(event);
		EnemyPlaceholderEntity.init(event);
		DarkMarketVendorEntity.init(event);
		DeadlyBalloonEntity.init(event);
		EvilClown1Entity.init(event);
		EvilClown2Entity.init(event);
		EvilClown3Entity.init(event);
		ClownSpawnerEntity.init(event);
		DemonNPCEntity.init(event);
		DemonSpawnerEntity.init(event);
		ManiacEntity.init(event);
		ManiacSpawnerEntity.init(event);
		CuredVampireEntity.init(event);
		RaidEntity.init(event);
		HunterPatrolNPCEntity.init(event);
		MonsterVillageMarkerEntity.init(event);
		PureFearMarkerEntity.init(event);
		MurkanusWormEntity.init(event);
		EyeletEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(VENGEFUL_PUMPKIN.get(), VengefulPumpkinEntity.createAttributes().build());
		event.put(EVIL_TREE_HOSTILE.get(), EvilTreeHostileEntity.createAttributes().build());
		event.put(EVIL_TREE_PASSIVE.get(), EvilTreePassiveEntity.createAttributes().build());
		event.put(EVIL_DARKNESS_SPIRIT.get(), EvilDarknessSpiritEntity.createAttributes().build());
		event.put(EVIL_LEVITATING_SPIRIT.get(), EvilLevitatingSpiritEntity.createAttributes().build());
		event.put(CHANNELER_SPARK.get(), ChannelerSparkEntity.createAttributes().build());
		event.put(SPIDER_ROBOT_ACTIVE.get(), SpiderRobotActiveEntity.createAttributes().build());
		event.put(MAD_SCIENTIST_NPC.get(), MadScientistNPCEntity.createAttributes().build());
		event.put(FLY_MUTANT.get(), FlyMutantEntity.createAttributes().build());
		event.put(MUTANT_SERPENT.get(), MutantSerpentEntity.createAttributes().build());
		event.put(MUTANT_EYE.get(), MutantEyeEntity.createAttributes().build());
		event.put(GIANT_FLY.get(), GiantFlyEntity.createAttributes().build());
		event.put(DREADFUL_WATCHER.get(), DreadfulWatcherEntity.createAttributes().build());
		event.put(GIANT_SNAKE.get(), GiantSnakeEntity.createAttributes().build());
		event.put(SOCIETY_GOON.get(), SocietyGoonEntity.createAttributes().build());
		event.put(SPIRITOF_THE_DEPTHS.get(), SpiritofTheDepthsEntity.createAttributes().build());
		event.put(SPIRITOF_MIDAS.get(), SpiritofMidasEntity.createAttributes().build());
		event.put(GUARD_ROBOT.get(), GuardRobotEntity.createAttributes().build());
		event.put(INFECTED_GOON.get(), InfectedGoonEntity.createAttributes().build());
		event.put(WITCH_1.get(), Witch1Entity.createAttributes().build());
		event.put(CAT_FAMILIAR.get(), CatFamiliarEntity.createAttributes().build());
		event.put(PUMPKIN_BROOM_ENTITY.get(), PumpkinBroomEntityEntity.createAttributes().build());
		event.put(GHOSTLY_BROOM_ENTITY.get(), GhostlyBroomEntityEntity.createAttributes().build());
		event.put(EVIL_BROOM_ENTITY.get(), EvilBroomEntityEntity.createAttributes().build());
		event.put(FERAL_VAMPIRE.get(), FeralVampireEntity.createAttributes().build());
		event.put(BLOOD_COLLECTOR_ENTITY.get(), BloodCollectorEntityEntity.createAttributes().build());
		event.put(VAMPIRE_NPC.get(), VampireNPCEntity.createAttributes().build());
		event.put(SWAMP_LIGHT.get(), SwampLightEntity.createAttributes().build());
		event.put(HUNGRY_TREE.get(), HungryTreeEntity.createAttributes().build());
		event.put(SWAMPMONSTER_VILLAGER.get(), SwampmonsterVillagerEntity.createAttributes().build());
		event.put(SWAMPMONSTER_CHIEFTAN.get(), SwampmonsterChieftanEntity.createAttributes().build());
		event.put(DEATHBLOOM_ENTITY.get(), DeathbloomEntityEntity.createAttributes().build());
		event.put(INFERNAL_LIGHT.get(), InfernalLightEntity.createAttributes().build());
		event.put(FERAL_SWAMPMONSTER.get(), FeralSwampmonsterEntity.createAttributes().build());
		event.put(WILL_O_THE_WISP.get(), WillOTheWispEntity.createAttributes().build());
		event.put(FERAL_GOBLIN.get(), FeralGoblinEntity.createAttributes().build());
		event.put(GOBLIN_VILLAGER.get(), GoblinVillagerEntity.createAttributes().build());
		event.put(HUNTER_NPC.get(), HunterNPCEntity.createAttributes().build());
		event.put(SOCIETY_SPAWNER.get(), SocietySpawnerEntity.createAttributes().build());
		event.put(CHANGELING.get(), ChangelingEntity.createAttributes().build());
		event.put(GOBLIN_FOLLOWER.get(), GoblinFollowerEntity.createAttributes().build());
		event.put(HUNTER_VILLAGE_MARKER.get(), HunterVillageMarkerEntity.createAttributes().build());
		event.put(FERAL_WEREWOLF.get(), FeralWerewolfEntity.createAttributes().build());
		event.put(FOLLOWER_WEREWOLF.get(), FollowerWerewolfEntity.createAttributes().build());
		event.put(WEREWOLF_TERRITORY_MARKER.get(), WerewolfTerritoryMarkerEntity.createAttributes().build());
		event.put(DIRE_WEREWOLF.get(), DireWerewolfEntity.createAttributes().build());
		event.put(HUMAN_WEREWOLF.get(), HumanWerewolfEntity.createAttributes().build());
		event.put(FERAL_MOUNTAIN_TROLL.get(), FeralMountainTrollEntity.createAttributes().build());
		event.put(FERAL_MOUNTAIN_TROLL_SPAWNER.get(), FeralMountainTrollSpawnerEntity.createAttributes().build());
		event.put(ENHANCED_ZOMBIE.get(), EnhancedZombieEntity.createAttributes().build());
		event.put(ENHANCED_HUSK.get(), EnhancedHuskEntity.createAttributes().build());
		event.put(ENHANCED_DROWNED.get(), EnhancedDrownedEntity.createAttributes().build());
		event.put(LARGE_POSSESSING_ENTITY.get(), LargePossessingEntityEntity.createAttributes().build());
		event.put(SERVANT_PUMPKIN.get(), ServantPumpkinEntity.createAttributes().build());
		event.put(PUMPKIN_GOLEM.get(), PumpkinGolemEntity.createAttributes().build());
		event.put(DARKENED_BLOSSOM.get(), DarkenedBlossomEntity.createAttributes().build());
		event.put(SERVANT_SKELETON.get(), ServantSkeletonEntity.createAttributes().build());
		event.put(AGGRESSIVE_GUARD.get(), AggressiveGuardEntity.createAttributes().build());
		event.put(GUARD_SPAWNER.get(), GuardSpawnerEntity.createAttributes().build());
		event.put(TROLL_NPC.get(), TrollNPCEntity.createAttributes().build());
		event.put(HELPER_SPIRIT.get(), HelperSpiritEntity.createAttributes().build());
		event.put(SORCERER_NPC.get(), SorcererNPCEntity.createAttributes().build());
		event.put(BLAZING_BARRIER.get(), BlazingBarrierEntity.createAttributes().build());
		event.put(AUTUMN_PLACEHOLDER.get(), AutumnPlaceholderEntity.createAttributes().build());
		event.put(ORE_PLACEHOLDER.get(), OrePlaceholderEntity.createAttributes().build());
		event.put(MYSTERIOUS_SHADOW.get(), MysteriousShadowEntity.createAttributes().build());
		event.put(ENEMY_PLACEHOLDER.get(), EnemyPlaceholderEntity.createAttributes().build());
		event.put(DARK_MARKET_VENDOR.get(), DarkMarketVendorEntity.createAttributes().build());
		event.put(DEADLY_BALLOON.get(), DeadlyBalloonEntity.createAttributes().build());
		event.put(EVIL_CLOWN_1.get(), EvilClown1Entity.createAttributes().build());
		event.put(EVIL_CLOWN_2.get(), EvilClown2Entity.createAttributes().build());
		event.put(EVIL_CLOWN_3.get(), EvilClown3Entity.createAttributes().build());
		event.put(CLOWN_SPAWNER.get(), ClownSpawnerEntity.createAttributes().build());
		event.put(DEMON_NPC.get(), DemonNPCEntity.createAttributes().build());
		event.put(DEMON_SPAWNER.get(), DemonSpawnerEntity.createAttributes().build());
		event.put(MANIAC.get(), ManiacEntity.createAttributes().build());
		event.put(MANIAC_SPAWNER.get(), ManiacSpawnerEntity.createAttributes().build());
		event.put(CURED_VAMPIRE.get(), CuredVampireEntity.createAttributes().build());
		event.put(RAID.get(), RaidEntity.createAttributes().build());
		event.put(HUNTER_PATROL_NPC.get(), HunterPatrolNPCEntity.createAttributes().build());
		event.put(MONSTER_VILLAGE_MARKER.get(), MonsterVillageMarkerEntity.createAttributes().build());
		event.put(PURE_FEAR_MARKER.get(), PureFearMarkerEntity.createAttributes().build());
		event.put(MURKANUS_WORM.get(), MurkanusWormEntity.createAttributes().build());
		event.put(EYELET.get(), EyeletEntity.createAttributes().build());
	}
}