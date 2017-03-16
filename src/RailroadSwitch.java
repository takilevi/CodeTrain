import java.util.List;

public class RailroadSwitch extends StaticElement {

    private int direction;
    private StaticElement staticDirection;
    private List<StaticElement> dynamicDirections;

    public RailroadSwitch()
    {
        Logger.CallLogging("RailroadSwitch", "RailroadSwitch()");
        Logger.ReturnLogging("RailroadSwitch", "RailroadSwitch()");
    }

    public void changeSwitchToDirection(int dir){}

    public StaticElement getCurrentSwitchInDirection(){ return null; }

    public StaticElement getStaticDirection(){return null;}

    public void setStaticDirection(StaticElement staticDir)
    {
        staticDirection = staticDir;
    }

    public void setDynamicDirections(List<StaticElement> directions)
    {
        dynamicDirections = directions;
    }
}
