package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppValues {
//    private static String path = new String(System.getProperty("user.home") + "/iFiles");
//    private static String logFormat = new String(".csv");
    static final Logger log = LoggerFactory.getLogger(AppValues.class);

//    public static String getPath() {
//        return path;
//    }
//
//    public static String getLogFormat() {
//        return logFormat;
//    }

    public static String getProperty(String property) {
        Properties properties = getCustomFileProperties();
        return properties.getProperty(property);
    }

    private static Properties getCustomFileProperties() {
        Properties toReturn = new Properties();
        try {
            InputStream input = new FileInputStream(System.getProperty("user.home") + "/iFiles/" + getCustomPropertiesFileName());
            toReturn.load(input);
        } catch (IOException e) {
            log.info("Custom Properties not found");
        }
        return toReturn;
    }

    /**
     * @return arquivo de configuração da applicação
     */
    public static String getCustomPropertiesFileName() {
        return "integra.properties";
    }
}
