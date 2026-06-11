package fr.Aximoxx.opTools;

import fr.Aximoxx.opTools.customcraft.OpPickaxe;
import fr.Aximoxx.opTools.listener.HammerBreak;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;
    private OpPickaxe opPickaxe;
    private Manager manager;

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("§7Les items sont en cours de chargement...");
        opPickaxe = new OpPickaxe();
        opPickaxe.OpPickaxe();
        getLogger().info("§2Les items sont correctement chargé !");

        getServer().getPluginManager().registerEvents(new HammerBreak(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("§cPlus d'item op pour vous.");
    }

    public Manager getManager()      { return manager; }
    public static Main getInstance() { return instance; }
    public OpPickaxe getOpPickaxe()  { return opPickaxe; }
}
