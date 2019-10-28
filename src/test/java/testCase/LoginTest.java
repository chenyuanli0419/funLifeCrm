package testCase;


import driver.Driver;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.LoginPage;
import page.PersonalPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class LoginTest {
    static HomePage homePage;
    static PersonalPage personalPage;

    @BeforeEach
    void setUp(){
        homePage=HomePage.begin();
        personalPage=homePage.gotoPersonal();
    }

    @ParameterizedTest
    @CsvSource({
            "13500001111,aa123456,手机号码或密码错误",
            "13675514932,aa111111,登陆成功"})
    public void passwordLoginFailTest(String username,String psw,String Expect){
        LoginPage loginPage=personalPage.gotoLogin();
        String toast=loginPage.passwordLoginFail(username,psw).getToast();
        assertThat(toast,equalTo(Expect));

    }

    @Test
    public void passwordLoginSuccessTest(){
        LoginPage loginPage=personalPage.gotoLogin();
        String flag=loginPage.passwordLoginSuccess("13675514932","aa112233");
        System.out.println(flag);
        assertThat(flag,containsString("logined"));
    }

    @Test
    public void optLoginFailTest(){
        LoginPage loginPage=personalPage.gotoLogin();
        String toast=loginPage.OptloginFail("13500001111","123456").getToast();
        assertThat(toast,equalTo("短信验证码错误"));

    }

}
