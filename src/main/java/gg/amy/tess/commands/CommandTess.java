package gg.amy.tess.commands;

import gg.amy.tess.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.Random;

/**
 * @author amy
 * @since 8/30/18.
 */
public class CommandTess extends Command {
    private final String[] quotes = {
            "半日本人? :O",
            "@amy#0001 が一番可愛いですよ",
            "嬉しいねええええ",
            "Ahhh so cool!!",
            "A-ah",
            "Socks!!",
            "Ah my cat is on the piano",
            "A-ah 何これ",
            "Are you a cat now?",
            "Lick it",
            "No n",
            "Donate to my pat-reon",
            "I eat your potatoes",
            "amy#0001 have potatoes :potato:",
    };
    
    private final Random random = new Random();
    
    @Override
    public void runCommand(final GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " > " + quotes[random.nextInt(quotes.length)]).queue();
    }
}
