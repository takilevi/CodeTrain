import java.util.List;
import java.util.Scanner;

public class Station extends StaticElement {
    private StaticElement previousElement;
    private StaticElement nextElement;

    public Station()
    {
    }

    public Color getColor(){
        Logger.CallLogging("Station", "getColor()");
        Logger.ReturnLogging("Station", "getColor(): Blue");
        return Color.Blue;}

    public void setElements(StaticElement previous, StaticElement next)
    {
        previousElement= previous;
        nextElement = next;
    }
    public StaticElement getNextElement(StaticElement previousElement)
    {
        Logger.CallLogging("Station", "getNextElement()");
        Logger.ReturnLogging("Station", "getNextElement(): nextElement");

        return null;
    }
    public boolean isCrash(){ return false;}
    public List<Movable> getTrainsOnElement()
    {
        Logger.CallLogging("Station", "getTrainsOnElement()");
        Logger.ReturnLogging("Station", "getTrainsOnElement() : List<Movable>");
        return null;

    }
    public void leaveElement(Movable m){
        Logger.CallLogging("Station", "leaveElement(Movable m)");
        Logger.ReturnLogging("Station", "leaveElement(Movable m)");
    }
    public void stepToElement(Movable m){
        Logger.CallLogging("Station", "stepToElement(Movable m)");

        Logger.ReturnLogging("Station", "stepToElement(Movable m)");
    }
    public void checkStation(RailroadCar r){
        Logger.CallLogging("Station", "checkStation(RailroadCar r)");
        System.out.print("\nNyomj 1-est ha le akarsz rakni utast, 2-est ha nem: ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                r.getOffPassengers(getColor());
                break;
            case 2:
                break;
        }
        Logger.ReturnLogging("Station", "checkStation(RailroadCar r)");
    }
}
