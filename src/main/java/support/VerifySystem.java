package support;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

public class VerifySystem extends ListenerAdapter {
    public void onMessageReceived (MessageReceivedEvent ver) {
        if (ver.getMessage().getContentStripped().equalsIgnoreCase(".setup Verify")){
            if (ver.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Verifiziere dich hier!");
                eb.setThumbnail("https://cdn.discordapp.com/attachments/972839641738805271/980833357439049788/giphy.gif");
                eb.setColor(0x42b580);
                eb.setDescription("Verhalte dich immer höflich und respektvoll gegenüber den anderen Nutzern!");
                eb.addField(" Wie kann ich mich Verifizieren?", "Klicke auf den Button Verifizieren!", false);

                Button button = Button.success("verify", "Verifiziere dich hier!").withEmoji(Emoji.fromMarkdown("<:check:980024475527565323>"));

                ver.getChannel().sendMessageEmbeds(eb.build()).setActionRow(button).queue();
            }

        }


    }

    public void onButtonInteraction (ButtonInteractionEvent click) {

        if (click.getButton().getId().equalsIgnoreCase("verify")){

            Role verifyRole = click.getGuild().getRoleById("980822324326580284");

            click.getGuild().addRoleToMember(click.getMember(), verifyRole).queue();
            click.reply("Du hast dich Verifiziert!").setEphemeral(true).queue();
            click.deferEdit().queue();
        }

    }

}
