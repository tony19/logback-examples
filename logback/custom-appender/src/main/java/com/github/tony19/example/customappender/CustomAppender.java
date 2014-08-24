package com.github.tony19.example.customappender;

import ch.qos.logback.core.AppenderBase;

/**
 * Sample appender that takes {#link Config} object
 *
 * @param <E> logging event type
 */
public class CustomAppender<E> extends AppenderBase<E> {
  private Config config;

  @Override
  protected void append(E arg0) {
    System.out.println("in append(). config.capacity=" + this.config.getCapacity());
  }

  public void setConfig(Config config) {
    this.config = config;
  }

  public Config getConfig() {
    return this.config;
  }
}
