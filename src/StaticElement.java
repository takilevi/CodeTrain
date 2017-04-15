import java.util.List;

/**
 * Statikus pályaelemet reprezentál. (Az amire a mozgó objektumaink ráléphetnek)
 */
public abstract class StaticElement {

    protected List<Movable> trainsOnElement;

    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public abstract StaticElement getNextElement(StaticElement previousElement);
    public abstract  StaticElement getPrevForLoco();
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


    public abstract void setNextElement(StaticElement nextElement);
    public abstract void setPreviousElement(StaticElement previousElement);
    public abstract void setDynamicDirection(StaticElement one_dir);
    public abstract void setStaticDirection(StaticElement staticDir);
    public abstract void setTunnelElement(StaticElement tunnelElement);
}
