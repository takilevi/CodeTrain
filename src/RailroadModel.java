
public class RailroadModel {

    private static RailroadModel model = new RailroadModel();
    protected int trainCount;

    public static RailroadModel getInstance() {
        return model;
    }

    private RailroadModel() {}

    public void initFiledElements(){}

    public void startGame(){}

    public void finishGame(){}

    public void emptyTrain(){}
}
