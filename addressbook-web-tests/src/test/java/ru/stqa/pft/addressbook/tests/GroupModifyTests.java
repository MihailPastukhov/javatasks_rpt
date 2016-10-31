package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Administrator on 10/18/2016.
 */
public class GroupModifyTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("tes1", null, null));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initModificationGroup();
        app.getGroupHelper().fillGroupData(new GroupData("test4", "test5", "test6"));
        app.getGroupHelper().updateGroupData();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);

    }
}
