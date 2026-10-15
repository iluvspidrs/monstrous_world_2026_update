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

import net.mcreator.monstrousworld.procedures.TomeOfInfernalPowerPageForwardProcedure;
import net.mcreator.monstrousworld.procedures.TomeOfInfernalPowerPageBackwardProcedure;
import net.mcreator.monstrousworld.procedures.OpenNetherBoneDaggerProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfInfernalPowerPage14ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfInfernalPowerPage14ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_infernal_power_page_14_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfInfernalPowerPage14ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfInfernalPowerPage14ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfInfernalPowerPage14ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfInfernalPowerPage14ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfInfernalPowerPage14ButtonMessage message, final IPayloadContext context) {
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

			OpenNetherBoneDaggerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenNetherBoneDaggerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			TomeOfInfernalPowerPageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			TomeOfInfernalPowerPageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfInfernalPowerPage14ButtonMessage.TYPE, TomeOfInfernalPowerPage14ButtonMessage.STREAM_CODEC, TomeOfInfernalPowerPage14ButtonMessage::handleData);
	}
}