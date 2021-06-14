import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {

        JDABuilder jdaBuilder = JDABuilder.createDefault("ODQyODA0OTM0MzkwOTcyNTA3.YJ6pQg.ZEfRDyLA4JZpC8J-JRMsNvnaG7o");
        JDA jda = null;

        try {
            jda = jdaBuilder.build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
            jda.getPresence().setActivity(Activity.playing("with yo momma"));


        } catch (LoginException e) {
            e.printStackTrace();
        }

        jda.addEventListener(new Hello());
        jda.addEventListener(new maybeMute());
        jda.addEventListener(new joinChannel());

        jda.addEventListener(new getMyAudioData());

//        PingPong pingPong = new PingPong();
//        jdaBuilder.addEventListeners(pingPong);
//        stopTyping stopTyping = new stopTyping();
//        jdaBuilder.addEventListeners(stopTyping);
//        maybeMute maybeMute = new maybeMute();
//        jdaBuilder.addEventListeners(maybeMute);


    }


}
