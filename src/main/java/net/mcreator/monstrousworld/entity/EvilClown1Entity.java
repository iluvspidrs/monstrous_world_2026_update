package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.EvilClownNaturalEntitySpawningConditionProcedure;
import net.mcreator.monstrousworld.procedures.EvilClown1EntityDiesProcedure;
import net.mcreator.monstrousworld.procedures.DemonNPCThisEntityKillsAnotherOneProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class EvilClown1Entity extends Monster {
	public EvilClown1Entity(EntityType<EvilClown1Entity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, WanderingTrader.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Pillager.class, false, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, HunterNPCEntity.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Witch1Entity.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, SorcererNPCEntity.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, GoblinVillagerEntity.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, TrollNPCEntity.class, false, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, VampireNPCEntity.class, false, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, SwampmonsterVillagerEntity.class, false, false));
		this.goalSelector.addGoal(14, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(15, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(16, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(17, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(18, new FloatGoal(this));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:clown_horn"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		EvilClown1EntityDiesProcedure.execute(this.level(), this, source.getEntity());
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		DemonNPCThisEntityKillsAnotherOneProcedure.execute(this.level(), entity);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MonstrousWorldModEntities.EVIL_CLOWN_1.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return EvilClownNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 60);
		builder = builder.add(Attributes.ARMOR, 3);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}