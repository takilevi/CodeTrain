package Game;

import Graphics.RailroadCrossGraphics;
import Graphics.RailroadSwitchGraphics;

import java.util.ArrayList;
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
    public RailroadSwitch(String name)
    {
        super(name);
        direction = 0;
        dynamicDirections = new ArrayList<>();
    }

    @Override
    public void setGraphics(String type, int x, int y) {

        graphics = new RailroadSwitchGraphics(type, x, y);
    }

    /**
     * Ez a fügvény hívódik, ha váltani szeretnénk.
     * Megvizsgálja hogy van -e mozgó objektum a váltón, és ennek megfelelően hív tovább.
     * @param d Az iránya amibe állítani szeretnénk a váltót.
     */
    public void changeSwitchToDirection(int d){

        if(trainsOnElement.isEmpty()){
            setDirection(d);
        }
    }

    public boolean isMoreDirections(){
        int k = direction+1;
        if(k < dynamicDirections.size()){

            return true;
        }
        else{
            return false;

        }
    }
    public int getDirection(){
        return direction;
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

        if(i < dynamicDirections.size()){
            direction = i;
            ((RailroadSwitchGraphics) graphics).setDirection(direction);
        }
    }

    /**
     * Megnézi melyik irányba áll a váltó, és ezzel visszatér.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {



        if(previousElement.getName().equals(staticDirection.getName())){
            System.out.println("statikusból jött");
            return dynamicDirections.get(direction);
        }
        else if(previousElement.getName().equals(dynamicDirections.get(direction).getName())){
            System.out.println("dinamikusból jött");
            return staticDirection;
        }
        else{
            return null;
        }
    }

    @Override
    public StaticElement getPrevForLoco() {
        return staticDirection;
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

    public String getDynamicDirectionNames(){
        String names="";
        for(StaticElement curInstance:dynamicDirections){
            names+=(curInstance.getName()+" ");
        }
        return  names;
    }
}
