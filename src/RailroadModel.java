import java.io.*;
import java.util.*;

public class RailroadModel {

    private static RailroadModel model;
    protected int trainCount;

    public static RailroadModel getInstance()
    {
        if(model == null)
        {
            model = new RailroadModel();
        }
        return model;
    }

    //Ezt ki írta és mi ez? Miért nem volt jó az előző? Inkább azt kéne módosítani.
   /* public RailroadModel(String location) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(location)))));

        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] args = line.split(" ");

        }
    }*/

   private RailroadModel(){}

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

    public void startGame(){}

    public void finishGame(){
        Logger.CallLogging("RailroadModel", "finishGame()");
        Logger.ReturnLogging("RailroadModel", "finishGame()");
    }

    public void emptyTrain(){}
}
