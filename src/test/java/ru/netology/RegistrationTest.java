package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationTest {


    @Test

    void shouldRegisterByAccountNumber () {
        Selenide.open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Абакан");
        LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").click();
        $("[data-test-id=name] input").setValue("Иванов Иван");
    //    $("[data-test-id='city']input").("Абакан").click();
        $("[data-test-id=phone] input").setValue("+79600000000");
        $("[data-test-id=agreement]").click();
        $$("button").find(Condition.text("Забронировать")).click();
        $(Selectors.withText("Успешно!"))
                .should(Condition.visible, Duration.ofSeconds(15));





    }
}
