public class Depot extends StaticElement {

    public Depot()
    {
        Logger.CallLogging("Depot", "Depot()");
        Logger.ReturnLogging("Depot", "Depot()");
    }

    private StaticElement nextElement;

    public void setNextElement(StaticElement next)
    {
        nextElement = next;
    }

    public void releaseTrain(){}
}
