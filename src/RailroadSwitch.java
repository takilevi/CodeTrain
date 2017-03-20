import java.util.List;

/**
 * A váltót megvalósító osztály
 */
public class RailroadSwitch extends StaticElement {

    private int direction;
    private StaticElement staticDirection;
    private List<StaticElement> dynamicDirections;

    /**
     * A váltó konstruktora.
     */
    public RailroadSwitch()
    {
    }

    /**
     * Ez a fügvény hívódik, ha váltani szeretnénk.
     * Megvizsgálja hogy van e mozgó objektum a váltón, és ennek megfelelően hív tovább.
     * @param dir Az iránya amibe állítani szeretnénk a váltót.
     */
    public void changeSwitchToDirection(int dir){

        switch (dir){
            case 1:
                Logger.CallLogging("RailroadSwitch","changeSwitchToDirection(int i)");
                trainsOnElement =0;
                setDirection(1);

                if(trainsOnElement == 0){
                    Logger.ReturnLogging("RailroadSwitch","setDirection(int i)");
                }
                Logger.ReturnLogging("RailroadSwitch","changeSwitchToDirection(int i)");
                break;
            case 2:
                Logger.CallLogging("RailroadSwitch","changeSwitchToDirection()");
                Logger.ReturnLogging("RailroadSwitch","changeSwitchToDirection");
        }
    }

    /**
     * Azon elemet adja vissza amelyik az éppen aktuális elemek közül aktívak.
     * @return Az aktív statikus elem.
     */
    public StaticElement getCurrentSwitchInDirection(){
        Logger.CallLogging("RailroadSwitch", "getCurrentSwitchInDirection()");
        Logger.ReturnLogging("RailroadSwitch", "getCurrentSwitchInDirection(): staticElement");
        return null;
    }

    /**
     * Visszaadja a statikus irányt.
     * @return Az elem ami statikus irányból szomszédos a váltóval.
     */
    public StaticElement getStaticDirection(){
        Logger.CallLogging("RailroadSwitch", "getStaticDirection()");
        Logger.ReturnLogging("RailroadSwitch", "getStaticDirection(): staticElement");
        return null;}

    /**
     * Beállíthatjuk az egyértékű elemet.
     * @param staticDir Egy statikus elem, ez mindig fix, nem állíthatjuk
     */
    public void setStaticDirection(StaticElement staticDir)
    {
        staticDirection = staticDir;
    }

    /**
     * Váltunk egyet
     * @param i Azon iránya, amibe állítani akarjuk a váltót.
     */
    public void setDirection(int i){

        Logger.CallLogging("RailroadSwitch","SetDirection(int i)");
    }

    /**
     * Megnézi melyik irányba áll a váltó, és ezzel visszatér.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("RailroadSwitch", "getNextElement()");
        getCurrentSwitchInDirection();
        Logger.ReturnLogging("RailroadSwitch", "getNextElement(): nextElement");

        return null;
    }

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listálya.
     */
    public boolean isCrash(){ return false;}

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listálya.
     */
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("RailroadSwitch", "getTrainsOnElement()");
        Logger.ReturnLogging("RailroadSwitch", "getTrainsOnElement()");
        return null;
    }

    /**
     * Elhagyjuk ezt az elemet. (Kikerül a listából)
     * @param m Azon mozgó objektum aki elhagyja.
     */
    public void leaveElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "leaveElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "leaveElement(Movable m)");
    }

    /**
     * Ráléptünk az elemre. (Bekerül a listába az obejktum)
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "stepToElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "stepToElement(Movable m)");
    }

    /**
     * A váltó inicíalizálása
     * @param directions Azon Statikus elemek, amelyek közül mindíg egyikre állíthatjuk a váltónkat.
     */
    public void setDynamicDirections(List<StaticElement> directions)
    {
        dynamicDirections = directions;
    }
}
