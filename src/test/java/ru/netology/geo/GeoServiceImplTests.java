package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class GeoServiceImplTests {

    GeoService geoService = new GeoServiceImpl();

    @MethodSource("methodSource")
    @ParameterizedTest
    public void byIpTest(String ip, Location expected){
        Location actual = geoService.byIp(ip);
        Assertions.assertEquals(expected,actual);
    }

    public static Stream <Arguments> methodSource(){
        return Stream.of(
                Arguments.of("127.0.0.1",new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11",new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149",new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.",new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.",new Location("New York", Country.USA, null,  0)),
                Arguments.of("",null));
    }

    @Test
    public void byCoordinatesTests() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, () -> geoService.byCoordinates(3.14,3.14));
    }
}
