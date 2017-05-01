package Game;

import Graphics.View;

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
    public static void main() {

        model = RailroadModel.getInstance();
        controller = new Controller(model);
        view = new View();

        model.startGame();

        controller.readCommand();

    }
}
