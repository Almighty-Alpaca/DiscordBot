package com.discord.commands.games.Test;

import com.discord.commands.CommandExec;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by xavi on 04/06/2017.
 */
public class ping extends CommandExec {
    @Override
    public String getComando() {
        return "ping";
    }

    @Override
    public String[] descripcion() {
        return new String[0];
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }

    @Override
    public String execute(MessageReceivedEvent channel, String[] args) {
        channel.getChannel().sendMessage("Pong!").queue();
        return "";
    }
}
