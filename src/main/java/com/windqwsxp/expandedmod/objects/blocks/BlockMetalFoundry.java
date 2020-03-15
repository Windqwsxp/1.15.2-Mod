package com.windqwsxp.expandedmod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockMetalFoundry extends DirectionalBlock {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(6, 3, 6, 10, 5.800000000000001, 10),
			Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
			Block.makeCuboidShape(1, 1, 1, 15, 2, 15),
			Block.makeCuboidShape(2, 14, 1.0000000000000036, 6, 15, 14),
			Block.makeCuboidShape(10, 14, 1.0000000000000036, 14, 15, 14),
			Block.makeCuboidShape(6, 14, 1.0000000000000036, 10, 15, 6),
			Block.makeCuboidShape(6, 14, 10.000000000000004, 10, 15, 14),
			Block.makeCuboidShape(6, 14, 6.0000000000000036, 7, 20, 10),
			Block.makeCuboidShape(5, 1, 6.0000000000000036, 6, 8.799999999999994, 10),
			Block.makeCuboidShape(9, 14, 6.0000000000000036, 10, 20, 10),
			Block.makeCuboidShape(10, 1, 6.0000000000000036, 11, 8.799999999999994, 10),
			Block.makeCuboidShape(7, 14, 6.0000000000000036, 9, 20, 7),
			Block.makeCuboidShape(5, 1, 5.0000000000000036, 11, 8.799999999999994, 6),
			Block.makeCuboidShape(7, 14, 9.000000000000004, 9, 20, 10),
			Block.makeCuboidShape(5, 1, 10.000000000000004, 11, 8.799999999999994, 11),
			Block.makeCuboidShape(1, 2, 14, 15, 15, 15),
			Block.makeCuboidShape(2, 5, 1, 14, 12, 2),
			Block.makeCuboidShape(1, 2, 1, 2, 15, 14),
			Block.makeCuboidShape(14, 2, 1, 15, 15, 14),
			Block.makeCuboidShape(2, 2, 1, 14, 5, 2),
			Block.makeCuboidShape(2, 12, 1, 14, 14, 2),
			Block.makeCuboidShape(1.5000000000000004, 1.4999999999999996, 0.4999999999999999, 2.5000000000000004, 14.499999999999996, 1),
			Block.makeCuboidShape(3, 2, 3, 13, 3, 13),
			Block.makeCuboidShape(4, 4.200000000000001, 4, 12, 5.700000000000001, 12),
			Block.makeCuboidShape(3, 3, 3, 4, 9, 13),
			Block.makeCuboidShape(12, 3, 3, 13, 9, 13),
			Block.makeCuboidShape(4, 3, 3, 12, 9, 4),
			Block.makeCuboidShape(4, 3, 12, 12, 9, 13),
			Block.makeCuboidShape(5, 20, 5, 7, 21, 11),
			Block.makeCuboidShape(9, 20, 5, 11, 21, 11),
			Block.makeCuboidShape(7, 20, 5, 9, 21, 7),
			Block.makeCuboidShape(7, 20, 9, 9, 21, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
			
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(6, 3, 6, 10, 5.800000000000001, 10),
			Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
			Block.makeCuboidShape(1, 1, 1, 15, 2, 15),
			Block.makeCuboidShape(1.0000000000000036, 14, 10, 14, 15, 14),
			Block.makeCuboidShape(1.0000000000000036, 14, 2, 14, 15, 6),
			Block.makeCuboidShape(1.0000000000000036, 14, 6, 6, 15, 10),
			Block.makeCuboidShape(10.000000000000004, 14, 6, 14, 15, 10),
			Block.makeCuboidShape(6.0000000000000036, 14, 9, 10, 20, 10),
			Block.makeCuboidShape(6.0000000000000036, 1, 10, 10, 8.799999999999994, 11),
			Block.makeCuboidShape(6.0000000000000036, 14, 6, 10, 20, 7),
			Block.makeCuboidShape(6.0000000000000036, 1, 5, 10, 8.799999999999994, 6),
			Block.makeCuboidShape(6.0000000000000036, 14, 7, 7, 20, 9),
			Block.makeCuboidShape(5.0000000000000036, 1, 5, 6, 8.799999999999994, 11),
			Block.makeCuboidShape(9.000000000000004, 14, 7, 10, 20, 9),
			Block.makeCuboidShape(10.000000000000004, 1, 5, 11, 8.799999999999994, 11),
			Block.makeCuboidShape(14, 2, 1, 15, 15, 15),
			Block.makeCuboidShape(1, 5, 2, 2, 12, 14),
			Block.makeCuboidShape(1, 2, 14, 14, 15, 15),
			Block.makeCuboidShape(1, 2, 1, 14, 15, 2),
			Block.makeCuboidShape(1, 2, 2, 2, 5, 14),
			Block.makeCuboidShape(1, 12, 2, 2, 14, 14),
			Block.makeCuboidShape(0.5, 1.4999999999999996, 13.5, 1, 14.499999999999996, 14.5),
			Block.makeCuboidShape(3, 2, 3, 13, 3, 13),
			Block.makeCuboidShape(4, 4.200000000000001, 4, 12, 5.700000000000001, 12),
			Block.makeCuboidShape(3, 3, 12, 13, 9, 13),
			Block.makeCuboidShape(3, 3, 3, 13, 9, 4),
			Block.makeCuboidShape(3, 3, 4, 4, 9, 12),
			Block.makeCuboidShape(12, 3, 4, 13, 9, 12),
			Block.makeCuboidShape(5, 20, 9, 11, 21, 11),
			Block.makeCuboidShape(5, 20, 5, 11, 21, 7),
			Block.makeCuboidShape(5, 20, 7, 7, 21, 9),
			Block.makeCuboidShape(9, 20, 7, 11, 21, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();	
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(6, 3, 6, 10, 5.800000000000001, 10),
			Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
			Block.makeCuboidShape(1, 1, 1, 15, 2, 15),
			Block.makeCuboidShape(10, 14, 2, 14, 15, 14.999999999999996),
			Block.makeCuboidShape(2, 14, 2, 6, 15, 14.999999999999996),
			Block.makeCuboidShape(6, 14, 10, 10, 15, 14.999999999999996),
			Block.makeCuboidShape(6, 14, 2, 10, 15, 5.9999999999999964),
			Block.makeCuboidShape(9, 14, 6, 10, 20, 9.999999999999996),
			Block.makeCuboidShape(10, 1, 6, 11, 8.799999999999994, 9.999999999999996),
			Block.makeCuboidShape(6, 14, 6, 7, 20, 9.999999999999996),
			Block.makeCuboidShape(5, 1, 6, 6, 8.799999999999994, 9.999999999999996),
			Block.makeCuboidShape(7, 14, 9, 9, 20, 9.999999999999996),
			Block.makeCuboidShape(5, 1, 10, 11, 8.799999999999994, 10.999999999999996),
			Block.makeCuboidShape(7, 14, 6, 9, 20, 6.9999999999999964),
			Block.makeCuboidShape(5, 1, 5, 11, 8.799999999999994, 5.9999999999999964),
			Block.makeCuboidShape(1, 2, 1, 15, 15, 2),
			Block.makeCuboidShape(2, 5, 14, 14, 12, 15),
			Block.makeCuboidShape(14, 2, 2, 15, 15, 15),
			Block.makeCuboidShape(1, 2, 2, 2, 15, 15),
			Block.makeCuboidShape(2, 2, 14, 14, 5, 15),
			Block.makeCuboidShape(2, 12, 14, 14, 14, 15),
			Block.makeCuboidShape(13.5, 1.4999999999999996, 15, 14.5, 14.499999999999996, 15.5),
			Block.makeCuboidShape(3, 2, 3, 13, 3, 13),
			Block.makeCuboidShape(4, 4.200000000000001, 4, 12, 5.700000000000001, 12),
			Block.makeCuboidShape(12, 3, 3, 13, 9, 13),
			Block.makeCuboidShape(3, 3, 3, 4, 9, 13),
			Block.makeCuboidShape(4, 3, 12, 12, 9, 13),
			Block.makeCuboidShape(4, 3, 3, 12, 9, 4),
			Block.makeCuboidShape(9, 20, 5, 11, 21, 11),
			Block.makeCuboidShape(5, 20, 5, 7, 21, 11),
			Block.makeCuboidShape(7, 20, 9, 9, 21, 11),
			Block.makeCuboidShape(7, 20, 5, 9, 21, 7)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(6, 3, 6, 10, 5.800000000000001, 10),
			Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
			Block.makeCuboidShape(1, 1, 1, 15, 2, 15),
			Block.makeCuboidShape(2, 14, 2, 14.999999999999996, 15, 6),
			Block.makeCuboidShape(2, 14, 10, 14.999999999999996, 15, 14),
			Block.makeCuboidShape(10, 14, 6, 14.999999999999996, 15, 10),
			Block.makeCuboidShape(2, 14, 6, 5.9999999999999964, 15, 10),
			Block.makeCuboidShape(6, 14, 6, 9.999999999999996, 20, 7),
			Block.makeCuboidShape(6, 1, 5, 9.999999999999996, 8.799999999999994, 6),
			Block.makeCuboidShape(6, 14, 9, 9.999999999999996, 20, 10),
			Block.makeCuboidShape(6, 1, 10, 9.999999999999996, 8.799999999999994, 11),
			Block.makeCuboidShape(9, 14, 7, 9.999999999999996, 20, 9),
			Block.makeCuboidShape(10, 1, 5, 10.999999999999996, 8.799999999999994, 11),
			Block.makeCuboidShape(6, 14, 7, 6.9999999999999964, 20, 9),
			Block.makeCuboidShape(5, 1, 5, 5.9999999999999964, 8.799999999999994, 11),
			Block.makeCuboidShape(1, 2, 1, 2, 15, 15),
			Block.makeCuboidShape(14, 5, 2, 15, 12, 14),
			Block.makeCuboidShape(2, 2, 1, 15, 15, 2),
			Block.makeCuboidShape(2, 2, 14, 15, 15, 15),
			Block.makeCuboidShape(14, 2, 2, 15, 5, 14),
			Block.makeCuboidShape(14, 12, 2, 15, 14, 14),
			Block.makeCuboidShape(15, 1.4999999999999996, 1.5, 15.5, 14.499999999999996, 2.5),
			Block.makeCuboidShape(3, 2, 3, 13, 3, 13),
			Block.makeCuboidShape(4, 4.200000000000001, 4, 12, 5.700000000000001, 12),
			Block.makeCuboidShape(3, 3, 3, 13, 9, 4),
			Block.makeCuboidShape(3, 3, 12, 13, 9, 13),
			Block.makeCuboidShape(12, 3, 4, 13, 9, 12),
			Block.makeCuboidShape(3, 3, 4, 4, 9, 12),
			Block.makeCuboidShape(5, 20, 5, 11, 21, 7),
			Block.makeCuboidShape(5, 20, 9, 11, 21, 11),
			Block.makeCuboidShape(9, 20, 7, 11, 21, 9),
			Block.makeCuboidShape(5, 20, 7, 7, 21, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public BlockMetalFoundry(Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	
	}
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
}