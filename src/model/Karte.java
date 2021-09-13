package model;

import javax.swing.*;

/**
 * Memory-Spiel
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 01.07.2021
 */
public class Karte {
    private ImageIcon bild;
    private String bezeichnung;
    private int index;
    private int punkt = 1;



    public Karte(){}

    public Karte(ImageIcon bild, String bezeichnung, int index){
       setBild(bild);
       setBezeichnung(bezeichnung);
       setIndex(index);
    }


    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setBild(ImageIcon bild) {
        this.bild = bild;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ImageIcon getBild() {
        return bild;
    }

    public int getIndex() {
        return index;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getPunkt() {
        return punkt;
    }

}
