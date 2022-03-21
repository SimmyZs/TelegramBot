/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bottelegrampghplc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class BotTelegramPGHPLC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCondivisa c =  new CCondivisa();
        ThreadInv ti = new ThreadInv(c);
        ThreadRic tr = new ThreadRic(c);
        
        tr.start();
        ti.start();
        

        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BotTelegramPGHPLC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ti.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BotTelegramPGHPLC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
