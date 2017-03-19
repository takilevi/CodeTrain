public class RailroadCar implements Movable {

    private boolean passengersOnBoard;
    private StaticElement currentElement;
    private RailroadCar carAfterCar;
    private Color color;

    public void create(Color c, StaticElement current, RailroadCar carAfter) {
    }

    public StaticElement getCurrentElement() {
        return null;
    }

    public void getOffPassengers() {
    }

    public void setPrevious(StaticElement currentElement) {
        Logger.CallLogging("RailroadCar","setPrevious(StaticElement currentElement)");
        Logger.ReturnLogging("RailroadCar","setPrevious(StaticElement currentElement)");
    }

    public void setCurrent(StaticElement nextElement) {
        Logger.CallLogging("RailroadCar","setCurrent(StaticElement currentElement)");
        Logger.ReturnLogging("RailroadCar","setCurrent(StaticElement currentElement)");
    }

    public void move(int param) {
        Logger.CallLogging("RailroadCar", "move()");

        switch (param){
            case 1:
                Track s1 = new Track();
                Track s2 = new Track();
                RailroadCar r = new RailroadCar();

                s2.getNextElement(s1);
                Track temp = new Track();
                setPrevious(s2);
                setCurrent(temp);

                s2.leaveElement(this);

                temp.stepToElement(this);
                break;
            case 2:

                break;
        }


        Logger.CallLogging("RailroadCar", "move()");
    }

    public void crash() {
    }
}
