package top.evanechecssss.weedding.common.blocks;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.utils.base.blocks.HorizontalBlockBase;

import java.util.Random;

public class GramophoneIron extends HorizontalBlockBase {


    public GramophoneIron(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
        GameRegistry.registerTileEntity(GramophoneTE.class, this.getRegistryName().toString());
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (getTileEntity(world, pos).getRecord().isEmpty()) {
                if (playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemRecord) {
                    Weedding.NETWORK.sendToServer(new GramophoneMessage(playerIn.getHeldItem(EnumHand.MAIN_HAND).copy(), pos));
                    setRecord(world, pos, playerIn.getHeldItem(EnumHand.MAIN_HAND));
                    playerIn.getHeldItem(EnumHand.MAIN_HAND).setCount(0);
                }

            } else {
                dropRecord(world, pos);
                Weedding.NETWORK.sendToServer(new GramophoneMessage(ItemStack.EMPTY, pos));
            }
            return true;
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (((GramophoneTE) worldIn.getTileEntity(pos)).getRecord().isEmpty()) {
            return;
        }
        double x = 0;
        double z = 0;
        switch (stateIn.getValue(FACING)) {
            case NORTH:
                x = pos.getX() + 8 * 0.0625;
                z = pos.getZ() - 5 * 0.0625;
                break;
            case WEST:
                x = pos.getX() - 8 * 0.0625;
                z = pos.getZ() + 5 * 0.0625;
                break;
            case EAST:
                x = pos.getX() + 24 * 0.0625;
                z = pos.getZ() + 5 * 0.0625;
                break;
            case SOUTH:
                x = pos.getX() - 4 * 0.0625;
                z = pos.getZ() + 24 * 0.0625;
                break;

        }
        worldIn.spawnParticle(EnumParticleTypes.NOTE, x, pos.getY() + 18 * 0.0625, z, 0, 0.2, 0);
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.playEvent(1010, pos, 0);
        worldIn.playRecord(pos, null);
        TileEntity te = worldIn.getTileEntity(pos);
        if (te instanceof GramophoneTE) {
            ItemStack record = ((GramophoneTE) te).getRecord();

            if (!record.isEmpty()) {
                Block.spawnAsEntity(worldIn, pos, record);
            }
        }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        worldIn.playEvent(1010, pos, 0);
        worldIn.playRecord(pos, null);
        if (te instanceof GramophoneTE) {
            ItemStack record = ((GramophoneTE) te).getRecord();
            if (!record.isEmpty()) {
                Block.spawnAsEntity(worldIn, pos, record);
            }
        }

        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    private void setRecord(World world, BlockPos pos, ItemStack record) {
        record = record.copy();
        GramophoneTE tile = getTileEntity(world, pos);
        tile.setRecord(record);
        if (record.getItem() instanceof ItemRecord) {
            ItemRecord record1 = (ItemRecord) record.getItem();
        }

    }


    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        GramophoneTE tile = getTileEntity(worldIn, pos);
        if (tile != null) {
            ItemStack item = tile.getRecord();

            if (!item.isEmpty()) {
                return item;
            }
        }

        return super.getItem(worldIn, pos, state);
    }


    private void dropRecord(World world, BlockPos pos) {
        world.playEvent(1010, pos, 0);
        world.playRecord(pos, null);
        if (!world.isRemote) {
            GramophoneTE tile = getTileEntity(world, pos);
            ItemStack item = tile.getRecord();
            if (!item.isEmpty()) {
                world.playRecord(pos, null);
                tile.setRecord(ItemStack.EMPTY);
                double d = new Random().nextDouble();
                BlockPos blockPos1 = new BlockPos(pos.getX() + d, pos.getY() + d, pos.getZ() + d);
                Block.spawnAsEntity(world, blockPos1, item);

            }
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(15 * 0.0625, 0 * 0.0625, 14 * 0.0625, 2 * 0.0625, 22 * 0.0625, -2 * 0.0625);
    }

    public GramophoneTE getTileEntity(World world, BlockPos pos) {
        return (GramophoneTE) world.getTileEntity(pos);
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
    public GramophoneTE createTileEntity(World world, IBlockState blockState) {
        return new GramophoneTE();
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public static class GramophoneTE extends TileEntity {
        private ItemStack record = ItemStack.EMPTY;

        public GramophoneTE() {

        }

        public void readFromNBT(NBTTagCompound compound) {
            super.readFromNBT(compound);

            if (compound.hasKey("RecordItem")) {
                this.setRecord(new ItemStack(compound.getCompoundTag("RecordItem")));
            }
        }

        public NBTTagCompound writeToNBT(NBTTagCompound compound) {
            if (!this.record.isEmpty()) {
                compound.setTag("RecordItem", this.record.serializeNBT());
            }
            return super.writeToNBT(compound);
        }

        public ItemStack getRecord() {
            return record;
        }

        public void setRecord(ItemStack recordStack) {
            this.record = recordStack;
            markDirty();
        }

        @Override
        public NBTTagCompound getUpdateTag() {
            return this.writeToNBT(new NBTTagCompound());
        }

        @Override
        public SPacketUpdateTileEntity getUpdatePacket() {
            return new SPacketUpdateTileEntity(this.pos, this.getBlockMetadata(), this.getUpdateTag());
        }

        @Override
        public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
            this.readFromNBT(packet.getNbtCompound());
        }

    }

    public static class GramophoneTERender extends TileEntitySpecialRenderer<GramophoneTE> {
        public GramophoneTERender() {
            super();
        }


        @Override
        public void render(GramophoneTE te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
            if (!te.getRecord().isEmpty()) {
                IBlockState state = te.getWorld().getBlockState(te.getPos());

                GlStateManager.pushMatrix();

                if (state.getBlock() instanceof GramophoneIron) {
                    EnumFacing facing = state.getValue(FACING);

                    if (facing == EnumFacing.NORTH) {
                        GlStateManager.translate(x + 8.5 / 16F, y + 5.5 / 16F, z + 6.5 / 16F);
                    } else if (facing == EnumFacing.SOUTH) {
                        GlStateManager.translate(x + 7.5 / 16F, y + 5.5 / 16F, z + 9.5 / 16F);
                    } else if (facing == EnumFacing.WEST) {
                        GlStateManager.translate(x + 6.5 / 16F, y + 5.5 / 16F, z + 7.5 / 16F);
                    } else {
                        GlStateManager.translate(x + 9.5 / 16F, y + 5.5 / 16F, z + 8.5 / 16F);
                    }
                }

                GlStateManager.rotate(-90 + (System.currentTimeMillis() % 4000 / 4000F) * -360, 0, 1, 0);
                GlStateManager.rotate(90, 1, 0, 0);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);

                RenderItem render = Minecraft.getMinecraft().getRenderItem();
                IBakedModel model = render.getItemModelWithOverrides(te.getRecord(), te.getWorld(), Minecraft.getMinecraft().player);

                Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                render.renderItem(te.getRecord(), model);

                GlStateManager.popMatrix();
            }
        }
    }

    public static class GramophoneMessage implements IMessage {

        private ItemStack itemSend;
        private BlockPos posSend;

        public GramophoneMessage() {
        }

        public GramophoneMessage(ItemStack itemSend, BlockPos posSend) {
            this.itemSend = itemSend;
            this.posSend = posSend;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            this.itemSend = ByteBufUtils.readItemStack(buf);
            this.posSend = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
        }

        @Override
        public void toBytes(ByteBuf buf) {
            ByteBufUtils.writeItemStack(buf, itemSend);
            buf.writeInt(posSend.getX());
            buf.writeInt(posSend.getY());
            buf.writeInt(posSend.getZ());
        }
    }

    public static class GramophoneMessageHandler implements IMessageHandler<GramophoneMessage, IMessage> {
        public static void PlayRecordClient(ItemStack itemStack, EntityPlayer player, BlockPos pos) {
            if (itemStack.getItem() instanceof ItemRecord) {
                player.world.playRecord(pos, ((ItemRecord) itemStack.getItem()).getSound());
            }

            TileEntity entity = player.world.getTileEntity(pos);

            if (entity instanceof GramophoneTE) {
                ((GramophoneTE) entity).setRecord(itemStack);
            }
        }

        @Override
        public IMessage onMessage(GramophoneMessage message, MessageContext ctx) {
            EntityPlayerMP entity = ctx.getServerHandler().player;
            EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
            entity.getServerWorld().addScheduledTask(() -> {
                PlayRecordClient(message.itemSend, entityPlayerSP, message.posSend);
            });
            return null;
        }
    }
}
