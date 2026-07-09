package ui.tests;

import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.tables.StaticTablePage;

public class StaticTableTest extends BaseTest {

    @Test
    public void checkStaticTableHeaders() {
        StaticTablePage staticTablePage = new StaticTablePage(getDriver()).open();
        System.out.println(staticTablePage.getHeaderTexts());
    }
}
