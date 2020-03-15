package com.windqwsxp.expandedmod.objects.items;

import java.util.List;

import com.windqwsxp.expandedmod.entities.GrenadeEntity;
import com.windqwsxp.expandedmod.util.helpers.KeyBoardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GrenadeItem extends Item {
   public GrenadeItem(Item.Properties builder) {
      super(builder);
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      if (!worldIn.isRemote) {
         GrenadeEntity eggentity = new GrenadeEntity(worldIn, playerIn);
         eggentity.setItem(itemstack);
         eggentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
         worldIn.addEntity(eggentity);
      }

      playerIn.addStat(Stats.ITEM_USED.get(this));
      if (!playerIn.abilities.isCreativeMode) {
         itemstack.shrink(1);
      }

      return ActionResult.resultSuccess(itemstack);
   }
   
   @Override
   public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
   {
	   if(KeyBoardHelper.isHoldingM()) {
		   tooltip.add(new StringTextComponent("\u00A74" + "This grenade works best"));
		   tooltip.add(new StringTextComponent("\u00A74" + "if pointed at the ground!"));
	   } else {
		   tooltip.add(new StringTextComponent("Hold M for more information!"));
		   
	   }
	   super.addInformation(stack, worldIn, tooltip, flagIn);
   }
}