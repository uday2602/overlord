package com.uday.overlord.contracts;

import java.util.Map;

import com.google.inject.ImplementedBy;
import com.uday.overlord.internal.OverlordImpl;

@ImplementedBy(OverlordImpl.class)
public interface Overlord {
  void increment(String metricName, Map<String, String> tag);
}
