package com.uday.overlord.internal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;

import com.uday.overlord.internal.Value;

public class FlusherImpl implements Flusher {

  private BufferedWriter buffer;
  @Inject private Aggregator aggregator;
  
  private static final String FILE_NAME = "aggregator.log";
  
  public FlusherImpl() {
    try {
      this.buffer = new BufferedWriter(new FileWriter(FILE_NAME, true));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
  @Override
  public synchronized void flush() {
    StringBuilder mapAsString = new StringBuilder();
    aggregator.getAndClear().forEach(entry -> {
      mapAsString.append(rawLogs(entry)).append("\n");
    });
    try {
      buffer.append(mapAsString.toString());
      buffer.flush();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private CharSequence rawLogs(Value entry) {
    StringBuilder mapAsString = new StringBuilder();
    entry.tags().entrySet().forEach(e -> {
      mapAsString.append(e.getKey()).append("=").append(e.getValue()).append(";");
    });
    mapAsString.append("metric_name").append("=").append(entry.metricName()).append(";");
    mapAsString.append("value").append("=").append(entry.counter().get()).append(";");
    return mapAsString.toString();
  }
}
