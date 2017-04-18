/**
 * Mozdony kezelését megvalósító osztály.
 */
public class Locomotive implements Movable {

    private StaticElement currentElement;
    private StaticElement previousElement;
    private RailroadCar carAfterLocomotive;
    private String name;
    private Train train;

    public Locomotive(StaticElement current, StaticElement previous, String name, Train t) {
        currentElement = current;
        current.stepToElement(this);

        previousElement = previous;
        currentElement.stepToElement(this);
        this.name = name;
        train = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Visszatér azon elemmel, amin a vonat éppen tartózkodik.
     *
     * @return akutális elem
     */
    public StaticElement getCurrentElement() {
        return currentElement;
    }

    /**
     * Azon statikus elemmel tér vissza, amin a vonat előzőleg tartózkodott.
     *
     * @return előző elem
     */
    public StaticElement getPreviousElement() {
        return previousElement;
    }

    /**
     * A vonat előző helyét állíthatjuk be itt.
     *
     * @param previous Az elem amit be akarunk állítani
     */
    public void setPrevious(StaticElement previous) {
        previousElement = previous;
    }

    /**
     * A vonat aktuális helyét állítjuk be.
     *
     * @param current Erre az elemre szeretnénk elhelyezni a vonatot.
     */
    public void setCurrent(StaticElement current) {
        currentElement = current;
    }

    public void setCarAfter(RailroadCar car) {
        carAfterLocomotive = car;
    }

    /**
     * A vonatot léptetjük egyet. Beállítja a aktuális elemet, és az előzőt,
     * majd ha van utána kocsi meghívja rajta a move-ot.
     */
    public void move(StaticElement stepToElement) {

        StaticElement next = currentElement.getNextElement(previousElement);
        previousElement = currentElement;
        currentElement = next;

        previousElement.leaveElement(this);
        currentElement.stepToElement(this);

        if (carAfterLocomotive != null) {
            carAfterLocomotive.move(previousElement);
        }
    }

    /**
     * A vonaton meghívhatjuk, ekkor megkérdezik azon elemet, amin áll, hogy történt e ütközés.
     * (Konkrét pédánkban igen.)
     */
    public void crash() {
        ;
        if (currentElement.isCrash()) {
            train.getOfRails();
        } else {
            if (carAfterLocomotive != null) {
                carAfterLocomotive.crash();
            }
        }
    }

    public void listTrain() {
        System.out.println("Locomotive "+name + " " + currentElement.getName());
    }

    @Override
    public boolean tryToGetOnPassenger(Color color) {
        return false;
    }

    @Override
    public boolean tryToPutDownPassengers(Color color) {
        return false;
    }
}
