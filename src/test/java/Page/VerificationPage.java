package Page;

import Data.DataHelper;
import Page.DashboardPage;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
        public DashboardPage ValidCode(DataHelper.User.getCode) {
            $("[data-test-id=code] input").shouldBe(Condition.visible).setValue(DataHelper.User.getCode);
            $("[data-test-id=action-verify]").click();
            return new DashboardPage();
        }
}
