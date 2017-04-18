/**
 *
 */
public class HopperCar extends RailroadCar{

    public HopperCar(Train trainRef, String name) {
        super(name, trainRef);
    }

    @Override
    public void listTrain(){
        System.out.print("HopperCar " + this.name +" "+ this.currentElement.getName());
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
