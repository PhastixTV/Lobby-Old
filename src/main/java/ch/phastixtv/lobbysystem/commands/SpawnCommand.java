package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import ch.phastixtv.lobbysystem.util.configs.ConfigurationUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnCommand implements CommandExecutor {

    Location location = new ConfigurationUtil(JavaPlugin.getPlugin(Lobbysystem.class),"Spawn").loadLocation();

    private Lobbysystem lobbysystem;

    public SpawnCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.teleport(location);

                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1L, 1L);

            } else
                sender.sendMessage(lobbysystem.getUsage() + "/spawn §c!");
        }
        return false;
    }
}
