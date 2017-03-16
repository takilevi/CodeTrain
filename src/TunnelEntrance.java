public class TunnelEntrance extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private StaticElement TunnelElement;
    private boolean isActive;

    public TunnelEntrance()
    {
        Logger.CallLogging("TunnelEntrance", "TunnelEntrance()");
        Logger.ReturnLogging("TunnelEntrance", "TunnelEntrance()");
    }
    public boolean getState(){ return false;}

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }

}
