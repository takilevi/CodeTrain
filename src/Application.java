/**
 * Az alkalmazás tartalmazza a main függvényt, innen indul a program,
 * illetve a vezérlést is ez az osztály végzi.
 */
public class Application {

    private static RailroadModel model;
    private static Controller controller;

    /**
     * Az alkalmazás belépési pontja.
     * Kiírja a standard inputra a menüpontokat,
     * majd bekéri a felhasználó által választott menüpont sorszámát, és meghívja vele a Teszt függvényt.
     */
    public static void main(String[] args) {

        model = RailroadModel.getInstance();
        controller = new Controller(model);

        model.startGame();

        controller.readCommand();

    }
}
