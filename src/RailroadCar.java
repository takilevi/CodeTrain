import java.util.Scanner;

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

    public void getOffPassengers(Color color) {
        Logger.CallLogging("RailroadCar","getOffPassengers(Color color)");
        Train vonat = new Train();
        vonat.emptyCar();
        Logger.ReturnLogging("RailroadCar","getOffPassengers(Color color)");
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
                Track tr1_st = new Track();
                Station stat1 = new Station();
                StaticElement previous = new StaticElement();

                tr1_st.getNextElement(previous);
                setPrevious(tr1_st);
                setCurrent(stat1);

                tr1_st.leaveElement(this);
                stat1.stepToElement(this);
                stat1.checkStation(this);


                break;
        }


        Logger.ReturnLogging("RailroadCar", "move()");
    }

    public void crash() {
    }
}
