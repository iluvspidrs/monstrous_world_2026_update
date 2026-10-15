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

import net.mcreator.monstrousworld.procedures.OpenWitcheryRobeProcedure;
import net.mcreator.monstrousworld.procedures.OpenTomeOfWitcheryPage4Procedure;
import net.mcreator.monstrousworld.procedures.OpenTomeOfWitcheryPage2Procedure;
import net.mcreator.monstrousworld.procedures.OpenLadleProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfWitcheryPage3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfWitcheryPage3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_witchery_page_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfWitcheryPage3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfWitcheryPage3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfWitcheryPage3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfWitcheryPage3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfWitcheryPage3ButtonMessage message, final IPayloadContext context) {
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

			OpenWitcheryRobeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenWitcheryRobeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenLadleProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenTomeOfWitcheryPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenTomeOfWitcheryPage4Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfWitcheryPage3ButtonMessage.TYPE, TomeOfWitcheryPage3ButtonMessage.STREAM_CODEC, TomeOfWitcheryPage3ButtonMessage::handleData);
	}
}