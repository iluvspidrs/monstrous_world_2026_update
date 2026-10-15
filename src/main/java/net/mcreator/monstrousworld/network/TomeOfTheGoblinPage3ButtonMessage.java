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

import net.mcreator.monstrousworld.procedures.TomeOfTheGoblinPageForwardProcedure;
import net.mcreator.monstrousworld.procedures.TomeOfTheGoblinPageBackwardProcedure;
import net.mcreator.monstrousworld.procedures.OpenGoblinWorkstationProcedure;
import net.mcreator.monstrousworld.procedures.OpenGoblinOvenProcedure;
import net.mcreator.monstrousworld.procedures.OpenFluteProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfTheGoblinPage3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfTheGoblinPage3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_the_goblin_page_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfTheGoblinPage3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfTheGoblinPage3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfTheGoblinPage3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfTheGoblinPage3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfTheGoblinPage3ButtonMessage message, final IPayloadContext context) {
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

			OpenFluteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenGoblinWorkstationProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenGoblinWorkstationProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenGoblinOvenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			TomeOfTheGoblinPageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			TomeOfTheGoblinPageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfTheGoblinPage3ButtonMessage.TYPE, TomeOfTheGoblinPage3ButtonMessage.STREAM_CODEC, TomeOfTheGoblinPage3ButtonMessage::handleData);
	}
}