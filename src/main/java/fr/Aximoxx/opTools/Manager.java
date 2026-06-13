package fr.Aximoxx.opTools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class Manager {

    public void Hammer3x3(Player p, Block block){
        ItemStack item = p.getInventory().getItemInMainHand();
        float pitch = p.getLocation().getPitch();

        BlockFace face;

        if (pitch <= -40) {
            face = BlockFace.UP;
        } else if (pitch >= 40) {
            face = BlockFace.DOWN;
        } else face = p.getFacing();

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {

                Block relative = switch (face) {
                    case NORTH, SOUTH -> block.getRelative(x, z, 0);
                    case EAST, WEST   -> block.getRelative(0, z, x);
                    case UP, DOWN     -> block.getRelative(x, 0, z);
                    default           -> null;
                };

                if (relative == null) continue;
                if (relative.getType() == Material.BEDROCK) continue;

                relative.breakNaturally(item);
            }
        }
    }

    public void breakAndReplant(Player p, Block block) {
        ItemStack item = p.getInventory().getItemInMainHand();

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {

                Block b = block.getRelative(x, 0, z);
                Material type = b.getType();

                if (type != Material.WHEAT && type != Material.CARROTS &&
                        type != Material.POTATOES && type != Material.BEETROOTS) continue;

                ItemStack seed = switch (type) {
                    case WHEAT -> new ItemStack(Material.WHEAT_SEEDS);
                    case CARROTS -> new ItemStack(Material.CARROT);
                    case POTATOES -> new ItemStack(Material.POTATO);
                    case BEETROOTS -> new ItemStack(Material.BEETROOT_SEEDS);
                    default -> null;
                };

                b.breakNaturally(item);

                if (seed == null) continue;
                if (!p.getInventory().containsAtLeast(seed, 1)) continue;

                p.getInventory().removeItem(seed);
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> b.setType(type), 1L);
            }
        }
    }

    public void breakTree(Block block, ItemStack item) {
        if (!block.getType().toString().contains("LOG")) return;

        block.breakNaturally(item);

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Block relative = block.getRelative(x, y, z);

                    if (relative.getType().toString().contains("LOG")) breakTree(relative, item);
                }
            }
        }
    }
}
