package com.windqwsxp.expandedmod.init;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.potion.effect.ModEffect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExpandedMod.MOD_ID)
public class EffectInit {
	
	public static final ModEffect MIDASTOUCH = null;
	
	@Mod.EventBusSubscriber(modid = ExpandedMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerEffect(final RegistryEvent.Register<Effect> event) {
			final Effect[] effects = {
					new ModEffect(EffectType.BENEFICIAL, 0xebe657).setRegistryName("midastouch")
			};
			event.getRegistry().registerAll(effects);
		}
	}

}
