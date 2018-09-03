package gg.amy.tess.commands;

import gg.amy.tess.Command;
import gg.amy.tess.RedPear;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 8/29/18.
 */
public class CommandPrefix extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(String.join(" or ", RedPear.INSTANCE.getPrefixes())).queue();
    }
}
