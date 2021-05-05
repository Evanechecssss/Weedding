package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.tiles.BoxTE;
import top.evanechecssss.weedding.utils.base.blocks.HorizontalBlockBase;

public class Box extends HorizontalBlockBase {
    public Box(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tabs, SoundType soundType, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tabs, soundType, lightLevel, lightOpacity);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }

    public Box(String name, Material material, CreativeTabs tabs, SoundType soundType, int hardness, int resistance, String toolClass, int toolLevel) {
        super(name, material, tabs, soundType, hardness, resistance, toolClass, toolLevel);
    }

    public Box(String name, Material material, int hardness, int resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
    }

    public Box(String name, Material material) {
        super(name, material);

    }

    public Box(String name) {
        super(name);
    }

    public Box(String name, Material material, CreativeTabs tabs, SoundType soundType) {
        super(name, material, tabs, soundType);
    }

    public Class<BoxTE> getTileEntityClass() {
        return BoxTE.class;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        BoxTE tile = (BoxTE) world.getTileEntity(pos);
        if (!world.isRemote) {
            ItemStack item = playerIn.getHeldItem(EnumHand.MAIN_HAND);
            if (item.getItem() == Items.COOKIE) {
                tile.addCracker(item);
                return true;
            }
            if (item.getItem() == Items.AIR) {
                tile.removeCracker();
                return true;
            }

        }else {
            playerIn.sendMessage(new TextComponentString("cookie - " + tile.getCrackerCount()));
        }
        return true;

    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new BoxTE();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
