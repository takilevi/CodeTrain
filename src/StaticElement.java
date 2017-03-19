import java.util.List;

public class StaticElement {

    protected int trainsOnElement;

    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("StaticElement", "getNextElement()");
        Logger.ReturnLogging("StaticElement", "getNextElement()");

        return null;
    }
    public boolean isCrash(){ return false;}
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("StaticElement", "getTrainsOnElement()");
        Logger.ReturnLogging("StaticElement", "getTrainsOnElement()");
        return null;

    }


}
