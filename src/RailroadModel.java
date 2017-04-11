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

    public void CommandExecution(String c){

        if(c == null){
            return;
        }

        String mapName;
        String trainName;
        String locomotiveName;
        String mapElement;
        String carName;
        String color;
        String passengers;
        String step;
        String switchName;
        String switchState;
        String Tenter1;
        String Tenter2;
        String stationName;

        String [] command = c.split(" ");

        switch (command[0]){
            case "help":
                break;

            case "loadMap":
                mapName = command[1];
                break;

            case "listMapElements":
                break;

            case "listTrain":
                trainName = command[1];
                break;

            case "listTrains":
                break;

            case "addLocomotive":
                trainName = command[1];
                locomotiveName = command[2];
                mapElement = command[3];
                break;

            case "addPassengerCarToLocomotive":
                locomotiveName = command[1];
                carName = command[2];
                color = command[3];
                passengers = command[4];
                break;

            case "addHopperCarToLocomotive":
                locomotiveName = command[1];
                carName = command[2];
                break;

            case "stepLocomotive":
                locomotiveName = command[1];
                step = command[2];
                break;

            case "stepAll":
                step = command[1];
                break;

            case "run":
                break;

            case "stop":
                break;

            case "changeSwitch":
                switchName = command[1];
                switchState = command[2];
                break;

            case "buildTunnel":
                Tenter1 = command[1];
                Tenter2 = command[2];
                break;

            case "destroyTunnel":
                break;

            case "readSwitch":
                switchName = command[1];
                break;

            case "changeStationParams":
                stationName =command[1];
                color = command[2];
                passengers = command[3];
                break;

            case "readStationParams":
                stationName = command[1];
                break;

            case "readPassengerCarParams":
                locomotiveName = command[1];
                carName = command[2];
                break;

        }

    }

    public void notEmpty(Train full){

        if(freeTrains.contains(full)){
            freeTrains.remove(full);
        }

    }

    public void clearMode(){

    }

}
