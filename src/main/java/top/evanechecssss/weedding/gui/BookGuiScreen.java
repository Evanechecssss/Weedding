package top.evanechecssss.weedding.gui;

import com.google.gson.JsonArray;
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
import java.util.ArrayList;


public class BookGuiScreen extends GuiScreen {
    private static ResourceLocation locationTexture;
    private static ResourceLocation locationText;
    private int pageShiftX = 15;
    private int pageShiftY = 15;
    private int textShiftX = 0;
    private int textShiftY = 0;
    public GuiButton buttonNext;
    private int countShiftY = 6;
    private int Page = 0;
    public GuiButton buttonBack;
    private int WIDTH = 147;
    private int countShiftX = WIDTH / 2;
    private int wrapWidth = WIDTH - 25;
    private int HEIGHT = 181;
    private int MaxPage;
    public ArrayList<String> BookText = new ArrayList<String>();
    private float angle = 0;
    private boolean showCount = true;
    private boolean scaleDeformText = false;
    private boolean scaleDeformPage = false;
    private int countColor = 1;
    private float scaleDeformTextX;
    private float scaleDeformTextY;
    private float scaleDeformTextZ;
    private float scaleDeformPageX;
    private float scaleDeformPageY;
    private float scaleDeformPageZ;
    private boolean doesPause = true;

    public BookGuiScreen(ResourceLocation locationTexture, ResourceLocation locationText) {
        BookGuiScreen.locationTexture = locationTexture;
        BookGuiScreen.locationText = locationText;
        Parsing();
    }

    public BookGuiScreen(ResourceLocation locationTexture, ResourceLocation locationText, boolean showCount, float angle, int countColor) {
        BookGuiScreen.locationTexture = locationTexture;
        BookGuiScreen.locationText = locationText;
        this.angle = angle;
        this.countColor = countColor;
        this.showCount = showCount;
        Parsing();
    }


    private ArrayList<String> JsonParsing(IResourceManager resourceManager) throws IOException {
        ArrayList<String> pages = new ArrayList<String>();
        IResource resource = resourceManager.getResource(locationText);
        JsonArray JSONArray = new JsonParser().parse(IOUtils.toString(resource.getInputStream(), Charset.defaultCharset())).getAsJsonObject().get("pages").getAsJsonArray();
        MaxPage = JSONArray.size();
        MaxPage -= 1;
        for (int j = 0; j < JSONArray.size(); j++) {
            pages.add(JSONArray.get(j).getAsString());
        }
        return pages;
    }

    private void Parsing() {
        try {
            BookText = JsonParsing(Minecraft.getMinecraft().getResourceManager());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateButtons() {
        buttonBack.enabled = true;
        buttonNext.enabled = true;
        buttonBack.visible = true;
        buttonNext.visible = true;
        if (Page == MaxPage) {
            buttonNext.enabled = false;
            buttonNext.visible = false;
        }
        if (Page == 0) {
            buttonBack.enabled = false;
            buttonBack.visible = false;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1, 1, 1, 1);
        this.drawDefaultBackground();
        int centerX = (width - WIDTH) / 2;
        int centerY = (height - HEIGHT) / 2;
        GlStateManager.pushMatrix();
        {
            mc.renderEngine.bindTexture(locationTexture);
            if (scaleDeformPage) {
                GlStateManager.scale(scaleDeformPageX, scaleDeformPageY, scaleDeformPageZ);
            }

            drawTexturedModalRect(centerX, centerY, 0, 0, WIDTH, HEIGHT);
        }
        GlStateManager.popMatrix();

        if (showCount)
            fontRenderer.drawString(this.getCurrentPage() + "/" + this.getMaxPage(), centerX + countShiftX, centerY + countShiftY, countColor);

        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX + pageShiftX, centerY + pageShiftY, 0);
            GlStateManager.rotate(angle, 0, 0, 1);
            if (scaleDeformText) {
                GlStateManager.scale(scaleDeformTextX, scaleDeformTextY, scaleDeformTextZ);
            }
            fontRenderer.drawSplitString(BookText.get(this.Page), textShiftX, textShiftY, wrapWidth, countColor);
        }
        GlStateManager.popMatrix();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public BookGuiScreen setPage(int page) {
        Page = page;
        return this;
    }

    public BookGuiScreen setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
        return this;
    }

    public BookGuiScreen setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
        return this;
    }

    public BookGuiScreen setMaxPage(int maxPage) {
        MaxPage = maxPage;
        return this;
    }

    public BookGuiScreen setPageShiftX(int pageShiftX) {
        this.pageShiftX = pageShiftX;
        return this;
    }

    public BookGuiScreen setPageShiftY(int pageShiftY) {
        this.pageShiftY = pageShiftY;
        return this;
    }

    public BookGuiScreen setTextShiftX(int textShiftX) {
        this.textShiftX = textShiftX;
        return this;
    }

    public BookGuiScreen setTextShiftY(int textShiftY) {
        this.textShiftY = textShiftY;
        return this;
    }

    public BookGuiScreen setAngle(float angle) {
        this.angle = angle;
        return this;
    }

    public BookGuiScreen setCountShiftX(int countShiftX) {
        this.countShiftX = countShiftX;
        return this;
    }

    public BookGuiScreen setCountShiftY(int countShiftY) {
        this.countShiftY = countShiftY;
        return this;
    }

    public BookGuiScreen setWrapWidth(int wrapWidth) {
        this.wrapWidth = wrapWidth;
        return this;
    }

    public BookGuiScreen setDeformPage(float x, float y, float z) {
        this.scaleDeformPage = true;
        this.scaleDeformPageX = x;
        this.scaleDeformPageY = y;
        this.scaleDeformPageZ = z;
        return this;
    }

    public BookGuiScreen setDeformText(float x, float y, float z) {
        this.scaleDeformText = true;
        this.scaleDeformTextX = x;
        this.scaleDeformTextY = y;
        this.scaleDeformTextZ = z;
        return this;
    }

    public BookGuiScreen setDoesPause(boolean doesPause) {
        this.doesPause = doesPause;
        return this;
    }

    public BookGuiScreen addText(String text, int x, int y, int wrapWidth, int countColor) {
        this.fontRenderer.drawSplitString(text, x, y, wrapWidth, countColor);
        return this;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    private int getCurrentPage() {
        int number;
        number = Page;
        number++;
        return number;
    }

    private int getMaxPage() {
        int number;
        number = MaxPage;
        number++;
        return number;
    }


    @Override
    public void initGui() {
        this.buttonNext = this.addButton(new NextButton(0, (width - WIDTH) / 2 + WIDTH, (height - HEIGHT) / 2 + HEIGHT, "", true));
        this.buttonBack = this.addButton(new NextButton(1, (width - WIDTH) / 2, (height - HEIGHT) / 2 + HEIGHT, "", false));
        this.updateButtons();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return doesPause;
    }

    @Override
    public boolean handleComponentClick(ITextComponent component) {
        return true;
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.enabled) {
            if (button.id == 0) {
                this.Page += 1;
            } else if (button.id == 1) {
                this.Page -= 1;
            }
        }
        this.updateButtons();
    }

    @SideOnly(Side.CLIENT)
    private static class NextButton extends GuiButton {
        private final boolean isForward;

        public NextButton(int buttonId, int x, int y, String buttonText, boolean isForward) {
            super(buttonId, x, y, "");
            this.isForward = isForward;
            this.height = 10;
            this.width = 18;
        }


        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            if (this.visible) {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BookGuiScreen.locationTexture);
                int i = 151;
                int j = 10;
                if (!this.isForward) {
                    j += 13;
                }
                if (flag) {
                    i += 23;
                }
                this.drawTexturedModalRect(x, y, i, j, 18, 10);
            }

        }
    }
}
