package me.saxon564.mochickens.blocks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import org.apache.logging.log4j.LogManager;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import me.saxon564.mochickens.world.dimensions.chicken.teleporters.ChickenTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFeatherPortal extends BlockPortal
{
    public BlockFeatherPortal()
    {
        this.setTickRandomly(true);
        this.setBlockName("chicken_portal");
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        super.updateTick(world, x, y, z, rand);
        
        EnumDifficulty difficulty = world.difficultySetting;
        int serverDifficulty;
        
        if (difficulty.toString() == "HARD") {
        	serverDifficulty = 3;
        } else if (difficulty.toString() == "NORMAL") {
        	serverDifficulty = 2;
        } else if (difficulty.toString() == "EASY") {
        	serverDifficulty = 1;
        } else {
        	serverDifficulty = 0;
        }

        if (world.provider.isSurfaceWorld() && rand.nextInt(2000) < serverDifficulty)
        {
            int l;

            for (l = y; !world.doesBlockHaveSolidTopSurface(world, x, l, z) && l > 0; --l)
            {
                ;
            }

            if (l > 0 && !world.isBlockNormalCubeDefault(x, l + 1, z, false))
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(world, 93, (double)x + 0.5D, (double)l + 1.1D, (double)z + 0.5D);

                if (entity != null)
                {
                	LogManager.getLogger().info(entity.getEntityId());
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess worldBlock, int x, int y, int z)
    {
        float f;
        float f1;

        if (worldBlock.getBlock(x - 1, y, z) != this && worldBlock.getBlock(x + 1, y, z) != this)
        {
            f = 0.125F;
            f1 = 0.5F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
        else
        {
            f = 0.5F;
            f1 = 0.125F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World world, int x, int y, int z)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (world.getBlock(x - 1, y, z) == MoChickens.blockFeatherBlock || world.getBlock(x + 1, y, z) == MoChickens.blockFeatherBlock)
        {
            b0 = 1;
        }

        if (world.getBlock(x, y, z - 1) == MoChickens.blockFeatherBlock || world.getBlock(x, y, z + 1) == MoChickens.blockFeatherBlock)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (world.isAirBlock(x - b0, y, z - b1))
            {
                x -= b0;
                z -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        Block j1 = world.getBlock(x + b0 * l, y + i1, z + b1 * l);
                        boolean isAirBlock = world.isAirBlock(x + b0 * l, y + i1, z + b1 * l);

                        if (flag)
                        {
                            if (j1 != MoChickens.blockFeatherBlock)
                            {
                                return false;
                            }
                        }
                        else if (!isAirBlock && j1 != MoChickens.blockChickenFire)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    world.setBlock(x + b0 * l, y + i1, z + b1 * l, this, 0, 2);
                }
            }

            return true;
        }
    }
    
    public boolean func_150000_e(World p_150000_1_, int p_150000_2_, int p_150000_3_, int p_150000_4_){return false;}

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: world, x, y, z
     */
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = y; world.getBlock(x, i1 - 1, z) == this; --i1)
        {
            
        }

        if (world.getBlock(x, i1 - 1, z) != MoChickens.blockFeatherBlock)
        {
            ((World) world).setBlockToAir(x, y, z);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1)
            {
                
            }

            if (j1 == 3 && world.getBlock(x, i1 + j1, z) == MoChickens.blockFeatherBlock)
            {
                boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this;
                boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z + 1) == this;

                if (flag && flag1)
                {
                    ((World) world).setBlockToAir(x, y, z);
                }
                else
                {
                    if ((world.getBlock(x + b0, y, z + b1) != MoChickens.blockFeatherBlock || world.getBlock(x - b0, y, z - b1) != this) && (world.getBlock(x - b0, y, z - b1) != MoChickens.blockFeatherBlock || world.getBlock(x + b0, y, z + b1) != this))
                    {
                        ((World) world).setBlockToAir(x, y, z);
                    }
                }
            }
            else
            {
                ((World) world).setBlockToAir(x, y, z);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess worldBlock, int x, int y, int z, int par5)
    {
        if (worldBlock.getBlock(x, y, z) == this)
        {
            return false;
        }
        else
        {
            boolean flag = worldBlock.getBlock(x - 1, y, z) == this && worldBlock.getBlock(x - 2, y, z) != this;
            boolean flag1 = worldBlock.getBlock(x + 1, y, z) == this && worldBlock.getBlock(x + 2, y, z) != this;
            boolean flag2 = worldBlock.getBlock(x, y, z - 1) == this && worldBlock.getBlock(x, y, z - 2) != this;
            boolean flag3 = worldBlock.getBlock(x, y, z + 1) == this && worldBlock.getBlock(x, y, z + 2) != this;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    /*public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP)
        {
        	EntityPlayerMP player = (EntityPlayerMP) entity;
        	FMLCommonHandler.instance().getMinecraftServerInstance();
        	MinecraftServer server = MinecraftServer.getServer();
        	
            if (player.timeUntilPortal > 0) {
            	player.timeUntilPortal = 10;
            } else if (player.dimension != MoChickens.chickenDimensionId) {
            	player.timeUntilPortal = 10;
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, MoChickens.chickenDimensionId, new ChickenTeleporter(server.worldServerForDimension(MoChickens.chickenDimensionId)));
            } else {
            	player.timeUntilPortal = 10;
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new ChickenTeleporter(server.worldServerForDimension(0)));
            }
        }
    }*/

    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        if (rand.nextInt(100) == 0)
        {
            world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)x + rand.nextFloat());
            double d1 = (double)((float)y + rand.nextFloat());
            double d2 = (double)((float)z + rand.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = rand.nextInt(2) * 2 - 1;
            d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;

            if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this)
            {
                d0 = (double)x + 0.5D + 0.25D * (double)i1;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)z + 0.5D + 0.25D * (double)i1;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)i1);
            }

            world.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_){return Item.getItemById(0);}
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(MoChickensReference.MODID + ":" + getUnlocalizedName().substring(5));
    }
}