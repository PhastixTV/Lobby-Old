package ch.phastixtv.lobbysystem.scoreboard;

import ch.phastixtv.lobbysystem.Lobbysystem;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Scoreboard extends ScoreboardBuilder{

    public Scoreboard(Player player) {
        super(player, "NeytMine");
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.DARK_GRAY.toString() + "----------------",12 );
        setScore("§x",10);
        setScore(ChatColor.GRAY.toString() + "Dein Rang:",11 );
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
            String prefix = user.getCachedData().getMetaData().getPrefix();
            setScore(prefix, 10);
        }
        setScore(ChatColor.GRAY.toString() + "Spieler:", 9);
        for (Player contester : Bukkit.getOnlinePlayers()) {
            setScore(ChatColor.GRAY.toString() + contester + "§7/§a100", 8);
        }
        setScore("§c", 7);
        setScore(ChatColor.GRAY.toString() + "Coins:",6 );
        setScore(ChatColor.GREEN.toString() + "1",5 );
        setScore("§l",4 );
        setScore(ChatColor.GRAY.toString() + "Unsere Website:", 3);
        setScore(ChatColor.AQUA.toString() + "in wartung", 2);
        setScore("§u", 1);
        setScore(ChatColor.DARK_GRAY.toString() + "-----------------",0 );

    }

    @Override
    public void update() {

    }
}
