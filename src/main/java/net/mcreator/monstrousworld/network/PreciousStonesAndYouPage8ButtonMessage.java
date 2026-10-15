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

import net.mcreator.monstrousworld.procedures.PreciousStonesPage9Procedure;
import net.mcreator.monstrousworld.procedures.PreciousStonesPage7Procedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record PreciousStonesAndYouPage8ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PreciousStonesAndYouPage8ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "precious_stones_and_you_page_8_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PreciousStonesAndYouPage8ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PreciousStonesAndYouPage8ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PreciousStonesAndYouPage8ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PreciousStonesAndYouPage8ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PreciousStonesAndYouPage8ButtonMessage message, final IPayloadContext context) {
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

			PreciousStonesPage9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			PreciousStonesPage7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(PreciousStonesAndYouPage8ButtonMessage.TYPE, PreciousStonesAndYouPage8ButtonMessage.STREAM_CODEC, PreciousStonesAndYouPage8ButtonMessage::handleData);
	}
}