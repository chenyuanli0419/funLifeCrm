package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{
    //String message;
    private By phonelocate=By.id("et_crm_login_with_auth_phone_number");
    private By optLocate=By.id("et_crm_login_with_auth_auth_code");
    private By passwordNum=By.id("et_crm_login_with_password_pwd");
    private By login=By.id("btn_crm_login_login");
    private By sendOpt=By.id("tv_crm_login_auth_login_get_auth_code");
    private By sign=By.xpath("//*[contains(@text,'新用户注册')]");
    private By optLogin=By.xpath("//*[contains(@text,'短信验证码登录')");
    private By passwordLogin=By.xpath("//*[contains((@text,'账号密码登录') or (@text,'账号登录'))");
    private By changeWay=By.id("tv_crm_login_change_login_ways");

    public String getToast(){
        return Driver.getCurrentDriver().findElementByXPath("//*[@class='android.widget.Toast']").getText();
    }

    public LoginPage passwordLoginFail(String username, String password){
        System.out.println("--kaishi--");
        Driver.getCurrentDriver().findElement(changeWay).click();
        System.out.println("--over--");
        find(By.id("et_crm_login_with_password_phone_number")).sendKeys(username);
        find(By.id("et_crm_login_with_password_pwd")).sendKeys(password);
        find(login).click();
        return this;
    }
    public String passwordLoginSuccess(String username, String password){
        find(changeWay).click();
        find(By.id("et_crm_login_with_password_phone_number")).sendKeys(username);
        find(By.id("et_crm_login_with_password_pwd")).sendKeys(password);
        find(login).click();
        Driver.getCurrentDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String element=find(By.xpath("//*[contains(@resource-id,'logined')]")).getAttribute("resourceId");
        return element;
    }

    public LoginPage OptloginFail(String username, String optNum){
        Driver.getCurrentDriver().findElement(phonelocate).sendKeys(username);
        Driver.getCurrentDriver().findElement(optLocate).sendKeys(optNum);
        Driver.getCurrentDriver().findElement(login).click();
        return this;
    }
}
