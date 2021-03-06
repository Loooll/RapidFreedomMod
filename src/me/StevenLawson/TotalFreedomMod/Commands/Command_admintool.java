package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level=AdminLevel.SUPER, source=SourceType.ONLY_IN_GAME)
@CommandParameters(description="Gives admins the admin goodies.", usage="/<command>")
public class Command_admintool
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    PlayerInventory inv = sender_p.getInventory();
    ItemStack LongShaft = new ItemStack(Material.STICK, 1);
    for (Enchantment ench : Enchantment.values()) {
      if ((!ench.equals(Enchantment.LOOT_BONUS_MOBS)) && (!ench.equals(Enchantment.LOOT_BONUS_BLOCKS))) {
        LongShaft.addUnsafeEnchantment(ench, 32767);
      }
    }
    ItemMeta shaftmeta = LongShaft.getItemMeta();
    shaftmeta.setDisplayName(ChatColor.YELLOW + "Logstick");
    LongShaft.setItemMeta(shaftmeta);
    inv.addItem(new ItemStack[] { LongShaft });
    ItemStack logblock = new ItemStack(Material.STONE, 1);
    inv.addItem(new ItemStack[] { logblock });
    ItemStack compass = new ItemStack(Material.COMPASS, 1);
    inv.addItem(new ItemStack[] { compass });
    ItemStack wand = new ItemStack(Material.WOOD_AXE, 1);
    ItemMeta wandmeta = wand.getItemMeta();
    wandmeta.setDisplayName(ChatColor.YELLOW + "WorldEdit Wand");
    wand.setItemMeta(wandmeta);
    inv.addItem(new ItemStack[] { wand });
    ItemStack invispot = new ItemStack(Material.POTION, 1, (short)8270);
    ItemMeta invismeta = invispot.getItemMeta();
    invismeta.setDisplayName(ChatColor.YELLOW + "Invis Potion");
    invispot.setItemMeta(invismeta);
    inv.addItem(new ItemStack[] { invispot });
    sender_p.sendMessage(ChatColor.GOLD + "Giving you the necessary admin tools.");
    
    return true;
  }
}
