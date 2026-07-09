package ui.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StaticTablePage {

    private WebDriver driver;
    private static final String URL = "https://aqa-proka4.org/sandbox/web";
    private static final By STATIC_TABLE_HEADER_XPATH = By.xpath("//section[@id='tables']/div[2]/div[2]/table[@id='usersTable']/thead[1]/tr[1]/th");


    public StaticTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public StaticTablePage open() {
        driver.get(URL);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(STATIC_TABLE_HEADER_XPATH));
        return this;
    }

    public List<String> getHeaderTexts() {
        List<WebElement> headerElements = driver.findElements(STATIC_TABLE_HEADER_XPATH);
        List<String> headerTexts = new ArrayList<>();
        for (WebElement header: headerElements ) {
            headerTexts.add(header.getText());
        };
        return headerTexts;
    }
}
