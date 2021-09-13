package model;

/**
 * Memory-Spiel
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 22.06.2021
 */
public class Spieler {
    private String name;
    private int punkte;
    private double zeit;
    private Boolean status;

    public Spieler(){}

    public Spieler(String name, int punkte){
        setName(name);
        setPunkte(punkte);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setZeit(double zeit) {
        this.zeit = zeit;
    }

    public Boolean getStatus() {
        return status;
    }

    public double getZeit() {
        return zeit;
    }

    public int getPunkte() {
        return punkte;
    }

    public String getName() {
        return name;
    }
}
