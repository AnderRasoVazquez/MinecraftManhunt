package com.github.anderrasovazquez.manhunt;

import com.github.anderrasovazquez.manhunt.commands.ManhuntCommand;
import com.github.anderrasovazquez.manhunt.listeners.CompassListener;
import com.github.anderrasovazquez.manhunt.listeners.RespawnListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private String hunted = null;

    public String getHunted() {
        return hunted;
    }

    public boolean setHunted(String hunted) {
        if (Bukkit.getServer().getPlayer(hunted) != null) {
            this.hunted = hunted;
            return true;
        } else {
            return false;
        }
    }

    public void stopHunt() {
        hunted = null;
    }

    public boolean isHuntStarted() {
        return hunted != null;
    }


    @Override
    public void onEnable() {
        new ManhuntCommand(this);
        new CompassListener(this);
        new RespawnListener(this);
    }
}