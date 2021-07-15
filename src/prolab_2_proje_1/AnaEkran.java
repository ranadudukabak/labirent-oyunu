package prolab_2_proje_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnaEkran extends JPanel implements ActionListener, KeyListener {

    Timer timer = new Timer(5, this);

    static Thread altinolusturma = null;
    private int sirineX = 850;
    private int sirineY = 425;
    private BufferedImage altinImage;
    private BufferedImage mantarImage;
    private BufferedImage sirineImage;//Sirine'nin gorseli icin.
    private BufferedImage gozlukluSirinImage;//Gozluklu Sirin'in gorseli icin.
    private BufferedImage tembelSirinImage;//Tembel Sirin'in gorseli icin.
    private BufferedImage gargamelImage;//Gargamel'in gorseli icin.
    private BufferedImage azmanImage;//Azman'in gorseli icin.

    private int gargamelX;
    private int gargamelY;
    private int gargamelKoordinasyonX = 50;
    private int gargamelKoordinasyonY = 50;

    private int azmanX;
    private int azmanY;
    private int azmanKoordinasyonX = 50;
    private int azmanKoordinasyonY = 50;
    private int gozlukluSirinX = 500;
    private int gozlukluSirinY = 325;
    private int gozlukluSirinKoordinasyonX = 50;
    private int gozlukluSirinKoordinasyonY = 50;

    private int tembelSirinX = 500;
    private int tembelSirinY = 325;
    private int tembelSirinKoordinasyonX = 50;
    private int tembelSirinKoordinasyonY = 50;

    Boolean Oyunbitti = false;

    int iyix;
    int iyiy;

    private int[][] mazearray = new int[11][13];

    String str;
    String[] dusmankarakter2 = null;
    String[] dusmankarakter1 = null;
    String[] str3 = null;
    String karakter1 = null;
    String kapi1 = null;
    String karakter2 = null;
    String kapi2 = null;

    int h = 0;
    int k = 0;
    int lineNumber = 0;
    Karakter iyikarakter;
    Altin altın;
    Karakter kotukarakter1;
    ArrayList<String> characters = new ArrayList<String>();
    ArrayList<String> maze = new ArrayList<String>();

    ArrayList<Karakter> kotukarakter = new ArrayList<Karakter>();

    Random random;
    Karakter gecicikotukarakter = new Karakter();

    public AnaEkran() throws IOException {

        if (Giris_Ekrani.hangisi == true) {
            iyikarakter = new Gozluklu_Sirin();
            iyikarakter.setName("gozluklusirin");
        } else if (Giris_Ekrani.hangisi == false) {
            iyikarakter = new Tembel_Sirin();
            iyikarakter.setName("tembelsirin");
        }
        Lokasyon iyikarakterlocasyonu = new Lokasyon(6, 5);
        iyikarakter.setCurrentlocation(iyikarakterlocasyonu);
        iyix = iyikarakter.currentlocation.getX() * 50 + 200;
        iyiy = iyikarakter.currentlocation.getY() * 50 + 75;

        BufferedReader filein = null;
        try {

            filein = new BufferedReader(new FileReader("C:\\Users\\rana\\Desktop\\Prolab_2_Proje_1\\src\\prolab_2_proje_1\\harita.txt"));
            String row;

            while ((row = (String) filein.readLine()) != null) {

                //System.out.println(row);
                //row of character details
                if (row.startsWith("Karakter")) {
                    characters.add(row);
                } //row of maze details
                else if (row.startsWith("0") || row.startsWith("1")) {
                    maze.add(row);
                }
            }

        } catch (IOException e) {

        }

        filein.close();

        labirent();
        kotukarakterler();

        try {
            mantarImage = ImageIO.read(new FileImageInputStream(new File("Mantar.png")));
            altinImage = ImageIO.read(new FileImageInputStream(new File("Altin.png")));
            sirineImage = ImageIO.read(new FileImageInputStream(new File("Sirine.png")));
            gozlukluSirinImage = ImageIO.read(new FileImageInputStream(new File("Gozluklu_Sirin.png")));
            tembelSirinImage = ImageIO.read(new FileImageInputStream(new File("Tembel_Sirin.png")));
            gargamelImage = ImageIO.read(new FileImageInputStream(new File("Gargamel.png")));
            azmanImage = ImageIO.read(new FileImageInputStream(new File("Azman.png")));
        } catch (IOException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.start();
    }

    private void labirent() {

        for (int i = 0; i < maze.size(); i++) {

            String row[] = maze.get(i).split("\\s+");

            for (int j = 0; j < row.length; j++) {
               
                mazearray[i][j] = Integer.valueOf(row[j]);

                if (mazearray[i][j] == 0) {

                }

            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(mazearray[i][j]);
                System.out.print("     ");
            }
            System.out.println("\n");
        }

    }

    private void kotukarakterler() {

        for (int i = 0; i < characters.size(); i++) {
            String row = characters.get(i);
            String splittedrow[] = row.split("\\W");
            
            if (splittedrow[1].equalsIgnoreCase("gargamel")) {

                Karakter gargamel = new Gargamel();
                gargamel.setName("gargamel");
                gargamel.setType("kotu");

                gargamel.setKapi(splittedrow[3]);
                gargamel.setCurrentlocation(kapi(splittedrow[3]));
                kotukarakter.add(gargamel);

            } else if (splittedrow[1].equalsIgnoreCase("azman")) {

                Karakter azman = new Azman();

                azman.setName("azman");
                azman.setType("kotu");
                azman.setKapi(splittedrow[3]);
                azman.setCurrentlocation(kapi(splittedrow[3]));
                kotukarakter.add(azman);
            } else {
                System.out.println("encountered an unknown character");

            }
        }

    }

    private Lokasyon kapi(String kapi) {

        if (kapi.equalsIgnoreCase("A")) {
            return new Lokasyon(3, 0);
        } else if (kapi.equalsIgnoreCase("B")) {
            return new Lokasyon(10, 0);
        } else if (kapi.equalsIgnoreCase("C")) {
            return new Lokasyon(0, 5);
        } else if (kapi.equalsIgnoreCase("D")) {
            return new Lokasyon(3, 11);
        }

        return null;

    }

    //@Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        g.setColor(Color.blue);
        setBackground(Color.BLACK);

        int dx = 50;
        int dy = 50;
        for (int i = 75; i < 625; i = i + dx) {
            for (int j = 200; j < 850; j = j + dy) {

                g.drawRect(j, i, dx, dy);
            }
        }
        int c = 200;
        int d = 75;
        g.setColor(Color.GRAY);
        for (int a = 0; a < 11; a++) {
            c = 200;
            for (int b = 0; b < 13; b++) {
                if (mazearray[a][b] == 0) {
                    g.fillRect(c, d, dx, dy);
                    c = c + 50;
                } else {
                    c = c + 50;
                }

            }
            d = d + 50;
        }
// sirine
        g.drawImage(sirineImage, sirineX, sirineY, 50, 50, this);
        //iyi karakter
        if (iyikarakter.getName().equalsIgnoreCase("gozluklusirin")) {
            g.drawImage(gozlukluSirinImage, iyix, iyiy, 50, 50, this);
        } else if (iyikarakter.getName().equalsIgnoreCase("tembelsirin")) {
            g.drawImage(tembelSirinImage, iyix, iyiy, 50, 50, this);
        }

        //kotu karakter
        for (int ki = 0; ki < kotukarakter.size(); ki++) {

            gecicikotukarakter = kotukarakter.get(ki);

            int kotux = gecicikotukarakter.currentlocation.getX() * 50 + 200;
            int kotuy = gecicikotukarakter.currentlocation.getY() * 50 + 75;
            if (gecicikotukarakter.getName().equalsIgnoreCase("gargamel")) {
                g.drawImage(gargamelImage, kotux, kotuy, 50, 50, this);
            } else if (gecicikotukarakter.name.equalsIgnoreCase("azman")) {
                g.drawImage(azmanImage, kotux, kotuy, 50, 50, this);
            }

        }

        if (Oyunbitti == true) {
            //KAZANDINIZ

            g.setColor(Color.BLACK);
            g.fillRect(300, 150, 450, 300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 50));
            g.drawString("KAZANDIN!", 400, 300);
        }

        //puan
        g.setColor(Color.blue);
        g.fillRect(400, 650, 300, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(iyikarakter.getName() + " in puanı : " + iyikarakter.getPuan(), 425, 675);
//oyun kontrolu
        if (Oyunbitti == false) {
            if (iyikarakter.getPuan() <= 0) {
                g.setColor(Color.BLACK);
                g.fillRect(300, 150, 450, 300);
                g.setColor(Color.WHITE);
                g.setFont(new Font("TimesRoman", Font.BOLD, 50));
                g.drawString("KAYBETTIN!", 400, 300);
            }
        }

////ALTIN OBJESI
        Random random = new Random();
        if (Oyunbitti == false && iyikarakter.getPuan() > 0) {
            ArrayList<Integer> eklex = new ArrayList<Integer>();
            ArrayList<Integer> ekley = new ArrayList<Integer>();

            while (eklex.size() <= 5 && ekley.size() <= 5) {
                for (int ki = 0; ki < kotukarakter.size(); ki++) {
                    gecicikotukarakter = kotukarakter.get(ki);
                    int kotux = gecicikotukarakter.currentlocation.getX();
                    int kotuy = gecicikotukarakter.currentlocation.getY();

                    int a = random.nextInt(13);
                    int b = random.nextInt(11);
                    int x = iyikarakter.currentlocation.getX();
                    int y = iyikarakter.currentlocation.getY();
                    if (gecicikotukarakter.getName().equalsIgnoreCase("gargamel")) {

                        if (mazearray[b][a] == 1 && a != x && b != y && a != kotux && b != kotuy) {

                            eklex.add(a);
                            ekley.add(b);

                        }
                    }
                    if (gecicikotukarakter.getName().equalsIgnoreCase("azman")) {

                        if (mazearray[b][a] == 1 && a != iyikarakter.currentlocation.getX() && b != iyikarakter.currentlocation.getY()) {

                            eklex.add(a);
                            ekley.add(b);

                        }
                    }
                }
            }

            int p = iyikarakter.getPuan();
            for (int i = 0; i < 5; i++) {

                g.drawImage(altinImage, eklex.get(i) * 50 + 200, ekley.get(i) * 50 + 75, 50, 50, this);
                if (iyix == eklex.get(i) && iyiy == ekley.get(i)) {
                    p = iyikarakter.getPuan();
                    p = iyikarakter.getPuan() + 5;
                    iyikarakter.setPuan(p);
                }
            }
        }

        ////MANTAR OBJESI
        if (Oyunbitti == false && iyikarakter.getPuan() > 0) {
            for (int ki = 0; ki < kotukarakter.size(); ki++) {
                gecicikotukarakter = kotukarakter.get(ki);
                int kotux = gecicikotukarakter.currentlocation.getX();
                int kotuy = gecicikotukarakter.currentlocation.getY();

                int a = random.nextInt(13);
                int b = random.nextInt(11);
                int x = iyikarakter.currentlocation.getX();
                int y = iyikarakter.currentlocation.getY();
                int p = iyikarakter.getPuan();
                if (gecicikotukarakter.getName().equalsIgnoreCase("gargamel")) {

                    if (mazearray[b][a] == 1 && a != x && b != y && a != kotux && b != kotuy) {
                        if (iyix == a && iyiy == b) {
                            p = iyikarakter.getPuan();
                            p = iyikarakter.getPuan() + 50;
                            iyikarakter.setPuan(p);
                        }
                        g.drawImage(mantarImage, a * 50 + 200, b * 50 + 75, 50, 50, this);

                    }

                }
                if (gecicikotukarakter.getName().equalsIgnoreCase("azman")) {

                    if (mazearray[b][a] == 1 && a != x && b != y) {
                        if (iyix == a && iyiy == b) {
                            p = iyikarakter.getPuan();
                            p = iyikarakter.getPuan() + 50;
                            iyikarakter.setPuan(p);
                        }
                        g.drawImage(mantarImage, a * 50 + 200, b * 50 + 75, 50, 50, this);

                    }
                }
            }
        }

        //ENKISAYOL  
        int kotux, kotuy;
        if (Oyunbitti == false) {
            for (int i = 0; i < kotukarakter.size(); i++) {
                gecicikotukarakter = kotukarakter.get(i);

                kotux = gecicikotukarakter.currentlocation.getX() * 50 + 200;

                Karakter geciciLokasyon = kotukarakter.get(i);

                if (gecicikotukarakter.getName().equalsIgnoreCase("gargamel")) {
                    for (int j = 0; j < geciciLokasyon.enkisayol.size() - 1; j++) {
                        Lokasyon loc = geciciLokasyon.enkisayol.get(j);
                        int pathx, pathy;
                        pathx = loc.getX() * 50 + 200;
                        pathy = loc.getY() * 50 + 75;
                        g.setColor(Color.PINK);
                        g.fillRect(pathx, pathy, 50, 50);
                    }
                }
                if (gecicikotukarakter.getName().equalsIgnoreCase("azman")) {
                    for (int j = 0; j < geciciLokasyon.enkisayol.size() - 1; j++) {
                        Lokasyon loc = geciciLokasyon.enkisayol.get(j);
                        int pathx, pathy;
                        pathx = loc.getX() * 50 + 200;
                        pathy = loc.getY() * 50 + 75;
                        g.setColor(Color.RED);
                        g.fillRect(pathx, pathy, 50, 50);
                    }
                }

            }

        }
    }

    private void yolhesapla() {

        for (int i = 0; i < kotukarakter.size(); i++) {

            if (kotukarakter.get(i).getName().equalsIgnoreCase("gargamel")) {
                Gargamel gargamel = (Gargamel) kotukarakter.get(i);
                gargamel.setbinaryMaze(mazearray);
                gargamel.sethedefKarakter(iyikarakter.currentlocation);
                gargamel.EnKisaYol();
                kotukarakter.set(i, gargamel);
            } else if (kotukarakter.get(i).getName().equalsIgnoreCase("azman")) {
                Azman azman = (Azman) kotukarakter.get(i);
                azman.setbinaryMaze(mazearray);
                azman.sethedefKarakter(iyikarakter.currentlocation);
                azman.EnKisaYol();
                kotukarakter.set(i, azman);
            }

        }

    }

    @Override
    public void repaint() {

        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();
        int yenix;
        int yeniy;
        int p = iyikarakter.getPuan();
        int kotux, kotuy;

        if (c == KeyEvent.VK_LEFT) {

            // TEMBEL SIRIN SOL
            if (iyikarakter.getName().equalsIgnoreCase("tembelsirin")) {
                if (iyix <= 200) {
                    iyix = 200;
                    yenix = (iyix - 200) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                } else {
                    iyix -= tembelSirinKoordinasyonX;
                    iyiy = iyiy + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix] == 0) {

                        iyix += tembelSirinKoordinasyonX;
                        iyikarakter.currentlocation.setX(yenix);
                    }
                }

            }
                 
            //GOZLUKLU SIRIN SOL
            if (iyikarakter.getName().equalsIgnoreCase("gozluklusirin")) {

                if (iyix <= 200) {
                    iyix = 200;
                    yenix = (iyix - 200) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                } else {
                    iyix -= gozlukluSirinKoordinasyonX;
                    iyiy = iyiy + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix + 1] == 0) {
                        iyix += 100;
                        yenix = (iyix - 200) / 50;

                        iyikarakter.currentlocation.setX(yenix);
                    } else if (mazearray[yeniy][yenix] == 0) {
                        iyix += 100;
                        yenix = (iyix - 200) / 50;

                        iyikarakter.currentlocation.setX(yenix);
                    }

                }

            }

        } else if (c == KeyEvent.VK_RIGHT) {
            //TEMBEL SIRIN SAG
            if (iyikarakter.getName().equalsIgnoreCase("tembelsirin")) {
                if (iyix >= 800) {
                    iyix = 800;
                    yenix = (iyix - 200) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                } else {
                    iyix += tembelSirinKoordinasyonX;
                    iyiy = iyiy + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix] == 0) {
                        iyix -= tembelSirinKoordinasyonX;
                        yenix = (iyix - 200) / 50;

                        iyikarakter.currentlocation.setX(yenix);

                    }

                    if (iyix == 800 && iyiy == 425) {
                        oyunbittimi();
                    }
                }
            }

//GOZLUKLU SIRIN SAG
            if (iyikarakter.getName().equalsIgnoreCase("gozluklusirin")) {
                if (iyix >= 800) {
                    iyix = 800;
                    yenix = (iyix - 200) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                } else {
                    iyix += gozlukluSirinKoordinasyonX;
                    iyiy = iyiy + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix - 1] == 0) {
                        iyix -= gozlukluSirinKoordinasyonX;
                        yenix = (iyix - 200) / 50;

                        iyikarakter.currentlocation.setX(yenix);

                    } else if (mazearray[yeniy][yenix] == 0) {
                        iyix -= gozlukluSirinKoordinasyonX;
                        yenix = (iyix - 200) / 50;

                        iyikarakter.currentlocation.setX(yenix);
                    }
                    if (iyix == 800 && iyiy == 425) {
                        oyunbittimi();
                    }

                }

            }

        } else if (c == KeyEvent.VK_DOWN) {
            //TEMBEL SIRIN ASAGI

            if (iyikarakter.getName().equalsIgnoreCase("tembelsirin")) {
                if (iyiy >= 575) {
                    iyiy = 575;

                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setY(yeniy);
                } else {
                    iyiy += tembelSirinKoordinasyonY;
                    iyix = iyix + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix] == 0) {
                        iyiy -= tembelSirinKoordinasyonY;
                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);
                    }
                }

            }

            //GOZLUKLU SIRIN ASAGI
            if (iyikarakter.getName().equalsIgnoreCase("gozluklusirin")) {
                if (iyiy >= 575) {
                    iyiy = 575;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setY(yeniy);
                } else {
                    iyiy += gozlukluSirinKoordinasyonY;
                    iyix = iyix + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy - 1][yenix] == 0) {
                        iyiy -= gozlukluSirinKoordinasyonY;

                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);
                    } else if (mazearray[yeniy][yenix] == 0) {
                        iyiy -= gozlukluSirinKoordinasyonY;

                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);
                    }
                }
            }

        } else if (c == KeyEvent.VK_UP) {

            // TEMBEL SIRIN YUKARI
            if (iyikarakter.getName().equalsIgnoreCase("tembelsirin")) {
                if (iyiy <= 75) {
                    iyiy = 75;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setY(yeniy);
                } else {
                    iyiy -= tembelSirinKoordinasyonY;
                    iyix = iyix + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);

                    iyikarakter.currentlocation.setY(yeniy);

                    if (mazearray[yeniy][yenix] == 0) {
                        iyiy += tembelSirinKoordinasyonY;

                        yeniy = (iyiy - 75) / 50;

                        iyikarakter.currentlocation.setY(yeniy);
                    }

                }

            }

            //GOZLUKLU SIRIN YUKARI
            if (iyikarakter.getName().equalsIgnoreCase("gozluklusirin")) {
                if (iyiy <= 75) {
                    iyiy = 75;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setY(yeniy);
                } else {
                    iyiy -= gozlukluSirinKoordinasyonY;
                    iyix = iyix + 0;
                    yenix = (iyix - 200) / 50;
                    yeniy = (iyiy - 75) / 50;
                    iyikarakter.currentlocation.setX(yenix);
                    iyikarakter.currentlocation.setY(yeniy);

                    if (yeniy < 0) {
                        iyiy += gozlukluSirinKoordinasyonY;

                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);
                    } else if (mazearray[yeniy + 1][yenix] == 0) {

                        iyiy += gozlukluSirinKoordinasyonY;

                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);
                    } else if (mazearray[yeniy][yenix] == 0) {
                        iyiy += gozlukluSirinKoordinasyonY;
                        yeniy = (iyiy - 75) / 50;
                        iyikarakter.currentlocation.setY(yeniy);

                    }

                }

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (Oyunbitti == false) {
            int p = iyikarakter.getPuan();
            int kotux, kotuy;

            yolhesapla();
            for (int ki = 0; ki < kotukarakter.size(); ki++) {

                gecicikotukarakter = kotukarakter.get(ki);

                kotux = gecicikotukarakter.currentlocation.getX() * 50 + 200;
                kotuy = gecicikotukarakter.currentlocation.getY() * 50 + 75;

                if (gecicikotukarakter.getName().equalsIgnoreCase("gargamel")) {
                    if (kotux == iyix && kotuy == iyiy) {
                        p = iyikarakter.getPuan();
                        p = iyikarakter.getPuan() - 15;
                        iyikarakter.setPuan(p);

                        break;
                    }
                } else if (gecicikotukarakter.name.equalsIgnoreCase("azman")) {
                    if (kotux == iyix && kotuy == iyiy) {
                        p = iyikarakter.getPuan();
                        p = iyikarakter.getPuan() - 5;
                        iyikarakter.setPuan(p);

                    }
                }
            }
        }

        try {
            Thread.sleep(1000, 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();

    }

    private void oyunbittimi() {
        if (iyikarakter.currentlocation.getX() == 12 && iyikarakter.currentlocation.getY() == 7) {
            this.Oyunbitti = true;
            //repaint();
        }

    }

    private Boolean duvar(int x, int y) {
        if (mazearray[y][x] == 1) {
            return false;
        }

        return true;
    }

}


