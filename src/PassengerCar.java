/**
 * Created by Andy on 2017. 04. 11..
 */
public class PassengerCar extends RailroadCar {

    private boolean passengerOnBoard;
    private Color color;
    private Train trainRef;

    public PassengerCar(StaticElement current, Color color, boolean passengers, Train trainRef) {
        super(current);

        this.color = color;
        passengerOnBoard = passengers;
        this.trainRef = trainRef;

    }

    public void setColor(Color color) {
        this.color = color;
    }


    public boolean tryToPutDownPassengers(Color color){

        if(passengerOnBoard && this.color == color){
            passengerOnBoard = false;
            return true;
        }
        return false;
    }

    public boolean tryToGetOnPassenger(Color color){

        if(!passengerOnBoard && this.color == color){
            passengerOnBoard = true;
            return true;
        }
        return false;
    }


}
