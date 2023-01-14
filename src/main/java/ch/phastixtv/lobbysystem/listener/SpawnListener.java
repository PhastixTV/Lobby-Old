package ch.phastixtv.lobbysystem.listener;

import ch.phastixtv.lobbysystem.Lobbysystem;
import ch.phastixtv.lobbysystem.util.configs.ConfigurationUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnListener implements Listener {
    Location location = new ConfigurationUtil(JavaPlugin.getPlugin(Lobbysystem.class),"Spawn").loadLocation();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
;
        player.teleport(location);

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1L, 1L);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (location != null) {
            event.setRespawnLocation(location);
        }
    }
}
