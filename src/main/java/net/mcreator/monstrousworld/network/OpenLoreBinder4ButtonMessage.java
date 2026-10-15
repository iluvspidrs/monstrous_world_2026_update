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

import net.mcreator.monstrousworld.procedures.BinderOpenTomeOfTheTrollProcedure;
import net.mcreator.monstrousworld.procedures.BinderOpenTheWarriorsArenaPage1Procedure;
import net.mcreator.monstrousworld.procedures.BinderOpenTheVileRaidersPage1Procedure;
import net.mcreator.monstrousworld.procedures.BinderOpenHeavyMetalsRightclickedProcedure;
import net.mcreator.monstrousworld.procedures.AddLoreToBinderPage4Procedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record OpenLoreBinder4ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinder4ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_4_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinder4ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinder4ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinder4ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinder4ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinder4ButtonMessage message, final IPayloadContext context) {
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

			BinderOpenTomeOfTheTrollProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenHeavyMetalsRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenTheWarriorsArenaPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenTheVileRaidersPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			AddLoreToBinderPage4Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinder4ButtonMessage.TYPE, OpenLoreBinder4ButtonMessage.STREAM_CODEC, OpenLoreBinder4ButtonMessage::handleData);
	}
}