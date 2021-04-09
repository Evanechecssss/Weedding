package com.evanko.likewise.utils.base.blocks;

import com.evanko.likewise.utils.reference.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block {
    public BlockBase(String name,Material material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
    }
    public BlockBase(String name,Material material,float hardness,float resistance,String toolClass,int toolLevel) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
    }
    public BlockBase(String name,Material material,float hardness,float resistance,String toolClass,int toolLevel,CreativeTabs tab, SoundType type) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setSoundType(type);
        this.setCreativeTab(tab);
    }
    public BlockBase(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type,float lightLevel, int lightOpacity) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setCreativeTab(tab);
        this.setLightLevel(lightLevel);
        this.setLightOpacity(lightOpacity);
        this.setSoundType(type);
    }
}
