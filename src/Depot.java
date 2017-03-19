public class Depot extends StaticElement {

    public Depot()
    {
    }

    private StaticElement nextElement;

    public void setNextElement(StaticElement next)
    {
        nextElement = next;
    }

    public void releaseTrain(){}
}
