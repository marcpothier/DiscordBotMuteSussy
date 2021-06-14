
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class stopTyping extends ListenerAdapter {

    public void onUserTyping(UserTypingEvent e) {
        e.getChannel().sendMessage("stop typing please no one wants to hear you speak").queue();

    }

//    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
//        event.getChannelJoined().;
//    }

}