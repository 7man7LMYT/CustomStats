package me.stats.CustomStats;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class CustomStats extends JavaPlugin {
    private Logger console;
    public void onEnable() {
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand(this));
        console = getLogger();
        console.info("Loading config.");
        saveDefaultConfig();
        console.info("Config loaded!");
        console.info("Checking for a newer version.");
        new UpdateChecker(this, 88300).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                console.info("You are up to date! (v1.1.0)");
            } else {
                console.info("There is a new update available. Download it at https://www.spigotmc.org/resources/customstats.88300/!");
            }
        });
        console.info("Successfully started!");
    }
}
