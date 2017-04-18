import java.util.List;

/**
 * Az állomást valósítja meg az osztály.
 */
public class Station extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private int getOnPassengers;
    Color color;

    /**
     * Az állomás konstruktora.
     */
    public Station(int getOnPassengers, Color color,String name) {
        super(name);
        this.getOnPassengers=getOnPassengers;
        this.color = color;
    }

    public void setGetOnPassengers(int passengers){getOnPassengers=passengers;}
    public void setColor(Color color){this.color=color;}
    /**
     * Az állomás színének a getter-e.
     * @return Az állomás színe.
     */
    public Color getColor(){

        return color;
    }
    public  int getGetOnPassengers(){return getOnPassengers;}

    /**
     * Azon statikus szomszédját adja vissza, ami nem egyenlő azzal ahonan oda léptünk.
     * @param previousElement Ahonan ide léptünk, nem ezt adja vissza.
     * @return A következő elem a megfelelő irányba.
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        if(this.previousElement == previousElement){
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
     * Ráléptünk az elemre. (Bekerül a listába az objektum)
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

    }

    public boolean isPassengersWaiting(){

        if(getOnPassengers>0){
            return true;
        }
        else{
            return false;
        }
    }
}
