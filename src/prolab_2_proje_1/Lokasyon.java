package prolab_2_proje_1;
import java.util.ArrayList;

public class Lokasyon {

	private int x;
	private int y;
	Boolean duvar;

	ArrayList<Lokasyon> shortpath;
	int cost;
	
	public Lokasyon() {
		duvar=false;
		cost=0;
		this.shortpath=new ArrayList<Lokasyon>();
	}
	public Lokasyon(int x,int y) {
		this.x=x;
		this.y=y;
		this.duvar=false;
		this.shortpath=new ArrayList<Lokasyon>();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
