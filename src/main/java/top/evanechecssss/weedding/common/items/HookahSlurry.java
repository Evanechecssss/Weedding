package top.evanechecssss.weedding.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import top.evanechecssss.weedding.common.base.items.ItemBase;
import top.evanechecssss.weedding.init.WeeddingCreativeTabs;


public abstract class HookahSlurry extends ItemBase {
    private PotionEffect[] effects;
    private int durabilityColor;
    private double durabilityValue;

    public HookahSlurry(String name) {
        super(name, 1, 1, WeeddingCreativeTabs.WEEDDING_CT);
    }

    public void setPotionEffects(PotionEffect[] effects){
        this.effects = effects;
    }

    public PotionEffect[] getPotionEffects(){
        return effects;
    }

    public void setDurabilityColor(int durabilityColor){
        this.durabilityColor = durabilityColor;
    }

    public void setDurabilityValue(double durabilityValue){
        this.durabilityValue = durabilityValue;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return durabilityValue;
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return durabilityColor;
    }

}
