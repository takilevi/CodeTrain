import java.util.Scanner;

public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;

    public StaticElement getCurrentElement(){ return null;}

    public StaticElement getPreviousElement(){ return null;}

    public void create(StaticElement current, StaticElement previous ,RailroadCar carAfter){}

    public void setPrevious(StaticElement currentElement){
        Logger.CallLogging("Locomotive","setPrevious(StaticElement currentElement)");
        Logger.ReturnLogging("Locomotive","setPrevious(StaticElement currentElement)");
    }

    public void setCurrent(StaticElement nextElement){
        Logger.CallLogging("Locomotive","setCurrent(StaticElement nextElement)");
        Logger.ReturnLogging("Locomotive","setCurrent(StaticElement nextElement)");
    }

    public void move(int param){
        Logger.CallLogging("Locomotive","move()");
        switch (param){
            case 1:
                Track s2 = new Track();
                Track s3 = new Track();
                RailroadCar r = new RailroadCar();

                s3.getNextElement(s2);
                Track temp = new Track();

                setPrevious(s3);
                setCurrent(temp);

                s3.leaveElement(this);

                temp.stepToElement(this);

                r.move(param);
                break;
            case 2:
                Track s1 = new Track();
                RailroadSwitch rs1 = new RailroadSwitch();
                rs1.getNextElement(s1);
                StaticElement temp_switch = new StaticElement();
                setPrevious(rs1);
                setCurrent(temp_switch);

                rs1.leaveElement(this);
                temp_switch.stepToElement(this);

                break;
            case 3:
                StaticElement ste = new StaticElement();
                RailroadSwitch rs2 = new RailroadSwitch();
                System.out.print("\nNyomj 1-est ha jó felé áll a switch, 2-est ha nem: ");
                Scanner scanner = new Scanner(System.in);
                switch (scanner.nextInt()){
                    case 1:
                        rs2.getStaticDirection();
                        StaticElement temp_switch2 = new StaticElement();
                        setPrevious(rs2);
                        setCurrent(temp_switch2);

                        rs2.leaveElement(this);
                        temp_switch2.stepToElement(this);
                        break;
                    case 2:
                        RailroadModel.getInstance().finishGame();
                        break;
                    default:
                        System.exit(1);
                }
                break;
            case 4:
                TunnelEntrance te1 = new TunnelEntrance();
                StaticElement temp_tunnelentrance = new StaticElement();
                te1.getTunnelElement();
                setPrevious(te1);
                setCurrent(temp_tunnelentrance);

                te1.leaveElement(this);
                temp_tunnelentrance.stepToElement(this);

                break;
            case 6:
                TunnelEntrance te2 = new TunnelEntrance();
                Track tunneltrack = new Track();

                te2.getNextElement(tunneltrack);

                setPrevious(te2);
                setCurrent(tunneltrack);

                te2.leaveElement(this);
                tunneltrack.stepToElement(this);
                break;
            case 7:
                Track tr1_st = new Track();
                Station stat1 = new Station();
                Track tr2_st = new Track();
                RailroadCar station_car = new RailroadCar();

                stat1.getNextElement(tr1_st);
                setPrevious(stat1);
                setCurrent(tr2_st);

                stat1.leaveElement(this);
                tr2_st.stepToElement(this);

                station_car.move(2);


                break;

        }




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
