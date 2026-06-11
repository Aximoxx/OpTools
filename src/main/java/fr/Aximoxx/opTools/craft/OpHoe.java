package fr.Aximoxx.opTools.craft;

import fr.Aximoxx.opTools.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class OpHoe {

    public void opHoe(){
        ItemStack result = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta meta = result.getItemMeta();
        if (meta != null) meta.setLore(List.of("§7Cette Houe casse et replante les plantations dans un rayon de 3x3."));
        result.setItemMeta(meta);

        ShapedRecipe craft = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "opHoe"), result);

        craft.shape(
                "DN ",
                " S ",
                " S ");

        craft.setIngredient('D', Material.DIAMOND_BLOCK);
        craft.setIngredient('N', Material.NETHERITE_INGOT);
        craft.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(craft);
    }
}
