import java.io.IOException;
import java.util.Scanner;

/**
 * Az alkalmazás tartalmazza a main függvényt, innen indul a program,
 * illetve a vezérlést is ez az osztály végzi.
 */
public class Application {

    /**
     * Az alkalmazás belépési pontja.
     * Kiírja a standard inputra a menüpontokat,
     * madj bekéri a felhasználó által választott menüpont sorszámát, és meghívja vele a Teszt függvényt.
     */
    public static void main(String[] args) {
        System.out.println("0. Kilépés");
        System.out.println("1. Vonat (mozdony+kocsi) sínen lép");
        System.out.println("2. Vonat váltón lép előre");
        System.out.println("3. Vonat váltón lép vissza");
        System.out.println("4. Vonat alagútba bemegy");
        System.out.println("5. Vonat alagútban lép");
        System.out.println("6. Vonat alagútból kijön");
        System.out.println("7. Vonat állomáshoz ér, utasok nem szállnak le/leszállnak (+ a játékos nyer)");
        System.out.println("8. Váltó állítása, ha nincs rajta vonat");
        System.out.println("9. Váltó állítása, ha van rajta vonat");
        System.out.println("10. Első alagútbejárat megépítése");
        System.out.println("11. Második alagútbejárat megépítése, alagút jön létre");
        System.out.println("12. Alagútbejárat lerombolása, ha nincs az alagútban vonat");
        System.out.println("13. Alagútbejárat lerombolása, ha van az alagútban vonat");
        System.out.println("14. Két vonat ütközik, a játékos veszít");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nAdja meg a menüpont számát: ");
            Test(scanner.nextLine());
        }
    }

    /**
     * A main függvény hívja, a kapott paraméter alapján elindítja a megfelelő függvényhívásokat.
     * @param input : A felhasználó által választott menüpont sorszáma
     */
    public static void Test(String input) {
        switch (input) {
            case "0":
                System.exit(1);
                break;
            case "1":
                Train tr = new Train();
                tr.awakeLocomotive(1);
                break;
            case "2":
                Train tr2 = new Train();
                tr2.awakeLocomotive(2);
                break;
            case "3":
                Train tr3 = new Train();
                tr3.awakeLocomotive(3);
                break;
            case "4":
                Train tr4 = new Train();
                tr4.awakeLocomotive(4);
                break;
            case "5": // nincs 5-ös mert az nálunk ugyanaz mint a sima lépés a síneken -> 1esre átirányítás
                Train tr5 = new Train();
                tr5.awakeLocomotive(1);
                break;
            case "6":
                Train tr6 = new Train();
                tr6.awakeLocomotive(6);
                break;
            case "7":
                Train tr7 = new Train();
                tr7.awakeLocomotive(7);
                break;
            case "8":
                RailroadSwitch rs1 = new RailroadSwitch();
                rs1.changeSwitchToDirection(1);
                break;
            case "9":
                RailroadSwitch rs2 = new RailroadSwitch();
                rs2.changeSwitchToDirection(2);
                break;
            case "10":
                Tunnel t = new Tunnel();
                TunnelEntrance e1 = new TunnelEntrance();
                t.build(e1);
                break;
            case "11":
                Tunnel t1 = new Tunnel();
                t1.destroy(false);
                break;
            case "12":
                Tunnel t2 = new Tunnel();
                t2.destroy(true);
                break;
            case "13":
                Locomotive l1 = new Locomotive();
                l1.crash();
                break;
            default:
                System.exit(0);
        }
    }
}
