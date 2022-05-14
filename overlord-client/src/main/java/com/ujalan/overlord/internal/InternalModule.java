package com.ujalan.overlord.internal;

import com.google.inject.AbstractModule;
import com.ujalan.overlord.contracts.Overlord;

public class InternalModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Flusher.class).to(FlusherImpl.class);
    bind(Aggregator.class).to(AggregatorImpl.class);
    bind(Overlord.class).to(OverlordImpl.class);
  }
}
