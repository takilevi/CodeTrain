import java.util.Scanner;

/**
 * A felhasználó által adott inputok kezelését végzi.
 * A skeletonban nincs szerepe, ugyanis esetünken a main függvény végzi ez a viselkedést.
 */
public class Controller {

    RailroadModel model;

    public Controller(RailroadModel model)
    {
        this.model = model;
    }

    public void readCommand()
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\nAdja meg a parancsot: ");
            model.CommandExecution(scanner.nextLine());

        }
    }

}
