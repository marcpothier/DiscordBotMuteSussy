import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPong extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("!ping")) {
             e.getChannel().sendMessage("pong").queue();
         }
        if (e.getMessage().getContentRaw().equals("!pong")) {
            e.getChannel().sendMessage("so funny hahaashdashdsahdhsa").queue();
        }
        if (e.getMessage().getContentRaw().equals("!pog")) {
            e.getChannel().sendMessage("poggers").queue();
        }
        }
    }


