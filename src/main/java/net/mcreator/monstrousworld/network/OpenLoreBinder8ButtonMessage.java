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
public record OpenLoreBinder8ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinder8ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_8_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinder8ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinder8ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinder8ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinder8ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinder8ButtonMessage message, final IPayloadContext context) {
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

			BinderOpenAGoodAlphaRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenTomeOfTheMoonRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenAHuntersWarningWerewolfProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenAClawedJournalProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			BinderOpenToDigFasterProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BinderOpenToKeepArmorProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BinderOpenForGreaterKnockbckProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BinderOpenToStunPreyProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BinderOpenToReduceFallDamageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			BinderOpenForHandlingItemsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BinderOpenArchaeologicalNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			AddLoreToBinderPage8Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinder8ButtonMessage.TYPE, OpenLoreBinder8ButtonMessage.STREAM_CODEC, OpenLoreBinder8ButtonMessage::handleData);
	}
}