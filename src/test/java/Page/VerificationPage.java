package Page;

import Data.DataHelper;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
        public DashboardPage ValidCode(DataHelper.VerificationCode verificationCode) {
            $("[data-test-id=code] input").shouldBe(Condition.visible).setValue(verificationCode.getCode());
            $("[data-test-id=action-verify]").click();
            return new DashboardPage();
        }
}
