package com.windqwsxp.expandedmod.init;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.entities.SnakeEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public final class EntityInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ExpandedMod.MOD_ID);

	public static final String SNAKE_NAME = "snake";
	public static final RegistryObject<EntityType<SnakeEntity>> SNAKE = ENTITY_TYPES.register(SNAKE_NAME, () ->
			EntityType.Builder.<SnakeEntity>create(SnakeEntity::new, EntityClassification.CREATURE)
					.size(EntityType.SILVERFISH.getWidth(), EntityType.SILVERFISH.getHeight())
					.build(new ResourceLocation(ExpandedMod.MOD_ID, SNAKE_NAME).toString())
	);

}