package ch.phastixtv.lobbysystem.util;

import ch.phastixtv.lobbysystem.Lobbysystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

        public static ItemStack createItem(Material id, String name, int ammount, String lore){
            ItemStack item = new ItemStack(id, ammount);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            List<String> list = new ArrayList<>();
            list.add(lore);
            meta.setLore(list);
            item.setItemMeta(meta);
            return item;

        }

        public static ItemStack createItemHead(Material id, String name, int amount, String lore, Player player){
            ItemStack itemStack = new ItemStack(id, amount);
            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
            skullMeta.setOwner(player.getName());
            skullMeta.setDisplayName(name);
            List<String> list = new ArrayList<>();
            list.add(lore);
            skullMeta.setLore(list);
            itemStack.setItemMeta(skullMeta);
            player.updateInventory();
            return itemStack;
        }

        public static ItemStack createItemLore(Material id, String name, int ammount, List<String> lore){
            ItemStack item = new ItemStack(id, ammount);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            List<String> list = new ArrayList<>();
            list.addAll(lore);
            meta.setLore(list);
            item.setItemMeta(meta);
            return item;
        }

        public static void setBuildLobbyItems(Player player) {
            ItemStack navigator = createItem(Material.COMPASS , "§aNavigator", 1, "§7● Rechtsclick zum benutzen");
            ItemStack head = createItemHead(Material.PLAYER_HEAD, "§aProfil", 1, "§7● Rechtclick zum benutzen", player);
            ItemStack nick = createItem(Material.NAME_TAG, "§aAutoNick", 1, "§7● Rechtsclick zum benutzen");

            player.getInventory().clear();
            player.setHealth(20);
            player.getInventory().setItem(7,head);
            player.getInventory().setItem(4, navigator);
            player.getInventory().setItem(8, nick);
        }
}
