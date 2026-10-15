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

import net.mcreator.monstrousworld.procedures.OpenSwampEssenceDustProcedure;
import net.mcreator.monstrousworld.procedures.OpenSwampCrystalBlockProcedure;
import net.mcreator.monstrousworld.procedures.DeathbloomInstructionsPageForwardProcedure;
import net.mcreator.monstrousworld.procedures.DeathbloomInstructionsPageBackwardProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record DeathbloomPage3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<DeathbloomPage3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "deathbloom_page_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DeathbloomPage3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DeathbloomPage3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DeathbloomPage3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<DeathbloomPage3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DeathbloomPage3ButtonMessage message, final IPayloadContext context) {
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

			OpenSwampCrystalBlockProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenSwampEssenceDustProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			DeathbloomInstructionsPageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			DeathbloomInstructionsPageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(DeathbloomPage3ButtonMessage.TYPE, DeathbloomPage3ButtonMessage.STREAM_CODEC, DeathbloomPage3ButtonMessage::handleData);
	}
}