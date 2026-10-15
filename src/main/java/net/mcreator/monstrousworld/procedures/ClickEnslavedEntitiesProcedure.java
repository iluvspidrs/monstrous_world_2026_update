package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClickEnslavedEntitiesProcedure {
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
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
					if (sourceentity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:exploitation"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIBUTE_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIBUTE_COOLDOWN).getDuration() : 0) == 0) {
						if (entity instanceof GoblinVillagerEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:goblin_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof TrollNPCEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:troll_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof Witch1Entity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:witch_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof SorcererNPCEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:sorcerer_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof VampireNPCEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:vampire_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof HumanWerewolfEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:werewolf_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof SwampmonsterVillagerEntity || entity instanceof SwampmonsterChieftanEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof MadScientistNPCEntity) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:lab_reward")))
											.getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FARMER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									FarmerTradesZombieProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									ButcherTradesZombieProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.ARMORER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									ArmorerTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									WeaponsmithTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									LibrarianTradesProcedure.execute(world, x, y, z, entity);
								}
								PullEnchantedBooksProcedure.execute(world, x, y, z, entity);
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									ShepherdTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.MASON) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									MasonTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									LeatherworkerTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									FishermanTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									ToolsmithTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CLERIC) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									ClericTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									CartographerTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 5); _i1++) {
									FletcherTradesProcedure.execute(world, x, y, z, entity);
								}
							});
						} else {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (entity instanceof Villager) {
									for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
								}
							});
						}
						MonstrousWorldMod.queueServerWork(5, () -> {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRIBUTE_COOLDOWN, 18000, 0, true, false));
						});
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This creature cannot pay you again yet..."), false);
					}
				}
			}
		}
	}
}