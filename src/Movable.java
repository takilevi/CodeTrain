/**
 * Interfész, azon osztályok valósítják meg, akik képesek valamilyen mozgásra.
 * Ezzel eggyüt járhat az ütközés is.
 */
public interface Movable {

    /**
     * Léptethetünk vele.
     * @param param Milyen elemre lépjünk tovább
     */
    void move();

    /**
     * Ütközés detektálása
     */
    void crash();
}
