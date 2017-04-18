import java.util.ArrayList;
import java.util.List;

/**
 * Az alagutat megvalósító osztály
 */
public class Tunnel {

    private List<TunnelEntrance> entrances;

    public Tunnel(){
        entrances = new ArrayList<>();
    }

    /**
     * Alagút építése. Az alagút csak akkor jön létre ha pontosan kettő 'bejáratot' kapott
     * Ha többet kapna, azokat már elveti.
     * @param e1 Alagút egy bejárata
     */
    public void build(TunnelEntrance e1) {

        if(entrances.size()>2){
            return;
        }
        if(entrances == null){
            entrances = new ArrayList<TunnelEntrance>();
        }
        entrances.add(e1);

        //Ennél nem kell megnézni hogy van e az alagútban vonat, mert nincs alagút. (trivi)
        if(entrances.size() == 2 ){
            entrances.get(0).changeState();
            entrances.get(1).changeState();
        }

    }
    public List<TunnelEntrance> getEntrances(){
        return entrances;
    }

    /**
     * Alagút lerombolása
     */
    public boolean destroy() {

        if(entrances.size() == 2 && !checkTrainInTunnel()){
            entrances.get(0).changeState();
            entrances.get(1).changeState();
            return true;

        }
        else{
            return false;
        }

    }

    /**
     * Megnézi hogy volt e az alagútban vonat
     * @return Visszaadja hogy volt-e benne.
     */
    private boolean checkTrainInTunnel() {
        boolean trainInTunnel = false;
        if(!entrances.isEmpty()){
            StaticElement next = entrances.get(0);
            StaticElement prev = entrances.get(0).getPrevForLoco();
            while(!trainInTunnel){
                if(next.getTrainsOnElement() != null && next.getTrainsOnElement().size()>0){
                    trainInTunnel = true;
                }
                else if(next == entrances.get(1) && next.getTrainsOnElement().size()>0){
                    return false;
                }
                else if(next == entrances.get(1) && next.getTrainsOnElement().size()==0){
                    return false;
                }
                StaticElement tmp = next;
                next = tmp.getNextElement(prev);
                prev = tmp;
            }
            return true;
        }
        else
            return false;
    }
}
