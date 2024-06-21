package org.betonquest.betonquest.commands;

import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.utils.PlayerConverter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Gives the player his journal
 */
@SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
public class JournalCommand implements CommandExecutor {

    /**
     * Registers a new executor of the /journal command
     */
    public JournalCommand() {
        BetonQuest.getInstance().getCommand("journal").setExecutor(this);
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if ("journal".equalsIgnoreCase(cmd.getName())) {
            // command sender must be a player, console can't have journal
            if (sender instanceof Player) {
                // giving the player his journal
                BetonQuest.getInstance().getPlayerData(PlayerConverter.getID((Player) sender)).getJournal().addToInv();
            }
            return true;
        }
        return false;
    }
}
