package page;

import driver.Driver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PersonalPage extends BasePage{

    public LoginPage gotoLogin(){
        String locate=find(By.xpath("//*[contains(@resource-id,'login')]")).getAttribute("resourceId");
        if (locate.contains("logined")){
            find(By.id("cl_crm_mine_header")).click();
            Driver.getCurrentDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            find(By.id("tv_crm_user_info_logout")).click();
            find(By.id("tv_crm_user_info_logout_pop_confirm")).click();
            Driver.getCurrentDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            Driver.getCurrentDriver().findElement(By.id("tv_crm_mine_unlogin")).click();
        }else {
            Driver.getCurrentDriver().findElement(By.id("tv_crm_mine_unlogin")).click();
        }

        return new LoginPage();
    }

}
