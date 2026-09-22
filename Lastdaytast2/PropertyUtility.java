package LastAssessmentTask2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public static String getData(String key) throws IOException {
        FileInputStream file=new FileInputStream("src/main/java/LastAssessmentTask2/commonData.properties");
        Properties properties=new Properties();
        properties.load(file);
        String data=properties.getProperty(key);
        return data;
    }
}