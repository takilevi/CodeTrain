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
}
