import java.util.ArrayList;
import java.util.List;

/**
 * A vonatot reprezentáló osztály
 */
public class Train {

    private int totalLength = 0;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private List<RailroadCar> fullCars;
    private RailroadModel model;
    private String name;

    /**
     * Publikus konstruktor a vonathoz
     */
    public Train(RailroadModel model, String name){
        this.name = name;
        this.model = model;
        cars = new ArrayList<>();
        fullCars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<RailroadCar> getCars(){return cars;}

    /**
     * Ha kiürül egy kocsi, eggyel csökenti a teli kocsik számát.
     * Ha az összes kocsi kiürült, és (ebben az esetben) nincs több vonat a modelben,
     * hív egy finishgame()-et.
     */
    public void  emptyCar(PassengerCar car){

        if(fullCars.contains(car)){
            fullCars.remove(car);


            if(fullCars.isEmpty()){
                model.emptyTrain(this);
            }
        }
    }
    public void fullCar(PassengerCar full){
        if(!fullCars.contains(full)){
            fullCars.add(full);
        }
    }

    /**
     * Elindítja a vonat counter-ét.
     */
    public void StartTrain(){}

    /**
     * A vonatot felkelti, és lépteti egyet.
     */
    public void awakeLocomotive(){

        locomotive.move(null);

        locomotive.crash();

        RailroadModel.commandsOutput.add("Nyertünk: false");
        RailroadModel.commandsOutput.add("Vesztettünk: false");
        System.out.println("Nyertünk: false");
        System.out.println("Vesztettünk: false");

    }

    public boolean CheckPutDownEligible(RailroadCar from){
        return false;
    }

    /**
     * Mozdony hozzáadása a vonathoz (csak 1 lehet)
     * @param loco a mozdony
     */
    public void addLocomotive(Locomotive loco) {

        if(locomotive == null){
            locomotive = loco;
        }


    }

    /**
     * Kocsi hozzáadása a vonathoz
     * @param car a kocsi
     */
    public void addCar(RailroadCar car) {


        if(cars != null && !cars.isEmpty()) {
            cars.get(cars.size()-1).setCarAfterCar(car);
            car.setCarBefore(cars.get(cars.size()-1));
            car.setCurrent(cars.get(cars.size()-1).getPreviousElement());
            if(car.getCurrentElement().getPrevForLoco() != null)car.setPreviousElement(car.getCurrentElement().getPrevForLoco());
            this.cars.add(car);

            totalLength++;
        }
        if(cars.isEmpty()){
            locomotive.setCarAfter(car);
            car.setCarBefore(locomotive);
            car.setCurrent(locomotive.getPreviousElement());
            if(car.getCurrentElement().getPrevForLoco() != null)car.setPreviousElement(locomotive.getPreviousElement().getPrevForLoco());
            this.cars.add(car);

            totalLength++;
        }

        if(car.getPassengersOnBoard()){
            fullCars.add(car);

            model.fullTrain(this);
        }
    }

    public void listTrain(){
        RailroadModel.commandsOutput.add(name);
        System.out.println(name);
        locomotive.listTrain();
        for(int i= 0; i< cars.size(); i++){
            cars.get(i).listTrain();
        }
    }

    /**
     * Kisiklott a vonat
     */
    public void getOfRails(){
        model.finishGame(1);
    }

}
