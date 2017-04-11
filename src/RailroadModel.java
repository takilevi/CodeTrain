import java.io.*;
import java.util.*;

/**
 * A program model osztálya.
 * Felelősége azon dolgok végzése, amik globálisan befolyásolját a teljes játékot.
 * (Játék indítás, Játék vége, pálya felépítése.)
 */
public class RailroadModel {

    private static RailroadModel model;
    private List<Train> trainsInModel;
    private List<Train> freeTrains;
    private List<StaticElement> elementsInModel;

    /**
     * Singletonná teszi az osztályt.
     * @return Visszatér a modelel, illetve ha még nem létezne, létrehozza
     */
    public static RailroadModel getInstance()
    {
        if(model == null)
        {
            model = new RailroadModel();
        }
        return model;
    }


    /**
     * Privát konstruktor.
     */
   private RailroadModel(){}

    /**
     * A pályaelemek inicíalizálása, pálya létrehozása.
     */
    public void initFieldElements() {
        trainsInModel = null;
        freeTrains = null;
        elementsInModel = null;
    }

    /**
     * Játék elindítása (A szkeletonban nincs még ilyen viselkedés.)
     */
    public void startGame(){}

    /**
     * A játék véget ért.
     */
    public void finishGame(int code){

    }

    /**
     * Ha egy vonat összes kocsija kiürült, akkor csökenti a teli vonatok számát a modelben,
     * illetve ha ez a szám nulla, meghívja  a finishgamet.
     * (Szerepe csak akkor lesz, amikor több vonat kerül a modelbe)
     */
    public void emptyTrain(Train empty){

        if(!freeTrains.contains(empty)){
            freeTrains.add(empty);
        }
    }

    public void CommandExecution(String command){

    }

    public void notEmpty(Train full){

        if(freeTrains.contains(full)){
            freeTrains.remove(full);
        }

    }

    public void clearMode(){

    }

}
