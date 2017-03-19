/**
 *
 */
public class Logger {

    private static int depth=0;

    /**
     *
     * @param className
     * @param methodName
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
     *
     * @param className
     * @param methodName
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
