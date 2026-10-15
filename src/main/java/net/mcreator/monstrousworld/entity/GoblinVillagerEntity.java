package net.mcreator.monstrousworld.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.procedures.OpenTradingGUIGoblinProcedure;
import net.mcreator.monstrousworld.procedures.MoveIndoorsConditionProcedure;

public class GoblinVillagerEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_Skin = SynchedEntityData.defineId(GoblinVillagerEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Trade = SynchedEntityData.defineId(GoblinVillagerEntity.class, EntityDataSerializers.INT);

	public GoblinVillagerEntity(EntityType<GoblinVillagerEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Skin, 0);
		builder.define(DATA_Trade, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, SocietyGoonEntity.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, AggressiveGuardEntity.class, false, false));
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 6));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, GoblinVillagerEntity.class, (float) 6));
		this.goalSelector.addGoal(8, new MoveBackToVillageGoal(this, 0.6, false) {
			@Override
			public boolean canUse() {
				double x = GoblinVillagerEntity.this.getX();
				double y = GoblinVillagerEntity.this.getY();
				double z = GoblinVillagerEntity.this.getZ();
				Entity entity = GoblinVillagerEntity.this;
				Level world = GoblinVillagerEntity.this.level();
				return super.canUse() && MoveIndoorsConditionProcedure.execute(world);
			}
		});
		this.goalSelector.addGoal(9, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(10, new OpenDoorGoal(this, true));
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
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataSkin", this.entityData.get(DATA_Skin));
		compound.putInt("DataTrade", this.entityData.get(DATA_Trade));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataSkin"))
			this.entityData.set(DATA_Skin, compound.getInt("DataSkin"));
		if (compound.contains("DataTrade"))
			this.entityData.set(DATA_Trade, compound.getInt("DataTrade"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		OpenTradingGUIGoblinProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}