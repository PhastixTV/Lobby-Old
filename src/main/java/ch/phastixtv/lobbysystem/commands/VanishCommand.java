package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class VanishCommand implements CommandExecutor {

    public Lobbysystem lobbysystem;

    public VanishCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.cmd.vanish")) {
                if (args.length == 0) {
                    if (!player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                        player.getPotionEffect(PotionEffectType.INVISIBILITY);
                        player.sendMessage(lobbysystem.getPrefix() + "&aDu bist nun unsichbar!");
                    } else {
                        player.getPotionEffect(null);
                        player.sendMessage(lobbysystem.getPrefix() + "&aDu bist nun nicht mehr unsichtbar!");
                    }
                } else
                    player.sendMessage(lobbysystem.getUsage() + "/vanish");
            } else
                player.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
