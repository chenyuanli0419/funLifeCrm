package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebElement find(By locator){
        try {
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            e.printStackTrace();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    public static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }

    public static By text(String content){
        return By.xpath("//*[@text='"+content+"']");}
    }


