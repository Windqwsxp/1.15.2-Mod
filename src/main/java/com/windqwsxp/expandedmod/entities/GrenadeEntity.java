package com.windqwsxp.expandedmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GrenadeEntity extends ProjectileItemEntity {
	public GrenadeEntity(EntityType<? extends ProjectileItemEntity> p_i50154_1_, World p_i50154_2_) {
		super(p_i50154_1_, p_i50154_2_);
	}

	public GrenadeEntity(World worldIn, LivingEntity throwerIn) {
		super(EntityType.EGG, throwerIn, worldIn);
	}

	public GrenadeEntity(World worldIn, double x, double y, double z) {
		super(EntityType.EGG, x, y, z, worldIn);
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {

			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getPosX(),
						this.getPosY(), this.getPosZ(), ((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D);
			}
		}

	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			((EntityRayTraceResult) result).getEntity()
					.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
		}

		if (!this.world.isRemote) {
			if (this.rand.nextInt(1) == 0) {
				int i = 1;
				if (this.rand.nextInt(4) == 0) {
					i = 4;
				}

				for (int j = 0; j < i; ++j) {
					TNTEntity chickenentity = EntityType.TNT.create(this.world);
					chickenentity.setLocationAndAngles(this.getPosXWidth(1), this.getPosYHeight(-5.5), this.getPosZWidth(0),
							this.rotationYaw, 0.0F);
					this.world.addEntity(chickenentity);
				}
			}

			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}

	}

	protected Item getDefaultItem() {
		return Items.EGG;
	}
}

