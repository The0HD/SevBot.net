package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class status extends ListenerAdapter {
    public void onMessageReceived (MessageReceivedEvent status ) {

        EmbedBuilder eb2 = new EmbedBuilder();
        eb2.setTitle("Status der Server");
        eb2.setDescription("Hier sind die Serverstatusse aufgelistet");
        eb2.addField("Minecraftserver (mc.sevnet.eu)", "Wartungsarbeiten", false);
        eb2.addField("Discod (discord.sevnet.eu)", "Ereichbar", false);
        eb2.addField("Website (sevnet.eu)", "Wartungarbeiten",false);
        eb2.setColor(0x70061d);
        eb2.setThumbnail("https://cdn.discordapp.com/attachments/972151121722376272/974653004403838976/Unbenannt_20.png");
        eb2.setAuthor("Sevbot.net", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", "https://cdn.discordapp.com/attachments/972151121722376272/974653004403838976/Unbenannt_20.png");
        if (status.getMessage().getContentStripped().equalsIgnoreCase(".status")) {
            status.getChannel().sendMessageEmbeds(eb2.build()).queue();
            status.getMessage().addReaction("\uD83D\uDC4D").queue();
        }
    }
}