import javax.sound.midi.SysexMessage;

/**
 * Created by Andy on 2017. 04. 11..
 */
public class PassengerCar extends RailroadCar {

    private boolean passengerOnBoard;
    private Color color;
    private Train trainRef;

    public PassengerCar(StaticElement current, Color color, boolean passengers, Train trainRef, String name) {
        super(current, name);

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

    @Override
    public void listTrain(){
        System.out.print("PassengerCar "+name+" "+color+" "+ currentElement+" " + passengerOnBoard);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean getPassengersOnBoard() {
        return passengerOnBoard;
    }
}
