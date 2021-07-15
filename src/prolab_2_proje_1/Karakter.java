/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package prolab_2_proje_1;
//
//import java.util.ArrayList;
//
///**
// *
// * @author ranadudukabak
// */
//
///*
//   Karakterlerin adini tutacak ID, Ad, Turunu (oyuncu/dusman) tutacak.
//   Karakterlerin ilerledigi koordinatlari tutacak Lokasyon degiskenleri olmalidir.
//   Constructor, Get, Set ve EnKisaYol metotları yer almalidir.
//*/
//
////LOKASYON DEGISKENI NASIL OLABILIR DUSUN
//
//public abstract class Karakter {
//    //Degiskenler
//    int karakterID;
//    String karakterAd;
//    int karakterTur; //0 = Dusman - 1 = Oyuncu
//    Lokasyon currentlocation;
//
//    ArrayList<Lokasyon> enkisayol = new ArrayList();
//    int steps;
//
//    //Constructorlar
//    public Karakter() {
//
//    }
//    
//    public Karakter(int karakterID, String karakterAd, int karakterTur) {
//        this.karakterID = karakterID;
//        this.karakterAd = karakterAd;
//        this.karakterTur = karakterTur;
//    }
//
//    
//    //Methodlar
//    public void EnKisaYol() {//Dusman karakter, oyuncu her oynadiginda oyuncuya ulasabilecegi en kisa yolu hesaplar.
//    
//    }
//
//    //Abstract Methodlar
//    public abstract void Ilerle();
//    
//    
//    //Get Set Methodlari
//    public int getKarakterID() {
//        return karakterID;
//    }
//
//    public void setKarakterID(int karakterID) {
//        this.karakterID = karakterID;
//    }
//
//    public String getKarakterAd() {
//        return karakterAd;
//    }
//
//    public void setKarakterAd(String karakterAd) {
//        this.karakterAd = karakterAd;
//    }
//
//    public int getKarakterTur() {
//        return karakterTur;
//    }
//
//    public void setKarakterTur(int karakterTur) {
//        this.karakterTur = karakterTur;
//    }
//}





package prolab_2_proje_1;
import java.awt.Color;
import java.util.ArrayList;

public class Karakter {
	String name;
	String type;
	String kapi;
	Lokasyon currentlocation;
	String color;
	int puan = 20;

	ArrayList<Lokasyon> enkisayol=new ArrayList();
	int steps;

	public Karakter() {

	}

	public String getKapi() {
		return kapi;
	}

	public void setKapi(String kapi) {
		this.kapi = kapi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Lokasyon getCurrentlocation() {
		return currentlocation;
	}

	public void setCurrentlocation(Lokasyon currentlocation) {
		this.currentlocation = currentlocation;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int can) {
		this.puan = puan;
	}

}



