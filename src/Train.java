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
        locomotive.move();

        locomotive.crash();

        //Nincs vége a játéknak
        System.out.println("false");
        System.out.println("false");

    }

    public boolean CheckPutDownEligible(RailroadCar from){
        return false;
    }

    public void fillUpTrain(Locomotive loco, List<RailroadCar> cars) {


        locomotive = loco;

        if (cars != null) {
            this.cars = cars;
            totalLength += cars.size();
        }
    }

    public void addCar(RailroadCar car) {

        this.cars.add(car);
        totalLength++;
        elementFindForCar(car);
    }
        //üres kicsik feltöltése, mert lehet alapból üresen indul 1 kocsi.


    private void elementFindForCar(RailroadCar car){
        //TODO meg kell keresni a staticelementjét, használjuk a totallenght-et
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
