import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase("!!muteMe"))
        {
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("!mute " + event.getMember().getAsMention() +" testing").queue();
            }
        }
        if(args[0].equalsIgnoreCase("!!unmuteMe"))
        {
            if(!event.getMember().getUser().isBot()) {
                event.getGuild().mute(event.getMember(), false).queue();
            }
        }
    }
}
