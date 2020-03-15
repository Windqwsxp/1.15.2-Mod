package com.windqwsxp.expandedmod.init;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.fluid.FluidMud;
import com.windqwsxp.expandedmod.fluid.FluidOil;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExpandedMod.MOD_ID)
public class FluidInit {

	public static final FluidMud.Flowing FLOWING_MUD = null;
	public static final FluidMud.Source MUD = null;
	
	public static final FluidOil.Flowing FLOWING_OIL = null;
	public static final FluidOil.Source OIL = null;
	
	public static class Tags {
		public static final Tag<Fluid> MUD = new FluidTags.Wrapper(new ResourceLocation(ExpandedMod.MOD_ID, "mud"));
		public static final Tag<Fluid> OIL = new FluidTags.Wrapper(new ResourceLocation(ExpandedMod.MOD_ID, "oil"));

	}
	
	@Mod.EventBusSubscriber(modid = ExpandedMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
			final Fluid[] fluids = {
					new FluidMud.Flowing().setRegistryName(ExpandedMod.MOD_ID, "flowing_mud"),
					new FluidMud.Source().setRegistryName(ExpandedMod.MOD_ID, "mud"),
					new FluidOil.Flowing().setRegistryName(ExpandedMod.MOD_ID, "flowing_oil"),
					new FluidOil.Source().setRegistryName(ExpandedMod.MOD_ID, "oil")
			};
			
			event.getRegistry().registerAll(fluids);
		}
	}
}