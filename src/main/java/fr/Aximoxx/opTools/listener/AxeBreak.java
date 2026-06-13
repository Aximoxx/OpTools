package fr.Aximoxx.opTools.listener;

import fr.Aximoxx.opTools.Main;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AxeBreak implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        Block block = e.getBlock();

        if (!item.hasItemMeta() || !item.getItemMeta().hasLore()) return;
        if (!item.getItemMeta().getLore().contains("§7Cette hâche peut casser un arbre entier.")) return;
        if (p.isSneaking()) return;

        Main.getInstance().getManager().breakTree(block, item);
    }
}
