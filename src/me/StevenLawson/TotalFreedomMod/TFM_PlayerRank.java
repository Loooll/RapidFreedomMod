package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "§8[§5Dev§8]§5 "),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "§8[§4OP§8]§4 "),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "§8[§6SA§8]§6 "),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "§8[§2STA§8]§2 "),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "§8[§dSrA§8]§d "),
    OWNER("the " + ChatColor.RED + "Founder", ChatColor.BLUE + "§8[§4Founder§8]§b "),
    EXECUTIVE("a " + ChatColor.GOLD + "Executive Admin", ChatColor.BLUE + "§8[§6Executive§8]§6 "),
    SYSADMIN("a " + ChatColor.RED + "System Admin", ChatColor.RED + "§8[§4Sys-Admin§8]§4 "),
    CONSOLE("The " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "§8[§5Console§8]§5 ");
    private final String loginMessage;
    private final String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }

        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }

        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }
            if (TFM_ConfigEntry.SERVER_EXECUTIVES.getList().contains(sender.getName()))
            {
                return EXECUTIVE;
            }
            if (TFM_ConfigEntry.SERVER_SYSADMINS.getList().contains(sender.getName()))
            {
                return SYSADMIN;
            }
            

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
