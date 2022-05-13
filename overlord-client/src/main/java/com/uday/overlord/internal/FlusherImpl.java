package com.uday.overlord.internal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;

import static java.util.UUID.randomUUID;

public class FlusherImpl implements Flusher {

  private static final String DIR_NAME = "logs/";
  @Inject
  private Aggregator aggregator;

  @Override
  public synchronized void flush() {
    try {
      BufferedWriter buffer = new BufferedWriter(
          new FileWriter(DIR_NAME + randomUUID() + ".log", false));
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
      entry.tags().entrySet().forEach(e -> {
        obj.put(e.getKey(), e.getValue());
      });
      obj.put("metric_name", entry.metricName());
      obj.put("value", entry.counter().get());
      return obj;
    }).toArray()).toString();
  }
}
