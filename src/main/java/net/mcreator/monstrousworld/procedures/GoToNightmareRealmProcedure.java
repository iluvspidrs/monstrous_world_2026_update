package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GoToNightmareRealmProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Villager && entity instanceof LivingEntity _livEnt2 && _livEnt2.isSleeping()) {
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4 && sourceentity.isShiftKeyDown()) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						entity.getPersistentData().putDouble("DeadlyNightmare", 1);
						sourceentity.getPersistentData().putDouble("Nightmare", 10);
						sourceentity.getPersistentData().putDouble("NightmareX", (entity.getX()));
						sourceentity.getPersistentData().putDouble("NightmareY", (entity.getY()));
						sourceentity.getPersistentData().putDouble("NightmareZ", (entity.getZ()));
						if (sourceentity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_walking_nightmare"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.ARMORER) {
							sourceentity.getPersistentData().putString("VJob", "armorer");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FARMER) {
							sourceentity.getPersistentData().putString("VJob", "farmer");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
							sourceentity.getPersistentData().putString("VJob", "librarian");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
							sourceentity.getPersistentData().putString("VJob", "cartographer");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
							sourceentity.getPersistentData().putString("VJob", "fletcher");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
							sourceentity.getPersistentData().putString("VJob", "butcher");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.CLERIC) {
							sourceentity.getPersistentData().putString("VJob", "cleric");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
							sourceentity.getPersistentData().putString("VJob", "leatherworker");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
							sourceentity.getPersistentData().putString("VJob", "fisherman");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.MASON) {
							sourceentity.getPersistentData().putString("VJob", "mason");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
							sourceentity.getPersistentData().putString("VJob", "weaponsmith");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
							sourceentity.getPersistentData().putString("VJob", "shepherd");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
							sourceentity.getPersistentData().putString("VJob", "toolsmith");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.NITWIT) {
							sourceentity.getPersistentData().putString("VJob", "nitwit");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getProfession() == VillagerProfession.NONE) {
							sourceentity.getPersistentData().putString("VJob", "none");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.PLAINS) {
							sourceentity.getPersistentData().putString("VBiome", "plains");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.TAIGA) {
							sourceentity.getPersistentData().putString("VBiome", "taiga");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.DESERT) {
							sourceentity.getPersistentData().putString("VBiome", "desert");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.JUNGLE) {
							sourceentity.getPersistentData().putString("VBiome", "jungle");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.SAVANNA) {
							sourceentity.getPersistentData().putString("VBiome", "savanna");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getType() == VillagerType.SNOW) {
							sourceentity.getPersistentData().putString("VBiome", "snow");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 1) {
							sourceentity.getPersistentData().putString("VStage", "1");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 2) {
							sourceentity.getPersistentData().putString("VStage", "2");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 3) {
							sourceentity.getPersistentData().putString("VStage", "3");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 4) {
							sourceentity.getPersistentData().putString("VStage", "4");
						}
						if (entity instanceof Villager && ((Villager) entity).getVillagerData().getLevel() == 5) {
							sourceentity.getPersistentData().putString("VStage", "5");
						}
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You can only invade nightmares from the Overworld"), true);
				}
			}
		}
	}
}