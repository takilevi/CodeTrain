import java.util.List;

public class Tunnel {

    private List<TunnelEntrance> entrances;

    public void build(TunnelEntrance e1, TunnelEntrance e2){}

    public void destroy()
    {
        Logger.CallLogging("Tunnel", "destroy()");
        checkTrainInTunnel();
        Logger.ReturnLogging("Tunnel", "destroy()");
    }

    private boolean checkTrainInTunnel()
    {
        Logger.CallLogging("Tunnel", "destroy()");
        TunnelEntrance t1 = new TunnelEntrance();
        Track s1 = new Track();
        Track s2 = new Track();

        t1.getTunnelElement();
        s1.getTrainsOnElement();
        s1.getNextElement(t1);
        s2.getTrainsOnElement();

        Logger.ReturnLogging("Tunnel", "checkTrainInTunnel(): true");
        return true;
    }
}
