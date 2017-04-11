import java.util.List;
import java.util.Scanner;

/**
 * Állomást valósítja meg az osztály.
 */
public class Station extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private int getOnPassengers;
    Color color;

    /**
     * Az állomás konstruktora.
     */
    public Station() {
    }

    /**
     * Az állomás színének a getter-e.
     * @return Az állomás színe.
     */
    public Color getColor(){

        return color;
    }

    /**
     * Létrehozásakor be kell álítani, hogy melyik pontosan két elemhez kapcsolódik.
     * @param previous Előző statikus elem.
     * @param next Következő statikus elem.
     */
    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }
    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        if(this.previousElement == previousElement){
            return nextElement;
        }
        else{
            return previousElement;
        }
    }

    /**
     * Volt e ütközés az elemet
     * @return Igaz, ha több mint egy mozgó objektum van rajta, egyébként hamis.
     */
    public boolean isCrash(){
        return false;
    }

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listálya.
     */
    public List<Movable> getTrainsOnElement()
    {
        return trainsOnElement;
    }

    /**
     * Elhagyjuk ezt az elemet. (Kikerül a listából)
     * @param m Azon mozgó objektum aki elhagyja.
     */
    public void leaveElement(Movable m){

        if(trainsOnElement.contains(m)){
            trainsOnElement.remove(m);
        }
    }

    /**
     * Ráléptünk az elemre. (Bekerül a listába az obejktum)
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){

        if(!trainsOnElement.contains(m)){
            trainsOnElement.add(m);
        }

    }

    public boolean isPassengersWaiting(){

        if(getOnPassengers>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Ha egy állomásra kocsi lép, akkor leszálhatnak róla utasok.
     * @param r A kocsi aki rálépett az állomásra.
     */
    public void checkStation(RailroadCar r){
        //Ez kell még?
    }
}
