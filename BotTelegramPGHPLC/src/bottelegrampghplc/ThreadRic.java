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
    CCondivisa condivisa;
    int offset;
    TelegramAPI api;
    CParser parser;
    boolean first;
    
    public ThreadRic(CCondivisa c){
        condivisa=c;
        offset=0;
        api = new TelegramAPI();
        parser = new CParser();
        first=true;
    }
    
    @Override
    public void run(){
        while(true){              
                List<CMessages> messaggi = parser.CParser();
                if(!messaggi.isEmpty()){
                    offset =messaggi.get(messaggi.size()-1).getUpdateID()+1;
                    if(!first)
                        condivisa.AddMessaggi(messaggi); 
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
