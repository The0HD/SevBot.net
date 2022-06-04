import Commands.Ips;
import Commands.helpcommant;
import Commands.secret_command;
import Commands.status;
import io.github.cdimascio.dotenv.Dotenv;
import moderation.Regeln;
import support.Ticketsystem;
import support.VerifySystem;
import Sonstiges.welcomemessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");

        String prefix = ".";

        String status;

        status = prefix + "help";

        System.out.println("Der Bot ist Online!");

        JDABuilder script = JDABuilder.createDefault(token);

        script.addEventListeners(new helpcommant());

        script.setStatus(OnlineStatus.ONLINE);

        script.addEventListeners(new Regeln());

        script.addEventListeners(new status());

        script.addEventListeners(new secret_command());

        script.addEventListeners(new Ips());

        script.addEventListeners(new welcomemessage());

        script.addEventListeners(new VerifySystem());

        script.addEventListeners(new Ticketsystem());

        script.setActivity(Activity.watching(status));

        JDA bot = script.build();


    }

}