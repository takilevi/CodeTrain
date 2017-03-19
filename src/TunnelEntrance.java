public class TunnelEntrance extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private StaticElement TunnelElement;
    private boolean isActive;

    public TunnelEntrance()
    {
    }
    public boolean getState(){ return false;}

    public void changeState()
    {
        Logger.CallLogging("TunnelEntrance", "changeState()");
        Logger.ReturnLogging("TunnelEntrance", "changeState(): StaticElement");

    }

    public StaticElement getTunnelElement()
    {
        Logger.CallLogging("TunnelEntrance", "getTunnelElement()");
        Logger.ReturnLogging("TunnelEntrance", "getTunnelElement(): StaticElement");
        return null;
    }

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }

}
