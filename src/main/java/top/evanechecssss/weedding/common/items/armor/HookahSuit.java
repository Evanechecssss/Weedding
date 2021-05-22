package top.evanechecssss.weedding.common.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;

public class HookahSuit extends ItemArmor {
    public HookahSuit(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName("weedding." + name);
        this.setCreativeTab(WeeddingCreativeTabs.WEEDDING_CT);
    }

}
