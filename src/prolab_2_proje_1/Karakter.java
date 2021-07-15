package prolab_2_proje_1;
import java.awt.Color;
import java.util.ArrayList;

/* 
Karakterlerin adini tutacak ID, Ad, Turunu (oyuncu/dusman) tutacak.
Karakterlerin ilerledigi koordinatlari tutacak Lokasyon degiskenleri olmalidir.
Constructor, Get, Set ve EnKisaYol metotları yer almalidir.
*/

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
