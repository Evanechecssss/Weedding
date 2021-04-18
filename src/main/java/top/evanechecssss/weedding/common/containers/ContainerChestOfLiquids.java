package top.evanechecssss.weedding.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import top.evanechecssss.weedding.common.tileEntitys.ChestOfLiquidsTE;


public class ContainerChestOfLiquids extends Container {
    ChestOfLiquidsTE te;
    InventoryPlayer inventory;

    public ContainerChestOfLiquids(InventoryPlayer inventory, ChestOfLiquidsTE te) {
        this.te = te;
        this.inventory = inventory;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }


}
