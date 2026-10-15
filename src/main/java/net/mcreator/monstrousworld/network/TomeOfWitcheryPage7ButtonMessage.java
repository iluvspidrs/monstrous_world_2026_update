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

import net.mcreator.monstrousworld.procedures.OpenTomeOfWitcheryPage8Procedure;
import net.mcreator.monstrousworld.procedures.OpenTomeOfWitcheryPage6Procedure;
import net.mcreator.monstrousworld.procedures.OpenMagicalTomeExampleProcedure;
import net.mcreator.monstrousworld.procedures.OpenIncantationBookProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record TomeOfWitcheryPage7ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TomeOfWitcheryPage7ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "tome_of_witchery_page_7_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TomeOfWitcheryPage7ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TomeOfWitcheryPage7ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TomeOfWitcheryPage7ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TomeOfWitcheryPage7ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TomeOfWitcheryPage7ButtonMessage message, final IPayloadContext context) {
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

			OpenIncantationBookProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenMagicalTomeExampleProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenTomeOfWitcheryPage6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenTomeOfWitcheryPage8Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(TomeOfWitcheryPage7ButtonMessage.TYPE, TomeOfWitcheryPage7ButtonMessage.STREAM_CODEC, TomeOfWitcheryPage7ButtonMessage::handleData);
	}
}