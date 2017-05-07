package Game;

import Graphics.RailroadCarGraphics;

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

    @Override
    public void setGraphics(String type, int x, int y) {
        graphics = new RailroadCarGraphics(type, x, y);
    }

    /**
     * Segédfüggvény a prototípushoz, kiírja a vonat 'állapotát'
     */
    @Override
    public void listTrain() {
        RailroadModel.commandsOutput.add("Game.HopperCar " + this.name + " " +this.currentElement.getName());
        System.out.println("Game.HopperCar " + this.name + " " +this.currentElement.getName());
    }

    /**
     * nincs színe
     * @return
     */
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setCurrent(StaticElement current) {

        currentElement = current;
        currentElement.stepToElement(this);

        setGraphics("hcar.png", current.getGraphics().getX(), current.getGraphics().getY());
        System.out.println("Added");
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
