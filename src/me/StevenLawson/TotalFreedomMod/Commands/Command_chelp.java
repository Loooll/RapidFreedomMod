package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Help for Commands!",
        aliases = "efh",
        usage = "/<command> [1]")
public class Command_chelp extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("1")) 
        {
         playerMsg("§e----§aRapidFreedomMod Commands Page §c1§e----");
         playerMsg("§6/ban§f: Basically like /gtfo but renamed!");
         playerMsg("§6/adminmode§f: Make the server admin-only");
         playerMsg("§6/adminworld§f: Teleport to the adminworld");
         playerMsg("§6/adventure§f: Go into adventure mode");
         playerMsg("§6/afk§f: Marks you as AFK");
         playerMsg("§6/ai§f: Find out how to apply for SA");	
         playerMsg("§6/blockcmd§f: Block specified user's commands");	
         playerMsg("§6/announce§f: Announce a message");
        }
        if (mode.equals("2"))
        {
        
        }
     return true;
        }
}