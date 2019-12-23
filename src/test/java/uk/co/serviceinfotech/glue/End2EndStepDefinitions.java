package uk.co.serviceinfotech.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

public class End2EndStepDefinitions {

    private final static Logger LOGGER = Logger.getLogger(End2EndStepDefinitions.class.getName());

    @Given("I have {word} id")
    public void iHaveId(String type) {
    }

    @Given("I have task description as {word}")
    public void setupTaskDescription(String taskDescription) {

    }

    @Given("I have data for the scenario")
    public void setupScenarioData() {

    }

    @Given("I have the status as {word}")
    public void assertStatus(String status) {
    }


    @When("I {word} scenario data")
    public void action(String action) {
    }

    @Then("I should see {string} as {word}")
    public void assertFields(String field, String value) {
    }


}
