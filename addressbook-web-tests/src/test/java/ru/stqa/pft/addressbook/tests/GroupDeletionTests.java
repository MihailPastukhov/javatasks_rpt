package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 10/18/2016.
 */
public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();

    }
}

