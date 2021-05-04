package top.evanechecssss.weedding.utils.base.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBase<T> extends Container {
    private final boolean canInteractWith;
    private final boolean canTransferStack;
    private final T tileEntity;
    private int ContainerSize;

    public ContainerBase(InventoryPlayer inventoryPlayer, T tileEntity, boolean canInteractWith, boolean canTransferStack) {
        this.canInteractWith = canInteractWith;
        this.canTransferStack = canTransferStack;
        this.tileEntity = tileEntity;
    }

    public void addPlayerInventory(InventoryPlayer inventoryPlayer) {

    }


    public void addPlayerInventory(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isAbsolute, boolean isHorizontal) {

    }

    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer) {

    }


    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isAbsolute, boolean isHorizontal) {

    }

    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer) {

        for (int col = 0; col < 9; ++col) {
            this.addSlotToContainer(new Slot(inventoryPlayer, col, 6, 162));
        }
    }


    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isAbsolute, boolean isHorizontal) {

    }

    public void addContainerInventory() {

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return canInteractWith;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack item = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        ItemStack itemSlot = slot.getStack();
        if (!canTransferStack || slot == null || !slot.getHasStack()) {
            return item;
        }

        for (int i = 0; i < inventorySlots.size(); i++) {
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
