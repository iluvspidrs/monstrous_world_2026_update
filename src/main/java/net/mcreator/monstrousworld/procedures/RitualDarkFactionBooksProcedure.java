package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class RitualDarkFactionBooksProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestVillager = null;
		Entity NearestWanderingTrader = null;
		Entity NearestHunter = null;
		Entity NearestSocietyMember = null;
		Entity NearestAggressiveGuard = null;
		Entity NearestHunterPatrol = null;
		NearestVillager = findEntityInWorldRange(world, Villager.class, x, y, z, 20);
		NearestWanderingTrader = findEntityInWorldRange(world, WanderingTrader.class, x, y, z, 20);
		NearestHunter = findEntityInWorldRange(world, HunterNPCEntity.class, x, y, z, 20);
		NearestSocietyMember = findEntityInWorldRange(world, SocietyGoonEntity.class, x, y, z, 20);
		NearestAggressiveGuard = findEntityInWorldRange(world, AggressiveGuardEntity.class, x, y, z, 20);
		NearestHunterPatrol = findEntityInWorldRange(world, HunterPatrolNPCEntity.class, x, y, z, 20);
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SORCERER_CHESTPLATE.get()) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get() && (getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Faction Books")) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
							if ((entity.level().dimension()) == Level.NETHER) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOOK) {
									if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(0, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Added 1 Book to ritual"), true);
										if (world instanceof ServerLevel)
											((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
									if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ItemStack.EMPTY.getItem()) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(1, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Added 1 Pure Dark Essence to ritual"), true);
										if (world instanceof ServerLevel)
											((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:dark_ingredients")))) {
									if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == ItemStack.EMPTY.getItem()) {
										if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
											ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
											_setstack.setCount(1);
											_itemHandlerModifiable.setStackInSlot(2, _setstack);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Added 1 Dark Ingredient to ritual"), true);
										if (world instanceof ServerLevel)
											((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MASTER_RITUAL_WAND.get()) {
									if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
										if (!world.getEntitiesOfClass(Villager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
												|| !world.getEntitiesOfClass(WanderingTrader.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
												|| !world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
												|| !world.getEntitiesOfClass(HunterPatrolNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
												|| !world.getEntitiesOfClass(SocietyGoonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
												|| !world.getEntitiesOfClass(AggressiveGuardEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
											if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BOOK
													&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
												if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:dark_ingredients")))) {
													if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Infernal Power summoned!"), false);
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_INFERNAL_POWER.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
															_vars.markSyncDirty();
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = -100;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Fun and Games summoned!"), true);
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_FUN_AND_GAMES.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
															_vars.markSyncDirty();
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = -100;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
														}
													} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BUTCHER_KNIFE.get()) {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (world instanceof ServerLevel)
															((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Tome of Violence summoned!"), true);
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_VIOLENCE.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
														if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
															_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
															_vars.markSyncDirty();
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = -100;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
														}
													}
													if (!world.getEntitiesOfClass(Villager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
														NearestVillager.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													} else if (!world.getEntitiesOfClass(WanderingTrader.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
														NearestWanderingTrader.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													} else if (!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
														NearestHunter.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													} else if (!world.getEntitiesOfClass(SocietyGoonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
														NearestSocietyMember.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													} else if (!world.getEntitiesOfClass(AggressiveGuardEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
														NearestAggressiveGuard.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													} else {
														NearestHunterPatrol.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
													}
												}
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("An ordinary human sacrifice is required..."), true);
										}
									}
								}
							}
						} else {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
								if ((entity.level().dimension()) == Level.NETHER) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOOK) {
										if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
												ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack.setCount(1);
												_itemHandlerModifiable.setStackInSlot(0, _setstack);
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Added 1 Book to ritual"), true);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
										if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
												ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack.setCount(1);
												_itemHandlerModifiable.setStackInSlot(1, _setstack);
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Added 1 Pure Dark Essence to ritual"), true);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:dark_ingredients")))) {
										if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
												ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack.setCount(1);
												_itemHandlerModifiable.setStackInSlot(2, _setstack);
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Added 1 Dark Ingredient to ritual"), true);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, y, z, 5, 1, 1, 1, 1);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MASTER_RITUAL_WAND.get()) {
										if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
											if (!world.getEntitiesOfClass(Villager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
													|| !world.getEntitiesOfClass(WanderingTrader.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
													|| !world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
													|| !world.getEntitiesOfClass(HunterPatrolNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
													|| !world.getEntitiesOfClass(SocietyGoonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()
													|| !world.getEntitiesOfClass(AggressiveGuardEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
												if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BOOK
														&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
													if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("monstrous_world:dark_ingredients")))) {
														if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															if (world instanceof ServerLevel)
																((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_INFERNAL_POWER.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Tome of Infernal Power summoned!"), false);
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
															MonstrousWorldMod.queueServerWork(1, () -> {
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.Reputation = -100;
																		_vars.markSyncDirty();
																	}
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																	if (entity instanceof LivingEntity _entity)
																		_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
																}
															});
														} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															if (world instanceof ServerLevel)
																((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_FUN_AND_GAMES.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Tome of Fun and Games summoned!"), true);
															MonstrousWorldMod.queueServerWork(1, () -> {
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.Reputation = -100;
																		_vars.markSyncDirty();
																	}
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																	if (entity instanceof LivingEntity _entity)
																		_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
																}
															});
														} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == MonstrousWorldModItems.BUTCHER_KNIFE.get()) {
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															if (world instanceof ServerLevel)
																((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_VIOLENCE.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
															if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
																_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 30;
																_vars.markSyncDirty();
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Tome of Violence summoned!"), true);
															MonstrousWorldMod.queueServerWork(1, () -> {
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.Reputation = -100;
																		_vars.markSyncDirty();
																	}
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
																}
																if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
																	if (entity instanceof LivingEntity _entity)
																		_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
																}
															});
														}
														if (!world.getEntitiesOfClass(Villager.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
															NearestVillager.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														} else if (!world.getEntitiesOfClass(WanderingTrader.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
															NearestWanderingTrader.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														} else if (!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
															NearestHunter.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														} else if (!world.getEntitiesOfClass(SocietyGoonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
															NearestSocietyMember.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														} else if (!world.getEntitiesOfClass(AggressiveGuardEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
															NearestAggressiveGuard.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														} else {
															NearestHunterPatrol.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 200);
														}
													}
												}
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("An ordinary human sacrifice is required..."), true);
											}
										}
									}
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This baffles you"), false);
							}
						}
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}