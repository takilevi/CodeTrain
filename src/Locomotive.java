
public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;

    public StaticElement getCurrentElement(){ return null;}

    public StaticElement getPreviousElement(){ return null;}

    public void create(StaticElement current, StaticElement previous ,RailroadCar carAfter){}

    public void setPrevious(StaticElement currentElement){
        Logger.CallLogging("Locomotive","setPrevious(StaticElement currentElement)");
    }

    public void setCurrent(StaticElement nextElement){
        Logger.CallLogging("Locomotive","setCurrent(StaticElement nextElement)");
    }

    public void move(){
        Logger.CallLogging("Locomotive","move()");
        Track s2 = new Track();
        Track s3 = new Track();
        RailroadCar r = new RailroadCar();

        StaticElement temp = s3.getNextElement(s2);

        setPrevious(s3);
        setCurrent(temp);

        s3.leaveElement(this);

        temp.stepToElement(this);

        r.move();



        Logger.ReturnLogging("Locomotive","move()");
    }

    public void crash(){
        Logger.CallLogging("Locomotive", "crash()");
        Track s1 = new Track();
        s1.isCrash();
        RailroadModel.getInstance().finishGame();
        Logger.ReturnLogging("Locomotive", "crash(): exit");

    }
}
