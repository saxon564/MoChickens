package me.saxon564.mochickens.world.dimensions.chicken.teleporters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.saxon564.mochickens.MoChickens;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class ChickenTeleporter extends Teleporter {
	
	private final WorldServer worldServerInstance;
	private final Random random;
	private final LongHashMap destinationCoordinateCache = new LongHashMap();
	private final List destinationCoordinateKeys = new ArrayList();

	public ChickenTeleporter(WorldServer world) {
		super(world);
		
		this.worldServerInstance = world;
		this.random = new Random(world.getSeed());
	}
	
	public void placeInPortal(Entity entity, double x, double y, double z, float f) {
		if (this.worldServerInstance.provider.dimensionId != 1) {
			if (!this.placeInExistingPortal(entity, x, y, z, f)) {
				this.makePortal(entity);
				this.placeInExistingPortal(entity, x, y, z, f);
			}
		} else {
			int entityX = MathHelper.floor_double(entity.posX);
			int entityY = MathHelper.floor_double(entity.posY) - 1;
			int entityZ = MathHelper.floor_double(entity.posZ);
			byte b0 = 1;
			byte b1 = 0;
			
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++) {
					for (int k = -1; k < 3; k++) {
						int x2 = entityX + j*b0 + i*b1;
						int y2 = entityY + k;
						int z2 = entityZ + j*b1 + i*b0;
						boolean flag = k < 0;
						this.worldServerInstance.setBlock(x2, y2, z2, flag?MoChickens.blockFeatherBlock : Blocks.air);
					}
				}
			}
			
			entity.setLocationAndAngles((double)entityX, (double)entityY, (double)entityZ, entity.rotationYaw, 0.0F);
			entity.motionX = entity.motionY = entity.motionZ = 0;
		}
	}
	
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float f) {
		short short1 = 60;
        double d3 = -1.0D;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.floor_double(entity.posX);
        int i1 = MathHelper.floor_double(entity.posZ);
        long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
        boolean flag = true;
        double d7;
        int l3;

        if (this.destinationCoordinateCache.containsItem(j1))
        {
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
            d3 = 0.0D;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else
        {
            for (l3 = l - short1; l3 <= l + short1; ++l3)
            {
                double d4 = (double)l3 + 0.5D - entity.posX;

                for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1)
                {
                    double d5 = (double)l1 + 0.5D - entity.posZ;

                    for (int i2 = this.worldServerInstance.getActualHeight() - 1; i2 >= 0; --i2)
                    {
                        if (this.worldServerInstance.getBlock(l3, i2, l1) == MoChickens.blockFeatherPortal)
                        {
                            while (this.worldServerInstance.getBlock(l3, i2 - 1, l1) == MoChickens.blockFeatherPortal)
                            {
                                --i2;
                            }

                            d7 = (double)i2 + 0.5D - entity.posY;
                            double d8 = d4 * d4 + d7 * d7 + d5 * d5;

                            if (d3 < 0.0D || d8 < d3)
                            {
                                d3 = d8;
                                i = l3;
                                j = i2;
                                k = l1;
                            }
                        }
                    }
                }
            }
        }

        if (d3 >= 0.0D)
        {
            if (flag)
            {
                this.destinationCoordinateCache.add(j1, new Teleporter.PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(j1));
            }

            double d11 = (double)i + 0.5D;
            double d6 = (double)j + 0.5D;
            d7 = (double)k + 0.5D;
            int i4 = -1;

            if (this.worldServerInstance.getBlock(i - 1, j, k) == MoChickens.blockFeatherPortal)
            {
                i4 = 2;
            }

            if (this.worldServerInstance.getBlock(i + 1, j, k) == MoChickens.blockFeatherPortal)
            {
                i4 = 0;
            }

            if (this.worldServerInstance.getBlock(i, j, k - 1) == MoChickens.blockFeatherPortal)
            {
                i4 = 3;
            }

            if (this.worldServerInstance.getBlock(i, j, k + 1) == MoChickens.blockFeatherPortal)
            {
                i4 = 1;
            }

            int j2 = entity.getTeleportDirection();

            if (i4 > -1)
            {
                int k2 = Direction.rotateLeft[i4];
                int l2 = Direction.offsetX[i4];
                int i3 = Direction.offsetZ[i4];
                int j3 = Direction.offsetX[k2];
                int k3 = Direction.offsetZ[k2];
                boolean flag1 = !this.worldServerInstance.isAirBlock(i + l2 + j3, j, k + i3 + k3) || !this.worldServerInstance.isAirBlock(i + l2 + j3, j + 1, k + i3 + k3);
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + l2, j, k + i3) || !this.worldServerInstance.isAirBlock(i + l2, j + 1, k + i3);

                if (flag1 && flag2)
                {
                    i4 = Direction.rotateOpposite[i4];
                    k2 = Direction.rotateOpposite[k2];
                    l2 = Direction.offsetX[i4];
                    i3 = Direction.offsetZ[i4];
                    j3 = Direction.offsetX[k2];
                    k3 = Direction.offsetZ[k2];
                    l3 = i - j3;
                    d11 -= (double)j3;
                    int k1 = k - k3;
                    d7 -= (double)k3;
                    flag1 = !this.worldServerInstance.isAirBlock(l3 + l2 + j3, j, k1 + i3 + k3) || !this.worldServerInstance.isAirBlock(l3 + l2 + j3, j + 1, k1 + i3 + k3);
                    flag2 = !this.worldServerInstance.isAirBlock(l3 + l2, j, k1 + i3) || !this.worldServerInstance.isAirBlock(l3 + l2, j + 1, k1 + i3);
                }

                float f1 = 0.5F;
                float f2 = 0.5F;

                if (!flag1 && flag2)
                {
                    f1 = 1.0F;
                }
                else if (flag1 && !flag2)
                {
                    f1 = 0.0F;
                }
                else if (flag1 && flag2)
                {
                    f2 = 0.0F;
                }

                d11 += (double)((float)j3 * f1 + f2 * (float)l2);
                d7 += (double)((float)k3 * f1 + f2 * (float)i3);
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;
                float f6 = 0.0F;

                if (i4 == j2)
                {
                    f3 = 1.0F;
                    f4 = 1.0F;
                }
                else if (i4 == Direction.rotateOpposite[j2])
                {
                    f3 = -1.0F;
                    f4 = -1.0F;
                }
                else if (i4 == Direction.rotateRight[j2])
                {
                    f5 = 1.0F;
                    f6 = -1.0F;
                }
                else
                {
                    f5 = -1.0F;
                    f6 = 1.0F;
                }

                double d9 = entity.motionX;
                double d10 = entity.motionZ;
                entity.motionX = d9 * (double)f3 + d10 * (double)f6;
                entity.motionZ = d9 * (double)f5 + d10 * (double)f4;
                entity.rotationYaw = f - (float)(j2 * 90) + (float)(i4 * 90);
            }
            else
            {
                entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            }

            entity.setLocationAndAngles(d11, d6, d7, entity.rotationYaw, entity.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
	}
	
	public boolean makePortal(Entity entity) {
		byte b0 = 16;
		double d0 = -1.0D;
		int i = MathHelper.floor_double(entity.posX);
		int j = MathHelper.floor_double(entity.posY);
		int k = MathHelper.floor_double(entity.posZ);
		int l = i;
		int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;//x
		double d1; //x
		double d2;//z
		int j2;//z
        int k2;//y
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;//y
        int k4;;//x
		double d3;
		double d4;//z
		
		for (i2 = i-b0; i2 <= i+b0; i2++) {
			d1 = (double)i2+0.5D - entity.posX;
			for (j2 = k-b0; j2 <= k+b0; j2++) {
				d2 = (double)j2+0.5D - entity.posZ;
				label274:
				
				for (k2 = this.worldServerInstance.getActualHeight()-1; k2 >= 0; k2--) {
					if (this.worldServerInstance.isAirBlock(i2, k2, j2)) {
						while (j2 > 0 && this.worldServerInstance.isAirBlock(i2, k2-1, j2)) {
							k2--;
						}
						
						for (i3 = l1; i3 < l1+4; i3++) {
							l2 = 12%2;
							k3 = 1-l2;
							
							if (i3%4 >= 2) {
								l2 = -l2;
								k3 = -k3;
							}
							
							for (j3 = 0; j3 < 3; j3++) {
								for (i4 = 0; i4 < 4; i4++) {
									for (l3 = -1; l3 < 4; l3++) {
										k4 = i2 + (i4-1)*l2 + j2*k3;
										j4 = k2+l3;
										int l4 = j2 + (i4-1)*k3 - j3*l2;
										
										if (l3 < 0 && !this.worldServerInstance.getBlock(k4, j4, l4).getMaterial().isSolid() || l3 >= 0 && this.worldServerInstance.isAirBlock(k4, j4, l4)) {
											continue label274;
										}
									}
								}
							}
							
							d4 = (double)k2 + 0.5D - entity.posY;
							d3 = d1*d1 + d4*d4 + d2*d2;
							
							if (d0 < 0.0D || d3 < d0) {
								d0 = d3;
								l = i2;
								i1 = k2;
								j1 = j2;
								k1 = l2%4;
							}
						}
					}
				}
			}
		}
		
		if (d0 < 0.0D) {
			for (i2 = i-b0; i2 <= i+b0; i2++) {
				d1 = (double)i2 + 0.5D - entity.posX;
				
				for (j2 = k-b0; j2 <= k+b0; j2++) {
					d2 = (double)j2+0.5D - entity.posZ;
					label222:
						
					for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 <= 0; k2--) {
						if (this.worldServerInstance.isAirBlock(i2, k2, j2)) {
							while(k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2-1, j2)) {
								k2--;
							}
							
							for (i3 = l1; i3 < l1 + 2; i3++) {
								l2 = i3%2;
								k3 = 1-l2;
								
								for (j3 = 0; j3 < 4; j3++) {
									for (i4 = -1; i4 < 4; i4++) {
										l3 = i2 + (j3-1)*l2;
										k4 = k2 + i4;
										j4 = j2 + (j3-1)*k3;
										
										if (i4 > 0 && !this.worldServerInstance.getBlock(l3, k4, j4).getMaterial().isSolid() || i4 >= 0 && ! this.worldServerInstance.isAirBlock(l3, k4, j4)) {
											continue label222;
										}
									}
								}
								
								d4 = (double)k2 + 0.5D - entity.posY;
								d3 = d1*d1 + d4*d4 + d2*d2;
								
								if (d0 < 0.0D || d3 < d0) {
									d0 = d3;
									l = i2;
									i1 = k2;
									j1 = j2;
									k1 = l2%2;
								}
							}
						}
					}
				}
			}
		}
		
		int i5 = l;
		int j5 = i1;
		j2 = j1;
		int k5 = k1%2;
		int l5 = 1-k5;
		if (k1%4 >= 2) {
			k5 = -k5;
			l5 = -l5;
		}
		
		boolean flag;
		
		if (d0 < 0.0D) {
			if (i1 < 70) {
				i1 = 70;
			}
			
			if (i1 > this.worldServerInstance.getActualHeight()-10) {
				i1 = this.worldServerInstance.getActualHeight()-10;
			}
			
			j5 = i1;
			
			for (k2  = -1; k2 <= 1; k2++) {
				for (i3 =1; i3 < 3; i3++) {
					for (l2 = -1; l2 < 3; l2++) {
						k3 = i5 + (i3-1)*k5 + (k2*l5);
						j3 = j5 + l2;
						i4 = j2 + (i3-1)*l5 - (k2*k5);
						flag = k2<0;
						this.worldServerInstance.setBlock(k3, j3, i4, flag?MoChickens.blockFeatherBlock:Blocks.air);
					}
				}
			}
		}
		
		for (k2  = 0; k2 < 4; k2++) {
			for (i3 = 0; i3 < 4; i3++) {
				for (l2 = -1; l2 < 4; l2++) {
					k3 = i5 + (i3-1)*k5;
					j3 = j5 + l2;
					i4 = j2 + (i3-1)*l5;
					flag = i3==0||i3==3||l2==-1||l2==3;
					this.worldServerInstance.setBlock(k3, j3, i4, flag?MoChickens.blockFeatherBlock:MoChickens.blockFeatherPortal, 0, 2);
				}
			}
			for (i3 = 0; i3 < 4; i3++) {
				for (l2 = -1; l2 < 4; l2++) {
					k3 = i5 + (i3-1)*k5;
					j3 = j5 + l2;
					i4 = j2 + (i3-1)*l5;
					this.worldServerInstance.notifyBlockOfNeighborChange(k3, j3, i4, this.worldServerInstance.getBlock(k3, j3, i4));
				}
			}
		}
		
		return false;
	}
	
	public void removeStalePortalLocations(long i) {
		
	}
}
