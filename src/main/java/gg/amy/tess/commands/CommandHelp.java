package gg.amy.tess.commands;

import gg.amy.tess.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * @author amy
 * @since 8/29/18.
 */
public class CommandHelp extends Command {
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("If you or anyone you know are struggling, please, PLEASE reach out for help. You are worthy, you are loved and you will always be able to find assistance.\n\n" +
                "USA: 18002738255\n" +
                "UK: 0800 58 58 58\n" +
                "Other countries: <https://pastebin.com/BV2PnF0g>").queue();
    }
}
