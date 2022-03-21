/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegram.API;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author simon
 */
public class CParser {
    public List<CMessages> Parser(JSONObject json){
        List<CMessages> message=new ArrayList<>();
        JSONArray jArray = json.getJSONArray("result");
        for (int i = 0; i < jArray.length(); i++) {
            int messageID=Integer.parseInt(jArray.getJSONObject(i).get("update_id").toString());
            int chatID=Integer.parseInt(jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").get("id").toString());            
            String text = jArray.getJSONObject(i).getJSONObject("message").get("text").toString();
            String username = jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").get("first_name").toString();
            message.add(new CMessages(messageID,chatID,username,text));  
        }
        
        return message;
    }
}
