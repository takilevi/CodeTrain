public class PassengerCar extends RailroadCar {

    private boolean passengerOnBoard;
    private Color color;

    public PassengerCar(Color color, boolean passengers, Train trainRef, String name) {
        super(name, trainRef);

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

    @Override
    public boolean tryToGetOnPassenger(Color color){

        if(!passengerOnBoard && this.color == color){
            passengerOnBoard = true;
            return true;
        }
        if(!passengerOnBoard){
            isEmpty();
        }
        return false;
    }

    public void isEmpty(){
        train.emptyCar(this);
    }

    @Override
    public void listTrain(){
        System.out.println("PassengerCar "+name+" "+color+" "+ currentElement.getName()+" " + passengerOnBoard);
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
