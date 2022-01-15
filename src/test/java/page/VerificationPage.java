package page;

import data.DataHelper;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
        public DashboardPage ValidCode(DataHelper.VerificationCode verifyCode) {
            $("[data-test-id=code] input").shouldBe(Condition.visible).setValue(verifyCode.getCode());
            $("[data-test-id=action-verify]").click();
            return new DashboardPage();
        }
}
