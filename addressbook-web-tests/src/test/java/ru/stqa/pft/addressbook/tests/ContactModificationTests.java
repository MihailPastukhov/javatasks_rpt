package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Administrator on 10/18/2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToGroupPage();
            if (!app.getGroupHelper().isThereAGroup()){
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
            app.getNavigationHelper().goToHomePage();
            app.getContactHelper().createContact(new ContactData("test1", "test1", "test1, 123", "123-123-123", "test1@test1.com", "none"));
        }

        app.getContactHelper().initEditingSelectedContact();
        app.getContactHelper().fillContactData(new ContactData("testFirstName1", "testLastName1", "testAddress, 123 1", "123-123-123-1", "test1@test11.com", null), false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();

    }
}
