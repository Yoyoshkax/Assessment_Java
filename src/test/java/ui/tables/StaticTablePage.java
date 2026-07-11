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
    private static final By STATIC_TABLE_ROWS_XPATH = By.xpath("//section[@id='tables']/div[2]/div[2]/table[@id='usersTable']/tbody[1]/tr");
    private static final By STATIC_TABLE_SINGLE_ROW_XPATH = By.xpath("//section[@id='tables']/div[2]/div[2]/table[@id='usersTable']/tbody[1]/tr");



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

    public List<WebElement> getTableRows() {
        List<WebElement> rowsElements = driver.findElements(STATIC_TABLE_ROWS_XPATH);
        return rowsElements;
    }

    public List<String> getTableRowsData() {
        List<WebElement> rows = getTableRows();
        List<String> rowsTextData = new ArrayList<>();

        for(WebElement row: rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));
            List<String> rowData = new ArrayList<>();
            for(WebElement cell : cells) {
                rowData.add(cell.getText());
            }

        rowsTextData.add(String.valueOf(rowData));
        }
        return rowsTextData;
    }
}
