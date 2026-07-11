package ui.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ui.base.BaseTest;
import ui.tables.StaticTablePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticTableTest extends BaseTest {

    StaticTablePage staticTablePage;

    @BeforeEach
    public void setUp() {
        staticTablePage = new StaticTablePage(getDriver());
        staticTablePage.open();
    }

    @Test
    public void checkStaticTableHeaders() {
        assertEquals(5,staticTablePage.getHeaderTexts().size());
        System.out.println(staticTablePage.getHeaderTexts());
    }

    @Test
    public void checkTableRowsCount() {
        int tableRowsCount = staticTablePage.getTableRows().size();
        assertEquals(3, tableRowsCount);
    }

    @Test
    public void checkRowsData() {
       int rowsDataCount = staticTablePage.getTableRowsData().size();
        assertEquals(3, rowsDataCount);
    }
}