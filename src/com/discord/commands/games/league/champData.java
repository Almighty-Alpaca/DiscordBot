package com.discord.commands.games.league;
import com.discord.commands.CommandExec;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

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
                JSONObject json = readJsonFromUrl("http://api.champion.gg/champion/"+args[1]+"/skills/mostWins?api_key="+API_KEY);
                //if args.length==2
                champ = args[1];
                switch (args[0]) {
                    case "level":
                        System.out.println("im in boys");
                        channel.getChannel().sendMessage(json.toString()).queue();
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

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            jsonText = jsonText.substring(1, jsonText.length()-1);//fix JSONObject text must begin with '{' at 1 [character 2 line 1] with '{' error
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
