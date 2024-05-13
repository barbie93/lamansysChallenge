package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    protected static Properties properties;
    protected static final String fileFolder = "/src/main/resources/config.properties";
    protected static final String USER_DIR = "user.dir";
    protected static final String ERROR_MSG = "Not able to Find the File.";

    public PropertyReader(){
        loadAllProperties();
    }

    public void loadAllProperties() {
        properties = new Properties();
        try {
            String fileName = System.getProperty(USER_DIR) + fileFolder;
            properties.load(new FileInputStream(fileName));

        }
        catch (IOException e){
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public static String readItem(String propertyName){
        return properties.getProperty(propertyName);
    }
}
