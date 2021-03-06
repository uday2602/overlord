package com.ujalan.overlord.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.ujalan.overlord.contracts.Environment;
import com.ujalan.overlord.contracts.Overlord;

@Singleton
public class OverlordImpl implements Overlord {
  @Inject
  private Environment env;
  @Inject
  private Aggregator aggregator;

  @Inject
  public OverlordImpl(Environment env, Aggregator aggregator, Flusher flusher) {
    this.env = env;
    this.aggregator = aggregator;
    setupFlusher(flusher);
  }

  private void setupFlusher(Flusher flusher) {
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    exec.scheduleAtFixedRate(flusher::flush, 0, 10, TimeUnit.SECONDS);
  }

  @Override
  public void increment(String metricName, Map<String, String> userTags) {
    Map<String, String> tags = new HashMap<>();
    tags.putAll(userTags);
    tags.put("service", env.getService());
    tags.put("host", env.getHost());
    tags.put("env", env.getEnvironment());
    aggregator.aggregate(metricName, tags);
  }
}
