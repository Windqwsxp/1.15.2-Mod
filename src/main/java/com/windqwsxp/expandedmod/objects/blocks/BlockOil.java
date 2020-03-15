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

public class BlockOil extends FlowingFluidBlock {

	public BlockOil() {
		super(() -> FluidInit.OIL, Block.Properties.create(Material.WATER).hardnessAndResistance(100.0F).noDrops());
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if(this.getFluid().isIn(FluidInit.Tags.OIL)) {
			if(entityIn instanceof LivingEntity) {
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 100, 1));
			}
			else entityIn.remove();
		}
		
	}
	
	
}


