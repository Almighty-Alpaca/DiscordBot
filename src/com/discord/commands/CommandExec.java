package com.discord.commands;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by xavi on 31/05/2017.
 */
public abstract class CommandExec {
    public abstract String getComando();
    public abstract String[] descripcion();
    public abstract String[] getAlias();
    public abstract String execute(MessageReceivedEvent channel, String[] args);
}
