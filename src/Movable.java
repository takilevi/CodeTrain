/**
 * Interfész, azon osztályok valósítják meg, akik képesek valamilyen mozgásra.
 * Ezzel eggyüt járhat az ütközés is.
 */
public interface Movable {

    /**
     * Léptethetünk vele.
     * @param stepToElement Milyen elemre lépjünk tovább
     */
    void move(StaticElement stepToElement);

    /**
     * Ütközés detektálása
     */
    void crash();

    /**
     * Megpróbálhatnak rá felkapaszkodni utasok
     * @param color Az állomás színe, ahonnan az utasok jöttek
     * @param number Az utasok száma (igazából 1 v 0), az állomás szemponjából lényeges
     * @return
     */
    public boolean tryToGetOnPassenger(Color color, int number);

    /**
     * Leszállhatnak utasok róla
     * @param color Az állomás színe
     * @return
     */
    public boolean tryToPutDownPassengers(Color color);
}
