import java.util.List;
import java.util.Scanner;

/**
 * A vonatot reprezentáló osztály
 */
public class Train {

    private int totalLength;
    private Locomotive locomotive;
    private List<RailroadCar> cars;
    private List<PassengerCar> freeCars;
    private RailroadModel model;



    /**
     * Publikus konstruktor a vonathoz
     */
    public Train(RailroadModel model){
        this.model = model;
    }

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
     * Elindítja vonat counter-ét.
     */
    public void StartTrain(){}

    /**
     * A vonatot felkelti, és lépteti egyet.
     * @param param
     */
    public void awakeLocomotive(int param){

    }

    public boolean CheckPutDownEligible(RailroadCar from){
        return false;
    }

    public void fillUpTrain(Locomotive loco, List<RailroadCar> cars){

        locomotive = loco;

        this.cars = cars;

        //üres kicsit feltöltése, mert lehet alapból üresen indul 1 kocsi.

    }


}
