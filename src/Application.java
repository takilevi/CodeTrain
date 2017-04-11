import java.io.IOException;
import java.util.Scanner;

/**
 * Az alkalmazás tartalmazza a main függvényt, innen indul a program,
 * illetve a vezérlést is ez az osztály végzi.
 */
public class Application {

    /**
     * Az alkalmazás belépési pontja.
     * Kiírja a standard inputra a menüpontokat,
     * madj bekéri a felhasználó által választott menüpont sorszámát, és meghívja vele a Teszt függvényt.
     */
    public static void main(String[] args) {



        RailroadModel model = RailroadModel.getInstance();
        Controller controller = new Controller(model);

        model.initFieldElements();
        //stb..

        controller.readCommand();

    }


}
