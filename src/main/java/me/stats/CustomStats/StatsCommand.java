package me.stats.CustomStats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class StatsCommand implements CommandExecutor, TabExecutor {
    CustomStats customStats;
    public StatsCommand(CustomStats customStats) {
        this.customStats = customStats;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1){
                if (args[0].equals("reload")){
                    // Checks for permission
                    if (p.hasPermission("customstats.reload")){
                        customStats.reloadConfig();
                        customStats.saveConfig();
                        customStats.getConfig();
                        p.sendMessage(ChatColor.GREEN+"Configuration reloaded!");
                    }
                    else {
                        p.sendMessage(ChatColor.RED+"Usage: /stats");
                    }
                }
                else if (args[0].equals("gui")){
                    Inventory gui = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&', customStats.getConfig().getString("statsgui.title")));
                    for (int i = 1; i < 10; i++){
                        if (customStats.getConfig().contains("statsgui.item"+i)){
                            List<String> statsgui = customStats.getConfig().getStringList("statsgui.item"+i);
                            ItemStack item = new ItemStack(Material.valueOf(statsgui.get(0).toUpperCase()), 1);
                            if (item.getType() != Material.AIR){
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',statsgui.get(1)));
                                item.setItemMeta(meta);
                            }
                            gui.setItem(i-1, item);
                        }
                        else{
                            gui.clear(i-1);
                            i++;
                        }
                    }
                    p.openInventory(gui);
                    customStats.opengui.put(p.getUniqueId(), 1);
                }
                else {
                    p.sendMessage(ChatColor.RED+"Usage: /stats");
                }
            }
            if (args.length>1){
                p.sendMessage(ChatColor.RED+"Usage: /stats");
            }
            else if (args.length == 0){
                List<String> statcommand = customStats.getConfig().getStringList("statscommand");
                //color code is &
                for (int i = 0; i<statcommand.size(); i++){
                    p.sendMessage(ChatColor.translateAlternateColorCodes(('&'), statcommand.get(i)));
                }
            }
        }
        else{
            sender.sendMessage("This command does not work for console.");
        }
        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}
