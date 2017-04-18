/**
 * Szeneskocsi
 */
public class HopperCar extends RailroadCar{

    /**
     *
     * @param trainRef A vonat referenciája
     * @param name A kocsi neve
     */
    public HopperCar(Train trainRef, String name) {
        super(name, trainRef);
    }

    /**
     * Segédfüggvény a prototípushoz, kiírja a vonat 'állapotát'
     */
    @Override
    public void listTrain() {
        RailroadModel.commandsOutput.add("HopperCar " + this.name + " " +this.currentElement.getName());
        System.out.println("HopperCar " + this.name + " " +this.currentElement.getName());
    }

    /**
     * nincs színe
     * @return
     */
    @Override
    public Color getColor() {
        return null;
    }

    /**
     * Nem szállít utasokat
     * @return
     */
    @Override
    public boolean getPassengersOnBoard() {
        return false;
    }

}
