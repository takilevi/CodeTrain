import java.util.List;

/**
 * Az alagutat megvalósító osztály
 */
public class Tunnel {

    private List<TunnelEntrance> entrances;

    /**
     * Alagút építése. Az alagút csak akkor jön létre ha pontosan kettő 'bejáratot' kapott
     * Ha többet kapna, azokat már elveti.
     * @param e1 Alagút egy bejárata
     */
    public void build(TunnelEntrance e1) {

        Logger.CallLogging("Tunnel", "build(TunnelEntrance e1)");
        Logger.CallLogging("TunnelEntrance","add(e1)");
        Logger.ReturnLogging("TunnelEntrance","add(e2)");
        Logger.CallLogging("TunnelEntrance","add(e2)");
        e1.changeState();
    }

    /**
     * Alagút lerombolása
     * @param containsTrain volt-e az alagútban vonat.
     */
    public void destroy(boolean containsTrain) {
        Logger.CallLogging("Tunnel", "destroy()");
        checkTrainInTunnel(containsTrain);
        Logger.ReturnLogging("Tunnel", "destroy()");
    }

    /**
     * Megnézi hogy volt e az alagútban vonat
     * @param containsTrain Volt-e benne vonat.(A felhasználó dönti el.)
     * @return Visszaadja hogy volt-e benne.
     */
    private boolean checkTrainInTunnel(boolean containsTrain) {
        Logger.CallLogging("Tunnel", "checkTrainInTunnel()");
        TunnelEntrance t1 = new TunnelEntrance();
        Track s1 = new Track();
        Track s2 = new Track();

        t1.getTunnelElement();
        s1.getTrainsOnElement();
        s1.getNextElement(t1);
        s2.getTrainsOnElement();

        if (!containsTrain) {
            Track s3 = new Track();
            s2.getNextElement(s1);
            s3.getTrainsOnElement();
            s3.getNextElement(s2);
        }
        if (containsTrain) {
            Logger.ReturnLogging("Tunnel", "checkTrainInTunnel(): true");
        } else {
            Logger.ReturnLogging("Tunnel", "checkTrainInTunnel(): false");
            TunnelEntrance t0 = new TunnelEntrance();
            t0.changeState();
        }

        return true;
    }
}
