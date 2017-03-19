public class Station extends StaticElement {
    private StaticElement previousElement;
    private StaticElement nextElement;

    public Station()
    {
    }

    public Color getColor(){ return null;}

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }
}
