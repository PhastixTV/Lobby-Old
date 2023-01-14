package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public HealCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.heal")) {
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    sender.sendMessage(lobbysystem.getPrefix() + "§aDu wurdest geheilt!");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(lobbysystem.getPrefix() + "§aDu wurdest von §6" + player.getName() + " §ageheilt!");
                        player.sendMessage(lobbysystem.getPrefix() + "§aDer Spieler §6" + args[0] + " §awurde geheilt!");
                    } else
                        sender.sendMessage(lobbysystem.getPrefix() + "§cDer Spieler §6" + args[0] + " §cist nicht auf dem Server!");
                } else
                    sender.sendMessage(lobbysystem.getUsage() + "/heal §c!");
            } else
                sender.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
