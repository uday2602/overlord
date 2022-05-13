package com.uday.overlord;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Environment {
    public Map<String, String> getTags() {
        return ImmutableMap.<String, String>builder()
                .put("env", "prod")
                .put("host", "host_a")
                .put("service", "service_a")
                .build();
    }
}
