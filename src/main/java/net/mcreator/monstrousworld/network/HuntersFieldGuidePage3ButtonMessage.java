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

import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record HuntersFieldGuidePage3ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<HuntersFieldGuidePage3ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "hunters_field_guide_page_3_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HuntersFieldGuidePage3ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HuntersFieldGuidePage3ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HuntersFieldGuidePage3ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<HuntersFieldGuidePage3ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HuntersFieldGuidePage3ButtonMessage message, final IPayloadContext context) {
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

			OpenSoakingBasinProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			FieldGuidePageForwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			FieldGuidePageBackwardProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenHunterHatProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenHunterCoatProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenHunterLeggingsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenHunterBootsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(HuntersFieldGuidePage3ButtonMessage.TYPE, HuntersFieldGuidePage3ButtonMessage.STREAM_CODEC, HuntersFieldGuidePage3ButtonMessage::handleData);
	}
}