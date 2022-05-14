package com.ujalan.overlord.internal;

import com.google.inject.ImplementedBy;

@ImplementedBy(FlusherImpl.class)
public interface Flusher {
  void flush();
}
