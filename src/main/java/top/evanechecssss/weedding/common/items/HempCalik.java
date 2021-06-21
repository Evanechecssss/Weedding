package top.evanechecssss.weedding.common.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import top.evanechecssss.weedding.api.WeeddingMisc;

public class HempCalik extends HookahSlurry{
    public HempCalik(String name) {
        super(name);
        super.setDurabilityColor(0x00DB28);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return WeeddingMisc.Rarity.TOXIC;
    }

}
