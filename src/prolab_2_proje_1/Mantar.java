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
Random olarak (maksimum 20 saniye olacak şekilde) herhangi bir yerde mantar
oluşacak ve 7 sn ekranda görünecektir. Eğer Oyuncu mantarı alabilirse 50 puan kazanır.
Oyuncu mantarı alamazsa mantar kaybolur.
*/

public class Mantar extends Obje {
    //Degiskenler
    int mantarSayisi;
    
    
    //Constructorlar
    public Mantar() {
        
    }
    
    public Mantar(int mantarSayisi) {
        this.mantarSayisi = mantarSayisi;
    }
    
    
    //Methodlar
    public void ObjeAlindi() {//Oyuncunun skoruna 50 puan eklenecek.
        mantarSayisi++;
        
    }

    public void ObjeyiOlustur() {//Ekranda 7 saniyeligine 1 mantar olustur.
        
    }
    
    public void ObjeyiYokEt() {//Olusturulan mantari yok et.
        
    }

    
    //Get Set Methodlari
    public int getMantarSayisi() {
        return mantarSayisi;
    }

    public void setMantarSayisi(int mantarSayisi) {
        this.mantarSayisi = mantarSayisi;
    }
}
