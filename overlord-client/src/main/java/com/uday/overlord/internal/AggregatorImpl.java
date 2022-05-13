package com.uday.overlord.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.Monitor;
import com.google.inject.Singleton;

@Singleton
public class AggregatorImpl implements Aggregator {

  private final Map<Key, Value> counters;
  private final Monitor monitor = new Monitor();
  private State state;
  private final Monitor.Guard logging = monitor.newGuard(() -> state == State.LOGGING);
  private final Monitor.Guard flushing = monitor.newGuard(() -> state == State.FLUSHING);
  public AggregatorImpl() {
    this.counters = new ConcurrentHashMap<>();
    this.state = State.LOGGING;
  }

  @Override
  public void aggregate(String metricName, Map<String, String> tags) {
    monitor.enterWhenUninterruptibly(logging);
    try {
      Key key = Key.create(metricName, tags);
      Value value = counters.getOrDefault(key,
          Value.create(metricName, tags, new AtomicInteger(0)));
      value.counter().addAndGet(1);
      counters.put(key, value);
    } finally {
      monitor.leave();
    }
  }

  @Override
  public synchronized Collection<Value> getAndClear() {
    state = State.FLUSHING;
    monitor.enterWhenUninterruptibly(flushing);
    try {
      HashMap<Key, Value> copyMap = new HashMap<>(counters);
      counters.clear();
      state = State.LOGGING;
      return copyMap.values();
    } finally {
      monitor.leave();
    }
  }

  enum State {
    LOGGING,
    FLUSHING
  }
}
