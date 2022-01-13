package Test;

import Data.DataHelper;
import Page.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
      @Test
        void shouldVerifyInfo() {
            open("http://localhost:9999/");
            var loginPage = new LoginPage();


        }
}
