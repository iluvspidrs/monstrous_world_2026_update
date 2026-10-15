package net.mcreator.monstrousworld.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModFluids;
import net.mcreator.monstrousworld.init.MonstrousWorldModFluidTypes;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public abstract class AcidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> MonstrousWorldModFluidTypes.ACID_TYPE.get(), () -> MonstrousWorldModFluids.ACID.get(), () -> MonstrousWorldModFluids.FLOWING_ACID.get())
			.explosionResistance(100f).bucket(() -> MonstrousWorldModItems.ACID_BUCKET.get()).block(() -> (LiquidBlock) MonstrousWorldModBlocks.ACID.get());

	private AcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.ITEM_SLIME;
	}

	public static class Source extends AcidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AcidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}