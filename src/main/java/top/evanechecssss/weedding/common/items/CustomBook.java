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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.client.gui.base.BookGuiScreen;
import top.evanechecssss.weedding.common.base.items.ItemBase;
import top.evanechecssss.weedding.init.WeeddingInfo;

public class CustomBook extends ItemBase {
    private final ResourceLocation texture;
    private final boolean showCount;
    private final int angle;
    private final int countColor;
    private String textName = "";

    public CustomBook(String name, int damage, int stackSize, CreativeTabs tab, String textName, ResourceLocation texture, boolean showCount, int angle, int countColor) {
        super(name, damage, stackSize, tab);
        this.textName = textName;
        this.texture = texture;
        this.angle = angle;
        this.showCount = showCount;
        this.countColor = countColor;
    }

    public BookGuiScreen createBook() {
        String lang = "";
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("en_us")) {
            lang = "en";
        }
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase("ru_ru")) {
            lang = "ru";
        }
        ResourceLocation text = new ResourceLocation(WeeddingInfo.MODID, "information/" + lang + "/" + textName + ".json");
        return new BookGuiScreen(texture, text, showCount, angle, countColor);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            Weedding.logger.info("BOOK IS ACTIVE");
        } else {
            this.openBook();
        }
        return EnumActionResult.SUCCESS;
    }

    @SideOnly(Side.CLIENT)
    private void openBook() {
        Minecraft.getMinecraft().displayGuiScreen(createBook());
    }

}
