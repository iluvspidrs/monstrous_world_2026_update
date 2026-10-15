package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.EnumSet;

public class DeadlyBalloonEntity extends Monster {
	public DeadlyBalloonEntity(EntityType<DeadlyBalloonEntity> type, Level world) {
		super(type, world);
		xpReward = 10;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (DeadlyBalloonEntity.this.getTarget() != null && !DeadlyBalloonEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return DeadlyBalloonEntity.this.getMoveControl().hasWanted() && DeadlyBalloonEntity.this.getTarget() != null && DeadlyBalloonEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = DeadlyBalloonEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				DeadlyBalloonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.2);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = DeadlyBalloonEntity.this.getTarget();
				if (DeadlyBalloonEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					DeadlyBalloonEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = DeadlyBalloonEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						DeadlyBalloonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.2);
					}
				}
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.02, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = DeadlyBalloonEntity.this.getRandom();
				double dir_x = DeadlyBalloonEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = DeadlyBalloonEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = DeadlyBalloonEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
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
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
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
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 5);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}
}