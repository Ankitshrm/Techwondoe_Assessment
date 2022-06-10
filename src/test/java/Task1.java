import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Task1 extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        ChooseBrowser();

        //Accessing the URL
        driver.get(url);

        //Maximizing the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        //We are in the welcome page and want to navigate to sign-in page. So we click on sign-in text.
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a"))
                .click();

        //Entering the username pass and click on the Login button.
        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.name("commit")).click();

        //Clicking on the myProfile icon present at the top-right of the window.
        driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary/img")).click();

        //Retrieving the username that we logged in.
        String loggedUsername =driver.findElement(
                By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a/strong"))
                .getText();

        //Verifying the username and text displayed is same or not.
        if(username.toLowerCase().equals(loggedUsername)){
            System.out.println("Username name is same. Hence verified");
        }else{
            System.out.println("Username name is not same. Hence failed");
        }

        //Closing all windows
        driver.quit();
        
    }
}
