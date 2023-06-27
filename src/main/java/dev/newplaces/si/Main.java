/*    */ package dev.newplaces.si;

/*    */ import dev.newplaces.si.commands.CommandInventory;
/*    */ import dev.newplaces.si.events.PlayerDeath;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main extends JavaPlugin {
/*    */   public void onEnable() {
/* 11 */     getConfig().addDefault("prefix", "&aSaveInventory &8⎜&7");
/* 12 */     getConfig().addDefault("invSavedMessage", "{prefix} Your inventory has been saved!");
/* 13 */     getConfig().addDefault("invLoadedMessage", "{prefix} Your inventory has been loaded!");
/* 14 */     getConfig().addDefault("invalidArgumentsMessage", "{prefix} Invalid arguments! Usage: &a{commandUsage}");
/* 15 */     getConfig().addDefault("mustBeAPlayerMessage", "{prefix} You must be a player to use this command!");
/* 16 */     getConfig().addDefault("noPermissionMessage", "{prefix} You do not have permission to use this command!");
/* 17 */     getConfig().addDefault("invSavedOnDeathMessage", "{prefix} Your inventory has been saved! Type /inventory load to load it.");
/* 18 */     getConfig().addDefault("invAlreadySavedOnDeathMessage", "{prefix} Your inventory could not be saved as you already have a previous inventory saved. Type /inventory load to load it.");
/* 19 */     getConfig().addDefault("invNotSavedMessage", "{prefix} There is no stored inventory with your name.");
/*    */     
/* 21 */     getConfig().options().copyDefaults(true);
/* 22 */     saveConfig();
/*    */     
/* 24 */     getCommand("inventory").setExecutor((CommandExecutor)new CommandInventory(this));
/* 25 */     getServer().getPluginManager().registerEvents((Listener)new PlayerDeath(this), (Plugin)this);
/*    */   }
/*    */ }


/* Location:              D:\TestServer\SaveInventory.jar!\me\vextricity\si\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */