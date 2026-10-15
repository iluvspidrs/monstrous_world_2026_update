package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DarkBookshelfBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (MonstrousWorldConfigConfiguration.ALLOW_BOOKSHELF_SPIRITS.get() == true) {
				if (Math.random() >= 0.66) {
					if (Math.random() > 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.EVIL_DARKNESS_SPIRIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_TROLL.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_TROLL.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_SORCERY.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_SORCERY.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_MAD_SCIENCE.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_MAD_SCIENCE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_MOON.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_MOON.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_BLOODLUST.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_BLOODLUST.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_INFERNAL_POWER.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_INFERNAL_POWER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_FUN_AND_GAMES.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_FUN_AND_GAMES.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
				if (Math.random() >= 0.75) {
					if (!hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.TOME_OF_VIOLENCE.get()))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.TOME_OF_VIOLENCE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}