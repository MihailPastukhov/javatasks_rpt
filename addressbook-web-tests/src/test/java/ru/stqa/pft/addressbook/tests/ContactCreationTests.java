package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        contactCreation();
        fillContactData(new ContactData("testFirstName", "testLastName", "testAddress, 123", "123-123-123", "test1@test1.com"));
        submitContactCreation();
        returnToHomePage();
    }

}
