package top.evanechecssss.weedding.client.gui.base;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class ContainerGUIBase<T extends IHasContainer> extends GuiContainer {
    private ResourceLocation background;
    private int width;
    private int height;
    private final boolean isDefaultBackground;
    private final boolean doesPause;
    private final T entity;
    private final Container container;
    private int slotSize;
    private List<Slot> sizedSlots = Lists.newArrayList();
    private int[] slotsId = new int[]{};

    public ContainerGUIBase(T entity, Container container, ResourceLocation background, int width, int height, boolean isDefaultBackground, boolean doesPause) {
        super(container);
        this.background = background;
        this.entity = entity;
        this.container = container;
        this.doesPause = doesPause;
        this.width = width;
        this.height = height;
        xSize = width;
        ySize = height;
        this.isDefaultBackground = isDefaultBackground;
    }

    private void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void setBackground(ResourceLocation background) {
        this.background = background;
    }

    public void changeSlotSize(int size, List<Slot> slots) {
        slotSize = size;
        sizedSlots = slots;
    }

    public void changeSlotSize(int size, int[] slotsId) {
        slotSize = size;
        for (int i : slotsId) {
            sizedSlots.add(container.getSlot(i));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        if (isDefaultBackground) {
            this.drawDefaultBackground();
        }
        int i = this.guiLeft;
        int j = this.guiTop;
        for (Slot slot : sizedSlots) {
            if (this.isMouseOverSlot(slot, mouseX, mouseY) && slot.isEnabled()) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float) i, (float) j, 0.0F);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.enableRescaleNormal();
                int j1 = slot.xPos;
                int k1 = slot.yPos;
                GlStateManager.disableDepth();
                GlStateManager.colorMask(true, true, true, false);
                this.drawGradientRect(j1, k1, j1 + slotSize, k1 + slotSize, -2130706433, -2130706433);
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.popMatrix();
            }
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);

    }

    @Override
    public boolean doesGuiPauseGame() {
        return doesPause;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, width, height);
    }

}
