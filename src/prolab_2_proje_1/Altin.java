/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab_2_proje_1;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranadudukabak
 */

/*
   Her bir altin 5 puan degerindedir. Ek olarak altin sayisini tutmak icin altin
   degiskeni tutulacak. Random olarak (maksimum 10 saniye olacak sekilde) herhangi bir
   yerde ayni anda 5 altin olusacak (farkli sayida altin olusmayacaktir) ve 5 sn ekranda
   gorunecektir. Eger Oyuncu altini alabilirse her bir altin icin 5 puan kazanir. Oyuncu altini
   alamazsa altin kaybolur.
*/

public class Altin extends Thread {

    
    //Degiskenler
    int altinSayisi;
    public static Thread createGold = null;
    public static Thread createMushroom = null;
    
    
    
    
//    createGold = new Thread(this.CreateGold());
    //Constructorlar
    public Altin() {
        
        
    }
    
    public Altin(int altinSayisi) {
        this.altinSayisi = altinSayisi;
    }
    
    
    //Methodlar
    public void ObjeAlindi() {//Oyuncunun skoruna 5 puan eklenecek.
        altinSayisi++;
        
    }
    
    public void ObjeyiOlustur() {//Ekranda 5 saniyeligine 5 altin olustur.
        
    }
    
    public void ObjeyiYokEt() {//Olusturulan altini yok et.
        
    }

    
    //Get Set Methodlari
    public int getAltinSayisi() {
        return altinSayisi;
    }

    public void setAltinSayisi(int altinSayisi) {
        this.altinSayisi = altinSayisi;
    }
    
    public static Runnable CreateGold() {
        while(true) {

            
            try {
                System.out.println("rana");
                Thread.sleep(5);
                CreateMushroom();
            } catch (InterruptedException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static Runnable CreateMushroom() {
        while(true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("esra");
        }
        
    }
//    Altin.createGold = new Thread(Altin.CreateGold());
//                Altin.createMushroom = new Thread(Altin.CreateMushroom());
//                Altin.createGold.start();
//                Altin.createMushroom.start(); 


}
