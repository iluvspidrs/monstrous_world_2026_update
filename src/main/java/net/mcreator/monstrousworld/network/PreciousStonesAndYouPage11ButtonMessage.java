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

import net.mcreator.monstrousworld.procedures.PreciousStonesPage12Procedure;
import net.mcreator.monstrousworld.procedures.PreciousStonesPage10Procedure;
import net.mcreator.monstrousworld.procedures.OpenEssenceOfEnchantmentProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record PreciousStonesAndYouPage11ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PreciousStonesAndYouPage11ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "precious_stones_and_you_page_11_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PreciousStonesAndYouPage11ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PreciousStonesAndYouPage11ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PreciousStonesAndYouPage11ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PreciousStonesAndYouPage11ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PreciousStonesAndYouPage11ButtonMessage message, final IPayloadContext context) {
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

			OpenEssenceOfEnchantmentProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenEssenceOfEnchantmentProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			PreciousStonesPage12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			PreciousStonesPage10Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(PreciousStonesAndYouPage11ButtonMessage.TYPE, PreciousStonesAndYouPage11ButtonMessage.STREAM_CODEC, PreciousStonesAndYouPage11ButtonMessage::handleData);
	}
}