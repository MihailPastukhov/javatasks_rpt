package ru.stqa.pft.addressbook.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Administrator on 10/18/2016.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupData(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void groupCreation() {
        click(By.name("new"));
    }

    public void selectGroup(){
        click(By.name("selected[]"));
    }

    public void deleteSelectedGroup(){
        click(By.name("delete"));
    }

    public void initModificationGroup() {
        click(By.name("edit"));
    }

    public void updateGroupData() {
        click(By.name("update"));
    }

    public void createGroup(GroupData groupData) {
        groupCreation();
        fillGroupData(new GroupData("test1", null, null));
        submitGroupCreation();
        returnToGroupPage();

    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}
