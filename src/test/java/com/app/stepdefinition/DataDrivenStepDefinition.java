package com.app.stepdefinition;

import com.app.model.Employee;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

public class DataDrivenStepDefinition implements En {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public DataDrivenStepDefinition() {

        Given("some pre-requisite information", () -> {

            LOGGER.info("Execute given");

        });
        When("^I pass param \"([^\"]*)\" and \"([^\"]*)\"$", (String param1, String param2) -> {

            LOGGER.info("Param 1:".concat(param1));
            LOGGER.info("Param 2:".concat(param2));
        });
        Then("^display both of these$", () -> {

            //ToDo--
        });
        When("^we pass \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$", (String username, String password, String num) -> {

            LOGGER.info(username + ":" + password + ":" + num);
        });
        When("^user enters username and password$", (DataTable datatable) -> {

            List<List<String>> data = datatable.asLists();
            System.out.println(data.get(0).get(0));
            System.out.println(data.get(0).get(1));
        });
        Then("^we will pass a set of data$", (DataTable datatable) -> {
            List<Map<String, String>> listOfDataMap = datatable.asMaps(String.class, String.class);

            listOfDataMap
                    .forEach(x -> {
                        x.entrySet()
                                .forEach(y -> {
                                    System.out.println(y.getKey().concat(":").concat(y.getValue()));
                                });
                    });
        });
    }
}
