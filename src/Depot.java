import java.util.List;

/**
 * A "depó", azaz a kocsiszín, a vonatok indításáért felelős, innen indulnak a vonatok.
 * Csak egy irányba lehet elhagyni az depót,
 * azaz azon vonat, aki indulása után ide érkezik, kisiklik.
 */


//MIVEL A PROTOTÍPUSBAN TETSZŐLEGES ELEMRE HELYEZHETÜNK EL VONATOT, NINCS SZEREPE AZ OSZTÁLYNAK MÉG!
//Todo: Majd végleges verzióra elkészíteni!
public class Depot {

    private List<StaticElement> depotElements;

    /**
     * A kocsiszín konstruktora.
     */
    public Depot() {}

    /**
     * Visszaadja a depóban lévő elemeket
     * @return
     */
    public List<StaticElement> getDepotElements() {
        return depotElements;
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
