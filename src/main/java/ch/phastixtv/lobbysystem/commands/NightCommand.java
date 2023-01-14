package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.server.BroadcastMessageEvent;

public class NightCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public NightCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.night")) {
                if (args.length == 0) {
                    player.getLocation().getWorld().setTime(13000);
                    Bukkit.broadcastMessage(lobbysystem.getPrefix() + "Der Spieler §6" + player.getName() + " §rhat die Zeit auf Nacht gesetzt!");
                } else
                    sender.sendMessage(lobbysystem.getUsage() + "/night§c!");
            } else
                sender.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
