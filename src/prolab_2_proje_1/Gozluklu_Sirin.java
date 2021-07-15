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
   Her defasinda 2 birim ilerler. Azman’a dokunursa oyuncu 5
   puan kaybeder. Gargamel’e dokunursa oyuncu 15 puan kaybeder.
*/
public class Gozluklu_Sirin extends Karakter {
    //Constructorlar
    public Gozluklu_Sirin() {
        
    }
    private int puan = 20;

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
    
//    public Gozluklu_Sirin(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor, int karakterID, String karakterAd, int karakterTur) {
//        super(oyuncuID, oyuncuAd, oyuncuTur, skor, karakterID, karakterAd, karakterTur);
//    }
//    
//    public Gozluklu_Sirin(int oyuncuID, String oyuncuAd, int oyuncuTur, int skor) {
//        super(oyuncuID, oyuncuAd, oyuncuTur, skor);
//    }

    
//    //Override Edilen Methodlar
//    public void Ilerle() {//Oyuncu 2 birim ilerler.
//        
//    }
//    
////   
//    public void OyuncuAzmanaDokundu() {//Oyuncu 5 puan kaybeder.
//        
//    }
//    
//  
//    public void OyuncuGargameleDokundu() {//Oyuncu 15 puan kaybeder.
//        
//    }
//
//   
//    public void PuaniGoster() {
//        
//    }
}
