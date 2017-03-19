import java.util.List;

/**
 * Statikus pályaelemet reprezentál. (Az amire a mozgó objektumaink ráléphetnek)
 */
public class StaticElement {

    protected int trainsOnElement;

    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("StaticElement", "getNextElement()");
        Logger.ReturnLogging("StaticElement", "nextElement");

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
        Logger.CallLogging("StaticElement", "getTrainsOnElement()");
        Logger.ReturnLogging("StaticElement", "getTrainsOnElement()");
        return null;

    }

    /**
     * Elhagyjuk ezt az elemet. (Kikerül a listából)
     * @param m Azon mozgó objektum aki elhagyja.
     */
    public void leaveElement(Movable m){
        Logger.CallLogging("StaticElement", "leaveElement(Movable m)");
        Logger.ReturnLogging("StaticElement", "leaveElement(Movable m)");
    }

    /**
     * Ráléptünk az elemre. (Bekerül a listába az obejktum)
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){
        Logger.CallLogging("StaticElement", "stepToElement(Movable m)");
        Logger.ReturnLogging("StaticElement", "stepToElement(Movable m)");
    }


}
