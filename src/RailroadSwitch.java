import java.util.List;

public class RailroadSwitch extends StaticElement {

    private int direction;
    private StaticElement staticDirection;
    private List<StaticElement> dynamicDirections;

    public RailroadSwitch()
    {
    }

    public void changeSwitchToDirection(int dir){
        Logger.CallLogging("RailroadSwitch","changeSwitchToDirection");

        Logger.ReturnLogging("RailroadSwitch","changeSwitchToDirection");
    }

    public StaticElement getCurrentSwitchInDirection(){
        Logger.CallLogging("RailroadSwitch", "getCurrentSwitchInDirection()");
        Logger.ReturnLogging("RailroadSwitch", "staticElement");
        return null;
    }

    public StaticElement getStaticDirection(){return null;}

    public void setStaticDirection(StaticElement staticDir)
    {
        staticDirection = staticDir;
    }

    public void setDynamicDirections(List<StaticElement> directions)
    {
        dynamicDirections = directions;
    }
    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("RailroadSwitch", "getNextElement()");
        getCurrentSwitchInDirection();
        Logger.ReturnLogging("RailroadSwitch", "nextElement");

        return null;
    }
    public boolean isCrash(){ return false;}
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("RailroadSwitch", "getTrainsOnElement()");
        Logger.ReturnLogging("RailroadSwitch", "getTrainsOnElement()");
        return null;

    }
    public void leaveElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "leaveElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "leaveElement(Movable m)");
    }
    public void stepToElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "stepToElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "stepToElement(Movable m)");
    }
}
