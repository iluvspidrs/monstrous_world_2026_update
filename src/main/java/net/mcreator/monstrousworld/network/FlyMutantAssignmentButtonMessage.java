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

import net.mcreator.monstrousworld.procedures.FlyAssignmentButtonPressedProcedure;
import net.mcreator.monstrousworld.procedures.FlyAssignmentButtonPressed2Procedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record FlyMutantAssignmentButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<FlyMutantAssignmentButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "fly_mutant_assignment_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlyMutantAssignmentButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FlyMutantAssignmentButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FlyMutantAssignmentButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FlyMutantAssignmentButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FlyMutantAssignmentButtonMessage message, final IPayloadContext context) {
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

			FlyAssignmentButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			FlyAssignmentButtonPressed2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(FlyMutantAssignmentButtonMessage.TYPE, FlyMutantAssignmentButtonMessage.STREAM_CODEC, FlyMutantAssignmentButtonMessage::handleData);
	}
}