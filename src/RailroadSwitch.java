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
        setDirection(0);
    }

    /**
     * Ez a fügvény hívódik, ha váltani szeretnénk.
     * Megvizsgálja hogy van -e mozgó objektum a váltón, és ennek megfelelően hív tovább.
     * @param direction Az iránya amibe állítani szeretnénk a váltót.
     */
    public void changeSwitchToDirection(StaticElement direction){

        if(trainsOnElement.isEmpty()){

            int dir = dynamicDirections.indexOf(direction);
            setDirection(dir);
        }
    }

    /**
     * Azon elemet adja vissza amelyik az éppen aktuális elemek közül aktívak.
     * @return Az aktív statikus elem.
     */
    public StaticElement getCurrentSwitchInDirection(){

        return dynamicDirections.get(direction);
    }

    /**
     * Visszaadja a statikus irányt.
     * @return Az elem ami statikus irányból szomszédos a váltóval.
     */
    public StaticElement getStaticDirection(){

        return staticDirection;
    }

    /**
     * Beállíthatjuk az egyértékű elemet.
     * @param staticDir Egy statikus elem, ez mindig fix, nem állíthatjuk
     */
    @Override
    public void setStaticDirection(StaticElement staticDir) {

        staticDirection = staticDir;
    }

    @Override
    public void setTunnelElement(StaticElement tunnelElement) {

    }

    /**
     * Váltunk egyet
     * @param i Azon iránya, amibe állítani akarjuk a váltót.
     */
    public void setDirection(int i){

        if(i <= dynamicDirections.size()){
            direction = i;
        }
    }

    /**
     * Megnézi melyik irányba áll a váltó, és ezzel visszatér.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        if(previousElement == staticDirection){
            return dynamicDirections.get(direction);
        }
        else if(previousElement == dynamicDirections.get(direction)){
            return staticDirection;
        }
        else{
            //Finishgame, kéne ismernie a modellt nem?
            return null;
        }
    }

    @Override
    public StaticElement getPrevForLoco() {
        return null;
    }

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listája.
     */

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listája.
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
     * @param m Aki rálépett az elemre.
     */
    public void stepToElement(Movable m){

        if(!trainsOnElement.contains(m)){
            trainsOnElement.add(m);
        }
    }

    @Override
    public void setNextElement(StaticElement nextElement) {

    }

    @Override
    public void setPreviousElement(StaticElement previousElement) {

    }

    /**
     * A váltó inicíalizálása
     * @param one_dir Azon Statikus elemek, amelyek közül mindíg egyikre állíthatjuk a váltónkat.
     */
    @Override
    public void setDynamicDirection(StaticElement one_dir)
    {
        dynamicDirections.add(one_dir);
    }
}
