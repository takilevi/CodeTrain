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
}



