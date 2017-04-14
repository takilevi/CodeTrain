import java.util.List;

/**
 * A "depó",azaz a kocsiszín, a vonatok indításáért felelős, innen indulnak a vonatok.
 * Csak egy irányba lehet elhagyni az depót,
 * azaz azon vonat, aki indulása után ide érkezik, kisiklik.
 */
<<<<<<< HEAD
public class Depot  {
=======
public class Depot {
>>>>>>> origin/master


    private List<StaticElement> depotElements;

    /**
     * A kocsiszín konstruktora.
     */
    public Depot() {}

    public List<StaticElement> getDepotElements() {
        return depotElements;
    }

    /**
     * Vonatot bocsájt ki a pályára
     */
    public void releaseTrain(){}

    public void checkElementsFree(){}

    public void addDepotPoint(StaticElement point) {

        depotElements.add(point);

    }
<<<<<<< HEAD


    public StaticElement getNextElement(StaticElement previousElement) {
        return null;
    }
=======
>>>>>>> origin/master
}
