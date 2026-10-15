package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TradeWithZombieVillagerProcedure {
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
		if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4 && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BRAIN.get()) {
			if (entity instanceof ZombieVillager) {
				if (!(sourceentity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
					if (sourceentity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:primitive_trading"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.BRAIN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.chime")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 3, 3, 3, 1);
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
					if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.FARMER) {
						sourceentity.getPersistentData().putDouble("FarmerTrade", (Mth.nextInt(RandomSource.create(), 1, 7)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							FarmerTradesZombieProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
						sourceentity.getPersistentData().putDouble("ButcherTrade", (Mth.nextInt(RandomSource.create(), 1, 3)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							ButcherTradesZombieProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.ARMORER) {
						sourceentity.getPersistentData().putDouble("ArmorerTrade", (Mth.nextInt(RandomSource.create(), 1, 7)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							ArmorerTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
						sourceentity.getPersistentData().putDouble("WeaponsmithTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							WeaponsmithTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
						sourceentity.getPersistentData().putDouble("LibrarianTrade", (Mth.nextInt(RandomSource.create(), 1, 5)));
						sourceentity.getPersistentData().putDouble("EnchantmentType", (Mth.nextInt(RandomSource.create(), 1, 101)));
						LibrarianTradesProcedure.execute(world, x, y, z, entity);
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (entity.getPersistentData().getDouble("LibrarianTrade") == 5) {
								if (entity.getPersistentData().getDouble("EnchantmentType") == 1) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'aqua_affinity':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 2) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'bane_of_arthropods':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 3) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'bane_of_arthropods':5}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 4) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'blast_protection':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 5) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'blast_protection':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 6) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'channeling':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 7) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'depth_strider':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 8) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'density':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 9) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'efficiency':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 10) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'efficiency':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 11) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'efficiency':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 12) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'efficiency':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 13) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'feather_falling':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 14) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'feather_falling':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 15) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'feather_falling':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 16) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'feather_falling':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 17) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_aspect':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 18) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_aspect':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 19) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_protection':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 20) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_protection':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 21) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_protection':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 22) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fire_protection':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 23) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'flame':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 24) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fortune':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 25) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fortune':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 26) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'fortune':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 27) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'frost_walker':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 28) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'frost_walker':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 29) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'impaling':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 30) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'impaling':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 31) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'impaling':5}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 32) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'infinity':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 33) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'knockback':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 34) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'knockback':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 35) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'looting':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 36) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'looting':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 37) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'looting':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 38) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'wind_burst':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 39) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'loyalty':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 40) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'loyalty':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 41) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'loyalty':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 42) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'luck_of_the_sea':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 43) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'luck_of_the_sea':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 44) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'luck_of_the_sea':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 45) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'lure':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 46) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'lure':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 47) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'lure':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 48) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'mending':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 49) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'multishot':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 50) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'piercing':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 51) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'piercing':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 52) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'piercing':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 53) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'piercing':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 54) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'power':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 55) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'power':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 56) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'power':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 57) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'power':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 58) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'power':5}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 59) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'projectile_protection':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 60) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'projectile_protection':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 61) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'projectile_protection':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 62) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'protection':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 63) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'protection':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 64) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'protection':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 65) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'punch':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 66) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'punch':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 67) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'quick_charge':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 68) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'quick_charge':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 69) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'quick_charge':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 70) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'riptide':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 71) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'riptide':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 72) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'riptide':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 73) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sharpness':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 74) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sharpness':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 75) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sharpness':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 76) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sharpness':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 77) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sharpness':5}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 78) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'silk_touch':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 79) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sweeping_edge':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 80) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sweeping_edge':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 81) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'sweeping_edge':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 82) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'thorns':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 83) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'thorns':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 84) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'thorns':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 85) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'unbreaking':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 86) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'unbreaking':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 87) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'unbreaking':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 88) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'swift_sneak':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 89) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'swift_sneak':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 90) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'swift_sneak':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 91) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'wind_burst':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 92) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'wind_burst':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 93) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'breach':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 94) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'breach':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 95) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'breach':3}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 96) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'breach':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 97) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'breach':5}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 98) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'density':1}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 99) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'density':2}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 100) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'density':4}}] 1");
								}
								if (entity.getPersistentData().getDouble("EnchantmentType") == 101) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/give @p enchanted_book[stored_enchantments={levels:{'density':5}}] 1");
								}
							}
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
						sourceentity.getPersistentData().putDouble("ShepherdTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							ShepherdTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.MASON) {
						sourceentity.getPersistentData().putDouble("MasonTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							MasonTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
						sourceentity.getPersistentData().putDouble("LeatherworkerTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							LeatherworkerTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
						sourceentity.getPersistentData().putDouble("FishermanTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							FishermanTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
						sourceentity.getPersistentData().putDouble("ToolsmithTrade", (Mth.nextInt(RandomSource.create(), 1, 7)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							ToolsmithTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.CLERIC) {
						sourceentity.getPersistentData().putDouble("ClericTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							ClericTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
						sourceentity.getPersistentData().putDouble("CartographerTrade", (Mth.nextInt(RandomSource.create(), 1, 7)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							CartographerTradesProcedure.execute(world, x, y, z, entity);
						});
					} else if (entity instanceof ZombieVillager && ((ZombieVillager) entity).getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
						sourceentity.getPersistentData().putDouble("FletcherTrade", (Mth.nextInt(RandomSource.create(), 1, 6)));
						MonstrousWorldMod.queueServerWork(1, () -> {
							FletcherTradesProcedure.execute(world, x, y, z, entity);
						});
					} else {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						});
					}
				}
			}
		}
	}
}