/**
 * A szekvencia diagramok kirajzolását vegző osztály.
 */
public class Logger {

    private static int depth=0;

    /**
     * Függényhívásokkor hívódik, ilyenkor mindig egy tab-al alrébb kerül a következő függvény neve.
     * @param className Osztály neve, ami meghívta.
     * @param methodName Függvény neve, ami meghívta.
     */
    public static void CallLogging(String className, String methodName)
    {
        for(int i=0;i<depth;i++)
        {
            System.out.print("\t");
        }
        System.out.println(String.format("=>[:%s].%s",className, methodName));
        depth++;
    }

    /**
     * Visszalépünk a függvényhívásokból. (== return)
     * @param className Osztály nevem ami meghívta.
     * @param methodName Függvény neve, ami meghívta.
     */
    public static void ReturnLogging(String className, String methodName)
    {
        depth--;
        for(int i=0;i<depth;i++)
        {
            System.out.print("\t");
        }
        System.out.println(String.format("<=[:%s].%s",className, methodName));
    }

}
