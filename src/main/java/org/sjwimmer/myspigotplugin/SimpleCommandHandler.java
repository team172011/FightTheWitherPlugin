package org.sjwimmer.myspigotplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SimpleCommandHandler implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player sendingPlayer = (Player) sender;
            ItemStack diamonds = new ItemStack(Material.DIAMOND_BLOCK);
            ItemStack oak_planks = new ItemStack(Material.OAK_PLANKS);
            ItemStack cobblestones = new ItemStack(Material.COBBLESTONE);
            ItemStack coal = new ItemStack(Material.COAL_BLOCK);
            diamonds.setAmount(diamonds.getMaxStackSize());
            oak_planks.setAmount(oak_planks.getMaxStackSize());
            cobblestones.setAmount(cobblestones.getMaxStackSize());
            coal.setAmount(coal.getMaxStackSize());
            sendingPlayer.getInventory().addItem(diamonds, oak_planks, cobblestones, coal);
            return true;
        }

        return false;
    }
}
