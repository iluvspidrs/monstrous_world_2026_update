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

import net.mcreator.monstrousworld.procedures.OpenIronBoltProcedure;
import net.mcreator.monstrousworld.procedures.FieldGuidePageForwardProcedure;
import net.mcreator.monstrousworld.procedures.FieldGuidePageBackwardProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record HuntersFieldGuidePage9ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<HuntersFieldGuidePage9ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "hunters_field_guide_page_9_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HuntersFieldGuidePage9ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HuntersFieldGuidePage9ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HuntersFieldGuidePage9ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<HuntersFieldGuidePage9ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HuntersFieldGuidePage9ButtonMessage message, final IPayloadContext context) {
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

			OpenIronBoltProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			FieldGuidePageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			FieldGuidePageBackwardProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(HuntersFieldGuidePage9ButtonMessage.TYPE, HuntersFieldGuidePage9ButtonMessage.STREAM_CODEC, HuntersFieldGuidePage9ButtonMessage::handleData);
	}
}