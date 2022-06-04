package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class helpcommant extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent help) {
        //embed builder
        EmbedBuilder helpcom = new EmbedBuilder();
        helpcom.setTitle("Algemeine Commands");
        helpcom.setDescription("Hier sind alle Commands aufgelistet");
        helpcom.setColor(0x70061d);
        helpcom.setThumbnail("https://cdn.discordapp.com/attachments/972151121722376272/974653004403838976/Unbenannt_20.png");
        helpcom.addField(".help", "Zeigt alle Commands an", false);
        helpcom.addField(".status", "Zeig die statusse an", false);
        helpcom.setAuthor("Sevbot.net", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", "https://cdn.discordapp.com/attachments/972151121722376272/974653004403838976/Unbenannt_20.png");
        helpcom.addField(".ip", "Zeigt die Ips an", false);
        helpcom.setImage("https://cdn.discordapp.com/attachments/972839641738805271/977240380397473793/1653062521869773955.gif");
            if (help.getMessage().getContentStripped().equalsIgnoreCase(".help"))  {
                help.getMessage().addReaction("\uD83D\uDC4D").queue();
                help.getChannel().sendMessageEmbeds(helpcom.build()).queue();

            }

        }

    }