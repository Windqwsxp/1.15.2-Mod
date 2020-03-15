package com.windqwsxp.expandedmod.init;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.ExpandedMod.ExpandedModItemGroup;
import com.windqwsxp.expandedmod.ItemTier.CopperArmor;
import com.windqwsxp.expandedmod.ItemTier.CopperItemTier;
import com.windqwsxp.expandedmod.ItemTier.TitaniumItemTier;
import com.windqwsxp.expandedmod.objects.items.GrenadeItem;
import com.windqwsxp.expandedmod.objects.items.RockItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ExpandedMod.MOD_ID);

	public static final RegistryObject<Item> tiningot = ITEMS.register("tiningot", () -> new Item(new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> nickelingot = ITEMS.register("nickelingot", () -> new Item(new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> titaniumingot = ITEMS.register("titaniumingot", () -> new Item(new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperingot = ITEMS.register("copperingot", () -> new Item(new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> grenade = ITEMS.register("grenade", () -> new GrenadeItem(new Item.Properties().rarity(Rarity.EPIC).group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> corn_food = ITEMS.register("corncrop", () -> new BlockItem(BlockInit.corncrop.get(), new Item.Properties().group(ExpandedModItemGroup.instance).food(FoodInit.cornk)));
	public static final RegistryObject<Item> blueberry = ITEMS.register("blueberry", () -> new BlockItem(BlockInit.bluebush.get(), new Item.Properties().group(ExpandedModItemGroup.instance).food(FoodInit.blueb)));
	public static final RegistryObject<Item> rock = ITEMS.register("rock", () -> new RockItem(new Item.Properties().group(ExpandedModItemGroup.instance)));				
	public static final RegistryObject<Item> mudbucket = ITEMS.register("mudbucket", () -> new BucketItem(() -> FluidInit.MUD, new Item.Properties().group(ExpandedModItemGroup.instance).maxStackSize(1)));	
	public static final RegistryObject<Item> oilbucket = ITEMS.register("oilbucket", () -> new BucketItem(() -> FluidInit.OIL, new Item.Properties().group(ExpandedModItemGroup.instance).maxStackSize(1)));	

	//Tools
	public static final RegistryObject<Item> coppersword = ITEMS.register("coppersword", () -> new SwordItem(CopperItemTier.COPPER, 2, -3.0F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperpickaxe = ITEMS.register("copperpickaxe", () -> new PickaxeItem(CopperItemTier.COPPER, 0, -3.1F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperaxe = ITEMS.register("copperaxe", () -> new AxeItem(CopperItemTier.COPPER, 1, -3.1F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> coppershovel = ITEMS.register("coppershovel", () -> new ShovelItem(CopperItemTier.COPPER, -1, -3.0F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperhoe = ITEMS.register("copperhoe", () -> new HoeItem(CopperItemTier.COPPER, -3.1F, new Item.Properties().group(ExpandedModItemGroup.instance)));

	public static final RegistryObject<Item> titiuamsword = ITEMS.register("titaniumsword", () -> new SwordItem(TitaniumItemTier.TITANIUM, 3, -2.9F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> titaniumpickaxe = ITEMS.register("titaniumpickaxe", () -> new PickaxeItem(TitaniumItemTier.TITANIUM, 1, -2.9F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> titaniumaxe = ITEMS.register("titaniumaxe", () -> new AxeItem(TitaniumItemTier.TITANIUM, 2, -2.8F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> titaniumshovel = ITEMS.register("titaniumshovel", () -> new ShovelItem(TitaniumItemTier.TITANIUM, 1, -2.9F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> titaniumhoe = ITEMS.register("titaniumhoe", () -> new HoeItem(TitaniumItemTier.TITANIUM, -3.1F, new Item.Properties().group(ExpandedModItemGroup.instance)));
	
	//Armor
	public static final RegistryObject<Item> copperhelmet = ITEMS.register("copperhelmet", () -> new ArmorItem(CopperArmor.COPPERARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperchestplate = ITEMS.register("copperchestplate", () -> new ArmorItem(CopperArmor.COPPERARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperleggings = ITEMS.register("copperleggings", () -> new ArmorItem(CopperArmor.COPPERARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ExpandedModItemGroup.instance)));
	public static final RegistryObject<Item> copperboots = ITEMS.register("copperboots", () -> new ArmorItem(CopperArmor.COPPERARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ExpandedModItemGroup.instance)));
	
	}


