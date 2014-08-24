package com.github.tony19.example.customappender;

/**
 * Sample configuration that takes an integer capacity setting
 */
public class Config {
  private int capacity;

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getCapacity() {
    return this.capacity;
  }
}
