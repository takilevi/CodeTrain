package Game;

import Graphics.View;
import com.sun.media.jfxmedia.logging.Logger;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.*;

/**
 * A program model osztálya.
 * Felelőssége azon dolgok végzése, amik globálisan befolyásolják a teljes játékot.
 * (Játék indítás, Játék vége, pálya felépítése.)
 */
public class RailroadModel {
    /**
     * Színek illetve egy lista, ami tárolja az egyes parancsokra kiadott outputokat.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static List<String> commandsOutput = new ArrayList<>();

    /**
     * Tárolja az összes vonatot, azokat amiken még vannak utasok
     * Az összes element, az aktív alagutat, a nem üres állomásokat
     * A betöltött pálya nevét, és egy counter szálat
     */
    private static RailroadModel model;
    private List<Train> trainsInModel;
    private List<Train> fullTrains;
    private Map<String, StaticElement> elementsInModel; //ezt átírtam list<Game.StaticElement>-ről, hogy tudjuk tárolni a neveket is
    private Tunnel activeTunnel;
    private List<Station> notEmptyStations;
    private String mapName;
    private Counter counter;

    private View view;



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

    public void setView(View v){
        view = v;
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
                    case "Game.Track":
                        Track t =  new Track(splittedLine[1]);

                        t.setGraphics(splittedLine[4], Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]));
                        view.addDrawable(t.getGraphics());

                        elementsInModel.put(splittedLine[1],t);
                        break;

                    case "Game.Switch":
                        RailroadSwitch sw = new RailroadSwitch(splittedLine[1]);

                        sw.setGraphics(splittedLine[5],Integer.parseInt(splittedLine[3]), Integer.parseInt(splittedLine[4]) );
                        view.addDrawable(sw.getGraphics());

                        elementsInModel.put(splittedLine[1], sw);
                        break;

                    case "Game.Station":

                        Station s = new Station(Integer.parseInt(splittedLine[2]), Color.valueOf(splittedLine[3]), splittedLine[1], this);

                        s.setGraphics(splittedLine[6], Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]));
                        view.addDrawable(s.getGraphics());

                        elementsInModel.put(splittedLine[1], s);
                        break;

                    case "Game.Depot":

                        Depot d = new Depot(splittedLine[1]);


                        d.setGraphics(splittedLine[4], Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]));
                        view.addDrawable(d.getGraphics());
                        elementsInModel.put(splittedLine[1], d);
                        break;

                    case "Game.TunnelEntrance":

                        TunnelEntrance te = new TunnelEntrance(splittedLine[1]);

                        te.setGraphics(splittedLine[4],Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]));
                        view.addDrawable(te.getGraphics());

                        elementsInModel.put(splittedLine[1],te);
                        break;

                    case "Game.RailroadCross":

                        RailroadCross rc = new RailroadCross(splittedLine[1]);

                        rc.setGraphics(splittedLine[4],Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3]));
                        view.addDrawable(rc.getGraphics());

                        elementsInModel.put(splittedLine[1],rc);
                        break;

                    default:
                        String searchType = elementsInModel.get(splittedLine[0]).getClass().getSimpleName();

                        switch (searchType) {
                            case "Game.TunnelEntrance":
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
            setConnections();
        } catch (FileNotFoundException e) {
            System.out.println("Wrong mapname");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setConnections(){


        elementsInModel.get("d0").setPreviousElement(null);

        elementsInModel.get("t0").setPreviousElement(elementsInModel.get("d0"));
        elementsInModel.get("t0").setNextElement(elementsInModel.get("t1"));

        elementsInModel.get("t1").setPreviousElement(elementsInModel.get("t0"));
        elementsInModel.get("t1").setNextElement(elementsInModel.get("st0"));

        elementsInModel.get("st0").setPreviousElement(elementsInModel.get("t1"));
        elementsInModel.get("st0").setNextElement(elementsInModel.get("rc0_c"));

        //elementsInModel.get("rc0_c").setPreviousElement();
        //elementsInModel.get("rc0_c").setPreviousElement();
        //elementsInModel.get("rc0_c").setNextElement();
        //elementsInModel.get("rc0_c").setNextElement();

        ((RailroadCross)elementsInModel.get("rc0_c")).setFirstDirections(elementsInModel.get("st0"), elementsInModel.get("t2_c"));
        ((RailroadCross) elementsInModel.get("rc0_c")).setSecondDirections(elementsInModel.get("t2_b"),elementsInModel.get("t2_a") );

        elementsInModel.get("t2_c").setPreviousElement(elementsInModel.get("rc0_c"));
        elementsInModel.get("t2_c").setNextElement(elementsInModel.get("t3_c"));

        elementsInModel.get("t3_c").setPreviousElement(elementsInModel.get("t2_c"));
        elementsInModel.get("t3_c").setNextElement(elementsInModel.get("t4_c"));

        elementsInModel.get("t4_c").setPreviousElement(elementsInModel.get("t3_c"));
        elementsInModel.get("t4_c").setNextElement(elementsInModel.get("sw0"));

        elementsInModel.get("sw0").setStaticDirection(elementsInModel.get("t0_d"));
        elementsInModel.get("sw0").setDynamicDirection(elementsInModel.get("t4_c"));
        elementsInModel.get("sw0").setDynamicDirection(elementsInModel.get("t9_b"));
        elementsInModel.get("sw0").setDynamicDirection(elementsInModel.get("t9_a"));

        elementsInModel.get("t2_a").setPreviousElement(elementsInModel.get("rc0_c"));
        elementsInModel.get("t2_a").setNextElement(elementsInModel.get("t3_a"));

        elementsInModel.get("t3_a").setPreviousElement(elementsInModel.get("t2_a"));
        elementsInModel.get("t3_a").setNextElement(elementsInModel.get("t4_a"));

        elementsInModel.get("t4_a").setPreviousElement(elementsInModel.get("t3_a"));
        elementsInModel.get("t4_a").setNextElement(elementsInModel.get("k0_a"));

        elementsInModel.get("k0_a").setPreviousElement(elementsInModel.get("t4_a"));
        elementsInModel.get("k0_a").setNextElement(elementsInModel.get("t5_a"));

        elementsInModel.get("t5_a").setPreviousElement(elementsInModel.get("k0_a"));
        elementsInModel.get("t5_a").setNextElement(elementsInModel.get("te0_a"));

        elementsInModel.get("te0_a").setPreviousElement(elementsInModel.get("t5_a"));
        elementsInModel.get("te0_a").setNextElement(elementsInModel.get("t6_a"));

        elementsInModel.get("t6_a").setPreviousElement(elementsInModel.get("te0_a"));
        elementsInModel.get("t6_a").setNextElement(elementsInModel.get("sw1"));

        elementsInModel.get("sw1").setStaticDirection(elementsInModel.get("t7_a"));
        elementsInModel.get("sw1").setDynamicDirection(elementsInModel.get("t6_a"));
        elementsInModel.get("sw1").setDynamicDirection(elementsInModel.get("t0_e"));

        elementsInModel.get("t7_a").setPreviousElement(elementsInModel.get("sw1"));
        elementsInModel.get("t7_a").setNextElement(elementsInModel.get("t8_a"));

        elementsInModel.get("t8_a").setPreviousElement(elementsInModel.get("t7_a"));
        elementsInModel.get("t8_a").setNextElement(elementsInModel.get("t9_a"));

        elementsInModel.get("t9_a").setPreviousElement(elementsInModel.get("t8_a"));
        elementsInModel.get("t9_a").setNextElement(elementsInModel.get("sw0"));

        elementsInModel.get("t2_b").setPreviousElement(elementsInModel.get("rc0_c"));
        elementsInModel.get("t2_b").setNextElement(elementsInModel.get("t3_b"));

        elementsInModel.get("t3_b").setPreviousElement(elementsInModel.get("t2_b"));
        elementsInModel.get("t3_b").setNextElement(elementsInModel.get("t4_b"));

        elementsInModel.get("t4_b").setPreviousElement(elementsInModel.get("t3_b"));
        elementsInModel.get("t4_b").setNextElement(elementsInModel.get("k0_b"));

        elementsInModel.get("k0_b").setPreviousElement(elementsInModel.get("t4_b"));
        elementsInModel.get("k0_b").setNextElement(elementsInModel.get("t5_b"));

        elementsInModel.get("t5_b").setPreviousElement(elementsInModel.get("k0_b"));
        elementsInModel.get("t5_b").setNextElement(elementsInModel.get("te0_b"));

        elementsInModel.get("te0_b").setPreviousElement(elementsInModel.get("t5_b"));
        elementsInModel.get("te0_b").setNextElement(elementsInModel.get("t6_b"));

        elementsInModel.get("t6_b").setPreviousElement(elementsInModel.get("teo_b"));
        elementsInModel.get("t6_b").setNextElement(elementsInModel.get("sw3"));

        elementsInModel.get("sw3").setStaticDirection(elementsInModel.get("t7_b"));
        elementsInModel.get("sw3").setDynamicDirection(elementsInModel.get("t6_b"));
        elementsInModel.get("sw3").setDynamicDirection(elementsInModel.get("t0_f"));

        elementsInModel.get("t7_b").setPreviousElement(elementsInModel.get("sw3"));
        elementsInModel.get("t7_b").setNextElement(elementsInModel.get("t8_b"));

        elementsInModel.get("t8_b").setPreviousElement(elementsInModel.get("t7_b"));
        elementsInModel.get("t8_b").setNextElement(elementsInModel.get("t9_b"));

        elementsInModel.get("t9_b").setPreviousElement(elementsInModel.get("t8_b"));
        elementsInModel.get("t9_b").setNextElement(elementsInModel.get("sw0"));

        elementsInModel.get("t0_d").setPreviousElement(elementsInModel.get("sw0"));
        elementsInModel.get("t0_d").setNextElement(elementsInModel.get("t1_d"));

        elementsInModel.get("t1_d").setPreviousElement(elementsInModel.get("t0_d"));
        elementsInModel.get("t1_d").setNextElement(elementsInModel.get("t2_d"));

        elementsInModel.get("t2_d").setPreviousElement(elementsInModel.get("t1_d"));
        elementsInModel.get("t2_d").setNextElement(elementsInModel.get("sw4"));

        elementsInModel.get("sw4").setStaticDirection(elementsInModel.get("t2_d"));
        elementsInModel.get("sw4").setDynamicDirection(elementsInModel.get("te0_g"));
        elementsInModel.get("sw4").setDynamicDirection(elementsInModel.get("t4_e"));
        elementsInModel.get("sw4").setDynamicDirection(elementsInModel.get("t4_f"));

        elementsInModel.get("t0_e").setPreviousElement(elementsInModel.get("sw1"));
        elementsInModel.get("t0_e").setNextElement(elementsInModel.get("st1"));

        elementsInModel.get("st1").setPreviousElement(elementsInModel.get("t0_e"));
        elementsInModel.get("st1").setNextElement(elementsInModel.get("t1_e"));

        elementsInModel.get("t1_e").setPreviousElement(elementsInModel.get("st1"));
        elementsInModel.get("t1_e").setNextElement(elementsInModel.get("k0_e"));

        elementsInModel.get("k0_e").setPreviousElement(elementsInModel.get("t1_e"));
        elementsInModel.get("k0_e").setNextElement(elementsInModel.get("t2_e"));

        elementsInModel.get("t2_e").setPreviousElement(elementsInModel.get("k0_e"));
        elementsInModel.get("t2_e").setNextElement(elementsInModel.get("t3_e"));

        elementsInModel.get("t3_e").setPreviousElement(elementsInModel.get("t2_e"));
        elementsInModel.get("t3_e").setNextElement(elementsInModel.get("t4_e"));

        elementsInModel.get("t4_e").setPreviousElement(elementsInModel.get("t3_e"));
        elementsInModel.get("t4_e").setNextElement(elementsInModel.get("sw4"));

        elementsInModel.get("t0_f").setPreviousElement(elementsInModel.get("sw3"));
        elementsInModel.get("t0_f").setNextElement(elementsInModel.get("t1_f"));

        elementsInModel.get("t1_f").setPreviousElement(elementsInModel.get("t0_f"));
        elementsInModel.get("t1_f").setNextElement(elementsInModel.get("t2_f"));

        elementsInModel.get("t2_f").setPreviousElement(elementsInModel.get("t2_f"));
        elementsInModel.get("t2_f").setNextElement(elementsInModel.get("k0_f"));

        elementsInModel.get("k0_f").setPreviousElement(elementsInModel.get("t2_f"));
        elementsInModel.get("k0_f").setNextElement(elementsInModel.get("t3_f"));

        elementsInModel.get("t3_f").setPreviousElement(elementsInModel.get("k0_f"));
        elementsInModel.get("t3_f").setNextElement(elementsInModel.get("st2"));

        elementsInModel.get("st2").setPreviousElement(elementsInModel.get("t3_f"));
        elementsInModel.get("st2").setNextElement(elementsInModel.get("t4_f"));

        elementsInModel.get("t4_f").setPreviousElement(elementsInModel.get("st2"));
        elementsInModel.get("t4_f").setNextElement(elementsInModel.get("sw4"));

        elementsInModel.get("te0_g").setPreviousElement(elementsInModel.get("sw4"));
        elementsInModel.get("te0_g").setNextElement(elementsInModel.get(null));

    }

    public Map<String, StaticElement> getElementsInModel(){
        return elementsInModel;
    }

    /**
     * Játék elindítása (A prototípusban még nem kell.)
     */
    public void startGame() {
    }

    /**
     * A játék véget ért. Ha a code 0, és már az állomásokon se várnak utasok, nyertünk
     * Ha 1 akkor vesztettünk.
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

    /**
     * Utasok szálltak fel egy vonatra
     * @param full
     */
    public void fullTrain(Train full){

        if(!fullTrains.contains(full)){
            fullTrains.add(full);
        }
    }

    /**
     * Kiürült egy állomás
     * @param empty az állomás
     */
    public void emptyStation(Station empty){

        if(notEmptyStations.contains(empty)){
            notEmptyStations.remove(empty);
        }
    }

    /**
     * A prototípus feldolgozza a standart inputon, vagy a testből olvasott parancsokat
     * és végrehajta.
     * @param c A parancs
     */
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
        String crossName;

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
                            commandsOutput.add(line);
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

                       view.addDrawable(m.getGraphics());

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
                            view.addDrawable(p.getGraphics());

                            view.DrawAll();
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

                            view.addDrawable(p.getGraphics());
                            view.DrawAll();
                        }
                    }
                    break;

                case "stepTrain":

                    trainName = command[1];
                    step = Integer.parseInt(command[2]);

                    for (int i = 0; i < step; i++) {
                        for (Train t : trainsInModel) {
                            if (t.getName().matches(trainName)) {

                                t.awakeLocomotive();
                            }
                        }
                    }
                    break;

                case "stepAll":
                    step = Integer.parseInt(command[1]);

                    if (trainsInModel.isEmpty()) {
                        System.out.println("Nincsenek vonatok a modelben!");
                    }

                    for (int i = 0; i < step; i++) {
                        for (Train t : trainsInModel) {
                            t.awakeLocomotive();
                            view.DrawAll();
                        }
                    }
                    break;

                case "readCross":
                    crossName = command[1];
                    RailroadCross cross = (RailroadCross)elementsInModel.get(crossName);
                    commandsOutput.add("Game.RailroadCross "+crossName);
                    commandsOutput.add(cross.firstDirections());
                    commandsOutput.add(cross.secondDirections());
                    System.out.println("Game.RailroadCross "+crossName);
                    System.out.println(cross.firstDirections());
                    System.out.println(cross.secondDirections());
                    break;

                case "run":
                    counter = new Counter(3000, "RunTrains", trainsInModel, view);
                    System.out.println("Nyomj meg valamilyen gombot, ha parancsot írnál be");
                    counter.start();
                    break;

                case "stop":
                    counter.stopThread();
                    break;

                case "changeSwitch":
                    switchName = command[1];
                    switchState = command[2];

                    RailroadSwitch switcher = (RailroadSwitch) elementsInModel.get(switchName);
                    switcher.changeSwitchToDirection(Integer.parseInt(switchState));

                    view.DrawAll();

                    break;

                case "buildTunnel":
                    Tenter1 = command[1];
                    Tenter2 = command[2];
                    TunnelEntrance t1 = (TunnelEntrance) elementsInModel.get(Tenter1);
                    TunnelEntrance t2 = (TunnelEntrance) elementsInModel.get(Tenter2);
                    t1.setTunnelElement(t2);
                    t2.setTunnelElement(t1);
                    if(activeTunnel != null){
                        activeTunnel.destroy();
                    }
                    activeTunnel = new Tunnel();
                    activeTunnel.build(t1);
                    activeTunnel.build(t2);

                    view.DrawAll();

                    break;

                case "destroyTunnel":
                    if(activeTunnel != null){
                        if(activeTunnel.destroy()){

                            view.DrawAll();

                            activeTunnel = null;
                        }
                    }

                    break;

                case "listActiveTunnel":
                    if(activeTunnel != null){
                        //Csúnya, és Demeter, de ez a prototípusban elmegy, a véglegesből úgyis ki kell szedni.
                        System.out.println("Game.Tunnel : " + activeTunnel.getEntrances().get(0).getName() + " " + activeTunnel.getEntrances().get(1).getName());
                        commandsOutput.add("Game.Tunnel : " + activeTunnel.getEntrances().get(0).getName() + " " + activeTunnel.getEntrances().get(1).getName());
                    }
                    else{
                        commandsOutput.add("Aktív alagút: null");
                        System.out.println("Aktív alagút: null");
                    }
                    break;

                case "readSwitch":
                    switchName = command[1];
                    RailroadSwitch readable = (RailroadSwitch) elementsInModel.get(switchName);

                    commandsOutput.add(readable.getClass().getSimpleName() + "\t" + switchName);
                    commandsOutput.add("Static Direction "+readable.getStaticDirection().getName());
                    commandsOutput.add("Current Dynamic Direction "+readable.getCurrentSwitchInDirection().getName());
                    commandsOutput.add("Optional Directions "+ readable.getDynamicDirectionNames());
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
                    commandsOutput.add("Game.Station " + stationName);
                    commandsOutput.add("Game.Color " + stat_read.getColor());
                    commandsOutput.add("Passengers " + stat_read.getGetOnPassengers());
                    System.out.println("Game.Station " + stationName);
                    System.out.println("Game.Color " + stat_read.getColor());
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
                                    commandsOutput.add("Game.PassengerCar " + carName);
                                    commandsOutput.add("In train " + trainName);
                                    commandsOutput.add("Game.Color " + curCar.getColor());
                                    commandsOutput.add("Passengers on board " + curCar.getPassengersOnBoard());
                                    System.out.println("Game.PassengerCar " + carName);
                                    System.out.println("In train " + trainName);
                                    System.out.println("Game.Color " + curCar.getColor());
                                    System.out.println("Passengers on board " + curCar.getPassengersOnBoard());
                                }
                            }
                        }
                    }
                    break;

                //Beolvassa a teszteket, majd végrehajtja.
                case "readTest":
                    try {
                        testName = command[1];
                        BufferedReader in = new BufferedReader(new FileReader("Resources/test/" + testName));
                        String line;
                        while ((line = in.readLine()) != null) {
                            CommandExecution(line);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                //Beolvassa a tesztet, végrehajtja, majd megnézi, hogy az eredmény egyezik e az elvártal.
                //(Kozolon nem működik megfelelően a karakterkódolás miatt. )
                case "readTestWithResult":
                    try {
                        commandsOutput = new ArrayList<>();
                        testName = command[1];
                        BufferedReader in = new BufferedReader(new FileReader("Resources/test/" + testName));
                        String line;
                        while ((line = in.readLine()) != null) {
                            CommandExecution(line);

                        }
                        System.out.println(".-----------------------------------------.");
                        if(commandsOutput != null){
                            List<String> output = new ArrayList<>();
                            in = new BufferedReader(new FileReader("Resources/test_out/" + testName));
                            while ((line = in.readLine()) != null) {
                                output.add(line);

                            }
                            for(int i= 0; i <commandsOutput.size(); i++){
                                //System.out.println(commandsOutput.get(i));
                                if(!commandsOutput.get(i).equals(output.get(i))){
                                    System.out.println("Sikertelen teszt hiba: " + i + " sorban");
                                    return;
                                }
                            }
                            System.out.println("Sikeres teszt!");
                        }

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
    public List<Train> getTrainsInModel(){
        return trainsInModel;
    }

    public void clearModel() {
        model = null;
    }
}
