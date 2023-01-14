package ch.phastixtv.lobbysystem.util;

import ch.phastixtv.lobbysystem.Lobbysystem;
import ch.phastixtv.lobbysystem.util.configs.ConfigurationUtil;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Navigator implements Listener {

    Location location = new ConfigurationUtil(JavaPlugin.getPlugin(Lobbysystem.class),"Spawn").loadLocation();

    private final String GUI_NAME = "§eWarpmenü";

    public void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 5, GUI_NAME);
        //Inventoryitems
        inventory.setItem(22, new ItemStack(Material.BEACON));
        player.openInventory(inventory);
    }

    @EventHandler
    public void onNavigator(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction(); //Unötig
        if (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) return;
        if (event.getItem().getType() != Material.COMPASS) return;
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) openGUI(player);

    }

    @EventHandler
    public void onNavigatorGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getCurrentItem() == null) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case BEACON:
                    player.teleport(location);

                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1L, 1L);

                    break;
            }
        }
    }
}
