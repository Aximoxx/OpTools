package fr.Aximoxx.opTools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Manager {

    public void Hammer3x3(Player p, Block block){
        ItemStack item = p.getInventory().getItemInMainHand();
        float pitch = p.getLocation().getPitch();

        BlockFace face;

        if (pitch <= -60) {
            face = BlockFace.UP;
        } else if (pitch >= 60) {
            face = BlockFace.DOWN;
        } else {
            face = p.getFacing();
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                Block relative = switch (face) {
                    case NORTH, SOUTH -> block.getRelative(i, j, 0);
                    case EAST, WEST   -> block.getRelative(0, j, i);
                    case UP, DOWN     -> block.getRelative(i, 0, j);
                    default           -> null;
                };

                if (relative == null) continue;
                if (relative.getType() == Material.BEDROCK) continue;

                relative.breakNaturally(item);
            }
        }
    }
}
