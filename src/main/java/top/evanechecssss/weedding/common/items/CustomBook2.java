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

public class CustomBook2 extends CustomBook {

    public CustomBook2(String name, int damage, int stackSize, CreativeTabs tab, String textName, ResourceLocation texture, boolean showCount, int angle, int countColor) {
        super(name, damage, stackSize, tab, textName, texture, showCount, angle, countColor);
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
        Minecraft.getMinecraft().displayGuiScreen(createBook()
                .setDoesPause(false).setDeformPage(2, 1, 1).setDeformText(2, 1, 0).setTextShiftY(65));
    }
}
