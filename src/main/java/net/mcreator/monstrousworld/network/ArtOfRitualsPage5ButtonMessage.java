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

import net.mcreator.monstrousworld.procedures.TheArtOfRitualsPageForwardProcedure;
import net.mcreator.monstrousworld.procedures.TheArtOfRitualsPageBackwardProcedure;
import net.mcreator.monstrousworld.procedures.TheArtOfRitualsBlueTOCButtonProcedure;
import net.mcreator.monstrousworld.procedures.OpenSorceryRobeProcedure;
import net.mcreator.monstrousworld.procedures.OpenRitualWandProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record ArtOfRitualsPage5ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ArtOfRitualsPage5ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "art_of_rituals_page_5_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ArtOfRitualsPage5ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ArtOfRitualsPage5ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ArtOfRitualsPage5ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ArtOfRitualsPage5ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ArtOfRitualsPage5ButtonMessage message, final IPayloadContext context) {
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

			OpenRitualWandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenSorceryRobeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			TheArtOfRitualsBlueTOCButtonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			TheArtOfRitualsPageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			TheArtOfRitualsPageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(ArtOfRitualsPage5ButtonMessage.TYPE, ArtOfRitualsPage5ButtonMessage.STREAM_CODEC, ArtOfRitualsPage5ButtonMessage::handleData);
	}
}