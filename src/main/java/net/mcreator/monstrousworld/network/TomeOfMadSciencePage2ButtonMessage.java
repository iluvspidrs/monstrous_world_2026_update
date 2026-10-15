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

import net.mcreator.monstrousworld.procedures.TomeOfMadSciencePageForwardProcedure;
import net.mcreator.monstrousworld.procedures.TomeOfMadSciencePageBackwardProcedure;
import net.mcreator.monstrousworld.procedures.OpenTestTUbeProcedure;
import net.mcreator.monstrousworld.procedures.OpenSyringeProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfMadSciencePage2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfMadSciencePage2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_mad_science_page_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfMadSciencePage2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfMadSciencePage2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfMadSciencePage2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfMadSciencePage2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfMadSciencePage2ButtonMessage message, final IPayloadContext context) {
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

			OpenTestTUbeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenTestTUbeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			TomeOfMadSciencePageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenSyringeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			TomeOfMadSciencePageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfMadSciencePage2ButtonMessage.TYPE, TomeOfMadSciencePage2ButtonMessage.STREAM_CODEC, TomeOfMadSciencePage2ButtonMessage::handleData);
	}
}