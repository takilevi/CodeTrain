import java.util.ArrayList;
import java.util.List;

/**
 * A vonatot reprezentáló osztály
 */
public class Train {

    private int totalLength = 0;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private List<PassengerCar> freeCars;
    private RailroadModel model;
    private String name;

    /**
     * Publikus konstruktor a vonathoz
     */
    public Train(RailroadModel model, String name){
        this.name = name;
        this.model = model;
        cars = new ArrayList<>();
        freeCars = new ArrayList<>();
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

        if(freeCars.contains(car)){
            freeCars.remove(car);

            if(freeCars.isEmpty()){
                model.emptyTrain(this);
            }
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

        //TODO WTF is that?
        //Nincs vége a játéknak
        System.out.println("false");
        System.out.println("false");

    }

    public boolean CheckPutDownEligible(RailroadCar from){
        return false;
    }

    public void fillUpTrain(Locomotive loco, List<RailroadCar> cars) {


        locomotive = loco;
        //TODO:itt ne adjunk cars listát, nem praktikus, ez legyen az addLocomotive, és van egy addCar

    }

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
    }

    public void listTrain(){
        System.out.println(name);
        locomotive.listTrain();
        for(int i= 0; i< cars.size(); i++){
            cars.get(i).listTrain();
        }
    }

    public void getOfRails(){
        model.finishGame(1);
    }

}
