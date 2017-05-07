package Game;

import Graphics.Drawable;
import Graphics.TrackGraphics;

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
    public Track(String name) {
        super(name);

    }

    @Override
    public void setGraphics(String type, int x, int y) {
        graphics = new TrackGraphics(type, x, y);

    }

    @Override
    public Drawable getGraphics() {
        return graphics;
    }

    /**
     * Létrehozásakor be kell álítani, hogy melyik két elemhez kapcsolódik.
     *
     * @param previous Előző statikus elem.
     * @param next     Következő statikus elem.
     */
    public void setElements(StaticElement previous, StaticElement next) {
        previousElement = previous;
        nextElement = next;
    }

    @Override
    public void setPreviousElement(StaticElement previousElement) {
        this.previousElement = previousElement;
    }

    @Override
    public void setDynamicDirection(StaticElement one_dir) {

    }

    @Override
    public void setStaticDirection(StaticElement staticDir) {

    }

    @Override
    public void setTunnelElement(StaticElement tunnelElement) {

    }

    @Override
    public void setNextElement(StaticElement nextElement) {
        this.nextElement = nextElement;
    }

    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     *
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement) {
        System.out.println("Pre"+previousElement+" this "+this.previousElement);
        if (this.previousElement.getName().equals(previousElement.getName())) {
            return nextElement;
        } else {
            return this.previousElement;
        }
    }

    @Override
    public StaticElement getPrevForLoco() {
        return previousElement;
    }

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     *
     * @return Ezen objektumok listája.
     */
    public List<Movable> getTrainsOnElement() {
        return trainsOnElement;

    }

    /**
     * Elhagyjuk ezt az elemet. (Kikerül a listából)
     *
     * @param m Azon mozgó objektum aki elhagyja.
     */
    public void leaveElement(Movable m) {

        if (trainsOnElement.contains(m)) {
            trainsOnElement.remove(m);
        }
    }

    /**
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m) {

        if (!trainsOnElement.contains(m)) {
            trainsOnElement.add(m);
        }
    }
}



