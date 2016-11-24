package fr.x9nico.viacheckconnection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class Updater {
	
	public static boolean checkForUpdate(Plugin pl, int spigotResourceID, boolean downloadIfAvailable) {
        boolean update = false;
        Double currentVersion;
        Double versionName;

        try {
            JSONArray versions = getArray(spigotResourceID);

            if(versions.size() == 0) {
                return update;
            }

            JSONObject latest = ((JSONObject) versions.get(versions.size()-1));

            versionName = Double.parseDouble(latest.get("name").toString());
            currentVersion = Double.parseDouble(pl.getDescription().getVersion());
        } catch(NumberFormatException e) {
            return update;
        }

        if(versionName > currentVersion) {
            update = true;
            if(downloadIfAvailable) download(pl, spigotResourceID);
        }
        return update;
    }

    private static JSONArray getArray(int spigotResourceID) {JSONArray array = new JSONArray();

        try {
            array = (JSONArray) JSONValue.parseWithException(connect(spigotResourceID));
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return array;
    }

    private static String connect(int spigotResourceID) {
        String json = "[]";
        try {
            final URL versionURL = new URL("https://api.spiget.org/v2/resources/" + spigotResourceID + "/versions");
            URLConnection conn = versionURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input = "", buffer;
            while((buffer = in.readLine()) != null) {
                input = input + buffer;
            }
            in.close();
            json = input;
        } catch(IOException e) {return json; }
        return json;
    }

    /**
     * @return If update is successful
     * @param pl The instance of your JavaPlugin
     * @param spigotResourceID @see checkForUpdate
     */
    public static boolean download(Plugin pl, int spigotResourceID) {
        File jar = new File(((JavaPlugin)pl).getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        try {
            URL url = new URL("https://api.spiget.org/v2/resources/"+spigotResourceID+"/download");

            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(jar, false);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            return true;
        } catch(IOException e) {
            return false;
        }
    }
}
