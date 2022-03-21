/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegram.API;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author simon
 */
public class TelegramAPI {
    
    String botName = "povero_gabbiano_bot";
    String botKey = "5239505661:AAGcrlCK3LbnMUGWlwgOKTF2tIil3Bl0Lyg";
    
    public TelegramAPI(String botName, String botKey){
        botName=botName;
        botKey=botKey;
    }

    public String getBotName() {
        return botName;
    }

    public String getBotKey() {
        return botKey;
    }

    public JSONObject getUpdates() throws IOException, JSONException {
        String tmp = "";
        URL url = new URL("https://api.telegram.org/bot" + botKey + "/getUpdates");
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getResponseCode() == 200) {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                tmp += scanner.nextLine();
            }
        }
        JSONObject json = new JSONObject(tmp);
        return json;
    }

    public void sendMessage(String message, int id) throws MalformedURLException, IOException {
        URL url = new URL("https://api.telegram.org/bot" + botKey + "/sendMessage?chat_id=" + id + "&text=" + message);
        URLConnection connection = url.openConnection();
        InputStream msg = new BufferedInputStream(connection.getInputStream());
    }
    
}
