package top.evanechecssss.weedding.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import top.evanechecssss.weedding.api.WeeddingMisc;
import top.evanechecssss.weedding.init.WeeddingBlocks;
import top.evanechecssss.weedding.common.base.items.ItemBase;

import java.util.List;

public class HempSeed extends ItemBase implements IPlantable {
    public HempSeed(String name) {
        super(name);
    }
    public HempSeed(String name, int damage, int stackSize, CreativeTabs tab) {
        super(name, damage, stackSize, tab);
    }
    public HempSeed(String name, int damage, int stackSize, CreativeTabs tab, String toolClass, int toolLevel, List<String> stringList) {
        super(name, damage, stackSize, tab, toolClass, toolLevel, stringList);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        if(facing==EnumFacing.UP && state.getBlock() == Blocks.GRASS && worldIn.isAirBlock(pos.up())){
            worldIn.setBlockState(pos.up(), WeeddingBlocks.HEMP.getDefaultState());
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
            }
            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return WeeddingBlocks.HEMP.getDefaultState();
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return WeeddingMisc.Rarity.FORBIDDEN;
    }
}
