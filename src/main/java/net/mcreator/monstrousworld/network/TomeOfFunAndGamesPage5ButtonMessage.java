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

import net.mcreator.monstrousworld.procedures.TomeOfFunAndGamesPageForwardProcedure;
import net.mcreator.monstrousworld.procedures.TomeOfFunAndGamesPageBackwardProcedure;
import net.mcreator.monstrousworld.procedures.OpenCottonCandyProcedure;
import net.mcreator.monstrousworld.procedures.OpenAcidGunProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfFunAndGamesPage5ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfFunAndGamesPage5ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_fun_and_games_page_5_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfFunAndGamesPage5ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfFunAndGamesPage5ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfFunAndGamesPage5ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfFunAndGamesPage5ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfFunAndGamesPage5ButtonMessage message, final IPayloadContext context) {
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

			OpenCottonCandyProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenAcidGunProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			TomeOfFunAndGamesPageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			TomeOfFunAndGamesPageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfFunAndGamesPage5ButtonMessage.TYPE, TomeOfFunAndGamesPage5ButtonMessage.STREAM_CODEC, TomeOfFunAndGamesPage5ButtonMessage::handleData);
	}
}