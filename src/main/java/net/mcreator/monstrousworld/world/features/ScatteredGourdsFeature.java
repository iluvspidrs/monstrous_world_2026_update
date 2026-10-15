package net.mcreator.monstrousworld.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.monstrousworld.procedures.ScatteredGourdsAdditionalGenerationConditionProcedure;

public class ScatteredGourdsFeature extends VegetationPatchFeature {
	public ScatteredGourdsFeature() {
		super(VegetationPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<VegetationPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!ScatteredGourdsAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}