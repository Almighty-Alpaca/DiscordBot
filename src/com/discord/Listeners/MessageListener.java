package com.discord.Listeners;

import com.discord.commands.CommandRegister;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by xavi on 31/05/2017.
 */
public class MessageListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getRawContent().startsWith("!"))
        {
            System.out.println("Listener | What user sends: " + event.getMessage().getRawContent());
            CommandRegister.handle(event);
        }
    }
}
