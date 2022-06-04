package support;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Ticketsystem extends ListenerAdapter {

    final int zahl = 0;

    public void onMessageReceived(MessageReceivedEvent tick){

        if (tick.getMessage().getContentStripped().equalsIgnoreCase(".setup Support")){

        if (tick.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Erstelle hier ein Ticket!");
            eb.setColor(0x42b580);
            eb.setDescription("Erstelle hier ein Ticket!");
            eb.addField("Wie kann ich mich Verifizieren?", "Klicke auf Erstelle ein Ticket!", false);

            Button open = Button.success("ticket", "Verifiziere dich hier!").withEmoji(Emoji.fromMarkdown("✉️"));

            tick.getChannel().sendMessageEmbeds(eb.build()).setActionRow(open).queue();

            }
        }

    }




    public void onButtonInteraction(ButtonInteractionEvent click) {
        click.deferEdit().queue();
        if(click.getButton().getId().equalsIgnoreCase("ticket")) {
            int min = 0;
            int max = 99999;
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

            Guild guild = click.getGuild();

            guild.createTextChannel("Ticket " + random_int, guild.getCategoryById("982280900689670206"));
        }

    }
}
