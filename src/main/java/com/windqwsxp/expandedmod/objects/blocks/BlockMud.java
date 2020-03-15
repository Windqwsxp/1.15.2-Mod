package com.windqwsxp.expandedmod.objects.blocks;

import com.windqwsxp.expandedmod.init.FluidInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMud extends FlowingFluidBlock {

	public BlockMud() {
		super(() -> FluidInit.MUD, Block.Properties.create(Material.WATER).hardnessAndResistance(100.0F).noDrops());
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if(this.getFluid().isIn(FluidInit.Tags.MUD)) {
			if(entityIn instanceof LivingEntity) {
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 1));
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 40, 1));

			}
			else entityIn.remove();
		}
		
	}
	
	
}


