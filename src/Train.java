import java.util.List;
import java.util.Scanner;

public class Train {

    private int totalLength;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private int emptyCars;

    private Train(int length, StaticElement next, Depot d){}
    public Train(){}

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

    public void StartTrain(){}

    public void awakeLocomotive(int param){
        Logger.CallLogging("Train","awakeLocomotive()");

        Locomotive l = new Locomotive();
        l.move(param);

        Logger.ReturnLogging("Train", "awakeLocomotive()");
    }
}
