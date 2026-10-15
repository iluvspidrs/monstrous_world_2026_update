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

import net.mcreator.monstrousworld.procedures.LaptopStrangeSerumButtonPressedProcedure;
import net.mcreator.monstrousworld.procedures.LaptopSampleListButtonPressedProcedure;
import net.mcreator.monstrousworld.procedures.LaptopIntroButtonPressedProcedure;
import net.mcreator.monstrousworld.procedures.LaptopCreatingRobotsButtonPressedProcedure;
import net.mcreator.monstrousworld.procedures.LaptopAnalyzeOptionPressedProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record LaptopTOCButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<LaptopTOCButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "laptop_toc_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, LaptopTOCButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, LaptopTOCButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new LaptopTOCButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<LaptopTOCButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final LaptopTOCButtonMessage message, final IPayloadContext context) {
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

			LaptopSampleListButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			LaptopIntroButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			LaptopStrangeSerumButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			LaptopCreatingRobotsButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			LaptopAnalyzeOptionPressedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(LaptopTOCButtonMessage.TYPE, LaptopTOCButtonMessage.STREAM_CODEC, LaptopTOCButtonMessage::handleData);
	}
}