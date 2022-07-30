package me.gamersclub.customstats.menus;

import me.gamersclub.customstats.util.PlaceholderManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.cumulus.component.LabelComponent;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.floodgate.api.FloodgateApi;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StatForm {
    @SuppressWarnings("CanBeFinal")
    private CustomForm.Builder statForm = CustomForm.builder();

    public StatForm(@NotNull JavaPlugin plugin, @NotNull PlaceholderManager pManager, @NotNull Player player) {
        String title = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("stats.stat-form.title")));
        List<String> content = Objects.requireNonNull(plugin.getConfig().getStringList("stats.stat-form.content"));

        statForm.component(LabelComponent.of(title));

        for (String message : content) {
            message = pManager.placeholderReplacer(player, message);
            statForm.component(LabelComponent.of(ChatColor.translateAlternateColorCodes('&', message)));
        }

        statForm.build();
    }

    public void sendStatForm(@NotNull UUID uuid) {
        FloodgateApi.getInstance().getPlayer(uuid).sendForm(statForm);
    }
}
