package Controller;

import Model.Train;
import View.TrainView;

public class TrainController {

    private Train model;
    private TrainView view;

    public TrainController(Train model, TrainView view){
        this.model = model;
        this.view = view;
    }

    public void SetTrainColor(String color){
        model.SetColor(color);
    }

    public String GetTrainColor(){
        return model.GetColor();
    }

    public void SetTrainVelocity(int velocity){
        model.SetVelocity(velocity);
    }

    public int GetTrainVelocity(){
        return model.GetVelocity();
    }

    public void UpdateView(){
        view.PrintTrainDetails(model.GetColor(), model.GetVelocity());
    }

}
