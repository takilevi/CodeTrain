import java.io.*;
import java.util.*;

/**
 * A program model osztálya.
 * Felelőssége azon dolgok végzése, amik globálisan befolyásolják a teljes játékot.
 * (Játék indítás, Játék vége, pálya felépítése.)
 */
public class RailroadModel {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static RailroadModel model;
    private List<Train> trainsInModel;
    private List<Train> fullTrains;
    private Map<String, StaticElement> elementsInModel; //ezt átírtam list<StaticElement>-ről, hogy tudjuk tárolni a neveket is
    private Tunnel activeTunnel;
    private List<Station> notEmptyStations;
    private String mapName;

    /**
     * Singletonná teszi az osztályt.
     *
     * @return Visszatér a modelel, illetve ha még nem létezne, létrehozza
     */
    public static RailroadModel getInstance() {
        if (model == null) {
            model = new RailroadModel();
        }
        return model;
    }

    /**
     * Privát konstruktor.
     */
    private RailroadModel() {
        trainsInModel = new ArrayList<>();
        fullTrains = new ArrayList<>();
        elementsInModel = new LinkedHashMap<String, StaticElement>();
        notEmptyStations = new ArrayList<>();
    }

    /**
     * A pályaelemek inicíalizálása, pálya létrehozása.
     */
    public void initFieldElements(String mapName) {
        trainsInModel = new ArrayList<>();
        fullTrains = new ArrayList<>();
        elementsInModel = new LinkedHashMap<String, StaticElement>();
        notEmptyStations = new ArrayList<>();
        String[] previousSplittedLine = null;

        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("Resources/map/" + mapName));
            String line;

            while ((line = in.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                switch (splittedLine[0]) {
                    case "Track":
                        elementsInModel.put(splittedLine[1], new Track(splittedLine[1]));
                        if (elementsInModel.size() > 1) {
                            StaticElement temp = elementsInModel.get(previousSplittedLine[1]);
                            temp.setNextElement(elementsInModel.get(splittedLine[1]));
                            StaticElement temp2 = elementsInModel.get(splittedLine[1]);
                            temp2.setPreviousElement(temp);
                        }
                        break;
                    case "Switch":
                        elementsInModel.put(splittedLine[1], new RailroadSwitch(splittedLine[1]));
                        int count_loop = Integer.parseInt(splittedLine[2]);
                        while (count_loop != 0) {
                            String temp_line = in.readLine();
                            String[] temp_splittedLine = temp_line.split(" ");
                            switch (temp_splittedLine[0]) {
                                case "Track":
                                    elementsInModel.put(temp_splittedLine[1], new Track(temp_splittedLine[1]));
                                    StaticElement temp = elementsInModel.get(splittedLine[1]);
                                    temp.setDynamicDirection(elementsInModel.get(temp_splittedLine[1]));
                                    StaticElement temp2 = elementsInModel.get(temp_splittedLine[1]);
                                    temp2.setPreviousElement(temp);
                                    break;
                                case "Station":
                                    elementsInModel.put(temp_splittedLine[1], new Station(0, Color.Blue, temp_splittedLine[1], this));
                                    StaticElement temp_s = elementsInModel.get(splittedLine[1]);
                                    temp_s.setDynamicDirection(elementsInModel.get(temp_splittedLine[1]));
                                    StaticElement temp2_s = elementsInModel.get(temp_splittedLine[1]);
                                    temp2_s.setPreviousElement(temp_s);
                                    break;
                                case "TunnelElement":
                                    elementsInModel.put(temp_splittedLine[1], new TunnelEntrance(temp_splittedLine[1]));
                                    StaticElement temp_te = elementsInModel.get(splittedLine[1]);
                                    temp_te.setDynamicDirection(elementsInModel.get(temp_splittedLine[1]));
                                    StaticElement temp2_te = elementsInModel.get(temp_splittedLine[1]);
                                    temp2_te.setPreviousElement(temp_te);
                                    break;
                            }
                            count_loop--;
                        }
                        StaticElement temp = elementsInModel.get(previousSplittedLine[1]);
                        temp.setNextElement(elementsInModel.get(splittedLine[1]));
                        StaticElement temp2 = elementsInModel.get(splittedLine[1]);
                        temp2.setStaticDirection(temp);

                        break;
                    case "Station":
                        Station s = new Station(Integer.parseInt(splittedLine[2]), Color.valueOf(splittedLine[3]), splittedLine[1], this);
                        elementsInModel.put(splittedLine[1], s);
                        StaticElement temp_stat = elementsInModel.get(previousSplittedLine[1]);
                        temp_stat.setNextElement(elementsInModel.get(splittedLine[1]));
                        StaticElement temp2_stat = elementsInModel.get(splittedLine[1]);
                        temp2_stat.setPreviousElement(temp_stat);
                        if(Integer.parseInt(splittedLine[2]) >0){
                            notEmptyStations.add(s);
                        }
                        break;

                    case "TunnelElement":
                        elementsInModel.put(splittedLine[1], new TunnelEntrance(splittedLine[1]));
                        StaticElement temp_tunnel = elementsInModel.get(previousSplittedLine[1]);
                        temp_tunnel.setNextElement(elementsInModel.get(splittedLine[1]));
                        StaticElement temp2_tunnel = elementsInModel.get(splittedLine[1]);
                        temp2_tunnel.setPreviousElement(temp_tunnel);
                        break;

                    case "RailroadCross":
                        //TODO: ez nem túl egyszerű
                        break;

                    default:
                        //ebben a .getClass().getName() -ben nem annyira vagyok biztos
                        String searchType = elementsInModel.get(splittedLine[0]).getClass().getSimpleName();

                        switch (searchType) {
                            case "TunnelEntrance":
                                String until_tunnelend = in.readLine();
                                String[] in_tunnel = until_tunnelend.split(" ");

                                elementsInModel.put(in_tunnel[1], new Track(in_tunnel[1]));
                                StaticElement temp_intunnel = elementsInModel.get(splittedLine[0]);
                                temp_intunnel.setTunnelElement(elementsInModel.get(in_tunnel[1]));
                                StaticElement temp2_intunnel = elementsInModel.get(in_tunnel[1]);
                                temp2_intunnel.setPreviousElement(temp_intunnel);

                                String[] prev_in_tunnel = in_tunnel;
                                until_tunnelend = in.readLine();
                                in_tunnel = until_tunnelend.split(" ");

                                while (in_tunnel.length != 1) {
                                    elementsInModel.put(in_tunnel[1], new Track(in_tunnel[1]));
                                    StaticElement prev_track_intunnel = elementsInModel.get(prev_in_tunnel[1]);
                                    prev_track_intunnel.setNextElement(elementsInModel.get(in_tunnel[1]));
                                    StaticElement track_intunnel = elementsInModel.get(in_tunnel[1]);
                                    track_intunnel.setPreviousElement(prev_track_intunnel);

                                    prev_in_tunnel = in_tunnel;
                                    until_tunnelend = in.readLine();
                                    in_tunnel = until_tunnelend.split(" ");
                                }

                                StaticElement tunnel_end_entrance = elementsInModel.get(in_tunnel[0]);
                                StaticElement tunnel_end_track = elementsInModel.get(prev_in_tunnel[1]);
                                tunnel_end_entrance.setTunnelElement(tunnel_end_track);
                                tunnel_end_track.setNextElement(tunnel_end_entrance);
                                break;

                            default:
                                String[] rebase_splittedline = new String[2];
                                rebase_splittedline[1] = splittedLine[0];
                                rebase_splittedline[0] = searchType;
                                splittedLine = rebase_splittedline;
                                break;
                        }
                        break;
                }
                previousSplittedLine = splittedLine;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Wrong mapname");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Játék elindítása (A szkeletonban nincs még ilyen viselkedés.)
     */
    public void startGame() {
    }

    /**
     * A játék véget ért.
     */
    public void finishGame(int code) {


        if (code == 0) {
            //Nem volt ütközés, nyertünk
            if(notEmptyStations.isEmpty()){
                System.out.println("Nyertünk: true");
                System.out.println("Vesztettünk: false");
                System.exit(0);
            }
            else{
                //Még nem nyertünk, mert van olyan állomás, ahol ég fel akarnak szállni.
                return;
            }

        } else if(code == 1){
            //Vesztettünk
            System.out.println("Nyertünk: false");
            System.out.println("Vesztettünk: true");
            System.exit(0);
        }

    }

    /**
     * Ha egy vonat összes kocsija kiürült, akkor csökenti a teli vonatok számát a modelben,
     * illetve ha ez a szám nulla, meghívja  a finishgamet.
     * (Szerepe csak akkor lesz, amikor több vonat kerül a modelbe)
     */
    public void emptyTrain(Train empty) {
        if(fullTrains.contains(empty)){
            fullTrains.remove(empty);

            if(fullTrains.isEmpty()){
                finishGame(0);
            }
        }


    }
    public void fullTrain(Train full){

        if(!fullTrains.contains(full)){
            fullTrains.add(full);
        }
    }

    public void emptyStation(Station empty){

        if(notEmptyStations.contains(empty)){
            notEmptyStations.remove(empty);
        }
    }

    public void CommandExecution(String c) {

        if (c == null) {
            return;
        }

        String trainName;
        String locomotiveName;
        String mapElement;
        String carName;
        String color;
        String passengers;
        int step;
        String switchName;
        String switchState;
        String Tenter1;
        String Tenter2;
        String stationName;
        String testName;

        String[] command = c.split(" ");

        try {

            switch (command[0]) {
                case "help":
                    System.out.println(ANSI_GREEN + "loadMap\t" + ANSI_RED + " loadMap map1.txt \t " + ANSI_BLUE + " Pálya felépítése");
                    System.out.println(ANSI_GREEN + "listMapElements\t " + ANSI_RED + "listMapElements \t " + ANSI_BLUE + " Kilistázza a pályaösszes elemét a rajta álló vonatokkal együtt");
                    System.out.println(ANSI_GREEN + "listTrain <vonat neve>\t " + ANSI_RED + " listTrain v1 \t " + ANSI_BLUE + " Egyetlen, paraméterben megadott vonatot fog kilistázni, ennek mozdonyát illetve kocsijait (ha vannak).");
                    System.out.println(ANSI_GREEN + "listTrains\t " + ANSI_RED + " listTrains \t " + ANSI_BLUE + " Kilistázza a pályán haladó összes vonatot (elemenként) és feltünteti a színüket (ha van) valamint, hogy melyik pálya elemen állnak éppen.");
                    System.out.println(ANSI_GREEN + "addLocomotive <vonat neve> <mozdony neve> <pályaelem neve amire kerül>\t " + ANSI_RED + " addLocomotive v4 m3 s4 \t " + ANSI_BLUE + " Egy mozdony ráhelyezése egy megadott pályaelemre, vonat nevének megadása.");
                    System.out.println(ANSI_GREEN + "addPassengersCarToLocomotive <mozodony neve> <kocsi neve> <szín> <tartalmaz-e utast>\t " + ANSI_RED + " addPassengersCarToLocomotive m3 k1 red true \t " + ANSI_BLUE + " Egy utasokat szállító/vagy nem szállító kocsit csatolhatunk egy létező mozdonyhoz.");
                    System.out.println(ANSI_GREEN + "addHopperCarToLocomotive <mozdony neve> <kocsi neve>\t " + ANSI_RED + " addHopperCarToLocomotive m1 k2 \t " + ANSI_BLUE + " Egy szeneskocsit csatolhatunk egy létező mozdonyhoz");
                    System.out.println(ANSI_GREEN + "stepTrain <vonat neve> <léptetés száma>\t " + ANSI_RED + " stepTrain t0 5 \t " + ANSI_BLUE + " Egy adott vonatot egy megadott mértékkel léptetünk.");
                    System.out.println(ANSI_GREEN + "stepAll <léptetések száma>\t " + ANSI_RED + " stepAll 3 \t " + ANSI_BLUE + " Minden mozdonyt (és a hozzá tartozó kocsikat) egy előre megadott mértékkel léptetünk.");
                    System.out.println(ANSI_GREEN + "run\t " + ANSI_RED + " run \t " + ANSI_BLUE + " Önállóan lépteti az összes pályán lévő vonatot másodpercenként egyszer, amíg véget nem ér a játék.");
                    System.out.println(ANSI_GREEN + "stop\t " + ANSI_RED + " stop \t " + ANSI_BLUE + " Ha futó run parancs után hívjuk, akkor leáll a futtatás (vonatok mozgása)");
                    System.out.println(ANSI_GREEN + "changeSwitch <váltó neve> <dinamikus váltás iránya>\t " + ANSI_RED + " changeSwitch v2 s3 \t " + ANSI_BLUE + " Egy megadott váltó dinamikus irányát átváltja a megadott irányba.");
                    System.out.println(ANSI_GREEN + "buildTunnel <első bejárat neve> <második bejárat neve>\t " + ANSI_RED + " buildTunnel a1 a3 \t " + ANSI_BLUE + " Egy alagutat épít (aktivál) a paraméterként megkapott két alagútbejárat segítségével");
                    System.out.println(ANSI_GREEN + "destroyTunnel\t " + ANSI_RED + " destroyTunnel \t " + ANSI_BLUE + " Lerombolja (deaktiválja) az éppen aktív alagutat.");
                    System.out.println(ANSI_GREEN + "readSwitch <váltó neve>\t " + ANSI_RED + " readSwitch v3 \t " + ANSI_BLUE + " Egy létező váltó paraméterei kérdezhetőek le.");
                    System.out.println(ANSI_GREEN + "changeStationParams <állomás neve> <beállítani kívánt szín> <legyen-e felszálló utas>\t " + ANSI_RED + " changeStationParams st2 red true \t " + ANSI_BLUE + " Egy létező állomás paramétereit lehet változtatni");
                    System.out.println(ANSI_GREEN + "readStationParams <állomás neve>\t " + ANSI_RED + " readStationParams st3 \t " + ANSI_BLUE + " Egy létező állomás paramétereit lehet lekérdezni.");
                    System.out.println(ANSI_GREEN + "readPassengerCarParams <mozdony neve amihez kapcsolódik> <kocsi neve>\t " + ANSI_RED + " readPassengerCarParams m1 k3 \t " + ANSI_BLUE + " Egy létező utasokat szállító kocsi paramétereit lehet lekérdezni." + ANSI_RESET);
                    break;

                case "loadMap":

                        mapName = command[1];
                        initFieldElements(mapName);

                    break;

                case "listMapElements":
                    try {
                        BufferedReader in = new BufferedReader(new FileReader("Resources/map/" + mapName));
                        String line;

                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("map has not been loaded");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case "listTrain":
                    trainName = command[1];
                    int equals = 0;
                    for (int i = 0; i < trainsInModel.size(); i++) {
                        Train t = trainsInModel.get(i);
                        if (t.getName().equals(trainName)) {
                            equals++;
                            t.listTrain();
                            break;
                        }
                        break;
                    }
                    if(equals==0) {
                        System.out.println("Ilyen nevű vonat jelenleg nincs a modelben!");
                    }
                    break;

                case "listTrains":
                    if (trainsInModel.isEmpty()) {
                        System.out.println("A modelben jelenleg nincsenek vonatok!");
                        break;
                    }
                    for (int i = 0; i < trainsInModel.size(); i++) {
                        trainsInModel.get(i).listTrain();
                    }
                    break;

                case "addLocomotive":
                    trainName = command[1];
                    locomotiveName = command[2];
                    mapElement = command[3];

                    if (elementsInModel.containsKey(mapElement)) {
                        Train t = new Train(this, trainName);
                        model.trainsInModel.add(t);
                        Locomotive m = new Locomotive(elementsInModel.get(mapElement), elementsInModel.get(mapElement).getPrevForLoco(), locomotiveName, t);
                        t.addLocomotive(m);
                    } else {
                        System.out.println("Ilyen elem sajnos nincs a modelben!");
                    }

                    break;

                case "addPassengerCarToTrain":
                    trainName = command[1];
                    carName = command[2];
                    color = command[3];
                    passengers = command[4];

                    for (Train curInstance : trainsInModel) {
                        if (curInstance.getName().matches(trainName)) {
                            PassengerCar p = new PassengerCar(Color.valueOf(color), Boolean.parseBoolean(passengers), curInstance, carName);
                            curInstance.addCar(p);
                        }
                    }
                    break;

                case "addHopperCarToTrain":
                    trainName = command[1];
                    carName = command[2];
                    for (Train curInstance : trainsInModel) {
                        if (curInstance.getName().matches(trainName)) {
                            HopperCar p = new HopperCar(curInstance, carName);
                            curInstance.addCar(p);
                        }
                    }
                    break;

                case "stepTrain":

                    trainName = command[1];
                    step = Integer.parseInt(command[2]);
                    int findIt = 0;
                    for (int i = 0; i < step; i++) {
                        for (Train t : trainsInModel) {
                            if (t.getName().matches(trainName)) {
                                findIt++;
                                t.awakeLocomotive();
                            }
                        }
                    }


                    //System.out.println(findIt);

                    break;

                case "stepAll":
                    step = Integer.parseInt(command[1]);

                    if (trainsInModel.isEmpty()) {
                        System.out.println("Nincsenek vonatok a modelben!");
                    }

                    for (int i = 0; i < step; i++) {
                        for (Train t : trainsInModel) {
                            t.awakeLocomotive();
                        }
                    }
                    break;

                case "run":
                    Counter counter = new Counter(1000);
                    counter.start();
                    break;

                case "stop":
                    break;

                case "changeSwitch":
                    switchName = command[1];
                    switchState = command[2];

                    RailroadSwitch switcher = (RailroadSwitch) elementsInModel.get(switchName);
                    switcher.changeSwitchToDirection(elementsInModel.get(switchState));
                    break;

                case "buildTunnel":
                    Tenter1 = command[1];
                    Tenter2 = command[2];
                    TunnelEntrance t1 = (TunnelEntrance) elementsInModel.get(Tenter1);
                    TunnelEntrance t2 = (TunnelEntrance) elementsInModel.get(Tenter2);
                    if(activeTunnel != null){
                        activeTunnel.destroy();
                    }
                    activeTunnel = new Tunnel();
                    activeTunnel.build(t1);
                    activeTunnel.build(t2);
                    break;

                case "destroyTunnel":
                    if(activeTunnel != null){
                        if(activeTunnel.destroy()){
                            activeTunnel = null;
                        }

                    }

                    break;

                case "listActiveTunnel":
                    if(activeTunnel != null){
                        //Csúnya, és Demeter, de ez a prototípusban elmegy, a véglegesből úgyis ki kell szedni.
                        System.out.println("Tunnel : " + activeTunnel.getEntrances().get(0).getName() + " " + activeTunnel.getEntrances().get(1).getName());
                    }
                    else{
                        System.out.println("Aktív alagút: null");
                    }
                    break;

                case "readSwitch":
                    switchName = command[1];
                    RailroadSwitch readable = (RailroadSwitch) elementsInModel.get(switchName);

                    System.out.println(readable.getClass().getSimpleName() + "\t" + switchName);
                    System.out.println("Static Direction "+readable.getStaticDirection().getName());
                    System.out.println("Current Dynamic Direction "+readable.getCurrentSwitchInDirection().getName());
                    System.out.println("Optional Directions "+ readable.getDynamicDirectionNames());
                    break;

                case "changeStationParams":
                    stationName = command[1];
                    color = command[2];
                    passengers = command[3];

                    Station stat = (Station) elementsInModel.get(stationName);

                    if(Integer.parseInt(passengers) > 0){
                        if(!notEmptyStations.contains(stat)){
                            notEmptyStations.add(stat);
                        }
                    }


                    stat.setColor(Color.valueOf(color));
                    stat.setGetOnPassengers(Integer.parseInt(passengers));
                    break;

                case "readStationParams":
                    stationName = command[1];
                    Station stat_read = (Station) elementsInModel.get(stationName);
                    System.out.println("Station " + stationName);
                    System.out.println("Color " + stat_read.getColor());
                    System.out.println("Passengers " + stat_read.getGetOnPassengers());
                    break;

                case "readPassengerCarParams":
                    trainName = command[1];
                    carName = command[2];
                    for (Train curInstance : trainsInModel) {
                        if (curInstance.getName().matches(trainName)) {
                            List<RailroadCar> cars_temp_list = curInstance.getCars();
                            for (RailroadCar curCar : cars_temp_list) {
                                if (curCar.getName().matches(carName)) {
                                    System.out.println("PassengerCar " + carName);
                                    System.out.println("In train " + trainName);
                                    System.out.println("Color " + curCar.getColor());
                                    System.out.println("Passengers on board " + curCar.getPassengersOnBoard());
                                }
                            }
                        }
                    }
                    break;

                case "readTest":
                    try {
                        testName = command[1];
                        BufferedReader in = new BufferedReader(new FileReader("Resources/test/" + testName));
                        String commands = "";
                        String line;
                        while ((line = in.readLine()) != null) {
                            CommandExecution(line);

                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("missing parameter " + c);
        }
    }

    public void notEmpty(Train full) {

        if (fullTrains.contains(full)) {
            fullTrains.remove(full);
        }
    }

    public void clearModel() {
        model = null;
    }
}
