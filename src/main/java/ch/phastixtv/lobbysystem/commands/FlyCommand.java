package ch.phastixtv.lobbysystem.commands;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    private Lobbysystem lobbysystem;

    public FlyCommand(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("lobbysystem.fly")) {
                if (args.length == 0) {
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        sender.sendMessage(lobbysystem.getPrefix() + "§aDu kannst nun fliegen!");
                    } else {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        sender.sendMessage(lobbysystem.getPrefix() + "§cDu kannst nicht mehr fliegen!");
                    }
                } else
                    sender.sendMessage(lobbysystem.getUsage() + "/fly§c!");
            } else
                sender.sendMessage(lobbysystem.getNoPerm());
        }
        return false;
    }
}
