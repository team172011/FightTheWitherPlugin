package org.sjwimmer.myspigotplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class PlayerEventHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        event.setJoinMessage("Welcome "+event.getPlayer().getName()+"!");
        event.getPlayer().getInventory().clear();
        event.getPlayer().setLevel(0);
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent event)
    {
        preparePlayer(event);
    }

    @EventHandler
    public void onPlayerSpawn(PlayerRespawnEvent event)
    {
        preparePlayer(event);
    }

    @EventHandler
    public void onNextLevelEvent(PlayerLevelChangeEvent playerLevelChangeEvent){
        if(playerLevelChangeEvent.getOldLevel() < playerLevelChangeEvent.getNewLevel()){
            preparePlayer(playerLevelChangeEvent);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent playerDeathEvent){
        playerDeathEvent.setKeepLevel(true);
    }

    private void preparePlayer(PlayerEvent event) {
        Player player = event.getPlayer();

        player.getInventory().clear();
        player.setLevel(0);
        Location location = player.getLocation();

        ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);
        diamond_sword.addEnchantment(Enchantment.DAMAGE_UNDEAD, 5);
        player.getInventory().addItem();
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
        player.getInventory().addItem(new ItemStack(Material.SHIELD));
        player.getInventory().addItem();

        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
        player.getInventory().addItem(bow);

        ItemStack arrows = new ItemStack(Material.ARROW);
        arrows.setAmount(arrows.getMaxStackSize());
        player.getInventory().addItem(arrows);
        player.getInventory().addItem(arrows);
        player.getInventory().addItem(arrows);

        ItemStack wither_skeleton_heads = new ItemStack(Material.WITHER_SKELETON_SKULL);
        wither_skeleton_heads.setAmount(3);
        player.getInventory().addItem(wither_skeleton_heads);

        ItemStack soulsand = new ItemStack(Material.SOUL_SAND);
        soulsand.setAmount(5);
        player.getInventory().addItem(soulsand);

        ItemStack golden_carrots = new ItemStack(Material.GOLDEN_CARROT);
        golden_carrots.setAmount(golden_carrots.getMaxStackSize());
        player.getInventory().addItem(golden_carrots);
        player.getWorld().getBlockAt(location.add(1,1,0)).setType(Material.DIAMOND_BLOCK);
    }
}
