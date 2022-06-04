import Commands.Ips;
import Commands.helpcommant;
import Commands.secret_command;
import Commands.status;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
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

    public static String prefix = ".";
    public AudioPlayerManager audioPlayerManager;

    public void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");

        String status = Main.prefix + "help";


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

        this.audioPlayerManager = new DefaultAudioPlayerManager();


        JDA bot = script.build();

        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        audioPlayerManager.getConfiguration().setFilterHotSwapEnabled(true);

        System.out.println("Der Bot ist Online!");

    }

}