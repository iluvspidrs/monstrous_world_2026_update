package net.mcreator.monstrousworld.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record LaptopSampleGuardRobotPage2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<LaptopSampleGuardRobotPage2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "laptop_sample_guard_robot_page_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, LaptopSampleGuardRobotPage2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, LaptopSampleGuardRobotPage2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new LaptopSampleGuardRobotPage2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<LaptopSampleGuardRobotPage2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final LaptopSampleGuardRobotPage2ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			OpenElectricityChannelerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenRobotTableSectionProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenRobotGuardHeadProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenElectricityChannelerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenElectricityChannelerBottomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenRobotGuardBodyAndArmsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenRobotGuardLegsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			LaptopTOCButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			LaptopMainScreenBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(LaptopSampleGuardRobotPage2ButtonMessage.TYPE, LaptopSampleGuardRobotPage2ButtonMessage.STREAM_CODEC, LaptopSampleGuardRobotPage2ButtonMessage::handleData);
	}
}