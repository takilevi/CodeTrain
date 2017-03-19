import java.util.List;

/**
 *
 */
public class RailroadSwitch extends StaticElement {

    private int direction;
    private StaticElement staticDirection;
    private List<StaticElement> dynamicDirections;

    public RailroadSwitch()
    {
    }

    /**
     *
     * @param dir
     */
    public void changeSwitchToDirection(int dir){

        switch (dir){
            case 1:
                Logger.CallLogging("RailroadSwitch","changeSwitchToDirection(int i)");
                trainsOnElement =0;
                setDirection(1);

                if(trainsOnElement == 0){
                    Logger.ReturnLogging("RailroadSwitch","setDirection(in i)");
                }
                Logger.ReturnLogging("RailroadSwitch","changeSwitchToDirection(int i)");
                break;
            case 2:
                Logger.CallLogging("RailroadSwitch","changeSwitchToDirection()");
                Logger.ReturnLogging("RailroadSwitch","changeSwitchToDirection");
        }
    }

    /**
     *
     * @return
     */
    public StaticElement getCurrentSwitchInDirection(){
        Logger.CallLogging("RailroadSwitch", "getCurrentSwitchInDirection()");
        Logger.ReturnLogging("RailroadSwitch", "staticElement");
        return null;
    }

    /**
     *
     * @return
     */
    public StaticElement getStaticDirection(){
        Logger.CallLogging("RailroadSwitch", "getStaticDirection()");
        Logger.ReturnLogging("RailroadSwitch", "staticElement");
        return null;}

    /**
     *
     * @param staticDir
     */
    public void setStaticDirection(StaticElement staticDir)
    {
        staticDirection = staticDir;
    }

    /**
     *
     * @param i
     */
    public void setDirection(int i){
        Logger.CallLogging("RailroadSwitch","SetDirection(int i)");
    }

    /**
     *
     * @param previousElement
     * @return
     */
    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("RailroadSwitch", "getNextElement()");
        getCurrentSwitchInDirection();
        Logger.ReturnLogging("RailroadSwitch", "nextElement");

        return null;
    }
    public boolean isCrash(){ return false;}

    /**
     *
     * @return
     */
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("RailroadSwitch", "getTrainsOnElement()");
        Logger.ReturnLogging("RailroadSwitch", "getTrainsOnElement()");
        return null;
    }

    /**
     *
     * @param m
     */
    public void leaveElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "leaveElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "leaveElement(Movable m)");
    }

    /**
     *
     * @param m
     */
    public void stepToElement(Movable m){
        Logger.CallLogging("RailroadSwitch", "stepToElement(Movable m)");
        Logger.ReturnLogging("RailroadSwitch", "stepToElement(Movable m)");
    }

    public void setDynamicDirections(List<StaticElement> directions)
    {
        dynamicDirections = directions;
    }
}
