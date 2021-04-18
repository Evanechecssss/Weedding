package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.common.tileEntitys.ChestOfLiquidsTE;
import top.evanechecssss.weedding.network.packets.AddictionMessage;
import top.evanechecssss.weedding.network.packets.WeeddingPacketHandler;
import top.evanechecssss.weedding.utils.base.blocks.HorizontalBlockBase;
import top.evanechecssss.weedding.utils.reference.WeeddingGUIs;

public class ChestOfLiquids extends HorizontalBlockBase {

    public ChestOfLiquids(String name, Material material, int hardness, int resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
        GameRegistry.registerTileEntity(ChestOfLiquidsTE.class, this.getRegistryName().toString());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn instanceof EntityPlayerMP) {
            WeeddingPacketHandler.INSTANCE.sendTo(new AddictionMessage(), (EntityPlayerMP) playerIn);
        }
        playerIn.openGui(Weedding.instance, WeeddingGUIs.CHEST_OF_LIQUIDS, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }


    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new ChestOfLiquidsTE();
    }
}
