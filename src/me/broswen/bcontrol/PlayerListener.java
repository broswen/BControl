package me.broswen.bcontrol;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener{
	public static BControl plugin;
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		plugin = BControl.plugin;
		FileConfiguration config = plugin.getConfig();
		boolean displayWarnMessages = config.getBoolean("display-warn-messages");
		
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK){
			return;
		}
		
		if(event.getClickedBlock().getType() == Material.CHEST){
			if(!player.hasPermission("bcontrol.chest")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use chests!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.FURNACE){
			if(!player.hasPermission("bcontrol.furnace")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use furnaces!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.WORKBENCH){
			if(!player.hasPermission("bcontrol.workbench")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use workbenches!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.ENDER_CHEST){
			if(!player.hasPermission("bcontrol.enderchest")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use ender chests!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.ANVIL){
			if(!player.hasPermission("bcontrol.anvil")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use anvils!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE){
			if(!player.hasPermission("bcontrol.enchantmenttable")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use enchanting tables!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.JUKEBOX){
			if(!player.hasPermission("bcontrol.jukebox")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use jukeboxes!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.NOTE_BLOCK){
			if(!player.hasPermission("bcontrol.noteblock")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use noteblocks!");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.TRAPPED_CHEST){
			if(!player.hasPermission("bcontrol.trappedchest")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use trapped chests");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.DISPENSER){
			if(!player.hasPermission("bcontrol.dispenser")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use dispensers");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.DROPPER){
			if(!player.hasPermission("bcontrol.dropper")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use droppers");
				}
				
				event.setCancelled(true);
				return;
			}
		}
		
		if(event.getClickedBlock().getType() == Material.HOPPER){
			if(!player.hasPermission("bcontrol.hopper")){
				if(displayWarnMessages){
					player.sendMessage(plugin.prefix + "You are not allowed to use hoppers");
				}
				
				event.setCancelled(true);
				return;
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		plugin = BControl.plugin;
		FileConfiguration config = plugin.getConfig();
		boolean displayWarnMessages = config.getBoolean("display-warn-messages");
		
		if(!player.hasPermission("bcontrol.destroy")){
			if(displayWarnMessages){
				player.sendMessage(plugin.prefix + "You are not allowed to break blocks!");
			}
			
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		plugin = BControl.plugin;
		FileConfiguration config = plugin.getConfig();
		boolean displayWarnMessages = config.getBoolean("display-warn-messages");
		
		if(!player.hasPermission("bcontrol.build")){
			if(displayWarnMessages){
				player.sendMessage(plugin.prefix + "You are not allowed to place blocks!");
			}
			
			event.setCancelled(true);
		}
	}
}
