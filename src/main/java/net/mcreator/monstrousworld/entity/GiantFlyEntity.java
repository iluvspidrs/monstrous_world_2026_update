package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.GiantFlyNaturalEntitySpawningConditionProcedure;
import net.mcreator.monstrousworld.procedures.GiantFlyAttackConditionProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

import java.util.EnumSet;

public class GiantFlyEntity extends Monster {
	public GiantFlyEntity(EntityType<GiantFlyEntity> type, Level world) {
		super(type, world);
		xpReward = 20;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, ServerPlayer.class, true, false) {
			@Override
			public boolean canUse() {
				double x = GiantFlyEntity.this.getX();
				double y = GiantFlyEntity.this.getY();
				double z = GiantFlyEntity.this.getZ();
				Entity entity = GiantFlyEntity.this;
				Level world = GiantFlyEntity.this.level();
				return super.canUse() && GiantFlyAttackConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (GiantFlyEntity.this.getTarget() != null && !GiantFlyEntity.this.getMoveControl().hasWanted()) {
					double x = GiantFlyEntity.this.getX();
					double y = GiantFlyEntity.this.getY();
					double z = GiantFlyEntity.this.getZ();
					Entity entity = GiantFlyEntity.this;
					Level world = GiantFlyEntity.this.level();
					return GiantFlyAttackConditionProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return GiantFlyEntity.this.getMoveControl().hasWanted() && GiantFlyEntity.this.getTarget() != null && GiantFlyEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = GiantFlyEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				GiantFlyEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = GiantFlyEntity.this.getTarget();
				if (GiantFlyEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					GiantFlyEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = GiantFlyEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						GiantFlyEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = GiantFlyEntity.this.getX();
				double y = GiantFlyEntity.this.getY();
				double z = GiantFlyEntity.this.getZ();
				Entity entity = GiantFlyEntity.this;
				Level world = GiantFlyEntity.this.level();
				return super.canUse() && GiantFlyAttackConditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.3, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = GiantFlyEntity.this.getRandom();
				double dir_x = GiantFlyEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = GiantFlyEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = GiantFlyEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.bee.loop"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.bee.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.bee.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	@Override
	protected float getFlyingSpeed() {
		return (float) this.getAttributeValue(Attributes.FLYING_SPEED);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MonstrousWorldModEntities.GIANT_FLY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return GiantFlyNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}
}