package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WebSequenceProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof Spider || sourceentity instanceof CaveSpider) {
				if (entity instanceof Player || entity instanceof ServerPlayer || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))
						|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:nonhuman_being")))) {
					if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3)) {
							if (Math.random() >= 0.7) {
								if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.COBWEB)
										&& !((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.COBWEB)) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Blocks.COBWEB.defaultBlockState(), 3);
										world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), Blocks.COBWEB.defaultBlockState(), 3);
									});
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WebbedLevel == 0) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEBBED, 1200, 0));
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.WebbedLevel = 1;
											_vars.markSyncDirty();
										}
									});
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WebbedLevel == 1) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEBBED, 1200, 1));
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.WebbedLevel = 2;
											_vars.markSyncDirty();
										}
										if (entity instanceof LivingEntity _entity) {
											AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:webbed_scale"), (-0.5), AttributeModifier.Operation.ADD_VALUE);
											if (!_entity.getAttribute(Attributes.SCALE).hasModifier(modifier.id())) {
												_entity.getAttribute(Attributes.SCALE).addPermanentModifier(modifier);
											}
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
											}
										}
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
											}
										}
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
											}
										}
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
											}
										}
									});
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WebbedLevel == 2) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.WebbedLevel = 3;
											_vars.markSyncDirty();
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("The spider bites and your flesh dissolves..."), false);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEBBED, 1200, 1));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 4));
										MonstrousWorldMod.queueServerWork(100, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.squish")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.squish")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
											if (world instanceof ServerLevel _serverworld) {
												StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("monstrous_world", "webbed_victim_1"));
												if (template != null) {
													template.placeInWorld(_serverworld, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
															new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
												}
											}
										});
									});
								}
							}
						}
					}
				}
			}
		}
	}
}