package top.evanechecssss.weedding.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.client.gui.BookGuiScreen;
import top.evanechecssss.weedding.utils.base.items.ItemBase;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

import java.util.List;

public class CustomBook extends ItemBase {
    String textName = "";
    ResourceLocation texture;

    public CustomBook(String name, String textName, ResourceLocation texture) {
        super(name);
        this.textName = textName;
        this.texture = texture;
    }

    public CustomBook(String name, int damage, int stackSize, CreativeTabs tab, String textName, ResourceLocation texture) {
        super(name, damage, stackSize, tab);
        this.textName = textName;
        this.texture = texture;
    }

    public CustomBook(String name, int damage, int stackSize, CreativeTabs tab, String toolClass, int toolLevel, List<String> stringList, String textName, ResourceLocation texture) {
        super(name, damage, stackSize, tab, toolClass, toolLevel, stringList);
        this.textName = textName;
        this.texture = texture;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            Weedding.logger.info("BOOK IS ACTIVE");

        } else {
            String lang = "";
            if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("en_us")) {
                lang = "en";
            }
            if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("ru_ru")) {
                lang = "ru";
            }
            ResourceLocation text = new ResourceLocation(WeeddingInfo.MODID, "information/" + lang + "/" + textName + ".json");
            Minecraft.getMinecraft().displayGuiScreen(new BookGuiScreen(texture, text));
        }
        return EnumActionResult.SUCCESS;
    }
}
