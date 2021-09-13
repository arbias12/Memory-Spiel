package controller;

import java.util.concurrent.TimeUnit;

/**
 * Memory-Spiel
 *
 * @author Arbias imeri
 * @version 1.2
 * @since 22.06.2021
 */
public class Timer {
    private Boolean x = true;
    private long displayMinutes = 0;
    private long starttime;
    private long timepassed;
    private long secondpassed;

    public void incDisplayMinutes() {
        displayMinutes++;
    }


    public void stoppen() {
        this.x = false;

    }
    public void setStarttime() {
        this.starttime = System.currentTimeMillis();
    }

    public void setTimepassed() {
        this.timepassed = System.currentTimeMillis() - starttime;
    }

    public void TimepassedInSeconds() {
        this.secondpassed = timepassed / 1000;
    }

    public void setSecondpassed(long secondpassed) {
        this.secondpassed = secondpassed;
    }

    public Timer() {
        setStarttime();
        try {
            anzeigen();
        }catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }

    }

        public void anzeigen() throws InterruptedException {
            System.out.println("Timer:");
            while (x) {
                TimeUnit.SECONDS.sleep(1);
                setTimepassed();
                TimepassedInSeconds();
                if (getSecondpassed() == 60) {
                    setSecondpassed(0);
                    setStarttime();
                }
                if ((getSecondpassed() % 60) == 0)
                    incDisplayMinutes();
                System.out.println(getDisplayMinutes() + ":" + getSecondpassed());
                if (getSecondpassed() == 10){
                    stoppen();
                }


            }
        }

    public long getSecondpassed() {
        return secondpassed;
    }

    public long getDisplayMinutes() {
        return displayMinutes;
    }

    public long getStarttime() {
        return starttime;
    }

    public long getTimepassed() {
        return timepassed;
    }

    public Boolean getX() {
        return x;
    }


    public static void main(String[] args) {
        Timer timer = new Timer();
        if (timer.getSecondpassed() == 10){
            System.out.println(timer.getSecondpassed());
        }
    }

}


