package ui.tests;

import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.tables.StaticTablePage;

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
        assertEquals(5, staticTablePage.getHeaderTexts().size());
        System.out.println(staticTablePage.getHeaderTexts());
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