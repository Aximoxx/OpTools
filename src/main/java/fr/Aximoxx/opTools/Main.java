package fr.Aximoxx.opTools;

import fr.Aximoxx.opTools.craft.OpAxe;
import fr.Aximoxx.opTools.craft.OpHoe;
import fr.Aximoxx.opTools.craft.OpPickaxe;
import fr.Aximoxx.opTools.listener.AxeBreak;
import fr.Aximoxx.opTools.listener.HammerBreak;
import fr.Aximoxx.opTools.listener.HoeBreak;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private OpAxe opAxe;
    private OpHoe opHoe;
    private Manager manager;
    private OpPickaxe opPickaxe;
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        manager = new Manager();

        registerClasses();

        getServer().getPluginManager().registerEvents(new HoeBreak(), this);
        getServer().getPluginManager().registerEvents(new AxeBreak(), this);
        getServer().getPluginManager().registerEvents(new HammerBreak(), this);
    }

    private void registerClasses(){
        getLogger().info("§7Début de l'enregistrement des classes...");

        opAxe = new OpAxe();
        opHoe = new OpHoe();
        opPickaxe = new OpPickaxe();

        getLogger().info("§2Les classes sont chargées.");

        try {
            registerCrafts();
        }catch (IllegalStateException e){ getLogger().severe("§cNan, tu t'es trumpé. §f" + e.getMessage()); }
    }

    private void registerCrafts(){
        getLogger().info("§7Début de l'enregistrement des crafts...");

        opAxe.opAxe();
        opHoe.opHoe();
        opPickaxe.opPickaxe();

        getLogger().info("§2Les crafts sont correctement chargé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("§cPlus d'item op pour vous.");
    }

    public OpAxe getOpAxe()          { return opAxe; }
    public OpHoe getOpHoe()          { return opHoe; }
    public Manager getManager()      { return manager; }
    public static Main getInstance() { return instance; }
    public OpPickaxe getOpPickaxe()  { return opPickaxe; }
}
