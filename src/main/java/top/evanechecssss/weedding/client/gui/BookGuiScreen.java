package top.evanechecssss.weedding.client.gui;

import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.nio.charset.Charset;


public class BookGuiScreen extends GuiScreen {
    public static final int WIDTH = 147;
    public static final int HEIGHT = 181;
    public static ResourceLocation locationTexture;
    public static ResourceLocation locationText;
    public GuiButton buttonNext;
    public int Page = 0;
    public int MaxPage = 1;

    public BookGuiScreen(ResourceLocation locationTexture, ResourceLocation locationText) {
        BookGuiScreen.locationTexture = locationTexture;
        BookGuiScreen.locationText = locationText;
    }

    private String JsonParsing(int i, IResourceManager resourceManager) throws IOException {
        IResource resource = resourceManager.getResource(locationText);
        return new JsonParser().parse(IOUtils.toString(resource.getInputStream(), Charset.defaultCharset())).getAsJsonObject().get("pages").getAsJsonArray().get(i).getAsString();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1, 1, 1, 1);
        this.drawDefaultBackground();
        int centerX = (width - WIDTH) / 2;
        int centerY = (height - HEIGHT) / 2;
        mc.renderEngine.bindTexture(locationTexture);
        drawTexturedModalRect(centerX, centerY, 0, 0, WIDTH, HEIGHT);
        try {
            fontRenderer.drawSplitString(JsonParsing(Page, Minecraft.getMinecraft().getResourceManager()), centerX + 15, centerY + 15, WIDTH - 25, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void initGui() {
        this.buttonNext = this.addButton(new NextButton(0, (width - WIDTH) / 2 + WIDTH, (height - HEIGHT) / 2 + HEIGHT, "ЗАБАНЕН ЧЕКАЙ"));
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public boolean handleComponentClick(ITextComponent component) {
        return true;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            if (button.id == 0) {
                Page += 1;

            }
        }
    }

    @SideOnly(Side.CLIENT)
    private static class NextButton extends GuiButton {
        public NextButton(int buttonId, int x, int y, String buttonText) {
            super(buttonId, x, y, buttonText);
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            if (this.visible) {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BookGuiScreen.locationTexture);
                int i = 0;
                if (flag) {
                    i += 23;
                }
                this.drawTexturedModalRect(x, y, 151 + i, 10, 18, 10);
            }

        }
    }
}
