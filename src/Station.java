import java.util.List;
import java.util.Scanner;

/**
 * Állomást valósítja meg az osztály.
 */
public class Station extends StaticElement {
    private StaticElement previousElement;
    private StaticElement nextElement;

    /**
     * Az állomás konstruktora.
     */
    public Station()
    {
    }

    /**
     * Az állomás színének a getter-e.
     * @return Az állomás színe.
     */
    public Color getColor(){
        Logger.CallLogging("Station", "getColor()");
        Logger.ReturnLogging("Station", "getColor(): Blue");
        return Color.Blue;}

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
        Logger.CallLogging("Station", "getNextElement()");
        Logger.ReturnLogging("Station", "getNextElement(): nextElement");

        return null;
    }

    /**
     * Volt e ütközés az elemet
     * @return Igaz, ha több mint egy mozgó objektum van rajta, egyébként hamis.
     */
    public boolean isCrash(){ return false;}

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listálya.
     */
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("Station", "getTrainsOnElement()");
        Logger.ReturnLogging("Station", "getTrainsOnElement() : List<Movable>");
        return null;

    }

    /**
     * Elhagyjuk ezt az elemet. (Kikerül a listából)
     * @param m Azon mozgó objektum aki elhagyja.
     */
    public void leaveElement(Movable m){
        Logger.CallLogging("Station", "leaveElement(Movable m)");
        Logger.ReturnLogging("Station", "leaveElement(Movable m)");
    }

    /**
     * Ráléptünk az elemre. (Bekerül a listába az obejktum)
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){
        Logger.CallLogging("Station", "stepToElement(Movable m)");

        Logger.ReturnLogging("Station", "stepToElement(Movable m)");
    }

    /**
     * Ha egy állomásra kocsi lép, akkor leszálhatnak róla utasok.
     * @param r A kocsi aki rálépett az állomásra.
     */
    public void checkStation(RailroadCar r){
        Logger.CallLogging("Station", "checkStation(RailroadCar r)");
        System.out.print("\nNyomj 1-est ha le akarsz rakni utast, 2-est ha nem: ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                r.getOffPassengers(getColor());
                break;
            case 2:
                break;
        }
        Logger.ReturnLogging("Station", "checkStation(RailroadCar r)");
    }
}
