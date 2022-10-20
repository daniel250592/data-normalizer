package pl.skoli.datanormalizer.receiver.solidjobs.service;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import pl.skoli.datanormalizer.receiver.solidjobs.dto.SolidJobOuterDto;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScraperService {

    private static final String URL = "https://solid.jobs/offers/it;categories=Programista;subcategories=Java";

    private final ChromeDriver driver;

    @PostConstruct
    public void getData() {
        scrape();
    }

    public void scrollByList(List<WebElement> elements) {
        for (WebElement offer : elements) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }
    }

    public List<WebElement> createSubList(List<WebElement> elements) {
        return elements.subList(elements.size() - 6, elements.size() - 1);
    }

    public List<WebElement> repeat(List<WebElement> start, List<SolidJobOuterDto> solidJobOuterDtos, int howMany, int counter) {

        List<WebElement> toReturn = new ArrayList<>();

        if (counter < howMany) {
            counter++;
            scrollByList(start);

            List<WebElement> offers1 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));
            to(offers1.size(), solidJobOuterDtos);
            toReturn = createSubList(offers1);
            repeat(toReturn, solidJobOuterDtos, howMany, counter);

        }
        return toReturn;
    }


    public void scrape() {


        List<SolidJobOuterDto> solidJobOuterDtos = new ArrayList<>();

        driver.get(URL);


        fetchData(solidJobOuterDtos);


        System.out.println();
        driver.quit();

    }

    private void fetchData(List<SolidJobOuterDto> solidJobOuterDtos) {
        try {
            List<WebElement> start = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));
            repeat(start, solidJobOuterDtos, 30, 0);

        } catch (StaleElementReferenceException e) {
            driver.get(URL);
            fetchData(solidJobOuterDtos);
        }
    }

    public void to(int range, List<SolidJobOuterDto> solidJobOuterDtos) {

        try {
            for (int i = 1; i < range; i++) {
                String listPosition = String.valueOf(i);

                String infoS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[2]/div[1]", listPosition);
                String moneyS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[2]/div[2]", listPosition);
                String linkS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[3]/div[1]/a", listPosition);

                String offerInfo = driver.findElement(By.xpath(infoS)).getText();
                String offerMoney = driver.findElement(By.xpath(moneyS)).getText();
                String offerLink = driver.findElement(By.xpath(linkS)).getAttribute("href");

                solidJobOuterDtos.add(new SolidJobOuterDto(offerInfo, offerMoney, offerLink));
            }

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println();
        }
    }
}


