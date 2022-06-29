package test_youTube;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;




public class ParamsTest extends TestBase {

    //@Disabled()
    @DisplayName("Проверка, что 5 > 3")
    @Test
   void simpleTest() {
        Assertions.assertTrue(5 > 3);
    }

    //@Disabled()
    @ValueSource(strings = {"The Prodigy - Firestarter", "The Prodigy - We Live Forever", "The Prodigy - Omen", "The Prodigy - Baby's Got A Temper"})
    @ParameterizedTest(name = "YouTube, при поискe песни {0} в результатах есть поле The Prodigy")
    void valueTest(String testData) {
        moviesPage.openPage()
                .topMenuClick()
                .topMenuSearch(testData)
                .titleMovieResult("The Prodigy");
    }

    //@CsvFileSource(resources = "test_data/films.csv")
    @CsvSource(value = {
    "Nothing Else Matters, Metallica",
    "Baby's Got A Temper , The Prodigy",
    "Smells Like Teen Spirit, Nirvana",
    "Wind Of Change, Scorpions"
    })

  @Disabled("CsvTest disabled")
    @ParameterizedTest(name = "YouTube, при поиске песни {0} в результатах есть  поле исполнитель {1}")
    void csvTest(String searchData, String expectedResult) {
        moviesPage.openPage()
                .topMenuClick()
                .topMenuSearch(searchData)
                .titleMovieResult(expectedResult);
    }

    static Stream<Arguments> complexDataProvider() {
        return Stream.of(
               Arguments.of("Nothing Else Matters", Arguments.arguments("Metallica", "Official Music Video")),
                Arguments.of("Smells Like Teen Spirit", Arguments.arguments("Nirvana", "Official Music Video"))
       );
    }


    @MethodSource(value = "complexDataProvider")
   // @Disabled("MethodTest disabled")
    @ParameterizedTest(name = "YouTube, при поискe песни {0} в результатах есть поле исполнитель The Prodigy")
    void methodTest(String searchData) {
        moviesPage.openPage()
                .topMenuClick()
                .topMenuSearch(searchData)
                .titleMovieResult(searchData);
    }

   @EnumSource(Movies.class)
    // @Disabled("EnumTest disabled")
    @ParameterizedTest()
   void enumTest(Movies movies) {
        moviesPage.openPage()
               .topMenuClick()
              .topMenuSearch(movies.desc)
             .titleMovieResult(movies.desc);

    }
}