package Game;

import Graphics.TunnelEntranceGraphics;

import java.util.List;

/**
 * Alagút bejáratát, (illetve kijáratát) megvalósító osztály.
 */
public class TunnelEntrance extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private StaticElement tunnelElement;
    private boolean isActive;

    /**
     * Alagút bejárat konstruktora.
     */
    public TunnelEntrance(String name) {
        super(name);
        isActive=false;
    }

    @Override
    public void setGraphics(String type, int x, int y) {
        graphics = new TunnelEntranceGraphics(type, x, y);
    }

    /**
     * Visszaadja hogy aktiválták -e az alagutat.
     * @return Az alagút állapota. Igaz ha aktív az alagút.
     */
    public boolean getState(){
        return isActive;
    }

    /**
     * Megváltoztatja az alagút bejárat állapotát.
     */
    public void changeState() {

        if(isActive){
            isActive = false;
        }
        else{
            isActive = true;
        }
    }

    /**
     * Megnézi hogy aktív -e az alagút, és a megfelelő elemet adja vissza.
     * @return Egy statikus elem, annak megfelelően, hogy aktív volt -e az alagút.
     */
    public StaticElement getTunnelElement()
    {
        return tunnelElement;
    }

    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        if(this.previousElement == previousElement && isActive){
            return tunnelElement;
        }
        else if(this.previousElement == previousElement && !isActive){
            return nextElement;
        }
        else{
            return previousElement;
        }
    }

    @Override
    public StaticElement getPrevForLoco() {
        return previousElement;
    }

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
     * @param m Aki rálpett az elemre.
     */
    public void stepToElement(Movable m){

        if(!trainsOnElement.contains(m)){
            trainsOnElement.add(m);
        }
    }

    @Override
    public void setNextElement(StaticElement nextElement) {
        this.nextElement=nextElement;
    }

    @Override
    public void setPreviousElement(StaticElement previousElement) {
        this.previousElement=previousElement;
    }

    @Override
    public void setDynamicDirection(StaticElement one_dir) {

    }

    @Override
    public void setStaticDirection(StaticElement staticDir) {

    }

    @Override
    public void setTunnelElement(StaticElement tunnelElement) {
        this.tunnelElement=tunnelElement;
    }
}
