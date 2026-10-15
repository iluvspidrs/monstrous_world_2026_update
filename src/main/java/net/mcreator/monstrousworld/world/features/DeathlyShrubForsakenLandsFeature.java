package net.mcreator.monstrousworld.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.monstrousworld.procedures.GrassyStructurePlacementConditionProcedure;

public class DeathlyShrubForsakenLandsFeature extends TreeFeature {
	public DeathlyShrubForsakenLandsFeature() {
		super(TreeConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!GrassyStructurePlacementConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}