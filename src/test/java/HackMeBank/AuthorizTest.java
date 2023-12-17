package HackMeBank;

import com.codeborne.selenide.Selenide;
import core.BaseTest;
import helper.TestValues;
import org.junit.jupiter.api.Test;

public class AuthorizTest extends BaseTest {
    private static final String BASE_URL = "http://tl.af-ctf.ru/#inputForAuth";


    @Test
    public void PozitiveAutoriz(){
        SuccessRegPage authorizationPage = new AuthorizationPage(BASE_URL)
                .LogIn(TestValues.FIO, TestValues.EMAIL,
                        TestValues.PHONE, TestValues.PASSWORD, TestValues.REPEAT_PASS);
    }
    @Test
    public void NegativeUserName(){
        UnSuccessRegPage authorizationPage = new AuthorizationPage(BASE_URL)
                .InvalidUserName(TestValues.DEMO_FIO, TestValues.EMAIL,
                TestValues.PHONE, TestValues.PASSWORD, TestValues.REPEAT_PASS);

    }
    @Test
    public void NegPassword(){
        UnSuccessRegPage unSuccessRegPage = new AuthorizationPage(BASE_URL)
                .InvalidPass(TestValues.FIO, TestValues.EMAIL, TestValues.PHONE,
                        TestValues.DEMO_PASS, TestValues.DEMO_REPEAT_PASS);
    }


}
