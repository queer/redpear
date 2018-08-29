package gg.amy.tess;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 8/29/18.
 */
public abstract class Command {
    public abstract void runCommand(final GuildMessageReceivedEvent event);
}
