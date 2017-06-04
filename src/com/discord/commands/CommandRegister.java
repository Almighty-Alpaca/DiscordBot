package com.discord.commands;

import com.discord.commands.games.Test.ping;
import com.discord.commands.games.league.champData;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xavi on 31/05/2017.
 */

// Map: link between a key and a value
//in this case your key should be a string and value should be the abstract class

public class CommandRegister {
    static Map<String, CommandExec> commands = new HashMap<>();

    public static void registerCommands() {
        registerCommand(new champData());
        registerCommand(new ping());
    }


    private static void registerCommand(CommandExec cmd) {
        commands.put(cmd.getComando(), cmd);
    }

    public static void handle(MessageReceivedEvent event) {
        String message = event.getMessage().getRawContent().substring(1); // Removes the prefix from the reference of the messages content.
        String[] tokens = message.split("\\s+"); // Breaks the content up into a array of strings whenever it encounters a space or newline character.
        String[] args = tokens.length > 1 ? Arrays.copyOfRange(tokens, 1, tokens.length) : new String[]{}; // The remaining arguments that came with the command.
        System.out.println("CommandRegistry | Compare " + tokens[0]);
        if (commands.containsKey(tokens[0])){
            System.out.println("CommandRegistry | Compared succesfully");
            commands.get(tokens[0]).execute(event, args);
        }
    }
}


