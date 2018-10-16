package gg.amy.tess.commands;

import gg.amy.tess.Command;
import gg.amy.tess.RedPear;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 10/16/18.
 */
public class CommandStats extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(
                "```\n" +
                        "Guilds: " + RedPear.INSTANCE.getJda().getGuildCache().size() + '\n' +
                        " Users: " + RedPear.INSTANCE.getJda().getUserCache().size() + '\n' +
                        "```"
        ).queue();
    }
}
