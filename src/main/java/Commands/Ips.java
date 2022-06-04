package Commands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ips extends ListenerAdapter {
    public void onMessageReceived  (MessageReceivedEvent Status ) {
        EmbedBuilder eb3 = new EmbedBuilder();
        eb3.setTitle("Ips");
        eb3.setColor(0x70061d);
        eb3.setDescription("Hier werden alle Ips aufgelistet \n zu den Statusinformationen bitte .status eingeben");
        eb3.addField("Minecraftserver", "Ip: sevnet.eu", false);
        eb3.addField("Discordserver", "Ip: discord.sevnet.eu", false);
        eb3.addField("Website", "Ip: sevnet.eu", false);
        eb3.setAuthor("SevBot.net", "https://dc.sevnet.eu", "https://cdn.discordapp.com/attachments/972151121722376272/974653004403838976/Unbenannt_20.png");

        if (Status.getMessage().getContentStripped().equalsIgnoreCase(".ip")) {
            Status.getChannel().sendMessageEmbeds(eb3.build()).queue();
            Status.getMessage().addReaction("\uD83D\uDC4D").queue();
        }
    }
}
