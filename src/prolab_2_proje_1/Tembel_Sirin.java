///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package prolab_2_proje_1;

/**
 *
 * @author ranadudukabak
 */

/*
Her defasında 1 birim ilerler. Azman’a dokunursa oyuncu 5
puan kaybeder. Gargamel’a dokunursa oyuncu 15 puan kaybeder.
*/

public class Tembel_Sirin extends Karakter{
    //Constructorlar
    public Tembel_Sirin() {
        
    }
    private int puan = 20;

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
//    public Tembel_Sirin(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor, int karakterID, String karakterAd, int karakterTur) {
//        super(oyuncuID, oyuncuAd, oyuncuTur, skor, karakterID, karakterAd, karakterTur);
//    }
//
//    public Tembel_Sirin(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor) {
//        super(oyuncuID, oyuncuAd, oyuncuTur, skor);
//    }

    
//    //Override Edilen Methodlar
//    public void Ilerle() {//Oyuncu 1 birim ilerler.
//        
//    }
//    
//    
//    public void OyuncuAzmanaDokundu() {//Oyuncu 5 puan kaybeder.
//        
//    }
//    
//    public void OyuncuGargameleDokundu() {//Oyuncu 15 puan kaybeder.
//        
//    }
//
//    public void PuaniGoster() {
//        
//    }
}
