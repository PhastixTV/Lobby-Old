package ch.phastixtv.lobbysystem;

import ch.phastixtv.lobbysystem.commands.*;
import ch.phastixtv.lobbysystem.listener.JoinListener;
import ch.phastixtv.lobbysystem.listener.SpawnListener;
import ch.phastixtv.lobbysystem.util.Navigator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobbysystem extends JavaPlugin {


    private static Lobbysystem plugin;

    private final String prefix = "§b§lTest-Server §7» §r",
                         noPerm = prefix + "§cDazu hast du keine Rechte",
                        usage = prefix + "§cBitte benutze §6";


    @Override
    public void onEnable() {
        plugin = this;

    initCommand();
    initListener(Bukkit.getPluginManager());
    saveConfig();
    }

    //getter
    @Override
    public void onDisable() {

    }

    public void initCommand() {
        getCommand("gamemode").setExecutor(new GamemodeCommand(this));
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("day").setExecutor(new DayCommand(this));
        getCommand("night").setExecutor(new NightCommand(this));
        getCommand("chatclear").setExecutor(new ChatClearCommand(this));
        getCommand("nick").setExecutor(new NickCommand(this));
    }

    public void initListener(PluginManager pluginManager) {
        pluginManager.registerEvents(new JoinListener(this), this);
        pluginManager.registerEvents(new Navigator(), this);
        pluginManager.registerEvents(new SpawnListener(), this);
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerm() {
        return noPerm;
    }

    public String getUsage() {
        return usage;
    }

    public static Lobbysystem getPlugin() {
        return plugin;
    }
}
