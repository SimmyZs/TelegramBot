/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bottelegrampghplc;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegram.API.*;

/**
 *
 * @author simon
 */
public class ThreadInv extends Thread {
    
    TelegramAPI api;
    CCondivisa condivisa;

    public ThreadInv(CCondivisa c) {
        api = new TelegramAPI();
        condivisa = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadInv.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (condivisa.hasMessaggio()) {
                CMessages mess = condivisa.getMessaggio();
                String testo = "";
                String messaggio = mess.getText();

                if (!messaggio.equals("")) {
                    if (messaggio.startsWith("/")) {
                        if (messaggio.toUpperCase().startsWith("/citta ")) {
                            String query = messaggio.substring(7);
                            }else{
                                testo="boh";
                            }
                        } else {
                            testo = "this comand doesn't exist";
                        }
                    }

                    if (!testo.equals("")) {
                        try {
                            api.sendMessage(testo, mess.getChatID());
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadInv.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }
    }
}
