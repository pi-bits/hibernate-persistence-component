package uk.co.serviceinfotech.glue;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.co.serviceinfotech.dao.IScenarioDao;
import uk.co.serviceinfotech.dao.ScenarioDao;
import uk.co.serviceinfotech.models.ScenarioData;

import java.util.Random;
import java.util.logging.Logger;

import static java.lang.String.format;

public class End2EndStepDefinitions {
    private final static Logger LOGGER = Logger.getLogger(End2EndStepDefinitions.class.getName());
    private DriverSetup driverSetup;

    public End2EndStepDefinitions(DriverSetup driverSetup) {
        this.driverSetup = driverSetup;
        LOGGER.info(() -> driverSetup.getDriverName());
    }


    private ScenarioData scenarioData;
    private IScenarioDao scenarioDao;


    @BeforeStep
    public void beforeStep(Scenario scenario) {


    }


    @AfterStep
    public void afterStep(Scenario scenario) {
    }


    @Before
    public void setUpData(Scenario scenario) {

        scenarioData = new ScenarioData();
        scenarioDao = new ScenarioDao();

    }

    @Given("I have {word} id")
    public void caseType(String caseType) {
        if (caseType.equalsIgnoreCase("New")) {
            scenarioData.setCaseId(format("%010d", new Random().nextInt(9000)));
        } else {
            scenarioData.setCaseId("01234567890");
        }
    }

    @Given("I have task description as {word}")
    public void setupTaskDescription(String taskDescription) {
        scenarioData.setTaskDescription(taskDescription);
    }

    @Given("I have data for the scenario")
    public void setupScenarioData() {

    }

    @Given("I have the status as {word}")
    public void assertStatus(String status) {
    }


    @When("I {word} scenario data")
    public void action(String action) {
        if (action.equalsIgnoreCase("save")) {
            scenarioDao.save(scenarioData);
        } else if (action.equalsIgnoreCase("update")) {
            scenarioDao.update(scenarioData);
        } else if (action.equalsIgnoreCase("get")) {
            this.scenarioData = scenarioDao.get(scenarioData.getTaskDescription());
        }
    }

    @Then("I should see {string} as {word}")
    public void assertFields(String field, String value) {
    }


}
