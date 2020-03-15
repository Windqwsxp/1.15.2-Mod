package com.windqwsxp.expandedmod.fluid;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.init.BlockInit;
import com.windqwsxp.expandedmod.init.FluidInit;
import com.windqwsxp.expandedmod.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class FluidOil extends FlowingFluid {

	@Override
	public Fluid getFlowingFluid() {
		return FluidInit.FLOWING_OIL;
	}

	@Override
	public Fluid getStillFluid() {
		return FluidInit.OIL;
	}

	@Override
	protected boolean canSourcesMultiply() {
		return true;
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 8;
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 2 ;
	}

	@Override
	public Item getFilledBucket() {
		return ItemInit.oilbucket.get();
	}

	protected boolean func_215665_a(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidInit.Tags.OIL);
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 4;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {
		return BlockInit.oil.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}
	
	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == FluidInit.OIL || fluidIn == FluidInit.FLOWING_OIL;
	}
	
	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(ExpandedMod.MOD_ID, "blocks/oil_still"), new ResourceLocation(ExpandedMod.MOD_ID, "blocks/oil_flow"))
				.translationKey("block.expandedmod.oil")
				.build(this);
	}
	
	public static class Flowing extends FluidOil {

		@Override
		protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}
		
		@Override
		public boolean isSource(IFluidState state) {
			return false;
		}

		@Override
		public int getLevel(IFluidState state) {
			return state.get(FluidOil.LEVEL_1_8);
		}

		@Override
		protected boolean canDisplace(IFluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_,
				Fluid p_215665_4_, Direction p_215665_5_) {
			return false;
		}
		
	}
	
	public static class Source extends FluidOil {

		@Override
		public boolean isSource(IFluidState state) {
			return true;
		}

		@Override
		public int getLevel(IFluidState p_207192_1_) {
			return 8;
		}

		@Override
		protected boolean canDisplace(IFluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_,
				Fluid p_215665_4_, Direction p_215665_5_) {
			return false;
		}
		
	}
	
	
}





