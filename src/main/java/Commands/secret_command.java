package Commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class secret_command extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent pam) {


        if (pam.getMessage().getContentStripped().startsWith("News")) {
            pam.getMessage().addReaction("\uD83D\uDC4D").queue();


        }

    }



}
