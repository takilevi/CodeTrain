package Game;

import Graphics.View;
import Graphics.Window;
import com.sun.javaws.WinOperaSupport;

import java.io.IOException;

/**
 * Az alkalmazás tartalmazza a main függvényt, innen indul a program,
 * illetve a vezérlést is ez az osztály végzi.
 */
public class Application {

    private static RailroadModel model;
    private static Controller controller;
    private static View view;

    /**
     * Az alkalmazás belépési pontja.
     * Kiírja a standard inputra a menüpontokat,
     * majd bekéri a felhasználó által választott menüpont sorszámát, és meghívja vele a Teszt függvényt.
     */
    public static void main(String [] args){

        Window w = new Window();
        w.setVisible(true);
        model = RailroadModel.getInstance();
        controller = new Controller(model);
        view = new View(model, w, controller);
        model.setView(view);

        model.startGame();

        model.CommandExecution("loadMap map2.txt");

        controller.readCommand();


    }
}
