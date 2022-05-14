package com.ujalan.overlord;

import com.google.inject.AbstractModule;
import com.ujalan.overlord.internal.InternalModule;

public class OverlordModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new InternalModule());
  }
}
