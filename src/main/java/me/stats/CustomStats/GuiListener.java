package me.stats.CustomStats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GuiListener implements Listener {
    CustomStats customStats;
    public GuiListener(CustomStats customStats) {
        this.customStats = customStats;
    }
    @EventHandler
    public void clickevent(InventoryClickEvent e){
        if (customStats.opengui.get(e.getWhoClicked().getUniqueId()).equals(1)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        customStats.opengui.put(e.getPlayer().getUniqueId(), 0);
    }
}
