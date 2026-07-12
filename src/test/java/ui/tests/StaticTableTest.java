package ui.tests;

import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.tablePage.StaticTablePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaticTableTest extends BaseTest {

    StaticTablePage staticTablePage;

    @BeforeEach
    public void setUp() {
        staticTablePage = new StaticTablePage(getDriver());
        staticTablePage.open();
    }

    @Test
    public void checkStaticTableHeaders() {
        assertEquals(5, staticTablePage.getHeaderTexts().size());
        List<String> expectedHeaderTexts = staticTablePage.getExpectedHeadersTexts();
        List<String> actualHeaderTexts = staticTablePage.getHeaderTexts();
        for (String headerText : actualHeaderTexts) {
            assertTrue(expectedHeaderTexts.contains(headerText));
        }
    }

    @Test
    public void checkTableRowsCount() {
        int tableRowsCount = staticTablePage.getTableRows().size();
        assertEquals(3, tableRowsCount);
    }

    @Test
    public void checkRowsData() {
        System.out.println(staticTablePage.getTableRowsData());
        int rowsDataCount = staticTablePage.getTableRowsData().size();
        assertEquals(3, rowsDataCount);
    }

    @Test
    public void checkSingleRowData() {
        int rowsCount = staticTablePage.getTableRows().size();
        String singleRowData = staticTablePage.getSingleTableRowData(DataGenerator.getRandomNumberForTableRows(rowsCount));
        System.out.println(singleRowData);
    }
}