package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import ch.phastixtv.lobbysystem.util.configs.ConfigurationUtil;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetSpawnCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public SetSpawnCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.setspawn")) {
            if (args.length == 0) {
                Location locPlayer = player.getLocation();
                new ConfigurationUtil(JavaPlugin.getPlugin(Lobbysystem.class), locPlayer, "Spawn").saveLocation();
                sender.sendMessage(lobbysystem.getPrefix() + "Der §6Spawnpunkt §rwurde gesetzt!");

            } else
                sender.sendMessage(lobbysystem.getUsage() + "/setspawn §c!");
            } else
                sender.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
