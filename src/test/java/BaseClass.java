import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static WebDriver driver;
    public static String browser ="Chrome";
    public static String url ="https://github.com/";
    public static String username ="whoankitsharma";
    public static String pass ="helloWorld@1001";
    public static String repo_name ="qa-assignment";



    public static void ChooseBrowser(){
        //Here we are selecting the web browser for automation.
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else if(browser.equals("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver =new EdgeDriver();
        }
    }
}
