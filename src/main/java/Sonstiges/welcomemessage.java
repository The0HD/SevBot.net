package Sonstiges;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class welcomemessage extends ListenerAdapter {
    public void onGuildMemberJoin (GuildMemberJoinEvent hi) {
        User nutzer = hi.getUser();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Willkommen auf Sevnet.eu!");
        eb.setDescription("Hi " + nutzer.getAsMention() + ", bitte Verifiziere dich in <977187002585874463>, damit du was sehen kannst");
        eb.setThumbnail("https://cdn.discordapp.com/attachments/972839641738805271/980818803317415976/wave.gif");
        eb.setColor(0x70061d);

        hi.getGuild().getTextChannelById("977187002585874463").sendMessageEmbeds(eb.build()).queue();

    }

}
