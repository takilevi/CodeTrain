/**
 * Created by Andy on 2017. 04. 11..
 */
public class HopperCar extends RailroadCar{

    private Train trainRef;


    public HopperCar(StaticElement current,Train trainRef, String name) {
        super(current, name);
        this.trainRef = trainRef;
    }

    @Override
    public void listTrain(){
        System.out.print("HopperCar" + this.name + this.currentElement);
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean getPassengersOnBoard() {
        return false;
    }

}
