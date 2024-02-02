import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class UsingListenerTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @DisplayName("Поиск Issue в репозитории с Listener")
    @Owner("AnastasiyaShpakova")
    @Severity(SeverityLevel.CRITICAL)
    public void searchIssueTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("AnastasiyaShpakova / project1_team24").submit();
        $(linkText("AnastasiyaShpakova/project1_team24")).click();
        $("#issues-tab").click();
        $(linkText("Issue for test with Allure")).should(Condition.exist);
    }

    }