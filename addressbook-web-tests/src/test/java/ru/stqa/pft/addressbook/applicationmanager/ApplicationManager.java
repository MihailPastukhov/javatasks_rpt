package ru.stqa.pft.addressbook.applicationmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 10/18/2016.
 */
public class ApplicationManager {

    WebDriver wd;

    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init(String browser) {
        this.browser = browser;
        //String browser = BrowserType.FIREFOX;
        if (browser == BrowserType.FIREFOX){
            wd = new FirefoxDriver();
        }
        else if(browser == BrowserType.CHROME){
            wd = new ChromeDriver();
        }
        else if(browser == BrowserType.IE){
            wd = new InternetExplorerDriver();
        }



        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("http://localhost/addressbook/");
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);

        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
