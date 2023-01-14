package ch.phastixtv.lobbysystem.listener;

import ch.phastixtv.lobbysystem.Lobbysystem;
import ch.phastixtv.lobbysystem.scoreboard.Scoreboard;
import ch.phastixtv.lobbysystem.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;


public class JoinListener implements Listener {

    private Lobbysystem lobbysystem;

    public JoinListener(Lobbysystem lobbysystem) {
        this.lobbysystem = lobbysystem;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.sendMessage(lobbysystem.getPrefix() + "§lWillkommen auf dem Server!");
        player.sendMessage("");
        ItemBuilder.setBuildLobbyItems(player);
        new Scoreboard(player);
    }
}
