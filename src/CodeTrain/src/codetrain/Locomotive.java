package codetrain;

public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;

    public StaticElement getCurrentElement(){}

    public StaticElement getPreviousElement(){}

    public void create(StaticElement current, StaticElement previous,RailroadCar carAfter){}

    public void setPrevious(StaticElement currentElement){}

    public void setCurrent(StaticElement nextElement){}
}
