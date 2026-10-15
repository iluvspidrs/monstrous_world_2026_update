package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class UseMadScientistContractProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double tin_ingot = 0;
		double dark_ingot = 0;
		dark_ingot = 0;
		if (!world.isClientSide()) {
			if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (MonstrousWorldModItems.DARKENED_IRON_INGOT.get() == itemstackiterator.getItem()) {
						dark_ingot = dark_ingot + itemstackiterator.getCount();
					}
				}
			}
			if (dark_ingot >= 16) {
				if (sourceentity instanceof ServerPlayer && entity instanceof MadScientistNPCEntity) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
						if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.isBaby())) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
								if (!(entity.getPersistentData().getString("NoSoul")).equals("true")) {
									if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEMONIC_CONTRACT_MAD_SCIENTIST.get()) {
										if (sourceentity instanceof Player _player)
											_player.closeContainer();
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Your victim accepts the contact, and you take their soul!"), false);
											entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
											entity.getPersistentData().putString("NoSoul", "true");
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											entity.getPersistentData().putDouble("TributeCooldown", 0);
											if (sourceentity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 16, _player.inventoryMenu.getCraftSlots());
											}
											if (sourceentity instanceof Player _player) {
												ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.ENSLAVED_WICKED_SOUL.get()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
												if (getEntityScore("mad_scientist_contract", sourceentity) == 0) {
													{
														Entity _ent = sourceentity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("mad_scientist_contract");
														if (_so == null)
															_so = _sc.addObjective("mad_scientist_contract", ObjectiveCriteria.DUMMY, Component.literal("mad_scientist_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = sourceentity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", sourceentity) + 1);
													}
													if (getEntityScore("Faction Points", sourceentity) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 6;
															_vars.markSyncDirty();
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (sourceentity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), true);
													}
												}
											}
											MonstrousWorldMod.queueServerWork(3, () -> {
												{
													final Vec3 _center = new Vec3(x, y, z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof ItemEntity) {
															if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENSLAVED_WICKED_SOUL.get()
																	|| (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENSLAVED_WICKED_SOUL.get()) {
																{
																	final String _tagName = "ID";
																	final String _tagValue = ("" + entity.getStringUUID());
																	CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
																}
																{
																	final String _tagName = "Type";
																	final String _tagValue = "Mad Scientist";
																	CustomData.update(DataComponents.CUSTOM_DATA, (entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
																}
																entityiterator.getPersistentData().putString("ID", ("" + entity.getStringUUID()));
																entityiterator.getPersistentData().putString("Type", "Mad Scientist");
															}
														}
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}