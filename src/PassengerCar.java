public class PassengerCar extends RailroadCar {

    private boolean passengerOnBoard;
    private Color color;

    public PassengerCar(StaticElement current,StaticElement previous, Color color, boolean passengers, Train trainRef, String name) {
        super(current, previous,  name, trainRef);

        this.color = color;
        passengerOnBoard = passengers;
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
