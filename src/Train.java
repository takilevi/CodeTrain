import java.util.List;

public class Train {

    private int totalLength;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private int emptyCars;

    private Train(int length, StaticElement next, Depot d){}
    public Train(){}

    public void emptyCar(){}

    public void StartTrain(){}

    public void awakeLocomotive(int param){
        Logger.CallLogging("Train","awakeLocomotive()");

        Locomotive l = new Locomotive();
        l.move(param);

        Logger.ReturnLogging("Train", "awakeLocomotive()");
    }
}
