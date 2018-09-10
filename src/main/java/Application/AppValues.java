package Application;

public class AppValues {
    private static String path = new String("/home/integra");
//    private static String path = new String("c:/temp/");
    private static String logFormat = new String(".csv");

    public static String getPath() {
        return path;
    }

    public static String getLogFormat() {
        return logFormat;
    }
}
