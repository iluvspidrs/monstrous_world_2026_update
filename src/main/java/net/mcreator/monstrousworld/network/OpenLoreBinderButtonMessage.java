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
public record OpenLoreBinderButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinderButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinderButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinderButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinderButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinderButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinderButtonMessage message, final IPayloadContext context) {
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

			BinderOpenPamphletPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenATornJournalContentsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenEmailArchiveProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenFarmersLogProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			BinderOpenANoteOnSpiritsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BinderOpenSocietyDirectiveProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BinderOpenUnusualInfectionPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BinderOpenMysteriousContainerPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BinderOpenMuseumClosedPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			BinderOpenQuotaProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BinderOpenMuseumAdProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			BinderOpenDarkMarketAdProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			BinderOpenTrickOrTreatAdProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			BinderOpenTomeOfLightNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			AddLoreToBinderProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinderButtonMessage.TYPE, OpenLoreBinderButtonMessage.STREAM_CODEC, OpenLoreBinderButtonMessage::handleData);
	}
}