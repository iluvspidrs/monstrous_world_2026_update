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

import net.mcreator.monstrousworld.procedures.GUIandInfoBackButtonProcedure;
import net.mcreator.monstrousworld.procedures.ButtonSlot2RHCraftingProcedure;
import net.mcreator.monstrousworld.procedures.ButtonSlot1RHCraftingProcedure;
import net.mcreator.monstrousworld.procedures.ButtonSlot0RHCraftingProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

@EventBusSubscriber
public record ConfectioneryTableRecipeHelperButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ConfectioneryTableRecipeHelperButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "confectionery_table_recipe_helper_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ConfectioneryTableRecipeHelperButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ConfectioneryTableRecipeHelperButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ConfectioneryTableRecipeHelperButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ConfectioneryTableRecipeHelperButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ConfectioneryTableRecipeHelperButtonMessage message, final IPayloadContext context) {
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

			ButtonSlot2RHCraftingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUIandInfoBackButtonProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(ConfectioneryTableRecipeHelperButtonMessage.TYPE, ConfectioneryTableRecipeHelperButtonMessage.STREAM_CODEC, ConfectioneryTableRecipeHelperButtonMessage::handleData);
	}
}