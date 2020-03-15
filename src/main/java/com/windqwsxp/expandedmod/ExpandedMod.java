package com.windqwsxp.expandedmod;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.windqwsxp.expandedmod.init.BlockInit;
import com.windqwsxp.expandedmod.init.ItemInit;
import com.windqwsxp.expandedmod.init.PotionsInit;
import com.windqwsxp.expandedmod.world.DrylandsWorldType;
import com.windqwsxp.expandedmod.world.biome.features.ExpandedModBiomeFeatures;
import com.windqwsxp.expandedmod.world.gen.ExpandedModOreGen;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("expandedmod")
@Mod.EventBusSubscriber(modid = ExpandedMod.MOD_ID, bus = Bus.MOD)

public class ExpandedMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "expandedmod";
    public static ExpandedMod instance;
    public static final WorldType DRYLANDS = new DrylandsWorldType();
 
    public ExpandedMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addListener(this::loadCompleteEvent);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
 
    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        ExpandedModBiomeFeatures.addBerryBushes(Biomes.PLAINS);
        ExpandedModBiomeFeatures.addBerryBushes(Biomes.DEFAULT);
        ExpandedModBiomeFeatures.addBerryBushes(Biomes.FOREST);
        ExpandedModBiomeFeatures.addBerryBushes(Biomes.SUNFLOWER_PLAINS);
        PotionsInit.addRecipes();
 
    }
   
    @SubscribeEvent
   
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
 
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ExpandedModItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
 
        LOGGER.debug("Registered BlockItems!");
    }
   
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.corncrop.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.bluebush.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.metalfoundry.get(), RenderType.getCutout());
 
    }
 
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
 
    }
 
    @SubscribeEvent
    public void loadCompleteEvent(FMLLoadCompleteEvent event) {
        ExpandedModOreGen.generateOre();
    }
   
    public static class ExpandedModItemGroup extends ItemGroup {
        public static final ItemGroup instance = new ExpandedModItemGroup(ItemGroup.GROUPS.length, "expandedmodtab");
 
        private ExpandedModItemGroup(int index, String label) {
            super(index, label);
        }
 
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.titaniumingot.get());
        }
    }

} 