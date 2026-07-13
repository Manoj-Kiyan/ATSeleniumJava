package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
    public static String getProperty(String key)  {
        FileInputStream fis =null;
        try {
             fis=new FileInputStream("./src/main/resources/common.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Properties properties =new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
         return properties.getProperty(key);


    }
}
