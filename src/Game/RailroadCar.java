package Game;

import Graphics.Drawable;
import Graphics.RailroadCarGraphics;

import java.awt.*;

/**
 * A vonatok kocsiját kezelő osztály.
 */
public abstract class RailroadCar implements Movable {

    protected StaticElement currentElement;
    protected StaticElement previousElement;
    protected Movable carAfterCar;
    protected Movable carBefore;

    protected String name;
    protected Train train;
    protected Drawable graphics;

    public RailroadCar(String name, Train t){
        this.name = name;
        train = t;
    }

    public abstract void setGraphics(String type, int x, int y);

    public Drawable getGraphics(){
        return graphics;
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
    public abstract void setCurrent(StaticElement current);

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
    public void move(StaticElement stepToElement) {


        previousElement = currentElement;
        currentElement = stepToElement;

        previousElement.leaveElement(this);
        currentElement.stepToElement(this);



        ((RailroadCarGraphics)graphics).RefreshPosition(new Point(currentElement.getGraphics().getX(), currentElement.getGraphics().getY()));

        if (carAfterCar != null) {
            carAfterCar.move(previousElement);
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

    public boolean tryToGetOnPassenger(Color color, int number){
        return false;
    }
    public boolean tryToPutDownPassengers(Color color){
        return false;
    }
}
