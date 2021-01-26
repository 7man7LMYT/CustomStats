package me.stats.CustomStats;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

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
                    //checks for permission
                    if (p.hasPermission("customstats.reload")){
                        customStats.reloadConfig();
                        customStats.saveConfig();
                        customStats.getConfig();
                        p.sendMessage(ChatColor.BLUE+"Configuration reloaded!");
                    }
                    else{
                        p.sendMessage(ChatColor.RED+"Usage: /stats");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED+"Usage: /stats");
                }
            }
            if (args.length>1){
                p.sendMessage(ChatColor.RED+"Usage: /stats");
            }
            else if (args.length == 0){
                String statcommand = customStats.getConfig().getString("statcommand");
                //color code is &
                p.sendMessage(ChatColor.translateAlternateColorCodes(('&'), statcommand));
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
