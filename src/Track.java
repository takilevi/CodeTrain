public class Track extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;

    public Track()
    {
        Logger.CallLogging("Track", "Track()");
        Logger.ReturnLogging("Track", "Track()");
    }

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }
}
