package top.evanechecssss.weedding.utils.base.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class SubBlock<T extends Enum<T> & IStringSerializable> extends BlockBase {
    public SubBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
        this.setDefaultState(getBaseState());
    }

    protected abstract IBlockState getBaseState();

    public int damageDropped(IBlockState state) {
        return state.getValue(getSubList()).ordinal();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        int meta = state.getValue(getSubList()).ordinal();

        return new ItemStack(Item.getItemFromBlock(this), 1, meta);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (T base : getValues()) {
            list.add(new ItemStack(this, 1, base.ordinal()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        T[] values = getValues();

        if (meta >= values.length || meta < 0) {
            return this.getDefaultState();
        }

        return this.getDefaultState().withProperty(getSubList(), values[meta]);
    }

    protected abstract T[] getValues();

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(getSubList()).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, getSubList());
    }

    public abstract PropertyEnum<T> getSubList();
}
