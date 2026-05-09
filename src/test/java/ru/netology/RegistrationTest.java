package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationTest {


    @Test

    void shouldRegisterByAccountNumber () {
        Selenide.open("http://localhost:9999");
    //    $$(".tab-item").find(Condition.text("По номеру счёта")).click();
    //    $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=city] input").sendKeys("Абакан");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=name] input").sendKeys("Иванов Иван");
    //    $("[data-test-id='city']input").("Абакан").click();
        $("[name='phone']").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $$("button").find(Condition.text("Забронировать")).click();
        $(Selectors.withText("Успешно!"))
                .should(Condition.visible, Duration.ofSeconds(15));




    }
}
