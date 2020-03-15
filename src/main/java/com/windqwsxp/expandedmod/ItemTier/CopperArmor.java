package com.windqwsxp.expandedmod.ItemTier;

import java.util.function.Supplier;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum CopperArmor implements IArmorMaterial {
	// Max damage factor, boots leggings chestplate helmet, enchantability, Sound,
	// Toughness,
	COPPERARMOR(ExpandedMod.MOD_ID+":copper", 4, new int[]{1,4,5,2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F, ()->

	{			
		return Ingredient.fromItems(ItemInit.copperingot.get());
});

	// Durability
private static final int[] MAX_DAMAGE_ARRAY = new int[] {5, 4, 7, 4};
private final String name;
private final int maxDamageFactor;
private final int[] damageReductionAmountArray;
private final int enchantability;
private final SoundEvent soundEvent;
private final float toughness;
private final LazyValue<Ingredient> repairMaterial;

private CopperArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
	
	this.name = nameIn;
	this.maxDamageFactor = maxDamageFactorIn;
	this.damageReductionAmountArray = damageReductionAmountIn;
	this.enchantability = enchantabilityIn;
	this.soundEvent = soundEventIn;
	this.toughness = toughnessIn;
	this.repairMaterial = new LazyValue<>(repairMaterialIn);
	
	}

@Override
public int getDurability(EquipmentSlotType slotIn) {
	return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
}

@Override
public int getDamageReductionAmount(EquipmentSlotType slotIn) {
	return this.damageReductionAmountArray[slotIn.getIndex()];
}

@Override
public int getEnchantability() {
	return this.enchantability;
}

@Override
public SoundEvent getSoundEvent() {
	return this.soundEvent;
}

@Override
public Ingredient getRepairMaterial() {
	return this.repairMaterial.getValue();
}

@OnlyIn(Dist.CLIENT)
@Override
public String getName() {
	return this.name;
}

@Override
public float getToughness() {
	return this.toughness;
	}


}