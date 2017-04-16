import java.util.ArrayList;
import java.util.List;

/**
 * Az alagutat megvalósító osztály
 */
public class Tunnel {

    private List<TunnelEntrance> entrances;

    /**
     * Alagút építése. Az alagút csak akkor jön létre ha pontosan kettő 'bejáratot' kapott
     * Ha többet kapna, azokat már elveti.
     *
     * @param e1 Alagút egy bejárata
     */
    public void build(TunnelEntrance e1) {

        if (entrances.size() > 2) {
            return;
        }
        if (entrances == null) {
            entrances = new ArrayList<TunnelEntrance>();
        }
        entrances.add(e1);

        if (entrances.size() == 2) {
            entrances.get(0).changeState();
            entrances.get(1).changeState();
        }
    }

    /**
     * Alagút lerombolása
     */
    public void destroy() {

        if (entrances.size() == 2 && !checkTrainInTunnel()) {
            entrances.get(0).changeState();
            entrances.get(1).changeState();
        }
    }

    /**
     * Megnézi hogy volt -e az alagútban vonat
     *
     * @return Visszaadja hogy volt-e benne.
     */
    private boolean checkTrainInTunnel() {
        return false;
    }
}
