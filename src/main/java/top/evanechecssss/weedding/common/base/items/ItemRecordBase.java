package top.evanechecssss.weedding.common.base.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.api.WeeddingMisc;
import top.evanechecssss.weedding.init.WeeddingCreativeTabs;
import top.evanechecssss.weedding.init.WeeddingInfo;

import java.util.List;

public class ItemRecordBase extends ItemRecord {
    private String author = "";
    private String music = "";
    private EnumRarity rarity;

    public ItemRecordBase(String name, SoundEvent soundEvent) {
        super(name, soundEvent);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(WeeddingCreativeTabs.WEEDDING_CT);
        this.setMaxStackSize(1);
        this.rarity = WeeddingMisc.Rarity.DISK;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("");
        tooltip.add(author);
        tooltip.add("§b" + music);
    }

    public ItemRecordBase addInfo(String author, String music) {
        this.author = author;
        this.music = music;
        return this;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return rarity;
    }

    public ItemRecordBase setRarity(EnumRarity rarity){
        this.rarity = rarity;
        return this;
    }
}
