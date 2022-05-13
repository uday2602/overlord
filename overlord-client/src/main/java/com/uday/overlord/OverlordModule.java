package com.uday.overlord;

import com.google.inject.AbstractModule;
import com.uday.overlord.contracts.Overlord;
import com.uday.overlord.internal.InternalModule;
import com.uday.overlord.internal.OverlordImpl;

public class OverlordModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new InternalModule());
  }
}
