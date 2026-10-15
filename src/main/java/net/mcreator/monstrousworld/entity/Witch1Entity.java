package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.RangedAttackMob;
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

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class Witch1Entity extends Monster implements RangedAttackMob {
	public static final EntityDataAccessor<Boolean> DATA_Vampire = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_Trade = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_HasZombieCure = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_HasVampireCure = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_HasWerewolfCure = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Skin = SynchedEntityData.defineId(Witch1Entity.class, EntityDataSerializers.INT);

	public Witch1Entity(EntityType<Witch1Entity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Vampire, false);
		builder.define(DATA_Trade, 0);
		builder.define(DATA_HasZombieCure, 0);
		builder.define(DATA_HasVampireCure, 0);
		builder.define(DATA_HasWerewolfCure, 0);
		builder.define(DATA_Skin, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.8));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, true, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, true, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, DireWerewolfEntity.class, true, false));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 8));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 60, 10f) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
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
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("DataVampire", this.entityData.get(DATA_Vampire));
		compound.putInt("DataTrade", this.entityData.get(DATA_Trade));
		compound.putInt("DataHasZombieCure", this.entityData.get(DATA_HasZombieCure));
		compound.putInt("DataHasVampireCure", this.entityData.get(DATA_HasVampireCure));
		compound.putInt("DataHasWerewolfCure", this.entityData.get(DATA_HasWerewolfCure));
		compound.putInt("DataSkin", this.entityData.get(DATA_Skin));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataVampire"))
			this.entityData.set(DATA_Vampire, compound.getBoolean("DataVampire"));
		if (compound.contains("DataTrade"))
			this.entityData.set(DATA_Trade, compound.getInt("DataTrade"));
		if (compound.contains("DataHasZombieCure"))
			this.entityData.set(DATA_HasZombieCure, compound.getInt("DataHasZombieCure"));
		if (compound.contains("DataHasVampireCure"))
			this.entityData.set(DATA_HasVampireCure, compound.getInt("DataHasVampireCure"));
		if (compound.contains("DataHasWerewolfCure"))
			this.entityData.set(DATA_HasWerewolfCure, compound.getInt("DataHasWerewolfCure"));
		if (compound.contains("DataSkin"))
			this.entityData.set(DATA_Skin, compound.getInt("DataSkin"));
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		ThrownFrogifyPowderEntity.shoot(this, target);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}