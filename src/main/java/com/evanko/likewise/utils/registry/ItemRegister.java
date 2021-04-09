package com.evanko.likewise.utils.registry;

import com.evanko.likewise.init.LikewiseItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ItemRegister {

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> event) {
        for(int i =0;i< LikewiseItems.ITEMS.length;i++){
        event.getRegistry().register(LikewiseItems.ITEMS[i]);
        }
    }
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(LikewiseItems.ITEMS);
    }
    @SideOnly(Side.CLIENT)
    public static void registerModel(Item[] items){
        for (Item item : items) {
            ModelBakery.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
