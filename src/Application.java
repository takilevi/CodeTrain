import java.io.IOException;
import java.util.Scanner;

public class Application {

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


    public static void Test(String input) {
        switch (input) {
            case "0":
                System.exit(1);
                break;
            case "1":
                Train t = new Train();
                t.awakeLocomotive();
                break;
            case "2":

                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                RailroadSwitch rs = new RailroadSwitch();
                rs.changeSwitchToDirection(0);
                break;
            case "9":
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                Tunnel t1 = new Tunnel();
                t1.destroy(false);
                break;
            case "13":
                Tunnel t2 = new Tunnel();
                t2.destroy(true);
                break;
            case "14":
                Locomotive l1 = new Locomotive();
                l1.crash();
                break;
            default:
                System.exit(0);
        }
    }
}
