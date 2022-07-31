package me.gamersclub.customstats;

import me.gamersclub.customstats.util.PlaceholderManager;
import me.gamersclub.customstats.menus.StatForm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.floodgate.api.FloodgateApi;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatsCommand implements CommandExecutor, TabExecutor {
    private final boolean floodgate;
    final CustomStats customStats;
    final PlaceholderManager placeholderManager;
    @SuppressWarnings("CanBeFinal")
    List<Integer> valid = new ArrayList<>();

    public StatsCommand(CustomStats customStats) {
        this.customStats = customStats;
        this.floodgate = customStats.floodgateIsInstalled;
        this.placeholderManager = new PlaceholderManager(customStats);

        valid.add(9);
        valid.add(18);
        valid.add(27);
        valid.add(36);
        valid.add(45);
        valid.add(54);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String alias, String @NotNull [] args) {
        if (args.length == 0) {
            if (sender instanceof ConsoleCommandSender) {
                List<String> statCommand = customStats.getConfig().getStringList("stats.stat-command");

                //color code is &
                for (String s : statCommand) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes(('&'), placeholderManager.placeholderReplacer(null, s)));
                }
            } else {
                List<String> statCommand = customStats.getConfig().getStringList("stats.stat-command");

                //color code is &
                for (String s : statCommand) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes(('&'), placeholderManager.placeholderReplacer((Player) sender, s)));
                }
            }

        } else {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("customstats.reload")) {
                    customStats.reloadConfig();
                    customStats.getConfig();
                    sender.sendMessage(ChatColor.GREEN + "Configuration reloaded!");
                } else {
                    sender.sendMessage(ChatColor.RED + "Usage: /stats (menu)");
                }
            } else if (args[0].equalsIgnoreCase("menu")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (floodgate) {
                        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
                            StatForm statForm = new StatForm(customStats, placeholderManager, player);
                            statForm.sendStatForm(player.getUniqueId());
                            return true;
                        }
                    }

                    String title =  Objects.requireNonNull(customStats.getConfig().getString("stats.stat-menu.title"));
                    int size = customStats.getConfig().getInt("stats.stat-menu.menu-size");
                    if (!valid.contains(size)) {
                        customStats.log.warning(size + " is not a valid multiple of 9!");
                        sender.sendMessage(ChatColor.RED + "An internal issue occurred while running this command.");
                        return true;
                    }

                    Inventory inventory = Bukkit.createInventory(player, size, ChatColor.translateAlternateColorCodes('&', title));

                    for (int i = 0; i < size; i++) {
                        if (customStats.getConfig().contains("stats.stat-menu.items." + i)) {
                            List<String> statsGui = customStats.getConfig().getStringList("stats.stat-menu.items." + i);

                            ItemStack item = new ItemStack(Material.valueOf(statsGui.get(0).toUpperCase()), 1);

                            //set item to name if not air
                            if (item.getType() != Material.AIR) {
                                ItemMeta itemMeta = item.getItemMeta();
                                String name = placeholderManager.placeholderReplacer(player, statsGui.get(1));

                                assert itemMeta != null;
                                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

                                if (statsGui.size() > 2) {
                                    List<String> lore = new ArrayList<>();
                                    for (int l = 2; l < statsGui.size(); l++) {
                                        lore.add(ChatColor.translateAlternateColorCodes('&',placeholderManager.placeholderReplacer(player, statsGui.get(l))));
                                    }
                                    itemMeta.setLore(lore);
                                }

                                item.setItemMeta(itemMeta);
                            }
                            inventory.setItem(i, item);
                        } else {
                            inventory.clear(i);
                        }
                    }

                    player.openInventory(inventory);
                    customStats.uuidsWithGuiOpen.add(player.getUniqueId().toString());
                } else {
                    sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /stats (menu)");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] strings) {
        List<String> completions = new ArrayList<>();
        completions.add("menu");

        if (sender.hasPermission("customstats.reload")) {
            completions.add("reload");
        }
        return completions;
    }
}
