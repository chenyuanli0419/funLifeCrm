package page;

import driver.Driver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static HomePage begin(){
        try {
            Driver.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        return new HomePage();
    }

    public PersonalPage gotoPersonal(){
        Driver.getCurrentDriver().findElement(By.xpath("//*[contains(@text,'我的')]")).click();
        return new PersonalPage();
    }

    public FunlivePage gotoFunlive(){
        Driver.getCurrentDriver().findElement(By.id("cl_homepage_banner_live")).click();
        return new FunlivePage();
    }
}
