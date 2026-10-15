package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class MysteriousDarknessOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 50000) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
						if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
							if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75I have a very dark gift planned for you..."), false);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/playsound entity.warden.roar master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 24000) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
						if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
							if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You are feeling very unnerved..."), false);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 18000) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
						if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
							if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Your heart races from building anxiety..."), false);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 12000) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
						if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
							if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You feel sick from the rising terror..."), false);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 6000) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
						if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
							if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true || MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You can barely contain your panic..."), false);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 2) {
					if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == false) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.EvilFaction = 2;
								_vars.markSyncDirty();
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 2
								|| hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_LIGHT.get())) || MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == false) {
							for (int _i1 = 0; _i1 < 150; _i1++) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = Mth.nextInt(RandomSource.create(), 1, 9);
									_vars.markSyncDirty();
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
									if (MonstrousWorldConfigConfiguration.ALLOW_WITCH_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
									if (MonstrousWorldConfigConfiguration.ALLOW_GOBLIN_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
									if (MonstrousWorldConfigConfiguration.ALLOW_TROLL_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
									if (MonstrousWorldConfigConfiguration.ALLOW_SORCERER_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
									if (MonstrousWorldConfigConfiguration.ALLOW_MAD_SCIENTIST_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
									if (MonstrousWorldConfigConfiguration.ALLOW_SWAMP_MONSTER_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
									if (MonstrousWorldConfigConfiguration.ALLOW_WEREWOLF_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
									if (MonstrousWorldConfigConfiguration.ALLOW_VAMPIRE_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
									if (MonstrousWorldConfigConfiguration.ALLOW_DARKNESS_FACTION.get() == true) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.DarknessTimer = 0;
										_vars.markSyncDirty();
									}
								}
							}
						} else {
							for (int _i1 = 0; _i1 < 50; _i1++) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = Mth.nextInt(RandomSource.create(), 10, 12);
									_vars.markSyncDirty();
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
									if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
									if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
									if (MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
										entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.DarknessTimer = 0;
											_vars.markSyncDirty();
										}
										break;
									}
								} else {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.DarknessTimer = 0;
										_vars.markSyncDirty();
									}
								}
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 1) {
							if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_LIGHT.get()))) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
									if (world.isClientSide())
										Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(MonstrousWorldModItems.TOME_OF_LIGHT.get()));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This book of light stops the worst of the darkness!"), true);
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:slightly_less_horrifying"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.TOME_OF_LIGHT.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else {
									for (int _i1 = 0; _i1 < 50; _i1++) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
											if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true) {
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof LivingEntity _entity)
													_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
												entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.markSyncDirty();
												}
												break;
											}
										} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
											if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true) {
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof LivingEntity _entity)
													_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
												entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.markSyncDirty();
												}
												break;
											}
										} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
											if (MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof LivingEntity _entity)
													_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
												entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.markSyncDirty();
												}
												break;
											}
										} else {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
										}
									}
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS,
							(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) + 1, 0));
			}
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS,
						(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) + 1, 0));
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}