package top.evanechecssss.weedding.client.gui.base;

import net.minecraftforge.items.ItemStackHandler;

public interface IHasContainer {
    int size = 0;
    ItemStackHandler inventory = new ItemStackHandler(size);

    ItemStackHandler getInventory();

    int getInventorySize();

    int getInventoryMaxIndex();
}
