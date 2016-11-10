package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Administrator on 10/18/2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToGroupPage();
            if (!app.getGroupHelper().isThereAGroup()){
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
            app.getNavigationHelper().goToHomePage();
            app.getContactHelper().createContact(new ContactData("test1", "test1", "test1, 123", "123-123-123", "test1@test1.com", "[none]"));
            app.getContactHelper().returnToHomePage();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);

    }
}
