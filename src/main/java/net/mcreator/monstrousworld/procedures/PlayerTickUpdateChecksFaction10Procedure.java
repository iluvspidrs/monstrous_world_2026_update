package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class PlayerTickUpdateChecksFaction10Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestPlayer = null;
		Entity Shademarker = null;
		Entity NearestHungryTree = null;
		Entity TargetEntity = null;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == false) {
					if (!entity.onGround()) {
						if (!entity.isInWaterOrBubble()) {
							if (!entity.isInLava()) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 0, false, false));
							}
						}
					}
				}
				if (!((entity.level().dimension()) == Level.NETHER)) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:cauldron_heating")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:cauldron_heating")))
							|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:cauldron_heating")))) {
						entity.clearFire();
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WEAKNESS);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled >= 1) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Chilled = 1;
								_vars.markSyncDirty();
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Disguised = false;
								_vars.markSyncDirty();
							}
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your true form is revealed!"), true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
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
							}
							if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_CHESTPLATE.get())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
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
							}
							if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))));
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
							}
						}
					} else {
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_CHESTPLATE.get())
								|| !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_LEGGINGS.get())) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Chilled = 0;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Chilled = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled - 1;
									_vars.markSyncDirty();
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled == 0) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Chilled = 2400;
										_vars.markSyncDirty();
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled >= 201) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This place is too cold for you..."), true);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, false));
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled == 200) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your form weakens and fades out of this world..."), true);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 2, false, false));
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false));
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled == 1) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putString("xx", ("" + entity.getX() / 8));
										entity.getPersistentData().putString("yy", "70");
										entity.getPersistentData().putString("zz", ("" + entity.getZ() / 8));
										entity.getPersistentData().putString("spawnlocation", "xx yy zz");
									});
									MonstrousWorldMod.queueServerWork(2, () -> {
										entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
									});
									MonstrousWorldMod.queueServerWork(3, () -> {
										entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
									});
									MonstrousWorldMod.queueServerWork(4, () -> {
										entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
									});
									MonstrousWorldMod.queueServerWork(5, () -> {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("/execute as @p in minecraft:the_nether run teleport placeholder".replace("placeholder", entity.getPersistentData().getString("spawnlocation"))));
											}
										}
									});
								}
							}
						} else {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Chilled = 0;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:escaping_the_nether"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				} else {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Chilled = 0;
						_vars.markSyncDirty();
					}
				}
				if ((entity.level().dimension()) == Level.NETHER) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled >= 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Chilled = 0;
							_vars.markSyncDirty();
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Disguised = false;
							_vars.markSyncDirty();
						}
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
							}
						}
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You cannot hide your true form here..."), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
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
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_CHESTPLATE.get())) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
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
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackFromItemStackSlot(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))));
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
						}
					}
					if (entity.isInLava()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1));
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).SetSpawn == false) {
						if (entity instanceof ServerPlayer) {
							if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).canOcclude()
									&& !((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.NETHER_PORTAL)) {
								if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
									if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))) {
										if (entity instanceof ServerPlayer _serverPlayer)
											_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Respawn point set"), true);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.SetSpawn = true;
											_vars.markSyncDirty();
										}
									}
								}
							}
						}
					}
					if (entity.isInWall()) {
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ());
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() + 1);
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() - 1);
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1);
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1);
							BlockState _bs = Blocks.CAVE_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENSLAVED_SOUL.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENSLAVED_WICKED_SOUL.get()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))
									|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:can_trade")))) {
								if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("ID"))
										.equals(entityiterator.getStringUUID())) {
									if (entityiterator instanceof Mob _entity)
										_entity.getNavigation().moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 1);
								}
							}
						}
					}
				}
			}
		}
	}

	private static ItemStack getItemStackFromItemStackSlot(int slotID, ItemStack itemStack) {
		IItemHandler itemHandler = itemStack.getCapability(Capabilities.ItemHandler.ITEM, null);
		if (itemHandler != null)
			return itemHandler.getStackInSlot(slotID).copy();
		return ItemStack.EMPTY;
	}
}