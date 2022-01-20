package page;

import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public VerificationPage validLogin(DataHelper.AuthInfo authInfo) {
        $("[data-test-id=login] input").setValue(DataHelper.getAuthInfo().getLogin());
        $("[data-test-id=password] input").setValue(DataHelper.getAuthInfo().getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
