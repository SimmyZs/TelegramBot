/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bottelegrampghplc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegram.API.*;
/**
 *
 * @author simon
 */
public class ThreadRic extends Thread{
    TelegramAPI api;
    CParser parser;
    CCondivisa condivisa;
    int offset;
    boolean first;
    
    public ThreadRic(CCondivisa c){
        api = new TelegramAPI();
        parser = new CParser();
        condivisa=c;
        offset=0;
        first=true;
    }
    
    @Override
    public void run(){
        while(true){
            try {                
                List<CMessages> messaggi = parser.CParser();
                if(!messaggi.isEmpty()){
                    offset =messaggi.get(messaggi.size()-1).getUpdateID()+1;
                    if(!first)
                        condivisa.AddMessaggi(messaggi); 
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadRic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ThreadRic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                       
            try {
                if(!first)
                    Thread.sleep(400);
                else
                    Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(first)
                first=false;
        }
    }
}
