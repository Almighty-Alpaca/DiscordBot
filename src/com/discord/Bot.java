package com.discord;

import com.discord.Listeners.MessageListener;
import com.discord.commands.CommandRegister;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Bot {
    public static final String BOT_TOKEN = "";
    public static JDA jda;
    public static void main(String[] args) {
        try {
            CommandRegister.registerCommands();
            jda = new  JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).buildBlocking();
            jda.addEventListener(new MessageListener());
        } catch (LoginException | InterruptedException | RateLimitedException  e) {
            e.printStackTrace();
        }
    }

}
