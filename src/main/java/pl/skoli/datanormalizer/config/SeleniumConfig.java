package pl.skoli.datanormalizer.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @Value("${driver.location}")
    private String location;

    @Bean
    public ChromeDriver driver() {
        System.setProperty("webdriver.chrome.driver", location);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--incognito");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
