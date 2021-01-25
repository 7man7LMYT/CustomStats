package me.stats.CustomStats;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.logging.Logger;

public class CustomStats extends JavaPlugin {
    private Logger console;
    public final HashMap<Player, GameMode> gamemodelist = new HashMap<>();
    public final HashMap<Player, Integer> taskidlist = new HashMap<>();
    public void onEnable() {
        getCommand("stats").setExecutor(new StatsCommand(this));
        console = getLogger();

        console.info("Loading configuration...");
        saveDefaultConfig();
        console.info("Configuration loaded.");
		
        console.info("Checking for a newer version.");
        new UpdateChecker(this, 88300).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                console.info("Your up to date!");
            } else {
                console.info("There is a new update available. Download it at https://www.spigotmc.org/resources/customstats.88300/.");
            }
        });

        console.info("Successfully started!");
    }
}
