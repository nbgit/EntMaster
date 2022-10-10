package me.pluginmaster.entmaster;

import me.pluginmaster.entmaster.commands.CommandTrample;
import me.pluginmaster.entmaster.listeners.FarmListener;

import org.bukkit.plugin.java.JavaPlugin;



    //creates a new class that listens for when a player clicks a block and if the farmutils.isfullygrown method returns true, it will break the block and use the getDrops method to get the drops for the block and naturally drop them.
public class EntMaster extends JavaPlugin{
        @Override
        public void onEnable() {
            getServer().getPluginManager().registerEvents(new FarmListener(), this);
            this.getCommand("trample").setExecutor(new CommandTrample());
        }

        @Override
        public void onDisable() {
            getLogger().info("EntMaster has been disabled!");
        }



    }
