import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

/**
 * A vonatok kocsiját kezelő osztály.
 */
public abstract class RailroadCar implements Movable {


    private StaticElement currentElement;
    private Movable carAfterCar;
    private Movable carBefore;

    public RailroadCar(StaticElement current){
        currentElement = current;
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
     * @param param Milyen elemre lépjünk tovább
     */
    public void move(int param) {

    }

    /**
     * Ütközés detektálása
     * (A skeletonban csak mozodny ütközését vizsgáltunk, de ez kocsiknál sem különböző)
     */
    public void crash() {

    }
}
