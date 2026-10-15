package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.SwampmonsterVillagerOnEntityTickUpdateProcedure;
import net.mcreator.monstrousworld.procedures.MoveIndoorsConditionProcedure;

public class SwampmonsterChieftanEntity extends Monster {
	public SwampmonsterChieftanEntity(EntityType<SwampmonsterChieftanEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, false, false));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 10));
		this.goalSelector.addGoal(6, new AvoidEntityGoal<>(this, HungryTreeEntity.class, (float) 10, 1, 1.2));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(9, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(10, new MoveBackToVillageGoal(this, 0.6, false) {
			@Override
			public boolean canUse() {
				double x = SwampmonsterChieftanEntity.this.getX();
				double y = SwampmonsterChieftanEntity.this.getY();
				double z = SwampmonsterChieftanEntity.this.getZ();
				Entity entity = SwampmonsterChieftanEntity.this;
				Level world = SwampmonsterChieftanEntity.this.level();
				return super.canUse() && MoveIndoorsConditionProcedure.execute(world);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SwampmonsterChieftanEntity.this.getX();
				double y = SwampmonsterChieftanEntity.this.getY();
				double z = SwampmonsterChieftanEntity.this.getZ();
				Entity entity = SwampmonsterChieftanEntity.this;
				Level world = SwampmonsterChieftanEntity.this.level();
				return super.canContinueToUse() && MoveIndoorsConditionProcedure.execute(world);
			}
		});
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(12, new FloatGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
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
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SwampmonsterVillagerOnEntityTickUpdateProcedure.execute(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 7);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}