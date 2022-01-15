package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import page.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    @BeforeEach
    @Test
    void shouldDeleteBase() {
        DataHelper.getDeleteDataBase();
    }

      @Test
        void shouldVerifyInfo() {
           open("http://localhost:9999/");
          var LoginPage = new LoginPage();
          var authInfo = DataHelper.getAuthInfo();
          var verificationPage =LoginPage.ValidLogin(authInfo);
          var verifyInfo = DataHelper.getVerificationCode();
          var dashboardPage = verificationPage.ValidCode(verifyInfo);
        }
}
