/**
 * Interfész, azon osztályok valósítják meg, akik képesek valamilyen mozgára.
 * Ezzel eggyüt járhat az ütközés is.
 */
public interface Movable {

    /**
     * Léptethetünk vele.
     * @param param Milyen elemre lépjünk tovább
     */
    void move(int param);

    /**
     * Ütközés detektálása
     */
    void crash();
}
