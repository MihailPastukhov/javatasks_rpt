package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.applicationmanager.ApplicationManager;

/**
 * Created by Administrator on 10/18/2016.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init(BrowserType.CHROME);

    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
