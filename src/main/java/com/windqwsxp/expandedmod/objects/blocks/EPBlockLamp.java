package com.windqwsxp.expandedmod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EPBlockLamp extends DirectionalBlock {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	
	public static int i = 0;
	public static final int lightV = i;
	
	
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6, 10, 10, 10, 15, 11),
			Block.makeCuboidShape(5, 0, 5, 11, 1, 11), Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
			Block.makeCuboidShape(4.7, 1, 4.7, 11.3, 5, 11.299999999999999),
			Block.makeCuboidShape(7, 5.400000000000002, 7, 9, 6.400000000000002, 9),
			Block.makeCuboidShape(6.499999999999998, 6.400000000000002, 6.499999999999998, 9.499999999999998,
					9.700000000000005, 9.499999999999998),
			Block.makeCuboidShape(5.299999999999999, 6, 7.5, 5.800000000000001, 10, 8.5),
			Block.makeCuboidShape(10.3, 6, 7.5, 10.800000000000002, 10, 8.5),
			Block.makeCuboidShape(5, 15, 5, 11, 15.399999999999995, 11), Block.makeCuboidShape(10, 10, 5, 11, 15, 11),
			Block.makeCuboidShape(5, 10, 5, 6, 15, 11), Block.makeCuboidShape(6, 10, 5, 10, 15, 6)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(10, 10, 6, 11, 15, 10),
			Block.makeCuboidShape(5, 0, 5, 11, 1, 11), Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
			Block.makeCuboidShape(4.699999999999999, 1, 4.699999999999999, 11.299999999999999, 5, 11.3),
			Block.makeCuboidShape(7, 5.400000000000002, 7, 9, 6.400000000000002, 9),
			Block.makeCuboidShape(6.499999999999998, 6.400000000000002, 6.500000000000002, 9.499999999999998,
					9.700000000000005, 9.500000000000002),
			Block.makeCuboidShape(7.5, 6, 10.2, 8.5, 10, 10.700000000000001),
			Block.makeCuboidShape(7.5, 6, 5.1999999999999975, 8.5, 10, 5.699999999999999),
			Block.makeCuboidShape(5, 15, 5, 11, 15.399999999999995, 11), Block.makeCuboidShape(5, 10, 5, 11, 15, 6),
			Block.makeCuboidShape(5, 10, 10, 11, 15, 11), Block.makeCuboidShape(5, 10, 6, 6, 15, 10))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(6, 10, 5, 10, 15, 6),
			Block.makeCuboidShape(5, 0, 5, 11, 1, 11), Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
			Block.makeCuboidShape(4.699999999999999, 1, 4.700000000000001, 11.3, 5, 11.3),
			Block.makeCuboidShape(7, 5.400000000000002, 7, 9, 6.400000000000002, 9),
			Block.makeCuboidShape(6.500000000000002, 6.400000000000002, 6.500000000000002, 9.500000000000002,
					9.700000000000005, 9.500000000000002),
			Block.makeCuboidShape(10.2, 6, 7.5, 10.700000000000001, 10, 8.5),
			Block.makeCuboidShape(5.1999999999999975, 6, 7.5, 5.699999999999999, 10, 8.5),
			Block.makeCuboidShape(5, 15, 5, 11, 15.399999999999995, 11), Block.makeCuboidShape(5, 10, 5, 6, 15, 11),
			Block.makeCuboidShape(10, 10, 5, 11, 15, 11), Block.makeCuboidShape(6, 10, 10, 10, 15, 11))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(5, 10, 6, 6, 15, 10),
			Block.makeCuboidShape(5, 0, 5, 11, 1, 11), Block.makeCuboidShape(5, 5, 5, 11, 6, 11),
			Block.makeCuboidShape(4.700000000000001, 1, 4.699999999999999, 11.3, 5, 11.3),
			Block.makeCuboidShape(7, 5.400000000000002, 7, 9, 6.400000000000002, 9),
			Block.makeCuboidShape(6.500000000000002, 6.400000000000002, 6.499999999999998, 9.500000000000002,
					9.700000000000005, 9.499999999999998),
			Block.makeCuboidShape(7.5, 6, 5.299999999999999, 8.5, 10, 5.800000000000001),
			Block.makeCuboidShape(7.5, 6, 10.3, 8.5, 10, 10.800000000000002),
			Block.makeCuboidShape(5, 15, 5, 11, 15.399999999999995, 11), Block.makeCuboidShape(5, 10, 10, 11, 15, 11),
			Block.makeCuboidShape(5, 10, 5, 11, 15, 6), Block.makeCuboidShape(10, 10, 6, 11, 15, 10))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public EPBlockLamp(Properties properties) {
		super(properties);
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

	@SuppressWarnings("unused")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		if (!worldIn.isRemote) {
			ServerWorld serverWorld = (ServerWorld) worldIn;
			worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0f);
			
		}
		
					
		return ActionResultType.SUCCESS;
	}
	
	
			

	
	//public ActionResultType onRedstoneActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			//Hand handIn, BlockRayTraceResult result) {
		//if (!worldIn.isRemote) {
			//worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true, null);

		//}
	//	return ActionResultType.SUCCESS;

	//}
	
}



