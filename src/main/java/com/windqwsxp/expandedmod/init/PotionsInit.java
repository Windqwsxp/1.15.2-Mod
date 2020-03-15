package com.windqwsxp.expandedmod.init;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.windqwsxp.expandedmod.ExpandedMod;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExpandedMod.MOD_ID)
public class PotionsInit {
	 
	public static final Potion MIDASTOUCH = null;
	public static final Potion LONG_MIDASTOUCH = null;
	
	private static Method brewing;
	
	@Mod.EventBusSubscriber(modid = ExpandedMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerPotion(final RegistryEvent.Register<Potion> event) {
			final Potion[] potions = {
					new Potion(new EffectInstance(EffectInit.MIDASTOUCH, 2400)).setRegistryName("midastouch"),
					new Potion(new EffectInstance(EffectInit.MIDASTOUCH, 3600)).setRegistryName("long_midastouch"),					
			};
			event.getRegistry().registerAll(potions);
		}
	}
	
	private static void addMix(Potion base, Item ingredient, Potion result) {
		if(brewing == null) {
			brewing = ObfuscationReflectionHelper.findMethod(PotionBrewing.class, "addMix", Potion.class, Item.class, Potion.class);
			brewing.setAccessible(true);
		}
		try {
			brewing.invoke(null, base, ingredient, result);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void addRecipes() {
		addMix(Potions.AWKWARD, Items.ENCHANTED_GOLDEN_APPLE, MIDASTOUCH);
		addMix(MIDASTOUCH, Items.REDSTONE, LONG_MIDASTOUCH);
	}

}
