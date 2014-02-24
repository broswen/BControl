package me.broswen.bcontrol;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BControl extends JavaPlugin{
	public static BControl plugin;
	public final PlayerListener playerlistener = new PlayerListener();
	public String prefix = ChatColor.RED.toString() + ChatColor.BOLD + "[BControl] " + ChatColor.RESET;
	
	public void onEnable(){
		this.plugin = this;
		loadConfig();
		getServer().getPluginManager().registerEvents(this.playerlistener, this);
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		PluginDescriptionFile pdfFile = this.getDescription();
		
		if(cmd.getName().equalsIgnoreCase("bcontrol")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(args.length == 1){
					
					if(args[0].equalsIgnoreCase("info")){
						if(!player.hasPermission("bcontrol.info")){
							player.sendMessage(prefix + "You dont have permission!");
							return true;
						}
						
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "====== BControl ======");
						player.sendMessage("Version: " + pdfFile.getVersion());
						player.sendMessage("Author: " + pdfFile.getAuthors());
						player.sendMessage("About: " + pdfFile.getDescription());
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "====== BControl ======");
						return true;
					}
					
					if(args[0].equalsIgnoreCase("reload")){
						if(!player.hasPermission("bcontrol.reload")){
							player.sendMessage(prefix + "You dont have permission!");
							return true;
						}
						
						player.sendMessage(prefix + "The plugin was reloaded!");
						reloadConfig();
						return true;
					}
					
					player.sendMessage(prefix + "Format: /bcontrol 'info/reload'");
					
				}else{
					player.sendMessage(prefix + "Format: /bcontrol 'info/reload'");
				}
			}else{
				getLogger().info("You must be a player to use this/these command(s)!");
			}
		}
		
		return true;
	}
	
	public void loadConfig(){
		saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
