package com.skm.regressionsuite.context;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<String, Object> applicationData = new HashMap<>();

    public void setContext(String key, Object value) {
        applicationData.put(key, value);
    }

    public Object getContext(String key) {
        return applicationData.get(key);
    }

    public <T> T getContext(String key, Class<T> type) {
        return type.cast(applicationData.get(key));
    }

    public Boolean isContains(String key) {
        return applicationData.containsKey(key);
    }
}
