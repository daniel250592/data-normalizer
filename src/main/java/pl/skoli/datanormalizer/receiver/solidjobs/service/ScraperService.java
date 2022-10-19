package pl.skoli.datanormalizer.receiver.solidjobs.service;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScraperService {

    //    private static final String URL = "https://solid.jobs/offers/it;experiences=Junior;categories=Programista;subcategories=Java";
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


    public void scrape() {



        List<String> infoList = new ArrayList<>();
        List<String> moneyList = new ArrayList<>();
        List<String> linksList = new ArrayList<>();
        driver.get(URL);

        List<WebElement> start = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));

        for (WebElement offer : start) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }

        List<WebElement> offers1 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));
        to(offers1.size(), infoList, moneyList, linksList);

        List<WebElement> offers2 = offers1.subList(offers1.size() - 6, offers1.size() - 1);


        for (WebElement offer : offers2) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }

        List<WebElement> offers3 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));
        to(offers3.size(), infoList, moneyList, linksList);
        List<WebElement> offers32 = offers3.subList(offers1.size() - 6, offers3.size() - 1);

        for (WebElement offer : offers32) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }

        List<WebElement> offers4 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));


        List<WebElement> offers5 = offers4.subList(offers4.size() - 6, offers4.size() - 1);


        for (WebElement offer : offers5) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }

        List<WebElement> offers6 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));


        List<WebElement> offers7 = offers6.subList(offers6.size() - 6, offers6.size() - 1);


        for (WebElement offer : offers7) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", offer);

        }


        List<WebElement> offers8 = driver.findElements(By.xpath("//div[@class ='d-flex flex-column flex-md-row align-items-start align-items-md-center flex-fill ml-0 ml-sm-3']"));


        System.out.println();
        driver.quit();

    }

    public void to(int range, List<String> infoList, List<String> moneyList, List<String> linkList) {

        try {
            for (int i = 1; i < range; i++) {
                String listPosition = String.valueOf(i);

                String infoS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[2]/div[1]", listPosition);
                String moneyS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[2]/div[2]", listPosition);
                String linkS = String.format("/html/body/app-root/main/div/div/div[1]/app-offer-list/div/div[1]/div/virtual-scroller/div[2]/div[1]/offer-list-item[%s]/div/div/div[3]/div[1]/a", listPosition);

                String offerInfo = driver.findElement(By.xpath(infoS)).getText();
                String offerMoney = driver.findElement(By.xpath(moneyS)).getText();
                String offerLink = driver.findElement(By.xpath(linkS)).getAttribute("href");

                infoList.add(offerInfo);
                moneyList.add(offerMoney);
                linkList.add(offerLink);
            }

        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println();
        }
    }
}


