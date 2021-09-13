package controller;

import model.Karte;
import model.ListItemValues;
import view.Bedinungsanleitung;
import view.Einstellungen;
import view.Multiplayer;
import view.Singleplayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Memory-Spiel
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 01.07.2021
 */
public class Spielcontroller {
    private Vector<Karte> kartenSammlung;
    private ArrayList<String> descriptions;
    private HashMap<Karte, ImageIcon> map;
    private Vector<ImageIcon> vector;

    public static Boolean singleplayer = false;
    public static Boolean multiplayer = false;
    public static int zahl1;
    public static int zahl2;
    public static int produkt;
    public static int gedreht = 0;


    public Spielcontroller(){
        kartenSammlung = new Vector<>();
        map = new HashMap<>();
        vector = new Vector<>();

        for(int i = 1; i < (produkt / 2) + 1; i++) {
            ImageIcon imageIcon = new ImageIcon("Bilder\\" + i + ".jpg"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            imageIcon.setDescription(String.valueOf(i));

            vector.add(imageIcon);
            vector.add(imageIcon);
        }
        for(int i = 0; i < vector.size(); i++) {
            Karte karte = new Karte();
            map.put(karte, vector.get(i));
        }
    }

    public void startGame(){
        if (singleplayer == true){
            new Singleplayer(zahl1, zahl2, produkt);
        }if (multiplayer==true){
            new Multiplayer(zahl1, zahl2, produkt);
        }else{
            System.out.println("Ein Fehler ist aufgetreten");
        }

    }

    public void option(){
        new Einstellungen(new Frame("JDialog"), new ListItemValues());
    }

    public void vergleicheDieKarten(){}

    public void singleplayer(String anzahl){
        String[] splited = anzahl.split("\\s+");
        zahl1 = Integer.parseInt(splited[0]);
        zahl2 = Integer.parseInt(splited[2]);
        produkt = zahl1*zahl2;
        setSingleplayer(true);

    }

    public static void setMultiplayer(Boolean multiplayer) {
        Spielcontroller.multiplayer = multiplayer;
    }

    public static void setSingleplayer(Boolean singleplayer) {
        Spielcontroller.singleplayer = singleplayer;
    }

    public void multiplayer(String anzahl){
        String[] splited = anzahl.split("\\s+");
        zahl1 = Integer.parseInt(splited[0]);
        zahl2 = Integer.parseInt(splited[2]);
        produkt = zahl1*zahl2;
        setMultiplayer(true);

    }

    public Karte getKarte(int index){
        return kartenSammlung.get(index);
    }

    public void addKarte(Karte karte){
        kartenSammlung.add(karte);
    }

    public int anzahlKarten(){
        return kartenSammlung.size();
    }
    public void bedinungsanleitung(){
        new Bedinungsanleitung(new Frame("Bedinungsanleitung"));
    }




    public String vergleichen(String description) {
        descriptions = new ArrayList<>();
        descriptions.add(description);

        if (descriptions.size() == 2) {
            if (descriptions.get(0).equals(descriptions.get(1))) {
                return "gleich";
            } else {
                return "ungleich";
            }
        }if (descriptions.size() ==1){
            return "fehlend";
        }

        return "fehlend";
    }

    public static int getGedreht() {
        return gedreht;
    }
    public static void incGedreht(){
        gedreht++;
    }

    public static void setGedreht(int gedreht) {
        Spielcontroller.gedreht = gedreht;
    }
}

