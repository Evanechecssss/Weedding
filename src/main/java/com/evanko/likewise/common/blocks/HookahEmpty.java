package com.evanko.likewise.common.blocks;

import com.evanko.likewise.common.blocks.help.IHookah;
import com.evanko.likewise.common.blocks.types.HookahEmptyTypes;
import com.evanko.likewise.utils.base.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HookahEmpty extends BlockBase implements IHookah {
    public static final PropertyEnum<HookahEmptyTypes> COLOR = PropertyEnum.create("color", HookahEmptyTypes.class);

    public HookahEmpty(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
        this.getDefaultState().withProperty(COLOR, HookahEmptyTypes.WHITE);
    }

    /*
    HOOKAH
     */
    @Override
    public PotionEffect[] getPotionEffects() {
        return new PotionEffect[]{new PotionEffect(Potion.getPotionById(1), 10, 5, true, false)};
    }

    @Override
    public boolean isHookah() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getTypeHookah() {
        return null;
    }

    /*
        EVENT
     */
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            float fortune = player.getLuck();
            boolean breack = false;
            if (player.getHeldItem(hand).getItem() instanceof ItemBlock && fortune < 1) {
                world.destroyBlock(pos, false);
                breack = true;
            }
            SendMessageHookah(world, player, hand, facing, fortune, breack);
        }
        return true;
    }

    public boolean SendMessageHookah(World world, EntityPlayer player, EnumHand hand, EnumFacing facing, float fortune, boolean breack) {
        if (breack) {
            Minecraft.getMinecraft().player.sendChatMessage(I18n.format("likewise.chat.message.hookah.mistake1"));
            return true;
        }
        Minecraft.getMinecraft().player.sendChatMessage(I18n.format("likewise.chat.message.hookah.variant" + (int) Math.round(Math.random() * 6 + 1)));
        return true;
    }

    /*
    META AND RENDER AND STATES
     */
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(5 * 0.0625, 0 * 0.0625, 5 * 0.0625, 10 * 0.0625, 17 * 0.0625, 10 * 0.0625);
    }

    public int damageDropped(IBlockState state) {
        return state.getValue(COLOR).ordinal();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        int meta = state.getValue(COLOR).ordinal();

        return new ItemStack(Item.getItemFromBlock(this), 1, meta);
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (HookahEmptyTypes base : HookahEmptyTypes.values()) {
            list.add(new ItemStack(this, 1, base.ordinal()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        HookahEmptyTypes[] values = HookahEmptyTypes.values();

        if (meta >= values.length || meta < 0) {
            return this.getDefaultState();
        }

        return this.getDefaultState().withProperty(COLOR, values[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(COLOR).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, COLOR);
    }
}
