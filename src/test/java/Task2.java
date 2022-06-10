import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;

public class Task2 extends BaseClass {

    public static void main(String[] args) {
        ChooseBrowser();

        //Accessing the URL
        driver.get(url);

//        Maximizing the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        We are in the welcome page and want to navigate to sign-in page. So we click on sign-in text.
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a"))
                .click();

//        Entering the username pass and click on the Login button.

        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.name("commit")).click();

        WebElement freshAcc=driver.findElement(By.xpath("//*[@id=\"repos-container\"]/div/a[1]"));

        freshAcc.click();

        WebElement repoName_Editbox =driver.findElement(By.id("repository_name"));
        repoName_Editbox.sendKeys(repo_name);

        WebElement public_radio =driver.findElement(By.id("repository_visibility_public"));
        if(!public_radio.isSelected()){
            public_radio.click();
        }

//      As it is dynamically changing its xpath, and we don't have some other unique attributes with it.
//      So instead of using relative xpath, we will use absolute xpath for easily get access to the particular elements.
        driver.findElement(By.xpath("/html/body/div[5]/main/div/form/div[5]/div[4]/div[2]/span/details")).click();


        WebElement el =driver.findElement(
                By.xpath("/html/body/div[5]/main/div/form/div[5]/div[4]/div[2]/span/details/details-menu/div/filter-input/input"));
        el.sendKeys("Node");
        el.sendKeys(Keys.ARROW_DOWN);
        el.sendKeys(Keys.ENTER);
        
        driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[5]/button")).click();

        String repo_created =driver.findElement(
                By.xpath("//*[@id=\"repository-container-header\"]/div[1]/div/div/strong/a")).getText();


        String fileUnderRepo =driver.findElement(
                By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div/div[3]/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/span/a")).getText();


        // Validating .gitignore
        if(fileUnderRepo.trim().equals(".gitignore")){
            System.out.println("gitIgnore file is present. Hence verified");
        }else {
            System.out.println("gitIgnore file is not not present. Invalid");
        }

        // Validating name of the repo
        if(repo_created.toLowerCase().trim().equals(repo_name)){
            System.out.println("Repository name is same. Hence verified");
        }else {
            System.out.println("Repository name is not same. Invalid");
        }

        //Closing All Windows
        driver.quit();
    }
}
