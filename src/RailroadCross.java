import java.util.List;

/**
 * Created by Andy on 2017. 04. 11..
 */
public class RailroadCross extends StaticElement {

    private StaticElement firstEntrance;
    private StaticElement firstExit;
    private StaticElement secondEntrance;
    private StaticElement secondExit;

    public RailroadCross(){

    }

    @Override
    public StaticElement getNextElement(StaticElement previousElement) {

        if(previousElement == firstEntrance){
            return firstExit;
        }
        else if(previousElement == firstExit){
            return firstEntrance;
        }
        else if(previousElement == secondEntrance){
            return secondExit;
        }
        else if(previousElement == secondExit){
            return secondEntrance;
        }
        else{
            return null;
        }

    }


    public void setFirstDirections(StaticElement entrance, StaticElement exit){

        firstEntrance = entrance;
        firstExit = exit;

    }

    public void setSecondDirections(StaticElement entrance, StaticElement exit){

        secondEntrance = entrance;
        secondExit = exit;

    }

    public boolean isCrash(){ return false;}

    /**
     * Visszaadja az elemen elhelyezkedő mozgó objektumokat.
     * @return Ezen objektumok listálya.
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


}
