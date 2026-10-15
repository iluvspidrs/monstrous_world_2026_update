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

import net.mcreator.monstrousworld.procedures.BinderOpenTomeOfSorceryRightclickedProcedure;
import net.mcreator.monstrousworld.procedures.BinderOpenTheArtOfRitualsRightclickedProcedure;
import net.mcreator.monstrousworld.procedures.BinderOpenSacrificePage1Procedure;
import net.mcreator.monstrousworld.procedures.BinderOpenPumpionCottageWelcomeProcedure;
import net.mcreator.monstrousworld.procedures.AddLoreToBinderPage5Procedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record OpenLoreBinder5ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinder5ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_5_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinder5ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinder5ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinder5ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinder5ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinder5ButtonMessage message, final IPayloadContext context) {
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

			BinderOpenTomeOfSorceryRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenTheArtOfRitualsRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenSacrificePage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenPumpionCottageWelcomeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			AddLoreToBinderPage5Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinder5ButtonMessage.TYPE, OpenLoreBinder5ButtonMessage.STREAM_CODEC, OpenLoreBinder5ButtonMessage::handleData);
	}
}