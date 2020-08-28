package tmnt150.BackPack;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BPack implements Listener {
    @EventHandler
    public void onSetChest(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (event.getItem()!=null && event.getClickedBlock()!= null){
                if (event.getItem().getType().equals(Material.EMERALD)&&event.getClickedBlock().getType().equals(Material.CHEST)){
                    Block block =event.getClickedBlock();
                    ItemStack item = event.getItem();
                    ItemMeta meta = item.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(block.getX()+";"+block.getY()+";"+block.getZ());
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                }
            }
        }
    }
    @EventHandler
    public void playeropenChest(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if (event.getItem()!= null){
                if (event.getItem().getType().equals(Material.EMERALD)) {
                    if (event.getItem().getItemMeta() != null && event.getItem().getItemMeta().getLore() != null) {
                        List<String> lore = event.getItem().getItemMeta().getLore();
                        String[] loc =lore.get(0).split(";");
                        int x = Integer.parseInt(loc[0]);
                        int y = Integer.parseInt(loc[1]);
                        int z = Integer.parseInt(loc[2]);
                        BlockState blockState= event.getPlayer().getWorld().getBlockAt(x,y,z).getState();
                        Chest chest = (Chest) blockState;
                        event.getPlayer().openInventory(chest.getInventory());
                    }
                }
            }
        }
    }
}
