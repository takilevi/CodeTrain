import java.io.*;
import java.util.*;

/**
 * A program model osztálya.
 * Felelősége azon dolgok végzése, amik globálisan befolyásolját a teljes játékot.
 * (Játék indítás, Játék vége, pálya felépítése.)
 */
public class RailroadModel {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static RailroadModel model;
    private List<Train> trainsInModel;
    private List<Train> freeTrains;
    private List<StaticElement> elementsInModel;

    //TODO: Ez csak ideiglenes, majd amikor rendesen betölti a pályát, máshova kell menteni
    private String mapName="";

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

        try
        {


        switch (command[0]){
            case "help":
                System.out.println(ANSI_GREEN+"loadMap\t"+ANSI_RED+" loadMap map1.txt \t " + ANSI_BLUE + " Pálya felépítése");
                System.out.println(ANSI_GREEN+"listMapElements\t "+ANSI_RED+"listMapElements \t " + ANSI_BLUE + " Kilistázza a pályaösszes elemét a rajta álló vonatokkal együtt");
                System.out.println(ANSI_GREEN+"listTrain <vonat neve>\t " + ANSI_RED + " listTrain v1 \t " + ANSI_BLUE + " Egyetlen, paraméterben megadott vonatot fog kilistázni, ennek mozdonyát illetve kocsijait (ha vannak).");
                System.out.println(ANSI_GREEN+"listTrains\t " + ANSI_RED + " listTrains \t " + ANSI_BLUE + " Kilistázza a pályán haladó összes vonatot (elemenként) és feltünteti a színüket (ha van) valamint, hogy melyik pálya elemen állnak éppen.");
                System.out.println(ANSI_GREEN+"addLocomotive <vonat neve> <mozdony neve> <pályaelem neve amire kerül>\t " + ANSI_RED + " addLocomotive v4 m3 s4 \t " + ANSI_BLUE + " Egy mozdony ráhelyezése egy megadott pályaelemre, vonat nevének megadása.");
                System.out.println(ANSI_GREEN+"addPassengersCarToLocomotive <mozodony neve> <kocsi neve> <szín> <tartalmaz-e utast>\t " + ANSI_RED + " addPassengersCarToLocomotive m3 k1 red true \t " + ANSI_BLUE + " Egy utasokat szállító/vagy nem szállító kocsit csatolhatunk egy létező mozdonyhoz.");
                System.out.println(ANSI_GREEN+"addHopperCarToLocomotive <mozdony neve> <kocsi neve>\t " + ANSI_RED + " addHopperCarToLocomotive m1 k2 \t " + ANSI_BLUE + " Egy szeneskocsit csatolhatunk egy létező mozdonyhoz");
                System.out.println(ANSI_GREEN+"stepLocomotive <mozdony neve> <léptetés száma>\t " + ANSI_RED + " stepLocomotive m2 5 \t " + ANSI_BLUE + " Egy adott mozdonyt (és a hozzá tartozó kocsikat) egy megadott mértékkel léptetünk.");
                System.out.println(ANSI_GREEN+"stepAll <léptetések száma>\t " + ANSI_RED + " stepAll 3 \t " + ANSI_BLUE + " Minden mozdonyt (és a hozzá tartozó kocsikat) egy előre megadott mértékkel léptetünk.");
                System.out.println(ANSI_GREEN+"run\t " + ANSI_RED + " run \t " + ANSI_BLUE + " Önállóan lépteti az összes pályán lévő vonatot másodpercenként egyszer, amíg véget nem ér a játék.");
                System.out.println(ANSI_GREEN+"stop\t " + ANSI_RED + " stop \t " + ANSI_BLUE + " Ha futó run parancs után hívjuk, akkor leáll a futtatás (vonatok mozgása)");
                System.out.println(ANSI_GREEN+"changeSwitch <váltó neve> <dinamikus váltás iránya>\t " + ANSI_RED + " changeSwitch v2 s3 \t " + ANSI_BLUE + " Egy megadott váltó dinamikus irányát átváltja a megadott irányba.");
                System.out.println(ANSI_GREEN+"buildTunnel <első bejárat neve> <második bejárat neve>\t " + ANSI_RED + " buildTunnel a1 a3 \t " + ANSI_BLUE + " Egy alagutat épít (aktivál) a paraméterként megkapott két alagútbejárat segítségével");
                System.out.println(ANSI_GREEN+"destroyTunnel\t " + ANSI_RED + " destroyTunnel \t " + ANSI_BLUE + " Lerombolja (deaktiválja) az éppen aktív alagutat.");
                System.out.println(ANSI_GREEN+"readSwitch <váltó neve>\t " + ANSI_RED + " readSwitch v3 \t " + ANSI_BLUE + " Egy létező váltó paraméterei kérdezhetőek le.");
                System.out.println(ANSI_GREEN+"changeStationParams <állomás neve> <beállítani kívánt szín> <legyen-e felszálló utas>\t " + ANSI_RED + " changeStationParams st2 red true \t " + ANSI_BLUE + " Egy létező állomás paramétereit lehet változtatni");
                System.out.println(ANSI_GREEN+"readStationParams <állomás neve>\t " + ANSI_RED + " readStationParams st3 \t " + ANSI_BLUE + " Egy létező állomás paramétereit lehet lekérdezni.");
                System.out.println(ANSI_GREEN+"readPassengerCarParams <mozdony neve amihez kapcsolódik> <kocsi neve>\t " + ANSI_RED + " readPassengerCarParams m1 k3 \t " + ANSI_BLUE + " Egy létező utasokat szállító kocsi paramétereit lehet lekérdezni."+ANSI_RESET);
                break;

            case "loadMap":
                try
                {
                    mapName = command[1];
                    Scanner in = new Scanner(new File("Resources/"+mapName));
                    //TODO: pálya elmentése, betöltése
                }

                catch (FileNotFoundException e)
                {
                    System.out.println("invalid parameter "+ c);
                }

                break;

            case "listMapElements":
                try
                {
                    BufferedReader  in = new BufferedReader (new FileReader("Resources/"+mapName));
                    String line;

                    while((line = in.readLine())!= null )
                    {
                        System.out.println(line);
                    }
                }

                catch (FileNotFoundException e)
                {
                    System.out.println("map has not been loaded");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
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

        catch(ArrayIndexOutOfBoundsException a)
        {
            System.out.println("missing parameter "+ c);
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
