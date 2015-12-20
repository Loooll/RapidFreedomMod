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

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Broadcast a message", usage = "/<command>", aliases = "bc, bcast")
public class Command_announce extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)       
        {

                String message = "";
                for (int i = 1; i < args.length; i++)
                {
                    if (i > 1)
                    {
                        message += " ";
                    }
                    message += args[i];
                }
                TFM_Util.bcastMsg(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Announcement" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + message); //Broadcast message
        return true;
            }
        
       }
