package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class SberbankTests extends TestBase {
    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Check sberbank mortgage terms")
    void generatedTest() {
        step("Открыть 'http://www.sberbank.ru/'", () -> {
            open ("http://www.ozon.ru/");
        });

        step("Проверка второго урованя для ипотека", () -> {
            $ (byText ("Ипотека")).click ();
            $(".kitt-top-menu")
                    .shouldHave(text("Все ипотечные кредиты"))
                    .shouldHave(text("Ипотека на вторичное жильё"))
                    .shouldHave(text("Ипотека на новостройки"))
                    .shouldHave(text("Ипотека по двум документам"))
                    .shouldHave(text("Ипотека с господдержкой"));
        });

        step("Открытие страницы Все ипотечные кредиты", () -> {
            $ (byText ("Все ипотечные кредиты")).click ();
        });

        step("Проверка открытия страницы с ипотечными продуктами", () -> {
            $(".bp-container")
                    .shouldHave(text("Вторичное жильё"))
                    .shouldHave(text("Новостройки"))
                    .shouldHave(text("Семейная ипотека"))
                    .shouldHave(text("Ипотека с господдержкой"));
        });

        step("Открытие страницы с условиями ипотечного кредитования на вторичное жилье", () -> {
            $("#main-page").$(byText ("Вторичное жильё")).click ();
            $("#main-page").$ (byText ("Условия и требования")).scrollTo ();
            $("#main-page").$ (byText ("Условия и требования")).click ();
            $(".tabs-container")
                    .shouldHave(text("Рубли РФ"))
                    .shouldHave(text("Не должна превышать меньшую из величин:"))
                    .shouldHave(text("до 30 лет"))
                    .shouldHave(text("Обязательное страхование передаваемого в залог имущества (за исключением земельного участка) от рисков утраты/гибели, повреждения в пользу Банка на весь срок действия кредитного договора."));

        });

    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'http://www.sberbank.ru/'", () ->
                open("http://www.sberbank.ru/"));

        step("", () -> {
            String expectedTitle = "";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'http://www.sberbank.ru/'", () ->
                open("http://www.sberbank.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}