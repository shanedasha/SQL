package test;

import data.DataHelper;
import org.junit.jupiter.api.AfterAll;
import page.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    @AfterAll
    static void shouldDeleteBase() {
        DataHelper.deleteDataBase();
    }

      @Test
        void shouldVerifyInfo() {
           open("http://localhost:9999/");
          var LoginPage = new LoginPage();
          var authInfo = DataHelper.getAuthInfo();
          var verificationPage =LoginPage.validLogin(authInfo);
          var verifyInfo = DataHelper.getVerificationCode();
          var dashboardPage = verificationPage.validCode(verifyInfo);
        }
}
