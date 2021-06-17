package me.gavin.notorious.util;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;

public class InventoryUtil {

    private static Boolean found = false;
    private static int i;

    public static void checkSlots(Item item) {
        for(i = 9; i <= 36; i++) {
            if(Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem().equals(item)) {
                found = true;
                break;
            }
        }
    }

    public static void moveItemToSlot(Integer startSlot, Integer endSlot) {
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.inventoryContainer.windowId, startSlot, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.inventoryContainer.windowId, endSlot, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
    }
}
