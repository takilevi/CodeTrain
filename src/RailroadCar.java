import java.util.Scanner;

/**
 * A vonatok kocsiját kezelő osztály.
 */
public class RailroadCar implements Movable {

    private boolean passengersOnBoard;
    private StaticElement currentElement;
    private RailroadCar carAfterCar;
    private Color color;

    /**
     * Létrehozhatunk új vonatkocsit.
     * @param c A kocsi színe, csak ilyen színű állomáson rakhatja le utasait.
     * @param current
     * @param carAfter
     */
    public void create(Color c, StaticElement current, RailroadCar carAfter) {
    }

    /**
     * Aktuális elem getter fügvénye.
     * @return az aktuális elem
     */
    public StaticElement getCurrentElement() {
        return null;
    }

    /**
     * Utasok leszállítása.
     * @param color Az állomás színe, ha nem egyezik a kocsi színével, nem szálhatnak le az utasok.
     */
    public void getOffPassengers(Color color) {
        Logger.CallLogging("RailroadCar","getOffPassengers(Color color)");
        Train vonat = new Train();
        vonat.emptyCar();
        Logger.ReturnLogging("RailroadCar","getOffPassengers(Color color)");
    }

    /**
     * Előző elem beállítása
     * @param currentElement Erről jött a kocsi.
     */
    public void setPrevious(StaticElement currentElement) {
        Logger.CallLogging("RailroadCar","setPrevious(StaticElement currentElement)");
        Logger.ReturnLogging("RailroadCar","setPrevious(StaticElement currentElement)");
    }

    /**
     * Aktuális elem beállítása
     * @param nextElement Ide lépett a kocsi.
     */
    public void setCurrent(StaticElement nextElement) {
        Logger.CallLogging("RailroadCar","setCurrent(StaticElement currentElement)");
        Logger.ReturnLogging("RailroadCar","setCurrent(StaticElement currentElement)");
    }

    /**
     * Kocsi léptetése. Vagy előtte lévő kocsi, vagy a modony hívhatja meg.
     * @param param Milyen elemre lépjünk tovább
     */
    public void move(int param) {
        Logger.CallLogging("RailroadCar", "move()");

        switch (param){
            case 1:
                Track s1 = new Track();
                Track s2 = new Track();
                RailroadCar r = new RailroadCar();

                s2.getNextElement(s1);
                Track temp = new Track();
                setPrevious(s2);
                setCurrent(temp);

                s2.leaveElement(this);

                temp.stepToElement(this);
                break;
            case 2:
                Track tr1_st = new Track();
                Station stat1 = new Station();
                StaticElement previous = new StaticElement();

                tr1_st.getNextElement(previous);
                setPrevious(tr1_st);
                setCurrent(stat1);

                tr1_st.leaveElement(this);
                stat1.stepToElement(this);
                stat1.checkStation(this);


                break;
        }


        Logger.ReturnLogging("RailroadCar", "move()");
    }

    /**
     * Ütközés detektálása
     * (A skeletonban csak mozodny ütközését vizsgáltunk, de ez kocsiknál sem különböző)
     */
    public void crash() {
    }
}
