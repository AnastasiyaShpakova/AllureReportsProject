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
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaWithStepTest {

    private static final String REPOSITORY = "AnastasiyaShpakova/project1_team24";
    private static final String ISSUE = "Issue for test with Allure";

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @DisplayName("Поиск Issue в репозитории с использованием Lambda")
    @Owner("AnastasiyaShpakova")
    @Severity(SeverityLevel.CRITICAL)
    public void lambdaStepTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });

        step("Найти через поиск репозиторий " + REPOSITORY, () -> {
                    $(".search-input").click();
                    $("#query-builder-test").setValue(REPOSITORY).submit();
        });

        step("Кликнуть по ссылке репозитория " + REPOSITORY, () -> {
                    $(linkText(REPOSITORY)).click();
        });

        step("Открыть вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверить наличие Issue " + ISSUE, () -> {
            $(linkText(ISSUE)).should(Condition.exist);
        });
    }

    }