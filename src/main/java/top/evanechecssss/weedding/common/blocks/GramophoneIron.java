package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.common.blocks.types.GramophoneTypes;
import top.evanechecssss.weedding.tiles.GramophoneTE;
import top.evanechecssss.weedding.utils.base.blocks.HorizontalBlockBase;

import java.util.Random;

public class GramophoneIron extends HorizontalBlockBase {
    public static final PropertyEnum<GramophoneTypes> COLOR = PropertyEnum.create("color", GramophoneTypes.class);

    public GramophoneIron(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
        GameRegistry.registerTileEntity(GramophoneTE.class, this.getRegistryName().toString());
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            if (getTileEntity(world, pos).getRecord().isEmpty()) {
                if (playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemRecord) {
                    setRecord(world, pos, playerIn.getHeldItem(EnumHand.MAIN_HAND));
                    playerIn.getHeldItem(EnumHand.MAIN_HAND).setCount(0);
                }
                return false;
            } else {
                dropRecord(world, pos);
                return true;
            }
        }
        return false;
    }

    private void setRecord(World world, BlockPos pos, ItemStack record) {
        GramophoneTE tile = getTileEntity(world, pos);
        tile.setRecord(record);
        if (record.getItem() instanceof ItemRecord) {
            ItemRecord record1 = (ItemRecord) record.getItem();
            world.playRecord(pos, record1.getSound());
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double x = 0;
        double z = 0;
        switch (stateIn.getValue(FACING)) {
            case NORTH:
                x = pos.getX() + 8 * 0.0625;
                z = pos.getZ() - 5 * 0.0625;
                break;
            case WEST:
                x = pos.getX() - 8 * 0.0625;
                z = pos.getZ() + 5 * 0.0625;
                break;
            case EAST:
                x = pos.getX() + 24 * 0.0625;
                z = pos.getZ() + 5 * 0.0625;
                break;
            case SOUTH:
                x = pos.getX() - 4 * 0.0625;
                z = pos.getZ() + 24 * 0.0625;
                break;

        }
        worldIn.spawnParticle(EnumParticleTypes.NOTE, x, pos.getY() + 18 * 0.0625, z, 0, 0.2, 0);
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
        this.dropRecord(worldIn, pos);

    }

    private void dropRecord(World world, BlockPos pos) {
        if (!world.isRemote) {
            GramophoneTE tile = getTileEntity(world, pos);
            ItemStack item = tile.getRecord();
            if (!item.isEmpty()) {
                world.playRecord(pos, null);
                tile.setRecord(ItemStack.EMPTY);
                ItemStack item1 = item.copy();
                double d = new Random().nextDouble();
                EntityItem entityItem = new EntityItem(world, pos.getX() + d, pos.getY() + d, pos.getZ() + d, item1);
                entityItem.setDefaultPickupDelay();
                world.spawnEntity(entityItem);
            }
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(15 * 0.0625, 0 * 0.0625, 14 * 0.0625, 2 * 0.0625, 22 * 0.0625, -2 * 0.0625);
    }

    public GramophoneTE getTileEntity(World world, BlockPos pos) {
        return (GramophoneTE) world.getTileEntity(pos);
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public GramophoneTE createTileEntity(World world, IBlockState blockState) {
        return new GramophoneTE();
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }


}
