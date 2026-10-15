package net.mcreator.monstrousworld.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.monstrousworld.init.MonstrousWorldModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements MonstrousWorldModBiomes.MonstrousWorldModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> monstrous_world_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.monstrous_world_dimensionTypeReference != null) {
			retval = MonstrousWorldModBiomes.adaptSurfaceRule(retval, this.monstrous_world_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setmonstrous_worldDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.monstrous_world_dimensionTypeReference = dimensionType;
	}
}