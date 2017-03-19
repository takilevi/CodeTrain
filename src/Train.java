import java.util.List;
import java.util.Scanner;

/**
 * A vonatot reprezentáló osztály
 */
public class Train {

    private int totalLength;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private int emptyCars;

    /**
     * A vonat privatát konstruktora
     * @param length A vonat hossza
     * @param next A következő elem ahova lépni fog a vonat
     * @param d A depó, ahol létrejött a vonat
     */
    private Train(int length, StaticElement next, Depot d){}

    /**
     * Publikus konstruktor a vonathoz
     */
    public Train(){}

    /**
     * Ha kiürül egy kocsi, eggyel csökenti a teli kocsik számát.
     * Ha az összes kocsi kiürült, és (ebben az esetben) nincs több vonat a modelben,
     * hív egy finishgame()-et.
     */
    public void  emptyCar(){
        Logger.CallLogging("Train","emptyCar()");
        System.out.print("\nNyomj 1-est ha ez volt az utolsó kiürítendő kocsi, 2-est ha nem: ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                RailroadModel.getInstance().finishGame();
                break;
            case 2:
                break;
        }
        Logger.ReturnLogging("Train","emptyCar()");
    }

    /**
     * Elindítja vonat counter-ét.
     */
    public void StartTrain(){}

    /**
     * A vonatot felkelti, és lépteti egyet.
     * @param param
     */
    public void awakeLocomotive(int param){
        Logger.CallLogging("Train","awakeLocomotive()");

        Locomotive l = new Locomotive();
        l.move(param);

        Logger.ReturnLogging("Train", "awakeLocomotive()");
    }
}
