package top.evanechecssss.weedding.client.gui.base;

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
    public ItemStackHandler inventoryContainer;

    public ContainerBase(InventoryPlayer inventoryPlayer, T entity, boolean canInteractWith, boolean canTransferStack) {
        this.canInteractWith = canInteractWith;
        this.canTransferStack = canTransferStack;
        this.entity = entity;
        this.inventoryPlayer = inventoryPlayer;
        this.inventoryContainer = entity.getInventory();
    }

    public void addPlayerInventory(InventoryPlayer inventoryPlayer) {
        this.addPlayerInventorySlots(inventoryPlayer);
        this.addPlayerInventoryBar(inventoryPlayer);
    }


    public void addPlayerInventory(InventoryPlayer inventoryPlayer, int cordX, int cordY, int shift, boolean isHorizontal) {

        for (int col = 0; col < 9; ++col) {
            int xPos = cordX + 18 * col;
            if (isHorizontal) this.addSlotToContainer(new Slot(inventoryPlayer, col, xPos, cordY + shift));
            else this.addSlotToContainer(new Slot(inventoryPlayer, col, cordY + shift, xPos));
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                int x = cordX + j1 * 18;
                int y = cordY + l * 18;
                if (isHorizontal) this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, x, y));
                else this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, y, x));
            }
        }
    }

    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer) {
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, 7 + j1 * 18, 105 + l * 18));
            }
        }

    }

    public void addPlayerInventorySlots(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isHorizontal) {
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                int x = cordX + j1 * 18;
                int y = cordY + l * 18;
                if (isHorizontal) {
                    this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, x, y));
                } else {
                    this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, y, x));
                }

            }
        }
    }

    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer) {
        for (int col = 0; col < 9; ++col) {
            int xPos = 7 + 18 * col;
            int yPos = 163;
            this.addSlotToContainer(new Slot(inventoryPlayer, col, xPos, yPos));
        }
    }


    public void addPlayerInventoryBar(InventoryPlayer inventoryPlayer, int cordX, int cordY, boolean isHorizontal) {
        for (int col = 0; col < 9; ++col) {
            int xPos = cordX + 18 * col;
            if (isHorizontal) {
                this.addSlotToContainer(new Slot(inventoryPlayer, col, xPos, cordY));
            } else {
                this.addSlotToContainer(new Slot(inventoryPlayer, col, cordY, xPos));
            }
        }
    }

    public void addContainerInventory() {

        for (int col = 0; col < 9; ++col) {
            int xPos = 7 + 18 * col;
            int yPos = 163;
            if (isIdExist(col)) {
                this.addSlotToContainer(new SlotItemHandler(inventoryContainer, col, xPos, yPos));
            }
        }
        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                if (isIdExist(j1 + l * 9 + 9)) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, 7 + j1 * 18, 105 + l * 18));}
            }
        }
    }

    public void addContainerInventory(int slotIdMin, int slotIdMax, int slotsRow,int slotsColumn ,int cordX, int cordY, int shift ,boolean isHorizontal) {
        for (int col = slotIdMin; col < slotIdMin+slotsRow; ++col) {
            int xPos = cordX + 18 * col;
            if (isIdExist(col)) {
                if (isHorizontal) {
                    this.addSlotToContainer(new SlotItemHandler(inventoryContainer, slotIdMin + col, xPos, cordY + shift));
                } else {
                    this.addSlotToContainer(new SlotItemHandler(inventoryContainer, slotIdMin + col, cordY+shift, xPos));
                }
            }
        }

        for (int l = 0; l < slotsColumn; ++l) {
            for (int j1 = slotIdMin; j1 < slotIdMin+slotsRow; ++j1) {
                int x = cordX + j1 * 18;
                int y = cordY + l * 18;
                if (isIdExist(j1 + l * 9 + 9)) {
                if (isHorizontal) this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, x, y));
                else this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, y, x));
                }
            }
        }
    }


    public void addContainerInventoryLine(int slotIdMin, int slotIdMax, int cordX, int cordY, boolean isHorizontal) {
        for (int col = 0; col < slotIdMax - slotIdMin + 1; ++col) {
            int xPos = cordX + 18 * col;
            if (isIdExist(slotIdMin + col)) {
                if (isHorizontal) {
                    this.addSlotToContainer(new SlotItemHandler(inventoryContainer, slotIdMin + col, xPos, cordY));
                } else {
                    this.addSlotToContainer(new SlotItemHandler(inventoryContainer, slotIdMin + col, cordY, xPos));
                }
            }
        }
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
