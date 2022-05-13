package com.uday.overlord;

import com.google.inject.AbstractModule;

public class Module  extends AbstractModule {
  @Override
  protected void configure() {
    bind(Overlord.class).to(OverlordImpl.class);
    bind(Flusher.class).to(FlusherImpl.class);
    bind(Aggregator.class).to(AggregatorImpl.class);
  }
}
