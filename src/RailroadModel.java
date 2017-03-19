import java.io.*;
import java.util.*;

/**
 * A program model osztálya.
 * Felelősége azon dolgok végzése, amik globálisan befolyásolját a teljes játékot.
 * (Játék indítás, Játék vége, pálya felépítése.)
 */
public class RailroadModel {

    private static RailroadModel model;
    protected int trainCount;

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
    public void initFieldElements()
    {
        Depot depot = new Depot();
        TunnelEntrance tunnelEntrance1 = new TunnelEntrance();
        TunnelEntrance tunnelEntrance2 = new TunnelEntrance();
        RailroadSwitch conveyor = new RailroadSwitch();
        Track track1 = new Track();
        Station station = new Station();
        Track track2 = new Track();

        depot.setNextElement(tunnelEntrance1);
        tunnelEntrance1.setElements(depot, tunnelEntrance2);
        tunnelEntrance2.setElements(tunnelEntrance1, conveyor);
        conveyor.setStaticDirection(tunnelEntrance2);
        ArrayList<StaticElement> directions = new ArrayList<StaticElement>();
        directions.add(track1);
        directions.add(track2);
        conveyor.setDynamicDirections(directions);
        track1.setElements(conveyor,station);
        station.setElements(track1,track2);
        track2.setElements(station,conveyor);
    }

    /**
     * Játék elindítása (A szkeletonban nincs még ilyen viselkedés.)
     */
    public void startGame(){}

    /**
     * A játék véget ért.
     */
    public void finishGame(){
        Logger.CallLogging("RailroadModel", "finishGame()");
        Logger.ReturnLogging("RailroadModel", "finishGame()");
    }

    /**
     * Ha egy vonat összes kocsija kiürült, akkor csökenti a teli vonatok számát a modelben,
     * illetve ha ez a szám nulla, meghívja  a finishgamet.
     * (Szerepe csak akkor lesz, amikor több vonat kerül a modelbe)
     */
    public void emptyTrain(){}
}
