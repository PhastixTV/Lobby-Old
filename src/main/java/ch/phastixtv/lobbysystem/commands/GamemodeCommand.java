package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public GamemodeCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0") && sender.hasPermission("lobbysystem.gamemode.survival")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(lobbysystem.getPrefix() + "Dein Spielmodus wurde auf §6Survival §rgeändert!");

                    } else if (args[0].equalsIgnoreCase("1") && sender.hasPermission("lobbysystem.gamemode.creative")) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(lobbysystem.getPrefix() + "Dein Spielmodus wurde auf §6Creative §rgeändert!");

                    } else if (args[0].equalsIgnoreCase("2") && sender.hasPermission("lobbysystem.gamemode.adventure")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(lobbysystem.getPrefix() + "Dein Spielmodus wurde auf §6Adventure §rgeändert!");

                    } else if (args[0].equalsIgnoreCase("3") && sender.hasPermission("lobbysystem.gamemode.spectator")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(lobbysystem.getPrefix() + "Dein Spielmodus wurde auf §6Spectator §rgeändert!");
                    } else
                        sender.sendMessage(lobbysystem.getNoPerm());
                } else
                sender.sendMessage(lobbysystem.getUsage() + "/gamemode 0 | 1 | 2 | 3 §c!");
        }
        return false;
    }
}
