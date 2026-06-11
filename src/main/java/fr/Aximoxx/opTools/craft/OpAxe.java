package fr.Aximoxx.opTools.craft;

import fr.Aximoxx.opTools.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class OpAxe {

    public void opAxe(){
        ItemStack result = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = result.getItemMeta();
        if (meta != null) meta.setLore(List.of("§7Cette hâche peut casser un arbre entier."));
        result.setItemMeta(meta);

        ShapedRecipe craft = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "opAxe"), result);

        craft.shape(
                "ND ",
                "DS ",
                " S ");

        craft.setIngredient('D', Material.DIAMOND_BLOCK);
        craft.setIngredient('N', Material.NETHERITE_INGOT);
        craft.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(craft);
    }
}
