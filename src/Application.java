import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("0. Kilépés");
        System.out.println("1. Pálya felépítése");
        System.out.println("2. Alagút bejárat építése");
        System.out.println("3. Alagút kijárat építése");
        System.out.println("4. Alagút lerombolása");
        System.out.println("5. Vonat léptetése");
        System.out.println("6. Váltó állítása");
        System.out.println("7. Vonat létrehozása");
        System.out.println("8. Utasok leszállítása");
        System.out.println("9. Vonatok ütközése");
        System.out.println("10. Következő elem lekérése");

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.print("\nAdja meg a menüpont számát: ");
            Test(scanner.nextLine());
        }
    }


    public static void Test(String input)
    {
        switch (input)
        {
            case "0": System.exit(1);
                break;
            case "1": RailroadModel.getInstance().initFiledElements();
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
                break;
            case "9":
                break;
            case "10":
                break;
            default:System.exit(0);
        }
    }
}
