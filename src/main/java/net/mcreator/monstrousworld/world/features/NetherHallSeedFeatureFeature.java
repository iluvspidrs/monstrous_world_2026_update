package net.mcreator.monstrousworld.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.monstrousworld.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.monstrousworld.procedures.NetherHallSeedFeatureAdditionalGenerationConditionProcedure;

public class NetherHallSeedFeatureFeature extends StructureFeature {
	public NetherHallSeedFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!NetherHallSeedFeatureAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}