package com.github.anderrasovazquez.manhunt.listeners;

import com.github.anderrasovazquez.manhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CompassListener implements Listener {

    private Main plugin;

    public CompassListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void OnCompassRightClick(PlayerInteractEvent event) {
        if (!plugin.isHuntStarted() || event.getPlayer().getName().equals(plugin.getHunted())) {
            return;
        }

        Player hunter = event.getPlayer();
        ItemStack itemStackOnHand = event.getItem();
        if (itemStackOnHand == null) {
            return;
        }
        Material itemOnHand = itemStackOnHand.getType();
        Action act = event.getAction();

        if (itemOnHand == Material.COMPASS && (act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK)) {
            Player huntedPlayer = hunter.getServer().getPlayer(plugin.getHunted());
            hunter.setCompassTarget(huntedPlayer.getLocation());
            // hunter.sendMessage(ChatColor.GREEN + "Estás cazando a: " + huntedPlayer.getName());
        }
    }
}
