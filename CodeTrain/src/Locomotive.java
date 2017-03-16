public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;

    public StaticElement getCurrentElement(){ return null;}

    public StaticElement getPreviousElement(){ return null;}

    public void create(StaticElement current, StaticElement previous ,RailroadCar carAfter){}

    public void setPrevious(StaticElement currentElement){}

    public void setCurrent(StaticElement nextElement){}

    public void move(){}

    public void crash(){}
}
