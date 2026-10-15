package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.SocietyGoonEntityDiesProcedure;
import net.mcreator.monstrousworld.procedures.InfectedGoonOnEntityTickUpdateProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class SocietyGoonEntity extends Monster {
	public static final EntityDataAccessor<Boolean> DATA_VampireEyes = SynchedEntityData.defineId(SocietyGoonEntity.class, EntityDataSerializers.BOOLEAN);

	public SocietyGoonEntity(EntityType<SocietyGoonEntity> type, Level world) {
		super(type, world);
		xpReward = 20;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MonstrousWorldModItems.MONSTER_DETECTOR.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_VampireEyes, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, SocietyGoonEntity.class, (float) 12, 1, 1.2));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(6, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 10));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new FloatGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		SocietyGoonEntityDiesProcedure.execute(this.level(), this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("DataVampireEyes", this.entityData.get(DATA_VampireEyes));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataVampireEyes"))
			this.entityData.set(DATA_VampireEyes, compound.getBoolean("DataVampireEyes"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		InfectedGoonOnEntityTickUpdateProcedure.execute(this.level(), this);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 25);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}