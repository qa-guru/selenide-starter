package github;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideOnGitHub() {
        // открыть страничку гитхаб
        open("https://github.com");
        // ввести в поле поиска selenide
        // нажать enter
        $("[name=q]").setValue("selenide").pressEnter();
        // выбрать первый найденый проект из списка (кликнуть)
        var firstRepositoryFound = $$("ul.repo-list li").first().$("a");
        firstRepositoryFound.click();
        // проверка: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
    }

}
