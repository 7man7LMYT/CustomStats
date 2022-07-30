package me.gamersclub.customstats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;

public class GuiListener implements Listener {
    public GuiListener(CustomStats customStats) {
        this.customStats = customStats;
    }
    final CustomStats customStats;

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event){
        if (customStats.uuidsWithGuiOpen.contains(event.getWhoClicked().getUniqueId().toString())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose (@NotNull InventoryCloseEvent event){
        customStats.uuidsWithGuiOpen.remove(event.getPlayer().getUniqueId().toString());
    }
}
