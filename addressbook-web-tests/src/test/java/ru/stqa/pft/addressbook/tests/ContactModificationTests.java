package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Administrator on 10/18/2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initEditingSelectedContact();
        app.getContactHelper().fillContactData(new ContactData("testFirstName1", "testLastName1", "testAddress, 123 1", "123-123-123-1", "test1@test11.com"));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();

    }
}
