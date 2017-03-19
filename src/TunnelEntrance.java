import java.util.List;

public class TunnelEntrance extends StaticElement {

    private StaticElement previousElement;
    private StaticElement nextElement;
    private StaticElement TunnelElement;
    private boolean isActive;

    public TunnelEntrance() {
    }

    public boolean getState() {
        Logger.CallLogging("TunnelEntrance", "getState()");
        Logger.ReturnLogging("TunnelEntrance", "getState(): true");
        return true;
    }

    public void changeState() {
        Logger.CallLogging("TunnelEntrance", "changeState(): StaticElement");
        Logger.ReturnLogging("TunnelEntrance", "changeState(): StaticElement");
    }

    public StaticElement getTunnelElement() {
        Logger.CallLogging("TunnelEntrance", "getTunnelElement()");
        getState();
        Logger.ReturnLogging("TunnelEntrance", "getTunnelElement(): StaticElement");
        return null;
    }

    public void setElements(StaticElement previous, StaticElement next) {
        previousElement = previous;
        nextElement = next;
    }

    public StaticElement getNextElement(StaticElement previousElement) {
        Logger.CallLogging("TunnelEntrance", "getNextElement()");
        Logger.ReturnLogging("TunnelEntrance", "getNextElement(): TunnelElement");

        return null;
    }

    public boolean isCrash() {
        return false;
    }

    public List<Movable> getTrainsOnElement() {
        Logger.CallLogging("TunnelEntrance", "getTrainsOnElement()");
        Logger.ReturnLogging("TunnelEntrance", "getTrainsOnElement()");
        return null;
    }

    public void leaveElement(Movable m) {
        Logger.CallLogging("TunnelEntrance", "leaveElement(Movable m)");
        Logger.ReturnLogging("TunnelEntrance", "leaveElement(Movable m)");
    }

    public void stepToElement(Movable m) {
        Logger.CallLogging("TunnelEntrance", "stepToElement(Movable m)");
        Logger.ReturnLogging("TunnelEntrance", "stepToElement(Movable m)");
    }
}
