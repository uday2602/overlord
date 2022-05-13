package com.uday.overlord;

import com.google.inject.ImplementedBy;

@ImplementedBy(FlusherImpl.class)
public interface Flusher {
  void flush();
}
