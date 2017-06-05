package com.discord.commands.games.league;
import com.discord.commands.CommandExec;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.net.URL;

/**
 * Created by xavi on 31/05/2017.
 */

public class ChampData extends CommandExec {

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
        final String API_KEY = ""; //champion gg v1
        String champ="";
        try {
            if (args.length == 0) {
                channel.getChannel().sendMessage("You miss an argument").queue();
                return "";
            }
            if (args.length == 1) {
                channel.getChannel().sendMessage("You need to put a champion").queue();
            } else {
                channel.getChannel().sendMessage("Party!").queue();
				JSONArray dataArray = readJsonArrayFromUrl("http://api.champion.gg/champion/" + args[1] + "/skills/mostWins?api_key=" + API_KEY);

				JSONObject championData = dataArray.getJSONObject(0); // first one
				JSONArray order = championData.getJSONArray("order");

				MessageBuilder text = new MessageBuilder();

				for (int i = 0; i < order.length(); i++) {
					String ability = order.getString(i);
					text.append(' ').append(":regional_indicator_" + ability.toLowerCase() + ":");
				}

                //if args.length==2
                champ = args[1];
                switch (args[0]) {
                    case "level":
                        System.out.println("im in boys");
                        channel.getChannel().sendMessage(text.build()).queue();
                        break;
                    case "build":
                        break;
                    default:
                        channel.getChannel().sendMessage("You have to put level or build").queue();
                        break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

	public static JSONObject readJsonObjectFromUrl(String url) throws IOException, JSONException {
		return new JSONObject(new JSONTokener(new URL(url).openStream()));
	}

	public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
		return new JSONArray(new JSONTokener(new URL(url).openStream()));
	}
}
