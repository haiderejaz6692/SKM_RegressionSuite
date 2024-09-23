package com.skm.regressionsuite.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioData = new HashMap<>();

    public void setContext(String key, Object value) {
        scenarioData.put(key, value);
    }

    public Object getContext(String key) {
        return scenarioData.get(key);
    }

    public <T> T getContext(String key, Class<T> type) {
        return type.cast(scenarioData.get(key));
    }

    public Boolean isContains(String key) {
        return scenarioData.containsKey(key);
    }
}
