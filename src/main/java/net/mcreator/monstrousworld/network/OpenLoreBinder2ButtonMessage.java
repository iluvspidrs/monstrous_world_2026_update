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
public record OpenLoreBinder2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OpenLoreBinder2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "open_lore_binder_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenLoreBinder2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenLoreBinder2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenLoreBinder2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenLoreBinder2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenLoreBinder2ButtonMessage message, final IPayloadContext context) {
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

			BinderOpenTomeOfWitcheryProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BinderOpenMagicalPlantsRightclickedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BinderOpenBookishRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BinderOpenChickenifyCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			BinderOpenExplosionRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BinderOpenFlightCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BinderOpenFrogifyRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BinderOpenVampireCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BinderOpenMidasRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			BinderOpenObstructionRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BinderOpenParalysisRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			BinderOpenPumpkinCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			BinderOpenSinkingRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			BinderOpenSpiritRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			BinderOpenVanishingCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			BinderOpenWerewolfCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			BinderOpenUndeathCureRecipeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			BinderOpenGlowingPumpkinSaplingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			AddLoreToBinderPage2Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(OpenLoreBinder2ButtonMessage.TYPE, OpenLoreBinder2ButtonMessage.STREAM_CODEC, OpenLoreBinder2ButtonMessage::handleData);
	}
}