package com.uday.overlord.internal;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.auto.value.AutoValue;
import com.google.inject.ImplementedBy;

@ImplementedBy(AggregatorImpl.class)
public interface Aggregator {
  void aggregate(String metricName, Map<String, String> tags);

  Collection<Value> getAndClear();
}

@AutoValue
abstract class Key {
  static Key create(String metricName, Map<String, String> tags) {
    return new AutoValue_Key(metricName, hash(tags));
  }

  private static String hash(Map<String, String> tags) {
    Map<String, String> map = new TreeMap<>(tags);
    StringBuilder mapAsString = new StringBuilder();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      mapAsString.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
    }
    return mapAsString.toString();
  }

  abstract String metricName();

  abstract String tagsHash();
}

@AutoValue
abstract class Value {
  static Value create(String metricName, Map<String, String> tags, AtomicInteger counter) {
    return new AutoValue_Value(metricName, tags, counter);
  }

  abstract String metricName();

  abstract Map<String, String> tags();

  abstract AtomicInteger counter();
}
