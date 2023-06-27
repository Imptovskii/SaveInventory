/*    */ package dev.newplaces.si.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ 
/*    */ 
/*    */ public class SaveInventory
/*    */ {
/* 18 */   Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("SaveInventory");
/*    */   
/*    */   public void saveInventory(Player p) throws IOException {
/* 21 */     YamlConfiguration c = new YamlConfiguration();
/* 22 */     c.set("inventory", p.getInventory().getContents());
/* 23 */     c.set("armor", p.getInventory().getArmorContents());
/* 24 */     c.set("potions", p.getActivePotionEffects());
/* 25 */     c.save(new File(this.plugin.getDataFolder() + File.separator + "players", String.valueOf(p.getName()) + ".yml"));
/* 26 */     p.getInventory().clear();
/* 27 */     p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 28 */     p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 29 */     p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 30 */     p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 31 */     for (PotionEffect pf : p.getActivePotionEffects()) {
/* 32 */       p.removePotionEffect(pf.getType());
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadInventory(Player p) {
/* 39 */     p.getInventory().clear();
/* 40 */     p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 41 */     p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 42 */     p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 43 */     p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 44 */     for (PotionEffect pf : p.getActivePotionEffects()) {
/* 45 */       p.removePotionEffect(pf.getType());
/*    */     }
/* 47 */     YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder() + File.separator + "players", String.valueOf(p.getName()) + ".yml"));
/* 48 */     ItemStack[] content = (ItemStack[])((List)c.get("inventory")).toArray((Object[])new ItemStack[0]);
/* 49 */     Collection<PotionEffect> poteff = (Collection<PotionEffect>)c.get("potions");
/* 50 */     ItemStack[] armor = (ItemStack[])((List)c.get("armor")).toArray((Object[])new ItemStack[0]);
/* 52 */     p.addPotionEffects(poteff);
/* 53 */     p.getInventory().setContents(content);
/* 54 */     p.getInventory().setArmorContents(armor);
/*    */   }
/*    */   
/*    */   public void removeInventory(Player p) {
/* 58 */     File df = new File(this.plugin.getDataFolder() + File.separator + "players");
/* 59 */     File[] files = df.listFiles(); byte b; int i; File[] arrayOfFile1;
/* 60 */     for (i = (arrayOfFile1 = files).length, b = 0; b < i; ) { File kitFile = arrayOfFile1[b];
/* 61 */       if (kitFile.getName().replace(".yml", "").equals(p.getName()))
/* 62 */         kitFile.delete(); 
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/*    */   public boolean isInventorySaved(Player p) {
/* 68 */     YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder() + File.separator + "players", String.valueOf(p.getName()) + ".yml"));
/* 69 */     if (c.get("inventory") == null) {
/* 70 */       return false;
/*    */     }
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\TestServer\SaveInventory.jar!\me\vextricity\s\\utils\SaveInventory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */