package Game;

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

}
