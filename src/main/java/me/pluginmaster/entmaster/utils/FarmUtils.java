package me.pluginmaster.entmaster.utils;


import org.bukkit.Material;
import org.bukkit.block.Block;

import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.PlayerInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;




public class FarmUtils {

    //create a method to check what type of crop the block is, and if the crop is fully grown using getMaxAge() and getBlockData()
    public static boolean isFullyGrown(Block block) {
        //get the block's data
        BlockData data = block.getBlockData();
        //check if the block is a crop
        if (data instanceof Ageable) {
            //if it is, cast it to an Ageable
            Ageable crop = (Ageable) data;
            //check if the crop is fully grown
            if (crop.getAge() == crop.getMaximumAge()) {
                //if it is, return true
                return true;
            }
        }
        //if the block is not a crop, or if the crop is not fully grown, return false
        return false;
    }
    //create a new method to get what type of hoe the player is holding and return the material of the hoe. if it is not a hoe, return null.
    public static Material getHeldHoe(Player player) {
        //get the player's inventory
        PlayerInventory inventory = player.getInventory();
        //get the item in the player's main hand
        ItemStack item = inventory.getItemInMainHand();
        //check if the item is a hoe
        if (item.getType() == Material.WOODEN_HOE || item.getType() == Material.STONE_HOE || item.getType() == Material.IRON_HOE || item.getType() == Material.GOLDEN_HOE || item.getType() == Material.DIAMOND_HOE) {
            //if it is, return the item's material
            return item.getType();
        }
        //if the item is not a hoe, return null
        return null;
    }


        //create a new method that stores the drops of a crop type in an array and returns the array
    public static ItemStack[] getDrops(Block block, Player player) {
        //create a new array to store the drops
        int x = 0;
        PlayerInventory inventory1 = player.getInventory();
        ItemStack item1 = inventory1.getItemInMainHand();
        int y = item1.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        if (y ==0){ y=1;
        }
            switch( FarmUtils.getHeldHoe(player) ) {
                case WOODEN_HOE:
                     x = 1 * y ;
                    break;
                case STONE_HOE:
                     x= 2 * y ;
                    break;
                case IRON_HOE:
                     x = 2 * y;
                    break;
                case GOLDEN_HOE:
                     x=2 * y;
                    break;
                case DIAMOND_HOE:
                     x=3 * y;
                    break;

                default:
                    x=0;
                    break;
            }

            ItemStack[] drops = new ItemStack[2];
            //check what type of crop the block is
            if (block.getType() == Material.WHEAT) {
                //if it is wheat, set the drops array to the drops of wheat
                drops = new ItemStack[]{new ItemStack(Material.WHEAT, x), new ItemStack(Material.WHEAT_SEEDS, 1)};
            } else if (block.getType() == Material.CARROTS) {
                //if it is carrots, set the drops array to the drops of carrots
                drops = new ItemStack[]{new ItemStack(Material.CARROT, x), new ItemStack(Material.CARROT, 1)};
            } else if (block.getType() == Material.POTATOES) {
                //if it is potatoes, set the drops array to the drops of potatoes
                drops = new ItemStack[]{new ItemStack(Material.POTATO, x), new ItemStack(Material.POTATO, 1)};
            } else if (block.getType() == Material.BEETROOTS) {
                //if it is beetroots, set the drops array to the drops of beetroots
                drops = new ItemStack[]{new ItemStack(Material.BEETROOT, x), new ItemStack(Material.BEETROOT_SEEDS, 1)};
            } else if (block.getType() == Material.NETHER_WART) {
                //if it is nether wart, set the drops array to the drops of nether wart
                drops = new ItemStack[]{new ItemStack(Material.NETHER_WART, x)};
            }
            //return the drops array
            return drops;
        }

    }
