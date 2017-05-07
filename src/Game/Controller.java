package Game;

import Graphics.Drawable;

import java.util.Map;
import java.util.Scanner;

/**
 * A felhasználó által adott inputok kezelését végzi.
 */
public class Controller {

    RailroadModel model;

    public Controller(RailroadModel model)
    {
        this.model = model;
    }

    /**
     * Olvassa a standard inputról a parancsokat,
     * és a modelnek továbbítja, hogy dolgozza fel.
     */
    public void readCommand()
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\nAdja meg a parancsot: ");
            model.CommandExecution(scanner.nextLine());

        }
    }

    public void addCommand(Drawable d){
        Map<String, StaticElement> mapElements = model.getElementsInModel();

        for (String key: mapElements.keySet()) {
            if(mapElements.get(key).getGraphics() == d){
                String trainname = "train"+model.getTrainsInModel().size();
                String locomotiveName = "locomotive"+model.getTrainsInModel().size();
                String pos = mapElements.get(key).getName();

                model.CommandExecution("addLocomotive "+ trainname+" "+locomotiveName+" "+pos);
                System.out.println("New Trains added to "+ pos);
            }
        }
    }

}
