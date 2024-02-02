import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsWithMethods {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти через поиск репозиторий {REPOSITORY}")
    public void findRepoDueSearchField(String REPOSITORY) {
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();
    }

    @Step("Кликнуть по ссылке репозитория {REPOSITORY}")
    public void clickLinkOfRepository(String REPOSITORY) {
        $(linkText(REPOSITORY)).click();
    }

    @Step("Открыть вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue {ISSUE}")
    public void checkExistingOfIssue(String ISSUE) {
        $(linkText(ISSUE)).should(Condition.exist);
    }

    }