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
   Bu sinifta karakter sinifi kalitim olarak verilecektir. Constructor, Get ve Set metotları yer
   alacaktir. Bu siniftaki parametreler dusmanID, dusmanAdi ve dusmanTür seklinde olmalidir. 
*/

public abstract class Dusman extends Karakter {
    //Degiskenler
    int dusmanID;
    String dusmanAd;
    int dusmanTur;//0 = Azman - 1 = Gargamel

    
    //Constructorlar
    public Dusman() {
        
    }
    
    public Dusman(int dusmanID, String dusmanAd, int dusmanTur, int karakterID, String karakterAd, int karakterTur) {
        //super(karakterID, karakterAd, karakterTur);
        this.dusmanID = dusmanID;
        this.dusmanAd = dusmanAd;
        this.dusmanTur = dusmanTur;
    }

    public Dusman(int dusmanID, String dusmanAd, int dusmanTur) {
        this.dusmanID = dusmanID;
        this.dusmanAd = dusmanAd;
        this.dusmanTur = dusmanTur;
    }

    
    //Get Set Methodlari
    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAd() {
        return dusmanAd;
    }

    public void setDusmanAd(String dusmanAd) {
        this.dusmanAd = dusmanAd;
    }

    public int getDusmanTur() {
        return dusmanTur;
    }

    public void setDusmanTur(int dusmanTur) {
        this.dusmanTur = dusmanTur;
    }
//
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
