package com.skm.regressionsuite.context;

import java.util.HashMap;
import java.util.Map;

public class FeatureContext {

    private Map<String, Object> featureData = new HashMap<>();

    public void setContext(String key, Object value) {
        featureData.put(key, value);
    }

    public Object getContext(String key) {
        return featureData.get(key);
    }

    public <T> T getContext(String key, Class<T> type) {
        return type.cast(featureData.get(key));
    }

    public Boolean isContains(String key) {
        return featureData.containsKey(key);
    }
}
