public class RailroadCar implements Movable {

    private boolean passengersOnBoard;
    private StaticElement currentElement;
    private RailroadCar carAfterCar;
    private Color color;

    public void create(Color c, StaticElement current, RailroadCar carAfter){}

    public StaticElement getCurrentElement(){ return null;}

    public void getOffPassengers(){}

    public void setPrevious(StaticElement currentElement){}

    public void setCurrent(StaticElement nextElement){}

    public void move(){
        Logger.CallLogging("RailroadCar","move()");

        Track s1 = new Track();
        Track s2 = new Track();
        RailroadCar r = new RailroadCar();

        StaticElement temp = s2.getNextElement(s1);

        setPrevious(s2);
        setCurrent(temp);

        s2.leaveElement(this);

        temp.stepToElement(this);

        Logger.CallLogging("RailroadCar","move()");
    }

    public void crash(){}
}
