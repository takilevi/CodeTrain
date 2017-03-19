import java.util.List;

public class Track extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;

    public Track()
    {
    }

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }

    public boolean isCrash()
    {
        Logger.CallLogging("Track", "isCrash()");
        Logger.ReturnLogging("Track", "isCrash(): true");
        return true;
    }

    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("Track", "getNextElement()");
        Logger.ReturnLogging("Track", "nextElement");

        return null;
    }
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("Track", "getTrainsOnElement()");
        Logger.ReturnLogging("Track", "getTrainsOnElement()");
        return null;

    }
    public void leaveElement(Movable m){
        Logger.CallLogging("Track", "leaveElement(Movable m)");
        Logger.ReturnLogging("Track", "leaveElement(Movable m)");
    }
    public void stepToElement(Movable m){
        Logger.CallLogging("Track", "stepToElement(Movable m)");
        Logger.ReturnLogging("Track", "stepToElement(Movable m)");
    }
}



