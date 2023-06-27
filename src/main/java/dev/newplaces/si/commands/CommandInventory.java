/*    */ package dev.newplaces.si.commands;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import dev.newplaces.si.Main;
/*    */ import dev.newplaces.si.utils.SaveInventory;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class CommandInventory
/*    */   implements CommandExecutor
/*    */ {
/*    */   Main plugin;
/*    */   
/*    */   public CommandInventory(Main pl) {
/* 19 */     this.plugin = pl;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 23 */     if (cmd.getName().equalsIgnoreCase("inventory")) {
/* 24 */       if (sender.hasPermission("inventory.save")) {
/* 25 */         if (sender instanceof Player) {
/* 26 */           Player p = (Player)sender;
/* 27 */           if (args.length > 0) {
/* 28 */             SaveInventory ku = new SaveInventory();
/* 29 */             if (args[0].equalsIgnoreCase("save")) {
/*    */               try {
/* 31 */                 ku.saveInventory(p);
/* 32 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invSavedMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/* 33 */               } catch (IOException e) {
/* 34 */                 e.printStackTrace();
/*    */               } 
/* 36 */             } else if (args[0].equalsIgnoreCase("load")) {
/* 37 */               if (ku.isInventorySaved(p)) {
/* 38 */                 ku.loadInventory(p);
/* 39 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invLoadedMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */               } else {
/* 41 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invNotSavedMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */               } 
/*    */             } else {
/* 44 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invalidArgumentsMessage").replace("{commandUsage}", this.plugin.getCommand(label).getUsage()).replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */             } 
/*    */           } else {
/* 47 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invalidArgumentsMessage").replace("{commandUsage}", this.plugin.getCommand(label).getUsage()).replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */           } 
/*    */         } else {
/* 50 */           sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("mustBeAPlayerMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */         } 
/*    */       } else {
/* 53 */         sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("noPermissionMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */       } 
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\TestServer\SaveInventory.jar!\me\vextricity\si\commands\CommandInventory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */