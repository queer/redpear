package gg.amy.tess;

import gg.amy.tess.commands.*;
import lombok.Getter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author amy
 * @since 8/29/18.
 */
@SuppressWarnings("Singleton")
public enum RedPear {
    INSTANCE;
    
    @Getter
    private final String prefix = "<@484313304509054986>";
    
    @Getter
    private final Map<String, Command> commands = new HashMap<>();
    @Getter
    // uwu
    // Can't have it as a non-final field
    @SuppressWarnings("NonFinalFieldInEnum")
    private JDA jda;
    
    public static void main(final String[] args) throws LoginException, InterruptedException {
        INSTANCE.start();
    }
    
    private void start() throws LoginException, InterruptedException {
        commands.put("prefix", new CommandPrefix());
        commands.put("eval", new CommandEval());
        commands.put("ping", new CommandPing());
        commands.put("help", new CommandHelp());
        commands.put("tato", new CommandTato());
        commands.put("pat", new CommandPat());
        
        jda = new JDABuilder(AccountType.BOT)
                .setToken(System.getenv("TOKEN"))
                .addEventListener(new ListenerAdapter() {
                    @Override
                    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
                        try {
                            if(event.getAuthor().isBot()) {
                                return;
                            }
                            if(event.getMessage().getContentRaw().equalsIgnoreCase("pls pingmax")) {
                                event.getChannel().sendMessage("<@!107563269484490752>").queue();
                                return;
                            }
                            if(!event.getMessage().getContentRaw().startsWith(prefix)) {
                                return;
                            }
                            final String msg = event.getMessage().getContentRaw().replaceFirst(prefix, "").trim();
                            final String[] parts = msg.split("\\s+", 2);
                            if(parts.length > 0) {
                                final String cmd = parts[0].toLowerCase();
                                Optional.ofNullable(commands.get(cmd)).ifPresent(c -> c.runCommand(event));
                            }
                        } catch(final Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build().awaitReady();
    }
}
