/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bottelegrampghplc;

import java.util.ArrayList;
import java.util.List;
import telegram.API.*;

/**
 *
 * @author simon
 */
public class CCondivisa {
     List<CMessages> messaggi;
    int lastMessageID;
    
    public CCondivisa(){
        messaggi=new ArrayList<CMessages>();
        lastMessageID=0;
    }
    
    public CCondivisa(List<CMessages> messaggi, int id){
        this.messaggi=messaggi;
        lastMessageID=id;
    }
    
    public void AddMessaggi(List<CMessages> messaggi){
        this.messaggi.addAll(messaggi);
    }
    
    public void setID(int id){
        lastMessageID=id;
    }
    
    public int getID(){
        return lastMessageID;
    }
    
    public void setNewerID(int id){
        if(lastMessageID<id)
            lastMessageID=id;
    }
    
    public CMessages getMessaggio(){
        if(!messaggi.isEmpty())
            return messaggi.remove(0);
        else
    }
    
    public boolean hasMessaggio(){
        if(messaggi.isEmpty())
            return false;
        else
            return true;
    }

}
