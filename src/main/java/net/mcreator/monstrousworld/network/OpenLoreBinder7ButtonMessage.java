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
public record OpenLoreBinder7ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinder7ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_7_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinder7ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinder7ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinder7ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinder7ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinder7ButtonMessage message, final IPayloadContext context) {
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

			BinderOpenTomeOfTheSwampProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenDeathbloomInstructionsRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenExplorerLogPart1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenExplorerLogPart2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			BinderOpenAHuntersWarningSwampProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BinderOpenEyeletNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BinderOpenInterrogationNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BinderOpenMurkanusMarthNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BinderOpenRecipeSlugSoupProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			BinderOpenRecipeCaterpillarStewProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BinderOpenRecipeMurkyMedleyProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			AddLoreToBinderPage7Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinder7ButtonMessage.TYPE, OpenLoreBinder7ButtonMessage.STREAM_CODEC, OpenLoreBinder7ButtonMessage::handleData);
	}
}