package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.ManiacThisEntityKillsAnotherOneProcedure;
import net.mcreator.monstrousworld.procedures.ManiacOnEntityTickUpdateProcedure;
import net.mcreator.monstrousworld.procedures.ManiacNaturalEntitySpawningConditionProcedure;
import net.mcreator.monstrousworld.procedures.ManiacEntityIsHurtProcedure;
import net.mcreator.monstrousworld.procedures.ManiacEntityDiesProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class ManiacEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_Trade = SynchedEntityData.defineId(ManiacEntity.class, EntityDataSerializers.INT);

	public ManiacEntity(EntityType<ManiacEntity> type, Level world) {
		super(type, world);
		xpReward = 100;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstrousWorldModItems.MANIAC_ARMOR_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstrousWorldModItems.MANIAC_ARMOR_LEGGINGS.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Trade, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, HunterNPCEntity.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, HunterPatrolNPCEntity.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, false, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, InfectedGoonEntity.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, MadScientistNPCEntity.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Witch1Entity.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, SorcererNPCEntity.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, GuardRobotEntity.class, false, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, VampireNPCEntity.class, false, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, HumanWerewolfEntity.class, false, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, TrollNPCEntity.class, false, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, GoblinVillagerEntity.class, false, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, GoblinFollowerEntity.class, false, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, SwampmonsterVillagerEntity.class, false, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, SwampmonsterChieftanEntity.class, false, false));
		this.goalSelector.addGoal(19, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(20, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(21, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(22, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(23, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(24, new FloatGoal(this));
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
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		ManiacEntityIsHurtProcedure.execute(world, entity, sourceentity);
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		ManiacEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataTrade", this.entityData.get(DATA_Trade));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataTrade"))
			this.entityData.set(DATA_Trade, compound.getInt("DataTrade"));
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		ManiacThisEntityKillsAnotherOneProcedure.execute(this.level(), entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ManiacOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MonstrousWorldModEntities.MANIAC.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ManiacNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 48);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}