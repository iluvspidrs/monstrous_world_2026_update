package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.HunterTagsOnSpawnProcedure;
import net.mcreator.monstrousworld.procedures.DemonNPCThisEntityKillsAnotherOneProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

public class HunterNPCEntity extends Monster implements RangedAttackMob {
	public static final EntityDataAccessor<Integer> DATA_Skin = SynchedEntityData.defineId(HunterNPCEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Trade = SynchedEntityData.defineId(HunterNPCEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_Vampire = SynchedEntityData.defineId(HunterNPCEntity.class, EntityDataSerializers.BOOLEAN);

	public HunterNPCEntity(EntityType<HunterNPCEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MonstrousWorldModItems.TRAINEE_CROSSBOW_STANDBY.get()));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstrousWorldModItems.HUNTER_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstrousWorldModItems.HUNTER_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstrousWorldModItems.HUNTER_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(MonstrousWorldModItems.HUNTER_BOOTS.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Skin, 0);
		builder.define(DATA_Trade, 0);
		builder.define(DATA_Vampire, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, (float) 8));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 8));
		this.goalSelector.addGoal(5, new FollowMobGoal(this, 1, (float) 10, (float) 5));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 40, 16f) {
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		HunterTagsOnSpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataSkin", this.entityData.get(DATA_Skin));
		compound.putInt("DataTrade", this.entityData.get(DATA_Trade));
		compound.putBoolean("DataVampire", this.entityData.get(DATA_Vampire));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataSkin"))
			this.entityData.set(DATA_Skin, compound.getInt("DataSkin"));
		if (compound.contains("DataTrade"))
			this.entityData.set(DATA_Trade, compound.getInt("DataTrade"));
		if (compound.contains("DataVampire"))
			this.entityData.set(DATA_Vampire, compound.getBoolean("DataVampire"));
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		DemonNPCThisEntityKillsAnotherOneProcedure.execute(this.level(), entity);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		SilverBoltNPCProjectileEntity.shoot(this, target);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}