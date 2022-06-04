package moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;

public class Regeln extends ListenerAdapter {
    public void onMessageReceived (MessageReceivedEvent rules ){
        if (rules.getMessage().getContentStripped().equalsIgnoreCase(".setup Rules")){

            System.out.println("hi");


            if (rules.getMember().getPermissions().contains(Permission.MANAGE_SERVER)) {

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(" \uD835\uDC11\uD835\uDC1E\uD835\uDC20\uD835\uDC1E\uD835\uDC25\uD835\uDC30\uD835\uDC1E\uD835\uDC2B\uD835\uDC24 auf " + rules.getGuild().getName());
                eb.setDescription("Die Regeln gelten für Chat, Voicechat, Namen und Spieleanzeige!");
                eb.addField("§1 Allgemein","", false);
                eb.addField("1.", "A) Teammitglieder müssen sich nicht vor dem Mitglied rechtfertigen, aber zumindest den Grund für ihre Handlung darlegen.", false);
                eb.addField("2.", "Identitätsdiebstahl ist ebenso unerwünscht, das Ausgeben als Teammitglied.", false);
                eb.addField("3.", "Geschäfte oder Verkäufe zu tätigen ist verboten", false);
                eb.addField("4.", "Multiaccounts sind verboten.", false);
                eb.addField("§2 Text Channels", "", false);
                eb.addField("1.", "Spam ist in jeder Hinsicht verboten. (Caps, Bilder, Emojis etc.)", false);
                eb.addField("2.", "Beleidigungen, übermäßiges Fluchen sowie rassistische oder sexistische Inhalte und Belästigung werden nicht geduldet.", false);
                eb.addField("3.", "Werbung ist in jeglicher Hinsicht verboten. Nur Partnerserver dürfen Werbung machen.", false);
                eb.addField("4.", "Links sind strengstens verboten.", false);
                eb.addField("5.", "Botcommands sind nur in dafür vorgesehenen Kanälen erlaubt.", false);
                eb.addField("6.", "Das unnötige Pingen von Mitgliedern ist verboten, vor allem von Teammitgliedern.", false);
                eb.addField("7.", "Das Verbreiten von privaten und sensiblen Daten anderer ist verboten.", false);
                eb.addField("8.", "Das Verbreiten von privaten und sensiblen Daten anderer ist verboten.", false);
                eb.addField("9.", " Das Verbreiten von Dateien, die jemandem Schaden können, ist verboten.", false);
                eb.addField("§3 Voice Chats","",false);
                eb.addField("11."," Das 'Channelhopping' (das schnelle und dauerhafte Wechseln der Sprachkanäle) ist untersagt.",false);
                eb.addField("12.","Das Abspielen von zu lauter Musik, Geräuschen und das nutzen eines Stimmenverzerrers ist verboten.",false);
                eb.addField("13.","Private Missverständnisse und Unterhaltungen sind auch privat zu halten.",false);
                eb.addField("14.","Gespräche dürfen nicht aufgenommen werden.",false);
                eb.addField("INFOS","Das Serverteam kann die Regeln jederzeit anpassen und verändern",false);
                eb.addField("","Jeder Regelbruch wird je nach Vergehen bestraft. Die Strafe kann je nach Teammitglied anders ausfallen. Niemand wird grundlos gekickt, gebannt oder gemutet.\n",false);
                eb.addField("","Unwissenheit schützt nicht vor Strafe",false);
                eb.addField("Wenn du die Regeln gelesen hast bist du eingeladen, die Räume des Discords zu verwenden. Du stimmst beim Betreten des Servers automatisch den obenstehenden Regeln zu.", "",false);
                eb.setColor(0x70061d);
                eb.setThumbnail("https://cdn.discordapp.com/attachments/981560166493343754/982260373853974558/pngwing.com.png");


                rules.getChannel().sendMessageEmbeds(eb.build()).queue();

            }

        }

    }

}
