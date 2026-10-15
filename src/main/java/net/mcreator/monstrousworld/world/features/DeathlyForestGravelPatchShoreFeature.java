package net.mcreator.monstrousworld.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.DiskFeature;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.monstrousworld.procedures.OddGravelGenerationConditionProcedure;

public class DeathlyForestGravelPatchShoreFeature extends DiskFeature {
	public DeathlyForestGravelPatchShoreFeature() {
		super(DiskConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!OddGravelGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}