package pl.skoli.datanormalizer.receiver.solidjobs.service;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScraperService {

    private static final String URL = "https://solid.jobs/offers/it;experiences=Junior;categories=Programista;subcategories=Java";

    private final ChromeDriver driver;

    public void scrape() {
        driver.get(URL);

        List<WebElement> offers = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));

        driver.quit();

    }
}
