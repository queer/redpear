package gg.amy.tess.commands;

import gg.amy.tess.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 8/29/18.
 */
public class CommandEval extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " no u").queue();
    }
}
