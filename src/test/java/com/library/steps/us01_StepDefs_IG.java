package com.library.steps;

import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class us01_StepDefs_IG {

    String actualUserCount;
List <String> actualColumnNames;




LoginPage loginPage = new LoginPage();

    @When("Execute query to get all IDs from users IG")
    public void execute_query_to_get_all_i_ds_from_users_ig() {
    String query = "SELECT COUNT(id) from users;";
        DB_Util.runQuery (query);
    actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }
    @Then("verify all users has unique ID IG")
    public void verify_all_users_has_unique_id_ig() {
        String query = "SELECT COUNT(DISTINCT id) from users";
        DB_Util.runQuery (query);
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);
        Assert.assertEquals(actualUserCount, expectedUserCount);
    }



    @When("Execute query to get all columns IG")
    public void execute_query_to_get_all_columns_ig() {
String query = "SELECT * from users";
DB_Util.runQuery(query);





    }


    @Then("verify the below columns are listed in result IG")
    public void verify_the_below_columns_are_listed_in_result_ig(List <String> expectedColumnNames) {
actualColumnNames = DB_Util.getAllColumnNamesAsList();

        System.out.println("actualColumnNames = " + actualColumnNames);
        System.out.println("expectedColumnNames = " + expectedColumnNames);

        Assert.assertEquals(actualColumnNames, expectedColumnNames);

    }



}
