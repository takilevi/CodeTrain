import java.util.Scanner;

/**
 * Mozdony kezelését megvalósító osztály.
 */
public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;
    private String name;

    public Locomotive(StaticElement current, StaticElement previous, String name){
        currentElement = current;
        previousElement = previous;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Visszatér azon elemmel, amin a vonat éppen tartózkodik.
     * @return akutális elem
     */
    public StaticElement getCurrentElement(){
        return currentElement;
    }

    /**
     * Azon statikus elemmel tér vissza, amin a vonat előzőleg tartózkodott.
     * @return előző elem
     */
    public StaticElement getPreviousElement(){
        return previousElement;
    }



    /**
     * A vonat előző helyét állíthatjuk be itt.
     * @param previous Az elem amit be akarunk állítani
     */
    public void setPrevious(StaticElement previous){
       previousElement = previous;
    }

    /**
     * A vonat aktuális helyét állítjuk be.
     * @param current Erre az elemre szeretnénk elhelyezni a vonatot.
     */
    public void setCurrent(StaticElement current){
        currentElement = current;
    }

    public void setCarAfter(RailroadCar car){
        carAfterLocomotive = car;
    }

    /**
     * A vonatot léptetjük egyet. Beállítja a aktuális elemet, és az előzőt,
     * majd ha van utána kocsi meghívja rajta a move-ot.
     * @param param : Megadhatjuk hogy milyen elemre lépjen a mozdony.
     */
    public void move(int param){

    }

    /**
     * A vonaton meghívhatjuk, ekkor megkérdezik azon elemet, amin áll, hogy történt e ütközés.
     * (Konkrét pédánkban igen.)
     */
    public void crash(){;

    }

    public void listTrain(){
        System.out.println(name + " " + currentElement.getClass());
    }

}
