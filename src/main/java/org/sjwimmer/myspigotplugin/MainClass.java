package org.sjwimmer.myspigotplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        this.getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);
        this.getCommand("init").setExecutor(new SimpleCommandHandler());
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
