package Page;

import Data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

        public VerificationPage ValidLogin(DataHelper.User user) {
            $("[data-test-id=login] input").setValue (DataHelper.User.getLogin);
            $("[data-test-id=password] input").setValue(DataHelper.User.getPassword);
            $("[data-test-id=action-login]").click();
            return new VerificationPage();
        }
}
