package configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigPropReader {

    private static Properties properties;
    private static FileInputStream fileInputStream;


    public static Properties initLangProp(String lang)  {
            System.out.println("Langauge is " + lang);
            properties = new Properties() ;
            try {

                switch (lang.toLowerCase()) {
                    case "english":
                        fileInputStream = new FileInputStream("F:\\Project\\MultiLocalLangauage\\src\\main\\resources\\lang.eng.Properties");
                        break;
                    case "french":
                        fileInputStream = new FileInputStream("F:\\Project\\MultiLocalLangauage\\src\\main\\resources\\lang.french.Properties");
                        break;
                    case "russia":
                        fileInputStream = new FileInputStream("F:\\Project\\MultiLocalLangauage\\src\\main\\resources\\lang.russia.Properties");
                        break;

                    default:
                        System.out.println("No language has been listed in the Web Page" + lang);
                        break;
                }
                properties.load(fileInputStream);
            }

            catch (Exception e){
                System.out.println(e.getStackTrace());
            }

            return properties;
        }
}
