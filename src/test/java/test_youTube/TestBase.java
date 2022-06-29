package test_youTube;

import pages.MoviesPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


    public class TestBase {
        MoviesPage moviesPage = new MoviesPage();

        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://www.youtube.com/";
            Configuration.browserSize = "1920x1080";
            // Configuration.holdBrowserOpen = true;
        }
    }

