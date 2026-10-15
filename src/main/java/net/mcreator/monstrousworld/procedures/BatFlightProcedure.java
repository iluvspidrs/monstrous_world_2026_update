package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BatFlightProcedure {
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
		if (world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
					if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
						if (new Object() {
							public boolean getValue() {
								boolean retBool = Minecraft.getInstance().options.keyJump.isDown();
								if (retBool) {
									if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("SHIFT")) {
										retBool = Screen.hasShiftDown();
									} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("CONTROL")) {
										retBool = Screen.hasControlDown();
									} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("ALT")) {
										retBool = Screen.hasAltDown();
									}
								}
								return retBool;
							}
						}.getValue()) {
							if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))) {
								entity.setDeltaMovement(new Vec3(0, 0.3, 0));
							}
						} else if (new Object() {
							public boolean getValue() {
								boolean retBool = Minecraft.getInstance().options.keyShift.isDown();
								if (retBool) {
									if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("SHIFT")) {
										retBool = Screen.hasShiftDown();
									} else if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("CONTROL")) {
										retBool = Screen.hasControlDown();
									} else if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("ALT")) {
										retBool = Screen.hasAltDown();
									}
								}
								return retBool;
							}
						}.getValue()) {
							if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))) {
								entity.setDeltaMovement(new Vec3(0, (-0.3), 0));
							}
						} else if (new Object() {
							public boolean getValue() {
								boolean retBool = Minecraft.getInstance().options.keyUp.isDown();
								if (retBool) {
									if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("SHIFT")) {
										retBool = Screen.hasShiftDown();
									} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("CONTROL")) {
										retBool = Screen.hasControlDown();
									} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("ALT")) {
										retBool = Screen.hasAltDown();
									}
								}
								return retBool;
							}
						}.getValue()) {
							if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))) {
								entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.5), (entity.getXRot() * (-0.01)), (entity.getLookAngle().z * 0.5)));
							}
						} else {
							entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0), (entity.getXRot() * (-0.01)), (entity.getLookAngle().z * 0)));
						}
					}
				}
			}
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
}