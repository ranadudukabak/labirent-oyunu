package prolab_2_proje_1;
import java.util.ArrayList;

public class Gargamel extends Karakter  {
ArrayList<Lokasyon> ziyaretEdildi=new ArrayList();
ArrayList<Lokasyon> ziyaretEdilecekDugum=new ArrayList();
Lokasyon hedefKarakter;
Lokasyon enKisaYolMatrisi[][];
int binaryMaze[][];

public void setbinaryMaze(int matrix[][]) {
		binaryMaze=new int[11][13];
		this.binaryMaze=matrix.clone();
	}
public void sethedefKarakter(Lokasyon iyikarakter) {
		this.hedefKarakter=iyikarakter;
		this.enkisayol.removeAll(enkisayol);
		this.ziyaretEdilecekDugum.add(this.currentlocation);
		EnKisaYolLokasyonu();
	}
	private void EnKisaYolLokasyonu() {
		enKisaYolMatrisi=new Lokasyon[11][13];
		for(int y=0;y<binaryMaze.length;y++) {

			for(int x=0;x<binaryMaze[y].length;x++) {
				Lokasyon geciciLokasyon=new Lokasyon(x,y);
				if(binaryMaze[y][x]==0) {
					geciciLokasyon.duvar=true;
                                        ziyaretEdildi.add(geciciLokasyon);
				}
				enKisaYolMatrisi[y][x]=geciciLokasyon;
			}
		}
	}
        

    private boolean nodeziyaretEdildi(Lokasyon temp) {

        for (int i = 0; i < this.ziyaretEdildi.size(); i++) {

            if ((ziyaretEdildi.get(i).getX() == temp.getX()) && (ziyaretEdildi.get(i).getY() == temp.getY())) {

                return true;
            }
        }

        return false;
    }

    private void ZiyaretEdilecekDugumuGuncelle(Lokasyon temp) {

        boolean done = false;

        for (int i = 0; i < ziyaretEdilecekDugum.size(); i++) {
            if (temp.cost < ziyaretEdilecekDugum.get(i).cost) {
                ziyaretEdilecekDugum.add(i, temp);
                done = true;
                break;
            }
        }
        if (!done) {
            ziyaretEdilecekDugum.add(temp);
        }

    }

    public void EnKisaYol() {

        int hedefKarakterx, hedefKaraktery;
        hedefKarakterx = this.hedefKarakter.getX();
        hedefKaraktery = this.hedefKarakter.getY();

        int x, y;
        Lokasyon visiting;

        if (ziyaretEdilecekDugum.size() > 0) {
            visiting = ziyaretEdilecekDugum.get(0);
            x = visiting.getX();
            y = visiting.getY();

            if (hedefKarakterx == x && hedefKaraktery == y) {

                this.enkisayol = (ArrayList<Lokasyon>) visiting.shortpath.clone();

                visiting.shortpath.removeAll(enkisayol);
                ziyaretEdilecekDugum.removeAll(ziyaretEdilecekDugum);
                ziyaretEdildi.removeAll(ziyaretEdildi);

                if (this.enkisayol.size() <= 1) {

                    //yakaladik onu
                    this.currentlocation.setX(hedefKarakterx);
                    this.currentlocation.setY(hedefKaraktery);

                    //System.out.println("------------------>yakaladim seni");
                } else {
                    this.currentlocation.setX(this.enkisayol.get(0).getX());
                    this.currentlocation.setY(this.enkisayol.get(0).getY());
                    this.enkisayol.remove(0);

                }

                return;
            } else {

                ziyaretEdildi.add(visiting);
                ziyaretEdilecekDugum.remove(0);

                //visit top 
                if (y - 1 >= 0) {
                    if (!nodeziyaretEdildi(enKisaYolMatrisi[y - 1][x])) {

                        Lokasyon geciciLokasyon = enKisaYolMatrisi[y - 1][x];

                        if (geciciLokasyon.cost == 0 || (visiting.cost <= geciciLokasyon.cost + 1)) {

                            geciciLokasyon.cost = visiting.cost + 1;
                            geciciLokasyon.shortpath = (ArrayList<Lokasyon>) visiting.shortpath.clone();
                            geciciLokasyon.shortpath.add(geciciLokasyon);
                            ZiyaretEdilecekDugumuGuncelle(geciciLokasyon);
                            //System.out.println("top ziyaretEdildi");	

                        }
                    }

                }

                //visit right
                if (x + 1 <= 12) {
                    if (!nodeziyaretEdildi(enKisaYolMatrisi[y][x + 1])) {
                        Lokasyon geciciLokasyon = enKisaYolMatrisi[y][x + 1];

                        if (geciciLokasyon.cost == 0 || (visiting.cost <= geciciLokasyon.cost + 1)) {

                            geciciLokasyon.cost = visiting.cost + 1;
                            geciciLokasyon.shortpath = (ArrayList<Lokasyon>) visiting.shortpath.clone();
                            geciciLokasyon.shortpath.add(geciciLokasyon);
                            ZiyaretEdilecekDugumuGuncelle(geciciLokasyon);
                            //System.out.println("right ziyaretEdildi");	

                        }
                    }

                }

                //visit bottom
                if (y + 1 <= 10) {
                    if (!nodeziyaretEdildi(enKisaYolMatrisi[y + 1][x])) {
                        Lokasyon geciciLokasyon = enKisaYolMatrisi[y + 1][x];

                        if (geciciLokasyon.cost == 0 || (visiting.cost <= geciciLokasyon.cost + 1)) {

                            geciciLokasyon.cost = visiting.cost + 1;
                            geciciLokasyon.shortpath = (ArrayList<Lokasyon>) visiting.shortpath.clone();
                            geciciLokasyon.shortpath.add(geciciLokasyon);
                            ZiyaretEdilecekDugumuGuncelle(geciciLokasyon);
                            //System.out.println("bottom ziyaretEdildi");	

                        }
                    }

                }

                //visit left
                if (x - 1 >= 0) {
                    if (!nodeziyaretEdildi(enKisaYolMatrisi[y][x - 1])) {

                        Lokasyon geciciLokasyon = enKisaYolMatrisi[y][x - 1];

                        if (geciciLokasyon.cost == 0 || (visiting.cost <= geciciLokasyon.cost + 1)) {

                            geciciLokasyon.cost = visiting.cost + 1;
                            geciciLokasyon.shortpath = (ArrayList<Lokasyon>) visiting.shortpath.clone();
                            geciciLokasyon.shortpath.add(geciciLokasyon);
                            ZiyaretEdilecekDugumuGuncelle(geciciLokasyon);
                            //System.out.println("left ziyaretEdildi");	

                        }
                    }
                }
                EnKisaYol();
            }
        }
    }

    public void ZiyaretEdilecekDugumlerinListesi() {
        System.out.println("\n-----------------visit next list");
        for (int i = 0; i < ziyaretEdilecekDugum.size(); i++) {
            System.out.println(ziyaretEdilecekDugum.get(i).getX() + "  " + ziyaretEdilecekDugum.get(i).getY());
        }
        System.out.println("\n-----------------");
    }

    public void kisayolugoster() {
        for (int i = 0; i < this.enkisayol.size(); i++) {
            System.out.println(enkisayol.get(i).getX() + "   " + enkisayol.get(i).getY());
        }
    }
    
    public void Ilerle() {//Dusman 2 birim ilerler.

    }
}
