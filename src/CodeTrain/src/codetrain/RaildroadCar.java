package codetrain;

/**
 * Created by ernoh on 2017. 03. 08..
 */
public class RaildroadCar implements Movable {

    private boolean passengersOnBoard;
    private StaticElement currentElement;
    private RaildroadCar carAfterCar;
    private Color color;

    public void create(Color c,StaticElement current,RaildroadCar carAfter){}

    public StaticElement getCurrentElement(){}

    public void getOffPassengers(){}

    public void setPreviousElement(StaticElement currentElement){}

    public void setCurrent(StaticElement nextElement){}
}
