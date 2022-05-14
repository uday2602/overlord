package com.ujalan.overlord.internal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import javax.inject.Inject;

import com.ujalan.overlord.contracts.Environment;

import org.json.JSONArray;
import org.json.JSONObject;

import static java.util.UUID.randomUUID;

public class FlusherImpl implements Flusher {

  public static final String METRIC_NAME_KEY = "metric_name";
  public static final String VALUE_KEY = "value";

  private final String dirName;

  @Inject
  private Aggregator aggregator;

  @Inject
  private Environment env;

  @Inject
  public FlusherImpl(Aggregator aggregator, Environment env) {
    this.aggregator = aggregator;
    this.env = env;
    this.dirName = "/tmp/" + env.getTags().get("service") + "/logs/";

  }

  @Override
  public synchronized void flush() {
    try {
      BufferedWriter buffer = new BufferedWriter(
          new FileWriter(this.dirName + randomUUID() + ".log", false));
      buffer.append(rawLogs(aggregator.getAndClear()));
      buffer.flush();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private CharSequence rawLogs(Collection<Value> values) {
    return new JSONArray(values.stream().map(entry -> {
      JSONObject obj = new JSONObject();
      entry.tags().forEach(obj::put);
      obj.put(METRIC_NAME_KEY, entry.metricName());
      obj.put(VALUE_KEY, entry.counter().get());
      return obj;
    }).toArray()).toString();
  }
}
