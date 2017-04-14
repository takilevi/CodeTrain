/**
 * Created by Andy on 2017. 04. 11..
 */
public class HopperCar extends RailroadCar{



    public HopperCar(StaticElement current, String name) {
        super(current, name);
    }

    @Override
    public void listTrain(){
        System.out.print("HopperCar" + this.name + this.currentElement);
    }

}
