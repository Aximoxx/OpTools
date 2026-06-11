package fr.Aximoxx.opTools.listener;

import fr.Aximoxx.opTools.Main;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class HoeBreak implements Listener {

    @EventHandler
    public void onHoeBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        Block block = e.getBlock();

        if (!item.hasItemMeta()) return;
        if (!item.getItemMeta().getLore().contains("§7Cette Houe casse et replante les plantations dans un rayon de 3x3.")) return;
        if (p.isSneaking()) return;

        Main.getInstance().getManager().breakAndReplant(p, block);
    }
}
