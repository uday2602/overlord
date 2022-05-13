package com.uday.overlord;

import java.util.Map;

import com.google.inject.ImplementedBy;

@ImplementedBy(OverlordImpl.class)
public interface Overlord {
  void increment(String metricName, Map<String, String> tag);
}
