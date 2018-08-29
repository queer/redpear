package gg.amy.tess.commands;

import gg.amy.tess.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 8/29/18.
 */
public class CommandPing extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        final long start = System.currentTimeMillis();
        event.getChannel().sendMessage("Ping!").queue(msg -> {
            final long end = System.currentTimeMillis();
            event.getChannel().editMessageById(msg.getId(), String.format("Ping! (took %sms)", end - start)).queue();
        });
    }
}
