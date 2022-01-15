package Test;

import Data.DataHelper;
import Page.LoginPage;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
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
