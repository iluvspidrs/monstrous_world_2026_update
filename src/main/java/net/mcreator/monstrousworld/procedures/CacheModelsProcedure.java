package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.client.model.*;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class CacheModelsProcedure {
	@SubscribeEvent
	public static void afterModelRegistration(EntityRenderersEvent.AddLayers event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		MonstrousWorldModVariables.BatForm = new ModelBatForm(Minecraft.getInstance().getEntityModels().bakeLayer(ModelBatForm.LAYER_LOCATION));
		MonstrousWorldModVariables.WerewolfForm = new ModelWerewolf(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWerewolf.LAYER_LOCATION));
		MonstrousWorldModVariables.WebbedVictim1 = new ModelWrappedVictimEarly(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWrappedVictimEarly.LAYER_LOCATION));
		MonstrousWorldModVariables.WebbedVictim2 = new ModelWrappedVictimLate(Minecraft.getInstance().getEntityModels().bakeLayer(ModelWrappedVictimLate.LAYER_LOCATION));
		MonstrousWorldModVariables.PlayerHungerMode = new ModelOvertaken(Minecraft.getInstance().getEntityModels().bakeLayer(ModelOvertaken.LAYER_LOCATION));
		MonstrousWorldModVariables.PlayerDemonOffGround = new ModelDemonPlayerOffGround(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDemonPlayerOffGround.LAYER_LOCATION));
		MonstrousWorldModVariables.BalloonForm = new ModelDeadlyBalloon(Minecraft.getInstance().getEntityModels().bakeLayer(ModelDeadlyBalloon.LAYER_LOCATION));
		MonstrousWorldModVariables.DummyBow = new ModelNeutralSkeleton(Minecraft.getInstance().getEntityModels().bakeLayer(ModelNeutralSkeleton.LAYER_LOCATION));
	}
}