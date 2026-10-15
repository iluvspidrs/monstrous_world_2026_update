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
public record RecipeHelperButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<RecipeHelperButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "recipe_helper_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, RecipeHelperButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RecipeHelperButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new RecipeHelperButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RecipeHelperButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final RecipeHelperButtonMessage message, final IPayloadContext context) {
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

			ButtonSlot0RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ButtonSlot1RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ButtonSlot1RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ButtonSlot2RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ButtonSlot3RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ButtonSlot4RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ButtonSlot5RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ButtonSlot6RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ButtonSlot7RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ButtonSlot8RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			GUIandInfoBackButtonProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(RecipeHelperButtonMessage.TYPE, RecipeHelperButtonMessage.STREAM_CODEC, RecipeHelperButtonMessage::handleData);
	}
}