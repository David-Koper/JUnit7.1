package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.text;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

    public class MoviesPage {
        SelenideElement topMenu = $(".style-scope ytd-searchbox"),
                topMenuComplete = $("#search"),
                searchPageMovie = $(".style-scope ytd-video-renderer"),
                searchPageGenre = $(".styles_linkDark__7m929 styles_link__3QfAk");

       public MoviesPage openPage() {
           Selenide.open("https://www.youtube.com/");
           return this;
     }

        public MoviesPage topMenuClick() {
            topMenu.click();
            return this;
        }

        public MoviesPage topMenuSearch(String value) {
            topMenu.setValue(value);
            topMenu.pressEnter();
            return this;
        }

        public MoviesPage titleMovieResult(String value) {
           searchPageMovie.shouldHave(text(value)).shouldBe(visible);
            return this;
        }


        public MoviesPage genreListResult(String value) {

            searchPageGenre.shouldHave(text(value)).shouldBe(visible);
            return this;
        }
    }
