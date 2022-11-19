package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class LocalizationServiceImplTests {

    @MethodSource("methodSource")
    @ParameterizedTest
    public void localeTest(Country country, String expected){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(country);
        Assertions.assertEquals(expected,actual);
    }

    public static Stream<Arguments> methodSource(){
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome"));
    }
}
