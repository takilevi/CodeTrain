package App;

import Controller.TrainController;
import Model.Train;
import View.TrainView;

public class App {

    public static void main(String[] args)
    {
        Train model = GetTrainData();
        TrainView view = new TrainView();
        TrainController controller = new TrainController(model, view);

        controller.UpdateView();

        model.SetVelocity(30);

        controller.UpdateView();
    }

    private static Train GetTrainData()
    {
        Train train = new Train();
        train.SetVelocity(9999999);
        train.SetColor("blue"); //Első felesleges komment.
        return train;
    }
}
