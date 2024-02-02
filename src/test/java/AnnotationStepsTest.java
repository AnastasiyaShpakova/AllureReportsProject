import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {
    private static final String REPOSITORY = "AnastasiyaShpakova/project1_team24";
    private static final String ISSUE = "Issue for test with Allure";

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsWithMethods steps = new StepsWithMethods();

        steps.openMainPage();
        steps.findRepoDueSearchField(REPOSITORY);
        steps.clickLinkOfRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkExistingOfIssue(ISSUE);
    }

    }