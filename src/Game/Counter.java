package Game;

import Graphics.View;

import java.util.List;

/**
 * A számláló osztály, leszármazik a Thread osztályból.
 * Felelőssége a vonatok léptetése, de a skeletonban ilyen követelmény nincs,
 * így itt nincs szerepe.
 */
public class Counter extends Thread {

    private int stepTime;
    private Thread t;
    private String name;
    private boolean isRunning;
    private List<Train> controlledTrains;
    private View v;

    /**
     * A konstruktor
     * @param stepTime Az időköz, amikben léptetni szeretnénk a vonatokat
     * @param n A szál neve
     * @param trains A modelben lévő vonatok
     * (Új vonat esetén nyilván nem indul el magától, újra kell indítani)
     */
    public Counter(int stepTime, String n, List<Train> trains, View v){
        this.v = v;
        this.stepTime = stepTime;
        name = n;
        isRunning = false;
        controlledTrains = trains;
    }

    /**
     * Szál elindítása
     */
    public void start(){
        if(t == null){
            t = new Thread(this, name);
            isRunning = true;
            t.start();
        }
    }

    /**
     * A szál fut amíg az isRunning igaz
     * Minden ciklusban lépteti a modelben lévő vonatokat
     */
    public void run() {
        try{
            while(isRunning) {
                t.sleep(stepTime);
                for(Train train : controlledTrains){
                    train.awakeLocomotive();
                    v.DrawAll();
                }



            }
        }
         catch (InterruptedException e) {
           System.out.println("Stopped "+ e );
        }
    }

    /**
     * A szál megállítása
     */
    public void stopThread(){
            isRunning = false;

    }

    }
