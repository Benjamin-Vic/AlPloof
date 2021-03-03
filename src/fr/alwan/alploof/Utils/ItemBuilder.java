package fr.alwan.alploof.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public static ItemStack create_item(Material material, String name) {
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return (itemStack);
    }
}
