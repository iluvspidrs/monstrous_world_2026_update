/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.potion.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public class MonstrousWorldModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MonstrousWorldMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> PUMPKINS_REVENGE = REGISTRY.register("pumpkins_revenge", PumpkinsRevengeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> DISAPPOINTMENT = REGISTRY.register("disappointment", DisappointmentMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> POSSESSED = REGISTRY.register("possessed", PossessedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> POSSESSED_2 = REGISTRY.register("possessed_2", Possessed2MobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SUGAR_RUSH = REGISTRY.register("sugar_rush", SugarRushMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> STRANGE_SERUM = REGISTRY.register("strange_serum", StrangeSerumMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> CURE_SERUM = REGISTRY.register("cure_serum", CureSerumMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MYSTERIOUS_DARKNESS = REGISTRY.register("mysterious_darkness", MysteriousDarknessMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> INSANITY = REGISTRY.register("insanity", InsanityMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SOUL_PARALYSIS = REGISTRY.register("soul_paralysis", SoulParalysisMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> CREEPER_SHIELD = REGISTRY.register("creeper_shield", CreeperShieldMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> PUMPKINS_REST = REGISTRY.register("pumpkins_rest", PumpkinsRestMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SAPPED = REGISTRY.register("sapped", SappedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> COLD_BLOODED = REGISTRY.register("cold_blooded", ColdBloodedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> STABILIZING_SERUM = REGISTRY.register("stabilizing_serum", StabilizingSerumMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SINKING = REGISTRY.register("sinking", SinkingMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MIDAS_CURSE = REGISTRY.register("midas_curse", MidasCurseMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> DRY_EYE = REGISTRY.register("dry_eye", DryEyeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> HYPNOSIS = REGISTRY.register("hypnosis", HypnosisMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> DESPAIR = REGISTRY.register("despair", DespairMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> DESSICATION = REGISTRY.register("dessication", DessicationMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> IRON_POISONING = REGISTRY.register("iron_poisoning", IronPoisoningMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ENCHANTED = REGISTRY.register("enchanted", EnchantedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> CRAZED = REGISTRY.register("crazed", CrazedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MENTAL_FORTITUDE = REGISTRY.register("mental_fortitude", MentalFortitudeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> HOLY_DAMAGE = REGISTRY.register("holy_damage", HolyDamageMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ALPHAS_BOON = REGISTRY.register("alphas_boon", AlphasBoonMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> LUNAR_PULL = REGISTRY.register("lunar_pull", LunarPullMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WEBBED = REGISTRY.register("webbed", WebbedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> UNDEAD_GLOW = REGISTRY.register("undead_glow", UndeadGlowMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> UNDEAD_CURE = REGISTRY.register("undead_cure", UndeadCureMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BAD_OMEN_SOCIETY = REGISTRY.register("bad_omen_society", BadOmenSocietyMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> HERO_OF_THE_VILLAGE = REGISTRY.register("hero_of_the_village", HeroOfTheVillageMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WARRIOR_TRIAL = REGISTRY.register("warrior_trial", WarriorTrialMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> AUTUMN_MAGIC = REGISTRY.register("autumn_magic", AutumnMagicMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> EASY_MINING = REGISTRY.register("easy_mining", EasyMiningMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TRICKED = REGISTRY.register("tricked", TrickedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> UNHOLY_DAMAGE = REGISTRY.register("unholy_damage", UnholyDamageMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> CURSED_CONFECTION = REGISTRY.register("cursed_confection", CursedConfectionMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> INFESTED = REGISTRY.register("infested", InfestedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BLOOD_LOSS = REGISTRY.register("blood_loss", BloodLossMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> LOOMING_UNDEATH = REGISTRY.register("looming_undeath", LoomingUndeathMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SLOW_ESCAPE = REGISTRY.register("slow_escape", SlowEscapeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MORE_NIGHTMARES = REGISTRY.register("more_nightmares", MoreNightmaresMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> NO_DEFENSE = REGISTRY.register("no_defense", NoDefenseMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MAGICALLY_POSSESSED = REGISTRY.register("magically_possessed", MagicallyPossessedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> VAMPIRISM = REGISTRY.register("vampirism", VampirismMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> RECENT_INFECTION = REGISTRY.register("recent_infection", RecentInfectionMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> REANIMATED = REGISTRY.register("reanimated", ReanimatedMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BLACKOUT = REGISTRY.register("blackout", BlackoutMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WEREWOLF_INFECTION = REGISTRY.register("werewolf_infection", WerewolfInfectionMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TRANSFORM_COOLDOWN = REGISTRY.register("transform_cooldown", TransformCooldownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WEREWOLF_EFFECT = REGISTRY.register("werewolf_effect", WerewolfEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BAD_REPUTATION = REGISTRY.register("bad_reputation", BadReputationMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BLOOD_RECOVERY = REGISTRY.register("blood_recovery", BloodRecoveryMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> VAMPIRE_INFECTION_EFFECT = REGISTRY.register("vampire_infection_effect", VampireInfectionEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TRIBUTE_COOLDOWN = REGISTRY.register("tribute_cooldown", TributeCooldownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ZOMBIE_INFECTION_EFFECT = REGISTRY.register("zombie_infection_effect", ZombieInfectionEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> VAMPIRISM_ENTITY = REGISTRY.register("vampirism_entity", VampirismEntityMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> WITCH_EFFECT = REGISTRY.register("witch_effect", WitchEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> GOBLIN_EFFECT = REGISTRY.register("goblin_effect", GoblinEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TRUE_EVIL_TRUCE = REGISTRY.register("true_evil_truce", TrueEvilTruceMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TRIDENT_COOLDOWN = REGISTRY.register("trident_cooldown", TridentCooldownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ENTITY_HUNGER = REGISTRY.register("entity_hunger", EntityHungerMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> EYE_EFFECT = REGISTRY.register("eye_effect", EyeEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SERPENT_EFFECT = REGISTRY.register("serpent_effect", SerpentEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SWAMPMONSTER_EFFECT = REGISTRY.register("swampmonster_effect", SwampmonsterEffectMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MURKANUS_MARTH = REGISTRY.register("murkanus_marth", MurkanusMarthMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MURKANUS_MARTH_COUNTDOWN = REGISTRY.register("murkanus_marth_countdown", MurkanusMarthCountdownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> TREASURE_SEEKER = REGISTRY.register("treasure_seeker", TreasureSeekerMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MEDLEY_COUNTDOWN = REGISTRY.register("medley_countdown", MedleyCountdownMobEffect::new);

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(STRANGE_SERUM)) {
			StrangeSerumEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(SINKING)) {
			SinkingEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(DRY_EYE)) {
			DryEyeEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(LUNAR_PULL)) {
			LunarPullEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(WEBBED)) {
			WebbedEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(UNDEAD_GLOW)) {
			UndeadGlowEffectExpiresProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(VAMPIRISM)) {
			VampirismEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(TRANSFORM_COOLDOWN)) {
			TransformCooldownEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(WEREWOLF_EFFECT)) {
			WerewolfEffectEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(BLOOD_RECOVERY)) {
			BloodRecoveryEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(VAMPIRISM_ENTITY)) {
			VampirismEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(GOBLIN_EFFECT)) {
			GoblinEffectEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(ENTITY_HUNGER)) {
			EntityHungerEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MURKANUS_MARTH)) {
			MurkanusMarthEffectExpiresProcedure.execute(entity);
		}
	}
}