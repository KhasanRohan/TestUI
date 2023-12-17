package HackMeBank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage extends BaseTest {
    private final SelenideElement inputUserName = $x("//input[@id='userName']");
    private final SelenideElement inputEmail = $x("//input[@id='email']");
    private final SelenideElement inputPhone = $x("//input[@id='phoneNumber']");
    private final SelenideElement inputPassword = $x("//input[@id='password']");
    private final SelenideElement inputPasswordValidation = $x("//input[@id='passwordValidation']");
    private final SelenideElement button = $x("//button[@id='submitLogin']");
    private final SelenideElement errText1 = $x("//*[@id='inputForAuth']/div[1]/div[1]/div[2]");
    private final SelenideElement errText2 = $x("//*[@id='inputForAuth']/div[2]/div[2]/div[2]");
    private final SelenideElement modalAuth = $x("//*[@id='loginModalAuth']/div/h1");


    public AuthorizationPage(String url){
        Selenide.open(url);
    }

    public SuccessRegPage LogIn(String login, String email, String phone, String pass, String reppass){
        inputUserName.sendKeys(login);
        inputEmail.sendKeys(email);
        inputPhone.setValue(phone);
        inputPassword.setValue(pass);
        inputPasswordValidation.setValue(reppass);
        button.click();
        modalAuth.shouldHave(text("Код проверки"));
        return new SuccessRegPage();
    }
    public UnSuccessRegPage InvalidUserName(String login, String email, String phone, String pass, String reppass){
        inputUserName.sendKeys(login);
        inputEmail.sendKeys(email);
        inputPhone.setValue(phone);
        inputPassword.setValue(pass);
        inputPasswordValidation.setValue(reppass);
        button.click();
        errText1.shouldHave(text("Имя может содержать только буквы английского и русского "));
        return new UnSuccessRegPage();
    }
    public UnSuccessRegPage InvalidPass(String login, String email, String phone, String pass, String reppass){
        inputUserName.sendKeys(login);
        inputEmail.sendKeys(email);
        inputPhone.setValue(phone);
        inputPassword.setValue(pass);
        inputPasswordValidation.setValue(reppass);
        button.click();
        errText2.shouldHave(text("Ваши пароли не совпадают"));
        return new UnSuccessRegPage();
    }
}
