import java.util.List;

/**
 * Egy egyszerű sínt reprezentáló osztály.
 */
public class Track extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;

    /**
     * A sín konstruktora.
     */
    public Track()
    {
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
     * Volt e ütközés a sínen.
     * @return Ha több mint egy mozgó objektum van rajta akkor igaz, egyébként hamis.
     */
    public boolean isCrash()
    {
        return false;
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
     *
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){

        if(!trainsOnElement.contains(m)){
            trainsOnElement.add(m);
        }
    }
}



