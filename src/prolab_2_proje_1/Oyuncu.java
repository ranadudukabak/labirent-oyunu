/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab_2_proje_1;

/**
 *
 * @author ranadudukabak
 */

/*
Bu sınıfta karakter sınıfı kalıtım olarak verilecektir. Constructor, Get ve Set metotları yer
alacaktır. Oyuncunun düşman karaktere her dokunuşunda kazandığı puan kademeli olarak
düşecektir. Bu sınıftaki parametreler oyuncuID, oyuncuAdi, oyuncuTur ve ayrıca Skor şeklinde
olmalıdır. PuaniGoster() fonksiyonu ile oyuncuların skorları gösterilecektir.
*/

/*
Not: Hiçbir oyuncu çapraz gidemez sadece sağ, sol, yukarı ya da aşağı yönde hareket sağlayabilir.
*/

public abstract class Oyuncu extends Karakter {
    //Degiskenler
    int oyuncuID;
    String oyuncuAd;
    int oyuncuTur; //0 = Gozluklu Sirin - 1 = Tembel Sirin
    int skor;
    

    //Constructorlar
    public Oyuncu() {
        
    }
    
    public Oyuncu(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor, int karakterID, String karakterAd, int karakterTur) {
       // super(karakterID, karakterAd, karakterTur);
        this.oyuncuID = oyuncuID;
        this.oyuncuAd = oyuncuAd;
        this.oyuncuTur = oyuncuTur;
        this.skor = skor;
    }

    public Oyuncu(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAd = oyuncuAd;
        this.oyuncuTur = oyuncuTur;
        this.skor = skor;
    }
    

    //Abstract Methodlar
    public abstract void OyuncuAzmanaDokundu();
    
    public abstract void OyuncuGargameleDokundu();
    
    public abstract void PuaniGoster();

    
    //Get Set Methodlari
    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAd() {
        return oyuncuAd;
    }

    public void setOyuncuAd(String oyuncuAd) {
        this.oyuncuAd = oyuncuAd;
    }

    public int getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(int oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

//    @Override
//    public int getKarakterID() {
//        return karakterID;
//    }
//
//    @Override
//    public void setKarakterID(int karakterID) {
//        this.karakterID = karakterID;
//    }
//
//    @Override
//    public String getKarakterAd() {
//        return karakterAd;
//    }
//
//    @Override
//    public void setKarakterAd(String karakterAd) {
//        this.karakterAd = karakterAd;
//    }
//
//    @Override
//    public int getKarakterTur() {
//        return karakterTur;
//    }
//
//    @Override
//    public void setKarakterTur(int karakterTur) {
//        this.karakterTur = karakterTur;
//    }
}
