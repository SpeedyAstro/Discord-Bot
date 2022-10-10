package org.example.listeners;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class EventListener extends ListenerAdapter {



    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getReaction().getReactionEmote().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();
        String jumpLink = event.getJumpUrl();

        String message = user.getAsTag() + " reacted to message with  " + emoji + " in the " +channelMention+" channel! ";
        event.getGuild().getDefaultChannel().sendMessage(message).queue();
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // This is gonna allows us to listen to the message content and respond accordingly
        String message = event.getMessage().getContentRaw();
        //event.getChannel().sendMessage(message).queue();
        if(message.contains("java-resource")) {
            event.getChannel().sendMessage("https://docs.oracle.com/en/java/").queue();
        }
    }

}
