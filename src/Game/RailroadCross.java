package Game;

import Graphics.Drawable;
import Graphics.RailroadCrossGraphics;
import Graphics.TrackGraphics;

import javax.swing.*;
import java.util.List;

/**
 * Kereszteződés
 */
public class RailroadCross extends StaticElement {

    /**
     * 4 elemet köt össze:  +
     */
    private StaticElement firstEntrance;
    private StaticElement firstExit;
    private StaticElement secondEntrance;
    private StaticElement secondExit;

    public RailroadCross(String name) {
        super(name);
    }

    @Override
    public void setGraphics(String type, int x, int y) {
        graphics = new RailroadCrossGraphics(type, x, y);
    }

    @Override
    public Drawable getGraphics() {
        return graphics;
    }

    /**
     * A következő elemet visszaadja annak megfelelően hogy honnan léptünk rá.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return
     */
    @Override
    public StaticElement getNextElement(StaticElement previousElement) {

        System.out.println(previousElement.getName());
        System.out.println(firstEntrance.getName());
        System.out.println(firstExit.getName());
        System.out.println(secondEntrance.getName());
        System.out.println(secondExit.getName());

        if (previousElement.getName().equals(firstEntrance.getName())) {
            return firstExit;
        } else if (previousElement.getName().equals(firstExit.getName())) {
            return firstEntrance;
        } else if (previousElement.getName().equals(secondEntrance.getName())) {
            return secondExit;
        } else if (previousElement.getName().equals(secondExit.getName())) {
            return secondEntrance;
        } else {
            return null;
        }
    }

    @Override
    public StaticElement getPrevForLoco() {
        return null;
    }

    public void setFirstDirections(StaticElement entrance, StaticElement exit) {

        firstEntrance = entrance;
        firstExit = exit;
    }

    public void setSecondDirections(StaticElement entrance, StaticElement exit) {

        secondEntrance = entrance;
        secondExit = exit;
    }

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     *
     * @return Ezen objektumok listálya.
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
     * Ráléptünk az elemre. (Bekerül a listába az obejktum)
     *
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m) {

        if (!trainsOnElement.contains(m)) {
            trainsOnElement.add(m);
        }
    }

    /**
     * Segéd függvény
     * @return Az 'első' irányok kiírása
     */
    public String firstDirections() {
        String st = "";
        st += "Entrance: ";
        st += firstEntrance.getName();
        st += " Exit: ";
        st += firstExit.getName();
        return st;
    }

    /**
     * Segéd fv.
     * @return A 'másodlagos' irányok kiírása
     */
    public String secondDirections() {
        String st = "";
        st += "Entrance: ";
        st += secondEntrance.getName();
        st += " Exit: ";
        st += secondExit.getName();
        return st;
    }

    @Override
    public void setNextElement(StaticElement nextElement) {

        if(firstExit== null){
            firstExit= nextElement;
        }
        else if(secondExit==null){
            secondExit = nextElement;
        }

    }

    @Override
    public void setPreviousElement(StaticElement previousElement) {
        if(firstExit== null){
            firstEntrance= previousElement;
        }
        else if(secondExit==null){
            secondEntrance = previousElement;
        }
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
}