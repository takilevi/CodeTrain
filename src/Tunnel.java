import java.util.List;

public class Tunnel {

    private List<TunnelEntrance> entrances;

    public void build(TunnelEntrance e1, TunnelEntrance e2){}

    public void destroy(boolean containsTrain)
    {
        Logger.CallLogging("Tunnel", "destroy()");
        checkTrainInTunnel(containsTrain);
        Logger.ReturnLogging("Tunnel", "destroy()");
    }

    private boolean checkTrainInTunnel(boolean containsTrain)
    {
        Logger.CallLogging("Tunnel", "destroy()");
        TunnelEntrance t1 = new TunnelEntrance();
        Track s1 = new Track();
        Track s2 = new Track();

        t1.getTunnelElement();
        s1.getTrainsOnElement();
        s1.getNextElement(t1);
        s2.getTrainsOnElement();

        if(!containsTrain)
        {
            Track s3 = new Track();
            s2.getNextElement(s1);
            s3.getTrainsOnElement();
            s3.getNextElement(s2);
        }
        if(containsTrain)
        {
            Logger.ReturnLogging("Tunnel", "checkTrainInTunnel(): true");
        }
        else{
            Logger.ReturnLogging("Tunnel", "checkTrainInTunnel(): false");
            TunnelEntrance t0 = new TunnelEntrance();
            t0.changeState();
        }

        return true;
    }
}
