package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.utils.base.blocks.HorizontalBlockBase;

import javax.annotation.Nullable;
import java.util.List;

public class BoilerBlock extends HorizontalBlockBase{
    private static final AxisAlignedBB AABB_INTERACT= new AxisAlignedBB(0*0.0625,0*0.0625,0*0.0625,16*0.0625,22*0.0625,16*0.0625);
    private static final AxisAlignedBB AABB_BODY= new AxisAlignedBB(0*0.0625,0*0.0625,0*0.0625,16*0.0625,22*0.0625,16*0.0625);
    private static final AxisAlignedBB AABB_N= new AxisAlignedBB(9*0.0625,22*0.0625,9*0.0625,13*0.0625,31*0.0625,13*0.0625);
    private static final AxisAlignedBB AABB_E= new AxisAlignedBB(2*0.0625,22*0.0625,9*0.0625,6*0.0625,31*0.0625,13*0.0625);
    private static final AxisAlignedBB AABB_W= new AxisAlignedBB(9*0.0625,22*0.0625,2*0.0625,13*0.0625,31*0.0625,6*0.0625);
    private static final AxisAlignedBB AABB_S= new AxisAlignedBB(2*0.0625,22*0.0625,2*0.0625,6*0.0625,31*0.0625,6*0.0625);
    private static final AxisAlignedBB AABB_DOOR_N= new AxisAlignedBB(16*0.0625,4*0.0625,-6*0.0625,2*0.0625,11*0.0625,0*0.0625);
    private static final AxisAlignedBB AABB_DOOR_S= new AxisAlignedBB(0*0.0625,4*0.0625,21*0.0625,14*0.0625,11*0.0625,15*0.0625);
    private static final AxisAlignedBB AABB_DOOR_W= new AxisAlignedBB(-6*0.0625,4*0.0625,0*0.0625,0*0.0625,11*0.0625,14*0.0625);
    private static final AxisAlignedBB AABB_DOOR_E= new AxisAlignedBB(21*0.0625,4*0.0625,15*0.0625,15*0.0625,11*0.0625,1*0.0625);
    private static AxisAlignedBB AABB_SEL = null;
    private static AxisAlignedBB AABB_DOOR = null;
    public BoilerBlock(String name, Material material, CreativeTabs tabs, SoundType soundType) {
        super(name, material, tabs, soundType);
        this.setHardness(1F);
        this.setResistance(10F);
        this.setLightLevel(1F);
        this.setLightOpacity(1);
        this.setHardness(1F);
        this.setResistance(10F);
    }
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes,AABB_BODY );
        switch (state.getValue(FACING)){
            case NORTH:
                AABB_SEL=AABB_N;
                AABB_DOOR=AABB_DOOR_N;
                break;
            case EAST:
                AABB_SEL=AABB_E;
                AABB_DOOR=AABB_DOOR_E;
                break;
            case WEST:
                AABB_SEL=AABB_W;
                AABB_DOOR=AABB_DOOR_W;
                break;
            case SOUTH:
                AABB_SEL=AABB_S;
                AABB_DOOR=AABB_DOOR_S;
                break;
        }
        addCollisionBoxToList(pos, entityBox, collidingBoxes,AABB_SEL);
        addCollisionBoxToList(pos, entityBox, collidingBoxes,AABB_DOOR);
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB_INTERACT;
    }
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return FULL_BLOCK_AABB;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
