import java.util.List;

public class StaticElement {

    protected int trainsOnElement;

    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("StaticElement", "getNextElement()");
        Logger.ReturnLogging("StaticElement", "nextElement");

        return null;
    }
    public boolean isCrash(){ return false;}
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("StaticElement", "getTrainsOnElement()");
        Logger.ReturnLogging("StaticElement", "getTrainsOnElement()");
        return null;

    }
    public void leaveElement(Movable m){
        Logger.CallLogging("StaticElement", "leaveElement(Movable m)");
        Logger.ReturnLogging("StaticElement", "leaveElement(Movable m)");
    }
    public void stepToElement(Movable m){
        Logger.CallLogging("StaticElement", "stepToElement(Movable m)");
        Logger.ReturnLogging("StaticElement", "stepToElement(Movable m)");
    }


}
