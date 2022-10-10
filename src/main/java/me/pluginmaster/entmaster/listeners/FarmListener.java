package me.pluginmaster.entmaster.listeners;

import me.pluginmaster.entmaster.utils.FarmUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FarmListener implements Listener {
    @EventHandler
    public void onPlayerFarm(PlayerInteractEvent event) {
    //get the player
    Player player = event.getPlayer();
    //get the block
    Block block = event.getClickedBlock();
    //check if the block is fully grown
    if (FarmUtils.isFullyGrown(block)) {

        //if it is, break the block
        if (FarmUtils.getHeldHoe(player) != null) {
            //get the drops for the block
            ItemStack[] drops = FarmUtils.getDrops(block, player);
            //drop the items
            for (ItemStack item : drops) {
                block.getWorld().dropItemNaturally(block.getLocation(), item);
            }
        }
        block.setType(Material.AIR);
    }
}

    @EventHandler
    public void onPlayerTrample(PlayerInteractEvent event) {
        if (event.getClickedBlock().getType() == Material.FARMLAND && event.getAction() == Action.PHYSICAL && event.getPlayer().hasPermission("entmaster.trample")) {
            event.setCancelled(true);
        }
    }
}
