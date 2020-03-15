package com.windqwsxp.expandedmod.client.render.entity;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.entities.SnakeEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.util.ResourceLocation;


public class SnakeRenderer extends MobRenderer<SnakeEntity, PigModel<SnakeEntity>> {

	private static final ResourceLocation WILD_BOAR_TEXTURE = new ResourceLocation(ExpandedMod.MOD_ID, "textures/entity/snake/snake.png");

	public SnakeRenderer(final EntityRendererManager manager) {
		super(manager, new PigModel<>(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(final SnakeEntity entity) {
		return WILD_BOAR_TEXTURE;
	}


}