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

public class SorcererNPCEntity extends Monster implements RangedAttackMob {
	public static final EntityDataAccessor<Integer> DATA_Trade = SynchedEntityData.defineId(SorcererNPCEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Skin = SynchedEntityData.defineId(SorcererNPCEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_Vampire = SynchedEntityData.defineId(SorcererNPCEntity.class, EntityDataSerializers.BOOLEAN);

	public SorcererNPCEntity(EntityType<SorcererNPCEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstrousWorldModItems.SORCERER_CHESTPLATE.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Trade, 0);
		builder.define(DATA_Skin, 0);
		builder.define(DATA_Vampire, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, false, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, false, false));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 6));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, SorcererNPCEntity.class, (float) 6));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 60, 16f) {
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
		compound.putInt("DataTrade", this.entityData.get(DATA_Trade));
		compound.putInt("DataSkin", this.entityData.get(DATA_Skin));
		compound.putBoolean("DataVampire", this.entityData.get(DATA_Vampire));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataTrade"))
			this.entityData.set(DATA_Trade, compound.getInt("DataTrade"));
		if (compound.contains("DataSkin"))
			this.entityData.set(DATA_Skin, compound.getInt("DataSkin"));
		if (compound.contains("DataVampire"))
			this.entityData.set(DATA_Vampire, compound.getBoolean("DataVampire"));
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		LevitationChargeProjectileEntity.shoot(this, target);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}