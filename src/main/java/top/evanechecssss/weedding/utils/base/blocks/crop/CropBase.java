package top.evanechecssss.weedding.utils.base.blocks.crop;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CropBase extends BlockCrops {
    public CropBase(String name) {
        this.setUnlocalizedName("weedding." + name);
        this.setRegistryName(name);
    }
    public CropBase(String name, CreativeTabs tab) {
        this.setUnlocalizedName("weedding." + name);
        this.setRegistryName(name);
        this.setCreativeTab(tab);
    }
    public CropBase(String name,  CreativeTabs tab, SoundType type) {
        this.setUnlocalizedName("weedding." + name);
        this.setRegistryName(name);
        this.setCreativeTab(tab);
        this.setSoundType(type);
    }
    public CropBase(String name, CreativeTabs tab, SoundType type, float resistance) {
        this.setUnlocalizedName("weedding." + name);
        this.setRegistryName(name);
        this.setCreativeTab(tab);
        this.setSoundType(type);
        this.setResistance(resistance);
    }
    @Override
    protected Item getSeed() {
        return super.getSeed();
    }
    @Override
    protected Item getCrop() {
        return super.getCrop();
    }

}
