package me.stats.CustomStats;

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
            Player player = (Player) sender;
{
                    player.sendMessage( "If you see this it worked!" );
                }
            }
        else {
            sender.sendMessage("This command does not work in console.");
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}
