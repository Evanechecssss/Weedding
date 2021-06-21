package top.evanechecssss.weedding.client.overlays;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.init.WeeddingItems;
import top.evanechecssss.weedding.init.WeeddingKeybinds;
import top.evanechecssss.weedding.init.WeeddingInfo;

public class ExoskeletonOverlay extends Gui {

    private final ResourceLocation overlayTexture = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/exoskeleton_layer.png");
    private final int label_Width = 53;
    private final int label_Hight = 12;
    private final int tab_Width = 53;
    private final int tab_Hight = 99;
    private final int level_Width = 102;
    private final int level_Hight = 11;
    private final int full_Width = 100;
    private final int full_Hight = 9;
    private static boolean isActive = false;
    private float timeStart;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && isArmorActive()) {
            renderLabelOverlay(event);
            if (isActive) {
                renderTabOverlay(event);
            }
            renderLevelEnergy(event, getLevelVal());
        }
    }


    private int getLevelVal() {
        int level = 0;
        Minecraft mc = Minecraft.getMinecraft();
        NBTTagCompound compound = mc.player.inventory.getStackInSlot(38).getTagCompound();
        if (!compound.hasKey("energy")) {
            Weedding.logger.error("DON'T HAVE NBT ENERGY");
            return 0;
        }
        int nbtLevel = compound.getInteger("energy");
        level = full_Width * nbtLevel / 1000;
        return Math.round(level);
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = false)
    public void renderPlayer(RenderPlayerEvent event){
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void keyInput(InputEvent.KeyInputEvent event) {
        isActive = WeeddingKeybinds.SHOW_KEYS.isKeyDown();

        if (WeeddingKeybinds.NAV_EFFECT.isKeyDown() && WeeddingKeybinds.NAV.isKeyDown() && isArmorActive()) {
            EntityPlayerSP player = Minecraft.getMinecraft().player;
            for (int i = 0; i<=100;i++) {
                player.getEntityWorld().spawnParticle(EnumParticleTypes.BLOCK_DUST, (double)player.posX , (double)player.posY,  (double)player.posZ, 0D + Math.random()*2-1, 1.0D, 0D+Math.random()*2-1, Block.getStateId(Blocks.PORTAL.getDefaultState()));
            }
            Weedding.NETWORK.sendToServer(new ExoskeletonMessage(1));
        }else if (WeeddingKeybinds.NAV_FLY.isKeyDown() && WeeddingKeybinds.NAV.isKeyDown() && isArmorActive()){
            EntityPlayerSP player = Minecraft.getMinecraft().player;
            player.moveRelative(0,5,10,10);

            Weedding.NETWORK.sendToServer(new ExoskeletonMessage(2));

        }
    }

    private void renderLabelOverlay(RenderGameOverlayEvent event) {
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft mc = Minecraft.getMinecraft();
        mc.renderEngine.bindTexture(overlayTexture);
        drawTexturedModalRect(2, 2, 0, 0, label_Width, label_Hight);

    }

    private void renderTabOverlay(RenderGameOverlayEvent event) {
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft mc = Minecraft.getMinecraft();
        mc.renderEngine.bindTexture(overlayTexture);
        drawTexturedModalRect(2, 2 + label_Hight, 0, 15, tab_Width, tab_Hight);
        mc.fontRenderer.drawStringWithShadow(I18n.format("weedding.overlay.exo1", WeeddingKeybinds.SHOW_KEYS.getDisplayName()), 8, 20, 0x1EFFA7);
        mc.fontRenderer.drawStringWithShadow(I18n.format("weedding.overlay.exo2", WeeddingKeybinds.NAV.getDisplayName()), 8, 32, 0x1EFFA7);
    }

    private void renderLevelEnergy(RenderGameOverlayEvent event, int level_val) {
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft mc = Minecraft.getMinecraft();
        mc.renderEngine.bindTexture(overlayTexture);
        drawTexturedModalRect(2 + label_Width, 3, 56, 1, level_Width, level_Hight);
        mc.renderEngine.bindTexture(overlayTexture);
        drawTexturedModalRect(2 + label_Width + 1, 4, 57, 15, level_val, full_Hight);
    }

    private boolean isArmorActive(){
        Minecraft mc = Minecraft.getMinecraft();
        return mc.player.inventory.getStackInSlot(39).getItem() == WeeddingItems.EXOSKELETON_HEAD &&
                mc.player.inventory.getStackInSlot(38).getItem() == WeeddingItems.EXOSKELETON_CHESTPLATE &&
                mc.player.inventory.getStackInSlot(37).getItem() == WeeddingItems.EXOSKELETON_LEGGS;
    }

    public static class ExoskeletonMessage implements IMessage {
        public ExoskeletonMessage() {

        }

        int type;

        public ExoskeletonMessage(int type) {
            this.type = type;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            this.type = buf.readInt();
        }

        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeInt(type);
        }

    }

    public static class ExoskeletonMessageHandler implements IMessageHandler<ExoskeletonMessage, IMessage> {

        private static void executeKeyBind(EntityPlayerMP player, int type) {
            if (type == 1) {
                PotionEffect[] potionEffects = new PotionEffect[]{
                        new PotionEffect(MobEffects.SATURATION, 200, 1),
                        new PotionEffect(MobEffects.REGENERATION, 200, 1),
                        new PotionEffect(MobEffects.JUMP_BOOST, 200, 1),
                        new PotionEffect(MobEffects.INSTANT_HEALTH, 200, 1),
                        new PotionEffect(MobEffects.SPEED, 200, 10),
                        new PotionEffect(MobEffects.RESISTANCE, 200, 1),
                        new PotionEffect(MobEffects.MINING_FATIGUE, 200, 1),
                        new PotionEffect(MobEffects.NIGHT_VISION, 200, 1),
                        new PotionEffect(MobEffects.STRENGTH, 200, 1)
                };
                for (PotionEffect effect : potionEffects) {
                    player.addPotionEffect(effect);
                }
                player.sendMessage(new TextComponentTranslation("weedding.chat.message.exo1"));
            }else if (type == 2){
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 10));
                player.sendMessage(new TextComponentTranslation("weedding.chat.message.exo2"));
                player.setElytraFlying();
            }
        }

        @Override
        public IMessage onMessage(ExoskeletonMessage message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            player.getServerWorld().addScheduledTask(() -> {
                executeKeyBind(player, message.type);
            });
            return null;
        }
    }
}
