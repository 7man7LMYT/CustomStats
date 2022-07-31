package me.gamersclub.customstats.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaceholderManager  {
    static JavaPlugin plugin;
    @SuppressWarnings("CanBeFinal")
    boolean papiInstalled;

    public PlaceholderManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.papiInstalled = plugin.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    public String placeholderReplacer(Player player, String message) {
        //handle our own placeholders first
        message = message.replaceAll("%totalplayers%",totalPlayers()+"");
        message = message.replaceAll("%onlineplayers",onlinePlayers()+"");

        //handle PlaceholderAPI placeholders after our own
        if (papiInstalled) {
            message = PlaceholderAPI.setPlaceholders(player, message);
        }

        return message;
    }

    public int totalPlayers() {
        return plugin.getServer().getOfflinePlayers().length;
    }

    public int onlinePlayers() {
        return plugin.getServer().getOnlinePlayers().size();
    }
}
