package ru.stqa.pft.addressbook.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/18/2016.
 */
public class ContactHelper extends HelperBase {

    public boolean isThereAContact(){
        return isElementPresent(By.name("selected[]"));
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactData(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void contactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void initEditingSelectedContact() {
        //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
        click(By.cssSelector("img[alt=Edit]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contactData) {
        contactCreation();
        fillContactData(contactData, true);
        submitContactCreation();
        returnToHomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[@name='entry']"));
        for (int i=1 ; i < elements.size()+1 ; i++){
            String lastName = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[@name='entry']["+i+"]/td[2]")).getText();
            String firstName = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[@name='entry']["+i+"]/td[3]")).getText();
            ContactData contact = new ContactData(firstName, lastName, null, null, null, null);
            contacts.add(contact);
        }

        return contacts;
    }
}
