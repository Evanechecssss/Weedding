package top.evanechecssss.weedding.utils.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import top.evanechecssss.weedding.Weedding;

public class ContainerBase<T extends IHasContainer> extends Container {
    private final boolean canInteractWith;
    private final boolean canTransferStack;
    public T entity;
    public InventoryPlayer inventoryPlayer;

    public ContainerBase(InventoryPlayer inventoryPlayer, T entity, boolean canInteractWith, boolean canTransferStack) {
        this.canInteractWith = canInteractWith;
        this.canTransferStack = canTransferStack;
        this.entity = entity;
        this.inventoryPlayer = inventoryPlayer;
    }

    public void addPlayerInventory(InventoryPlayer inventoryPlayer) {

    }


    public void addPlayerInventory(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer) {

    }


    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer) {
        for (int col = 0; col < 9; ++col) {
            int xPos = 7 + 18 * col;
            int yPos = 163;
            this.addSlotToContainer(new Slot(inventoryPlayer, col, xPos, yPos));
        }
    }


    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addContainerInventory() {

    }

    public void addContainerInventory(int cordX, int cordY, boolean isHorizontal) {

    }

    public void addContainerInventory(int SlotsX, int SlotsY, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addContainerInventory(int gapIdMin, int gapIdMax, int SlotsX, int SlotsY, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addContainerInventoryLine() {

    }

    public void addContainerInventoryLine(int SlotsX, int gapIdMin, int gapIdMax, int cordX, int cordY, boolean isHorizontal) {

    }

    public void addContainerSlot(int Id, int cordX, int cordY) {
        if (isIdExist(Id)) {
            this.addSlotToContainer(new SlotItemHandler(getInventoryEntity(), Id, cordX - 50, cordY));
        }
    }

    public ItemStackHandler getInventoryEntity() {
        return entity.getInventory();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return canInteractWith;
    }

    public void setItemInSlot(int Id, ItemStack item) {
        inventorySlots.get(Id).putStack(item);
    }

    public ItemStack getItemFromSlot(int Id) {
        return inventorySlots.get(Id).getStack();
    }

    private boolean idInRegion(int IdCount, int Max, int Min) {
        if (Max - Min > IdCount) {
            return true;
        } else {
            Weedding.logger.error("The selected region is too small".toUpperCase());
            return false;
        }
    }

    private boolean isIdExist(int Id) {
        if (Id <= entity.getInventoryMaxIndex()) {
            return true;
        } else {
            Weedding.logger.error(("such id is not available for the slot:" + Id).toUpperCase());
            return false;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack item = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        ItemStack itemSlot = slot.getStack();
        int size = entity.getInventoryMaxIndex();
        if (!canTransferStack || !slot.getHasStack()) {
            return item;
        }
        for (int i = size; i > 0; --i) {
            Slot iSlot = inventorySlots.get(i);
            if (!iSlot.getHasStack()) {
                iSlot.putStack(itemSlot);
                slot.putStack(item);
                break;
            }
        }
        return item;
    }


}
