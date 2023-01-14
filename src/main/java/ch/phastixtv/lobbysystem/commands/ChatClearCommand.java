package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public ChatClearCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("lobbysystem.chatclear")) {
                if (args.length == 0) {
                    for (int i = 0; i <= 1000; i++) {
                        Bukkit.broadcastMessage(" ");
                    }
                    Bukkit.broadcastMessage("§aDer Chat wurde von §6" + player.getName() + " §ageleert.");
                } else
                    player.sendMessage(lobbysystem.getUsage() + "/chatclear§c!");
            } else
                player.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
