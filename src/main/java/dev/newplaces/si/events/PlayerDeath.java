/*    */ package dev.newplaces.si.events;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import dev.newplaces.si.Main;
/*    */ import dev.newplaces.si.utils.SaveInventory;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ 
/*    */ 
/*    */ public class PlayerDeath
/*    */   implements Listener
/*    */ {
/*    */   Main plugin;
/*    */   
/*    */   public PlayerDeath(Main pl) {
/* 19 */     this.plugin = pl;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntityDeath(PlayerDeathEvent e) {
/* 24 */     if (e.getEntity() instanceof Player) {
/* 25 */       Player p = e.getEntity();
/* 26 */       if (p.hasPermission("inventory.save.death")) {
/* 27 */         SaveInventory ku = new SaveInventory();
/* 28 */         if (!ku.isInventorySaved(p)) {
/* 29 */           p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invSavedOnDeathMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */           try {
/* 31 */             e.getDrops().clear();
/* 32 */             ku.saveInventory(p);
/* 33 */           } catch (IOException e1) {
/* 34 */             e1.printStackTrace();
/*    */           } 
/*    */         } else {
/* 37 */           p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("invAlreadySavedOnDeathMessage").replace("{prefix}", ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("prefix")))));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\TestServer\SaveInventory.jar!\me\vextricity\si\events\PlayerDeath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */