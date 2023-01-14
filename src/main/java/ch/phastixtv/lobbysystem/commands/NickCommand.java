package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public NickCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.nick")) {
                if (args.length == 1) {
                    if (args[0].length() < 16) {
                        player.setDisplayName(args[0]);
                        player.setPlayerListName(args[0]);
                        sender.sendMessage(lobbysystem.getPrefix() + "Dein Nickname wurde geändert!");

                    } else if (args[0].equalsIgnoreCase("remove")) {
                        player.setDisplayName(player.getName());
                        player.setPlayerListName(player.getName());
                    } else
                        sender.sendMessage(lobbysystem.getUsage() + "/nick ... | remove §4!");
                }
                else
                    sender.sendMessage(lobbysystem.getUsage() + "/nick ... §4!");
            } else
                sender.sendMessage(lobbysystem.getNoPerm());
        } else
            sender.sendMessage(lobbysystem.getNoPerm());

        return false;
    }
}
