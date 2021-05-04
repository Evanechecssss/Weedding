package top.evanechecssss.weedding.utils.base.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ContainerGUIBase<T, C> extends GuiContainer {
    private static ResourceLocation background;
    private static int width;
    private static int height;
    private final boolean isDefaultBackground;
    private final boolean doesPause;
    private final T tileEntity;
    private final C container;

    public ContainerGUIBase(T tileEntity, C container, ResourceLocation background, int width, int height, boolean isDefaultBackground, boolean doesPause) {
        super((net.minecraft.inventory.Container) container);
        ContainerGUIBase.background = background;
        this.tileEntity = tileEntity;
        this.container = container;
        this.doesPause = doesPause;
        ContainerGUIBase.width = width;
        ContainerGUIBase.height = height;
        xSize = width;
        ySize = height;
        this.isDefaultBackground = isDefaultBackground;
    }

    private static void setSize(int width, int height) {
        ContainerGUIBase.width = width;
        ContainerGUIBase.height = height;
    }

    private static void setBackground(ResourceLocation background) {
        ContainerGUIBase.background = background;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (isDefaultBackground) {
            this.drawDefaultBackground();
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
