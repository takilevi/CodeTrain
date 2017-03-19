/**
 * A "depó",azaz a kocsiszín, a vonatok indításáért felelős, innen indulnak a vonatok.
 * Csak egy irányba lehet elhagyni az depót,
 * azaz azon vonat, aki indulása után ide érkezik, kisiklik.
 */
public class Depot extends StaticElement {

    /**
     * A kocsiszín konstruktora.
     */
    public Depot()
    {
    }

    private StaticElement nextElement;


    /**
     * A depó után következő statikus elemet lehet beállítani a settere segítségével.
     * @param next : A következő elem
     */
    public void setNextElement(StaticElement next)
    {
        nextElement = next;
    }

    /**
     * Vonatot bocsájt ki a pályára
     */
    public void releaseTrain(){}
}
