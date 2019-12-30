package uk.co.serviceinfotech.dao;

import uk.co.serviceinfotech.models.ScenarioData;

public interface IScenarioDao {
    void save(ScenarioData scenarioData);
    void update(ScenarioData scenarioData);
    ScenarioData get(String taskDescription);
}
