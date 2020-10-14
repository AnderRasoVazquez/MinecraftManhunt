package com.github.anderrasovazquez.manhunt.commands;

import com.github.anderrasovazquez.manhunt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ManhuntCommand implements CommandExecutor {

    private final String COMMAND_NAME = "manhunt";
    private Main plugin;

    public ManhuntCommand(Main plugin) {
        this.plugin = plugin;
        this.plugin.getCommand(COMMAND_NAME).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0) {
            this.plugin.stopHunt();
            return true;
        } else if (args.length == 1) {
            return this.plugin.setHunted(args[0]);
        } else {
            return false;
        }
    }
}
