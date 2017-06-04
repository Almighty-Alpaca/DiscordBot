package com.discord.commands.games.league;
import com.discord.commands.CommandExec;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by xavi on 31/05/2017.
 */

public class champData extends CommandExec {

    @Override
    public String[] getAlias() {
        return new String[0];
    }

    @Override
    public String getComando() {
        return "lol";
    }

    @Override
    public String[] descripcion() {
        return new String[]{
                "!lol build champ -- Obtener build del campeon",
                "!lol subir champ posicion --  Obtener los niveles que subir del champeon",
        };
    }

    @Override
    public String execute(MessageReceivedEvent channel, String[] args) {
        final String API_KEY = "";
        if (args.length == 0) {
            channel.getChannel().sendMessage("Necesitas poner algo").queue();
        } else {
            if (args.length == 1) {
                channel.getChannel().sendMessage("You need to put a champion").queue();
            } else {
                channel.getChannel().sendMessage("Party!").queue();
                switch (args[0]) {
                    case "build":

                        break;
                    case "items":

                        break;
                    default:
                        channel.getChannel().sendMessage("Pon build o items");
                        break;
                }
            }
        }
        return null;
    }
}
