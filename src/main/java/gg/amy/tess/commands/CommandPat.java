package gg.amy.tess.commands;

import gg.amy.tess.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author amy
 * @since 8/29/18.
 */
public class CommandPat extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        final Message msg = event.getMessage();
        final Collection<User> mentions = new ArrayList<>(msg.getMentionedUsers());
        mentions.removeIf(u -> u.getId().equalsIgnoreCase("484313304509054986"));
        if(mentions.isEmpty()) {
            event.getChannel().sendMessage("\\*pat\\* You must be pretty lonely if you do this :(").queue();
        } else {
            final String names = String.join(", ", mentions.stream().map(e -> "**" + e.getName() + "**")
                    .collect(Collectors.toList()));
            event.getChannel().sendMessage(names + ", you were just patted by **" + msg.getAuthor().getName() + "**!")
                    .queue();
        }
    }
}
