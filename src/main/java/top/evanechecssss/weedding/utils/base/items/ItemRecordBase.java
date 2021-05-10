package top.evanechecssss.weedding.utils.base.items;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class ItemRecordBase extends ItemRecord {
    public ItemRecordBase(String name, SoundEvent soundEvent) {
        super(name, soundEvent);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(WeeddingCreativeTabs.weedding);
        this.setMaxStackSize(1);
    }

}
