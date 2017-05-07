package Game;

import Graphics.Drawable;

import java.util.Map;
import java.util.Scanner;

/**
 * A felhasználó által adott inputok kezelését végzi.
 */
public class Controller {

    RailroadModel model;

    TunnelEntrance tmp;

    int count = 0;

    public Controller(RailroadModel model) {

        this.model = model;


    }

    /**
     * Olvassa a standard inputról a parancsokat,
     * és a modelnek továbbítja, hogy dolgozza fel.
     */
    public void readCommand() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\nAdja meg a parancsot: ");
            model.CommandExecution(scanner.nextLine());

        }
    }

    public void addCommand(Drawable d) {
        Map<String, StaticElement> mapElements = model.getElementsInModel();


        for (String key : mapElements.keySet()) {
            if (mapElements.get(key).getGraphics() == d) {

                if (mapElements.get(key).getName().contains("sw")) {

                    RailroadSwitch sw = (RailroadSwitch) mapElements.get(key);
                    System.out.println("Volt: " + sw.getDirection() + "  ");
                    if (sw.isMoreDirections()) {

                        model.CommandExecution("changeSwitch " + mapElements.get(key).getName() + " " + (sw.getDirection() + 1));
                        System.out.println("changeSwitch " + mapElements.get(key).getName() + " " + (sw.getDirection() + 1));
                    } else {
                        model.CommandExecution("changeSwitch " + mapElements.get(key).getName() + " " + 0);
                        System.out.println("changeSwitch " + mapElements.get(key).getName() + " " + 0);
                    }
                    System.out.println(" Lett: " + sw.getDirection() + "  ");
                } else if (mapElements.get(key).getName().contains("te")) {

                    TunnelEntrance te = (TunnelEntrance) mapElements.get(key);
                    if (te.getState()) {
                        model.CommandExecution("destroyTunnel");
                        tmp = null;
                    } else if (tmp == null) {
                        System.out.println("Elsé létrehozva");
                        tmp = te;
                    } else if (tmp != te) {
                        System.out.println("Második is");
                        model.CommandExecution("buildTunnel " + tmp.getName() + " " + te.getName());
                        tmp = null;
                    }
                } else if (mapElements.get(key).getName().contains("d0")) {
                    count++;
                    if (count == 1) {

                        String trainname = "train" + model.getTrainsInModel().size();
                        String locomotiveName = "locomotive" + model.getTrainsInModel().size();
                        String pos = mapElements.get(key).getName();

                        model.CommandExecution("addLocomotive " + trainname + " " + locomotiveName + " " + "t1");

                        String carName = "pc1";
                        model.CommandExecution("addPassengerCarToTrain " + trainname + " " + carName + " Green" + " true");

                        String hopperCarName = "hc1";
                        model.CommandExecution("addHopperCarToTrain " + trainname + " " + hopperCarName);


                        System.out.println("New Trains added to " + pos);


                    }
                    else if (count == 2 && model.getElementsInModel().get(key).getName().isEmpty() ) {

                        String trainname = "train2" + model.getTrainsInModel().size();
                        String locomotiveName = "locomotive2" + model.getTrainsInModel().size();
                        String pos = mapElements.get(key).getName();

                        model.CommandExecution("addLocomotive " + trainname + " " + locomotiveName + " " + "t1");

                        String hopperCarName = "hc2";
                        model.CommandExecution("addHopperCarToTrain " + trainname + " " + hopperCarName + "Blue" + "true");

                        String carName = "pc2";
                        model.CommandExecution("addPassengerCarToTrain " + trainname + " " + carName + " Red" + " true");

                        System.out.println("New Trains added to " + pos);
                        System.out.println(count);
                    } else {
                        System.out.println("Max 2 vonat lehet");
                    }
                    model.CommandExecution("run");

                }

            }
        }
    }

}
