package Page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public DashboardPage() {
        $("[data-test-id=dashboard]").shouldBe(Condition.visible);
    }
}
