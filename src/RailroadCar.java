/**
 * A vonatok kocsiját kezelő osztály.
 */
public abstract class RailroadCar implements Movable {

    protected StaticElement currentElement;
    protected StaticElement previousElement;
    protected Movable carAfterCar;
    protected Movable carBefore;

    protected String name;
    private Train train;

    public RailroadCar(StaticElement current,StaticElement previous, String name, Train t){
        this.name = name;
        currentElement = current;
        previousElement = previous;
        currentElement.stepToElement(this);
        train = t;
    }

    /**
     * Aktuális elem getter fügvénye.
     * @return az aktuális elem
     */
    public StaticElement getCurrentElement() {
        return currentElement;
    }

     /*
     * Aktuális elem beállítása
     * @param nextElement Ide lépett a kocsi.
     */
    public void setCurrent(StaticElement current) {
        currentElement = current;
    }
    public void setPreviousElement(StaticElement previousElement){this.previousElement=previousElement;}
    public StaticElement getPreviousElement(){return previousElement;}

    public String getName(){return name;}
    public Movable getCarAfterCar() {
        return carAfterCar;
    }

    public void setCarAfterCar(Movable carAfterCar) {
        this.carAfterCar = carAfterCar;
    }

    public Movable getCarBefore() {
        return carBefore;
    }

    public void setCarBefore(Movable carBefore) {
        this.carBefore = carBefore;
    }

    /**
     * Kocsi léptetése. Vagy előtte lévő kocsi, vagy a modony hívhatja meg.
     */
    public void move() {

        StaticElement next = currentElement.getNextElement(previousElement);
        previousElement = currentElement;
        currentElement = next;

        previousElement.leaveElement(this);
        currentElement.leaveElement(this);

        if (carAfterCar != null) {
            carAfterCar.move();
        }
    }

    /**
     * Ütközés detektálása
     * (A skeletonban csak mozodny ütközését vizsgáltunk, de ez kocsiknál sem különböző)
     */
    public void crash() {
        if(currentElement.isCrash()){
            train.getOfRails();
        }
        else{
            if(carAfterCar != null){
                carAfterCar.crash();
            }
        }
    }

    public abstract void listTrain();
    public abstract Color getColor();
    public abstract boolean getPassengersOnBoard();
}
