package com.uday.overlord;

import com.google.inject.AbstractModule;
import com.uday.overlord.internal.InternalModule;

public class OverlordModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new InternalModule());
  }
}
