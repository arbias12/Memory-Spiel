package view;

import model.Spieler;

import java.util.Vector;

/**
 * Memory-Spiel
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 01.07.2021
 */
public class Auswertung {
    private Vector<Spieler> spielerSammlung;
    private Vector<Spieler> multiPlayer;

    public Auswertung(){
        spielerSammlung = new Vector<>();
    }
    public void sortieren(){
    }
    public void vergleicheMultiplayer(){
        if (multiPlayer.get(0).getPunkte() < multiPlayer.get(1).getPunkte()){
            System.out.println("model.Spieler: " + multiPlayer.get(1).getName() + " hat gewonnen");
        }else if(multiPlayer.get(0).getPunkte() > multiPlayer.get(1).getPunkte()){
            System.out.println("model.Spieler: " + multiPlayer.get(0).getName() + " hat gewonnen");
        }else {
            System.out.println("Es ist gleichstand");
        }
    }
}
