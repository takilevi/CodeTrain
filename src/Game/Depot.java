package Game;

import Graphics.StationGraphics;

import java.util.List;

/**
 * A "depó", azaz a kocsiszín, a vonatok indításáért felelős, innen indulnak a vonatok.
 * Csak egy irányba lehet elhagyni az depót,
 * azaz azon vonat, aki indulása után ide érkezik, kisiklik.
 */


//MIVEL A PROTOTÍPUSBAN TETSZŐLEGES ELEMRE HELYEZHETÜNK EL VONATOT, NINCS SZEREPE AZ OSZTÁLYNAK MÉG!
//Todo: Majd végleges verzióra elkészíteni!
public class Depot extends StaticElement {

    private List<StaticElement> depotElements;

    /**
     * A kocsiszín konstruktora.
     */
    public Depot(String name) {
        super(name);
    }

    /**
     * Visszaadja a depóban lévő elemeket
     * @return
     */
    public List<StaticElement> getDepotElements() {
        return depotElements;
    }

    @Override
    public void setGraphics(String type, int x, int y) {
        graphics = new StationGraphics(type, x, y);
    }

    @Override
    public StaticElement getNextElement(StaticElement previousElement) {
        return null;
    }

    @Override
    public StaticElement getPrevForLoco() {
        return null;
    }

    @Override
    public void setNextElement(StaticElement nextElement) {

    }

    @Override
    public void setPreviousElement(StaticElement previousElement) {

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

    /**
     * Vonatot bocsájt ki a pályára(A prototípusban adott helyre helyezhetünk el vonatokat, íhy nincs szerepe)
     */
    public void releaseTrain(){}

    public void checkElementsFree(){}

    public void addDepotPoint(StaticElement point) {

        depotElements.add(point);

    }


}
