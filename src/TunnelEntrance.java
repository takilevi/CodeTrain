import java.util.List;

/**
 * Alagút bejáratát, (illetve kijáratát) megvalósító osztály.
 */
public class TunnelEntrance extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private StaticElement TunnelElement;
    private boolean isActive;

    /**
     * Alagút bejárat konstruktora.
     */
    public TunnelEntrance() {
    }

    /**
     * Visszaadja hogy aktiválták e az alagutat.
     * @return Az alagút állapota. Igaz ha aktív az alagút.
     */
    public boolean getState(){
        return isActive;
    }

    /**
     * Megváltoztatja az alagút bejárat állapotát.
     */
    public void changeState() {

        if(isActive){
            isActive = false;
        }
        else{
            isActive = true;
        }
    }

    /**
     * Megnézi hogy aktív e az alagút, és a megfelelő elemet adja vissza.
     * @return Egy statikus elem, annak megfelelően, hogy aktív volt e az alagút.
     */
    public StaticElement getTunnelElement()
    {
        return TunnelElement;
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
}
