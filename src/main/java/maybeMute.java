import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class maybeMute extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase("!mute")) {
            if(args.length <= 1) {
                sendErrorMessage(event.getChannel(), event.getMember());
            }
            else {
                Member target = event.getMessage().getMentionedMembers().get(0);

                Role muted = event.getGuild().getRolesByName("muted", true).get(0);

//                event.getGuild().addRoleToMember(target, muted).queue();
                event.getGuild().mute(target, true).queue();



                if(args.length >= 3) {
                    String reason = "";
                    for (int i = 2; i < args.length; i++) {
                        reason += args[i] + " ";
                    }
                    log(target, event.getMember(), reason, event.getGuild().getTextChannelById("846439220208861284"));
                } else {
                    log(target, event.getMember(), "", event.getGuild().getTextChannelById("846439220208861284"));
                    }
                }
            }
        }


    public void sendErrorMessage(TextChannel channel, Member member) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Invalid Usage");
        builder.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        builder.setColor(Color.decode("#e056fd"));
        builder.setDescription("Proper Usage: !mute @user [reason]");
        builder.addField("Hello", "hi", false);
        channel.sendMessage(builder.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
    }

    public void log(Member muted, Member muter, String reason, TextChannel channel) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        EmbedBuilder builder  = new EmbedBuilder();
        builder.setTitle("Mute Report");
        builder.setColor(Color.decode("#c7ecee"));
        builder.addField("Muted User", muted.getAsMention(), false);
        builder.addField("Muter", muter.getAsMention(), false);
        builder.addField("Date", sdf.format(date), false);
        builder.addField("Time", stf.format(date), false);
        channel.sendMessage(builder.build()).queue();
    }
}
