package Game;

/**
 * Utasszállító kocsi
 */
public class PassengerCar extends RailroadCar {

    /**
     * Utazhatnak rajta utasok, és van színe
     */
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

    /**
     * Leszállhatnak róla utasok, ha megfelelő színű
     * @param color Az állomás színe
     * @return leszálltak-e?
     */
    @Override
    public boolean tryToPutDownPassengers(Color color){

        if(passengerOnBoard && this.color == color){
            passengerOnBoard = false;
            return true;
        }
        return false;
    }

    /**
     * Felszállhatnak rá utasok, ha megfelelő színű, és üres
     * @param color állomás színe
     * @param number akar e valaki felszállni (0 v 1)
     * @return felszálltak e
     */
    @Override
    public boolean tryToGetOnPassenger(Color color, int number){

        if(!passengerOnBoard && this.color == color && number > 0){
            passengerOnBoard = true;
            return true;
        }
        isEmpty();
        return false;
    }

    /**
     * Kiürült e a kocsi
     */
    public void isEmpty(){
        if(!passengerOnBoard)
            train.emptyCar(this);
    }

    @Override
    public void listTrain(){
        RailroadModel.commandsOutput.add("Game.PassengerCar "+name+" "+color+" "+ currentElement.getName()+" " + passengerOnBoard);
        System.out.println("Game.PassengerCar "+name+" "+color+" "+ currentElement.getName()+" " + passengerOnBoard);
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
