package me.gamersclub.customstats;

import me.gamersclub.customstats.bStats.Metrics;
import me.gamersclub.customstats.util.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class CustomStats extends JavaPlugin {
    public final Logger log = this.getLogger();
    public boolean floodgateIsInstalled = false;
    public boolean placeholderAPIInstalled = false;
    @SuppressWarnings("CanBeFinal")
    List<String> uuidsWithGuiOpen = new ArrayList<>();

    public void onEnable() {
        log.info("CustomStats v2.0.0");

        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }

        floodgateIsInstalled = this.getServer().getPluginManager().isPluginEnabled("floodgate");
        if (floodgateIsInstalled) {
            log.info("Floodgate detected!");
        }

        placeholderAPIInstalled = this.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
        if (placeholderAPIInstalled) {
            log.info("PlaceholderAPI detected!");
        }

        log.info("Registering commands/events..");
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand(this));

        this.getServer().getPluginManager().registerEvents(new GuiListener(this), this);

        log.info("Starting Metrics..");
        Metrics metrics = new Metrics(this, 10123);

        log.info("Checking for a newer version..");
        new UpdateChecker(this, 88300).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                log.info("You are up to date! (v2.0.0)");
            } else {
                log.warning("There is a new update available!\n Download it at https://www.spigotmc.org/resources/88300/");
            }
        });

        log.info("Successfully started!");
    }
}
